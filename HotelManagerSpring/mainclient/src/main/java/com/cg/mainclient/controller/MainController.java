package com.cg.mainclient.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.mainclient.entities.BookingDetails;
import com.cg.mainclient.entities.Hotel;
import com.cg.mainclient.entities.ResponseClient;
import com.cg.mainclient.entities.RoomDetails;
import com.cg.mainclient.exception.BookingException;
import com.cg.mainclient.exception.HotelNotFoundException;
import com.cg.mainclient.exception.RoomNotFoundException;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;


@RefreshScope
@RestController
public class MainController{
	
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;
    
    private Logger mainClientLogger = null;
    
    
    
    public MainController() {
		setupLogger();
	}

	//API Info
    @RequestMapping("/actuator/info")
    public String apiInfo(){
    	return "This is main client application";
    }
    
    //HOTEL MICROSERVICE ACCESS..
    //find hotel
    @RequestMapping("hotel/1/{id}")
    public Hotel findme(@PathVariable String id) {
        Application application = eurekaClient.getApplication("hotel-service");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "/selecthotel/" + id;
        System.out.println("URL" + url);
        Hotel hotel = restTemplate.getForObject(url, Hotel.class);
        if(hotel == null){
        	mainClientLogger.error("Hotel Not Found Exception Thrown");
        	throw new HotelNotFoundException("Hotel with Id: "+id+" could not be found.");
        }
        mainClientLogger.info("hotel fetched with id: "+hotel.getHotelId());
        return hotel;
    }
    
    //insert new hotel
    @PostMapping(value="hotel/2", consumes=MediaType.APPLICATION_JSON_VALUE)
    public String insertHotel(@RequestBody Hotel hotel)
    {
        Application app=eurekaClient.getApplication("hotel-service");
        InstanceInfo instanceInfo=app.getInstances().get(0);
        String url="http://"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort()+"/insert/hotel";
        ResponseClient bd= restTemplate.postForObject(url,hotel,ResponseClient.class);
        String res = bd.getResponse();
        mainClientLogger.info("hotel inserted with Id: "+hotel.getHotelId());
        return res; 
    }
    
    
    //ROOM MICROSERVICE ACCESS.. 
    //find room
    @GetMapping("/room/1/{id}")
    public RoomDetails findRoom(@PathVariable String id){
    	 Application application = eurekaClient.getApplication("room-service");
         InstanceInfo instanceInfo = application.getInstances().get(0);
         String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "/select/" + id;
         System.out.println("URL" + url);
         RoomDetails roomDetails = restTemplate.getForObject(url, RoomDetails.class);
         if(roomDetails == null){
        	 mainClientLogger.error("Room not found exception thrown");
        	 throw new RoomNotFoundException("There is no room Available with Room Id: "+id);
         }
         mainClientLogger.info("Room fetched with id: "+roomDetails.getRoom_id());
         return roomDetails;
    }
    
    //insert new room
    @PostMapping(value="/room/2",consumes=MediaType.APPLICATION_JSON_VALUE)
    public RoomDetails insertRoom(@RequestBody RoomDetails roomDetails){
    	 Application application = eurekaClient.getApplication("room-service");
         InstanceInfo instanceInfo = application.getInstances().get(0);
         String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "/insert";
         System.out.println("URL" + url);
         RoomDetails room = restTemplate.postForObject(url,roomDetails, RoomDetails.class);
         mainClientLogger.info("room inserted with Id: "+room.getRoom_id());
         return room;
    }  
    
    
    //BOOKING MICROSERVICE ACCESS
    //fetch booking
    @GetMapping(value="/booking/1/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public BookingDetails findBooking(@PathVariable String id){
    	 Application application = eurekaClient.getApplication("booking-service");
         InstanceInfo instanceInfo = application.getInstances().get(0);
         String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "/selectbooking/" + id;
         System.out.println("URL" + url);
         BookingDetails bookingDetails = restTemplate.getForObject(url, BookingDetails.class);
         if(bookingDetails == null){
        	 throw new BookingException("No booking details could be found");
         }
         System.out.println(bookingDetails);
         bookingDetails.setstartDate();
         bookingDetails.setendDate();
         mainClientLogger.info("booking details fetched with Id: "+id);
         return bookingDetails;
    } 
    
    
    //book new Room
    @RequestMapping(value="/booking/2", consumes=MediaType.APPLICATION_JSON_VALUE)
    public String bookRoom(@RequestBody BookingDetails bookingDetails){
    	Application application = eurekaClient.getApplication("room-service");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "/setavailability/"+bookingDetails.getRoomId();
        System.out.println("URL" + url);
        ResponseClient bd= restTemplate.getForObject(url, ResponseClient.class);;
        if(bd.getResponse().equals("success")){
        	application = eurekaClient.getApplication("booking-service");
            instanceInfo = application.getInstances().get(0);
            url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "/bookroom";
            System.out.println("URL" + url);
            bd = restTemplate.postForObject(url, bookingDetails, ResponseClient.class);
            mainClientLogger.info("room booked with Id: "+bookingDetails.getBookingId());
            return bd.getResponse();
        }
        mainClientLogger.error("failed to book room.");
        return "failed to book room";
    }
    
    private void setupLogger() {
		mainClientLogger = Logger.getLogger(MainController.class);
			PropertyConfigurator.configure("log4j.properties");
			mainClientLogger.debug("This is a debug message.");
			mainClientLogger.warn("This is a warn message.");
			mainClientLogger.fatal("This is a fatal message.");
	}
}
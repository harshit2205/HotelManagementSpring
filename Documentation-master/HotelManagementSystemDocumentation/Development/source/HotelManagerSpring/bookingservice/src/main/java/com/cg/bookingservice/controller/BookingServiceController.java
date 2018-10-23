package com.cg.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookingservice.entities.BookingDetails;
import com.cg.bookingservice.entities.ResponseClient;
import com.cg.bookingservice.service.BookingService;


@RestController
public class BookingServiceController {
     
	
	 @Autowired
	 BookingService bookingService;
	 
	//api information..
		@RequestMapping("/actuator/info")
		public String ServiceInfo(){
			return "this is Booking Service";
		}
	 
		
	 //fetch Booking details by their booking id functionality..
	 @GetMapping(value="/selectbooking/{id}")
	 public BookingDetails getBookingDetails(@PathVariable("id") String id )
	 {
		 BookingDetails details = bookingService.findById(id).get();
		 details.setBooked_from_String(details.getStartDate());
		 details.setBooked_to_String(details.getEndDate());
		 System.out.println(details.showBooking());
		 return details;
	 }
	 
	//book room and generate booking details functionality..
	 @PostMapping(value="/bookroom",consumes=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseClient bookRoom(@RequestBody BookingDetails bookingdetails){
		 bookingService.save(bookingdetails);
		 ResponseClient client = new ResponseClient("Room booked with room_id: "+bookingdetails.getRoomId());
		 System.out.println("new room booked");
		 return client;
	 }
	 
	 
}

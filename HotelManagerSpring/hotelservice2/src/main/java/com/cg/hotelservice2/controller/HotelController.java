package com.cg.hotelservice2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hotelservice2.entities.Hotel;
import com.cg.hotelservice2.entities.ResponseClient;
import com.cg.hotelservice2.service.HotelService;

@RestController
public class HotelController {

	@Autowired
	HotelService hotelSer;
	
	//api information..
	@RequestMapping("/actuator/info")
	public String ServiceInfo(){
		return "this is Hotel Service";
	}
	
	//insert new hotel functionality..
	@PostMapping(value="/insert/hotel", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseClient insertNewRoom(@RequestBody Hotel hotel){
		hotelSer.save(hotel);
		ResponseClient res = new ResponseClient();
		res.setResponse("successfull hotel_id: ");
		return res;
	}
	
	//fetch hotel by thier hotel id functionality..
	@GetMapping(value="/selecthotel/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel fetchRoomDetails(@PathVariable("id") String hotelId){
		if(!hotelSer.existsById(hotelId)){
			return null;
		}
		return hotelSer.findById(hotelId).get();
	}
}

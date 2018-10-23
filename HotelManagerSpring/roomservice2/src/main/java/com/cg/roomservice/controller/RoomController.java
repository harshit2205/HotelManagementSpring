package com.cg.roomservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.roomservice.entities.ResponseClient;
import com.cg.roomservice.entities.RoomDetails;
import com.cg.roomservice.service.RoomService;


@RestController
public class RoomController {
	
	@Autowired
	RoomService roomSer;
	
	//api information..
	@RequestMapping("/actuator/info")
	public String ServiceInfo(){
		return "this is Room Service";
	}
	
	//insert new room functionality..
	@PostMapping(value="/insert", consumes=MediaType.APPLICATION_JSON_VALUE)
	public RoomDetails insertNewRoom(@RequestBody RoomDetails roomdet){
		roomSer.save(roomdet);
		return roomdet;
	}

	//fetch room by thier room id functionality..
	@GetMapping(value="/select/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public RoomDetails fetchRoomDetails(@PathVariable("id") String roomId){
		if(!roomSer.existsById(roomId)){
			return null;
		}
		return roomSer.findById(roomId).get();
	}
	
	
	//change the availability of a room with a particular room id..
	@GetMapping(value="/setavailability/{id}")
	public ResponseClient modifyRoomDetails(@PathVariable("id") String roomId){
		ResponseClient client = new ResponseClient();
		if(!roomSer.existsById(roomId)){
			client.setResponse("failed");
			return client;
		}else{
			RoomDetails room = roomSer.findById(roomId).get();
			if(room.isAvailability() == RoomDetails.NOT_AVAILABLE){
				client.setResponse("booked");
				return client;
			}else{
				room.setAvailability(RoomDetails.AVAILABLE);
				roomSer.save(room);
				client.setResponse("success");
				return client;
			}
		}
		
		
	}
}

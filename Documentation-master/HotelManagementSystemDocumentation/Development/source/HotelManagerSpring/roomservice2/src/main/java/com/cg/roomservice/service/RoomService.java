package com.cg.roomservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.roomservice.entities.RoomDetails;

public interface RoomService extends JpaRepository<RoomDetails, String>{

}

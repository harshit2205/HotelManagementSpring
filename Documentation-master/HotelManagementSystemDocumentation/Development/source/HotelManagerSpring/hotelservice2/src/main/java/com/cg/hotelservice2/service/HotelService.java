package com.cg.hotelservice2.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hotelservice2.entities.Hotel;

public interface HotelService extends JpaRepository<Hotel, String>{

}

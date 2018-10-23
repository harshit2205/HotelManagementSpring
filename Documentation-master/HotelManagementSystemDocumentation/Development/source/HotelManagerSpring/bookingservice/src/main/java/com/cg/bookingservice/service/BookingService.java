package com.cg.bookingservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookingservice.entities.BookingDetails;

public interface BookingService extends JpaRepository<BookingDetails, String> {

}

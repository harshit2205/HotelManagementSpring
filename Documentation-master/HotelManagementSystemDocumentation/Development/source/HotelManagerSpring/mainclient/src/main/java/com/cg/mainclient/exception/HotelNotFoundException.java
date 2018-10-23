package com.cg.mainclient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HotelNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	String message;
	 
    public HotelNotFoundException(String message) {
        super(message);
        this.message=message;
    }
}

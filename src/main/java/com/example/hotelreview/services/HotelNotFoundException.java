package com.example.hotelreview.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class HotelNotFoundException extends ResponseStatusException {


    public HotelNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Hotel Not Found");
    }

}


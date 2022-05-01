package com.example.hotelreview.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ReviewNotFoundException extends ResponseStatusException {


    public ReviewNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Hotel Not Found");
    }

}


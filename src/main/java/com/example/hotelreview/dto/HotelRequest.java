package com.example.hotelreview.dto;

import javax.validation.constraints.NotBlank;

public class HotelRequest {

    @NotBlank
    private final String name;
    @NotBlank
    private final String location;

    public HotelRequest(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}

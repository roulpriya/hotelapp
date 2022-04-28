package com.example.hotelreview.dto;

public class HotelResponse {

    private final Long id;
    private  final String name;
    private final String location;

    public HotelResponse(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}

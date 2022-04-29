package com.example.hotelreview.dto;

import com.example.hotelreview.models.Hotel;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.validation.constraints.NotBlank;


@JacksonXmlRootElement(localName = "hotel")
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

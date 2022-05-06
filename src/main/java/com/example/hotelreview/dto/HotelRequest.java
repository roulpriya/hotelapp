package com.example.hotelreview.dto;

import com.example.hotelreview.models.Hotel;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.validation.constraints.NotBlank;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRequest that = (HotelRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }


}

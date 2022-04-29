package com.example.hotelreview.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@JacksonXmlRootElement(localName = "review")
public class ReviewRequest {

    @Min(1)
    @Max(5)
    private final int rating;

    @NotBlank
    private final String content;


    public ReviewRequest(int rating, String content) {
        this.rating = rating;
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }
}

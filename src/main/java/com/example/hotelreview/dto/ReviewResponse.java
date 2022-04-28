package com.example.hotelreview.dto;

public class ReviewResponse {
    
    private final Long id;
    private final int rating;
    private final String content;

    public ReviewResponse(Long id,int rating, String content) {
        this.id = id;
        this.rating = rating;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }
}

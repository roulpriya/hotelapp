package com.example.hotelreview.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int rating;
    @Column
    private String content;

    @ManyToOne
    private Hotel hotel;

    public Review(int rating, String content, Hotel hotel) {
        this.rating = rating;
        this.content = content;
        this.hotel = hotel;
    }

    protected Review(){

    }

    public Long getId() {
        return id;
    }

    public int getRating() { return rating; }

    public String getContent() {
        return content;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}

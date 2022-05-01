package com.example.hotelreview.controllers;

import com.example.hotelreview.dto.PaginatedResponse;
import com.example.hotelreview.dto.ReviewRequest;
import com.example.hotelreview.dto.ReviewResponse;
import com.example.hotelreview.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ReviewController {

    private final HotelService hotelService;

    @Autowired
    public ReviewController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @GetMapping("/hotels/{hotelId}/reviews")
    public PaginatedResponse<ReviewResponse> reviews(@PathVariable Long hotelId,
                                                     @RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "10") int size){
        return new PaginatedResponse<>(hotelService.getHotelReviewsById(hotelId, page, size));
    }

    @PostMapping("/hotels/{hotelId}/reviews")
    public ResponseEntity<ReviewResponse> createReview(@PathVariable Long hotelId, @RequestBody @Valid ReviewRequest request){
        return ResponseEntity.ok(hotelService.createReview(hotelId, request));

    }



}


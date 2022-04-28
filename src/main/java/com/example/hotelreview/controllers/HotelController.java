package com.example.hotelreview.controllers;

import com.example.hotelreview.dto.HotelRequest;
import com.example.hotelreview.dto.HotelResponse;
import com.example.hotelreview.dto.PaginatedResponse;
import com.example.hotelreview.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> getById(@PathVariable Long id){
        return ResponseEntity.of(hotelService.getHotelById(id));
    }

    @PostMapping("")
    public ResponseEntity<HotelResponse> create(@RequestBody @Valid HotelRequest request){
        return ResponseEntity.ok(hotelService.create(request));

    }

    @GetMapping("")
    public PaginatedResponse<HotelResponse> list(@RequestParam(value = "page", defaultValue = "0") int page,
                                                 @RequestParam(value = "size", defaultValue = "10") int size){
        return new PaginatedResponse<>(hotelService.getAll(page, size));
    }

}


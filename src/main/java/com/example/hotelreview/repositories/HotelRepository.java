package com.example.hotelreview.repositories;

import com.example.hotelreview.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelRepository extends JpaRepository<Hotel, Long> {


}

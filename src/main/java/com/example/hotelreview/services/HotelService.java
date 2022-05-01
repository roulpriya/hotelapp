package com.example.hotelreview.services;

import com.example.hotelreview.dto.HotelRequest;
import com.example.hotelreview.dto.HotelResponse;
import com.example.hotelreview.dto.ReviewRequest;
import com.example.hotelreview.dto.ReviewResponse;
import com.example.hotelreview.models.Hotel;
import com.example.hotelreview.models.Review;
import com.example.hotelreview.repositories.HotelRepository;
import com.example.hotelreview.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository, ReviewRepository reviewRepository) {
        this.hotelRepository = hotelRepository;
        this.reviewRepository = reviewRepository;
    }


    public Optional<HotelResponse> getHotelById(Long id) {
        return hotelRepository.findById(id)
                .map(hotel -> new HotelResponse(hotel.getId(), hotel.getName(), hotel.getLocation()));


//        if(byId.isPresent()){
//            Hotel hotel = byId.get();
//            HotelResponse hotelResponse = new HotelResponse(hotel.getId(), hotel.getName(), hotel.getLocation());
//            return Optional.of(hotelResponse);
//        }
//        else
//            return Optional.empty();

    }

    public HotelResponse create(HotelRequest request) {
        Hotel hotel = new Hotel(request.getName(), request.getLocation());
        hotelRepository.save(hotel);
        return new HotelResponse(hotel.getId(), hotel.getName(), hotel.getLocation());
    }

    public Page<HotelResponse> getAll(int page, int size) {
        return hotelRepository.findAll(PageRequest.of(page, size))
                .map(hotel -> new HotelResponse(hotel.getId(), hotel.getName(), hotel.getLocation()));
    }

    public Page<ReviewResponse> getHotelReviewsById(Long hotelId, int page, int size) {
        var hotel = hotelRepository.findById(hotelId).orElseThrow(HotelNotFoundException::new);
        return reviewRepository.findAllByHotel(hotel, PageRequest.of(page, size))
                .map(review -> new ReviewResponse(review.getId(),
                        review.getRating(),
                        review.getContent()));

    }

    public ReviewResponse createReview(Long hotelId, ReviewRequest request) {
        var hotel = hotelRepository.findById(hotelId).orElseThrow(HotelNotFoundException::new);
        Review review = new Review(request.getRating(), request.getContent(), hotel);
        reviewRepository.save(review);

        return new ReviewResponse(review.getId(), review.getRating(), review.getContent());
    }

    public HotelResponse update(Long hotelId, HotelRequest request) {
        var hotel = hotelRepository.findById(hotelId).orElseThrow(ReviewNotFoundException::new);
        hotel = new Hotel(request.getName(), request.getLocation());
        hotelRepository.save(hotel);
        return new HotelResponse(hotel.getId(), hotel.getName(), hotel.getLocation());


    }

    public void delete(Long hotelId) {
        var hotel = hotelRepository.findById(hotelId).orElseThrow(HotelNotFoundException::new);
        hotelRepository.delete(hotel);
    }

}

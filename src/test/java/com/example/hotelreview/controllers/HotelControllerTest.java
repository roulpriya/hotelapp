package com.example.hotelreview.controllers;

import com.example.hotelreview.dto.HotelResponse;
import com.example.hotelreview.services.HotelService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HotelController.class)
class HotelControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelService hotelService;

    @Test
    void getById() throws Exception {
        when(hotelService.getHotelById(1L)).thenReturn(Optional.of(new HotelResponse(1L,"demo","XYZ")));
        when(hotelService.getHotelById(100L)).thenReturn(Optional.empty());

        this.mockMvc.perform(get("/hotels/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("demo")))
                .andExpect(jsonPath("$.location", Matchers.equalTo("XYZ")));

        this.mockMvc.perform(get("/hotels/100")).andExpect(status().isNotFound());


    }

    @Test
    void create() throws Exception {
        when(hotelService.getHotelById(1L)).thenReturn(Optional.of(new HotelResponse(1L,"demo","XYZ")));
        when(hotelService.getHotelById(100L)).thenReturn(Optional.empty());

        this.mockMvc.perform(get("/hotels")).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("demo")))
                .andExpect(jsonPath("$.location", Matchers.equalTo("XYZ")));

        this.mockMvc.perform(get("/hotels/100")).andExpect(status().isNotFound());
    }

    @Test
    void list() throws Exception {
        when(hotelService.getHotelById(1L)).thenReturn(Optional.of(new HotelResponse(1L,"demo","XYZ")));
        when(hotelService.getHotelById(100L)).thenReturn(Optional.empty());

        this.mockMvc.perform(get("/hotels/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("demo")))
                .andExpect(jsonPath("$.location", Matchers.equalTo("XYZ")));

        this.mockMvc.perform(get("/hotels/100")).andExpect(status().isNotFound());
    }

    @Test
    void update() throws Exception {
        when(hotelService.getHotelById(1L)).thenReturn(Optional.of(new HotelResponse(1L,"demo","XYZ")));
        when(hotelService.getHotelById(100L)).thenReturn(Optional.empty());

        this.mockMvc.perform(get("/hotels/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("demo")))
                .andExpect(jsonPath("$.location", Matchers.equalTo("XYZ")));

        this.mockMvc.perform(get("/hotels/100")).andExpect(status().isNotFound());
    }
}
package com.example.hotelreview.controllers;

import com.example.hotelreview.dto.HotelRequest;
import com.example.hotelreview.dto.HotelResponse;
import com.example.hotelreview.services.HotelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HotelController.class)
class HotelControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private HotelService hotelService;

    @Test
    void getById() throws Exception {
        when(hotelService.getHotelById(1L)).thenReturn(Optional.of(new HotelResponse(1L, "demo", "XYZ")));
        when(hotelService.getHotelById(100L)).thenReturn(Optional.empty());

        this.mockMvc.perform(get("/hotels/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("demo")))
                .andExpect(jsonPath("$.location", Matchers.equalTo("XYZ")));

        this.mockMvc.perform(get("/hotels/100")).andExpect(status().isNotFound());


    }

    @Test
    void testCreate() throws Exception {
        HotelRequest request = new HotelRequest("test", "test");
        when(hotelService.create(request))
                .thenReturn(new HotelResponse(1L, "test", "test"));
        this.mockMvc.perform(post("/hotels").contentType(MediaType.APPLICATION_JSON).content(asJsonString(request))).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("test")))
                .andExpect(jsonPath("$.location", Matchers.equalTo("test")));
    }

    private String asJsonString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    @Test
    void testUpdate() throws Exception {
        HotelRequest request = new HotelRequest("test", "test");
        when(hotelService.update(1L, request)).thenReturn(new HotelResponse(1L,"test", "test"));
        this.mockMvc.perform(put("/hotels/1").contentType(MediaType.APPLICATION_JSON).content(asJsonString(request))).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("test")))
                .andExpect(jsonPath("$.location", Matchers.equalTo("test")));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(hotelService).delete(1L);
        this.mockMvc.perform(delete("/hotels/1"))
                .andExpect(status().isOk());

    }

}
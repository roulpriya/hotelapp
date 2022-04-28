package com.example.hotelreview.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class PaginatedResponse<T> {


    private final int pageCount;
    private final long elementCount;
    private final List<T> data;

    public PaginatedResponse(Page<T> page) {
        this.pageCount = page.getTotalPages();
        this.elementCount = page.getTotalElements();
        this.data = page.getContent();
    }

    public int getPageCount() {
        return pageCount;
    }

    public long getElementCount() {
        return elementCount;
    }

    public List<T> getData() {
        return data;
    }
}

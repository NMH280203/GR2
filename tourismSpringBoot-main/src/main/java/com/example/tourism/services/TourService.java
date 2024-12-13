package com.example.tourism.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    public List<String> getPopularDestinations() {
        return List.of("Okavango Delta", "Serengeti", "Great Barrier Reef");
    }
}

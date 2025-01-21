package com.example.tourism.services;

import com.example.tourism.models.City;
import com.example.tourism.models.Tour;
import com.example.tourism.repositories.CityRepository;
import com.example.tourism.repositories.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {

    private final TourRepository tourRepository;
    private final CityRepository cityRepository;

    public TourService(TourRepository tourRepository, CityRepository cityRepository) {
        this.tourRepository = tourRepository;
        this.cityRepository = cityRepository;
    }

    // Lấy danh sách tất cả tour
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    // Lấy danh sách tour theo cityId
    public List<Tour> getToursByCityId(Long cityId) {
        if (cityId == null) {
            return tourRepository.findAll(); // Không lọc
        }
        return tourRepository.findByCityId(cityId);
    }

    // Lấy danh sách tất cả thành phố
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}


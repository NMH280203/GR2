package com.example.tourism.controllers;

import com.example.tourism.models.City;
import com.example.tourism.models.Tour;
import com.example.tourism.repositories.TourRepository;
import com.example.tourism.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    // Hiển thị danh sách tour với khả năng lọc theo thành phố
    @GetMapping("/tours")
    public String showTours(
            @RequestParam(value = "cityId", required = false) Long cityId, // Tham số lọc theo thành phố
            Model model
    ) {
        // Lấy danh sách tour theo cityId (hoặc tất cả nếu cityId không được cung cấp)
        List<Tour> tours = tourService.getToursByCityId(cityId);

        // Lấy danh sách thành phố để hiển thị trong dropdown
        List<City> cities = tourService.getAllCities();

        // Thêm dữ liệu vào model
        model.addAttribute("tours", tours); // Danh sách tour
        model.addAttribute("cities", cities); // Danh sách thành phố
        model.addAttribute("selectedCityId", cityId); // Giữ trạng thái lựa chọn thành phố

        return "tours"; // Tên file HTML trong thư mục templates (tours.html)
    }
}



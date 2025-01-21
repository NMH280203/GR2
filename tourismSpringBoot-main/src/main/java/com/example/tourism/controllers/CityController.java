package com.example.tourism.controllers;

import com.example.tourism.models.City;
import com.example.tourism.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/")
public class CityController {

    private static final String UPLOAD_DIR = "tourismSpringBoot-main/src/main/resources/static/assets/images/";
    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public String index(Model model) {
        List<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities);
        return "index";
    }

    @GetMapping("/offers")
    public String showOffersPage(Model model) {
        List<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities);
        return "offers";
    }
    @GetMapping("/post")
    public String showPostForm(Model model) {
        model.addAttribute("city", new City());
        return "post";
    }
    @PostMapping("/post")
    public String saveCity(@ModelAttribute City city, MultipartFile imageFile, Model model) {
        try {
            // Kiểm tra thư mục lưu ảnh
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Lưu file ảnh với tên gốc
            String fileName = imageFile.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR + fileName);
            Files.write(filePath, imageFile.getBytes());

            // Lưu tên file ảnh vào entity
            city.setImageUrl(fileName);

            // Lưu city vào database
            cityRepository.save(city);
            model.addAttribute("successMessage", "City has been posted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Failed to post the city. Please try again.");
        }
        model.addAttribute("city", new City());

        return "redirect:/post";
    }


}

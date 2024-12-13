package com.example.tourism.controllers;

import com.example.tourism.models.City;
import com.example.tourism.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CityController {

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

}

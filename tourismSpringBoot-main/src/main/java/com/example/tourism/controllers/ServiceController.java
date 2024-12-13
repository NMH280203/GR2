package com.example.tourism.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/services")
public class ServiceController {

    // Show the services page
    @GetMapping
    public String showServicesPage(Model model) {
        return "services";
    }

    @PostMapping("/calculate")
    @ResponseBody
    public String calculateExpenses(
            @RequestParam("travelers") int travelers,
            @RequestParam("luggage") int luggage,
            @RequestParam("serviceTier") String serviceTier,
            @RequestParam("days") int days) {

        System.out.println("Calculating expenses for: travelers=" + travelers + ", luggage=" + luggage + ", serviceTier=" + serviceTier + ", days=" + days);

        int baseCostPerDay;

        switch (serviceTier.toLowerCase()) {
            case "basic":
                baseCostPerDay = 50;
                break;
            case "comfort":
                baseCostPerDay = 100;
                break;
            case "luxury":
                baseCostPerDay = 200;
                break;
            default:
                return "Invalid service tier provided";
        }

        int luggageCost = luggage * 10;
        int costPerTraveler = (baseCostPerDay + luggageCost) * days;
        int totalCost = costPerTraveler * travelers;

        return "Estimated Total Cost: $" + totalCost;
    }
}

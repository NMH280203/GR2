package com.example.tourism.controllers;

import com.example.tourism.models.Review;
import com.example.tourism.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    // Hiển thị danh sách bình luận
    @GetMapping("/reviews")
    public String showReviews(Model model) {
        model.addAttribute("reviews", reviewRepository.findAll());
        return "reviews"; // Trả về file reviews.html
    }

    // Xử lý thêm bình luận mới
    @PostMapping("/reviews")
    public String addReview(
            @RequestParam(required = false, defaultValue = "Anonymous") String userName,
            @RequestParam(required = false, defaultValue = "No review provided") String reviewText,
            @RequestParam int rating,
            Model model) {
        Review newReview = new Review();
        newReview.setUserName(userName);
        newReview.setReviewText(reviewText);
        newReview.setRating(rating);
        reviewRepository.save(newReview);
        return "redirect:/reviews";
    }
}

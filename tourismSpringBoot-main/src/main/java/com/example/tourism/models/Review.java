package com.example.tourism.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // ID của review

    @NotNull
    private String userName;
    // Tên người dùng viết review
    @Column(nullable = true)
    private String reviewText;// Nội dung review
    private int rating; // Đánh giá (rating từ 1-5 hoặc theo quy định)

    // Constructor mặc định
    public Review() {
    }

    // Constructor đầy đủ
    public Review(Long id, String userName, String reviewText, int rating) {
        this.id = id;
        this.userName = userName;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    // Getter và Setter cho id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter và Setter cho userName
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter và Setter cho reviewText
    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    // Getter và Setter cho rating
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

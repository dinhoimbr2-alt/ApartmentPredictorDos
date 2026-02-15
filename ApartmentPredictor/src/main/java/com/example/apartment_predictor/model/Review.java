package com.example.apartment_predictor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Review {

    @Id
    private String id;

    private String title;
    private String content;
    private int rating;
    private LocalDate reviewDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "apartment_fk")
    private Apartment apartment;

    @ManyToOne
    @JoinColumn(name = "reviewer_fk")
    private Reviewer reviewer;

    public Review() {
        this.id = UUID.randomUUID().toString();
    }

    public Review(String title, String content, int rating) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.rating = rating;
    }

    public Review(String title, String content, int rating, LocalDate reviewDate) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.reviewDate = reviewDate;
    }

    // GETTERS & SETTERS

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}

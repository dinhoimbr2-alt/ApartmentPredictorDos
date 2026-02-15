package com.example.apartment_predictor.repository;

import com.example.apartment_predictor.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends JpaRepository<Review, String> {
}

package com.example.apartment_predictor.repository;

import com.example.apartment_predictor.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, String> {
}

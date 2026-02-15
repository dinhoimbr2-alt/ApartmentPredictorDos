package com.example.apartment_predictor.repository;

import com.example.apartment_predictor.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, String> {
}

package com.example.apartment_predictor.repository;

import com.example.apartment_predictor.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends JpaRepository<School, String> {
}

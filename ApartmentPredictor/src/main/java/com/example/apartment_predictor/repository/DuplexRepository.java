package com.example.apartment_predictor.repository;

import com.example.apartment_predictor.model.Duplex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuplexRepository extends JpaRepository<Duplex, String> {
}

package com.example.apartment_predictor.model;

import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class Reviewer extends Person {

    private int reputationScore;

    public Reviewer() {
        this.id = UUID.randomUUID().toString();
    }

    public Reviewer(String fullName, String email, String phone, int reputationScore) {
        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.reputationScore = reputationScore;
    }

    public int getReputationScore() {
        return reputationScore;
    }

    public void setReputationScore(int reputationScore) {
        this.reputationScore = reputationScore;
    }
}

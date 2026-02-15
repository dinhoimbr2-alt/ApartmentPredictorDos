package com.example.apartment_predictor.model;

import jakarta.persistence.Entity;
import java.util.UUID;

@Entity
public class Duplex extends ResidentialProperty {

    private String balcony;
    private boolean elevator;

    public Duplex() {
        this.id = UUID.randomUUID().toString();
    }

    public Duplex(Long price, Integer area, Integer bedrooms,
                  String balcony, boolean elevator) {

        this.id = UUID.randomUUID().toString();
        this.price = price;
        this.area = area;
        this.bedrooms = bedrooms;
        this.balcony = balcony;
        this.elevator = elevator;
    }

    @Override
    public double calculatePrice() {
        double basePrice = area * 120 + (bedrooms * 8000);
        if (elevator) {
            basePrice *= 1.15;
        }
        return basePrice * (1 + (area * 0.04));
    }

    public String getBalcony() {
        return balcony;
    }

    public void setBalcony(String balcony) {
        this.balcony = balcony;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    @Override
    public String toString() {
        return "Duplex{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", bedrooms=" + bedrooms +
                ", balcony='" + balcony + '\'' +
                ", elevator=" + elevator +
                '}';
    }
}

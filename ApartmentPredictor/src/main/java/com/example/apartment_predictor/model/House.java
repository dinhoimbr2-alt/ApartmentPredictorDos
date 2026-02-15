package com.example.apartment_predictor.model;

import jakarta.persistence.Entity;
import java.util.UUID;

@Entity
public class House extends ResidentialProperty {

    private int garageQty;
    private String roofType;
    private String garden;

    public House() {
        this.id = UUID.randomUUID().toString();
    }

    public House(Long price, Integer area, Integer bedrooms,
                 int garageQty, String roofType, String garden) {

        this.id = UUID.randomUUID().toString();
        this.price = price;
        this.area = area;
        this.bedrooms = bedrooms;
        this.garageQty = garageQty;
        this.roofType = roofType;
        this.garden = garden;
    }

    @Override
    public double calculatePrice() {
        double basePrice = area * 120 + (bedrooms * 8000);
        if (garageQty > 0) {
            basePrice += 25000;
        }
        return basePrice * (1 + (area * 0.04));
    }

    public int getGarageQty() {
        return garageQty;
    }

    public void setGarageQty(int garageQty) {
        this.garageQty = garageQty;
    }

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public String getGarden() {
        return garden;
    }

    public void setGarden(String garden) {
        this.garden = garden;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", price=" + price +
                ", area=" + area +
                ", bedrooms=" + bedrooms +
                ", garageQty=" + garageQty +
                ", roofType='" + roofType + '\'' +
                ", garden='" + garden + '\'' +
                '}';
    }
}

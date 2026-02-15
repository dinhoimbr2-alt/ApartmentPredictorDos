package com.example.apartment_predictor.model;

import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ResidentialProperty {

    @Id
    protected String id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    protected Long price;
    protected Integer area;
    protected Integer bedrooms;

    public String getId() {
        return id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public abstract double calculatePrice();
}

package com.example.apartment_predictor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Owner extends Person {

    private int age;
    private boolean isActive;
    private boolean isBusiness;
    private String idLegalOwner;
    private LocalDate registrationDate;
    private int qtyDaysAsOwner;

    @OneToMany(mappedBy = "owner")
    private List<ResidentialProperty> properties = new ArrayList<>();

    public Owner() {
        this.id = UUID.randomUUID().toString();
    }

    // 🔥 Constructor usado en DataInitializer
    public Owner(String fullName, String email, String phone) {
        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;

        this.age = 30;
        this.isActive = true;
        this.isBusiness = false;
        this.idLegalOwner = "NIF-" + UUID.randomUUID().toString().substring(0, 5);
        this.registrationDate = LocalDate.now();
        this.qtyDaysAsOwner = 0;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isBusiness() {
        return isBusiness;
    }

    public String getIdLegalOwner() {
        return idLegalOwner;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public int getQtyDaysAsOwner() {
        return qtyDaysAsOwner;
    }
}

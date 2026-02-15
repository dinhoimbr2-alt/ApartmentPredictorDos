package com.example.apartment_predictor.config;

import com.example.apartment_predictor.model.*;
import com.example.apartment_predictor.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerRepository ownerRepo;
    private final ApartmentRepository apartmentRepo;
    private final HouseRepository houseRepo;
    private final DuplexRepository duplexRepo;
    private final ReviewRepository reviewRepo;
    private final ReviewerRepository reviewerRepo;

    public DataInitializer(
            OwnerRepository ownerRepo,
            ApartmentRepository apartmentRepo,
            HouseRepository houseRepo,
            DuplexRepository duplexRepo,
            ReviewRepository reviewRepo,
            ReviewerRepository reviewerRepo
    ) {
        this.ownerRepo = ownerRepo;
        this.apartmentRepo = apartmentRepo;
        this.houseRepo = houseRepo;
        this.duplexRepo = duplexRepo;
        this.reviewRepo = reviewRepo;
        this.reviewerRepo = reviewerRepo;
    }

    @Override
    public void run(String... args) {

        // 🔹 Clean previous data
        reviewRepo.deleteAll();
        duplexRepo.deleteAll();
        houseRepo.deleteAll();
        apartmentRepo.deleteAll();
        ownerRepo.deleteAll();
        reviewerRepo.deleteAll();

        // =========================
        // 1️⃣ CREATE OWNERS
        // =========================

        Owner owner1 = new Owner("Maria Soler", "maria@demo.com", "600111111");
        Owner owner2 = new Owner("Joan Puig", "joan@demo.com", "600222222");
        Owner owner3 = new Owner("Laura Vidal", "laura@demo.com", "600333333");

        List<Owner> owners = new ArrayList<>();
        owners.add(owner1);
        owners.add(owner2);
        owners.add(owner3);

        owners = ownerRepo.saveAll(owners);

        // =========================
        // 2️⃣ CREATE REVIEWERS
        // =========================

        Reviewer reviewer1 = new Reviewer("Carlos Ruiz", "carlos@demo.com", "611111111", 80);
        Reviewer reviewer2 = new Reviewer("Anna Costa", "anna@demo.com", "622222222", 95);

        List<Reviewer> reviewers = new ArrayList<>();
        reviewers.add(reviewer1);
        reviewers.add(reviewer2);

        reviewers = reviewerRepo.saveAll(reviewers);

        // =========================
        // 3️⃣ GENERATE APARTMENTS
        // =========================

        for (int i = 0; i < 10; i++) {

            Apartment apt = new Apartment();
            apt.setPrice(ThreadLocalRandom.current().nextLong(150000, 400000));
            apt.setArea(ThreadLocalRandom.current().nextInt(60, 150));
            apt.setBedrooms(ThreadLocalRandom.current().nextInt(1, 5));
            apt.setBathrooms(ThreadLocalRandom.current().nextInt(1, 3));

            apt.setOwner(owners.get(i % owners.size()));

            apartmentRepo.save(apt);
        }

        // =========================
        // 4️⃣ GENERATE HOUSES
        // =========================

        for (int i = 0; i < 5; i++) {

            House house = new House();
            house.setPrice(ThreadLocalRandom.current().nextLong(300000, 700000));
            house.setArea(ThreadLocalRandom.current().nextInt(120, 300));
            house.setBedrooms(ThreadLocalRandom.current().nextInt(3, 6));
            house.setGarageQty(ThreadLocalRandom.current().nextInt(1, 3));
            house.setGarden("Yes");

            house.setOwner(owners.get(i % owners.size()));

            houseRepo.save(house);
        }

        // =========================
        // 5️⃣ GENERATE DUPLEX
        // =========================

        for (int i = 0; i < 3; i++) {

            Duplex duplex = new Duplex();
            duplex.setPrice(ThreadLocalRandom.current().nextLong(250000, 500000));
            duplex.setArea(ThreadLocalRandom.current().nextInt(90, 180));
            duplex.setBedrooms(ThreadLocalRandom.current().nextInt(2, 4));
            duplex.setBalcony("Yes");
            duplex.setElevator(i % 2 == 0);

            duplex.setOwner(owners.get(i % owners.size()));

            duplexRepo.save(duplex);
        }

        // =========================
        // 6️⃣ GENERATE REVIEWS
        // =========================

        List<Apartment> apartments = apartmentRepo.findAll();

        for (int i = 0; i < apartments.size(); i++) {

            Review review = new Review();
            review.setTitle("Review " + (i + 1));
            review.setContent("Automatically generated review content.");
            review.setRating(ThreadLocalRandom.current().nextInt(3, 6));
            review.setReviewDate(LocalDate.now());

            review.setApartment(apartments.get(i));
            review.setReviewer(reviewers.get(i % reviewers.size()));

            reviewRepo.save(review);
        }

        System.out.println("✅ Database initialized with automatic demo data.");
    }
}

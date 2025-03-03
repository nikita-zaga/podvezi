package com.example.podvezi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private String experienceYears;
    private String tripCount;

    @OneToOne
    private Car car;

    public Driver(User user, String experienceYears, String tripCount, Car car) {
        this.user = user;
        this.experienceYears = experienceYears;
        this.tripCount = tripCount;
        this.car = car;
    }

    public Driver() {

    }
}

package com.example.podvezi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String route;
    private LocalDateTime startTime;
    private String price;
    private String countFreePlaces;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    public Trip(String route, LocalDateTime startTime, String price, String countFreePlaces, String status, Driver driver) {
        this.route = route;
        this.startTime = startTime;
        this.price = price;
        this.countFreePlaces = countFreePlaces;
        this.status = status;
        this.driver = driver;
    }

    public Trip() {
    }
}

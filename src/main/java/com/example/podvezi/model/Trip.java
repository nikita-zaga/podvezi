package com.example.podvezi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "trip")
@Getter
@Setter
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Route route;

    private LocalDateTime startTime;
    private String price;
    private String countFreePlaces;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    public Trip(Route route, LocalDateTime startTime, String price, String countFreePlaces, String status, Driver driver) {
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

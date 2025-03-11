package com.example.podvezi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class TripDto {
    private String route;
    private LocalDateTime startTime;
    private String price;
    private String countFreePlaces;
    private String status;

    private DriverDto driver;
}

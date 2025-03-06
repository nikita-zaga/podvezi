package com.example.podvezi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class CreateDriverTripDto {
    private String countFreePlaces;
    private LocalDateTime date;
    private String price;
    private String route;
}

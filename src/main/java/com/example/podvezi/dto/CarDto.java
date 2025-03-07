package com.example.podvezi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CarDto {
    private String model;
    private String number;
    private String color;
}

package com.example.podvezi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DriverDto {
    private String experienceYears;
    private String tripCount;

    private CarDto carDto;
}

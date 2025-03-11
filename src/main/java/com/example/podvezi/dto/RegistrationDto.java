package com.example.podvezi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RegistrationDto {
    private String username;
    private String password;
    private String role;
    private String experienceYears;
    private String tripCount;
    private CarDto car;
}

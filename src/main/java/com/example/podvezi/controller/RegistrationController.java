package com.example.podvezi.controller;

import com.example.podvezi.dto.RegistrationDto;
import com.example.podvezi.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationDto registrationDto) {
        registrationService.registerUser(registrationDto);

        return ResponseEntity.ok("Регистрация выполнена успешна");
    }
}

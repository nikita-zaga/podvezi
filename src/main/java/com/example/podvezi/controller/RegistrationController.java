package com.example.podvezi.controller;

import com.example.podvezi.dto.RegistrationDto;
import com.example.podvezi.model.User;
import com.example.podvezi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerPassenger(@RequestBody RegistrationDto registrationDto) {
        String username = registrationDto.getUsername();
        String password = registrationDto.getPassword();

        String encodePassword = passwordEncoder.encode(password);

        User user = new User(username, encodePassword);
        userRepository.save(user);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Регистрация успешна выполнена!");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }


}

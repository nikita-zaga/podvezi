package com.example.podvezi.service;

import com.example.podvezi.controller.DriveController;
import com.example.podvezi.dto.RegistrationDto;
import com.example.podvezi.model.Authority;
import com.example.podvezi.model.Car;
import com.example.podvezi.model.Driver;
import com.example.podvezi.model.Passenger;
import com.example.podvezi.model.User;
import com.example.podvezi.repository.AuthorityRepository;
import com.example.podvezi.repository.DriverRepository;
import com.example.podvezi.repository.PassengerRepository;
import com.example.podvezi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Transactional
    public void registerUser(RegistrationDto registrationDto) {
        logger.info("Start register {}", registrationDto.getUsername());
        String username = registrationDto.getUsername();
        String password = registrationDto.getPassword();
        String role = registrationDto.getRole();

        String encodePassword = passwordEncoder.encode(password);

        User user = new User(username, encodePassword);
        User savedUser = userRepository.save(user);
        logger.info("User saved with id :{}", savedUser.getId());

        Authority authority = new Authority(username, role);
        authorityRepository.save(authority);

        switch (role) {
            case "passenger":
                Passenger passenger = new Passenger(savedUser);
                passengerRepository.save(passenger);
                logger.info("passenger saved successfully");
                break;
            case "driver":
                String experienceYears = registrationDto.getExperienceYears();
                String tripCount = "0";
                Car car = new Car(
                        registrationDto.getCar().getModel(),
                        registrationDto.getCar().getNumber(),
                        registrationDto.getCar().getColor());
                Driver driver = new Driver(savedUser, experienceYears, tripCount, car);
                driverRepository.save(driver);
                logger.info("driver saved successfully");
                break;
        }
    }
}

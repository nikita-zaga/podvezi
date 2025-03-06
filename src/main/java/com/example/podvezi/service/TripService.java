package com.example.podvezi.service;

import com.example.podvezi.dto.CreateDriverTripDto;
import com.example.podvezi.model.Driver;
import com.example.podvezi.model.Trip;
import com.example.podvezi.model.User;
import com.example.podvezi.repository.DriverRepository;
import com.example.podvezi.repository.TripRepository;
import com.example.podvezi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TripService {
    private static final Logger logger = LoggerFactory.getLogger(TripService.class);

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TripRepository tripRepository;

    public void createDriverTrip(CreateDriverTripDto createDriverTripDto) {
        logger.info("Create driver trip");

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        logger.info("username :{}", username);

        User user = userRepository.findByUsername(username);

        Driver driver = driverRepository.findByUser(user);

        Trip trip = new Trip(
                createDriverTripDto.getRoute(),
                createDriverTripDto.getDate(),
                createDriverTripDto.getPrice(),
                createDriverTripDto.getCountFreePlaces(),
                "created",
                driver);

        tripRepository.save(trip);
        logger.info("trip successfully saved");
    }
}

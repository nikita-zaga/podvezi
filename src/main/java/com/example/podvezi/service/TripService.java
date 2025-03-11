package com.example.podvezi.service;

import com.example.podvezi.dto.CreateDriverTripDto;
import com.example.podvezi.dto.TripDto;
import com.example.podvezi.mapper.TripMapper;
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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {
    private static final Logger logger = LoggerFactory.getLogger(TripService.class);

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripMapper tripMapper;

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

    public List<TripDto> getTrips() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        logger.info("Get trips fro user: {}", username);

        List<Trip> trips = tripRepository.findAllByOrderByStartTime();

        return trips.stream()
                .map(trip -> tripMapper.mapToDto(trip))
                .collect(Collectors.toList());
    }
}

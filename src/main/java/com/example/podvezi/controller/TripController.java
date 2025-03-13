package com.example.podvezi.controller;

import com.example.podvezi.dto.CreateDriverTripDto;
import com.example.podvezi.dto.RegistrationDto;
import com.example.podvezi.dto.TripDto;
import com.example.podvezi.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {
    private static final Logger logger = LoggerFactory.getLogger(TripController.class);

    @Autowired
    private TripService tripService;

    @PostMapping("/create/driver")
    public ResponseEntity<?> createDriverTrip(@RequestBody CreateDriverTripDto createDriverTripDto) {
        tripService.createDriverTrip(createDriverTripDto);

        return ResponseEntity.ok("Поездка создана успешно");
    }

    @GetMapping("/trips")
    public ResponseEntity<?> getTrips(
            @RequestParam(value="routeSystemName", required = false)
            String routeSystemName) {
        List<TripDto> result = tripService.getTrips(routeSystemName);

        return ResponseEntity.ok(result);
    }
}

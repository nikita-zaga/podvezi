package com.example.podvezi.mapper;

import com.example.podvezi.dto.CarDto;
import com.example.podvezi.dto.DriverDto;
import com.example.podvezi.dto.TripDto;
import com.example.podvezi.model.Car;
import com.example.podvezi.model.Driver;
import com.example.podvezi.model.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {

    public TripDto mapToDto(Trip trip) {
        TripDto tripDto = new TripDto();
        tripDto.setStartTime(trip.getStartTime());
        tripDto.setStatus(trip.getStatus());
        tripDto.setRoute(trip.getRoute());
        tripDto.setCountFreePlaces(trip.getCountFreePlaces());
        tripDto.setPrice(trip.getPrice());

        Driver driver = trip.getDriver();
        DriverDto driverDto = new DriverDto();
        Car car = driver.getCar();
        CarDto carDto = new CarDto();

        carDto.setColor(car.getColor());
        carDto.setModel(car.getModel());
        carDto.setNumber(car.getNumber());

        driverDto.setCar(carDto);

        driverDto.setTripCount(driver.getTripCount());
        driverDto.setExperienceYears(driver.getExperienceYears());
        tripDto.setDriver(driverDto);

        return tripDto;
    }
}

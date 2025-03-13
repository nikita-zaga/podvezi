package com.example.podvezi.service;

import com.example.podvezi.dto.RouteResponse;
import com.example.podvezi.model.Route;
import com.example.podvezi.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<RouteResponse> getRoutes() {
        List<Route> routes = routeRepository.findAll();

        return routes.stream()
                .map(route ->
                        new RouteResponse(route.getSystemName(), route.getLabelName()))
                .collect(Collectors.toList());
    }
}

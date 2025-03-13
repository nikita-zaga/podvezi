package com.example.podvezi.controller;

import com.example.podvezi.dto.RouteResponse;
import com.example.podvezi.dto.TripDto;
import com.example.podvezi.model.Route;
import com.example.podvezi.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/routes")
    public ResponseEntity<?> getRoutes() {
        List<RouteResponse> result = routeService.getRoutes();

        return ResponseEntity.ok(result);
    }
}

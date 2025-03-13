package com.example.podvezi.repository;

import com.example.podvezi.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
    public Route findBySystemName(String systemName);
}

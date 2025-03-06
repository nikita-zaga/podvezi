package com.example.podvezi.repository;

import com.example.podvezi.model.AuthToken;
import com.example.podvezi.model.Driver;
import com.example.podvezi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findByUser(User user);
}

package com.example.podvezi.repository;

import com.example.podvezi.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {
    Optional<AuthToken> findByToken(String token);
    Optional<AuthToken> findByUsername(String username);
    void deleteByToken(String token);
}

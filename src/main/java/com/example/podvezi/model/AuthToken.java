package com.example.podvezi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auth_tokens")
public class AuthToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    public AuthToken() {}

    public AuthToken(String token, String username, LocalDateTime expiresAt) {
        this.token = token;
        this.username = username;
        this.expiresAt = expiresAt;
    }

    public Long getId() { return id; }
    public String getToken() { return token; }
    public String getUsername() { return username; }
    public LocalDateTime getExpiresAt() { return expiresAt; }

    public void setToken(String token) { this.token = token; }
    public void setUsername(String username) { this.username = username; }
    public void setExpiresAt(LocalDateTime expiresAt) { this.expiresAt = expiresAt; }
}


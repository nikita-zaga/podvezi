package com.example.podvezi.service;

import com.example.podvezi.model.AuthToken;
import com.example.podvezi.repository.AuthTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

@Service
public class AuthTokenService {

    private final AuthTokenRepository authTokenRepository;

    public AuthTokenService(AuthTokenRepository authTokenRepository) {
        this.authTokenRepository = authTokenRepository;
    }

    @Transactional
    public String generateToken(String username) {
        String token = generateRandomToken();
        LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(30);

        authTokenRepository.findByUsername(username).ifPresent(authTokenRepository::delete);

        AuthToken authToken = new AuthToken(token, username, expiresAt);
        authTokenRepository.save(authToken);

        return token;
    }

    public Optional<AuthToken> validateToken(String token) {
        return authTokenRepository.findByToken(token)
                .filter(authToken -> authToken.getExpiresAt().isAfter(LocalDateTime.now()));
    }

    @Transactional
    public void revokeToken(String token) {
        authTokenRepository.deleteByToken(token);
    }

    private String generateRandomToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

}

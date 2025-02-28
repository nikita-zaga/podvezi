package com.example.podvezi.controller;

import com.example.podvezi.dto.AuthRequest;
import com.example.podvezi.service.AuthTokenService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AuthTokenService authTokenService;
    private final UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authenticationManager, AuthTokenService authTokenService,
                          UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.authTokenService = authTokenService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

            String token = authTokenService.generateToken(authRequest.getUsername());

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public  ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        authTokenService.revokeToken(token.replace("Bearer ", ""));
        return ResponseEntity.ok("Logged out successfully");
    }


}

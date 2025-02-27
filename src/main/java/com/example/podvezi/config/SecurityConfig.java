package com.example.podvezi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(c -> {
            CorsConfigurationSource source = request -> {
                CorsConfiguration corsConfiguration = new CorsConfiguration();

                corsConfiguration.setAllowedOrigins(List.of("http://localhost:5173"));
                corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                corsConfiguration.setAllowedHeaders(List.of("*"));

                return corsConfiguration;
            };
            c.configurationSource(source);
        });

        http.csrf(c -> {
            c.disable();
        });

        http.authorizeHttpRequests(
                c -> c.anyRequest().permitAll()
        );
        return http.build();
    }
}

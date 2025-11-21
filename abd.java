package com.streamhive.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Implementación de Estrategia "Zero Trust"
        http
            .csrf(csrf -> csrf.disable()) // Deshabilitado para APIs REST
            .authorizeHttpRequests(auth -> auth
                // Endpoints públicos (Login, Registro, Home)
                .requestMatchers("/api/auth/**", "/api/public/**").permitAll()
                // Endpoints protegidos (requieren Rol de ADMIN)
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                // Todo lo demás requiere Token JWT válido
                .anyRequest().authenticated()
            );
        
        return http.build();
    }
}
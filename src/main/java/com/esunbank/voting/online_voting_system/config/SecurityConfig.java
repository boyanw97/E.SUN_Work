package com.esunbank.voting.online_voting_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() 
            .cors()
            .and()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/votes/**").permitAll() // 允許訪問API
                .anyRequest().authenticated()
            );

        return http.build();
    }
}

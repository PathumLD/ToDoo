package com.example.ToDoo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    @Bean(name = "appPasswordEncoder")
    @Primary
    public BCryptPasswordEncoder appPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}


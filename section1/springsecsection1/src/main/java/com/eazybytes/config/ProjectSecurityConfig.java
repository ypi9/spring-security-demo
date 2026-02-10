package com.eazybytes.config;

import org.springframework.boot.security.autoconfigure.web.servlet.SecurityFilterProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
        //        http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        //        http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/myAccount","/myBlance","/myLoans","/myCards").authenticated()
                .requestMatchers("/notices","/contact","/error").permitAll());
        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
        // http.formLogin(flc -> flc.disable());
        // http.httpBasic(hbc -> hbc.disable());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
}


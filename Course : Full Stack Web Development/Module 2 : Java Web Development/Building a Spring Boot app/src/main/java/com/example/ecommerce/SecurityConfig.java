package com.example.ecommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/actuator/**", "/products/**").hasRole("ADMIN") // Only admins can access products and Actuator endpoints
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable(); // Disabling CSRF for simplicity (only for APIs; re-enable for production if necessary)

                http.headers().frameOptions().disable(); //Enabling Frames for H2 Console

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        return username -> {
            Users user = userService.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build();
            return userDetails;
        };
    }

}

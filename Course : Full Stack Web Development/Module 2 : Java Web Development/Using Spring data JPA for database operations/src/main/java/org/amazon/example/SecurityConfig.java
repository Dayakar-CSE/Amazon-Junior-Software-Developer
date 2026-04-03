package org.amazon.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
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
                .requestMatchers("/register", "/login").permitAll()  // Allow public access to these pages
                .requestMatchers("/admin/**").hasRole("ADMIN")        // Only ADMIN can access /admin/*
                .requestMatchers("/user/**").hasRole("USER")          // Only USER can access /user/*
                .anyRequest().authenticated()
                .and()
                // Configure Basic Authentication for the API endpoints (like /products)
                .httpBasic()
                .and()
                // Disable form login for API endpoints to avoid redirection
                .csrf().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/welcome", true)
                .and()
                .logout().permitAll();

        return http.build();

        /*
                http
                        .authorizeHttpRequests()
                        .requestMatchers("/products/**").authenticated()
                        .anyRequest().permitAll()
                        .and()
                        .httpBasic();

         */

    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            org.amazon.example.User user = userService.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            UserBuilder builder = User.withUsername(user.getUsername());
            builder.password(user.getPassword());  // Password is already encoded
            if(user.getRole() != null) {
                builder.roles(user.getRole());
            }
            return builder.build();
        };
    }
}

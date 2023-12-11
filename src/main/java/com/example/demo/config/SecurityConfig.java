//package com.example.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Bean
////    public InMemoryUserDetailsManager userDetailsService() {
////        return User.builder().username("admin").password(passwordEncoder().encode("123"))
////                .roles("admin", "user").build();
////    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//                http
//                .requestMatchers(antMatcher("/food/all")).permitAll()
//                .anyRequest().authenticated() // Secure other endpoints
//                .and()
//                .formLogin() // Enable form-based login
//                .and()
//                .csrf() // Enable CSRF protection
//                .and()
//                .httpBasic(); // Enable basic authentication
//
//        return http.build();
//    }
//}
package com.example.demo.controller;

import com.example.demo.dto.LoginDTO;
import com.example.demo.exceptions.InvalidLoginException;
import com.example.demo.service.UserDetailsServiceImpl;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final UserDetailsServiceImpl userDetailsService;
    private final DaoAuthenticationProvider authenticationManager;

    private final UserService userService;

    public LoginController(UserDetailsServiceImpl userDetailsService, DaoAuthenticationProvider authenticationManager, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO credentials) {
//        return userService.login(credentials);
            try {
                Authentication authentication = authenticationManager.authenticate(

                        new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword())
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            return userService.login(credentials);
            } catch (AuthenticationException e) {
                throw new InvalidLoginException("Invalid Login");
            }

    }
}

package com.example.demo.controller;

import com.example.demo.dto.LoginDTO;
import com.example.demo.service.UserDetailsServiceImpl;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final UserDetailsServiceImpl userDetailsService;
    private final UserService userService;

    public LoginController(UserDetailsServiceImpl userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO credentials) {
        return userService.login(credentials);
    }
}

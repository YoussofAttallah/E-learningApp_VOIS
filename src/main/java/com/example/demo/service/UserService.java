package com.example.demo.service;

import com.example.demo.dto.LoginDTO;
import com.example.demo.entity.User;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    @Transactional
    public void createNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    @Transactional
    public User getUser(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("instructor not found"));
    }

    @Transactional
    public ResponseEntity<?> login(LoginDTO credentials) {
        User user = userRepository.findByEmail(credentials.getEmail()).orElse(null);
        String msg;
        if (user == null) msg = "Email doesn't exist";
        else {
            String hashedPassword = user.getPassword();
            if (!passwordEncoder.matches(credentials.getPassword(), hashedPassword))
                msg = "wrong password!";
            else msg = "Login Successful";
        }
        return ResponseEntity.ok(msg);
    }
}


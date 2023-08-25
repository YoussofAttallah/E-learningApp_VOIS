package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    @Transactional
    public void createNewUser(User user) {
        userRepository.save(user);
    }
    @Transactional
    public User getUser(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
    @Transactional
    public User updateUser(Integer userId, User user) {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException("user doesn't exist"));
        userRepository.save(user);
        return user;
    }
    @Transactional
    public void deleteUser(Integer userId) {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException("user doesn't exist"));
        userRepository.deleteById(userId);
    }
}


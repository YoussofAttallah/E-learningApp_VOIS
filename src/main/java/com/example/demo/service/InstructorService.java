package com.example.demo.service;

import com.example.demo.entity.Instructor;
import com.example.demo.repository.InstructorDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private final InstructorDAO instructorDAO;

    public InstructorService(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    public List<Instructor> getAllInstructors() {
        return instructorDAO.findAll();
    }
}

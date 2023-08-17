package com.example.demo.service;

import com.example.demo.entity.Instructor;
import com.example.demo.exceptions.InstructorNotFoundException;
import com.example.demo.repository.InstructorDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorService {
    private final InstructorDAO instructorDAO;


    public InstructorService(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Transactional
    public List<Instructor> getAllInstructors() {
        return instructorDAO.findAll();
    }
    @Transactional
    public void createNewInstructor(Instructor instructor) {
        instructorDAO.save(instructor);
    }

    @Transactional
    public Instructor getInstructor(Integer instructorId) {
        return instructorDAO.findById(instructorId)
                        .orElseThrow(() -> new InstructorNotFoundException("instructor not found"));
    }
}

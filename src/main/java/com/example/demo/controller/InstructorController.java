package com.example.demo.controller;

import com.example.demo.entity.Instructor;
import com.example.demo.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @PostMapping()
    public void createNewInstructor(@RequestBody @Valid Instructor instructor) {
        instructorService.createNewInstructor(instructor);
    }

    @GetMapping("/{instructorId}")
    public Instructor getInstructor(@PathVariable(name = "instructorId") Integer instructorId) {
        return instructorService.getInstructor(instructorId);
    }
}

package com.example.demo.controller;

import com.example.demo.entity.Instructor;
import com.example.demo.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
@CrossOrigin(origins = "http://localhost:3000")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/all")
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

    @PutMapping("/{instructorId}")

    public Instructor updateInstructor(@PathVariable("instructorId") Integer instructorId,
                                       @RequestBody(required = true) @Valid Instructor instructor) {
        return instructorService.updateInstructor(instructorId, instructor);
    }

    @DeleteMapping("/{instructorId}")

    public ResponseEntity<String> deleteInstructor(@PathVariable("instructorId") Integer instructorId) {
        instructorService.deleteInstructor(instructorId);
        return ResponseEntity.ok("Instructor deleted successfully");
    }

    @GetMapping("/search/{instructorName}")
    public List<Instructor> findInstructorByName(@PathVariable() String instructorName) {
        return instructorService.findInstructorByName(instructorName);
    }
}

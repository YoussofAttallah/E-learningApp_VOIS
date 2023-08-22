package com.example.demo.controller;


import com.example.demo.entity.Course;
import com.example.demo.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // This means that this class is a Controller
@RequestMapping(path="/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CoursesService coursesService;

    @PostMapping
    public void add(@RequestBody Course course)
    {
        coursesService.addCourse(course);
//        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody Map<String, Object> updates)
    {
        coursesService.updateCourse(id,updates);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<>(coursesService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> searchId(@PathVariable Integer id)
    {
        return new ResponseEntity<>(coursesService.findById(id),HttpStatus.OK);

    }
    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<?> searchTitle(@PathVariable String title)
    {
        return new ResponseEntity<>(coursesService.findByTitle(title),HttpStatus.OK);

    }

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteCourse(@PathVariable Integer id)
{
    coursesService.deleteCourse(id);
   return new ResponseEntity<>(HttpStatus.OK);

}




}


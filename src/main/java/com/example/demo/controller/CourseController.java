package com.example.demo.controller;


import com.example.demo.entity.Course;
import com.example.demo.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // This means that this class is a Controller
@RequestMapping(path="/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CoursesService coursesService;

    @PostMapping
    public ResponseEntity<?> add(Course course)
    {
        coursesService.addCourse(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(Course course)
    {
        coursesService.updateCourse(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<>(coursesService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchCourse(@RequestParam Integer id, @RequestParam String title)
    {
        return new ResponseEntity<>(coursesService.findCourse(id,title),HttpStatus.OK);

    }

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteCourse(@PathVariable Integer id)
{
    coursesService.deleteCourse(id);
   return new ResponseEntity<>(HttpStatus.OK);

}




}


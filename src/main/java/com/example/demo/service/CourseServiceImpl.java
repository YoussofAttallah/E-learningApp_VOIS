package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CoursesService{

   private final CourseRepository courseRepository;

    @Override
    public void addCourse(Course course)
    {
        //TODO add business logic for validation and initializing null values
        courseRepository.save(course);

    }

    @Override
    public void updateCourse(Course course)
    {
        //TODO add business logic for validation

        courseRepository.save(course);


    }

    @Override
    public void deleteCourse(Integer id)
    {
        courseRepository.deleteById(id);

    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourse(Integer id, String title) {

        Optional<Course> course = Optional.empty();

        if(id!=null)
           course = courseRepository.findById(id);
        else if(title!=null)
            course = courseRepository.findCourseByTitle(title);
        return course.orElseThrow(()-> new NotFoundException("course not found"));
    }
}

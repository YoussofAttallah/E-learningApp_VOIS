package com.example.demo.service;

import com.example.demo.entity.Course;

import java.util.List;
import java.util.Map;

public interface CoursesService {

    void addCourse(Course course);
    void updateCourse(Integer id, Map<String,Object> updates);
    void deleteCourse(Integer id);

    List<Course> getAllCourses();

    Course findById(Integer id);
    Course[] findByTitle(String title);

}

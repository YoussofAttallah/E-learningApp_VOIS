package com.example.demo.service;

import com.example.demo.entity.Course;

import java.util.List;

public interface CoursesService {

    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Integer id);

    List<Course> getAllCourses();

    Course findCourse(Integer id, String title);

}

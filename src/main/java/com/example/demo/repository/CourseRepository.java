package com.example.demo.repository;
import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Optional<Course> findCourseByTitle(String title);

}


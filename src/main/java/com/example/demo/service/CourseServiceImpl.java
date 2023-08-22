package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CoursesService{

   private final CourseRepository courseRepository;

    @Override
    @Transactional
    public void addCourse(Course course)
    {
        //TODO add business logic for validation and initializing null values

        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Integer id, Map<String,Object> updates)
    {
        //TODO add business logic for validation
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with id: " + id));

        // Update only the attributes provided in the request body
        if (updates.containsKey("title")) {
            System.out.println((String) updates.get("title"));
            existingCourse.setTitle((String) updates.get("title"));
        }
        if (updates.containsKey("duration")) {
            existingCourse.setDuration((Integer) updates.get("duration"));
        }
        if (updates.containsKey("viewersNum")) {
            existingCourse.setViewersNum((Integer) updates.get("viewersNum"));
        }
        if (updates.containsKey("ratingNum")) {
            existingCourse.setRatingNum((Integer) updates.get("ratingNum"));
        }
        if (updates.containsKey("link")) {
            existingCourse.setLink((String) updates.get("link"));
        }
        if (updates.containsKey("imageLink")) {
            existingCourse.setImageLink((String) updates.get("imageLink"));
        }
        if (updates.containsKey("totalRating")) {
            existingCourse.setTotalRating((Integer) updates.get("totalRating"));
        }
        courseRepository.save(existingCourse);


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
    public Course findById(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElseThrow(()-> new NotFoundException("course not found"));

    }

    @Override
    public Course[] findByTitle(String title) {
        Optional<Course[]> course = courseRepository.findCourseByTitle(title);
        return course.orElseThrow(()-> new NotFoundException("course not found"));
    }
}

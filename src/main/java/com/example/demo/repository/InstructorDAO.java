package com.example.demo.repository;

import com.example.demo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorDAO extends JpaRepository<Instructor, Integer> {

    @Query(value = "SELECT * from instructor i where i.name = ?1", nativeQuery = true)
    public List<Instructor> findInstructorByInstructorName(String name);
}

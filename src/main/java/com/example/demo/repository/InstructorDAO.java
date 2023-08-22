package com.example.demo.repository;

import com.example.demo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDAO extends JpaRepository<Instructor, Integer> {

    public Instructor findInstructorByInstructorName(String name);
}

package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity // This tells Hibernate to make a table out of this class
@Data
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String title;
    private String link;

    private Integer instructorId;
    private String imageLink;
    private Integer viewersNum;
    private Integer ratingNum;
    private float rating;




}

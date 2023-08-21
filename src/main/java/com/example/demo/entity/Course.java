package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // This tells Hibernate to make a table out of this class
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String title;
    private String link;
    private String imageLink;
    private Integer viewersNum;
    private Integer ratingNum;
    private float rating;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "instructor_id", nullable = false)
    private com.example.demo.entity.Instructor instructor;

}

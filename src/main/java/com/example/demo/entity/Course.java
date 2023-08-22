package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Data
@RequiredArgsConstructor
//@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NonNull
    private String title;
    @NonNull
    private String link;
    private Integer duration;
//    private Integer instructorId;
    private String imageLink;
    private Integer viewersNum;
    private Integer ratingNum;
    private Integer totalRating;

    @ManyToOne()
    @JoinColumn(name = "instructorId",nullable = false)
    private Instructor instructor;
}

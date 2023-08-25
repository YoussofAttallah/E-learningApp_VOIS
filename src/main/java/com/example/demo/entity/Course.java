package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Integer duration=0;
//    private Integer instructorId;
    private String imageLink;
    private Integer viewersNum =0;
    private Integer ratingNum=0;
    private Integer totalRating=0;

    @ManyToOne()
    @JoinColumn(name = "instructorId",nullable = false)
    @JsonIgnoreProperties("courses")
    private Instructor instructor;
}

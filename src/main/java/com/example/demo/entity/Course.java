package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // This tells Hibernate to make a table out of this class
@Data
@RequiredArgsConstructor
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
    private Integer instructorId;
    private String imageLink;
    private Integer viewersNum;
    private Integer ratingNum;
    private float rating;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(nullable = false)
    private Instructor instructor;

}

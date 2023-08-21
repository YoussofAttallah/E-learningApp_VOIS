package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity(name = "instructor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Instructor {
    @Id
    @Column(name = "instructor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer instructorId;

    @Column(name = "name")
    @NotNull
    private String instructorName;

    @Column(name = "rating_num")
    @NotNull
    private Integer ratingNum = 0;

    @Column(name = "rating_total")
    @NotNull
    private Integer ratingTotal = 0;
    @Column(name = "link")
    private String link;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<Course> courses;

}

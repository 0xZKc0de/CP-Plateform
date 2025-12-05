package com.g8s6.cp_springboot.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data

@Entity
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double time_limit;
    private double memory_limit;

    @Column(name = "resumeUrl")
    private String resumeUrl;

    @Enumerated(EnumType.ORDINAL)
    private Difficulty difficulty;

    @OneToMany(mappedBy = "problem")
    private List<TestCase> testCases;

    @OneToMany(mappedBy = "problem")
    private List<Submission> submissions;

    @ManyToMany
    @JoinTable(
            name = "problem_topics",
            joinColumns = @JoinColumn(name = "problem_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    private List<Topic> topics;

}

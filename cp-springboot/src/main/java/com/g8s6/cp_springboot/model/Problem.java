package com.g8s6.cp_springboot.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data @Entity
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double time_limit;
    private double memory_limit;
    private String resumeUrl;

    private List<TestCase> testCases;
    private List<Submission> submissions;
}

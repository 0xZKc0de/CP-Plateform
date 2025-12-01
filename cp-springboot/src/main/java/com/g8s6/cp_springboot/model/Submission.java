package com.g8s6.cp_springboot.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
//@Table(name = "submissions")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    private String code_source;
    private Language language;
    private boolean isPassed;
    private double execution_time;
    private LocalDateTime submission_time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    public Problem problem;

}
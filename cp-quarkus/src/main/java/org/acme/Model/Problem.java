package org.acme.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@Entity
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public String description;
    public double time_limit;
    public double memory_limit;
    public String resumeUrl;
    public Difficulty difficulty;
    
    @OneToMany(mappedBy = "problem")
    private List<TestCase> testCases;

    @OneToMany(mappedBy = "problem")
    public List<Submission> submissions;

    @ManyToMany
    @JoinTable(
        name = "problem_topics",
        joinColumns = @JoinColumn(name = "problem_id"),
        inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    public List<Topic> topics;

}
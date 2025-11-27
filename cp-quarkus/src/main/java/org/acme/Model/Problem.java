package org.acme.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @OneToMany(mappedBy = "problem")
    private List<TestCase> testCases;

    @OneToMany(mappedBy = "problem")
    private List<Submission> submissions;

    @OneToMany(mappedBy = "problem")
    private List<Topic> topics; 

}
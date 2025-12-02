package org.acme.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime; 

@Entity 
@NoArgsConstructor 
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    public String code_source;
    public Language language;
    public boolean isPassed;
    public double execution_time;
    

    public LocalDateTime submission_time; 


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    public User user; 

    @ManyToOne
    @JoinColumn(name = "problem_id")
    @JsonIgnore
    public Problem problem; 
}
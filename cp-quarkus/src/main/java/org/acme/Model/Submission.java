package org.acme.Model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    public double submission_time;

}
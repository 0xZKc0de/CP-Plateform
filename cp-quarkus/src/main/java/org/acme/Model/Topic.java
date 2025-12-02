package org.acme.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Generated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@NoArgsConstructor
@Entity
public class Topic {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    public long id;
    public String name;

  
    @ManyToMany(mappedBy = "topics")
    @JsonIgnore
    public List<Problem> problems;
}
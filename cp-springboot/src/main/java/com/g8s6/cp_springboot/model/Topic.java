package com.g8s6.cp_springboot.model;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@AllArgsConstructor @NoArgsConstructor
@Data @Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    long id;
    String name;

    @OneToMany(mappedBy = "topics")
    private List<Problem> problems;
}

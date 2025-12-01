package com.g8s6.cp_springboot.model;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
//@Table(name = "topics")
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    long id;
    String name;

    @ManyToMany(mappedBy = "topics")
    private List<Problem> problems;
}

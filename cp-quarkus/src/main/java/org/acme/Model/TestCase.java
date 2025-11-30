package org.acme.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;   // <--- استيراد جديد
import jakarta.persistence.JoinColumn;  // <--- استيراد جديد
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data @Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String input_data;
    private String excepted_output;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;
}
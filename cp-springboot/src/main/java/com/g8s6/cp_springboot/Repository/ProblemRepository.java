package com.g8s6.cp_springboot.Repository;

import com.g8s6.cp_springboot.model.Problem;
import com.g8s6.cp_springboot.model.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem, Long> {

    List<Problem> findByDifficulty(Difficulty difficulty);

    @Query("SELECT p FROM Problem p JOIN p.topics t WHERE t.id = :topicId")
    List<Problem> findByTopicId(Long topicId);

    List<Problem> findByTitleContainingIgnoreCase(String title);
}

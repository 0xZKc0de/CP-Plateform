package com.g8s6.cp_springboot.Repository;

import com.g8s6.cp_springboot.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    List<Submission> findByUserId(Long userId);

    List<Submission> findByProblemId(Long problemId);

    @Query("SELECT s FROM Submission s WHERE s.user.id = :userId AND s.isPassed = true")
    List<Submission> findPassedSubmissionsByUserId(Long userId);
}

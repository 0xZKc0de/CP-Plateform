package org.acme.Service;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional; // Nécessaire pour les écritures (Add/Update/Delete)
import jakarta.ws.rs.WebApplicationException;
import org.acme.Model.Problem;
import org.acme.Repository.ProblemRepository;
import org.acme.Repository.UserRepository;

import java.util.List;

@ApplicationScoped
public class ProblemService {

    @Inject
    UserRepository userRepository;
    @Inject
    private ProblemRepository problemRepository;

    public PanacheQuery<Problem> findByTitle(String title) {
        return problemRepository.find("title", title);
    }

    public PanacheQuery<Problem> findById(Long id) {
        return problemRepository.find("id", id);
    }

    public List<Problem> findAll() {
        return problemRepository.listAll();
    }


    @Transactional
    public Problem createProblem(Problem problem) {
        problemRepository.persist(problem);
        return problem;
    }

    @Transactional
    public Problem updateProblem(Long id, Problem problemUpdates) {
        Problem entity = problemRepository.findById(id);

        if (entity == null) {
            throw new WebApplicationException("Problem with id " + id + " not found.", 404);
        }

        entity.title = problemUpdates.title;
        entity.description = problemUpdates.description;
        entity.time_limit = problemUpdates.time_limit;
        entity.memory_limit = problemUpdates.memory_limit;
        entity.resumeUrl = problemUpdates.resumeUrl;
        entity.difficulty = problemUpdates.difficulty;

        return entity;
    }

    @Transactional
    public void deleteProblem(Long id) {
        boolean deleted = problemRepository.deleteById(id);
        if (!deleted) {
            throw new WebApplicationException("Problem with id " + id + " not found.", 404);
        }
    }
}
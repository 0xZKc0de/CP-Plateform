package org.acme.Service;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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

    public List<Problem> findAll() {
        return problemRepository.listAll();
    }
}

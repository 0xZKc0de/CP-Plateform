package org.acme.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Model.Problem;

import java.util.List;

@ApplicationScoped
public class ProblemRepository implements PanacheRepository<Problem> {



}

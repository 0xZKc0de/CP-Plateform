package org.acme.Web;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.Model.Problem;
import org.acme.Service.ProblemService;

import java.util.List;

@Path("api/problems")
public class ProblemController {

    @Inject
    ProblemService problemService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Problem> findAllProblems() {
        return problemService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Problem getProblem(@PathParam("id") Long id) {
        return problemService.findById(id).firstResult();
    }

}

package org.acme.Web;

import jakarta.inject.Inject;
import jakarta.ws.rs.*; // Import pour GET, POST, PUT, DELETE, etc.
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response; // Pour gérer les statuts HTTP
import org.acme.Model.Problem;
import org.acme.Service.ProblemService;

import java.net.URI;
import java.util.List;

@Path("api/problems")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON) // Important pour lire le JSON envoyé
public class ProblemController {

    @Inject
    ProblemService problemService;

    @GET
    public List<Problem> findAllProblems() {
        return problemService.findAll();
    }

    @GET
    @Path("/{id}")
    public Problem getProblem(@PathParam("id") Long id) {
        Problem problem = problemService.findById(id).firstResult();
        if (problem == null) {
            throw new WebApplicationException(404);
        }
        return problem;
    }

    @POST
    public Response addProblem(Problem problem) {
        Problem createdProblem = problemService.createProblem(problem);
        return Response.created(URI.create("/api/problems/" + createdProblem.id))
                .entity(createdProblem)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProblem(@PathParam("id") Long id, Problem problem) {
        Problem updatedProblem = problemService.updateProblem(id, problem);
        return Response.ok(updatedProblem).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProblem(@PathParam("id") Long id) {
        problemService.deleteProblem(id);
        return Response.noContent().build();
    }

}
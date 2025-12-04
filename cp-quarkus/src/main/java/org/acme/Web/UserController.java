package org.acme.Web;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.acme.DTO.Response.UserDTO;
import org.acme.Model.User;
import org.acme.Service.UserService;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @GET
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }


    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") Long id) {
        Optional<UserDTO> user = userService.findById(id);
        if (user.isPresent()) {
            return Response.ok(user.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response createUser(User userRequest) {
        UserDTO createdUser = userService.createUser(userRequest);

        return Response.created(URI.create("/api/users/" + createdUser.id()))
                .entity(createdUser)
                .build();
    }


    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, User userRequest) {
        try {
            UserDTO updatedUser = userService.updateUser(id, userRequest);
            return Response.ok(updatedUser).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        try {
            userService.deleteUser(id);
            return Response.noContent().build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
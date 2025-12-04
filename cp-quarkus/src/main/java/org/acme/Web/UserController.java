package org.acme.Web;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam;

import java.util.List;
import java.util.Optional;

import org.acme.DTO.Response.UserDTO;
import org.acme.Service.UserService;

@Path("/api/users")
public class UserController {

    @Inject 
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<UserDTO> getUser(@PathParam("id") Long id) { 
        
        return userService.findById(id); 
    }
}
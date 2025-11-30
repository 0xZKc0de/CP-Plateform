package org.acme.Web;

import jakarta.inject.Inject; // مهم جداً لاستخدام Service
import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam; // مهم لاستقبال المتغير

import java.util.Optional;

import org.acme.DTO.Response.UserDTO;
import org.acme.Service.UserService;

@Path("/api/users")
public class UserController {

    @Inject 
    UserService userService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<UserDTO> getUser(@PathParam("id") Long id) { 
        
        return userService.findById(id); 
    }
}
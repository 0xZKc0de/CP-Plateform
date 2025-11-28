package org.acme.Web;

import jakarta.ws.rs.Path;

import org.acme.DTO.Response.UserDTO;
import org.acme.Service.UserService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;




@Path("api/users")
public class UserController {

    private UserService userService;

    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUser(Long id){
        
    }
}

package org.acme.Repository;

import org.acme.Model.User;
import org.acme.DTO.Response.UserDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User>{

    @Inject
    public User user;

    @Inject
    public UserDTO userDTO;

    public Optional<UserDTO> findUserDtoById(String id){
        return find("id", id).singleResultOptional()
            .map(user -> new UserDTO(user.username, user.email, user.rating)); 
    }

    public Optional<User> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }
}

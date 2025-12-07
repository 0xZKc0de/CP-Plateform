package org.acme.Repository;

import org.acme.Model.User;
import org.acme.DTO.Response.UserDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class  UserRepository implements PanacheRepository<User> {

    public List<UserDTO> findAllProjected() {
        return findAll()
                .project(UserDTO.class)
                .list();
    }

    public Optional<UserDTO> findUserDtoById(Long id) {
        return find("id", id)
                .project(UserDTO.class)
                .singleResultOptional();
    }

    public Optional<User> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }
}
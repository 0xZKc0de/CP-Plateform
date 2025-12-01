package org.acme.Repository;

import org.acme.Model.User;
import org.acme.DTO.Response.UserDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {


    @Query(value = "SELECT id, username, email FROM users_table", nativeQuery = true)
    List<UserProjection> findAllUsersSQL();
    public Optional<UserDTO> findUserDtoById(Long id) { 
        return find("id", id).singleResultOptional()
           
            .map(user -> new UserDTO(user.id ,user.username, user.email, user.rating)); 
    }

    public Optional<User> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }
}
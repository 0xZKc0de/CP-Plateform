package org.acme.Service;

import org.acme.Model.User;
import org.acme.Repository.UserRepository;
import org.acme.DTO.Response.UserDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional; 
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<UserDTO> getUsers() {
        return userRepository.findAllProjected();
    }

    public Optional<UserDTO> findById(Long id){
        return userRepository.findUserDtoById(id);
    }

    @Transactional
    public UserDTO createUser(User userRequest) {
        userRepository.persist(userRequest);

        return mapToDTO(userRequest);
    }

    @Transactional
    public UserDTO updateUser(Long id, User userUpdates) {
        User user = userRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        user.username = userUpdates.username;
        user.email = userUpdates.email;
        user.password = userUpdates.password; // يفضل تشفير كلمة السر هنا
        user.rating = userUpdates.rating;


        return mapToDTO(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        boolean deleted = userRepository.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("User not found");
        }
    }

    private UserDTO mapToDTO(User user) {
        return new UserDTO(user.id, user.username, user.email, user.rating);
    }
}
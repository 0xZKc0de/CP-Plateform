package org.acme.Service;

import org.acme.Repository.UserRepository;
import org.acme.DTO.Response.UserDTO; 
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

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
}
package org.acme.DTO.Response;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record UserDTO(Long id, String username, String email, int rating) {
}
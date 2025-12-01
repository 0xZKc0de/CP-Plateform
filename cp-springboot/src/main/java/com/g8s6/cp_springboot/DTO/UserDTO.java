package com.g8s6.cp_springboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private int rating;

    public UserDTO(Long id, String username, String email, int rating) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.rating = rating;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public int getRating() { return rating; }
}
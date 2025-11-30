package org.acme.DTO.Response;


public class UserDTO {
    public Long id;
    public String username;
    public String email;
    public int rating;
    

    public UserDTO() {}

    public UserDTO(Long id, String username, String email, int rating) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.rating = rating;
    }
}

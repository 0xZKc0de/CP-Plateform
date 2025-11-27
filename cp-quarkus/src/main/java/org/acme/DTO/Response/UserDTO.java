package org.acme.DTO.Response;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class UserDTO {
    public Long id;
    public String username;
    public String email;
    public int rating;
}

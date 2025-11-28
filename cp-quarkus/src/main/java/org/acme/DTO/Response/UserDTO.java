package org.acme.DTO.Response;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    public Long id;
    public String username;
    public String email;
    public int rating;
    
}

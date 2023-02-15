package mk.ukim.finki.tech_prototype.Model.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}

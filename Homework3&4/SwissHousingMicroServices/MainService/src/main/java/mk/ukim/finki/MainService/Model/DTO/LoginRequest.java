package mk.ukim.finki.MainService.Model.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}

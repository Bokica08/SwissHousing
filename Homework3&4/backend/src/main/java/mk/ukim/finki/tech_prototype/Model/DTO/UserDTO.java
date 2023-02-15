package mk.ukim.finki.tech_prototype.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.tech_prototype.Model.Enumeration.Role;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    String username;
    String password;
    String repeatedPassword;
    String name;
    String surname;
    Role role;
}

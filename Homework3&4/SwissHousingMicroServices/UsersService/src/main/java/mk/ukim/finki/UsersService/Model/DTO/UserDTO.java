package mk.ukim.finki.UsersService.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.UsersService.Model.Enumeration.Role;

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

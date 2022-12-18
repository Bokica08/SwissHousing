package mk.ukim.finki.tech_prototype.Service;

import mk.ukim.finki.tech_prototype.Model.DTO.UserDTO;
import mk.ukim.finki.tech_prototype.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.*;

public interface UserService extends UserDetailsService {

    Optional<User> register(UserDTO userDTO);
}

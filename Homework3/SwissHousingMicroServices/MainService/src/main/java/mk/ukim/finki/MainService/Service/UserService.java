package mk.ukim.finki.MainService.Service;

import mk.ukim.finki.MainService.Model.DTO.UserDTO;
import mk.ukim.finki.MainService.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    Optional<User> register(UserDTO userDTO);
}

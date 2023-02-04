package mk.ukim.finki.UsersService.Service;

import mk.ukim.finki.UsersService.Model.DTO.UserDTO;
import mk.ukim.finki.UsersService.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    Optional<User> register(UserDTO userDTO);
    Optional<User> authorizePendingAdmin(String username);
    Optional<User> addToFavourites(String username, Long locationId);
    Optional<User> addToVisited(String username, Long locationId);
    List<User> findAllPendingAdmins();
    Optional<User> getUser(String username);
}

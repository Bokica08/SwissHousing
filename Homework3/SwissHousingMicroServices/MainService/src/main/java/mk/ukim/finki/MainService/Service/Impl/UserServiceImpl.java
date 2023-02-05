package mk.ukim.finki.MainService.Service.Impl;

import mk.ukim.finki.MainService.FeignClient.UsersServiceRegisterClient;
import mk.ukim.finki.MainService.FeignClient.UsersServiceUsersClient;
import mk.ukim.finki.MainService.Model.DTO.UserDTO;
import mk.ukim.finki.MainService.Model.User;
import mk.ukim.finki.MainService.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UsersServiceUsersClient usersClient;
    private final UsersServiceRegisterClient registerClient;

    public UserServiceImpl(UsersServiceUsersClient usersClient, UsersServiceRegisterClient registerClient) {
        this.usersClient = usersClient;
        this.registerClient = registerClient;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResponseEntity<User> response=usersClient.getUserByUsername(username);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        throw new UsernameNotFoundException(username);
    }

    @Override
    public Optional<User> register(UserDTO userDTO) {
        ResponseEntity<User> response=registerClient.register(userDTO);
        if (response.getStatusCode().is2xxSuccessful()) {
            return Optional.ofNullable(response.getBody());
        }
        return Optional.empty();
    }


}

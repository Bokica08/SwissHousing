package mk.ukim.finki.MainService.Service.Impl;

import mk.ukim.finki.MainService.FeignClient.LocationsServiceLocationClient;
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
    private final LocationsServiceLocationClient locationClient;

    public UserServiceImpl(UsersServiceUsersClient usersClient, UsersServiceRegisterClient registerClient, LocationsServiceLocationClient locationClient) {
        this.usersClient = usersClient;
        this.registerClient = registerClient;
        this.locationClient = locationClient;
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

    @Override
    public Optional<User> getUser(String username) {
        ResponseEntity<User> response=usersClient.getUserByUsername(username);
        if (response.getStatusCode().is2xxSuccessful()) {
            User user=response.getBody();
            user.setFavourites(user.getFavourites().stream().map(l-> locationClient.findById(l.getLocationId()).get()).toList());
            user.setVisited(user.getVisited().stream().map(l-> locationClient.findById(l.getLocationId()).get()).toList());
            return Optional.of(user);
        }
        throw new UsernameNotFoundException(username);
    }
    /**
     * NOTE:
     * The users service stores only the ids of the favourites and visited locations.
     * So we need to invoke the locations service to get the full information about these locations.
     */


}

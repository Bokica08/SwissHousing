package mk.ukim.finki.UsersService.Service.Impl;

import mk.ukim.finki.UsersService.Model.DTO.UserDTO;
import mk.ukim.finki.UsersService.Model.Enumeration.Role;
import mk.ukim.finki.UsersService.Model.Exception.InvalidArgumentsException;
import mk.ukim.finki.UsersService.Model.Exception.LocationNotFoundException;
import mk.ukim.finki.UsersService.Model.Exception.PasswordsDoNotMatchException;
import mk.ukim.finki.UsersService.Model.Exception.UsernameAlreadyExistsException;
import mk.ukim.finki.UsersService.Model.Location;
import mk.ukim.finki.UsersService.Model.User;
import mk.ukim.finki.UsersService.Repository.LocationRepository;
import mk.ukim.finki.UsersService.Repository.UserRepository;
import mk.ukim.finki.UsersService.Service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LocationRepository locationRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.locationRepository = locationRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
    }

    @Override
    public Optional<User> register(UserDTO userDTO) {
        if (userDTO.getUsername()==null || userDTO.getUsername().isEmpty()  || userDTO.getPassword()==null || userDTO.getPassword().isEmpty())
            throw new InvalidArgumentsException();
        if (!userDTO.getPassword().equals(userDTO.getRepeatedPassword()))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(userDTO.getUsername()).isPresent())
            throw new UsernameAlreadyExistsException(userDTO.getUsername());
        User user = new User(userDTO.getUsername(), userDTO.getName(), userDTO.getSurname(), passwordEncoder.encode(userDTO.getPassword()), userDTO.getRole());
        return Optional.of(userRepository.save(user));
    }

    /**
        Each admin must be checked by an already registered admin(and checked) in order to have the admin capabilities.
        Until that, these users are registered with the role PENDING_ADMIN.
        This serves as protection against unwanted adding and editing of locations by invalid admins.
     */
    @Override
    @Transactional
    public Optional<User> authorizePendingAdmin(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
        if(!user.getRole().equals(Role.ROLE_PENDING_ADMIN))
        {
            throw new InvalidArgumentsException();
        }
        user.setRole(Role.ROLE_ADMIN);
        return Optional.of(userRepository.save(user));
    }

    @Override
    @Transactional
    public Optional<User> addToFavourites(String username, Long locationId) {
        User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
        Location location = locationRepository.findById(locationId).orElseThrow(LocationNotFoundException::new);
        if(user.getFavourites().stream().anyMatch(l->l.getLocationId().equals(locationId)))
        {
            return Optional.of(userRepository.save(user));
        }
        user.getFavourites().add(location);
        return Optional.of(userRepository.save(user));
    }

    @Override
    @Transactional
    public Optional<User> addToVisited(String username, Long locationId) {
        User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
        Location location = locationRepository.findById(locationId).orElseThrow(LocationNotFoundException::new);
        if(user.getVisited().stream().anyMatch(l->l.getLocationId().equals(locationId)))
        {
            return Optional.of(userRepository.save(user));
        }
        user.getVisited().add(location);
        return Optional.of(userRepository.save(user));
    }

    @Override
    public List<User> findAllPendingAdmins() {
        return userRepository.findAllByRole(Role.ROLE_PENDING_ADMIN);
    }

    @Override
    public Optional<User> getUser(String username){
        User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
        return Optional.of(user);
    }

}

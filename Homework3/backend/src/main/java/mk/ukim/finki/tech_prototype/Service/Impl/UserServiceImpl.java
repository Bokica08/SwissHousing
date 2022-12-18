package mk.ukim.finki.tech_prototype.Service.Impl;

import mk.ukim.finki.tech_prototype.Model.DTO.UserDTO;
import mk.ukim.finki.tech_prototype.Model.Enumeration.Role;
import mk.ukim.finki.tech_prototype.Model.Exception.InvalidArgumentsException;
import mk.ukim.finki.tech_prototype.Model.Exception.PasswordsDoNotMatchException;
import mk.ukim.finki.tech_prototype.Model.Exception.UsernameAlreadyExistsException;
import mk.ukim.finki.tech_prototype.Model.User;
import mk.ukim.finki.tech_prototype.Repository.UserRepository;
import mk.ukim.finki.tech_prototype.Service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
        User user = new User(userDTO.getUsername(),passwordEncoder.encode(userDTO.getPassword()), userDTO.getName(), userDTO.getSurname(), userDTO.getRole());
        return Optional.of(userRepository.save(user));
    }


}

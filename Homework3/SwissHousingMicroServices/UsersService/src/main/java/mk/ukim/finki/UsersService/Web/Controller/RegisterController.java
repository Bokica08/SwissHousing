package mk.ukim.finki.UsersService.Web.Controller;

import mk.ukim.finki.UsersService.Model.DTO.UserDTO;
import mk.ukim.finki.UsersService.Model.User;
import mk.ukim.finki.UsersService.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody UserDTO userDto) {
        return this.userService.register(userDto)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
}

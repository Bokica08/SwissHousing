package mk.ukim.finki.MainService.Web.Controller;

import mk.ukim.finki.MainService.Model.DTO.UserDTO;
import mk.ukim.finki.MainService.Model.User;
import mk.ukim.finki.MainService.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", maxAge = 3600)
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

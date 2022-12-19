package mk.ukim.finki.tech_prototype.Web.Controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.tech_prototype.Model.*;
import mk.ukim.finki.tech_prototype.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/pending/authorizeAdmin")
    public ResponseEntity<User> authorizeAdmin(@RequestParam String username)
    {
        return this.userService.authorizePendingAdmin(username)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @GetMapping("/pending")
    public List<User> findPendingAdmins()
    {
        return userService.findAllPendingAdmins();
    }
    
    @GetMapping("/user/addFavourite/{id}")
    public ResponseEntity<User> addFavourite(@PathVariable Long id, HttpServletRequest request)
    {
        return this.userService.addToFavourites(request.getRemoteUser(), id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @GetMapping("/user/addVisited/{id}")
    public ResponseEntity<User> addVisited(@PathVariable Long id, HttpServletRequest request)
    {
        return this.userService.addToVisited(request.getRemoteUser(), id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

}

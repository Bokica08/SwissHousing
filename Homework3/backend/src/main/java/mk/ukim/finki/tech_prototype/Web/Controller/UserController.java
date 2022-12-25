package mk.ukim.finki.tech_prototype.Web.Controller;

import javax.servlet.http.HttpServletRequest;
import mk.ukim.finki.tech_prototype.Model.*;
import mk.ukim.finki.tech_prototype.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", maxAge = 3600)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
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
    
    @GetMapping("/addFavourite/{id}")
    public ResponseEntity<User> addFavourite(@PathVariable Long id, HttpServletRequest request)
    {
        return this.userService.addToFavourites(request.getRemoteUser(), id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @GetMapping("/addVisited/{id}")
    public ResponseEntity<User> addVisited(@PathVariable Long id, HttpServletRequest request)
    {
        return this.userService.addToVisited(request.getRemoteUser(), id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @GetMapping("/get")
    public ResponseEntity<User> getUserByUsername(@RequestParam String username){
        return this.userService.getUser(username)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

}

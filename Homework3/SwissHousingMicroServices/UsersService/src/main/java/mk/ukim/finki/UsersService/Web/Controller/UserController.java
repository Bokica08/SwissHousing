package mk.ukim.finki.UsersService.Web.Controller;

import mk.ukim.finki.UsersService.Model.*;
import mk.ukim.finki.UsersService.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**@GetMapping
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }
     todo:Implement directly in main service
     **/
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
    public ResponseEntity<User> addFavourite(@PathVariable Long id, @RequestParam String loggedUser)
    {
        return this.userService.addToFavourites(loggedUser, id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @GetMapping("/addVisited/{id}")
    public ResponseEntity<User> addVisited(@PathVariable Long id, @RequestParam String loggedUser)
    {
        return this.userService.addToVisited(loggedUser, id)
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

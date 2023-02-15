package mk.ukim.finki.MainService.Web.Controller;

import mk.ukim.finki.MainService.FeignClient.UsersServiceUsersClient;
import mk.ukim.finki.MainService.Model.*;
import mk.ukim.finki.MainService.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", maxAge = 3600)
public class UserController {

    private final UsersServiceUsersClient usersClient;
    private final UserService userService;

    public UserController(UsersServiceUsersClient usersClient, UserService userService) {
        this.usersClient = usersClient;
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
        return usersClient.authorizeAdmin(username);
    }

    @GetMapping("/pending")
    public List<User> findPendingAdmins()
    {
        return usersClient.findPendingAdmins();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
    @GetMapping("/addFavourite/{id}")
    public ResponseEntity<User> addFavourite(@PathVariable Long id, HttpServletRequest request)
    {
        return usersClient.addFavourite(id, request.getRemoteUser());
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
    @GetMapping("/addVisited/{id}")
    public ResponseEntity<User> addVisited(@PathVariable Long id, HttpServletRequest request)
    {
        return usersClient.addVisited(id, request.getRemoteUser());
    }

    @GetMapping("/get")
    public ResponseEntity<User> getUserByUsername(@RequestParam String username){
        return userService.getUser(username)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

}

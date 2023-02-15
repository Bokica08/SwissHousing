package mk.ukim.finki.MainService.FeignClient;

import mk.ukim.finki.MainService.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name="usersServiceUsers", url="localhost:8180")
public interface UsersServiceUsersClient {
    @GetMapping("/user/pending/authorizeAdmin")
    ResponseEntity<User> authorizeAdmin(@RequestParam("username") String username);
    @GetMapping("/user/pending")
    List<User> findPendingAdmins();
    @GetMapping("/user/addFavourite/{id}")
    ResponseEntity<User> addFavourite(@PathVariable(name="id") Long id, @RequestParam("loggedUser") String loggedUser);
    @GetMapping("/user/addVisited/{id}")
    ResponseEntity<User> addVisited(@PathVariable(name="id") Long id, @RequestParam("loggedUser") String loggedUser);
    @GetMapping("/user/get")
    ResponseEntity<User> getUserByUsername(@RequestParam("username") String username);
}

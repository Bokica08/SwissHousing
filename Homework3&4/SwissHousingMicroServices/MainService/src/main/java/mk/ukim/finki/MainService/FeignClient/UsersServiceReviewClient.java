package mk.ukim.finki.MainService.FeignClient;

import mk.ukim.finki.MainService.Model.DTO.ReviewDTO;
import mk.ukim.finki.MainService.Model.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="usersServiceReviews", url="localhost:8180")
public interface UsersServiceReviewClient {
    @GetMapping("/review/location")
    List<Review> findByLocation(@RequestParam("locationId") Long locationId);
    @GetMapping("/review/reviewer")
    List<Review> findByReviewer(@RequestParam("username") String username);
    @GetMapping("/review/reviewer/user")
    List<Review> findByLoggedUser(@RequestParam("loggedUser") String loggedUser);
    @GetMapping("/review/{id}")
    public Optional<Review> findById(@PathVariable("id") Long id);
    @PostMapping("/review/edit/{id}")
    ResponseEntity<Review> edit(@PathVariable("id") Long id, @RequestBody ReviewDTO reviewDTO, @RequestParam("loggedUser") String loggedUser);
    @PostMapping("/review/add")
    ResponseEntity<Review> save(@RequestBody ReviewDTO reviewDTO, @RequestParam("loggedUser") String loggedUser);
    @DeleteMapping("/review/delete/{id}")
    ResponseEntity deleteById(@PathVariable("id") Long id);
}

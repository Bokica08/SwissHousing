package mk.ukim.finki.UsersService.Web.Controller;

import mk.ukim.finki.UsersService.Model.DTO.ReviewDTO;
import mk.ukim.finki.UsersService.Model.Review;
import mk.ukim.finki.UsersService.Service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/location")
    public List<Review> findByLocation(@RequestParam Long locationId)
    {
        return reviewService.findByLocation(locationId);
    }
    @GetMapping("/reviewer")
    public List<Review> findByReviewer(@RequestParam String username)
    {
        return reviewService.findByReviewer(username);
    }
    @GetMapping("/reviewer/user")
    public List<Review> findByLoggedUser(@RequestParam String loggedUser)
    {
        return reviewService.findByReviewer(loggedUser);
    }
    @GetMapping("/{id}")
    public Optional<Review> findById(@PathVariable Long id)
    {
        return reviewService.findById(id);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<Review> edit(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO, @RequestParam String loggedUser)
    {
        return this.reviewService.edit(id,reviewDTO, loggedUser)
                .map(review -> ResponseEntity.ok().body(review))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PostMapping("/add")
    public ResponseEntity<Review> save(@RequestBody ReviewDTO reviewDTO, @RequestParam String loggedUser)
    {
        return this.reviewService.post(reviewDTO, loggedUser)
                .map(review -> ResponseEntity.ok().body(review))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id)
    {
        this.reviewService.deleteById(id);
        if(this.reviewService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();

    }
}

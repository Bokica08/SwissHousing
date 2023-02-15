package mk.ukim.finki.tech_prototype.Web.Controller;
import javax.servlet.http.HttpServletRequest;

import mk.ukim.finki.tech_prototype.Model.DTO.ListReviewsDTO;
import mk.ukim.finki.tech_prototype.Model.DTO.ReviewDTO;
import mk.ukim.finki.tech_prototype.Model.Review;
import mk.ukim.finki.tech_prototype.Service.ReviewService;
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
    public List<Review> findByLoggedUser(HttpServletRequest request)
    {
        return reviewService.findByReviewer(request.getRemoteUser());
    }
    @GetMapping("/{id}")
    public Optional<Review> findById(@PathVariable Long id)
    {
        return reviewService.findById(id);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<Review> edit(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO, HttpServletRequest request)
    {
        return this.reviewService.edit(id,reviewDTO, request.getRemoteUser())
                .map(review -> ResponseEntity.ok().body(review))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PostMapping("/add")
    public ResponseEntity<Review> save(@RequestBody ReviewDTO reviewDTO, HttpServletRequest request)
    {
        return this.reviewService.post(reviewDTO, request.getRemoteUser())
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

package mk.ukim.finki.tech_prototype.Web.Controller;
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
    public List<Review> findByReviewer(@RequestParam String name,@RequestParam String surname)
    {
        return reviewService.findByReviewer(name,surname);
    }
    @GetMapping("/{id}")
    public Optional<Review> findById(@PathVariable Long id)
    {
        return reviewService.findById(id);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<Review> edit(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO)
    {
        return this.reviewService.edit(id,reviewDTO)
                .map(review -> ResponseEntity.ok().body(review))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PostMapping("/add")
    public ResponseEntity<Review> save(@RequestBody ReviewDTO reviewDTO)
    {
        return this.reviewService.post(reviewDTO)
                .map(review -> ResponseEntity.ok().body(review))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }
    @DeleteMapping("/delte/{id}")
    public ResponseEntity deleteById(@PathVariable Long id)
    {
        this.reviewService.deleteById(id);
        if(this.reviewService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();

    }
}

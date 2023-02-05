package mk.ukim.finki.MainService.Web.Controller;

import mk.ukim.finki.MainService.FeignClient.UsersServiceReviewClient;
import mk.ukim.finki.MainService.Model.DTO.ReviewDTO;
import mk.ukim.finki.MainService.Model.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final UsersServiceReviewClient reviewClient;

    public ReviewController(UsersServiceReviewClient reviewClient) {
        this.reviewClient = reviewClient;
    }

    @GetMapping("/location")
    public List<Review> findByLocation(@RequestParam Long locationId)
    {
        return reviewClient.findByLocation(locationId);
    }
    @GetMapping("/reviewer")
    public List<Review> findByReviewer(@RequestParam String username)
    {
        return reviewClient.findByReviewer(username);
    }
    @GetMapping("/reviewer/user")
    public List<Review> findByLoggedUser(HttpServletRequest request)
    {
        return reviewClient.findByLoggedUser(request.getRemoteUser());
    }
    @GetMapping("/{id}")
    public Optional<Review> findById(@PathVariable Long id)
    {
        return reviewClient.findById(id);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<Review> edit(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO, HttpServletRequest request)
    {
        return reviewClient.edit(id, reviewDTO, request.getRemoteUser());
    }
    @PostMapping("/add")
    public ResponseEntity<Review> save(@RequestBody ReviewDTO reviewDTO, HttpServletRequest request)
    {
        return reviewClient.save(reviewDTO, request.getRemoteUser());

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id)
    {
        return reviewClient.deleteById(id);

    }
}

package mk.ukim.finki.UsersService.Service;

import mk.ukim.finki.UsersService.Model.DTO.ReviewDTO;
import mk.ukim.finki.UsersService.Model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> post(String text, String username, Long locationId, int grade);
    Optional<Review> post(ReviewDTO reviewDto, String username);
    List<Review> findByLocation(Long locationId);
    List<Review> findByReviewer(String username);
    Optional<Review> findById(Long id);
    Optional<Review> edit(Long id, String text, String username, Long locationId, int grade);
    Optional<Review> edit(Long id, ReviewDTO reviewDTO, String username);
    void deleteById(Long id);
}

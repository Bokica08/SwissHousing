package mk.ukim.finki.tech_prototype.Service;

import mk.ukim.finki.tech_prototype.Model.DTO.ReviewDTO;
import mk.ukim.finki.tech_prototype.Model.Review;
import java.util.*;

public interface ReviewService {
    Optional<Review> post(String text, String username, Long locationId, int grade);
    Optional<Review> post(ReviewDTO reviewDto);
    List<Review> findByLocation(Long locationId);
    List<Review> findByReviewer(String username);
    Optional<Review> findById(Long id);
    Optional<Review> edit(Long id, String text, String username, Long locationId, int grade);
    Optional<Review> edit(Long id, ReviewDTO reviewDTO);
    void deleteById(Long id);
}

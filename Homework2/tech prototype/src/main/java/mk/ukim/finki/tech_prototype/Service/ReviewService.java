package mk.ukim.finki.tech_prototype.Service;

import mk.ukim.finki.tech_prototype.Model.DTO.ReviewDTO;
import mk.ukim.finki.tech_prototype.Model.Review;
import java.util.*;

public interface ReviewService {
    Optional<Review> post(String text, String reviewerName, String reviewerSurname, Long locationId);
    Optional<Review> post(ReviewDTO reviewDto);
    List<Review> findByLocation(Long locationId);
    List<Review> findByReviewer(String name, String surname);
    Optional<Review> findById(Long id);
    Optional<Review> edit(Long id, String text, String reviewerName, String reviewerSurname, Long locationId);
    Optional<Review> edit(Long id, ReviewDTO reviewDTO);
    void deleteById(Long id);
}

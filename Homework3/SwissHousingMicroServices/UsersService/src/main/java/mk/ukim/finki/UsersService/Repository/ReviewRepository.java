package mk.ukim.finki.UsersService.Repository;


import mk.ukim.finki.UsersService.Model.Review;
import mk.ukim.finki.UsersService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewsByLocation_LocationId(Long id);
    List<Review> findAllByReviewer(User reviewer);
}

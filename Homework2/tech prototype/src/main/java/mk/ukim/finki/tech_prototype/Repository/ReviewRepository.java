package mk.ukim.finki.tech_prototype.Repository;

import mk.ukim.finki.tech_prototype.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}

package mk.ukim.finki.tech_prototype.Repository;

import mk.ukim.finki.tech_prototype.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findHotelsByNameContainingIgnoreCase(String city);
    Optional<Hotel> findHotelByNameIgnoreCase(String city);
    List<Hotel> findHotelsByCityIgnoreCase(String city);
    List<Hotel> findHotelsByStars(int stars);
}

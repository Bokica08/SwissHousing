package mk.ukim.finki.LocationsService.Repository;

import mk.ukim.finki.LocationsService.Model.GuestHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestHouseRepository extends JpaRepository<GuestHouse, Long> {
    List<GuestHouse> findGuestHousesByNameContainingIgnoreCase(String name);
    Optional<GuestHouse> findGuestHouseByNameIgnoreCase(String name);
    List<GuestHouse> findGuestHousesByCityIgnoreCase(String city);
}

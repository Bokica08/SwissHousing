package mk.ukim.finki.LocationsService.Repository;

import mk.ukim.finki.LocationsService.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}

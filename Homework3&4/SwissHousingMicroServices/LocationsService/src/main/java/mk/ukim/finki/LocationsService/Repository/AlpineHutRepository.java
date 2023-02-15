package mk.ukim.finki.LocationsService.Repository;

import mk.ukim.finki.LocationsService.Model.AlpineHut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlpineHutRepository extends JpaRepository<AlpineHut, Long> {
    List<AlpineHut> findAlpineHutsByNameContainingIgnoreCase(String name);
    Optional<AlpineHut> findAlpineHutByNameIgnoreCase(String name);
    List<AlpineHut> findAlpineHutsByCityIgnoreCase(String city);
}

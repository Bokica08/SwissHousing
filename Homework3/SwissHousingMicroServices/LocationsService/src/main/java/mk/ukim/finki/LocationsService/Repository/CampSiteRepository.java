package mk.ukim.finki.LocationsService.Repository;

import mk.ukim.finki.LocationsService.Model.CampSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampSiteRepository extends JpaRepository<CampSite, Long> {
    List<CampSite> findCampSitesByNameContainingIgnoreCase(String name);
    Optional<CampSite> findCampSiteByNameIgnoreCase(String name);
    List<CampSite> findCampSitesByCityIgnoreCase(String city);
}

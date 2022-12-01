package mk.ukim.finki.tech_prototype.Repository;

import mk.ukim.finki.tech_prototype.Model.CampSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampSiteRepository extends JpaRepository<CampSite, Long> {
}

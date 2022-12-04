package mk.ukim.finki.tech_prototype.Repository;

import mk.ukim.finki.tech_prototype.Model.AlpineHut;
import org.springframework.data.domain.Sort;
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

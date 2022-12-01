package mk.ukim.finki.tech_prototype.Repository;

import mk.ukim.finki.tech_prototype.Model.AlpineHut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlpineHutRepository extends JpaRepository<AlpineHut, Long> {
}

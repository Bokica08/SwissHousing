package mk.ukim.finki.tech_prototype.Service;

import mk.ukim.finki.tech_prototype.Model.Location;
import mk.ukim.finki.tech_prototype.Model.Review;

import java.util.*;

public interface LocationService {
    void deleteById(Long id);
    Optional<Location>addGrade(Long id, int g);
    Optional<Location> findById(Long id);
}

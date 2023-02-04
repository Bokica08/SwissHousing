package mk.ukim.finki.LocationsService.Service;

import mk.ukim.finki.LocationsService.Model.Location;

import java.util.Optional;

public interface LocationService {
    void deleteById(Long id);
    double getGradeForLocation(Long id);
    Optional<Location> findById(Long id);
}

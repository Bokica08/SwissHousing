package mk.ukim.finki.UsersService.Service;

import mk.ukim.finki.UsersService.Model.Location;

import java.util.Optional;

public interface LocationService {
    void deleteById(Long id);
    double getGradeForLocation(Long id);
    Optional<Location> findById(Long id);
    Optional<Location> create(Long id);
}

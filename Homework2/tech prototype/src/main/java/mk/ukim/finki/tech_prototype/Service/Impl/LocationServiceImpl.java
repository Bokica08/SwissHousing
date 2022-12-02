package mk.ukim.finki.tech_prototype.Service.Impl;

import mk.ukim.finki.tech_prototype.Model.Exception.InvalidArgumentsException;
import mk.ukim.finki.tech_prototype.Model.Location;
import mk.ukim.finki.tech_prototype.Repository.LocationRepository;
import mk.ukim.finki.tech_prototype.Service.LocationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public Optional<Location> addGrade(Long id, int g) {
        Location location = locationRepository.findById(id).orElseThrow(InvalidArgumentsException::new);
        double grades=location.getRating();
        grades+=g;
        int num= location.getNumOfRatings();
        num++;
        location.setRating(grades);
        location.setNumOfRatings(num);
        return Optional.of(locationRepository.save(location));
    }
}

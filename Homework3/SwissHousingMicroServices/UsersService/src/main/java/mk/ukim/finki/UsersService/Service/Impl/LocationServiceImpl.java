package mk.ukim.finki.UsersService.Service.Impl;

import mk.ukim.finki.UsersService.Model.Location;
import mk.ukim.finki.UsersService.Model.Review;
import mk.ukim.finki.UsersService.Repository.LocationRepository;
import mk.ukim.finki.UsersService.Repository.ReviewRepository;
import mk.ukim.finki.UsersService.Service.LocationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final ReviewRepository reviewRepository;

    public LocationServiceImpl(LocationRepository locationRepository, ReviewRepository reviewRepository) {
        this.locationRepository = locationRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }

    public double getGradeForLocation(Long id)
    {
        if(reviewRepository.findReviewsByLocation_LocationId(id).size()==0)
            return 0;
        return reviewRepository.findReviewsByLocation_LocationId(id).stream().mapToDouble(Review::getGrade).average().orElse(0);
    }

    @Override
    public Optional<Location> findById(Long id) {

            return locationRepository.findById(id);
    }

    @Override
    public Optional<Location> create(Long id) {
        return Optional.of(locationRepository.save(new Location(id)));
    }
}

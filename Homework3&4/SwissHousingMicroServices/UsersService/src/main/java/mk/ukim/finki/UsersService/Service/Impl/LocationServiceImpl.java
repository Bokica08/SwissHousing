package mk.ukim.finki.UsersService.Service.Impl;

import mk.ukim.finki.UsersService.Model.Location;
import mk.ukim.finki.UsersService.Model.Review;
import mk.ukim.finki.UsersService.Repository.LocationRepository;
import mk.ukim.finki.UsersService.Repository.ReviewRepository;
import mk.ukim.finki.UsersService.Repository.UserRepository;
import mk.ukim.finki.UsersService.Service.LocationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public LocationServiceImpl(LocationRepository locationRepository, ReviewRepository reviewRepository, UserRepository userRepository) {
        this.locationRepository = locationRepository;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.findAll().forEach(user -> user.getFavourites().removeIf(l->l.getLocationId().equals(id)));
        userRepository.findAll().forEach(user -> user.getVisited().removeIf(l->l.getLocationId().equals(id)));
        reviewRepository.deleteAllByLocationLocationId(id);
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

package mk.ukim.finki.tech_prototype.Service.Impl;

import mk.ukim.finki.tech_prototype.Model.DTO.ListReviewsDTO;
import mk.ukim.finki.tech_prototype.Model.DTO.ReviewDTO;
import mk.ukim.finki.tech_prototype.Model.Exception.InvalidArgumentsException;
import mk.ukim.finki.tech_prototype.Model.Location;
import mk.ukim.finki.tech_prototype.Model.Review;
import mk.ukim.finki.tech_prototype.Model.User;
import mk.ukim.finki.tech_prototype.Repository.LocationRepository;
import mk.ukim.finki.tech_prototype.Repository.ReviewRepository;
import mk.ukim.finki.tech_prototype.Repository.UserRepository;
import mk.ukim.finki.tech_prototype.Service.ReviewService;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    public ReviewServiceImp(ReviewRepository reviewRepository, LocationRepository locationRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Review> post(String text, String username, Long locationId, int grade) {
        Location location = locationRepository.findById(locationId).orElseThrow(InvalidArgumentsException::new);
        User user = userRepository.findByUsername(username).orElseThrow(InvalidArgumentsException::new);
        return Optional.of(reviewRepository.save(new Review(text, user, location, grade)));
    }

    @Override
    public Optional<Review> post(ReviewDTO reviewDto, String username) {
        Location location = locationRepository.findById(reviewDto.getLocationId()).orElseThrow(InvalidArgumentsException::new);
        User user = userRepository.findByUsername(username).orElseThrow(InvalidArgumentsException::new);
        return Optional.of(reviewRepository.save(new Review(reviewDto.getText(), user, location, reviewDto.getGrade())));
    }

    @Override
    public List<Review> findByLocation(Long locationId) {
        return reviewRepository.findReviewsByLocation_LocationId(locationId);
    }

    @Override
    public List<Review> findByReviewer(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(InvalidArgumentsException::new);
        return reviewRepository.findAllByReviewer(user);
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Optional<Review> edit(Long id, String text, String username, Long locationId, int grade) {
        Review review = reviewRepository.findById(id).orElseThrow(InvalidArgumentsException::new);
        review.setText(text);
        User user = userRepository.findByUsername(username).orElseThrow(InvalidArgumentsException::new);
        review.setReviewer(user);
        Location location = locationRepository.findById(locationId).orElseThrow(InvalidArgumentsException::new);
        review.setLocation(location);
        review.setGrade(grade);
        return Optional.of(reviewRepository.save(review));
    }

    @Override
    public Optional<Review> edit(Long id, ReviewDTO reviewDTO, String username) {
        Review review = reviewRepository.findById(id).orElseThrow(InvalidArgumentsException::new);
        review.setText(reviewDTO.getText());
        User user = userRepository.findByUsername(username).orElseThrow(InvalidArgumentsException::new);
        review.setReviewer(user);
        Location location = locationRepository.findById(reviewDTO.getLocationId()).orElseThrow(InvalidArgumentsException::new);
        review.setLocation(location);
        review.setGrade(review.getGrade());
        return Optional.of(reviewRepository.save(review));
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}

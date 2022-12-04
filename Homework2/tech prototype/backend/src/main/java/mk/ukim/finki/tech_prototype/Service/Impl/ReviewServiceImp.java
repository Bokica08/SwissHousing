package mk.ukim.finki.tech_prototype.Service.Impl;

import mk.ukim.finki.tech_prototype.Model.DTO.ReviewDTO;
import mk.ukim.finki.tech_prototype.Model.Exception.InvalidArgumentsException;
import mk.ukim.finki.tech_prototype.Model.Location;
import mk.ukim.finki.tech_prototype.Model.Review;
import mk.ukim.finki.tech_prototype.Repository.LocationRepository;
import mk.ukim.finki.tech_prototype.Repository.ReviewRepository;
import mk.ukim.finki.tech_prototype.Service.ReviewService;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final LocationRepository locationRepository;

    public ReviewServiceImp(ReviewRepository reviewRepository, LocationRepository locationRepository) {
        this.reviewRepository = reviewRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Optional<Review> post(String text, String reviewerName, String reviewerSurname, Long locationId) {
        Location location = locationRepository.findById(locationId).orElseThrow(InvalidArgumentsException::new);
        return Optional.of(reviewRepository.save(new Review(text, reviewerName, reviewerSurname, location)));
    }

    @Override
    public Optional<Review> post(ReviewDTO reviewDto) {
        Location location = locationRepository.findById(reviewDto.getLocation().getLocationId()).orElseThrow(InvalidArgumentsException::new);
        return Optional.of(reviewRepository.save(new Review(reviewDto.getText(), reviewDto.getReviewerName(), reviewDto.getReviewerSurname(), location)));
    }

    @Override
    public List<Review> findByLocation(Long locationId) {
        return reviewRepository.findReviewsByLocation_LocationId(locationId);
    }

    @Override
    public List<Review> findByReviewer(String name, String surname) {
        return reviewRepository.findReviewsByReviewerNameAndReviewerSurname(name, surname);
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Optional<Review> edit(Long id, String text, String reviewerName, String reviewerSurname, Long locationId) {
        Review review = reviewRepository.findById(id).orElseThrow(InvalidArgumentsException::new);
        review.setText(text);
        review.setReviewerName(reviewerName);
        review.setReviewerSurname(reviewerSurname);
        Location location = locationRepository.findById(locationId).orElseThrow(InvalidArgumentsException::new);
        review.setLocation(location);
        return Optional.of(reviewRepository.save(review));
    }

    @Override
    public Optional<Review> edit(Long id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id).orElseThrow(InvalidArgumentsException::new);
        review.setText(reviewDTO.getText());
        review.setReviewerName(reviewDTO.getReviewerName());
        review.setReviewerSurname(reviewDTO.getReviewerSurname());
        Location location = locationRepository.findById(reviewDTO.getLocation().getLocationId()).orElseThrow(InvalidArgumentsException::new);
        review.setLocation(location);
        return Optional.of(reviewRepository.save(review));
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}

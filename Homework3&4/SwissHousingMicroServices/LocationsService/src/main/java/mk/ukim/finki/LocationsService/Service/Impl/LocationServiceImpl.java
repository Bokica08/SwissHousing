package mk.ukim.finki.LocationsService.Service.Impl;

import mk.ukim.finki.LocationsService.FeignClient.UsersServiceLocationClient;
import mk.ukim.finki.LocationsService.Model.Location;
import mk.ukim.finki.LocationsService.Repository.LocationRepository;
import mk.ukim.finki.LocationsService.Service.LocationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final UsersServiceLocationClient locationClient;


    public LocationServiceImpl(LocationRepository locationRepository, UsersServiceLocationClient locationClient) {
        this.locationRepository = locationRepository;
        this.locationClient = locationClient;
    }

    @Override
    public void deleteById(Long id) {
        locationRepository.deleteById(id);
        locationClient.deleteById(id);
    }

    public double getGradeForLocation(Long id)
    {
        return locationClient.getGrade(id);
    }

    @Override
    public Optional<Location> findById(Long id) {

            return locationRepository.findById(id);
    }
}

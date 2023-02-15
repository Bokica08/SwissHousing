package mk.ukim.finki.LocationsService.Service;

import mk.ukim.finki.LocationsService.Model.DTO.GuestHouseDTO;
import mk.ukim.finki.LocationsService.Model.GuestHouse;

import java.util.List;
import java.util.Optional;

public interface GuestHouseService {
    Optional<GuestHouse> post(Double x, Double y, String name, String city, String street, String houseNumber, String phoneNumber);
    Optional<GuestHouse> post(GuestHouseDTO guestHouseDTO);
    List<GuestHouse> findAll();
    Optional<GuestHouse> findById(Long id);
    Optional<GuestHouse> edit(Long id, Double x, Double y, String name, String city, String street, String houseNumber, String phoneNumber, String description, String imagePath);
    Optional<GuestHouse> edit(Long id, GuestHouseDTO guestHouseDTO);
    Optional<GuestHouse> findByName(String name);
    List<GuestHouse> findAllContainingName(String name);
    List<GuestHouse> findByCity(String city);
}

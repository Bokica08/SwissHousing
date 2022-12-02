package mk.ukim.finki.tech_prototype.Service;

import mk.ukim.finki.tech_prototype.Model.DTO.GuestHouseDTO;
import mk.ukim.finki.tech_prototype.Model.GuestHouse;
import java.util.*;

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

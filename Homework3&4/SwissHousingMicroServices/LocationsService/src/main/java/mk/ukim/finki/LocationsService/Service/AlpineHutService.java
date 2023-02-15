package mk.ukim.finki.LocationsService.Service;

import mk.ukim.finki.LocationsService.Model.AlpineHut;
import mk.ukim.finki.LocationsService.Model.DTO.AlpineHutDTO;

import java.util.List;
import java.util.Optional;

public interface AlpineHutService {
    Optional<AlpineHut> post(Double x, Double y, String name, String city, String street, String houseNumber, int elevation);
    Optional<AlpineHut> post(AlpineHutDTO alpineHutDTO);
    Optional<AlpineHut> findById(Long id);
    List<AlpineHut> findAll();
    Optional<AlpineHut> edit(Long id, Double x, Double y, String name, String city, String street, String houseNumber, String description, String imagePath, int elevation);
    Optional<AlpineHut> edit(Long id, AlpineHutDTO alpineHutDTO);
    List<AlpineHut> findAllContainingName(String name);
    Optional<AlpineHut> findByName(String name);
    List<AlpineHut> findByCity(String city);
}

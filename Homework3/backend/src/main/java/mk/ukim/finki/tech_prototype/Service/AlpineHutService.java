package mk.ukim.finki.tech_prototype.Service;

import mk.ukim.finki.tech_prototype.Model.AlpineHut;
import mk.ukim.finki.tech_prototype.Model.DTO.AlpineHutDTO;

import java.util.*;

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

package mk.ukim.finki.LocationsService.Service;

import mk.ukim.finki.LocationsService.Model.CampSite;
import mk.ukim.finki.LocationsService.Model.DTO.CampSiteDTO;

import java.util.List;
import java.util.Optional;

public interface CampSiteService {
    Optional<CampSite> post(Double x, Double y, String name, String city, String street, String houseNumber, String website, String phoneNumber);
    Optional<CampSite> post(CampSiteDTO campSiteDTO);
    Optional<CampSite> findById(Long id);
    List<CampSite> findAll();
    Optional<CampSite> edit(Long id, Double x, Double y, String name, String city, String street, String houseNumber, String website, String phoneNumber, String description, String imagePath);
    Optional<CampSite> edit(Long id, CampSiteDTO campSiteDTO);
    Optional<CampSite> findByName(String name);
    List<CampSite> findAllContainingName(String name);
    List<CampSite> findByCity(String city);
}

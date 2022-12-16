package mk.ukim.finki.tech_prototype.Service.Impl;

import mk.ukim.finki.tech_prototype.Model.CampSite;
import mk.ukim.finki.tech_prototype.Model.DTO.CampSiteDTO;
import mk.ukim.finki.tech_prototype.Model.Exception.InvalidArgumentsException;
import mk.ukim.finki.tech_prototype.Repository.CampSiteRepository;
import mk.ukim.finki.tech_prototype.Service.CampSiteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampSiteServiceImpl implements CampSiteService {
    private final CampSiteRepository campSiteRepository;

    public CampSiteServiceImpl(CampSiteRepository campSiteRepository) {
        this.campSiteRepository = campSiteRepository;
    }

    @Override
    public Optional<CampSite> post(Double x, Double y, String name, String city, String street, String houseNumber, String website, String phoneNumber) {
        return Optional.of(campSiteRepository.save(new CampSite(x, y, name, city, street, houseNumber, website, phoneNumber)));
    }

    @Override
    public Optional<CampSite> post(CampSiteDTO campSiteDTO) {
        CampSite campSite = new CampSite(campSiteDTO.getX(), campSiteDTO.getY(), campSiteDTO.getName(), campSiteDTO.getCity(), campSiteDTO.getStreet(), campSiteDTO.getHouseNumber(), campSiteDTO.getWebsite(), campSiteDTO.getPhoneNumber());
        if(campSiteDTO.getDescription()!=null && !campSiteDTO.getDescription().isEmpty())
        {
            campSite.setDescription(campSiteDTO.getDescription());
        }
        if(campSiteDTO.getImagePath()!=null && !campSiteDTO.getImagePath().isEmpty())
        {
            campSite.setImagePath(campSiteDTO.getImagePath());
        }
        return Optional.of(campSiteRepository.save(campSite));
    }

    @Override
    public Optional<CampSite> findById(Long id) {
        return campSiteRepository.findById(id);
    }

    @Override
    public List<CampSite> findAll() {
        return campSiteRepository.findAll();
    }

    @Override
    public Optional<CampSite> edit(Long id, Double x, Double y, String name, String city, String street, String houseNumber, String website, String phoneNumber, String description, String imagePath) {
        CampSite campSite = campSiteRepository.findById(id).orElseThrow(InvalidArgumentsException::new);
        campSite.setX(x);
        campSite.setY(y);
        campSite.setName(name);
        campSite.setCity(city);
        campSite.setStreet(street);
        campSite.setHouseNumber(houseNumber);
        campSite.setWebsite(website);
        campSite.setPhoneNumber(phoneNumber);
        if(description!=null && !description.isEmpty())
        {
            campSite.setDescription(description);
        }
        if(imagePath!=null && !imagePath.isEmpty())
        {
            campSite.setImagePath(imagePath);
        }
        return Optional.of(campSiteRepository.save(campSite));
    }

    @Override
    public Optional<CampSite> edit(Long id, CampSiteDTO campSiteDTO) {
        CampSite campSite = campSiteRepository.findById(id).orElseThrow(InvalidArgumentsException::new);
        campSite.setX(campSiteDTO.getX());
        campSite.setY(campSiteDTO.getY());
        campSite.setName(campSiteDTO.getName());
        campSite.setCity(campSiteDTO.getCity());
        campSite.setStreet(campSiteDTO.getStreet());
        campSite.setHouseNumber(campSiteDTO.getHouseNumber());
        campSite.setWebsite(campSiteDTO.getWebsite());
        campSite.setPhoneNumber(campSiteDTO.getPhoneNumber());
        if(campSiteDTO.getDescription()!=null && !campSiteDTO.getDescription().isEmpty())
        {
            campSite.setDescription(campSiteDTO.getDescription());
        }
        if(campSiteDTO.getImagePath()!=null && !campSiteDTO.getImagePath().isEmpty())
        {
            campSite.setImagePath(campSiteDTO.getImagePath());
        }
        return Optional.of(campSiteRepository.save(campSite));
    }

    @Override
    public Optional<CampSite> findByName(String name) {
        return campSiteRepository.findCampSiteByNameIgnoreCase(name);
    }

    @Override
    public List<CampSite> findAllContainingName(String name) {
        return campSiteRepository.findCampSitesByNameContainingIgnoreCase(name);
    }

    @Override
    public List<CampSite> findByCity(String city) {
        return campSiteRepository.findCampSitesByCityIgnoreCase(city);
    }
}

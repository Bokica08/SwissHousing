package mk.ukim.finki.LocationsService.Service.Impl;

import mk.ukim.finki.LocationsService.FeignClient.UsersServiceLocationClient;
import mk.ukim.finki.LocationsService.Model.AlpineHut;
import mk.ukim.finki.LocationsService.Model.DTO.AlpineHutDTO;
import mk.ukim.finki.LocationsService.Model.Exception.InvalidArgumentsException;
import mk.ukim.finki.LocationsService.Repository.AlpineHutRepository;
import mk.ukim.finki.LocationsService.Service.AlpineHutService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlpineHutServiceImpl implements AlpineHutService {
    private final AlpineHutRepository alpineHutRepository;
    private final UsersServiceLocationClient locationClient;

    public AlpineHutServiceImpl(AlpineHutRepository alpineHutRepository, UsersServiceLocationClient locationClient) {
        this.alpineHutRepository = alpineHutRepository;
        this.locationClient = locationClient;
    }

    @Override
    public Optional<AlpineHut> post(Double x, Double y, String name, String city, String street, String houseNumber, int elevation) {
        AlpineHut alpineHut=new AlpineHut(x, y, name, city, street, houseNumber, elevation);
        alpineHut=alpineHutRepository.saveAndFlush(alpineHut);
        locationClient.saveById(alpineHut.getLocationId());
        return Optional.of(alpineHut);
    }

    @Override
    public Optional<AlpineHut> post(AlpineHutDTO alpineHutDTO) {
        AlpineHut hut = new AlpineHut(alpineHutDTO.getX(), alpineHutDTO.getY(), alpineHutDTO.getName(), alpineHutDTO.getCity(), alpineHutDTO.getStreet(), alpineHutDTO.getHouseNumber(), alpineHutDTO.getElevation());
        if(alpineHutDTO.getDescription()!=null && !alpineHutDTO.getDescription().isEmpty())
        {
            hut.setDescription(alpineHutDTO.getDescription());
        }
        if(alpineHutDTO.getImagePath()!=null && !alpineHutDTO.getImagePath().isEmpty())
        {
            hut.setImagePath(alpineHutDTO.getImagePath());
        }
        hut=alpineHutRepository.saveAndFlush(hut);
        locationClient.saveById(hut.getLocationId());
        return Optional.of(hut);
    }

    @Override
    public Optional<AlpineHut> findById(Long id) {
        return alpineHutRepository.findById(id);
    }

    @Override
    public List<AlpineHut> findAll() {
        return alpineHutRepository.findAll();
    }

    @Override
    public Optional<AlpineHut> edit(Long id, Double x, Double y, String name, String city, String street, String houseNumber, String description, String imagePath, int elevation) {
        AlpineHut hut=alpineHutRepository.findById(id).orElseThrow(InvalidArgumentsException::new);
        hut.setX(x);
        hut.setY(y);
        hut.setCity(city);
        hut.setName(name);
        hut.setStreet(street);
        hut.setHouseNumber(houseNumber);
        hut.setElevation(elevation);
        if(description!=null && !description.isEmpty())
        {
            hut.setDescription(description);
        }
        if(imagePath!=null && !imagePath.isEmpty())
        {
            hut.setImagePath(imagePath);
        }
        return Optional.of(alpineHutRepository.save(hut));
    }

    @Override
    public Optional<AlpineHut> edit(Long id, AlpineHutDTO alpineHutDTO) {
        AlpineHut hut=alpineHutRepository.findById(id).orElseThrow(InvalidArgumentsException::new);
        hut.setX(alpineHutDTO.getX());
        hut.setY(alpineHutDTO.getY());
        hut.setCity(alpineHutDTO.getCity());
        hut.setName(alpineHutDTO.getName());
        hut.setStreet(alpineHutDTO.getStreet());
        hut.setHouseNumber(alpineHutDTO.getHouseNumber());
        hut.setElevation(alpineHutDTO.getElevation());
        if(alpineHutDTO.getDescription()!=null && !alpineHutDTO.getDescription().isEmpty())
        {
            hut.setDescription(alpineHutDTO.getDescription());
        }
        if(alpineHutDTO.getImagePath()!=null && !alpineHutDTO.getImagePath().isEmpty())
        {
            hut.setImagePath(alpineHutDTO.getImagePath());
        }
        return Optional.of(alpineHutRepository.save(hut));
    }

    @Override
    public List<AlpineHut> findAllContainingName(String name) {
        return alpineHutRepository.findAlpineHutsByNameContainingIgnoreCase(name);
    }

    @Override
    public Optional<AlpineHut> findByName(String name) {
        return alpineHutRepository.findAlpineHutByNameIgnoreCase(name);
    }

    @Override
    public List<AlpineHut> findByCity(String city) {
        return alpineHutRepository.findAlpineHutsByCityIgnoreCase(city);
    }
}

package mk.ukim.finki.tech_prototype.Service.Impl;

import mk.ukim.finki.tech_prototype.Model.AlpineHut;
import mk.ukim.finki.tech_prototype.Model.DTO.AlpineHutDTO;
import mk.ukim.finki.tech_prototype.Model.Exception.InvalidArgumentsException;
import mk.ukim.finki.tech_prototype.Repository.AlpineHutRepository;
import mk.ukim.finki.tech_prototype.Service.AlpineHutService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlpineHutServiceImpl implements AlpineHutService {
    private final AlpineHutRepository alpineHutRepository;

    public AlpineHutServiceImpl(AlpineHutRepository alpineHutRepository) {
        this.alpineHutRepository = alpineHutRepository;
    }

    @Override
    public Optional<AlpineHut> post(Double x, Double y, String name, String city, String street, String houseNumber) {
        return Optional.of(alpineHutRepository.save(new AlpineHut(x, y, name, city, street, houseNumber)));
    }

    @Override
    public Optional<AlpineHut> post(AlpineHutDTO alpineHutDTO) {
        AlpineHut hut = new AlpineHut(alpineHutDTO.getX(), alpineHutDTO.getY(), alpineHutDTO.getName(), alpineHutDTO.getCity(), alpineHutDTO.getStreet(), alpineHutDTO.getHouseNumber());
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
    public Optional<AlpineHut> findById(Long id) {
        return alpineHutRepository.findById(id);
    }

    @Override
    public List<AlpineHut> findAll() {
        return alpineHutRepository.findAll();
    }

    @Override
    public Optional<AlpineHut> edit(Long id, Double x, Double y, String name, String city, String street, String houseNumber, String description, String imagePath) {
        AlpineHut hut=alpineHutRepository.findById(id).orElseThrow(InvalidArgumentsException::new);
        hut.setX(x);
        hut.setY(y);
        hut.setCity(city);
        hut.setName(name);
        hut.setStreet(street);
        hut.setHouseNumber(houseNumber);
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

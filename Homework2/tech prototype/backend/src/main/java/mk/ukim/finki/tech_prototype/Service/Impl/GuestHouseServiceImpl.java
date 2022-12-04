package mk.ukim.finki.tech_prototype.Service.Impl;

import mk.ukim.finki.tech_prototype.Model.DTO.GuestHouseDTO;
import mk.ukim.finki.tech_prototype.Model.Exception.InvalidArgumentsException;
import mk.ukim.finki.tech_prototype.Model.GuestHouse;
import mk.ukim.finki.tech_prototype.Repository.GuestHouseRepository;
import mk.ukim.finki.tech_prototype.Service.GuestHouseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestHouseServiceImpl implements GuestHouseService {
    private final GuestHouseRepository guestHouseRepository;

    public GuestHouseServiceImpl(GuestHouseRepository guestHouseRepository) {
        this.guestHouseRepository = guestHouseRepository;
    }

    @Override
    public Optional<GuestHouse> post(Double x, Double y, String name, String city, String street, String houseNumber, String phoneNumber) {
        return Optional.of(guestHouseRepository.save(new GuestHouse(x, y, name, city, street, houseNumber, phoneNumber)));
    }

    @Override
    public Optional<GuestHouse> post(GuestHouseDTO guestHouseDTO) {
        GuestHouse guestHouse = new GuestHouse(guestHouseDTO.getX(), guestHouseDTO.getY(), guestHouseDTO.getName(), guestHouseDTO.getCity(), guestHouseDTO.getStreet(), guestHouseDTO.getHouseNumber(), guestHouseDTO.getPhoneNumber());
        if(guestHouseDTO.getDescription()!=null && !guestHouseDTO.getDescription().isEmpty())
        {
            guestHouse.setDescription(guestHouseDTO.getDescription());
        }
        if(guestHouseDTO.getImagePath()!=null && !guestHouseDTO.getImagePath().isEmpty())
        {
            guestHouse.setImagePath(guestHouseDTO.getImagePath());
        }
        return Optional.of(guestHouseRepository.save(guestHouse));
    }

    @Override
    public List<GuestHouse> findAll() {
        return guestHouseRepository.findAll();
    }

    @Override
    public Optional<GuestHouse> findById(Long id) {
        return guestHouseRepository.findById(id);
    }

    @Override
    public Optional<GuestHouse> edit(Long id, Double x, Double y, String name, String city, String street, String houseNumber, String phoneNumber, String description, String imagePath) {
        GuestHouse guestHouse = guestHouseRepository.findById(id).orElseThrow(InvalidArgumentsException::new);
        guestHouse.setX(x);
        guestHouse.setY(y);
        guestHouse.setName(name);
        guestHouse.setCity(city);
        guestHouse.setStreet(street);
        guestHouse.setHouseNumber(houseNumber);
        guestHouse.setPhoneNumber(phoneNumber);
        if(description!=null && !description.isEmpty())
        {
            guestHouse.setDescription(description);
        }
        if(imagePath!=null && !imagePath.isEmpty())
        {
            guestHouse.setImagePath(imagePath);
        }
        return Optional.of(guestHouseRepository.save(guestHouse));
    }

    @Override
    public Optional<GuestHouse> edit(Long id, GuestHouseDTO guestHouseDTO) {
        GuestHouse guestHouse = guestHouseRepository.findById(id).orElseThrow(InvalidArgumentsException::new);
        guestHouse.setX(guestHouseDTO.getX());
        guestHouse.setY(guestHouseDTO.getY());
        guestHouse.setName(guestHouseDTO.getName());
        guestHouse.setCity(guestHouseDTO.getCity());
        guestHouse.setStreet(guestHouseDTO.getStreet());
        guestHouse.setHouseNumber(guestHouseDTO.getHouseNumber());
        guestHouse.setPhoneNumber(guestHouseDTO.getPhoneNumber());
        if(guestHouseDTO.getDescription()!=null && !guestHouseDTO.getDescription().isEmpty())
        {
            guestHouse.setDescription(guestHouseDTO.getDescription());
        }
        if(guestHouseDTO.getImagePath()!=null && !guestHouseDTO.getImagePath().isEmpty())
        {
            guestHouse.setImagePath(guestHouseDTO.getImagePath());
        }
        return Optional.of(guestHouseRepository.save(guestHouse));
    }

    @Override
    public Optional<GuestHouse> findByName(String name) {
        return guestHouseRepository.findGuestHouseByNameIgnoreCase(name);
    }

    @Override
    public List<GuestHouse> findAllContainingName(String name) {
        return guestHouseRepository.findGuestHousesByNameContainingIgnoreCase(name);
    }

    @Override
    public List<GuestHouse> findByCity(String city) {
        return guestHouseRepository.findGuestHousesByCityIgnoreCase(city);
    }
}

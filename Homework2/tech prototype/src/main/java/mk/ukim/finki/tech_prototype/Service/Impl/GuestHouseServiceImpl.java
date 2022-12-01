package mk.ukim.finki.tech_prototype.Service.Impl;

import mk.ukim.finki.tech_prototype.Model.GuestHouse;
import mk.ukim.finki.tech_prototype.Repository.GuestHouseRepository;
import mk.ukim.finki.tech_prototype.Service.GuestHouseService;
import org.springframework.stereotype.Service;

@Service
public class GuestHouseServiceImpl implements GuestHouseService {
    private final GuestHouseRepository guestHouseRepository;

    public GuestHouseServiceImpl(GuestHouseRepository guestHouseRepository) {
        this.guestHouseRepository = guestHouseRepository;
    }

    @Override
    public void post(Double x, Double y, String name, String city, String street, String houseNumber, String phoneNumber) {
        guestHouseRepository.save(new GuestHouse(x, y, name, city, street, houseNumber, phoneNumber));
    }
}

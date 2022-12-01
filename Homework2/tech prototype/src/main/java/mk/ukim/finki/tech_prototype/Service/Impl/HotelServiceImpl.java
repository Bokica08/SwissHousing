package mk.ukim.finki.tech_prototype.Service.Impl;

import mk.ukim.finki.tech_prototype.Model.Hotel;
import mk.ukim.finki.tech_prototype.Repository.HotelRepository;
import mk.ukim.finki.tech_prototype.Service.HotelService;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void post(Double x, Double y, String name, String city, String street, String houseNumber, String website, String phoneNumber, int stars) {
        hotelRepository.save(new Hotel(x, y, name, city, street, houseNumber, website, phoneNumber, stars));
    }
}

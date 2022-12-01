package mk.ukim.finki.tech_prototype.Service.Impl;

import mk.ukim.finki.tech_prototype.Model.AlpineHut;
import mk.ukim.finki.tech_prototype.Repository.AlpineHutRepository;
import mk.ukim.finki.tech_prototype.Service.AlpineHutService;
import org.springframework.stereotype.Service;

@Service
public class AlpineHutServiceImpl implements AlpineHutService {
    private final AlpineHutRepository alpineHutRepository;

    public AlpineHutServiceImpl(AlpineHutRepository alpineHutRepository) {
        this.alpineHutRepository = alpineHutRepository;
    }

    @Override
    public void post(Double x, Double y, String name, String city, String street, String houseNumber) {
        alpineHutRepository.save(new AlpineHut(x, y, name, city, street, houseNumber));
    }
}

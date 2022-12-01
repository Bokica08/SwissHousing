package mk.ukim.finki.tech_prototype.Service.Impl;

import mk.ukim.finki.tech_prototype.Model.CampSite;
import mk.ukim.finki.tech_prototype.Repository.CampSiteRepository;
import mk.ukim.finki.tech_prototype.Service.CampSiteService;
import org.springframework.stereotype.Service;

@Service
public class CampSiteServiceImpl implements CampSiteService {
    private final CampSiteRepository campSiteRepository;

    public CampSiteServiceImpl(CampSiteRepository campSiteRepository) {
        this.campSiteRepository = campSiteRepository;
    }

    @Override
    public void post(Double x, Double y, String name, String city, String street, String houseNumber, String website, String phoneNumber) {
        campSiteRepository.save(new CampSite(x, y, name, city, street, houseNumber, website, phoneNumber));
    }
}

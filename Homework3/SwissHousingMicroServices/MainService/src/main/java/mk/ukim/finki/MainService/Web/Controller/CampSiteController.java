package mk.ukim.finki.MainService.Web.Controller;

import mk.ukim.finki.MainService.FeignClient.LocationsServiceCampSiteClient;
import mk.ukim.finki.MainService.Model.CampSite;
import mk.ukim.finki.MainService.Model.DTO.CampSiteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campsite")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", maxAge = 3600)

public class CampSiteController {
    private final LocationsServiceCampSiteClient campSiteClient;

    public CampSiteController(LocationsServiceCampSiteClient campSiteClient) {
        this.campSiteClient = campSiteClient;
    }

    @GetMapping
    public List<CampSite> getCampSite()
    {
        return campSiteClient.getCampSite();
    }
    @GetMapping("/{id}")
    public Optional<CampSite> getById(@PathVariable Long id)
    {
        return campSiteClient.getById(id);
    }
    @GetMapping("/name")
    public Optional<CampSite> getByName(@RequestParam String name)
    {
        return campSiteClient.getByName(name);
    }
    @GetMapping("/cname")
    public List<CampSite> getByContains(@RequestParam String name)
    {
        return campSiteClient.getByContains(name);
    }
    @GetMapping("/city")
    public List<CampSite> getByCity(@RequestParam String city)
    {
        return campSiteClient.getByCity(city);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<CampSite> edit(@PathVariable Long id, @RequestBody CampSiteDTO campSiteDTO)
    {
        return campSiteClient.edit(id, campSiteDTO);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<CampSite> save(@RequestBody CampSiteDTO campSiteDTO)
    {
        return campSiteClient.save(campSiteDTO);

    }
}

package mk.ukim.finki.LocationsService.Web.Controller;

import mk.ukim.finki.LocationsService.Model.CampSite;
import mk.ukim.finki.LocationsService.Model.DTO.CampSiteDTO;
import mk.ukim.finki.LocationsService.Service.CampSiteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campsite")
public class CampSiteController {
    private final CampSiteService campSiteService;

    public CampSiteController(CampSiteService campSiteService) {
        this.campSiteService = campSiteService;
    }
    @GetMapping
    public List<CampSite> getCampSite()
    {
        return campSiteService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<CampSite> getById(@PathVariable Long id)
    {
        return campSiteService.findById(id);
    }
    @GetMapping("/name")
    public Optional<CampSite> getByName(@RequestParam String name)
    {
        return campSiteService.findByName(name);
    }
    @GetMapping("/cname")
    public List<CampSite> getByContains(@RequestParam String name)
    {
        return campSiteService.findAllContainingName(name);
    }
    @GetMapping("/city")
    public List<CampSite> getByCity(@RequestParam String city)
    {
        return campSiteService.findByCity(city);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<CampSite> edit(@PathVariable Long id, @RequestBody CampSiteDTO campSiteDTO)
    {
        return this.campSiteService.edit(id,campSiteDTO)
                .map(campSite -> ResponseEntity.ok().body(campSite))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PostMapping("/add")
    public ResponseEntity<CampSite> save(@RequestBody CampSiteDTO campSiteDTO)
    {
        return this.campSiteService.post(campSiteDTO)
                .map(campSite -> ResponseEntity.ok().body(campSite))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }
}

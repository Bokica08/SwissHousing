package mk.ukim.finki.tech_prototype.Web.Controller;

import mk.ukim.finki.tech_prototype.Model.Location;
import mk.ukim.finki.tech_prototype.Service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @GetMapping("/{id}")
    public Optional<Location> findById(@PathVariable Long id)
    {
        return locationService.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id)
    {
        this.locationService.deleteById(id);
        if(this.locationService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/grade/{id}")
    public Optional<Location> addGrade(@PathVariable Long id,@RequestParam int g)
    {
        return locationService.addGrade(id,g);
    }

}

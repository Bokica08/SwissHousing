package mk.ukim.finki.UsersService.Web.Controller;

import mk.ukim.finki.UsersService.Model.Location;
import mk.ukim.finki.UsersService.Service.LocationService;
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
    @GetMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id)
    {
        this.locationService.deleteById(id);
        if(this.locationService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/grade/{id}")
    public double getGrade(@PathVariable Long id)
    {
        return locationService.getGradeForLocation(id);
    }
    @PostMapping("/save/{id}")
    public Optional<Location> saveById(@PathVariable Long id)
    {
        return locationService.create(id);
    }

}

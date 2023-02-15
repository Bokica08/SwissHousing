package mk.ukim.finki.LocationsService.Web.Controller;

import mk.ukim.finki.LocationsService.Model.Location;
import mk.ukim.finki.LocationsService.Service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity deleteById(@PathVariable Long id, HttpServletRequest request)
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

}

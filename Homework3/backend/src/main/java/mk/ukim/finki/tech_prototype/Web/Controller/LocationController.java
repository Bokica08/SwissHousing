package mk.ukim.finki.tech_prototype.Web.Controller;

import mk.ukim.finki.tech_prototype.Model.Location;
import mk.ukim.finki.tech_prototype.Service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", maxAge = 3600)
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
    @GetMapping("/grade/{id}")
    public double getGrade(@PathVariable Long id)
    {
        return locationService.getGradeForLocation(id);
    }

}

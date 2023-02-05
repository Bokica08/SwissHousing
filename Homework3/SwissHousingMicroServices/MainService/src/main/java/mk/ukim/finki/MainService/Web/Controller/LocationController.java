package mk.ukim.finki.MainService.Web.Controller;

import mk.ukim.finki.MainService.FeignClient.LocationsServiceLocationClient;
import mk.ukim.finki.MainService.Model.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", maxAge = 3600)
public class LocationController {
    private final LocationsServiceLocationClient locationClient;

    public LocationController(LocationsServiceLocationClient locationClient) {
        this.locationClient = locationClient;
    }

    @GetMapping("/{id}")
    public Optional<Location> findById(@PathVariable Long id)
    {
        return locationClient.findById(id);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id)
    {
        return locationClient.deleteById(id);
    }
    @PostMapping("/grade/{id}")
    public double getGrade(@PathVariable Long id)
    {
        return locationClient.getGrade(id);
    }

}

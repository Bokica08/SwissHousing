package mk.ukim.finki.MainService.FeignClient;

import mk.ukim.finki.MainService.Model.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@FeignClient(name="locationsServiceLocations", url="localhost:8280")
public interface LocationsServiceLocationClient {
    @GetMapping("/location/{id}")
    Optional<Location> findById(@PathVariable("id") Long id);
    @GetMapping("/location/delete/{id}")
    ResponseEntity deleteById(@PathVariable("id") Long id);
    @PostMapping("/location/grade/{id}")
    double getGrade(@PathVariable("id") Long id);
}

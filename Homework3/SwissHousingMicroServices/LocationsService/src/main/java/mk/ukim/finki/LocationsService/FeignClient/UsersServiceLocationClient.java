package mk.ukim.finki.LocationsService.FeignClient;

import mk.ukim.finki.LocationsService.Model.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@FeignClient(name="usersService", url="localhost:8180")
public interface UsersServiceLocationClient {
    @GetMapping("/location/delete/{id}")
    ResponseEntity deleteById(@PathVariable("id") Long id);
    @PostMapping("/location/grade/{id}")
    double getGrade(@PathVariable("id") Long id);
    @PostMapping("/location/save/{id}")
    Optional<Location> saveById(@PathVariable("id") Long id);
}

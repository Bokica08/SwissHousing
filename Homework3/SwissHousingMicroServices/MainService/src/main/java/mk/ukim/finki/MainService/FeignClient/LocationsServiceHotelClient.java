package mk.ukim.finki.MainService.FeignClient;

import mk.ukim.finki.MainService.Model.DTO.HotelDTO;
import mk.ukim.finki.MainService.Model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="locationsServiceHotels", url="localhost:8280")
public interface LocationsServiceHotelClient {
    @GetMapping ("/hotel")
    public List<Hotel> getHotels();
    @GetMapping("/hotel/{id}")
    Optional<Hotel> getById(@PathVariable("id") Long id);
    @GetMapping("/hotel/name")
    Optional<Hotel> getByName(@RequestParam("name") String name);
    @GetMapping("/hotel/cname")
    List<Hotel> getByContains(@RequestParam("name") String name);
    @GetMapping("/hotel/city")
    List<Hotel> getByCity(@RequestParam("city") String city);
    @GetMapping("/hotel/stars")
    List<Hotel> getByStars(@RequestParam("stars") int stars);
    @PostMapping("/hotel/edit/{id}")
    ResponseEntity<Hotel> edit(@PathVariable("id") Long id, @RequestBody HotelDTO hotelDTO);
    @PostMapping("/hotel/add")
    ResponseEntity<Hotel> save(@RequestBody HotelDTO hotelDTO);
}

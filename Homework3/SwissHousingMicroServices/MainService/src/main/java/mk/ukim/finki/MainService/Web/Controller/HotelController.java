package mk.ukim.finki.MainService.Web.Controller;

import mk.ukim.finki.MainService.FeignClient.LocationsServiceHotelClient;
import mk.ukim.finki.MainService.Model.DTO.HotelDTO;
import mk.ukim.finki.MainService.Model.Hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", maxAge = 3600)
public class HotelController {
    private final LocationsServiceHotelClient hotelClient;

    public HotelController(LocationsServiceHotelClient hotelClient) {
        this.hotelClient = hotelClient;
    }

    @GetMapping
    public List<Hotel> getHotels()
    {
        return hotelClient.getHotels();
    }
    @GetMapping("/{id}")
    public Optional<Hotel> getById(@PathVariable Long id)
    {
        return hotelClient.getById(id);
    }
    @GetMapping("/name")
    public Optional<Hotel> getByName(@RequestParam String name)
    {
        return hotelClient.getByName(name);
    }
    @GetMapping("/cname")
    public List<Hotel> getByContains(@RequestParam String name)
    {
        return hotelClient.getByContains(name);
    }
    @GetMapping("/city")
    public List<Hotel> getByCity(@RequestParam String city)
    {
        return hotelClient.getByCity(city);
    }
    @GetMapping("/stars")
    public List<Hotel> getByStars(@RequestParam int stars)
    {
        return hotelClient.getByStars(stars);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<Hotel> edit(@PathVariable Long id, @RequestBody HotelDTO hotelDTO)
    {
        return hotelClient.edit(id, hotelDTO);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Hotel> save(@RequestBody HotelDTO hotelDTO)
    {
        return hotelClient.save(hotelDTO);

    }

}

package mk.ukim.finki.MainService.Web.Controller;

import mk.ukim.finki.MainService.FeignClient.LocationsServiceGuestHouseClient;
import mk.ukim.finki.MainService.Model.DTO.GuestHouseDTO;
import mk.ukim.finki.MainService.Model.GuestHouse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guesthouse")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", maxAge = 3600)

public class GuestHouseController {
    private final LocationsServiceGuestHouseClient guestHouseClient;

    public GuestHouseController(LocationsServiceGuestHouseClient guestHouseClient) {
        this.guestHouseClient = guestHouseClient;
    }

    @GetMapping
    public List<GuestHouse> getGuestHouse()
    {
        return guestHouseClient.getGuestHouse();
    }
    @GetMapping("/{id}")
    public Optional<GuestHouse> getById(@PathVariable Long id)
    {
        return guestHouseClient.getById(id);
    }
    @GetMapping("/name")
    public Optional<GuestHouse> getByName(@RequestParam String name)
    {
        return guestHouseClient.getByName(name);
    }
    @GetMapping("/cname")
    public List<GuestHouse> getByContains(@RequestParam String name)
    {
        return guestHouseClient.getByContains(name);
    }
    @GetMapping("/city")
    public List<GuestHouse> getByCity(@RequestParam String city)
    {
        return guestHouseClient.getByCity(city);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<GuestHouse> edit(@PathVariable Long id, @RequestBody GuestHouseDTO guestHouseDTO)
    {
        return guestHouseClient.edit(id, guestHouseDTO);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<GuestHouse> save(@RequestBody GuestHouseDTO guestHouseDTO)
    {
        return guestHouseClient.save(guestHouseDTO);

    }
}

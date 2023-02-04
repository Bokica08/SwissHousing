package mk.ukim.finki.LocationsService.Web.Controller;

import mk.ukim.finki.LocationsService.Model.DTO.GuestHouseDTO;
import mk.ukim.finki.LocationsService.Model.GuestHouse;
import mk.ukim.finki.LocationsService.Service.GuestHouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guesthouse")
public class GuestHouseController {
    private final GuestHouseService guestHouseService;

    public GuestHouseController(GuestHouseService guestHouseService) {
        this.guestHouseService = guestHouseService;
    }
    @GetMapping
    public List<GuestHouse> getGuestHouse()
    {
        return guestHouseService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<GuestHouse> getById(@PathVariable Long id)
    {
        return guestHouseService.findById(id);
    }
    @GetMapping("/name")
    public Optional<GuestHouse> getByName(@RequestParam String name)
    {
        return guestHouseService.findByName(name);
    }
    @GetMapping("/cname")
    public List<GuestHouse> getByContains(@RequestParam String name)
    {
        return guestHouseService.findAllContainingName(name);
    }
    @GetMapping("/city")
    public List<GuestHouse> getByCity(@RequestParam String city)
    {
        return guestHouseService.findByCity(city);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<GuestHouse> edit(@PathVariable Long id, @RequestBody GuestHouseDTO guestHouseDTO)
    {
        return this.guestHouseService.edit(id,guestHouseDTO)
                .map(guestHouse -> ResponseEntity.ok().body(guestHouse))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PostMapping("/add")
    public ResponseEntity<GuestHouse> save(@RequestBody GuestHouseDTO guestHouseDTO)
    {
        return this.guestHouseService.post(guestHouseDTO)
                .map(guestHouse -> ResponseEntity.ok().body(guestHouse))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }
}

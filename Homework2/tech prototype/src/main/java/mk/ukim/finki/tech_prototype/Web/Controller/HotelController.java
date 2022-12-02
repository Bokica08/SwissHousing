package mk.ukim.finki.tech_prototype.Web.Controller;

import mk.ukim.finki.tech_prototype.Model.DTO.HotelDTO;
import mk.ukim.finki.tech_prototype.Model.Hotel;
import mk.ukim.finki.tech_prototype.Service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping
    public List<Hotel> getHotels()
    {
        return hotelService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Hotel> getById(@PathVariable Long id)
    {
        return hotelService.findById(id);
    }
    @GetMapping("/name")
    public Optional<Hotel> getByName(@RequestParam String name)
    {
        return hotelService.findByName(name);
    }
    @GetMapping("/cname")
    public List<Hotel> getByContains(@RequestParam String name)
    {
        return hotelService.findAllContainingName(name);
    }
    @GetMapping("/city")
    public List<Hotel> getByCity(@RequestParam String city)
    {
        return hotelService.findByCity(city);
    }
    @GetMapping("/stars")
    public List<Hotel> getByStars(@RequestParam int stars)
    {
        return hotelService.findByStars(stars);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<Hotel> edit(@PathVariable Long id, @RequestBody HotelDTO hotelDTO)
    {
        return this.hotelService.edit(id,hotelDTO)
                .map(hotel -> ResponseEntity.ok().body(hotel))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PostMapping("/add")
    public ResponseEntity<Hotel> save(@RequestBody HotelDTO hotelDTO)
    {
        return this.hotelService.post(hotelDTO)
                .map(hotel -> ResponseEntity.ok().body(hotel))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }

}

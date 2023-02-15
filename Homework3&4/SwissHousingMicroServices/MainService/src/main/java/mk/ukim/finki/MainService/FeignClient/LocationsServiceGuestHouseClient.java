package mk.ukim.finki.MainService.FeignClient;

import mk.ukim.finki.MainService.Model.DTO.GuestHouseDTO;
import mk.ukim.finki.MainService.Model.GuestHouse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="locationsServiceHouses", url="localhost:8280")
public interface LocationsServiceGuestHouseClient {
    @GetMapping("/guesthouse")
    List<GuestHouse> getGuestHouse();
    @GetMapping("/guesthouse/{id}")
    Optional<GuestHouse> getById(@PathVariable("id") Long id);
    @GetMapping("/guesthouse/name")
    Optional<GuestHouse> getByName(@RequestParam("name") String name);
    @GetMapping("/guesthouse/cname")
    List<GuestHouse> getByContains(@RequestParam("name") String name);
    @GetMapping("/guesthouse/city")
    List<GuestHouse> getByCity(@RequestParam("city") String city);
    @PostMapping("/guesthouse/edit/{id}")
    ResponseEntity<GuestHouse> edit(@PathVariable("id") Long id, @RequestBody GuestHouseDTO guestHouseDTO);
    @PostMapping("/guesthouse/add")
    ResponseEntity<GuestHouse> save(@RequestBody GuestHouseDTO guestHouseDTO);
}

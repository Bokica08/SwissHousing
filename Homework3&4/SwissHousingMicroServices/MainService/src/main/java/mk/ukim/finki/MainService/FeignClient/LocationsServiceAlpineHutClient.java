package mk.ukim.finki.MainService.FeignClient;

import mk.ukim.finki.MainService.Model.AlpineHut;
import mk.ukim.finki.MainService.Model.DTO.AlpineHutDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="locationsServiceHuts", url="localhost:8280")
public interface LocationsServiceAlpineHutClient {
    @GetMapping("/alpinehut")
    List<AlpineHut> getAlpineHut();
    @GetMapping("/alpinehut/{id}")
    Optional<AlpineHut> getById(@PathVariable("id") Long id);
    @GetMapping("/alpinehut/name")
    Optional<AlpineHut> getByName(@RequestParam("name") String name);
    @GetMapping("/alpinehut/cname")
    List<AlpineHut> getByContains(@RequestParam("name") String name);
    @GetMapping("/alpinehut/city")
    List<AlpineHut> getByCity(@RequestParam("city") String city);
    @PostMapping("/alpinehut/edit/{id}")
    ResponseEntity<AlpineHut> edit(@PathVariable("id") Long id, @RequestBody AlpineHutDTO alpineHutDTO);
    @PostMapping("/alpinehut/add")
    ResponseEntity<AlpineHut> save(@RequestBody AlpineHutDTO alpineHutDTO);
}

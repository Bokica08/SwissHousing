package mk.ukim.finki.MainService.Web.Controller;

import mk.ukim.finki.MainService.FeignClient.LocationsServiceAlpineHutClient;
import mk.ukim.finki.MainService.Model.AlpineHut;
import mk.ukim.finki.MainService.Model.DTO.AlpineHutDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alpinehut")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", maxAge = 3600)

public class AlpineHutController {
    private final LocationsServiceAlpineHutClient alpineHutClient;

    public AlpineHutController(LocationsServiceAlpineHutClient alpineHutClient) {
        this.alpineHutClient = alpineHutClient;
    }

    @GetMapping
    public List<AlpineHut> getAlpineHut()
    {
        return alpineHutClient.getAlpineHut();
    }
    @GetMapping("/{id}")
    public Optional<AlpineHut> getById(@PathVariable Long id)
    {
        return alpineHutClient.getById(id);
    }
    @GetMapping("/name")
    public Optional<AlpineHut> getByName(@RequestParam String name)
    {
        return alpineHutClient.getByName(name);
    }
    @GetMapping("/cname")
    public List<AlpineHut> getByContains(@RequestParam String name)
    {
        return alpineHutClient.getByContains(name);
    }
    @GetMapping("/city")
    public List<AlpineHut> getByCity(@RequestParam String city)
    {
        return alpineHutClient.getByCity(city);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<AlpineHut> edit(@PathVariable Long id, @RequestBody AlpineHutDTO alpineHutDTO)
    {
        return alpineHutClient.edit(id, alpineHutDTO);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<AlpineHut> save(@RequestBody AlpineHutDTO alpineHutDTO)
    {
        return alpineHutClient.save(alpineHutDTO);

    }

}

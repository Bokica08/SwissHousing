package mk.ukim.finki.tech_prototype.Web.Controller;

import mk.ukim.finki.tech_prototype.Model.AlpineHut;
import mk.ukim.finki.tech_prototype.Model.DTO.AlpineHutDTO;
import mk.ukim.finki.tech_prototype.Service.AlpineHutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alpinehut")
public class AlpineHutController {
    private final AlpineHutService alpineHutService;

    public AlpineHutController(AlpineHutService alpineHutService) {
        this.alpineHutService = alpineHutService;
    }
    @GetMapping
    public List<AlpineHut> getAlpineHut()
    {
        return alpineHutService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<AlpineHut> getById(@PathVariable Long id)
    {
        return alpineHutService.findById(id);
    }
    @GetMapping("/name")
    public Optional<AlpineHut> getByName(@RequestParam String name)
    {
        return alpineHutService.findByName(name);
    }
    @GetMapping("/cname")
    public List<AlpineHut> getByContains(@RequestParam String name)
    {
        return alpineHutService.findAllContainingName(name);
    }
    @GetMapping("/city")
    public List<AlpineHut> getByCity(@RequestParam String city)
    {
        return alpineHutService.findByCity(city);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<AlpineHut> edit(@PathVariable Long id, @RequestBody AlpineHutDTO alpineHutDTO)
    {
        return this.alpineHutService.edit(id,alpineHutDTO)
                .map(alpineHut -> ResponseEntity.ok().body(alpineHut))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PostMapping("/add")
    public ResponseEntity<AlpineHut> save(@RequestBody AlpineHutDTO alpineHutDTO)
    {
        return this.alpineHutService.post(alpineHutDTO)
                .map(alpineHut -> ResponseEntity.ok().body(alpineHut))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }

}

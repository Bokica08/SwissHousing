package mk.ukim.finki.MainService.FeignClient;

import mk.ukim.finki.MainService.Model.CampSite;
import mk.ukim.finki.MainService.Model.DTO.CampSiteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="locationsServiceCamps", url="localhost:8280")
public interface LocationsServiceCampSiteClient {
    @GetMapping("/campsite")
    List<CampSite> getCampSite();
    @GetMapping("/campsite/{id}")
    Optional<CampSite> getById(@PathVariable("id") Long id);
    @GetMapping("/campsite/name")
    Optional<CampSite> getByName(@RequestParam("name") String name);
    @GetMapping("/campsite/cname")
    List<CampSite> getByContains(@RequestParam("name") String name);
    @GetMapping("/campsite/city")
    List<CampSite> getByCity(@RequestParam("city") String city);
    @PostMapping("/campsite/edit/{id}")
    ResponseEntity<CampSite> edit(@PathVariable("id") Long id, @RequestBody CampSiteDTO campSiteDTO);
    @PostMapping("/campsite/add")
    ResponseEntity<CampSite> save(@RequestBody CampSiteDTO campSiteDTO);
}

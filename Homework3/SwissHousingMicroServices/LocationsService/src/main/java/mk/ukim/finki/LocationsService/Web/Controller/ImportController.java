package mk.ukim.finki.LocationsService.Web.Controller;

import mk.ukim.finki.LocationsService.Service.AlpineHutService;
import mk.ukim.finki.LocationsService.Service.CampSiteService;
import mk.ukim.finki.LocationsService.Service.GuestHouseService;
import mk.ukim.finki.LocationsService.Service.HotelService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
@RequestMapping("/csv/fill")
public class ImportController {
    private final HotelService hotelService;
    private final CampSiteService campSiteService;
    private final GuestHouseService guestHouseService;
    private final AlpineHutService alpineHutService;
    private final ResourceLoader resourceLoader;

    public ImportController(HotelService hotelService, CampSiteService campSiteService, GuestHouseService guestHouseService, AlpineHutService alpineHutService, ResourceLoader resourceLoader) {
        this.hotelService = hotelService;
        this.campSiteService = campSiteService;
        this.guestHouseService = guestHouseService;
        this.alpineHutService = alpineHutService;
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/hotels")
    public String fillHotels() throws IOException {
        Resource file = resourceLoader.getResource("classpath:/static/csvData/f_hotel.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        reader.readLine();
        String line=null;
        while ((line=reader.readLine())!=null)
        {
            String[] parts=line.split(",");
            hotelService.post(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), parts[2], parts[5], parts[4], parts[3], parts[6], parts[7], Integer.parseInt(parts[8]));
        }
        return "success";
    }

    @GetMapping("/huts")
    public String fillHuts() throws IOException {
        Resource file = resourceLoader.getResource("classpath:/static/csvData/f_alpine_hut.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        reader.readLine();
        String line=null;
        while ((line=reader.readLine())!=null)
        {
            String[] parts=line.split(",");
            alpineHutService.post(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), parts[2], parts[4], parts[5], parts[6], Integer.parseInt(parts[3]));
        }
        return "success";
    }

    @GetMapping("/camps")
    public String fillCamps() throws IOException {
        Resource file = resourceLoader.getResource("classpath:/static/csvData/f_camp_site.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        reader.readLine();
        String line=null;
        while ((line=reader.readLine())!=null)
        {
            String[] parts=line.split(",");
            campSiteService.post(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), parts[2], parts[5], parts[6], parts[7], parts[3], parts[4]);
        }
        return "success";
    }

    @GetMapping("/guests")
    public String fillGuests() throws IOException {
        Resource file = resourceLoader.getResource("classpath:/static/csvData/f_guest_house.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        reader.readLine();
        String line=null;
        while ((line=reader.readLine())!=null)
        {
            String[] parts=line.split(",");
            guestHouseService.post(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), parts[2], parts[5], parts[4], parts[3], parts[6]);
        }
        return "success";
    }
}

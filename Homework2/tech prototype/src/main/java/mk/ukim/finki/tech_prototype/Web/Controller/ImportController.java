package mk.ukim.finki.tech_prototype.Web.Controller;

import mk.ukim.finki.tech_prototype.Service.AlpineHutService;
import mk.ukim.finki.tech_prototype.Service.CampSiteService;
import mk.ukim.finki.tech_prototype.Service.GuestHouseService;
import mk.ukim.finki.tech_prototype.Service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Controller
@RequestMapping("/csv/fill")
public class ImportController {
    private final HotelService hotelService;
    private final CampSiteService campSiteService;
    private final GuestHouseService guestHouseService;
    private final AlpineHutService alpineHutService;

    public ImportController(HotelService hotelService, CampSiteService campSiteService, GuestHouseService guestHouseService, AlpineHutService alpineHutService) {
        this.hotelService = hotelService;
        this.campSiteService = campSiteService;
        this.guestHouseService = guestHouseService;
        this.alpineHutService = alpineHutService;
    }

    @GetMapping("/hotels")
    public String fillHotels() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Bojan/Dropbox/My PC (DESKTOP-HM9G9A7)/Desktop/demo1/SwissHousing/Homework2/tech prototype/src/main/resources/static/csvData/f_hotel.csv"));
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
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/static/csvData/f_alpine_hut.csv"));
        reader.readLine();
        String line=null;
        while ((line=reader.readLine())!=null)
        {
            String[] parts=line.split(",");
            alpineHutService.post(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), parts[2], parts[4], parts[5], parts[6]);
        }
        return "success";
    }

    @GetMapping("/camps")
    public String fillCamps() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/static/csvData/f_camp_site.csv"));
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
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/static/csvData/f_guest_house.csv"));
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

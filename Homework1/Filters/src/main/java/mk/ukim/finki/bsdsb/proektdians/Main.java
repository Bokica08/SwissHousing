package mk.ukim.finki.bsdsb.proektdians;
import mk.ukim.finki.bsdsb.proektdians.filters.AlpineHut.*;
import mk.ukim.finki.bsdsb.proektdians.filters.CampSite.CampSiteFilter;
import mk.ukim.finki.bsdsb.proektdians.filters.GuestHouseAndHotel.*;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void passThroughPipe(Pipe<String> pipe, BufferedWriter bufferedWriter, Scanner scanner) throws IOException {
        while (scanner.hasNextLine()) {
            String line = pipe.runFilters(scanner.nextLine());
            if (line.isEmpty()) {
                continue;
            }
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner alpineHutScanner = new Scanner(new File("src/main/resources/csvData/alpine_hut.csv"));
        Scanner hotelScanner = new Scanner(new File("src/main/resources/csvData/hotel.csv"));
        Scanner guestHouseScanner = new Scanner(new File("src/main/resources/csvData/guest_house.csv"));
        Scanner campSiteScanner = new Scanner(new File("src/main/resources/csvData/camp_site.csv"));
        Pipe<String> alpineHutPipe = new Pipe<>();
        Pipe<String> guestHouseAndHotelPipe = new Pipe<>();
        Pipe<String> campSitePipe = new Pipe<>();
        AlpineHutIncompleteDataFilter alpineHutIncompleteDataFilter = new AlpineHutIncompleteDataFilter();
        AlpineHutRemoveUnnecesarryColumnsInTheMiddleFilter alpineHutRemoveTourismAndBuildingFilter = new AlpineHutRemoveUnnecesarryColumnsInTheMiddleFilter();
        AlpineHutUnnecessaryColumnsAtTheEndFilter alpineHutUnnecessaryColumnsAtTheEndFilter = new AlpineHutUnnecessaryColumnsAtTheEndFilter();
        GHAHIncompleteDataFilter ghahIncompleteDataFilter = new GHAHIncompleteDataFilter();
        GHAHRemovePostCodeFilter ghahRemovePostCodeFilter = new GHAHRemovePostCodeFilter();
        GHAHRemoveTourismAndBuildingFilter ghahRemoveTourismAndBuildingFilter = new GHAHRemoveTourismAndBuildingFilter();
        GHAHRemoveCountryAndWebsiteFilter ghahRemoveCountryAndWebsiteFilter = new GHAHRemoveCountryAndWebsiteFilter();
        GHAHUnnecessaryColumnsAtTheEndFilter ghahUnnecessaryColumnsAtTheEndFilter = new GHAHUnnecessaryColumnsAtTheEndFilter();
        CampSiteFilter campSiteFilter = new CampSiteFilter();
        alpineHutPipe.addFilter(alpineHutUnnecessaryColumnsAtTheEndFilter);
        alpineHutPipe.addFilter(alpineHutRemoveTourismAndBuildingFilter);
        alpineHutPipe.addFilter(alpineHutIncompleteDataFilter);
        guestHouseAndHotelPipe.addFilter(ghahUnnecessaryColumnsAtTheEndFilter);
        guestHouseAndHotelPipe.addFilter(ghahRemovePostCodeFilter);
        guestHouseAndHotelPipe.addFilter(ghahRemoveTourismAndBuildingFilter);
        guestHouseAndHotelPipe.addFilter(ghahRemoveCountryAndWebsiteFilter);
        guestHouseAndHotelPipe.addFilter(ghahIncompleteDataFilter);
        campSitePipe.addFilter(campSiteFilter);
        BufferedWriter alpineHutWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/csvData/filtered/f_alpine_hut.csv")));
        BufferedWriter hotelWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/csvData/filtered/f_hotel.csv")));
        BufferedWriter guestHouseWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/csvData/filtered/f_guest_house.csv")));
        BufferedWriter campSiteWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/csvData/filtered/f_camp_site.csv")));
        passThroughPipe(alpineHutPipe, alpineHutWriter, alpineHutScanner);
        passThroughPipe(guestHouseAndHotelPipe, hotelWriter, hotelScanner);
        passThroughPipe(guestHouseAndHotelPipe, guestHouseWriter, guestHouseScanner);
        passThroughPipe(campSitePipe, campSiteWriter, campSiteScanner);
    }
}

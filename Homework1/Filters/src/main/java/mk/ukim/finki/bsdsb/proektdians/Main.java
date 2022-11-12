package mk.ukim.finki.bsdsb.proektdians;
import mk.ukim.finki.bsdsb.proektdians.filters.AlpineHut.*;
import mk.ukim.finki.bsdsb.proektdians.filters.CampSite.*;
import mk.ukim.finki.bsdsb.proektdians.filters.GlobalFilters.GHAHUnnecessaryColumnsAtTheEndFilter;
import mk.ukim.finki.bsdsb.proektdians.filters.GlobalFilters.GHAHRemovePostCodeFilter;
import mk.ukim.finki.bsdsb.proektdians.filters.GlobalFilters.IncompleteDataFilter;
import mk.ukim.finki.bsdsb.proektdians.filters.GuestHouse.*;
import mk.ukim.finki.bsdsb.proektdians.filters.Hotel.HotelIncompleteDataFilter;
import mk.ukim.finki.bsdsb.proektdians.filters.Hotel.HotelRemoveFromMiddleTierFilter;

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
        Scanner alpineHutScanner = new Scanner(new File("Homework1/Filters/src/main/resources/csvData/alpine_hut.csv"));
        Scanner hotelScanner = new Scanner(new File("Homework1/Filters/src/main/resources/csvData/hotel.csv"));
        Scanner guestHouseScanner = new Scanner(new File("Homework1/Filters/src/main/resources/csvData/guest_house.csv"));
        Scanner campSiteScanner = new Scanner(new File("Homework1/Filters/src/main/resources/csvData/camp_site.csv"));

        Pipe<String> alpineHutPipe = new Pipe<>();
        Pipe<String> guestHousePipe = new Pipe<>();
        Pipe<String> hotelPipe = new Pipe<>();
        Pipe<String> campSitePipe = new Pipe<>();

        IncompleteDataFilter incompleteDataFilter = new IncompleteDataFilter();
        AlpineHutRemoveUnnecesarryColumnsInTheMiddleFilter alpineHutRemoveTourismAndBuildingFilter = new AlpineHutRemoveUnnecesarryColumnsInTheMiddleFilter();
        AlpineHutUnnecessaryColumnsAtTheEndFilter alpineHutUnnecessaryColumnsAtTheEndFilter = new AlpineHutUnnecessaryColumnsAtTheEndFilter();
        GHAHRemovePostCodeFilter ghahRemovePostCodeFilter = new GHAHRemovePostCodeFilter();
        GHRemoveTourismAndBuildingFilter ghRemoveTourismAndBuildingFilter = new GHRemoveTourismAndBuildingFilter();
        GHRemoveCountryAndWebsiteFilter ghRemoveCountryAndWebsiteFilter = new GHRemoveCountryAndWebsiteFilter();
        GHAHUnnecessaryColumnsAtTheEndFilter ghahUnnecessaryColumnsAtTheEndFilter = new GHAHUnnecessaryColumnsAtTheEndFilter();
        CampSiteRemoveUnnecesarryColumnsInTheMiddleFilter campSiteRemoveUnnecesarryColumnsInTheMiddleFilter = new CampSiteRemoveUnnecesarryColumnsInTheMiddleFilter();
        CampSiteUnnecessaryColumnsAtTheEndFilter campSiteUnnecessaryColumnsAtTheEndFilter = new CampSiteUnnecessaryColumnsAtTheEndFilter();
        WebSiteStripFilter webSiteStripFilter = new WebSiteStripFilter();
        CampSiteIncompleteDataFilter campSiteIncompleteDataFilter = new CampSiteIncompleteDataFilter();
        HotelRemoveFromMiddleTierFilter hotelRemoveFromMiddleTierFilter = new HotelRemoveFromMiddleTierFilter();
        HotelIncompleteDataFilter hotelIncompleteDataFilter = new HotelIncompleteDataFilter();

        alpineHutPipe.addFilter(alpineHutUnnecessaryColumnsAtTheEndFilter);
        alpineHutPipe.addFilter(alpineHutRemoveTourismAndBuildingFilter);
        alpineHutPipe.addFilter(incompleteDataFilter);

        guestHousePipe.addFilter(ghahUnnecessaryColumnsAtTheEndFilter);
        guestHousePipe.addFilter(ghRemoveCountryAndWebsiteFilter);
        guestHousePipe.addFilter(ghahRemovePostCodeFilter);
        guestHousePipe.addFilter(ghRemoveTourismAndBuildingFilter);
        guestHousePipe.addFilter(incompleteDataFilter);

        hotelPipe.addFilter(ghahUnnecessaryColumnsAtTheEndFilter);
        hotelPipe.addFilter(hotelRemoveFromMiddleTierFilter);
        hotelPipe.addFilter(hotelIncompleteDataFilter);

        campSitePipe.addFilter(campSiteUnnecessaryColumnsAtTheEndFilter);
        campSitePipe.addFilter(campSiteRemoveUnnecesarryColumnsInTheMiddleFilter);
        campSitePipe.addFilter(campSiteIncompleteDataFilter);
        campSitePipe.addFilter(webSiteStripFilter);

        BufferedWriter alpineHutWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Homework1/Filters/src/main/resources/csvData/filtered/f_alpine_hut.csv")));
        BufferedWriter hotelWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Homework1/Filters/src/main/resources/csvData/filtered/f_hotel.csv")));
        BufferedWriter guestHouseWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Homework1/Filters/src/main/resources/csvData/filtered/f_guest_house.csv")));
        BufferedWriter campSiteWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Homework1/Filters/src/main/resources/csvData/filtered/f_camp_site.csv")));

        passThroughPipe(alpineHutPipe, alpineHutWriter, alpineHutScanner);
        passThroughPipe(hotelPipe, hotelWriter, hotelScanner);
        passThroughPipe(guestHousePipe, guestHouseWriter, guestHouseScanner);
        passThroughPipe(campSitePipe, campSiteWriter, campSiteScanner);
    }
}

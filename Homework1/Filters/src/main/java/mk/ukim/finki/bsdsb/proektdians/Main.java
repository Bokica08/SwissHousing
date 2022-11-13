package mk.ukim.finki.bsdsb.proektdians;
import mk.ukim.finki.bsdsb.proektdians.filters.AlpineHut.*;
import mk.ukim.finki.bsdsb.proektdians.filters.CampSite.*;
import mk.ukim.finki.bsdsb.proektdians.filters.GlobalFilters.*;
import mk.ukim.finki.bsdsb.proektdians.filters.GuestHouse.*;
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

        IncompleteDataFilter incompleteDataFilter = new IncompleteDataFilter(7);
        AlpineHutRemoveUnnecesarryColumnsInTheMiddleFilter alpineHutRemoveTourismAndBuildingFilter = new AlpineHutRemoveUnnecesarryColumnsInTheMiddleFilter();
        UnnecessaryColumnsAtTheEndFilter alpineHutUnnecessaryColumnsAtTheEndFilter = new UnnecessaryColumnsAtTheEndFilter(16);
        GHAHRemovePostCodeFilter ghahRemovePostCodeFilter = new GHAHRemovePostCodeFilter();
        GHRemoveTourismAndBuildingFilter ghRemoveTourismAndBuildingFilter = new GHRemoveTourismAndBuildingFilter();
        GHRemoveCountryAndWebsiteFilter ghRemoveCountryAndWebsiteFilter = new GHRemoveCountryAndWebsiteFilter();
        UnnecessaryColumnsAtTheEndFilter ghahUnnecessaryColumnsAtTheEndFilter = new UnnecessaryColumnsAtTheEndFilter(14);
        CampSiteRemoveUnnecesarryColumnsInTheMiddleFilter campSiteRemoveUnnecesarryColumnsInTheMiddleFilter = new CampSiteRemoveUnnecesarryColumnsInTheMiddleFilter();
        UnnecessaryColumnsAtTheEndFilter campSiteUnnecessaryColumnsAtTheEndFilter = new UnnecessaryColumnsAtTheEndFilter(10);
        WebSiteStripFilter webSiteStripFilter = new WebSiteStripFilter(8, 3);
        IncompleteDataFilter campSiteIncompleteDataFilter = new IncompleteDataFilter(8);
        HotelRemoveFromMiddleTierFilter hotelRemoveFromMiddleTierFilter = new HotelRemoveFromMiddleTierFilter();
        IncompleteDataFilter hotelIncompleteDataFilter = new IncompleteDataFilter(9);
        WebSiteStripFilter hotelWebSiteStripFilter = new WebSiteStripFilter(9, 6);

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
        hotelPipe.addFilter(hotelWebSiteStripFilter);

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

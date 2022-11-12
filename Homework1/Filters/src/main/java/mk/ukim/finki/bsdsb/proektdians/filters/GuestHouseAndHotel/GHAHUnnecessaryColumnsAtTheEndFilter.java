package mk.ukim.finki.bsdsb.proektdians.filters.GuestHouseAndHotel;

import mk.ukim.finki.bsdsb.proektdians.Filter;

import java.util.Arrays;

public class GHAHUnnecessaryColumnsAtTheEndFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        String[] withoutColumns = Arrays.copyOfRange(fields, 0,12);
        return String.join(",", withoutColumns);
    }
}

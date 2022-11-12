package mk.ukim.finki.bsdsb.proektdians.filters.CampSite;

import mk.ukim.finki.bsdsb.proektdians.Filter;

import java.util.Arrays;

public class CampSiteUnnecessaryColumnsAtTheEndFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        String[] withoutColumns = Arrays.copyOfRange(fields, 0,10);
        return String.join(",", withoutColumns);
    }
}

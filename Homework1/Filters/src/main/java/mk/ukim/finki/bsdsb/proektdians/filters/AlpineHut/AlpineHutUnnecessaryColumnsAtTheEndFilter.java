package mk.ukim.finki.bsdsb.proektdians.filters.AlpineHut;

import mk.ukim.finki.bsdsb.proektdians.Filter;

import java.util.Arrays;

public class AlpineHutUnnecessaryColumnsAtTheEndFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        String[] withoutColumns = Arrays.copyOfRange(fields, 0,16);
        return String.join(",", withoutColumns);
    }
}

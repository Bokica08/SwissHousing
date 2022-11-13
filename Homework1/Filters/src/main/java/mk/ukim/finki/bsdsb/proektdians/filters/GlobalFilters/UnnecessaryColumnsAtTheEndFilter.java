package mk.ukim.finki.bsdsb.proektdians.filters.GlobalFilters;

import mk.ukim.finki.bsdsb.proektdians.Filter;

import java.util.Arrays;

public class UnnecessaryColumnsAtTheEndFilter implements Filter<String> {
    private int columns;

    public UnnecessaryColumnsAtTheEndFilter(int columns) {
        this.columns = columns;
    }

    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        String[] withoutColumns = Arrays.copyOfRange(fields, 0,columns);
        return String.join(",", withoutColumns);
    }
}

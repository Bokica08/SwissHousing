package mk.ukim.finki.bsdsb.proektdians.filters.CampSite;

import mk.ukim.finki.bsdsb.proektdians.Filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CampSiteFilter implements Filter<String> {

    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        String[] withoutColumns = Arrays.copyOfRange(fields, 0,10);
        List<String> list = new ArrayList<>();
        int br=0;
        for (String s:withoutColumns) {
            br++;
            if(br==3 || br==8)
            {
                continue;
            }
            if (s != null && !s.isEmpty() && !s.equals("")) {
                list.add(s);
            }
            else
            {
                return "";
            }
        }
        return list.stream().collect(Collectors.joining(","));
    }
}

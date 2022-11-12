package mk.ukim.finki.bsdsb.proektdians.filters.GuestHouse;

import mk.ukim.finki.bsdsb.proektdians.Filter;

import java.util.ArrayList;
import java.util.List;

public class GHRemoveCountryAndWebsiteFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        List<String> list = new ArrayList<>();
        int br=0;
        for (String s:fields) {
            br++;
            if(br==10 || br==11 || br==13 || br==14)
            {
                continue;
            }
            list.add(s);
        }
        return String.join(",", list);
    }
}

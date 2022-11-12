package mk.ukim.finki.bsdsb.proektdians.filters.Hotel;

import mk.ukim.finki.bsdsb.proektdians.Filter;

import java.util.ArrayList;
import java.util.List;

public class HotelRemoveFromMiddleTierFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        List<String> list = new ArrayList<>();
        int br=0;
        for (String s:fields) {
            br++;
            if(br==3 || br==5 || br==10 || br==8 || br==13)
            {
                continue;
            }
            list.add(s);
        }
        return String.join(",", list);
    }
}

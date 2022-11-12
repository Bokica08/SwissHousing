package mk.ukim.finki.bsdsb.proektdians.filters.GlobalFilters;

import mk.ukim.finki.bsdsb.proektdians.Filter;

import java.util.ArrayList;
import java.util.List;

public class GHAHRemovePostCodeFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        List<String> list = new ArrayList<>();
        int br=0;
        for (String s:fields) {
            br++;
            if(br==8)
            {
                continue;
            }
            list.add(s);
        }
        return String.join(",", list);
    }
}

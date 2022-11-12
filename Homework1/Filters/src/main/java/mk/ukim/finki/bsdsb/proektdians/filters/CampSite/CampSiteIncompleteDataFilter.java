package mk.ukim.finki.bsdsb.proektdians.filters.CampSite;

import mk.ukim.finki.bsdsb.proektdians.Filter;

import java.util.ArrayList;
import java.util.List;

public class CampSiteIncompleteDataFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        List<String> list = new ArrayList<>();
        for (String s:fields) {
            if (s != null && !s.equals("") && !s.equals("null")) {
                list.add(s);
            }
            else
            {
                return "";
            }
        }
        if(list.size()!=8)
        {
            return "";
        }
        return String.join(",", list);
    }
}
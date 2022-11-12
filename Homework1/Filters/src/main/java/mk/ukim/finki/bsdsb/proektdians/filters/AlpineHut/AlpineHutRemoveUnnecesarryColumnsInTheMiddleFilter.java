package mk.ukim.finki.bsdsb.proektdians.filters.AlpineHut;

import mk.ukim.finki.bsdsb.proektdians.Filter;

import java.util.ArrayList;
import java.util.List;

public class AlpineHutRemoveUnnecesarryColumnsInTheMiddleFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        List<String> list = new ArrayList<>();
        int br=0;
        for (String s:fields) {
            br++;
            if(br==3 || br==4|| br==7|| br==8|| br==9|| br==10|| br==11|| br==13|| br==14)
            {
                continue;
            }
            list.add(s);
        }
        return String.join(",", list);
    }
}

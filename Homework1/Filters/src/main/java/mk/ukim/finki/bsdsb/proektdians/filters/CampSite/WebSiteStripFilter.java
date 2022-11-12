package mk.ukim.finki.bsdsb.proektdians.filters.CampSite;


import mk.ukim.finki.bsdsb.proektdians.Filter;

public class WebSiteStripFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        if(fields.length<8)
        {
            return String.join(",", fields);
        }
        String newWebSite = null;
        if(fields[3].startsWith("https"))
        {
            newWebSite = fields[3].substring(8);
        }
        else if(fields[3].startsWith("http"))
        {
            newWebSite = fields[3].substring(7);
        }
        else
        {
            newWebSite = fields[3];
        }
        fields[3]=newWebSite;
        if(fields[3].endsWith("/"))
            fields[3]=fields[3].substring(0, fields[3].length()-1);
        return String.join(",", fields);

    }
}

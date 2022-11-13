package mk.ukim.finki.bsdsb.proektdians.filters.GlobalFilters;


import mk.ukim.finki.bsdsb.proektdians.Filter;

public class WebSiteStripFilter implements Filter<String> {
    private int length;
    private int column;

    public WebSiteStripFilter(int length, int column) {
        this.length = length;
        this.column = column;
    }

    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        if(fields.length<length)
        {
            return String.join(",", fields);
        }
        String newWebSite = null;
        if(fields[column].startsWith("https"))
        {
            newWebSite = fields[column].substring(8);
        }
        else if(fields[column].startsWith("http"))
        {
            newWebSite = fields[column].substring(7);
        }
        else
        {
            newWebSite = fields[column];
        }
        fields[column]=newWebSite;
        if(fields[column].endsWith("/"))
            fields[column]=fields[column].substring(0, fields[column].length()-1);
        return String.join(",", fields);

    }
}

package yongze;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Site implements Serializable {
    private String URL;
    private String SRC;
    private String SEARCH;
    private int COUNT;

    public Site(String url){
        this.URL = url;
        this.COUNT = 0;
    }
    
    public void count(String search){
        Pattern p = Pattern.compile(search.toLowerCase());
        Matcher m = p.matcher(this.SRC.toLowerCase());
        while (m.find())
            this.COUNT++;
    }
    
    public int getCount(){
        return COUNT;
    }
    
    public void setSrc(String src){
        this.SRC = src;
    }

    public String getUrl(){
        return URL;
    }
    public String getSrc(){
        return SRC;
    }

    public boolean equals(Object o){
        if (o instanceof Site){
            return ((Site)o).getUrl().equals(URL);
        }
        return false;
    }

    public int hashCode(){
        return URL.hashCode();
    }
}

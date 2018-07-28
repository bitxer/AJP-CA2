public class Site {
    private String URL;
    private String SRC;

    public Site(String url){
        this.URL = url;
    }

    public void setSrc(String src){
        this.SRC = src;
    }

    public String getUrl(){
        return URL;
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

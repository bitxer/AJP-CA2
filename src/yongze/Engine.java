package yongze;

public enum Engine {
    GOOGLE("https://www.google.com/search?q=");
    private String SEARCHQUERY;

    Engine(String searchQuery){
        SEARCHQUERY = searchQuery;
    }

    public String getSearchQuery(String search){
        return SEARCHQUERY + search.replaceAll(" ", "%20");
    }
    public String getSearchQuery(String search, int page){
        return SEARCHQUERY + search.replaceAll(" ", "%20") + "&start=" + ((page-1)*10);
    }
    
}

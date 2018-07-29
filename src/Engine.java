public enum Engine {
    GOOGLE("https://www.google.com/search?q=");
    private String SEARCHQUERY;

    Engine(String searchQuery){
        SEARCHQUERY = searchQuery;
    }

    public String getSearchQuery(String search){
        return SEARCHQUERY + search;
    }
}

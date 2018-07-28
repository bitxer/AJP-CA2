public class Reader {
    private String ENGINE;
    private String SEARCH;
    private String LINKS;

    public Reader(String engine, String search){
        ENGINE = engine;
        SEARCH = search;
        LINKS = "href=\"(?<href>[\\.A-Za-z0-9/?~!@#$%^&*()_+`\\-=\\[\\]\\{}|;':\",./?]+)\"";
    }

    public Reader(String engine, String search, String links){
        ENGINE = engine;
        SEARCH = search;
        LINKS = links;
    }

    public int read(){
        return PageRead.getLinks(SEARCH, LINKS);

    }
}

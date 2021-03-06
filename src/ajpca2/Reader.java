package ajpca2;

import java.util.ArrayList;

public class Reader {
    private Engine ENGINE;
    private String SEARCH;
    private int page=1;
    private String LINKS;

    public Reader(Engine engine, String search){
        ENGINE = engine;
        SEARCH = search;
        LINKS = "href=\"(?<href>[\\.A-Za-z0-9/?~!@#$%^&*()_+`\\-=\\[\\]\\{}|;':\",./?]+)\"";
    }

    public Reader(Engine engine, String search, String links){
        ENGINE = engine;
        SEARCH = search;
        LINKS = links;
    }
    
    public void setPage(int i){
        page = i;
    }
    public ArrayList<String> read(){
        if (ENGINE.equals(Engine.GOOGLE)) {
            if (page == 1)
                return readGoogle();
            else {
                return readGoogle(page);
            }
        }

        return PageRead.getLinks(SEARCH, LINKS);
    }
    
    private ArrayList<String> readGoogle(int page) {
        return PageRead.getLinks(ENGINE.getSearchQuery(SEARCH, page), "<a href=\"/url\\?q=(?<link>[a-zA-Z0-9:/.-\\\\~!@#$%^*_+`\\-=\\[\\]{}|:\";'<>?,./]+)");
    }
    
    private ArrayList<String> readGoogle() {
        return PageRead.getLinks(ENGINE.getSearchQuery(SEARCH), "<a href=\"/url\\?q=(?<link>[a-zA-Z0-9:/.-\\\\~!@#$%^*_+`\\-=\\[\\]{}|:\";'<>?,./]+)");
    }
}

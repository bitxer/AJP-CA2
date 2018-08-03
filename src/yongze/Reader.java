package yongze;
import java.util.ArrayList;

public class Reader {
    private Engine ENGINE;
    private String SEARCH;
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

    public ArrayList<String> read(){
        if (ENGINE.equals(Engine.GOOGLE)) {
            return readGoogle();
        }

        return PageRead.getLinks(SEARCH, LINKS);
    }

    private ArrayList<String> readGoogle() {
        return PageRead.getLinks(ENGINE.getSearchQuery(SEARCH), "<a href=\"/url\\?q=(?<link>[a-zA-Z0-9:/.-\\\\~!@#$%^*_+`\\-=\\[\\]{}|:\";'<>?,./]+)");
    }
}

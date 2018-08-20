package yongze;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GetSrc implements Runnable{
    private String URL;
    private String SEARCH;
    
    public GetSrc(String url, String search) {
        URL = url.replaceAll(" ", "%20");
        SEARCH = search;
    }

    public void run(){
        Site site = new Site(URL);
        site.setSrc(PageRead.getSrc(URL));
        site.count(SEARCH);
        
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        try (ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream(URL.replaceAll("[^a-zA-Z0-9]+", "") + ".ser"))) {
            out.writeObject(site);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

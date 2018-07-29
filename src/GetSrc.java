import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.Instant;

public class GetSrc extends Thread{
    private String URL;
    public GetSrc(String url) {
        URL = url;
    }

    public void run(){
        Site site = new Site(URL);
        site.setSrc(PageRead.getSrc(URL));
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try (ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream(Instant.now().toEpochMilli() + ".ser"))) {
            out.writeObject(site);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

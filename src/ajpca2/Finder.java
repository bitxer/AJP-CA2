package ajpca2;

import java.util.concurrent.BlockingQueue;

public class Finder extends Thread {

    private Reader READER;
    private BlockingQueue<String> SITES;

    public Finder(Reader reader, BlockingQueue<String> sites) {
        READER = reader;
        SITES = sites;
    }

    public void run() {
        int counter = 0;
        for (String i : READER.read()) {
            counter += 1;
            try {
                SITES.put(cleanURL(i));
                sleep(10);
            } catch (InterruptedException e) {
                return;
            }

        }
        READER.setPage(2);

        for (String i : READER.read()) {
            counter += 1;
            try {
                SITES.put(cleanURL(i));
                sleep(10);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
    private String cleanURL(String url){
        url = url.replaceAll("%25", "%");
        url = url.replaceAll("%3F", "?");
        url = url.replaceAll("%3D", "=");
        url = url.replaceAll("%27", "'");
        return url;
    }
    
}

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Crawler {
    public static void main(String[] args) {

        String search = JOptionPane.showInputDialog("What would you like to search");

        BlockingQueue<String> sites = new ArrayBlockingQueue<>(20);
        Reader reader = new Reader(Engine.GOOGLE, search);
        Handler findLinks = new Handler(reader, sites);
        findLinks.start();

        for (;;){
            String s = sites.poll();
            if (s == null){
                continue;
            }
            new GetSrc(s).start();
        }

    }
}

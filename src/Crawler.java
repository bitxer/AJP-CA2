import javax.swing.*;
import java.util.HashSet;

public class Crawler {
    public static void main(String[] args) {
        String search = JOptionPane.showInputDialog("What would you like to search");
        HashSet<Site> sites = new HashSet<Site>();
        System.out.println(PageRead.getLinks("https://www.google.com/search?q=" + search));

    }
}

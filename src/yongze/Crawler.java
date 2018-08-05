package yongze;

import javax.swing.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Crawler {
    public static void main(String[] args) {

        String search = JOptionPane.showInputDialog("What would you like to search");

        BlockingQueue<String> sites = new ArrayBlockingQueue<>(20);
        Reader reader = new Reader(Engine.GOOGLE, search);
        Finder findLinks = new Finder(reader, sites);
        findLinks.start();

        for (;;){
            String s = sites.poll();
            if (s == null){
                continue;
            }
            new GetSrc(s).start();
        }

    }

    private static void showSites(String[] sites) {
        JDialog dialog = null;
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage("Available Sites");
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 1));
        JButton[] buttons = new JButton[sites.length];
        for (int i = 0; i < sites.length; i++) {
            buttons[i] = new JButton(sites[i]);
            panel.add(buttons[i]);
        }
        optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
        optionPane.add(panel);
        dialog = optionPane.createDialog(null, "Icon/Text Button");
        dialog.setVisible(true);
    }
}


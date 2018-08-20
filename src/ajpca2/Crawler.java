package ajpca2;

import javax.swing.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Crawler {

    public static void main(String[] args) throws InterruptedException {

        String search = JOptionPane.showInputDialog("What would you like to search");

        BlockingQueue<String> sites = new ArrayBlockingQueue<>(20);
        Reader reader = new Reader(Engine.GOOGLE, search);
        Finder findLinks = new Finder(reader, sites);
        findLinks.start();
        Object[] threadCount = {2,4,6,8,10,12};
        
        int i = 0;
        
        int n = JOptionPane.showOptionDialog(null,
                "How many threads do you want to run?",
                "Input",
                0,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                threadCount,
                threadCount[i]);
        
        n = (int) threadCount[n];
        
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        String[] vSites = new String[12];
        long start = System.currentTimeMillis();
        for (i = 0; i < 12; i++) {
            String s = sites.poll();
            
            if (s == null){
                i--;
                continue;
            }
            
            vSites[i] = s;
            
            Runnable r = new GetSrc(s, search);
            executorService.execute(r);
            
        }
        
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        long end = System.currentTimeMillis();
        
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(end-start) + " seconds");

        ResultsUI r = new ResultsUI();
        r.setButtons(vSites);
        r.setVisible(true);

    }

}

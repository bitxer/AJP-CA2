package ajpca2;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageRead {
    private static StringBuilder readPage(String pageAddr) {
        try {
            System.setProperty("http.agent", "Mozilla/5.0");
            URL url = new URL(pageAddr);
            BufferedReader reader = null;
            StringBuilder sb = new StringBuilder();
            try {
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
                return sb;
            }
          
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line+"\n");
            }
 
            reader.close();

			return sb;            
        } catch (MalformedURLException e) {
            e.printStackTrace();
			return new StringBuilder("");
        }  catch (IOException e) {
            e.printStackTrace();
			return new StringBuilder("");
        }
    }

    public static ArrayList<String> getLinks(String pageAddr){
        return getLinks(pageAddr, "href=\"(?<link>[\\.A-Za-z0-9/?~!@#$%^&*\\(\\)_+`\\-=\\[\\]\\{}|;':\",./?]+)\"");
    }

    public static ArrayList<String> getLinks(String pageAddr, String pattern){
        String html = readPage(pageAddr).toString();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(html);
        ArrayList<String> links = new ArrayList<>();
        while (m.find()) {
            String link = m.group("link");
            if (links.contains(link))
                continue;
            links.add(m.group("link"));
        }

        return links;
    }

    public static String getSrc(String url){
        return readPage(url).toString();
    }
}
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageRead {
    private static StringBuilder readPage(String pageAddr) {
        try {
            System.setProperty("http.agent", "Mozilla/5.0");
            URL url = new URL(pageAddr);
 
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
          
            String line;
            StringBuilder sb=new StringBuilder();
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

    public static int getLinks(String pageAddr){
        return getLinks(pageAddr, "href=\"(?<href>[\\.A-Za-z0-9/?~!@#$%^&*()_+`\\-=\\[\\]\\{}|;':\",./?]+)\"");
    }

    public static int getLinks(String pageAddr, String pattern){
        String html = readPage(pageAddr).toString();
        //System.out.println(html);

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(html);
        while (m.find()) {
            System.out.println(m.group("href"));
        }

        return 1;
    }
}
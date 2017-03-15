package weather;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

/**
 * Created by Kesava on 01/03/2017.
 */


public class ReadRSS {

    public static void main(String[] args) {

        System.out.println(readRSSFeed("http://open.live.bbc.co.uk/weather/feeds/en/2641170/3dayforecast.rss"));
    }

    public static String readRSSFeed(String urlAddress){
        try{
            URL rssUrl = new URL (urlAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
            String sourceCode = "";
            String line;
            while((line=in.readLine())!=null){
                if(line.contains("<title>")){
                    System.out.println(line);
                    int firstPos = line.indexOf("<title>");
                    String temp = line.substring(firstPos);
                    temp=temp.replace("<title>","");
                    int lastPos = temp.indexOf("</title>");
                    temp = temp.substring(0,lastPos);
                    sourceCode +=temp+ "\n" ;
                }
            }
            in.close();
            return sourceCode;
        } catch (MalformedURLException ue){
            System.out.println("Malformed URL");
        } catch (IOException ioe){
            System.out.println("Something went wrong reading the contents");
        }
        return null;
    }
}
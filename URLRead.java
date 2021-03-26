import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class URLRead {

    public ArrayList<String> readURL(String urlstr) {
        ArrayList<String> lst = new ArrayList<>();
        String line = "";
        try {
            URL url = new URL(urlstr);
            InputStreamReader inread = new InputStreamReader(url.openStream());
            BufferedReader bufr = new BufferedReader(inread);
            line = bufr.readLine();
            while (line != null) {
                lst.add(line);
                line = bufr.readLine();
            }
            //System.out.println(line);
        } catch (Exception e) {
            System.out.println("Fejl i url =" + e.getMessage());
        }
        return lst;
    }

}

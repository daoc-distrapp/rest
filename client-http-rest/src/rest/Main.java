
package rest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author dordonez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        URL url;
        HttpURLConnection con;
        
        try {
            url = new URL("http://localhost:8080/app/rest/datos");
            con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            //con.setRequestProperty("Accept", "text/plain");
            con.connect();
            
            System.out.println(con.getResponseCode());
            Scanner in = new Scanner(con.getInputStream());
            String line = "";
            while (in.hasNextLine()) {
                line += in.nextLine();
            }
            System.out.println(line);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }
    
}

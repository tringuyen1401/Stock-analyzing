/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Cookies {  
    public static void fetch(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            InputStream in = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            int status = conn.getResponseCode();
            System.out.println("Status = " + status);
            String key;
            
           List<String> cookies = conn.getHeaderFields().get("Set-Cookie");
           System.out.println(cookies);
            System.out.println("Headers-------start-----");
            for (int i = 1; (key = conn.getHeaderFieldKey(i)) != null; i++) {
                System.out.println(key + ":" + conn.getHeaderField(i));
            }
            System.out.println("Headers-------end-----");
            System.out.println("Content-------start-----");
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
            System.out.println("Content-------end-----");
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        CookieHandler.setDefault( new CookieManager( null, CookiePolicy.ACCEPT_ALL ) );
        
        fetch("http://www.cophieu68.vn/export.php");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        String prompt = "> ";
        String urlString;
        try {
            for (System.out.print(prompt);
                    (urlString = reader.readLine()) != null; 
                    System.out.print(prompt)) 
            {
                fetch(urlString);
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

}

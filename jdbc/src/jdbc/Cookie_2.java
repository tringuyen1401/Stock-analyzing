/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author tri
 */
public class Cookie_2 {
    public static void main(String[] arg) {
     Cookie_2 obj = new Cookie_2();
        obj.getCookieUsingCookieHandler();   
    }
    public void getCookieUsingCookieHandler() { 
    try {       
        // Instantiate CookieManager;
        // make sure to set CookiePolicy
        CookieManager manager = new CookieManager();
        manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(manager);

        // get content from URLConnection;
        // cookies are set by web site
        URL url = new URL("http://www.cophieu68.vn/account/login.php");
        URLConnection connection = url.openConnection();
        connection.getContent();

        // get cookies from underlying
        // CookieStore
        CookieStore cookieJar =  manager.getCookieStore();
        List <HttpCookie> cookies =
            cookieJar.getCookies();
        for (HttpCookie cookie: cookies) {
          System.out.println("CookieHandler retrieved cookie: " + cookie);
        }
    } catch(Exception e) {
        System.out.println("Unable to get cookie using CookieHandler");
        e.printStackTrace();
    }
}
    
    public void setCookieUsingCookieHandler() {
    try {
        // instantiate CookieManager
        CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);
        CookieStore cookieJar =  manager.getCookieStore();

        // create cookie
        HttpCookie cookie = new HttpCookie("UserName", "hello_nguyenson@live.com");

        // add cookie to CookieStore for a
        // particular URL
        URL url = new URL("http://www.cophieu68.vn/export.php");
        cookieJar.add(url.toURI(), cookie);
        System.out.println("Added cookie using cookie handler");
    } catch(Exception e) {
        System.out.println("Unable to set cookie using CookieHandler");
        e.printStackTrace();
    }
}
    public static void exam(){
        HttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost("https://example.com/login");
HttpResponse response = null;
List<NameValuePair> postFields = new ArrayList<NameValuePair>(2);

// Set the post fields
postFields.add(new BasicNameValuePair("username", "myusername"));
postFields.add(new BasicNameValuePair("password", "mypassword"));
post.setEntity(new UrlEncodedFormEntity(postFields, HTTP.UTF_8));

// Execute the POST request
response = client.execute(post);

// Now GET the file
HttpGet get = new HttpGet("http://example.com/files/myfile.mp3");
response = client.execute(get);

HttpEntity entity = response.getEntity();
InputStream in = entity.getContent();

// Save the file to SD
File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
path.mkdirs();
File file = new File(path, "myfile.mp3");
FileOutputStream fos = new FileOutputStream(file);

byte[] buffer = new byte[1024];
int len1 = 0;
while ((len1 = in.read(buffer)) > 0) {
        fos.write(buffer, 0, len1);
}

fos.close();
    }
    
    }


package jdbc;


import java.io.*;  
import java.net.*;  
import java.util.List;

  
public class GetCookiePrintAndSetValue {  
  public static void main(String[] arg) throws IOException {
      GetCookiePrintAndSetValue obj = new GetCookiePrintAndSetValue();
      obj.login();
      
  }
 public static boolean downloadFileFromURL(String fetchUrl, String savePathAndFilename)  
throws IOException,FileNotFoundException,IOException {  
      
    HttpURLConnection c;  
   
    //save file       
    URL url = new URL(fetchUrl);  
    c = (HttpURLConnection)url.openConnection();  
      
    //set cache and request method settings  
    c.setUseCaches(true);  
    c.setDoOutput(true);  
      
    //set other headers  
    c.setRequestProperty ("Content-Type", "application/x-www-form-urlencoded");  
    
    //connect  
    c.connect();  
      
    BufferedInputStream in = new BufferedInputStream(c.getInputStream());  
  
    OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(savePathAndFilename)));  
    byte[] buf = new byte[256];  
    int n = 0;  
    while ((n=in.read(buf))>=0) {  
       out.write(buf, 0, n);  
    }  
    out.flush();  
    out.close();  
     
    return true;          
}
 // Variables to hold the URL object and its connection to that URL.

    private static URL URLObj;

    private static URLConnection connect;

     

    public static void login() {
        try {
           CookieManager  manager = new CookieManager();
            manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(manager);
        
            // Establish a URL and open a connection to it. Set it to output mode.

            URLObj = new URL("http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/");

            connect = URLObj.openConnection();

            connect.setDoOutput(true); 
            
        
        }

        catch (MalformedURLException ex) {

            System.out.println("The URL specified was unable to be parsed or uses an invalid protocol. Please try again.");

            System.exit(1);

        }

        catch (Exception ex) {

            System.out.println("An exception occurred. " + ex.getMessage());

            System.exit(1);

        }

         

         
        try {
          
            
            // Create a buffered writer to the URLConnection's output stream and write our forms parameters.

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connect.getOutputStream()));

            writer.write("username=hello_nguyenson@live.com&tpassword=19931994&submit=ogin");

            writer.close();

             

            // Now establish a buffered reader to read the URLConnection's input stream.

            BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));

             

            String lineRead = "";
             

            // Read all available lines of data from the URL and print them to screen.

            while ((lineRead = reader.readLine()) != null) {

                System.out.println(lineRead);

            }

             
            
            reader.close();  
            
              List<String> cookies = connect.getHeaderFields().get("Set-Cookie");
            GetCookiePrintAndSetValue obj = new GetCookiePrintAndSetValue();
               
 //     obj.downloadFileFromURL("http://www.cophieu68.vn/export/excel.php?id=AAA","C:\\Users\\tri\\Desktop\\busi\\data\\123.txt");

        }

        catch (Exception ex) {

            System.out.println("There was an error reading or writing to the URL: " + ex.getMessage());

        }

    }

}  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;
import jdbc.Myauth;

 
/**
 * A utility that downloads a file from a URL.
 * @author www.codejava.net
 *
 */
public class Download {
    public static void main(String[] args) throws IOException {
       
        Integer linenumber = 2;
        
        Download dl = new Download();
        String company_code = null;
  //     downloadFile_WRITE_BS("https://www.vcsc.com.vn/Modules/Analysis/Web/IncomeReport.aspx?id="+linenumber+"&unit=2&dir=","C:\\Users\\tri\\Desktop\\busi\\data",linenumber);
       
         //obj.downloadFile_PRICE("http://www.cophieu68.vn/export/excel.php?id="+obj.readfile(linenumber),"C:\\Users\\tri\\Desktop\\busi\\data");
      String full = "";
        String company = "";
        
        while (linenumber < 756) {
            full = dl.readfile(linenumber);
            if (full.equals("FLCS  974")) {
                company_code = "974"; 
                company = "FLCS";
            } else {
            company_code = full.substring(5, dl.readfile(linenumber).length());
            company = full.substring(0,3);
            }
 
 /*_IS All*/        downloadFile_WRITE_IS("https://www.vcsc.com.vn/Modules/Analysis/UserControls/CompanyAZ/FinancialReport/Baocaolailo_excel.aspx?id="+company_code+"&unit=2&dir=","C:\\Users\\tri\\Desktop\\busi\\data\\All",linenumber);
 /*BS All*/ downloadFile_WRITE_BS("https://www.vcsc.com.vn/Modules/Analysis/UserControls/CompanyAZ/FinancialReport/ExportExcel/BalanceSheetByYear_ExcelAll.aspx?id="+company_code+"&unit=2&dir=0","C:\\Users\\tri\\Desktop\\busi\\data\\All",linenumber);
 /*CFS All*/  downloadFile_WRITE_CFS("https://www.vcsc.com.vn/Modules/CompanyAZ/UserControls/ExportExcel/FinicialCashFlowCompanyExcelAll.aspx?DonVi=2&ID="+company_code,"C:\\Users\\tri\\Desktop\\busi\\data\\All",linenumber);
 /*_FI All*/        downloadFile_WRITE_FI("https://www.vcsc.com.vn/Modules/Analysis/Web/FinancialIndexByYearExport.aspx?id="+company_code+"&cur=2015","C:\\Users\\tri\\Desktop\\busi\\data\\All",linenumber);
 
 /*Current*/
 
 /*IS*/  //downloadFile_WRITE_IS("https://www.vcsc.com.vn/Modules/Analysis/Web/IncomeReport.aspx?id="+company_code+"&unit=2&dir=","C:\\Users\\tri\\Desktop\\busi\\data\\",linenumber);
 /*BS*/ // downloadFile_WRITE_BS("https://www.vcsc.com.vn/Modules/Analysis/UserControls/CompanyAZ/FinancialReport/ExportExcel/BalanceSheetByYear_Excel.aspx?id="+company_code+"&unit=2&dir=0","C:\\Users\\tri\\Desktop\\busi\\data\\",linenumber);
 /*CFS*/ // downloadFile_WRITE_CFS("https://www.vcsc.com.vn/Modules/CompanyAZ/UserControls/ExportExcel/FinicialCashFlowCompanyExcel.aspx?year1=2013&year2=2012&year3=2011&year4=2010&year5=0&DonVi=2&ID="+company_code,"C:\\Users\\tri\\Desktop\\busi\\data\\",linenumber);
 /*FI*/  //  downloadFile_WRITE_FI("https://www.vcsc.com.vn/Modules/Analysis/Web/FinancialIndexByYearExport.aspx?id="+company_code+"&cur=2015","C:\\Users\\tri\\Desktop\\busi\\data\\",linenumber);
   
   System.out.println(company);       
    linenumber = linenumber +1;
        }
    }
     
     public static String readfile(Integer linenumber) {

        // The name of the file to open.
        String fileName = "C:\\Users\\tri\\Desktop\\busi\\text data\\data - Copy.txt";
        
        // This will reference one line at a time
        String line = null;
        Integer n = 1;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
               
                if (Objects.equals(linenumber, n)) {
                    
                break;
                }
                 n = n+1;
            }    

            // Always close files.
            bufferedReader.close();            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                   
            // Or we could just do this: 
            // ex.printStackTrace();
        } finally {
            return line;
        }
    }
     
     
     public static void writefile(String content) {
		try {
 
			
 
			File file = new File("C:\\Users\\tri\\Desktop\\yolo.txt");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                         out.println(content);
			out.close();
 
	//		System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    private static final int BUFFER_SIZE = 4096;
 
    /**
     * Downloads a file from a URL
     * @param fileURL HTTP URL of the file to be downloaded
     * @param saveDir path of the directory to save the file
     * @throws IOException
     */
    
    public static void downloadFile(String fileURL, String saveDir)
            throws IOException {
         java.net.CookieManager cm = new java.net.CookieManager();
        java.net.CookieHandler.setDefault(cm);
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String company = "";
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();
 
            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    company = disposition.substring(index + 64,disposition.length() - 13);
                    fileName = disposition.substring(index + 64,disposition.length() - 13)+"_FI.csv";
                   
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }
 
    //        System.out.println("Content-Type = " + contentType);
    //        System.out.println("Content-Disposition = " + disposition);
    //        System.out.println("Content-Length = " + contentLength);
     //       System.out.println("fileName = " + fileName);
 
            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
    //        System.out.println("File downloaded");
        } else {
    //        System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
    
    
    
     public static void downloadFile_WRITE_FI(String fileURL, String saveDir,Integer linenumber)
            throws IOException {
         
          
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String company = "";
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            String cookie = httpConn.getHeaderField("Set-Cookie");
            int contentLength = httpConn.getContentLength();
 
            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    company = disposition.substring(index + 64,disposition.length() - 13);
                    fileName = disposition.substring(index + 64,disposition.length() - 13)+"_FI.xls";
                   
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 14,
                        fileURL.length())+"_FI.xls";
            }
    //        System.out.println(linenumber+" , "+company);
    //        Download obj = new Download();
  //          obj.writefile(company+"  "+linenumber);
   //        System.out.println("Content-Type = " + contentType);
  //         System.out.println("Cookie = " + cookie);
   //        System.out.println("Content-Disposition = " + disposition);
   //         System.out.println("Content-Length = " + contentLength);
   //         System.out.println("fileName = " + fileName);
            
            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
    //        System.out.println("File downloaded");
        } else {
    //        System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
    
     public static void downloadFile_WRITE_IS(String fileURL, String saveDir,Integer linenumber)
            throws IOException {
         
          
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String company = "";
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            String cookie = httpConn.getHeaderField("Set-Cookie");
            int contentLength = httpConn.getContentLength();
 
            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    company = disposition.substring(index + 64,disposition.length() - 13);
                    fileName = disposition.substring(index + 64,disposition.length() - 13)+"_IS.xls";
                   
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(
                        fileURL.length())+"_IS.xls";
            }
     //       System.out.println(linenumber+" , "+company);
     //       Download obj = new Download();
      //      obj.writefile(company+"  "+linenumber);
    //      System.out.println("Content-Type = " + contentType);
    //       System.out.println("Cookie = " + cookie);
     //      System.out.println("Content-Disposition = " + disposition);
     //       System.out.println("Content-Length = " + contentLength);
     //       System.out.println("fileName = " + fileName);
            
            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
    //        System.out.println("File downloaded");
        } else {
    //        System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
      
     public static void downloadFile_WRITE_CFS(String fileURL, String saveDir,Integer linenumber)
            throws IOException {
         
          
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String company = "";
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            String cookie = httpConn.getHeaderField("Set-Cookie");
            int contentLength = httpConn.getContentLength();
 
            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    company = disposition.substring(index + 66,disposition.length() - 13);
                    fileName = disposition.substring(index + 66,disposition.length() - 13)+"_CFS.xls";
                   
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(
                        fileURL.length())+"_CFS.xls";
            }
     //       System.out.println(linenumber+" , "+company);
   //         Download obj = new Download();
   //         obj.writefile(company+"  "+linenumber);
   //        System.out.println("Content-Type = " + contentType);
  //         System.out.println("Cookie = " + cookie);
    //       System.out.println("Content-Disposition = " + disposition);
   //         System.out.println("Content-Length = " + contentLength);
    //        System.out.println("fileName = " + fileName);
            
            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
    //        System.out.println("File downloaded");
        } else {
    //        System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
public static void downloadFile_WRITE_BS(String fileURL, String saveDir,Integer linenumber)
            throws IOException {
         
          
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String company = "";
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            String cookie = httpConn.getHeaderField("Set-Cookie");
            int contentLength = httpConn.getContentLength();
 
            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    company = disposition.substring(index + 61,disposition.length() - 13);
                    fileName = disposition.substring(index + 61,disposition.length() - 13)+"_BS.xls";
                   
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(
                        fileURL.length())+"_BS.xls";
            }
  //          System.out.println(linenumber+" , "+company);
            
    //        Download.writefile(company+"  "+linenumber);
   //        System.out.println("Content-Type = " + contentType);
  //         System.out.println("Cookie = " + cookie);
   //        System.out.println("Content-Disposition = " + disposition);
   //         System.out.println("Content-Length = " + contentLength);
   //         System.out.println("fileName = " + fileName);
            
            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
    //        System.out.println("File downloaded");
        } else {
    //        System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
     
}

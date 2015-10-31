/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 *
 * @author tri
 */
public class Intersection {
    public static void main(String[] arg) {
        Integer n = 1;
        while (readfile("C:\\Users\\tri\\Desktop\\busi\\text data\\data_cp.txt",n) != null) {
       //     System.out.println(readfile("C:\\Users\\tri\\Desktop\\busi\\yolo+IS.txt",n));
            compare(readfile("C:\\Users\\tri\\Desktop\\busi\\text data\\data_cp.txt",n));
            n = n+1;
        }
    }
    
    public static void duplicate (String str,Integer linenumber) {
        Integer n = linenumber+1;
        String str2 = readfile("C:\\Users\\tri\\Desktop\\data.txt",n);
        while (str2 != null) {
            
            if (str.equals(str2)) {
                writefile(str);
                System.out.println(str);
            } 
            n = n+1;
            str2 = readfile("C:\\Users\\tri\\Desktop\\data.txt",n);
        }
    }
    public static void compare(String str) {
        
        Integer n = 1;
        while (n < 1305) {
      //      System.out.println(readfile("C:\\Users\\tri\\Desktop\\busi\\data_cp.txt",n));
            String str2 = readfile("C:\\Users\\tri\\Desktop\\busi\\text data\\yolo+IS.txt",n);
          if (str2 != null) {  
              
            if (str.equals(str2.substring(0,3))) {
                
                writefile(str2);
                System.out.println(str2.substring(0,str.length()));
                n = 1305;
            }
              
          }
            n = n+1;
            
        }
    }
    public static String readfile(String path,Integer linenumber) {

        // The name of the file to open.
        String fileName = path;
        
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
}

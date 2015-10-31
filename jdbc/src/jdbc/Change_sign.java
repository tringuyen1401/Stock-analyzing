/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tri
 */
public class Change_sign {
    
     public static boolean isDouble(final String s) {
        //check if data[5] is a Double
    try {
        Double.parseDouble(s);
        return true;
    } catch(NumberFormatException e) {
        return false;
    }
}
    public static void main(String[] args) throws FileNotFoundException {
 
	Change_sign obj = new Change_sign();
	obj.run();
 
  }
 
  public void run() throws FileNotFoundException {
 
	BufferedReader br = null;
	Integer n = 0;
        Double today = 0.0;
        Double yesterday = 0.0;
        String sign = null;
        Double Pup = 0.0;
        Double Pdown= 0.0;
        
	try {
                String[] row = null;
                String csvFilename = "C:\\Users\\tri\\Desktop\\VI\\BUSINESS\\VCB_PRICE.csv";
                
                String line = "";
                String cvsSplitBy = ",";
                
                CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
                List content = csvReader.readAll();//read whole file
                
                    for (Object object : content) {
                     row = (String[]) object;
                       
                    
                      if(isDouble(row[5])) {  //check if row[5] is double
                       yesterday = Double.parseDouble(row[5]);    
                       Double change = (today - yesterday)/yesterday*100; //%change
                       if (change != -100){
                       if (change > 0) {
                       sign = "UP"; 
                       Pup = today;
                       Pdown = 0.0;
                       } else if (change < 0) {
                        sign = "DOWN";
                        Pup = 0.0;
                       Pdown = today;
                       } else {
                        sign = "NOTHING";
                        Pup = 0.0;
                       Pdown = 0.0;
                       }
                        System.out.println(change+" , "+ sign+" , "+row[5]+" , "+Pup+" , "+Pdown);
                       }
         //       if (n > 0) {       
               
       //         } //remove first line
                
                today = Double.parseDouble(row[5]);
                
                n = n+1; 
            } else {

            csvReader.close();        
                      }
                    }
     //                  }
     //                  else {
     //                     System.out.println(%Change);
                    
    //                    }
	//	}
                        
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	System.out.println("Done");
  }
 
    
}

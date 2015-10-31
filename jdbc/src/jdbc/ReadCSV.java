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
import java.math.*;

/**
 *
 * @author tri
 */
public class ReadCSV {
    
    public static boolean isDouble(final String s) {
        //check if data[5] is a Double
    try {
        Double.parseDouble(s);
        return true;
    } catch(NumberFormatException e) {
        return false;
    }
}
    public static void main(String[] args) {
 
	ReadCSV obj = new ReadCSV();
	obj.run();
 
  }
 
  public void run() {
        String company = "AMC";
	String csvFilename = "C:\\Users\\tri\\Desktop\\VI\\BUSINESS\\"+company+".csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
        Double today = 0.0;
	try {
 
		br = new BufferedReader(new FileReader(csvFilename));
		while ((line = br.readLine()) != null) {
                        
		        // use comma as separator
			String[] data = line.split(cvsSplitBy);
                        if(isDouble(data[5])) {  
                             Double yesterday = Double.parseDouble(data[5]);    
                       Double change = (today - yesterday)/yesterday*100;
			System.out.println(change+" , "+yesterday);
                        today = Double.parseDouble(data[5]);
                            
                       }
                        else {
                          System.out.println("%Change");
                     
                        }
		}
 
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

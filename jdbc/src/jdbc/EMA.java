/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tri
 */
public class EMA {
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
 
	EMA obj = new EMA();
	obj.run();
 
  }
 
  public void run() throws FileNotFoundException {
 
	
	BufferedReader br = null;
	
	Integer n = 0;
        Double today = 0.0;
        String sign = null;
        Double day1 = 0.0;
        Double day2 = 0.0;
        Double day3 = 0.0;
        Double day4 = 0.0;
        Double day5 = 0.0;
        Double day6 = 0.0;
        Double day7 = 0.0;
        Double day8 = 0.0;
        Double day9 = 0.0;
        Double day10 = 0.0;
        Double day11 = 0.0;
        Double day12 = 0.0;
        Double day13 = 0.0;
        Double day14 = 0.0;
        
        Integer k = 2/15;
        Double yesterday = 0.0;
        Double yEMA = 0.0;
        Double tEMA = 0.0;
        ArrayList al = new ArrayList();
	try {
                String[] row = null;
                String csvFilename = "C:\\Users\\tri\\Desktop\\VI\\BUSINESS\\VCB_PRICE.csv";
                
                CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
                List content = csvReader.readAll();
                
		        // use comma as separator
    
		Collections.reverse(content);
                    for (Object object : content) {
                     row = (String[]) object;
                       n = n+1;
                    
                      if(isDouble(row[5])) {  //check if row[5] is double
                       today = Double.parseDouble(row[5]);    
                       
                      if (n <15) { 
                          
                       day14 = day13;
                       day13=day12;
                       day12=day11;
                       day11=day10;
                       day10=day9;
                       day9=day8;
                       day8=day7;
                       day7=day6;
                       day6=day5;
                       day5=day4;
                       day4=day3;
                       day3=day2;
                       day2=day1;
                       day1 = today;
                      if(n == 14){ 
                    tEMA = (day1+day2+day3+day4+day5+day6+day7+day8+day9+day10+day11+day12+day13+day14)/14;
                    
                      }} else {
                    yEMA = tEMA;      
                    tEMA = today*0.13333333333 + yEMA*(1-0.13333333333);
                      }
                al.add(tEMA);
         //       System.out.println(n+","+today+","+tEMA);
                       yesterday = Double.parseDouble(row[5]);
                 
            } else {

            csvReader.close();        
                      }
                    }
            Collections.reverse(al);
            // Get size and display.
	int count = al.size();
	System.out.println("Count: " + count);

	// Loop through elements.
	for (int i = 0; i < al.size(); i++) {
	    
	    System.out.println(al.get(i));
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

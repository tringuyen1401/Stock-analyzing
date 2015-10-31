/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.List;
import static jdbc.RSI.isDouble;

/**
 *
 * @author tri
 */
public class test {
    public static void main(String[] args) throws FileNotFoundException {
 
	test obj = new test();
	obj.run();
 
  }
    public void run (){
         Integer n = 0;
        Integer u = 0;
        Integer d = 0;
        Double today = 0.0;
        Double yesterday = 0.0;
        String sign = null;
        Double UP1 = 0.0;
        Double UP2 = 0.0;
        Double UP3 = 0.0;
        Double UP4 = 0.0;
        Double UP5 = 0.0;
        Double UP6 = 0.0;
        Double UP7 = 0.0;
        Double UP8 = 0.0;
        Double UP9 = 0.0;
        Double UP10 = 0.0;
        Double UP11= 0.0;
        Double UP12= 0.0;
        Double UP13 = 0.0;
        Double UP14 = 0.0;
        Double DOWN1 = 0.0;
        Double DOWN2 = 0.0;
        Double DOWN3 = 0.0;
        Double DOWN4 = 0.0;
        Double DOWN5 = 0.0;
        Double DOWN6 = 0.0;
        Double DOWN7 = 0.0;
        Double DOWN8 = 0.0;
        Double DOWN9 = 0.0;
        Double DOWN10 = 0.0;
        Double DOWN11 = 0.0;
        Double DOWN12 = 0.0;
        Double DOWN13 = 0.0;
        Double DOWN14 = 0.0;
        Double avgDOWN = 0.0;
        Double avgUP = 0.0;
        Double RSI = 0.0;
        Double rs = 0.0;
        
	try {
                String[] row = null;
                
                
                String csvFilename = "C:\\Users\\tri\\Desktop\\VI\\BUSINESS\\AMV_PRICE.csv";
                CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
                List content = csvReader.readAll();//read whole file
                
                    for (Object object : content) {
                     row = (String[]) object;
                       
                    
                      if(isDouble(row[5])) {  //check if row[5] is double
                          
                              if (isDouble(row[1])) {
                                  if (d < 16 && u < 16) {
                          if ((20141231 - Double.parseDouble(row[1])) >= 0) {
                       today = Double.parseDouble(row[5]);
                       
                       Double change = (yesterday - today )/today*100; //%change
                       Double dif = abs(today - yesterday);
                       if (change > 0) {
                           if (u < 15){
                        sign = "UP";
                       UP14 = UP13;
                       UP13 = UP12;
                       UP12 = UP11;
                       UP11 = UP10;
                       UP10 = UP9;
                       UP9 = UP8;        
                       UP8 = UP7;
                       UP7 = UP6;
                       UP6 = UP5;
                       UP5 = UP4;
                       UP4 = UP3;
                       UP3 = UP2;
                       UP2 = UP1;
                       if (yesterday != 0) {
                       UP1 = dif;
                       u = u+1;
                       System.out.println(row[1]+" , "+UP1+" , "+UP2+" , "+UP3+" , "+UP4+" , "+UP5+" , "+UP6+" , "+UP7+" , "+UP8+" , "+UP9+" , "+UP10+" , "+UP11+" , "+UP12+" , "+UP13+" , "+UP14);
                       }
                       if (u == 14){
                       avgUP = (UP1+UP2+UP3+UP4+UP5+UP6+UP7+UP8+UP9+UP10+UP11+UP12+UP13+UP14)/14;    
                       } 
                       
                       }
                       } else if (change < 0) {
                        
                        
                        if (d < 15) {
                        sign = "DOWN";    
                        DOWN14 = DOWN13 ;
                        DOWN13 = DOWN12 ;
                        DOWN12 = DOWN11 ;
                        DOWN11 = DOWN10 ;
                        DOWN10 = DOWN9 ;
                        DOWN9 = DOWN8 ;
                        DOWN8 = DOWN7 ;
                        DOWN7 = DOWN6 ;
                        DOWN6 = DOWN5 ;
                        DOWN5 = DOWN4 ;
                        DOWN4 = DOWN3 ;
                        DOWN3 = DOWN2 ;
                        DOWN2 = DOWN1 ;
                        if (yesterday != 0) {
                        DOWN1 = dif;
                        d = d+1;
                        }
                       // System.out.println(row[1]+" , "+sign+ " , "+RSI+" , "+avgDOWN+" , "+avgUP+" , "+ DOWN14+" , "+UP14+" , "+UP1+" , "+DOWN1);
                        if (d == 14){
                        avgDOWN = (DOWN1+DOWN2+DOWN3+DOWN4+DOWN5+DOWN6+DOWN7+DOWN8+DOWN9+DOWN10+DOWN11+DOWN12+DOWN13+DOWN14)/14;
                        }   
                       }
                        
                       } else {
                           sign = "NOTHING";
                       }
                       if (d == 15 && u == 15) {
                          rs = avgUP/avgDOWN;
                          RSI = 100-(100/(1+rs));
                          System.out.println(row[1]+" , "+sign+ " , "+RSI+" , "+avgDOWN+" , "+avgUP+" , "+ DOWN14+" , "+UP14+" , "+UP1+" , "+DOWN1);
                          d = d+1;
                          u = u+1;
                      }
               
                n = n+1; 
                yesterday = Double.parseDouble(row[5]);               }
            } 
                      } else {

            csvReader.close();        
                      }
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
		
	}
 
	System.out.println("Done");
  }
}

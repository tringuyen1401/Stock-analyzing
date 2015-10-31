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
import static java.lang.Math.abs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 *
 * @author tri
 */
public class Import_data_csv {
    
   public static void main(String[] args) {
    Import_data_csv obj = new Import_data_csv();
    obj.get_conn();
    }
    
    public static void addCompany(Connection conn,PreparedStatement prestatement, String name) throws SQLException//creating templates for prepared statement
    {
       prestatement = conn.prepareStatement ("CREATE TABLE "+ name + " ( Date INT(9) UNSIGNED, High DOUBLE(7,2) NOT NULL,Low DOUBLE(7,2) NOT NULL,Close DOUBLE(7,2),Volume INT(9))");
       
        
        
    }
    public static void addEMA(Connection conn,PreparedStatement prestatement,String name, Double ema) throws SQLException//creating templates for prepared statement 
    {
        prestatement = conn.prepareStatement("INSERT INTO "+name+" (ema) VALUES (?);");
        
       prestatement.setDouble(1, ema);
        
    }
    public static void addchange_sign(Connection conn,PreparedStatement prestatement,String name, Double change, String sign) throws SQLException//creating templates for prepared statement 
    {
        prestatement = conn.prepareStatement("INSERT INTO "+name+" (chang,sign) VALUES (?, ?);");
        prestatement.setDouble(1, change);
        prestatement.setString(2, sign);
    }
    
    public static void addRSI(Connection conn,PreparedStatement prestatement,String name, Double rsi) throws SQLException//creating templates for prepared statement 
    {
        prestatement = conn.prepareStatement("INSERT INTO "+name+" (rsi) VALUES (?);");
        prestatement.setDouble(1, rsi);
       
    }
    public static void addData(Connection conn,PreparedStatement prestatement, String name, Double Date, Double Open, Double High, Double Low, Double Close,Double Volume,Double change,String sign, Double ema, Double rsi) throws SQLException//creating templates for prepared statement
    {
       prestatement = conn.prepareStatement("INSERT INTO "+name+" (Date,Open, High,Low,Close,Volume,chang,sign,ema,rsi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"); //watchout for prepareStament,it is a query,not variable
       prestatement.setDouble(1, Date); //set string value to the first "?"
       prestatement.setDouble(2, Open);
       prestatement.setDouble(3, High); // set string value to the second "?"
       prestatement.setDouble(4, Low);
       prestatement.setDouble(5, Close);
       prestatement.setDouble(6 , Volume);
       prestatement.setDouble(7 , change);
       prestatement.setString(8 , sign);
       prestatement.setDouble(9 , ema);
       prestatement.setDouble(10 , rsi);
       
       
       prestatement.executeUpdate();
           
    
    }
    
    public void get_conn() {
    
    Connection conn = null;    
    String url = "jdbc:mysql://localhost:3308/";
    String dbName = "test";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root"; 
    String password = "root";
    Statement statement = null;
    ResultSet result = null;
    PreparedStatement prestatement = null;
    String company = "AMC";
    String csvFilename = "C:\\Users\\tri\\Google Drive\\Data\\EXCEL_"+company+".csv";
    BufferedReader br = null;
    Double today= 0.0;
    Double yesterday= 0.0;
    String sign = "";
    Integer n = 0;
    Double todayema = 0.0;
    Integer p = 1;    
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
        Double yesterdayema = 0.0;
        Double yEMA = 0.0;
        Double tEMA = 0.0;
        ArrayList al = new ArrayList();
        Double RSI = 0.0;
        Double todate = 0.0;
    try {
    
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url+dbName,userName,password);
        
        statement = conn.createStatement();
        statement.execute("DROP TABLE IF EXISTS "+company+";"); 
        statement.execute("CREATE TABLE "+company+" ( Date INT(9) UNSIGNED, Open DOUBLE(7,2), High DOUBLE(7,2) NOT NULL,Low DOUBLE(7,2) NOT NULL,Close DOUBLE(7,2),Volume INT(9), Chang DOUBLE(7,2), Sign VARCHAR(8), Ema DOUBLE(7,2), Rsi DOUBLE(7,3))");
        //following method predetermined in addBook()
        
	
	try {
 
		String[] row = null;
               
                
                
                CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
                List content = csvReader.readAll();//read whole file
                
                    for (Object object : content) {
                     row = (String[]) object;
                       
                    
                      if(isDouble(row[5])) {  //check if row[5] is double
                          
                       
         //       if (n > 0) {       
                 addData(conn, prestatement, company, Double.parseDouble(row[1]), Double.parseDouble(row[2]), Double.parseDouble(row[3]), Double.parseDouble(row[4]), Double.parseDouble(row[5]),Double.parseDouble(row[6]),change_cal(company,Double.parseDouble(row[1])),sign_cal(company,Double.parseDouble(row[1])),EMA_cal(company,p,Double.parseDouble(row[1])),RSI_cal(company,Double.parseDouble(row[1])));
       //         } //remove first line
                
              
                    }
                      p = p +1;
                    }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    finally {
            
        if (conn != null) try{conn.close();} catch(Exception ignore) {}
        if (statement != null) try{statement.close();} catch(Exception ignore) {}
        if (result != null) try{result.close();} catch(Exception ignore) {}
        if (prestatement != null) try{prestatement.close();} catch(Exception ignore) {}
        System.out.println("Done");
        }
    }
    
    public Double change_cal (String name,Double date) {
         String csvFilename = "C:\\Users\\tri\\Desktop\\VI\\BUSINESS\\"+name+"_PRICE.csv";
        Double today= 0.0;
        Double yesterday= 0.0;
        String[] row = null;
         Double change = 0.0;
         Integer n = 0;
       try{
           CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
       List content = csvReader.readAll();//read whole file
        String sign = null;
        
       
        for (Object object : content) {
            
            row = (String[]) object;
            
            if(isDouble(row[1])) {  //check if row[5] is double
                if ((date - Double.parseDouble(row[1])) >= 0){
                    if (n != 2){
                        yesterday = Double.parseDouble(row[5]);
                        change = (today - yesterday)/yesterday*100; //%change
                        if (change != -100){
                            if (change > 0) {
                                sign = "UP";
                                
                            } else if (change < 0) {
                                sign = "DOWN";
                                
                            } else {
                                sign = "NOTHING";
                                
                            }
                            
                            
                        }
                        today = Double.parseDouble(row[5]);
                        n = n+1;
                    }
                }
            }
        }
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
             
           return change;
       }
    }
    
    public Double close_price (String name) {
         String csvFilename = "C:\\Users\\tri\\Desktop\\VI\\BUSINESS\\"+name+"_PRICE.csv";
        Double today= 0.0;
        Double yesterday= 0.0;
        String[] row = null;
         Double change = 0.0;
         Integer n = 0;
       try{
           CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
       List content = csvReader.readAll();//read whole file
        String sign = null;
        
       
        for (Object object : content) {
            
            row = (String[]) object;
            
            if(isDouble(row[1])) {  //check if row[5] is double
                if (n == 0) {
                    
                      today = Double.parseDouble(row[5]);
                        
                        n = n+1;
                    }
                }
            }
        
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
             
           return today;
       }
    }
        
	
   public String sign_cal (String name,Double date) throws FileNotFoundException, IOException {
         String csvFilename = "C:\\Users\\tri\\Desktop\\VI\\BUSINESS\\"+name+"_PRICE.csv";
        Double today= 0.0;
        Double yesterday= 0.0;
        String[] row = null;
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        List content = csvReader.readAll();//read whole file
        String sign = null;
        Integer n = 0;
        Double change = 0.0;
     try {   for (Object object : content) {
            
            row = (String[]) object;
            
            if(isDouble(row[1])) {  //check if row[5] is double
                if ((date - Double.parseDouble(row[1])) >= 0){
                    if (n != 2){
                        yesterday = Double.parseDouble(row[5]);
                        change = (today - yesterday)/yesterday*100; //%change
                        if (change != -100){
                            if (change > 0) {
                                sign = "UP";
                                
                            } else if (change < 0) {
                                sign = "DOWN";
                                
                            } else {
                                sign = "NOTHING";
                                
                            }
                            
                            
                        }
                        today = Double.parseDouble(row[5]);
                        n = n+1;
                    }
                }
            }
        }
     } catch (Exception e) {
            e.printStackTrace();
        } finally {
     
        return sign;
    }
     }
		
    public Double EMA_cal (String name,Integer p, Double date) {
        Integer n = 0;
        Integer t = 0;
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
        
        Double ema = 0.0;
        Double yesterday = 0.0;
        Double yEMA = 0.0;
        Double tEMA = 0.0;
        ArrayList al = new ArrayList();
       try{
           String[] row = null;
       
        String csvFilename = "C:\\Users\\tri\\Desktop\\VI\\BUSINESS\\"+name+"_PRICE.csv";
                
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
       List content = csvReader.readAll();
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
                    
                
                
                
                      }
                      }
                    Collections.reverse(al);
           
	int count = al.size();
	
	
	for (int i = 0; i < al.size(); i++) {
	   if (i == (p-2)) {
           ema = (Double) al.get(i);
           }
            
        }
        
    } catch (Exception e) {
            e.printStackTrace();
        } finally {
     
        return ema;
       
    }
    }
    
    
    public Double RSI_cal (String name,Double date) {
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
                
                
                String csvFilename = "C:\\Users\\tri\\Desktop\\VI\\BUSINESS\\"+name+"_PRICE.csv";
                CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
                List content = csvReader.readAll();//read whole file
                
                    for (Object object : content) {
                     row = (String[]) object;
                       
                    
                      if(isDouble(row[5])) {  //check if row[5] is double
                          
                              if (isDouble(row[1])) {
                                  if (d < 16 && u < 16) {
                          if ((date - Double.parseDouble(row[1])) >= 0) {
                       today = Double.parseDouble(row[5]);    
                       
                       Double change = (yesterday - today)/today*100; //%change
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
            return RSI;
        }
 
	
  }
    public static boolean isDouble(final String s) {
        //check if data[5] is a Double
    try {
        Double.parseDouble(s);
        return true;
    } catch(NumberFormatException e) {
        return false;
    }
        
}
}

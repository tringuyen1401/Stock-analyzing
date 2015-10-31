/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;


import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.abs;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.util.Locale;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static jdbc.Import_data_csv.isDouble;
/**
 *
 * @author tri
 */
public class Multiples {
    
    public static void main(String[] args) throws Exception {
        Multiples obj = new Multiples();
        Integer linenumber = 2;
        String name;
        while (linenumber < 691) {
            name = Import_data_excel_Fin_Annual.readfile(linenumber);
     //       name = name.substring(1,name.length());
            System.out.println(name);
            obj.run(name);
            linenumber += 1;
        }
    }
    
   
    public static void run(String company) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException, Exception {
            Connection conn = null;    
    String url = "jdbc:mysql://gator4185.hostgator.com:3306/";
    String db = "vninvest_company";
    String dbName = db+"?useUnicode=true&characterEncoding=UTF-8";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "vninvest_admin"; 
    String password = "c.Kz?gF]8t]G";
    Statement statement = null;
    ResultSet result = null;
    PreparedStatement prestatement = null;
    
    String part = null;
    String part_change = null;
    String clause = null;
    Integer year = 2015;
   
    Double data_09 = 0.0;
    Double data_10 = 0.0;
    Double data_11 = 0.0;
    Double data_12 = 0.0;
    Double data_13 = 0.0;
    Double data_14 = 0.0;
    Double eat_09 = 0.0;
    Double eat_10 = 0.0;
    Double eat_11 = 0.0;
    Double eat_12 = 0.0;
    Double eat_13 = 0.0;
    Double eat_14 = 0.0;
    Double share_09 = 0.0;
    Double share_10 = 0.0;
    Double share_11 = 0.0;
    Double share_12 = 0.0;
    Double share_13 = 0.0;
    Double share_14 = 0.0;
    Double earn_09 = 0.0;
    Double earn_10 = 0.0;
    Double earn_11 = 0.0;
    Double earn_12 = 0.0;
    Double earn_13 = 0.0;
    Double earn_14 = 0.0;
    Double ev_09 = 0.0;
    Double ev_10 = 0.0;
    Double ev_11 = 0.0;
    Double ev_12 = 0.0;
    Double ev_13 = 0.0;
    Double ev_14 = 0.0;
    Integer n = 0;
    Integer b = 0;
    String output_09 = null;
    String output_10 = null;
    String output_11 = null;
    String output_12 = null;
    String output_13 = null;
    String output_14 = null;
    String dtt_09 = null;
    String dtt_10 = null;
    String dtt_11 = null;
    String dtt_12 = null;
    String dtt_13 = null;
    String dtt_14 = null;
    String sn_09 = null;
    String sn_10 = null;
    String sn_11 = null;
    String sn_12 = null;
    String sn_13 = null;
    String sn_14 = null;
    String stock_09 = null;
    String stock_10 = null;
    String stock_11 = null;
    String stock_12 = null;
    String stock_13 = null;
    String stock_14 = null;
    String div_09 = null;
    String div_10 = null;
    String div_11 = null;
    String div_12 = null;
    String div_13 = null;
    String div_14 = null;
    String ebit_09 = null;
    String ebit_10 = null;
    String ebit_11 = null;
    String ebit_12 = null;
    String ebit_13 = null;
    String ebit_14 = null;
    String cf_09 = null;
    String cf_10 = null;
    String cf_11 = null;
    String cf_12 = null;
    String cf_13 = null;
    String cf_14 = null;
    String lst_09 = null;
    String lst_10 = null;
    String lst_11 = null;
    String lst_12 = null;
    String lst_13 = null;
    String lst_14 = null;
    Double wc_09 = null;
    Double wc_10 = null;
    Double wc_11 = null;
    Double wc_12 = null;
    Double wc_13 = null;
    Double wc_14 = null;
    String ta_09 = null;
    String ta_10 = null;
    String ta_11 = null;
    String ta_12 = null;
    String ta_13 = null;
    String ta_14 = null;
    String td_09 = null;
    String td_10 = null;
    String td_11 = null;
    String td_12 = null;
    String td_13 = null;
    String td_14 = null;
    String std_09 = null;
    String std_10 = null;
    String std_11 = null;
    String std_12 = null;
    String std_13 = null;
    String std_14 = null;
    String cb_09 = null;
    String cb_10 = null;
    String cb_11 = null;
    String cb_12 = null;
    String cb_13 = null;
    String cb_14 = null;
    Double ebt_09 = 0.0;
    Double ebt_10 = 0.0;
    Double ebt_11 = 0.0;
    Double ebt_12 = 0.0;
    Double ebt_13 = 0.0;
    Double change_09 = 0.0;
    Double change_10 = 0.0;
    Double change_11 = 0.0;
    Double change_12 = 0.0;
    Double change_13 = 0.0;
    Double t_09 = 0.0;
    Double t_10 = 0.0;
    Double t_11 = 0.0;
    Double t_12 = 0.0;
    Double t_13 = 0.0;
    String ctcvmcp_09 = "";
    String ctcvmcp_10 = "";
    String ctcvmcp_11 = "";
    String ctcvmcp_12 = "";
    String ctcvmcp_13 = "";
    String g_10 = "";
    String g_11 = "";
    String g_12 = "";
    String g_13 = "";
    String g_14 = "";
    String tttphcp_09 = "";
    String tttphcp_10 = "";
    String tttphcp_11 = "";
    String tttphcp_12 = "";
    String tttphcp_13 = "";
    String vcsh_09 = "";
     String vcsh_10 = "";
      String vcsh_11 = "";
       String vcsh_12 = "";
        String vcsh_13 = "";
    String ebitda_09 = "";
    String ebitda_10 = "";
    String ebitda_11 = "";
    String ebitda_12 = "";
    String ebitda_13 = "";
    String ebitda_14 = "";
    DataFormatter fmt = new DataFormatter();
    NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
    

   
            try {
    Multiples obj = new Multiples();
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url+dbName,userName,password);
        
        statement = conn.createStatement();   
        
         add_company(conn,prestatement,company);
        
        
    FileInputStream file_FI = new FileInputStream(new File("C:\\Users\\tri\\Desktop\\busi\\data\\All\\"+company+"_FI.xlsx"));
            
            XSSFWorkbook workbook_FI = new XSSFWorkbook(file_FI);
             XSSFSheet sheet_FI = workbook_FI.getSheetAt(0);
            Iterator <Row> rowIterator_FI = sheet_FI.iterator();
            
           
            FileInputStream file_IS = new FileInputStream(new File("C:\\Users\\tri\\Desktop\\busi\\data\\All\\"+company+"_IS.xlsx"));
            
          XSSFWorkbook workbook_IS = new XSSFWorkbook(file_IS);
          XSSFSheet   sheet_IS = workbook_IS.getSheetAt(0);
          Iterator <Row>  rowIterator_IS = sheet_IS.iterator();
          
           FileInputStream file_CFS = new FileInputStream(new File("C:\\Users\\tri\\Desktop\\busi\\data\\All\\"+company+"_CFS.xlsx"));
            
          XSSFWorkbook workbook_CFS = new XSSFWorkbook(file_CFS);
          XSSFSheet   sheet_CFS = workbook_CFS.getSheetAt(0);
          Iterator <Row>  rowIterator_CFS = sheet_CFS.iterator();
          
           FileInputStream file_BS = new FileInputStream(new File("C:\\Users\\tri\\Desktop\\busi\\data\\All\\"+company+"_BS.xlsx"));
            
          XSSFWorkbook workbook_BS = new XSSFWorkbook(file_BS);
          XSSFSheet   sheet_BS = workbook_BS.getSheetAt(0);
          Iterator <Row>  rowIterator_BS = sheet_BS.iterator();
          
           // Read Financial Index
          b = 0;
          part = "_FI";
         
            while(rowIterator_FI.hasNext()) {
                Row row = rowIterator_FI.next();
                n = 0; 
                b = b+1;
                
                if (b == 6) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_14 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_14) || "".equals(stock_14)) {
                  stock_14 = "0.0";
                        }
                      break;
                      
                     }
                         if (n == 4) {
                      stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) { 
                         stock_13 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_12 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_12) || "".equals(stock_12)) {   
                         stock_12 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_11 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_11) || "".equals(stock_11)) {  
                         stock_11 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_10 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_10) || "".equals(stock_10)) {
                         stock_10 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
                if (b == 9) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                     
                   
                     
                        if (n == 5) {
                          div_14 = fmt.formatCellValue(cell);
                          
                       if ("-".equals(div_14) || "".equals(div_14)) { 
                        div_14 = "0.0";
                         
                        }
                      break;
                      
                     }
                         if (n == 4) {
                      
                      // data_12 = cell.getNumericCellValue();
                      div_13 = fmt.formatCellValue(cell);
                       if ("-".equals(div_13) || "".equals(div_13)) {  
                         div_13 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                     
                  //    data_11 = cell.getNumericCellValue();
                      div_12 = fmt.formatCellValue(cell);
                      if ("-".equals(div_12) || "".equals(div_12)) {  
                         div_12 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      div_11 = fmt.formatCellValue(cell);
                       if ("-".equals(div_11) || "".equals(div_11)) {  
                  
                         div_11 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                         
             
                      div_10 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(div_10) || "".equals(div_10)) {
                
                         div_10 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     
                     }
                      }    
                }
                  if (b == 5) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                     
                   
                     
                        if (n == 5) {
                          output_14 = fmt.formatCellValue(cell);
                          
                       if ("-".equals(output_14) || "".equals(output_14)) { 
                        output_14 = "0.0";
                         
                        }
                       
                        g_10 = output_10;
                        g_11 = output_11;
                        g_12 = output_12;
                        g_13 = output_13;
                        g_14 = output_14;
                       
                       
                      break;
                      
                     }
                         if (n == 4) {
                      
                      // data_12 = cell.getNumericCellValue();
                      output_13 = fmt.formatCellValue(cell);
                       if ("-".equals(output_13) || "".equals(output_13)) {  
                         output_13 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                     
                  //    data_11 = cell.getNumericCellValue();
                      output_12 = fmt.formatCellValue(cell);
                      if ("-".equals(output_12) || "".equals(output_12)) {  
                         output_12 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      output_11 = fmt.formatCellValue(cell);
                       if ("-".equals(output_11) || "".equals(output_11)) {  
                  
                         output_11 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                         
             
                      output_10 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(output_10) || "".equals(output_10)) {
                
                         output_10 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     
                     }
                      }    
                }   
            }
                
                share_10 =  Double.parseDouble(rs(stock_10));
                if ("0.0".equals(stock_11)) { stock_11 = stock_10;}
                if ("0.0".equals(stock_12)) { stock_12 = stock_11;}
                 if ("0.0".equals(stock_13)) { stock_13 = stock_12;}
                  if ("0.0".equals(stock_14)) { stock_14 = stock_13;}
                share_11 = Double.parseDouble(rs(stock_11)); 
                 share_12 = Double.parseDouble(rs(stock_12));
                 share_13 = Double.parseDouble(rs(stock_13));
                 share_14 = Double.parseDouble(rs(stock_14));
                 earn_10 = Double.parseDouble(rs(div_10));
                 earn_11 =  Double.parseDouble(rs(div_11));
                 earn_12 =  Double.parseDouble(rs(div_12));
                 earn_13 = Double.parseDouble(rs(div_13));
                 earn_14 =  Double.parseDouble(rs(div_14));
               
    Double        dps_09 = earn_10*1000;
     Double        dps_10 = earn_10*1000;
     Double        dps_11 = earn_11*1000;
      Double        dps_12 = earn_12*1000;
      Double        dps_13 = earn_13*1000;
                  
             // Read Income Statement
            b = 0;
            part = "_Mult_IS";
           
           
           
          while(rowIterator_IS.hasNext()) {
                Row row = rowIterator_IS.next();
                n = 0; 
                b = b+1;
                
               if (b == 23) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    ebit_13 = fmt.formatCellValue(cell);
                       if ("-".equals(ebit_13) || "".equals(ebit_13)) {
                  ebit_13 = "0.0";
                        }
                       
                      break;
                      
                     }
                         if (n == 4) {
                      ebit_12 = fmt.formatCellValue(cell);
                       if ("-".equals(ebit_12) || "".equals(ebit_12)) { 
                         ebit_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      ebit_11 = fmt.formatCellValue(cell);
                      if ("-".equals(ebit_11) || "".equals(ebit_11)) {   
                         ebit_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      ebit_10 = fmt.formatCellValue(cell);
                       if ("-".equals(ebit_10) || "".equals(ebit_10)) {  
                         ebit_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      ebit_10 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(ebit_09) || "".equals(ebit_09)) {
                         ebit_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
               
                   if (b == 22) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
               
                    ebitda_09 = stock_09; 
                    ebitda_10 = stock_10;
                    ebitda_11 = stock_11;
                    ebitda_12 = stock_12;
                    ebitda_13 = stock_13;
                    System.out.println(stock_13);
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }
                }
                    if (b == 18) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
                       
                       eat_09 = Double.parseDouble(rs(stock_09));
                      eat_10 = Double.parseDouble(rs(stock_10));
                      eat_11 = Double.parseDouble(rs(stock_11));
                      eat_12 = Double.parseDouble(rs(stock_12));
                      eat_13 = Double.parseDouble(rs(stock_13));
                       
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
                    if (b == 16) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
               
                   t_09 = abs(Double.parseDouble(stock_09))/ebt_09;
                   t_10 = abs(Double.parseDouble(stock_10))/ebt_10;
                   t_11 = abs(Double.parseDouble(stock_11))/ebt_11;
                   t_12 = abs(Double.parseDouble(stock_12))/ebt_12;
                   t_13 = abs(Double.parseDouble(stock_13))/ebt_13;
                   
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }
                }
                     if (b == 15) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
          //             System.out.println(clause+" , "+stock_09+" , "+stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13);
        //           add_data(conn,prestatement,company,part,clause,stock_13,stock_12,stock_11,stock_10,stock_09);
         //              if (Double.parseDouble(rs(stock_09)) <= 20000) {
         //                  t_09 = 0.2;
         //              } else {
         //                  t_09 = 0.22;
         //              }
         //              if (Double.parseDouble(rs(stock_10)) <= 20000) {
          //                 t_10 = 0.2;
          //             }else {
         //                  t_10 = 0.22;
         //              }
         //              if (Double.parseDouble(rs(stock_11)) <= 20000) {
         //                  t_11 = 0.2;
         //              } else {
         //                  t_11 = 0.22;
         //              }
          //             if (Double.parseDouble(rs(stock_12)) <= 20000) {
         //                  t_12 = 0.2;
          //             } else {
           //                t_12 = 0.22;
            //           }
             //          if (Double.parseDouble(rs(stock_13)) <= 20000) {
              //             t_13 = 0.2;
               //        } else {
                //           t_09 = 0.22;
                 //      }
                       
                       ebt_09 = abs(Double.parseDouble(rs(stock_09)));
                       ebt_10 = abs(Double.parseDouble(rs(stock_10)));
                       ebt_11 = abs(Double.parseDouble(rs(stock_11)));
                       ebt_12 = abs(Double.parseDouble(rs(stock_12)));
                       ebt_13 = abs(Double.parseDouble(rs(stock_13)));
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
                         if (b == 4) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
               
                       String      gvbh_09 = stock_09;
                       String      gvbh_10 = stock_10;
                       String      gvbh_11 = stock_11;
                       String      gvbh_12 = stock_12;
                       String      gvbh_13 = stock_13;
                       
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }
                } 
                        if (b == 3) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
               
                       dtt_09 = stock_09;
                       dtt_10 = stock_10;
                       dtt_11 = stock_11;
                       dtt_12 = stock_12;
                       dtt_13 = stock_13;
                       
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }
                }  
                
                 if (b < 23 && b > 3) {
                Iterator<Cell> cellIterator = row.cellIterator();
                n = 0;
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                     
                   
                     
                        if (n == 5) {
                     
                   //   data_13 = cell.getNumericCellValue();
                          stock_13 = fmt.formatCellValue(cell);
                          
                        
                //      output_13 = cell.getStringCellValue();
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  //       data_13 = 0.0;   
                        stock_13 = "N/A";
                         
                        } 
                       
                        if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                     
                        if (("N/A".equals(stock_09)&& "N/A".equals(stock_10)) || "N/A".equals(stock_09)) {
                             change_10 = 0.0;
                        } else {
                          change_10 = (Double.parseDouble(rs(output_10)) - Double.parseDouble(rs(output_09)))/Double.parseDouble(rs(output_09))*100;
                        }
                        
                        if (("N/A".equals(stock_10)&& "N/A".equals(stock_11)) || "N/A".equals(stock_11)) {
                             change_11 = 0.0;
                        } else {
                          change_11 = (Double.parseDouble(rs(output_11)) - Double.parseDouble(rs(output_10)))/Double.parseDouble(rs(output_10))*100;
                        }
                        
                        if ("N/A".equals(stock_11)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_12 = 0.0;
                        } else {
                          change_12 = (Double.parseDouble(rs(output_12)) - Double.parseDouble(rs(output_11)))/Double.parseDouble(rs(output_11))*100;
                        }
                        
                        if ("N/A".equals(stock_13)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_13 = 0.0;
                        } else {
                          change_13 = (Double.parseDouble(rs(output_13)) - Double.parseDouble(rs(output_12)))/Double.parseDouble(rs(output_12))*100;
                        }
                       
           //      
                   n = 0;
                      break;
                      
                     }
                         if (n == 4) {
                      
                      // data_12 = cell.getNumericCellValue();
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
               //          data_12 = 0.0;    
                         stock_12 = "N/A";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                     
                  //    data_11 = cell.getNumericCellValue();
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
              //           data_11 = 0.0; 
                         stock_11 = "N/A"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      
            //          data_10 = cell.getNumericCellValue();
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
               //          data_10 = 0.0;    
                         stock_10 = "N/A";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                         
               //       data_09 = cell.getNumericCellValue();
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
              //            data_09 = 0.0;    
                         stock_09 = "N/A";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                    
                     }
                     
                     
                     
                     }    
                }
              
            }
           
            Double   eps_09 =  eat_09/share_10*1000000;
           Double  eps_10 = eat_10/share_11*1000000;
           Double      eps_11 = eat_11/share_12*1000000;
           Double     eps_12 = eat_12/share_13*1000000;
           Double      eps_13 = eat_13/share_14*1000000;
           
           
           Double peps_09 = obj.close_price(company,year-4)/eps_09*1000;
           Double peps_10 = obj.close_price(company,year-3)/eps_10*1000;
           Double peps_11 = obj.close_price(company,year-2)/eps_11*1000;
           Double peps_12 = obj.close_price(company,year-1)/eps_12*1000;
           Double peps_13 = obj.close_price(company,year)/eps_13*1000;
          
            
             
             // Reading Balance Sheet
            part = "_Mult_BS";
            
           
           
            b = 0;
            
            while(rowIterator_BS.hasNext()) {
                Row row = rowIterator_BS.next();
                n = 0; 
                b = b+1;
                  if (b == 62) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
        //               System.out.println(clause+" , "+stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
               
                   vcsh_09 = stock_09; 
                   vcsh_10 = stock_10;
                   vcsh_11 = stock_11;
                   vcsh_12 = stock_12;
                   vcsh_13 = stock_13;
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }
                }
                  
               
                  
                  if (b == 42) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
               
                   std_09 = stock_09;
                   std_10 = stock_10;
                   std_11 = stock_11;
                   std_12 = stock_12;
                   std_13 = stock_13;
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }
                }
                  if (b == 41) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
               
                   td_09 = stock_09;
                   td_10 = stock_10;
                   td_11 = stock_11;
                   td_12 = stock_12;
                   td_13 = stock_13;
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }
                }
                  if (b == 37) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
               
                   ta_09 = stock_09;
                   ta_10 = stock_10;
                   ta_11 = stock_11;
                   ta_12 = stock_12;
                   ta_13 = stock_13;
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }
                }
                    if (b == 4) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
               
                   div_09 = stock_09;
                   div_10 = stock_10;
                   div_11 = stock_11;
                   div_12 = stock_12;
                   div_13 = stock_13;
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12)  || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }
                }
                
                if (b < 83 && b > 3) {
                    
                
                n = 0;
               
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                     
                   
                     
                        if (n == 5) {
                     
                   //   data_13 = cell.getNumericCellValue();
                          output_13 = fmt.formatCellValue(cell);
                          
                        
                //      output_13 = cell.getStringCellValue();
                       if ("-".equals(output_13) || "".equals(output_13)) {
                  //       data_13 = 0.0;   
                        output_13 = "N/A";
                         
                        }
                        if ("N/A".equals(output_09)) {
                            stock_09 = "0.0";
                        } else {
                            stock_09 = output_09;
                        }
                        if ("N/A".equals(output_10)) {
                            stock_10 = "0.0";
                        } else {
                            stock_10 = output_10;
                        }
                        if ("N/A".equals(output_11)) {
                            stock_11 = "0.0";
                        } else {
                            stock_11 = output_11;
                        }
                        if ("N/A".equals(output_12)) {
                            stock_12 = "0.0";
                        } else {
                            stock_12 = output_12;
                        }
                        if ("N/A".equals(output_13)) {
                            stock_13 = "0.0";
                        } else {
                            stock_13 = output_13;
                        }
       //      change_10 = (Double.parseDouble(rs(stock_10)) - Double.parseDouble(rs(stock_09)))/Double.parseDouble(rs(stock_09))*100;
       //               change_11 = (Double.parseDouble(rs(stock_11)) - Double.parseDouble(rs(stock_10)))/Double.parseDouble(rs(stock_10))*100;
       //                 change_12 = (Double.parseDouble(rs(stock_12)) - Double.parseDouble(rs(stock_11)))/Double.parseDouble(rs(stock_11))*100;
        //                change_13 = (Double.parseDouble(rs(stock_13)) - Double.parseDouble(rs(stock_12)))/Double.parseDouble(rs(stock_12))*100;
                 //      System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
             
                      break;
                      
                     }
                         if (n == 4) {
                      
                      // data_12 = cell.getNumericCellValue();
                      output_12 = fmt.formatCellValue(cell);
                       if ("-".equals(output_12) || "".equals(output_12)) { 
               //          data_12 = 0.0;    
                         output_12 = "N/A";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                     
                  //    data_11 = cell.getNumericCellValue();
                      output_11 = fmt.formatCellValue(cell);
                      if ("-".equals(output_11) || "".equals(output_11)) {   
              //           data_11 = 0.0; 
                         output_11 = "N/A"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      
            //          data_10 = cell.getNumericCellValue();
                      output_10 = fmt.formatCellValue(cell);
                       if ("-".equals(output_10) || "".equals(output_10)) {  
               //          data_10 = 0.0;    
                         output_10 = "N/A";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                         
               //       data_09 = cell.getNumericCellValue();
                      output_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(output_09) || "".equals(output_09)) {
              //            data_09 = 0.0;    
                         output_09 = "N/A";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     
                     }
                     
                     
                     
                     }    
                }
                    
            }
            
            wc_09 = (Double.parseDouble(rs(div_09))-Double.parseDouble(rs(std_09)))*1000000;
            wc_10 = (Double.parseDouble(rs(div_10))-Double.parseDouble(rs(std_10)))*1000000;
            wc_11 = (Double.parseDouble(rs(div_11))-Double.parseDouble(rs(std_11)))*1000000;
            wc_12 = (Double.parseDouble(rs(div_12))-Double.parseDouble(rs(std_12)))*1000000;
            wc_13 = (Double.parseDouble(rs(div_13))-Double.parseDouble(rs(std_13)))*1000000;
            
    Double  bvps_09 = Double.parseDouble(rs(vcsh_09))/share_10*1000000;
    Double  bvps_10 = Double.parseDouble(rs(vcsh_10))/share_10*1000000;
    Double  bvps_11 = Double.parseDouble(rs(vcsh_11))/share_11*1000000;
    Double  bvps_12 = Double.parseDouble(rs(vcsh_12))/share_12*1000000;
    Double  bvps_13 = Double.parseDouble(rs(vcsh_13))/share_13*1000000;
    
            
    Double pbvps_09 = obj.close_price(company, year-4)/bvps_09*1000;
    Double pbvps_10 = obj.close_price(company, year-3)/bvps_10*1000;
    Double pbvps_11 = obj.close_price(company, year-2)/bvps_11*1000;
    Double pbvps_12 = obj.close_price(company, year-1)/bvps_12*1000;
    Double pbvps_13 = obj.close_price(company, year)/bvps_13*1000;
            
            
             ev_13 = obj.close_price(company,year)/share_13*1000;
          
             
             
             
            // Read Cash Flow Statement
            part = "_FINA_CFS";
           
            
          
            b = 0;
            
            while(rowIterator_CFS.hasNext()) {
                Row row = rowIterator_CFS.next();
                n = 0; 
                b = b+1;
                if (b == 41) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
               if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                        
                         if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                       
                        if (("N/A".equals(stock_09)&& "N/A".equals(stock_10)) || "N/A".equals(stock_09)) {
                             change_10 = 0.0;
                        } else {
                          change_10 = (Double.parseDouble(rs(output_10)) - Double.parseDouble(rs(output_09)))/Double.parseDouble(rs(output_09))*100;
                        }
                        
                        if (("N/A".equals(stock_10)&& "N/A".equals(stock_11)) || "N/A".equals(stock_11)) {
                             change_11 = 0.0;
                        } else {
                          change_11 = (Double.parseDouble(rs(output_11)) - Double.parseDouble(rs(output_10)))/Double.parseDouble(rs(output_10))*100;
                        }
                        
                        if ("N/A".equals(stock_11)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_12 = 0.0;
                        } else {
                          change_12 = (Double.parseDouble(rs(output_12)) - Double.parseDouble(rs(output_11)))/Double.parseDouble(rs(output_11))*100;
                        }
                        
                        if ("N/A".equals(stock_13)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_13 = 0.0;
                        } else {
                          change_13 = (Double.parseDouble(rs(output_13)) - Double.parseDouble(rs(output_12)))/Double.parseDouble(rs(output_12))*100;
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);

                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
                if (b == 39) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
           if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                        
                        if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                       
                        if (("N/A".equals(stock_09)&& "N/A".equals(stock_10)) || "N/A".equals(stock_09)) {
                             change_10 = 0.0;
                        } else {
                          change_10 = (Double.parseDouble(rs(output_10)) - Double.parseDouble(rs(output_09)))/Double.parseDouble(rs(output_09))*100;
                        }
                        
                        if (("N/A".equals(stock_10)&& "N/A".equals(stock_11)) || "N/A".equals(stock_11)) {
                             change_11 = 0.0;
                        } else {
                          change_11 = (Double.parseDouble(rs(output_11)) - Double.parseDouble(rs(output_10)))/Double.parseDouble(rs(output_10))*100;
                        }
                        
                        if ("N/A".equals(stock_11)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_12 = 0.0;
                        } else {
                          change_12 = (Double.parseDouble(rs(output_12)) - Double.parseDouble(rs(output_11)))/Double.parseDouble(rs(output_11))*100;
                        }
                        
                        if ("N/A".equals(stock_13)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_13 = 0.0;
                        } else {
                          change_13 = (Double.parseDouble(rs(output_13)) - Double.parseDouble(rs(output_12)))/Double.parseDouble(rs(output_12))*100;
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);

                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_13)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
                if (b == 38) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
               if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                        
                         if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                       
                        if (("N/A".equals(stock_09)&& "N/A".equals(stock_10)) || "N/A".equals(stock_09)) {
                             change_10 = 0.0;
                        } else {
                          change_10 = (Double.parseDouble(rs(output_10)) - Double.parseDouble(rs(output_09)))/Double.parseDouble(rs(output_09))*100;
                        }
                        
                        if (("N/A".equals(stock_10)&& "N/A".equals(stock_11)) || "N/A".equals(stock_11)) {
                             change_11 = 0.0;
                        } else {
                          change_11 = (Double.parseDouble(rs(output_11)) - Double.parseDouble(rs(output_10)))/Double.parseDouble(rs(output_10))*100;
                        }
                        
                        if ("N/A".equals(stock_11)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_12 = 0.0;
                        } else {
                          change_12 = (Double.parseDouble(rs(output_12)) - Double.parseDouble(rs(output_11)))/Double.parseDouble(rs(output_11))*100;
                        }
                        
                        if ("N/A".equals(stock_13)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_13 = 0.0;
                        } else {
                          change_13 = (Double.parseDouble(rs(output_13)) - Double.parseDouble(rs(output_12)))/Double.parseDouble(rs(output_12))*100;
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);

                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
                if (b == 37) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
               if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                        
                         if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                       
                        if (("N/A".equals(stock_09)&& "N/A".equals(stock_10)) || "N/A".equals(stock_09)) {
                             change_10 = 0.0;
                        } else {
                          change_10 = (Double.parseDouble(rs(output_10)) - Double.parseDouble(rs(output_09)))/Double.parseDouble(rs(output_09))*100;
                        }
                        
                        if (("N/A".equals(stock_10)&& "N/A".equals(stock_11)) || "N/A".equals(stock_11)) {
                             change_11 = 0.0;
                        } else {
                          change_11 = (Double.parseDouble(rs(output_11)) - Double.parseDouble(rs(output_10)))/Double.parseDouble(rs(output_10))*100;
                        }
                        
                        if ("N/A".equals(stock_11)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_12 = 0.0;
                        } else {
                          change_12 = (Double.parseDouble(rs(output_12)) - Double.parseDouble(rs(output_11)))/Double.parseDouble(rs(output_11))*100;
                        }
                        
                        if ("N/A".equals(stock_13)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_13 = 0.0;
                        } else {
                          change_13 = (Double.parseDouble(rs(output_13)) - Double.parseDouble(rs(output_12)))/Double.parseDouble(rs(output_12))*100;
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);

                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
                  if (b == 31) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
               
                        ctcvmcp_09 = stock_09;
                        ctcvmcp_10 = stock_10;
                        ctcvmcp_11 = stock_11;
                        ctcvmcp_12 = stock_12;
                        ctcvmcp_13 = stock_13;
                       
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }
                }  
                   if (b == 30) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
               
                        tttphcp_09 = stock_09;
                       tttphcp_10 = stock_10;
                       tttphcp_11 = stock_11;
                        tttphcp_12 = stock_12;
                       tttphcp_13 = stock_13;
                       
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }
                } 
                if (b == 29) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
                     
                       
                      if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                      
                         if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                       
                        if (("N/A".equals(stock_09)&& "N/A".equals(stock_10)) || "N/A".equals(stock_09)) {
                             change_10 = 0.0;
                        } else {
                          change_10 = (Double.parseDouble(rs(output_10)) - Double.parseDouble(rs(output_09)))/Double.parseDouble(rs(output_09))*100;
                        }
                        
                        if (("N/A".equals(stock_10)&& "N/A".equals(stock_11)) || "N/A".equals(stock_11)) {
                             change_11 = 0.0;
                        } else {
                          change_11 = (Double.parseDouble(rs(output_11)) - Double.parseDouble(rs(output_10)))/Double.parseDouble(rs(output_10))*100;
                        }
                        
                        if ("N/A".equals(stock_11)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_12 = 0.0;
                        } else {
                          change_12 = (Double.parseDouble(rs(output_12)) - Double.parseDouble(rs(output_11)))/Double.parseDouble(rs(output_11))*100;
                        }
                        
                        if ("N/A".equals(stock_13)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_13 = 0.0;
                        } else {
                          change_13 = (Double.parseDouble(rs(output_13)) - Double.parseDouble(rs(output_12)))/Double.parseDouble(rs(output_12))*100;
                        }
                       

                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
                
                ////////////////////////////////////////////////////
                /////////////////////////////////////////////////
                
                if (b == 21) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
                       cf_09 = stock_09;
                       cf_10 = stock_10;
                       cf_11 = stock_11;
                       cf_12 = stock_12;
                       cf_13 = stock_13;
                       
                      if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                      
                         if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                       
                        if (("N/A".equals(stock_09)&& "N/A".equals(stock_10)) || "N/A".equals(stock_09)) {
                             change_10 = 0.0;
                        } else {
                          change_10 = (Double.parseDouble(rs(output_10)) - Double.parseDouble(rs(output_09)))/Double.parseDouble(rs(output_09))*100;
                        }
                        
                        if (("N/A".equals(stock_10)&& "N/A".equals(stock_11)) || "N/A".equals(stock_11)) {
                             change_11 = 0.0;
                        } else {
                          change_11 = (Double.parseDouble(rs(output_11)) - Double.parseDouble(rs(output_10)))/Double.parseDouble(rs(output_10))*100;
                        }
                        
                        if ("N/A".equals(stock_11)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_12 = 0.0;
                        } else {
                          change_12 = (Double.parseDouble(rs(output_12)) - Double.parseDouble(rs(output_11)))/Double.parseDouble(rs(output_11))*100;
                        }
                        
                        if ("N/A".equals(stock_13)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_13 = 0.0;
                        } else {
                          change_13 = (Double.parseDouble(rs(output_13)) - Double.parseDouble(rs(output_12)))/Double.parseDouble(rs(output_12))*100;
                        }
                       

                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
                
                ////////////////////////////////////////////////////
                /////////////////////////////////////////////////
                if (b == 18) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
                       if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                       
                        if (("N/A".equals(stock_09)&& "N/A".equals(stock_10)) || "N/A".equals(stock_09)) {
                             change_10 = 0.0;
                        } else {
                          change_10 = (Double.parseDouble(rs(output_10)) - Double.parseDouble(rs(output_09)))/Double.parseDouble(rs(output_09))*100;
                        }
                        
                        if (("N/A".equals(stock_10)&& "N/A".equals(stock_11)) || "N/A".equals(stock_11)) {
                             change_11 = 0.0;
                        } else {
                          change_11 = (Double.parseDouble(rs(output_11)) - Double.parseDouble(rs(output_10)))/Double.parseDouble(rs(output_10))*100;
                        }
                        
                        if ("N/A".equals(stock_11)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_12 = 0.0;
                        } else {
                          change_12 = (Double.parseDouble(rs(output_12)) - Double.parseDouble(rs(output_11)))/Double.parseDouble(rs(output_11))*100;
                        }
                        
                        if ("N/A".equals(stock_13)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_13 = 0.0;
                        } else {
                          change_13 = (Double.parseDouble(rs(output_13)) - Double.parseDouble(rs(output_12)))/Double.parseDouble(rs(output_12))*100;
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);
           //        add_data(conn,prestatement,company,part,clause,stock_13,stock_12,stock_11,stock_10,stock_09);
          //         add_change(conn,prestatement,company,part_change,clause,Double.toString(change_13),Double.toString(change_12),Double.toString(change_11),Double.toString(change_10),"N/A");
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
                
              if (b == 12) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
                       if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                       
                        if (("N/A".equals(stock_09)&& "N/A".equals(stock_10)) || "N/A".equals(stock_09)) {
                             change_10 = 0.0;
                        } else {
                          change_10 = (Double.parseDouble(rs(output_10)) - Double.parseDouble(rs(output_09)))/Double.parseDouble(rs(output_09))*100;
                        }
                        
                        if (("N/A".equals(stock_10)&& "N/A".equals(stock_11)) || "N/A".equals(stock_11)) {
                             change_11 = 0.0;
                        } else {
                          change_11 = (Double.parseDouble(rs(output_11)) - Double.parseDouble(rs(output_10)))/Double.parseDouble(rs(output_10))*100;
                        }
                        
                        if ("N/A".equals(stock_11)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_12 = 0.0;
                        } else {
                          change_12 = (Double.parseDouble(rs(output_12)) - Double.parseDouble(rs(output_11)))/Double.parseDouble(rs(output_11))*100;
                        }
                        
                        if ("N/A".equals(stock_13)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_13 = 0.0;
                        } else {
                          change_13 = (Double.parseDouble(rs(output_13)) - Double.parseDouble(rs(output_12)))/Double.parseDouble(rs(output_12))*100;
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);

                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
              
              if (b == 5) {
                    
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                    
                    if (n == 5) {
                    stock_13 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_13) || "".equals(stock_13)) {
                  stock_13 = "0.0";
                        }
                        if ("N/A".equals(stock_09) ) {
                            output_09 = "0.0";
                            change_10 = 0.0;
                        } else {
                            output_09 = stock_09; 
                        }
                        
                        if ("N/A".equals(stock_10) ) {
                            output_10 = "0.0";
                        } else {
                            output_10 = stock_10;
                        }
                        if ("N/A".equals(stock_11) ) {
                            output_11 = "0.0";
                        } else {
                            output_11 = stock_11;
                        }
                        if ("N/A".equals(stock_12) ) {
                            output_12 = "0.0";
                        } else {
                            output_12 = stock_12;
                        }
                        if ("N/A".equals(stock_13) ) {
                            output_13 = "0.0";
                        } else {
                            output_13 = stock_13;
                        }
                        
                       
                        if (("N/A".equals(stock_09)&& "N/A".equals(stock_10)) || "N/A".equals(stock_09)) {
                             change_10 = 0.0;
                        } else {
                          change_10 = (Double.parseDouble(rs(output_10)) - Double.parseDouble(rs(output_09)))/Double.parseDouble(rs(output_09))*100;
                        }
                        
                        if (("N/A".equals(stock_10)&& "N/A".equals(stock_11)) || "N/A".equals(stock_11)) {
                             change_11 = 0.0;
                        } else {
                          change_11 = (Double.parseDouble(rs(output_11)) - Double.parseDouble(rs(output_10)))/Double.parseDouble(rs(output_10))*100;
                        }
                        
                        if ("N/A".equals(stock_11)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_12 = 0.0;
                        } else {
                          change_12 = (Double.parseDouble(rs(output_12)) - Double.parseDouble(rs(output_11)))/Double.parseDouble(rs(output_11))*100;
                        }
                        
                        if ("N/A".equals(stock_13)&& "N/A".equals(stock_12) || "N/A".equals(stock_11)) {
                             change_13 = 0.0;
                        } else {
                          change_13 = (Double.parseDouble(rs(output_13)) - Double.parseDouble(rs(output_12)))/Double.parseDouble(rs(output_12))*100;
                        }
           //            System.out.println(stock_10+" , "+stock_11+" , "+stock_12+" , "+stock_13+" , "+stock_14);

                   div_09 = stock_09;
                   div_10 = stock_10;
                   div_11 = stock_11;
                   div_12 = stock_12;
                   div_13 = stock_13;
                      break;
                      
                     }
                         if (n == 4) {
                      stock_12 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_12) || "".equals(stock_12)) { 
                         stock_12 = "0.0";
                       }
                       n = 5;
                     }
                     
                         if (n == 3) {
                      stock_11 = fmt.formatCellValue(cell);
                      if ("-".equals(stock_11) || "".equals(stock_11)) {   
                         stock_11 = "0.0"; 
                     }
                        n = 4;
                         }
                         if (n == 2) {
                      stock_10 = fmt.formatCellValue(cell);
                       if ("-".equals(stock_10) || "".equals(stock_10)) {  
                         stock_10 = "0.0";
                     }
                       n = 3;
                         }
                     if (n == 1) {
                      stock_09 = fmt.formatCellValue(cell);
                         
                      if ("-".equals(stock_09) || "".equals(stock_09)) {
                         stock_09 = "0.0";
                      }  
                      n = 2;
                      
                     } 
                     if (n == 0) {
                     clause = fmt.formatCellValue(cell);
                     n = 1;
                     }
                     }    
                }
            }
            
            
            Double cfps_09 = Double.parseDouble(rs(cf_09))/share_10*1000000;
            Double cfps_10 = Double.parseDouble(rs(cf_10))/share_11*1000000;
            Double cfps_11 = Double.parseDouble(rs(cf_11))/share_12*1000000;
            Double cfps_12 = Double.parseDouble(rs(cf_12))/share_13*1000000;
            Double cfps_13 = Double.parseDouble(rs(cf_13))/share_14*1000000;
            Double sps_09 = Double.parseDouble(rs(dtt_09))/share_10*1000000;
            Double sps_10 = Double.parseDouble(rs(dtt_10))/share_10*1000000;
            Double sps_11 = Double.parseDouble(rs(dtt_11))/share_11*1000000;
            Double sps_12 = Double.parseDouble(rs(dtt_12))/share_12*1000000;
            Double sps_13 = Double.parseDouble(rs(dtt_13))/share_13*1000000;
            
            Double pcfps_09 = obj.close_price(company,year-4)/cfps_09*1000;
            Double pcfps_10 = obj.close_price(company,year-3)/cfps_10*1000;
            Double pcfps_11 = obj.close_price(company,year-2)/cfps_11*1000;
            Double pcfps_12 = obj.close_price(company,year-1)/cfps_12*1000;
            Double pcfps_13 = obj.close_price(company,year)/cfps_13*1000;
            
            Double psps_09 = obj.close_price(company,year-4)/sps_09*1000;
            Double psps_10 = obj.close_price(company,year-3)/sps_10*1000;
            Double psps_11 = obj.close_price(company,year-2)/sps_11*1000;
            Double psps_12 = obj.close_price(company,year-1)/sps_12*1000;
            Double psps_13 = obj.close_price(company,year)/sps_13*1000;
            
            
        //    System.out.println(cfps_09+" , "+cfps_10+" , "+cfps_11+" , "+cfps_12+" , "+cfps_13);
            
            
           Double   fcfps_09 =  0.0;
           Double  fcfps_10 = Double.parseDouble(rs(ebit_10))*(1-t_10)*1000000 + Double.parseDouble(rs(div_10))*1000000 - (wc_10 - wc_09)-(Double.parseDouble(rs(ta_10))-Double.parseDouble(rs(ta_09)))*1000000+(Double.parseDouble(rs(td_10))-Double.parseDouble(rs(td_09)))*1000000;           
           Double      fcfps_11 = Double.parseDouble(rs(ebit_11))*(1-t_11)*1000000 + Double.parseDouble(rs(div_11))*1000000 - (wc_11 - wc_10)-(Double.parseDouble(rs(ta_11))-Double.parseDouble(rs(ta_10)))*1000000+(Double.parseDouble(rs(td_11))-Double.parseDouble(rs(td_10)))*1000000;
           Double     fcfps_12 = Double.parseDouble(rs(ebit_12))*(1-t_12)*1000000 + Double.parseDouble(rs(div_12))*1000000 - (wc_12 - wc_11)-(Double.parseDouble(rs(ta_12))-Double.parseDouble(rs(ta_11)))*1000000+(Double.parseDouble(rs(td_12))-Double.parseDouble(rs(td_11)))*1000000;
           Double      fcfps_13 = Double.parseDouble(rs(ebit_13))*(1-t_13)*1000000 + Double.parseDouble(rs(div_13))*1000000 - (wc_13 - wc_12)-(Double.parseDouble(rs(ta_13))-Double.parseDouble(rs(ta_12)))*1000000+(Double.parseDouble(rs(td_13))-Double.parseDouble(rs(td_12)))*1000000;
           
           Double pfcfps_09 = 0.0;
           Double pfcfps_10 = obj.close_price(company, year-3)/fcfps_10*1000;
           Double pfcfps_11 = obj.close_price(company, year-2)/fcfps_11*1000;
           Double pfcfps_12 = obj.close_price(company, year-1)/fcfps_12*1000;
           Double pfcfps_13 = obj.close_price(company, year)/fcfps_13*1000;
          
           Double yield_09 = dps_09/obj.close_price(company, year-4)/1000*100;
           Double yield_10 = dps_10/obj.close_price(company, year-3)/1000*100;
           Double yield_11 = dps_11/obj.close_price(company, year-2)/1000*100;
           Double yield_12 = dps_12/obj.close_price(company, year-1)/1000*100;
           Double yield_13 = dps_13/obj.close_price(company, year)/1000*100;
           
           
           if (g_12 == "0.0") { g_12 = g_13;}
           if (g_11 == "0.0") { g_11 = g_12;}
           if (g_10 == "0.0") { g_10 = g_11;}
           
               
           Double bby_09 = 0.0;
           Double bby_10 = Double.parseDouble(rs(ctcvmcp_10))/(Double.parseDouble(rs(g_10))*share_10);
           Double bby_11 = Double.parseDouble(rs(ctcvmcp_11))/(Double.parseDouble(rs(g_11))*share_11);
           Double bby_12 = Double.parseDouble(rs(ctcvmcp_12))/(Double.parseDouble(rs(g_12))*share_12);
           Double bby_13 = Double.parseDouble(rs(ctcvmcp_13))/(Double.parseDouble(rs(g_13))*share_13);
           
           Double shy_09 = 0.0;
           Double shy_10 = (dps_10+Double.parseDouble(rs(ctcvmcp_10))-Double.parseDouble(rs(tttphcp_10)))/(Double.parseDouble(rs(g_10))*share_10);
           Double shy_11 = (dps_11+Double.parseDouble(rs(ctcvmcp_11))-Double.parseDouble(rs(tttphcp_11)))/(Double.parseDouble(rs(g_11))*share_11);
           Double shy_12 = (dps_12+Double.parseDouble(rs(ctcvmcp_12))-Double.parseDouble(rs(tttphcp_12)))/(Double.parseDouble(rs(g_12))*share_12);
           Double shy_13 = (dps_13+Double.parseDouble(rs(ctcvmcp_13))-Double.parseDouble(rs(tttphcp_13)))/(Double.parseDouble(rs(g_13))*share_13);
           
           Double evebitda_09 = 0.0;
           Double evebitda_10 = (Double.parseDouble(rs(g_10))*share_10)/Double.parseDouble(rs(ebitda_10));
           Double evebitda_11 = (Double.parseDouble(rs(g_11))*share_11)/Double.parseDouble(rs(ebitda_11));
           Double evebitda_12 = (Double.parseDouble(rs(g_12))*share_12)/Double.parseDouble(rs(ebitda_12));
           Double evebitda_13 = (Double.parseDouble(rs(g_13))*share_13)/Double.parseDouble(rs(ebitda_13));
           
           
           
         add_data(conn,prestatement,company,"Price/Earning per share",Double.toString(peps_13),Double.toString(peps_12),Double.toString(peps_11),Double.toString(peps_10),Double.toString(peps_09));
          add_data(conn,prestatement,company,"Price/Book value per share",Double.toString(pbvps_13),Double.toString(pbvps_12),Double.toString(pbvps_11),Double.toString(pbvps_10),Double.toString(pbvps_09));
           add_data(conn,prestatement,company,"Price/Sales per share",Double.toString(psps_13),Double.toString(psps_12),Double.toString(psps_11),Double.toString(psps_10),Double.toString(psps_09));
            add_data(conn,prestatement,company,"Price/Cash Flow per share",Double.toString(pcfps_13),Double.toString(pcfps_12),Double.toString(pcfps_11),Double.toString(pcfps_10),Double.toString(pcfps_09));
            add_data(conn,prestatement,company,"Price/Free Cash Flow per share",Double.toString(pfcfps_13),Double.toString(pfcfps_12),Double.toString(pfcfps_11),Double.toString(pfcfps_10),Double.toString(pfcfps_09));
            add_data(conn,prestatement,company,"Yield",Double.toString(yield_13),Double.toString(yield_12),Double.toString(yield_11),Double.toString(yield_10),Double.toString(yield_09));
           add_data(conn,prestatement,company,"Buy Back Yield",Double.toString(bby_13),Double.toString(bby_12),Double.toString(bby_11),Double.toString(bby_10),Double.toString(bby_09));
           add_data(conn,prestatement,company,"Share Holder Yield",Double.toString(shy_13),Double.toString(shy_12),Double.toString(shy_11),Double.toString(shy_10),Double.toString(shy_09));
           add_data(conn,prestatement,company,"Enterprise value/EBITDA",Double.toString(evebitda_13),Double.toString(evebitda_12),Double.toString(evebitda_11),Double.toString(evebitda_10),Double.toString(evebitda_09));
            
             file_BS.close();
             file_CFS.close();
             file_FI.close();
            file_IS.close();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                    if (conn != null) try{conn.close();} catch(Exception ignore) {}
        if (statement != null) try{statement.close();} catch(Exception ignore) {}
        if (result != null) try{result.close();} catch(Exception ignore) {}
        if (prestatement != null) try{prestatement.close();} catch(Exception ignore) {}
                }
    
    
    
    }
    
    public static String rs(String currency) throws Exception {

    
    	// Replace all dots with commas
    	currency = currency.replaceAll("\\.", ",");

    	// If fractions exist, the separator must be a .
    	if(currency.length()>=3) {
    		char[] chars = currency.toCharArray();
    		if(chars[chars.length-2] == ',') {
    			chars[chars.length-2] = '.';
    		} else if(chars[chars.length-3] == ',') {
    			chars[chars.length-3] = '.';
    		}
    		currency = new String(chars);
    	}

    	// Remove all commas		
    	return currency.replaceAll(",", "");				
    }
    
    
    
    public static void add_data(Connection conn, PreparedStatement prestatement, String name, String clause, String output_09, String output_10, String output_11, String output_12, String output_13) throws SQLException {
        
        prestatement = conn.prepareStatement("INSERT INTO `"+name+"_MULT` (`clause`, `Current`, `1 Year Ago`, `2 Years Ago`, `3 Years Ago`, `4 Years Ago`) VALUES(N?,?,?,?,?,?);");
        
       prestatement.setString(1, clause);
       prestatement.setString(2, output_09);
       prestatement.setString(3, output_10);
       prestatement.setString(4, output_11);
       prestatement.setString(5, output_12);
       prestatement.setString(6, output_13);
       
        prestatement.executeUpdate();
       
    }
    
    
    public static void add_company(Connection conn,PreparedStatement prestatement, String name) throws SQLException//creating templates for prepared statement
    {
       prestatement = conn.prepareStatement ("DROP TABLE IF EXISTS `"+name+"_MULT`;");
       prestatement.executeUpdate();
       prestatement = conn.prepareStatement ("CREATE TABLE `"+ name+ "_MULT` ( ID INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL, `clause` VARCHAR(255) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci, `Current` VARCHAR(255), `1 Year Ago` VARCHAR(255), `2 Years Ago` VARCHAR(255), `3 Years Ago` VARCHAR(255), `4 Years Ago` VARCHAR(255))");
       prestatement.executeUpdate();
        
    }
     public Double close_price (String name, Integer year) {
         String csvFilename = "C:\\Users\\tri\\Desktop\\VI\\BUSINESS\\"+name+"_PRICE.csv";
        Double today= 0.0;
        Double yesterday= 0.0;
        String[] row = null;
         Double change = 0.0;
         Integer n = 0;
         Integer d = 0;
       try{
           CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
       List content = csvReader.readAll();//read whole file
        String sign = null;
        
       
        for (Object object : content) {
            
            row = (String[]) object;
            if(isDouble(row[1]))    {
                double date = Double.parseDouble(row[1])/10000;
                long day = (long) date;
            if (year == day) {
                if (n == 0) {
              //check if row[5] is double
                
                    
                      today = Double.parseDouble(row[5]);
                        
                        n = n+1;
                    
                }
            
            }
            }
            
            }
        
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
             
           return today;
       }
    }

     public Double change (String numer,String deno) {
       Double rs = 0.0;  
       try {
         if ("0.0".equals(deno)) {
             rs = 0.0;
         } else {
             rs = (Double.parseDouble(numer)-Double.parseDouble(deno))/Double.parseDouble(deno);
         }
       } catch(Exception e) {
        e.printStackTrace();
       }finally {
             
           return rs;
       }
    }
}

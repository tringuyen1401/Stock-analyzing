/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tri
 */
public class Initiation {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,  Exception {
        Initiation obj = new Initiation();
        obj.run();
    }
    static void run() throws Exception{
    Connection conn = null;    
    String url = "jdbc:mysql://gator4185.hostgator.com:3306/";
    String db = "vninvest_company";
    String dbName = db+"?useUnicode=true&characterEncoding=UTF-8";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "vninvest_admin"; 
    String password = "c.Kz?gF]8t]G";
    Statement statement = null;
    PreparedStatement prestatement = null;
    
    try {
        
       Class.forName(driver).newInstance();
       conn = DriverManager.getConnection(url+dbName,userName,password);
       
    create_main(conn, prestatement);
    create_bs_annual(conn, prestatement);
    create_cfs_annual(conn,prestatement);
    create_is_annual(conn,prestatement);
    } catch(SQLException e) {
            e.printStackTrace();
    
    }
    finally {
        if (conn != null) try{conn.close();} catch(Exception ignore) {}
        if (statement != null) try{statement.close();} catch(Exception ignore) {}
        
        if (prestatement != null) try{prestatement.close();} catch(Exception ignore) {}
    }
    }
    public static void create_main(Connection conn, PreparedStatement prestatement) throws SQLException {
       prestatement = conn.prepareStatement ("DROP TABLE IF EXISTS `main`;");
       prestatement.executeUpdate();  
       
       prestatement = conn.prepareStatement ("CREATE TABLE `main` ( ID INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,"
               + " `Company name` VARCHAR(50) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci, `Accounts payable` VARCHAR(50), `Accounts receivable` VARCHAR(50), `Cash` VARCHAR(50), `Current Asset` VARCHAR(50),"
               + " `Equity` VARCHAR(50), `Goodwill and Intangile` VARCHAR(50), `Inventory` VARCHAR(50), `Long-term investment` VARCHAR(50), `Net fixed assets` VARCHAR(50),"
               + " `Other current assets` VARCHAR(50), `Other current liabilities` VARCHAR(50), `Other long-term assets` VARCHAR(50), `Other long-term liabilities` VARCHAR(50), `Retained earnings` VARCHAR(50),"
               + " `Short-term Investment` VARCHAR(50), `Capital expenditures` VARCHAR(50), `Cash flow` VARCHAR(50), `Cash from financing` VARCHAR(50), `Cash from investing` VARCHAR(50),"
               + " `Cash from operation` VARCHAR(50), `Common Dividend paid` VARCHAR(50), `Depreciation` VARCHAR(50), `Exchange rate effect` VARCHAR(50), `Earning and estimates` VARCHAR(50),"
               + " `Growth rate` VARCHAR(50), `Cost of good sold` VARCHAR(50), `Depreciation(IS)` VARCHAR(50), `Gross income` VARCHAR(50), `Gross operating income` VARCHAR(50),"
               + " `Income after taxes` VARCHAR(50), `Income tax` VARCHAR(50), `Interest expense` VARCHAR(50), `Net income` VARCHAR(50), `Other income` VARCHAR(50),"
               + " `Pre-tax income` VARCHAR(50), `Sales` VARCHAR(50), `Total operating expense` VARCHAR(50), `Multiples` VARCHAR(50), `Floatt` VARCHAR(50),"
               + " `Market Capt Hist.` VARCHAR(50), `Price` VARCHAR(50))");
       
       prestatement.executeUpdate();
    }
    public static void create_bs_annual(Connection conn, PreparedStatement prestatement) throws SQLException {
       prestatement = conn.prepareStatement ("DROP TABLE IF EXISTS `BS_AN`;");
       prestatement.executeUpdate();  
       
       prestatement = conn.prepareStatement ("CREATE TABLE `BS_AN` ( ID INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL, `Company name` VARCHAR(50) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci,"
               + " `Account Payable Y1` VARCHAR(50), `Account Payable Y2` VARCHAR(50), `Account Payable Y3` VARCHAR(50), `Account Payable Y4` VARCHAR(50), `Account Payable Y5` VARCHAR(50),"
               + " `Account Receivable Y1` VARCHAR(50), `Account Receivable Y2` VARCHAR(50), `Account Receivable Y3` VARCHAR(50), `Account Receivable Y4` VARCHAR(50), `Account Receivable Y5` VARCHAR(50),"
               + " `Book value/share Y1` VARCHAR(50), `Book value/share Y2` VARCHAR(50), `Book value/share Y3` VARCHAR(50), `Book value/share Y4` VARCHAR(50), `Book value/share Y5` VARCHAR(50),"
               + " `Cash Y1` VARCHAR(50), `Cash Y2` VARCHAR(50), `Cash Y3` VARCHAR(50), `Cash Y4` VARCHAR(50), `Cash Y5` VARCHAR(50),"
               + " `Current Assets Y1` VARCHAR(50), `Current Assets Y2` VARCHAR(50), `Current Assets Y3` VARCHAR(50), `Current Assets Y4` VARCHAR(50), `Current Assets Y5` VARCHAR(50),"
               + " `Current Liability Y1` VARCHAR(50), `Current Liability Y2` VARCHAR(50), `Current Liability Y3` VARCHAR(50), `Current Liability Y4` VARCHAR(50), `Current Liability Y5` VARCHAR(50),"
               + " `Enterprise value Y1` VARCHAR(50), `Enterprise value Y2` VARCHAR(50), `Enterprise value Y3` VARCHAR(50), `Enterprise value Y4` VARCHAR(50), `Enterprise value Y5` VARCHAR(50),"
               + " `Equity Y1` VARCHAR(50), `Equity Y2` VARCHAR(50), `Equity Y3` VARCHAR(50), `Equity Y4` VARCHAR(50), `Equity Y5` VARCHAR(50),"
               + " `Goodwill and Intangibles Y1` VARCHAR(50), `Goodwill and Intangibles Y2` VARCHAR(50), `Goodwill and Intangibles Y3` VARCHAR(50), `Goodwill and Intangibles Y4` VARCHAR(50), `Goodwill and Intangibles Y5` VARCHAR(50),"
               + " `Inventory Y1` VARCHAR(50), `Inventory Y2` VARCHAR(50), `Inventory Y3` VARCHAR(50), `Inventory Y4` VARCHAR(50), `Inventory Y5` VARCHAR(50),"
               + " `Long-term debt Y1` VARCHAR(50), `Long-term debt Y2` VARCHAR(50), `Long-term debt Y3` VARCHAR(50), `Long-term debt Y4` VARCHAR(50), `Long-term debt Y5` VARCHAR(50),"
               + " `Long-term investment Y1` VARCHAR(50), `Long-term investment Y2` VARCHAR(50), `Long-term investment Y3` VARCHAR(50), `Long-term investment Y4` VARCHAR(50), `Long-term investment Y5` VARCHAR(50),"
               + " `Net fixed assets Y1` VARCHAR(50), `Net fixed assets Y2` VARCHAR(50), `Net fixed assets Y3` VARCHAR(50), `Net fixed assets Y4` VARCHAR(50), `Net fixed assets Y5` VARCHAR(50),"
               + " `Other current assets Y1` VARCHAR(50), `Other current assets Y2` VARCHAR(50), `Other current assets Y3` VARCHAR(50), `Other current assets Y4` VARCHAR(50), `Other current assets Y5` VARCHAR(50),"
               + " `Other current liabilities Y1` VARCHAR(50), `Other current liabilities Y2` VARCHAR(50), `Other current liabilities Y3` VARCHAR(50), `Other current liabilities Y4` VARCHAR(50), `Other current liabilities Y5` VARCHAR(50),"
               + " `Other long-term assets Y1` VARCHAR(50), `Other long-term assets Y2` VARCHAR(50), `Other long-term assets Y3` VARCHAR(50), `Other long-term assets Y4` VARCHAR(50), `Other long-term assets Y5` VARCHAR(50),"
               + " `Other long-term liabilities Y1` VARCHAR(50), `Other long-term liabilities Y2` VARCHAR(50), `Other long-term liabilities Y3` VARCHAR(50), `Other long-term liabilities Y4` VARCHAR(50), `Other long-term liabilities Y5` VARCHAR(50),"
               + " `Retained Earnings Y1` VARCHAR(50), `Retained Earnings Y2` VARCHAR(50), `Retained Earnings Y3` VARCHAR(50), `Retained Earnings Y4` VARCHAR(50), `Retained Earnings Y5` VARCHAR(50),"
               + " `Short-term debt Y1` VARCHAR(50), `Short-term debt Y2` VARCHAR(50), `Short-term debt Y3` VARCHAR(50), `Short-term debt Y4` VARCHAR(50), `Short-term debt Y5` VARCHAR(50),"
               + " `Short-term investments Y1` VARCHAR(50), `Short-term investments Y2` VARCHAR(50), `Short-term investments Y3` VARCHAR(50), `Short-term investments Y4` VARCHAR(50), `Short-term investments Y5` VARCHAR(50),"
               + " `Total assets Y1` VARCHAR(50), `Total assets Y2` VARCHAR(50), `Total assets Y3` VARCHAR(50), `Total assets Y4` VARCHAR(50), `Total assets Y5` VARCHAR(50),"
               + " `Total liabilities Y1` VARCHAR(50), `Total liabilities Y2` VARCHAR(50), `Total liabilities Y3` VARCHAR(50), `Total liabilities Y4` VARCHAR(50), `Total liabilities Y5` VARCHAR(50),"
               + " `Working Capital Y1` VARCHAR(50), `Working Capital Y2` VARCHAR(50), `Working Capital Y3` VARCHAR(50), `Working Capital Y4` VARCHAR(50), `Working Capital Y5` VARCHAR(50))");
       prestatement.executeUpdate();
    }
    
    public static void create_cfs_annual(Connection conn, PreparedStatement prestatement) throws SQLException {
       prestatement = conn.prepareStatement ("DROP TABLE IF EXISTS `CF_AN`;");
       prestatement.executeUpdate();  
       
       prestatement = conn.prepareStatement ("CREATE TABLE `CF_AN` ( ID INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,`Company name` VARCHAR(50) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci,"
                + "`Capital expenditures Y1` VARCHAR(50),`Capital expenditures Y2` VARCHAR(50),`Capital expenditures Y3` VARCHAR(50),`Capital expenditures Y4` VARCHAR(50),`Capital expenditures Y5` VARCHAR(50),"
                + "`Cash flow Y1` VARCHAR(50),`Cash flow Y2` VARCHAR(50),`Cash flow Y3` VARCHAR(50),`Cash flow Y4` VARCHAR(50),`Cash flow Y5` VARCHAR(50),"
                + "`Cash flow/share Y1` VARCHAR(50), `Cash flow/share Y2` VARCHAR(50),`Cash flow/share Y3` VARCHAR(50),`Cash flow/share Y4` VARCHAR(50),`Cash flow/share Y5` VARCHAR(50),"
                + "`Cash from financing Y1` VARCHAR(50),`Cash from financing Y2` VARCHAR(50),`Cash from financing Y3` VARCHAR(50),`Cash from financing Y4` VARCHAR(50),`Cash from financing Y5` VARCHAR(50),"
                + "`Cash from investing Y1` VARCHAR(50),`Cash from investing Y2` VARCHAR(50),`Cash from investing Y3` VARCHAR(50),`Cash from investing Y4` VARCHAR(50),`Cash from investing Y5` VARCHAR(50),"
                + "`Cash from operation Y1` VARCHAR(50),`Cash from operation Y2` VARCHAR(50),`Cash from operation Y3` VARCHAR(50),`Cash from operation Y4` VARCHAR(50),`Cash from operation Y5` VARCHAR(50),"
                + "`Common Dividend Paid Y1` VARCHAR(50),`Common Dividend Paid Y2` VARCHAR(50),`Common Dividend Paid Y3` VARCHAR(50),`Common Dividend Paid Y4` VARCHAR(50),`Common Dividend Paid Y5` VARCHAR(50),"
                + "`Depreciation and Amortization Y1` VARCHAR(50),`Depreciation and Amortization Y2` VARCHAR(50),`Depreciation and Amortization Y3` VARCHAR(50),`Depreciation and Amortization Y4` VARCHAR(50),`Depreciation and Amortization Y5` VARCHAR(50),"
                + "`Exchange rate effect Y1` VARCHAR(50),`Exchange rate effect Y2` VARCHAR(50),`Exchange rate effect Y3` VARCHAR(50),`Exchange rate effect Y4` VARCHAR(50),`Exchange rate effect Y5` VARCHAR(50),"
                + "`Free cash flow/share Y1` VARCHAR(50),`Free cash flow/share Y2` VARCHAR(50),`Free cash flow/share Y3` VARCHAR(50),`Free cash flow/share Y4` VARCHAR(50),`Free cash flow/share Y5` VARCHAR(50))");
       prestatement.executeUpdate();  
}
    
    public static void create_is_annual(Connection conn, PreparedStatement prestatement) throws SQLException {
        prestatement = conn.prepareStatement ("DROP TABLE IF EXISTS `IS_AN`;");
        
       prestatement.executeUpdate();  
    
     prestatement = conn.prepareStatement ("CREATE TABLE `IS_AN` ( ID INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,`Company name` VARCHAR(50) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci,"
             + "`Cost of goods sold Y1` VARCHAR(50),`Cost of goods sold Y2` VARCHAR(50),`Cost of goods sold Y3` VARCHAR(50),`Cost of goods sold Y4` VARCHAR(50),`Cost of goods sold Y5` VARCHAR(50),"
                + "`Depreciation Y1` VARCHAR(50),`Depreciation Y2` VARCHAR(50),`Depreciation Y3` VARCHAR(50),`Depreciation Y4` VARCHAR(50),`Depreciation Y5` VARCHAR(50),"
                + "`EBIT Y1` VARCHAR(50),`EBIT Y2` VARCHAR(50),`EBIT Y3` VARCHAR(50),`EBIT Y4` VARCHAR(50),`EBIT Y5` VARCHAR(50),"
                + "`EBITDA Y1` VARCHAR(50),`EBITDA Y2` VARCHAR(50),`EBITDA Y3` VARCHAR(50),`EBITDA Y4` VARCHAR(50),`EBITDA Y5` VARCHAR(50),"
                + "`EPS Y1` VARCHAR(50),`EPS Y2` VARCHAR(50),`EPS Y3` VARCHAR(50),`EPS Y4` VARCHAR(50),`EPS Y5` VARCHAR(50),"
                + "`Gross income Y1` VARCHAR(50),`Gross income Y2` VARCHAR(50),`Gross income Y3` VARCHAR(50),`Gross income Y4` VARCHAR(50),`Gross income Y5` VARCHAR(50),"
                + "`Gross operating income Y1` VARCHAR(50),`Gross operating income Y2` VARCHAR(50),`Gross operating income Y3` VARCHAR(50),`Gross operating income Y4` VARCHAR(50),`Gross operating income Y5` VARCHAR(50),"
                + "`Income after taxes Y1` VARCHAR(50),`Income after taxes Y2` VARCHAR(50),`Income after taxes Y3` VARCHAR(50),`Income after taxes Y4` VARCHAR(50),`Income after taxes Y5` VARCHAR(50),"
                + "`Income tax Y1` VARCHAR(50),`Income tax Y2` VARCHAR(50),`Income tax Y3` VARCHAR(50),`Income tax Y4` VARCHAR(50),`Income tax Y5` VARCHAR(50),"
                + "`Interest expense Y1` VARCHAR(50),`Interest expense Y2` VARCHAR(50),`Interest expense Y3` VARCHAR(50),`Interest expense Y4` VARCHAR(50),`Interest expense Y5` VARCHAR(50),"
                + "`Net income Y1` VARCHAR(50),`Net income Y2` VARCHAR(50),`Net income Y3` VARCHAR(50),`Net income Y4` VARCHAR(50),`Net income Y5` VARCHAR(50),"
                + "`Other income Y1` VARCHAR(50),`Other income Y2` VARCHAR(50),`Other income Y3` VARCHAR(50),`Other income Y4` VARCHAR(50),`Other income Y5` VARCHAR(50),"
                + "`Pre-tax income Y1` VARCHAR(50),`Pre-tax income Y2` VARCHAR(50),`Pre-tax income Y3` VARCHAR(50),`Pre-tax income Y4` VARCHAR(50),`Pre-tax income Y5` VARCHAR(50),"
                + "`Sales Y1` VARCHAR(50),`Sales Y2` VARCHAR(50),`Sales Y3` VARCHAR(50),`Sales Y4` VARCHAR(50),`Sales Y5` VARCHAR(50),"
                + "`Total operating expenses Y1` VARCHAR(50),`Total operating expenses Y2` VARCHAR(50),`Total operating expenses Y3` VARCHAR(50),`Total operating expenses Y4` VARCHAR(50),`Total operating expenses Y5` VARCHAR(50))");
        prestatement.executeUpdate();
    }

    }




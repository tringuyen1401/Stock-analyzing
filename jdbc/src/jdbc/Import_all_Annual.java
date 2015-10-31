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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import jdbc.BS;
import jdbc.CFS;
import jdbc.IS;
import jdbc.FI;
import static jdbc.Import_data_csv.isDouble;

/**
 *
 * @author tri
 */
public class Import_all_Annual {
    PreparedStatement p1 = null;
    PreparedStatement p2 = null;
    PreparedStatement p_main = null;
    PreparedStatement p_is_a = null;
    PreparedStatement p_bs_a = null;
    PreparedStatement p_cfs_a = null;
    PreparedStatement p_delcom = null;
    PreparedStatement p_val = null;
    PreparedStatement p_mul = null;
    PreparedStatement p_rat = null;
    PreparedStatement p_percent = null;
    Import_all_Annual(Connection conn) throws SQLException {
        
        this.p_main = conn.prepareStatement("INSERT INTO `main` ("
                + "`Company name`, `Accounts payable`, `Accounts receivable`, `Cash`, `Current Asset`, `Equity`, `Goodwill and Intangile`, `Inventory`, `Long-term investment`, `Net fixed assets`,"
                + " `Other current assets`, `Other current liabilities`, `Other long-term assets`, `Other long-term liabilities`, `Retained earnings`, `Short-term Investment`, `Capital expenditures`, `Cash flow`, `Cash from financing`, `Cash from investing`,"
                + " `Cash from operation`, `Common Dividend paid`, `Depreciation`, `Exchange rate effect`,`Earning and estimates`, `Growth rate`, `Cost of good sold`, `Depreciation(IS)`,`Gross income`, `Gross operating income`,"
                + " `Income after taxes`,`Income tax`,`Interest expense`, `Net income`, `Other income`, `Pre-tax income`, `Sales`, `Total operating expense`, `Multiples`, `Floatt`,"
                + " `Market Capt Hist.`,`Price`)"
                + " VALUES(N?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?);");;
        this.p_is_a = conn.prepareStatement ("INSERT INTO `IS_AN` (`Company name`,"
                + "`Cost of goods sold Y1`,`Cost of goods sold Y2`,`Cost of goods sold Y3`,`Cost of goods sold Y4`,`Cost of goods sold Y5`,"
                + "`Depreciation Y1`,`Depreciation Y2`,`Depreciation Y3`,`Depreciation Y4`,`Depreciation Y5`,"
                + "`EBIT Y1`,`EBIT Y2`,`EBIT Y3`,`EBIT Y4`,`EBIT Y5`,"
                + "`EBITDA Y1`,`EBITDA Y2`,`EBITDA Y3`,`EBITDA Y4`,`EBITDA Y5`,"
                + "`EPS Y1`,`EPS Y2`,`EPS Y3`,`EPS Y4`,`EPS Y5`,"
                + "`Gross income Y1`,`Gross income Y2`,`Gross income Y3`,`Gross income Y4`,`Gross income Y5`,"
                + "`Gross operating income Y1`,`Gross operating income Y2`,`Gross operating income Y3`,`Gross operating income Y4`,`Gross operating income Y5`,"
                + "`Income after taxes Y1`,`Income after taxes Y2`,`Income after taxes Y3`,`Income after taxes Y4`,`Income after taxes Y5`,"
                + "`Income tax Y1`,`Income tax Y2`,`Income tax Y3`,`Income tax Y4`,`Income tax Y5`,"
                + "`Interest expense Y1`,`Interest expense Y2`,`Interest expense Y3`,`Interest expense Y4`,`Interest expense Y5`,"
                + "`Net income Y1`,`Net income Y2`,`Net income Y3`,`Net income Y4`,`Net income Y5`,"
                + "`Other income Y1`,`Other income Y2`,`Other income Y3`,`Other income Y4`,`Other income Y5`,"
                + "`Pre-tax income Y1`,`Pre-tax income Y2`,`Pre-tax income Y3`,`Pre-tax income Y4`,`Pre-tax income Y5`,"
                + "`Sales Y1`,`Sales Y2`,`Sales Y3`,`Sales Y4`,`Sales Y5`,"
                + "`Total operating expenses Y1`,`Total operating expenses Y2`,`Total operating expenses Y3`,`Total operating expenses Y4`,`Total operating expenses Y5`) "
                + "VALUES(N?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?)");;
        this.p_bs_a =  conn.prepareStatement ("INSERT INTO `BS_AN` (`Company name`,"
               + " `Account Payable Y1`, `Account Payable Y2`, `Account Payable Y3`, `Account Payable Y4`, `Account Payable Y5`,"
               + " `Account Receivable Y1`, `Account Receivable Y2`, `Account Receivable Y3`, `Account Receivable Y4`, `Account Receivable Y5`,"
               + " `Book value/share Y1`, `Book value/share Y2`, `Book value/share Y3`, `Book value/share Y4`, `Book value/share Y5`,"
               + " `Cash Y1`, `Cash Y2`, `Cash Y3`, `Cash Y4`, `Cash Y5`,"
               + " `Current Assets Y1`, `Current Assets Y2`, `Current Assets Y3`, `Current Assets Y4`, `Current Assets Y5`,"
               + " `Current Liability Y1`, `Current Liability Y2`, `Current Liability Y3`, `Current Liability Y4`, `Current Liability Y5`,"
               + " `Enterprise value Y1`, `Enterprise value Y2`, `Enterprise value Y3`, `Enterprise value Y4`, `Enterprise value Y5`,"
               + " `Equity Y1`, `Equity Y2`, `Equity Y3`, `Equity Y4`, `Equity Y5`,"
               + " `Goodwill and Intangibles Y1`, `Goodwill and Intangibles Y2`, `Goodwill and Intangibles Y3`, `Goodwill and Intangibles Y4`, `Goodwill and Intangibles Y5`,"
               + " `Inventory Y1`, `Inventory Y2`, `Inventory Y3`, `Inventory Y4`, `Inventory Y5`,"
               + " `Long-term debt Y1`, `Long-term debt Y2`, `Long-term debt Y3`, `Long-term debt Y4`, `Long-term debt Y5`,"
               + " `Long-term investment Y1`, `Long-term investment Y2`, `Long-term investment Y3`, `Long-term investment Y4`, `Long-term investment Y5`,"
               + " `Net fixed assets Y1`, `Net fixed assets Y2`, `Net fixed assets Y3`, `Net fixed assets Y4`, `Net fixed assets Y5`,"
               + " `Other current assets Y1`, `Other current assets Y2`, `Other current assets Y3`, `Other current assets Y4`, `Other current assets Y5`,"
               + " `Other current liabilities Y1`, `Other current liabilities Y2`, `Other current liabilities Y3`, `Other current liabilities Y4`, `Other current liabilities Y5`,"
               + " `Other long-term assets Y1`, `Other long-term assets Y2`, `Other long-term assets Y3`, `Other long-term assets Y4`, `Other long-term assets Y5`,"
               + " `Other long-term liabilities Y1`, `Other long-term liabilities Y2`, `Other long-term liabilities Y3`, `Other long-term liabilities Y4`, `Other long-term liabilities Y5`,"
               + " `Retained Earnings Y1`, `Retained Earnings Y2`, `Retained Earnings Y3`, `Retained Earnings Y4`, `Retained Earnings Y5`,"
               + " `Short-term debt Y1`, `Short-term debt Y2`, `Short-term debt Y3`, `Short-term debt Y4`, `Short-term debt Y5`,"
               + " `Short-term investments Y1`, `Short-term investments Y2`, `Short-term investments Y3`, `Short-term investments Y4`, `Short-term investments Y5`,"
               + " `Total assets Y1`, `Total assets Y2`, `Total assets Y3`, `Total assets Y4`, `Total assets Y5`,"
               + " `Total liabilities Y1`, `Total liabilities Y2`, `Total liabilities Y3`, `Total liabilities Y4`, `Total liabilities Y5`,"
               + " `Working Capital Y1`, `Working Capital Y2`, `Working Capital Y3`, `Working Capital Y4`, `Working Capital Y5`)"
               + " VALUES(N?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?,"
               + "?,?,?,?,?);");
       
        this.p_cfs_a =  conn.prepareStatement ("INSERT INTO `CF_AN` (`Company name`,"
                + "`Capital expenditures Y1`,`Capital expenditures Y2`,`Capital expenditures Y3`,`Capital expenditures Y4`,`Capital expenditures Y5`,"
                + "`Cash flow Y1`,`Cash flow Y2`,`Cash flow Y3`,`Cash flow Y4`,`Cash flow Y5`,"
                + "`Cash flow/share Y1`, `Cash flow/share Y2`,`Cash flow/share Y3`,`Cash flow/share Y4`,`Cash flow/share Y5`,"
                + "`Cash from financing Y1`,`Cash from financing Y2`,`Cash from financing Y3`,`Cash from financing Y4`,`Cash from financing Y5`,"
                + "`Cash from investing Y1`,`Cash from investing Y2`,`Cash from investing Y3`,`Cash from investing Y4`,`Cash from investing Y5`,"
                + "`Cash from operation Y1`,`Cash from operation Y2`,`Cash from operation Y3`,`Cash from operation Y4`,`Cash from operation Y5`,"
                + "`Common Dividend Paid Y1`,`Common Dividend Paid Y2`,`Common Dividend Paid Y3`,`Common Dividend Paid Y4`,`Common Dividend Paid Y5`,"
                + "`Depreciation and Amortization Y1`,`Depreciation and Amortization Y2`,`Depreciation and Amortization Y3`,`Depreciation and Amortization Y4`,`Depreciation and Amortization Y5`,"
                + "`Exchange rate effect Y1`,`Exchange rate effect Y2`,`Exchange rate effect Y3`,`Exchange rate effect Y4`,`Exchange rate effect Y5`,"
                + "`Free cash flow/share Y1`,`Free cash flow/share Y2`,`Free cash flow/share Y3`,`Free cash flow/share Y4`,`Free cash flow/share Y5`)"
                + " VALUES(N?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?)");
        
    }
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String url = "jdbc:mysql://gator4185.hostgator.com:3306/";
    String db = "vninvest_company";
    String dbName = db+"?useUnicode=true&characterEncoding=UTF-8";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "vninvest_admin"; 
    String password = "c.Kz?gF]8t]G";
        Class.forName(driver).newInstance();
       conn = DriverManager.getConnection(url+dbName,userName,password);
        
       conn.setAutoCommit(false);
        Import_all_Annual obj = new Import_all_Annual(conn);
        Integer linenumber = 2; 
        String name = "a";
        
        while (linenumber < 695 && name != null) {
            name = Import_data_excel_Fin_Annual.readfile(linenumber);
     //       name = name.substring(1,name.length());
            System.out.println(name);
            obj.run(name,conn);
            linenumber += 1;
        }
        
        
        obj.execute();
        conn.commit();
      //  obj.run("AAA");
             
    }
    public void execute() throws SQLException {
        
        p_main.executeBatch();
        p_is_a.executeBatch();
        p_bs_a.executeBatch();
        p_cfs_a.executeBatch();
        
        
    }
    void run(String company, Connection conn) throws Exception {
        
    
    
  
     p_percent = conn.prepareStatement("INSERT INTO `"+company+"_%FINA` (`clause`, `2013`, `2012`, `2011`, `2010`, `2009`,`2008`,`2007`,`2006`,`2005`) VALUES(N?,?,?,?,?,?,?,?,?,?);");
    
        
        
     PreparedStatement prestatement = null;
   Integer year = 2015;
   Integer linenumber = 0; 
   String clause = null; 
   String data_05 = null;
   String data_06 = null;
   String data_07 = null;
   String data_08 = null;
   String data_09 = null;
   String data_10 = null;
   String data_11 = null;
   String data_12 = null;
   String data_13 = null;
   
    
    //Change
    Double change_05= null;
    Double change_06= null;
    Double change_07= null;
    Double change_08= null;
    Double change_09= null;
    Double change_10= null;
    Double change_11= null;
    Double change_12= null;
    Double change_13= null;
    
   
    
    try {
       
    Import_all_Annual IaA = new Import_all_Annual(conn);
    IS is = new IS();
    BS bs = new BS();
    CFS cfs = new CFS();
    FI fi = new FI();
  
    
    Double cp05 = IaA.close_price(company, year - 8);
    Double cp06 = IaA.close_price(company, year - 7);
    Double cp07 = IaA.close_price(company, year - 6);
    Double cp08 = IaA.close_price(company, year - 5);
    Double cp09 = IaA.close_price(company, year - 4);
    Double cp10 = IaA.close_price(company, year - 3);
    Double cp11 = IaA.close_price(company, year - 2);
    Double cp12 = IaA.close_price(company, year - 1);
    Double cp13 = IaA.close_price(company, year);
    
    add_company(conn,prestatement,company,"_FINA");
    add_company(conn,prestatement,company,"_%FINA");
    
    
    //////////////////////////////FI
     //Cổ phiếu
    Double sn_05 = Double.parseDouble(dtcm(fi.read_FI(company,7,2005)));
    Double sn_06 = Double.parseDouble(dtcm(fi.read_FI(company,7,2006)));
    Double sn_07 = Double.parseDouble(dtcm(fi.read_FI(company,7,2007)));
    Double sn_08 = Double.parseDouble(dtcm(fi.read_FI(company,7,2008)));
    Double sn_09 = Double.parseDouble(dtcm(fi.read_FI(company,7,2009)));
    Double sn_10 = Double.parseDouble(dtcm(fi.read_FI(company,7,2010)));
    Double sn_11 = Double.parseDouble(dtcm(fi.read_FI(company,7,2011)));
    Double sn_12 = Double.parseDouble(dtcm(fi.read_FI(company,7,2012)));
    Double sn_13 = Double.parseDouble(dtcm(fi.read_FI(company,7,2013)));
    
    
    if ("0.0".equals(sn_12)) {sn_12 = sn_13;}
    if ("0.0".equals(sn_11)) {sn_11 = sn_12;}
    if ("0.0".equals(sn_10)) {sn_10 = sn_11;}
    if ("0.0".equals(sn_09)) {sn_09 = sn_10;}
    if ("0.0".equals(sn_08)) {sn_08 = sn_09;}
    if ("0.0".equals(sn_07)) {sn_07 = sn_08;}
    if ("0.0".equals(sn_06)) {sn_06 = sn_07;}
    if ("0.0".equals(sn_05)) {sn_05 = sn_06;}
    // Cổ tức
    Double ct_05 = Double.parseDouble(dtcm(fi.read_FI(company,10,2005)));
    Double ct_06 = Double.parseDouble(dtcm(fi.read_FI(company,10,2006)));
    Double ct_07 = Double.parseDouble(dtcm(fi.read_FI(company,10,2007)));
    Double ct_08 = Double.parseDouble(dtcm(fi.read_FI(company,10,2008)));
    Double ct_09 = Double.parseDouble(dtcm(fi.read_FI(company,10,2009)));
    Double ct_10 = Double.parseDouble(dtcm(fi.read_FI(company,10,2010)));
    Double ct_11 = Double.parseDouble(dtcm(fi.read_FI(company,10,2011)));
    Double ct_12 = Double.parseDouble(dtcm(fi.read_FI(company,10,2012)));
    Double ct_13 = Double.parseDouble(dtcm(fi.read_FI(company,10,2013)));
    
    
    
    /////////////////////////// IS
    add_company(conn,prestatement,company,"_IS");
    add_data(conn,prestatement,company,"_FINA","INCOME STATEMENT","","","","","","","","","");
    add_data(conn,prestatement,company,"_%FINA","INCOME STATEMENT","","","","","","","","","");
    
    
    
    //Doanh thu thuần
    Double dtt_05 = Double.parseDouble(dtcm(is.read_IS(company,5,2005)));
    Double dtt_06 = Double.parseDouble(dtcm(is.read_IS(company,5,2006)));
    Double dtt_07 = Double.parseDouble(dtcm(is.read_IS(company,5,2007)));
    Double dtt_08 = Double.parseDouble(dtcm(is.read_IS(company,5,2008)));
    Double dtt_09 = Double.parseDouble(dtcm(is.read_IS(company,5,2009)));
    Double dtt_10 = Double.parseDouble(dtcm(is.read_IS(company,5,2010)));
    Double dtt_11 = Double.parseDouble(dtcm(is.read_IS(company,5,2011)));
    Double dtt_12 = Double.parseDouble(dtcm(is.read_IS(company,5,2012)));
    Double dtt_13 = Double.parseDouble(dtcm(is.read_IS(company,5,2013)));
    
    //Giá vốn bán hàng
    Double gvbh_05 = Double.parseDouble(dtcm(is.read_IS(company,6,2005)));
    Double gvbh_06 = Double.parseDouble(dtcm(is.read_IS(company,6,2006)));
    Double gvbh_07 = Double.parseDouble(dtcm(is.read_IS(company,6,2007)));
    Double gvbh_08 = Double.parseDouble(dtcm(is.read_IS(company,6,2008)));
    Double gvbh_09 = Double.parseDouble(dtcm(is.read_IS(company,6,2009)));
    Double gvbh_10 = Double.parseDouble(dtcm(is.read_IS(company,6,2010)));
    Double gvbh_11 = Double.parseDouble(dtcm(is.read_IS(company,6,2011)));
    Double gvbh_12 = Double.parseDouble(dtcm(is.read_IS(company,6,2012)));
    Double gvbh_13 = Double.parseDouble(dtcm(is.read_IS(company,6,2013)));
    
    //Lãi gộp
    Double lg_05 = Double.parseDouble(dtcm(is.read_IS(company,7,2005)));
    Double lg_06 = Double.parseDouble(dtcm(is.read_IS(company,7,2006)));
    Double lg_07 = Double.parseDouble(dtcm(is.read_IS(company,7,2007)));
    Double lg_08 = Double.parseDouble(dtcm(is.read_IS(company,7,2008)));
    Double lg_09 = Double.parseDouble(dtcm(is.read_IS(company,7,2009)));
    Double lg_10 = Double.parseDouble(dtcm(is.read_IS(company,7,2010)));
    Double lg_11 = Double.parseDouble(dtcm(is.read_IS(company,7,2011)));
    Double lg_12 = Double.parseDouble(dtcm(is.read_IS(company,7,2012)));
    Double lg_13 = Double.parseDouble(dtcm(is.read_IS(company,7,2013)));
    
    //Thu nhập tài chính
    Double tntc_05 = Double.parseDouble(dtcm(is.read_IS(company,8,2005)));
    Double tntc_06 = Double.parseDouble(dtcm(is.read_IS(company,8,2006)));
    Double tntc_07 = Double.parseDouble(dtcm(is.read_IS(company,8,2007)));
    Double tntc_08 = Double.parseDouble(dtcm(is.read_IS(company,8,2008)));
    Double tntc_09 = Double.parseDouble(dtcm(is.read_IS(company,8,2009)));
    Double tntc_10 = Double.parseDouble(dtcm(is.read_IS(company,8,2010)));
    Double tntc_11 = Double.parseDouble(dtcm(is.read_IS(company,8,2011)));
    Double tntc_12 = Double.parseDouble(dtcm(is.read_IS(company,8,2012)));
    Double tntc_13 = Double.parseDouble(dtcm(is.read_IS(company,8,2013)));
    
    //Chi phi tài chính
    Double cptc_05 = Double.parseDouble(dtcm(is.read_IS(company,10,2005)));
    Double cptc_06 = Double.parseDouble(dtcm(is.read_IS(company,10,2006)));
    Double cptc_07 = Double.parseDouble(dtcm(is.read_IS(company,10,2007)));
    Double cptc_08 = Double.parseDouble(dtcm(is.read_IS(company,10,2008)));
    Double cptc_09 = Double.parseDouble(dtcm(is.read_IS(company,10,2009)));
    Double cptc_10 = Double.parseDouble(dtcm(is.read_IS(company,10,2010)));
    Double cptc_11 = Double.parseDouble(dtcm(is.read_IS(company,10,2011)));
    Double cptc_12 = Double.parseDouble(dtcm(is.read_IS(company,10,2012)));
    Double cptc_13 = Double.parseDouble(dtcm(is.read_IS(company,10,2013)));
    
    //Chi phí tiền lãi vay
    Double cptlv_05 = Double.parseDouble(dtcm(is.read_IS(company,11,2005)));
    Double cptlv_06 = Double.parseDouble(dtcm(is.read_IS(company,11,2006)));
    Double cptlv_07 = Double.parseDouble(dtcm(is.read_IS(company,11,2007)));
    Double cptlv_08 = Double.parseDouble(dtcm(is.read_IS(company,11,2008)));
    Double cptlv_09 = Double.parseDouble(dtcm(is.read_IS(company,11,2009)));
    Double cptlv_10 = Double.parseDouble(dtcm(is.read_IS(company,11,2010)));
    Double cptlv_11 = Double.parseDouble(dtcm(is.read_IS(company,11,2011)));
    Double cptlv_12 = Double.parseDouble(dtcm(is.read_IS(company,11,2012)));
    Double cptlv_13 = Double.parseDouble(dtcm(is.read_IS(company,11,2013)));
    
    //Chi phí bán hàng
    Double cpbh_05 = Double.parseDouble(dtcm(is.read_IS(company,12,2005)));
    Double cpbh_06 = Double.parseDouble(dtcm(is.read_IS(company,12,2006)));
    Double cpbh_07 = Double.parseDouble(dtcm(is.read_IS(company,12,2007)));
    Double cpbh_08 = Double.parseDouble(dtcm(is.read_IS(company,12,2008)));
    Double cpbh_09 = Double.parseDouble(dtcm(is.read_IS(company,12,2009)));
    Double cpbh_10 = Double.parseDouble(dtcm(is.read_IS(company,12,2010)));
    Double cpbh_11 = Double.parseDouble(dtcm(is.read_IS(company,12,2011)));
    Double cpbh_12 = Double.parseDouble(dtcm(is.read_IS(company,12,2012)));
    Double cpbh_13 = Double.parseDouble(dtcm(is.read_IS(company,12,2013)));
    
    //Chi phí quản lí doanh nghiệp
    Double cpqldn_05 = Double.parseDouble(dtcm(is.read_IS(company,13,2005)));
    Double cpqldn_06 = Double.parseDouble(dtcm(is.read_IS(company,13,2006)));
    Double cpqldn_07 = Double.parseDouble(dtcm(is.read_IS(company,13,2007)));
    Double cpqldn_08 = Double.parseDouble(dtcm(is.read_IS(company,13,2008)));
    Double cpqldn_09 = Double.parseDouble(dtcm(is.read_IS(company,13,2009)));
    Double cpqldn_10 = Double.parseDouble(dtcm(is.read_IS(company,13,2010)));
    Double cpqldn_11 = Double.parseDouble(dtcm(is.read_IS(company,13,2011)));
    Double cpqldn_12 = Double.parseDouble(dtcm(is.read_IS(company,13,2012)));
    Double cpqldn_13 = Double.parseDouble(dtcm(is.read_IS(company,13,2013)));
    
    //Lãi từ hoạt động kinh doanh
    Double lthdkd_05 = Double.parseDouble(dtcm(is.read_IS(company,14,2005)));
    Double lthdkd_06 = Double.parseDouble(dtcm(is.read_IS(company,14,2006)));
    Double lthdkd_07 = Double.parseDouble(dtcm(is.read_IS(company,14,2007)));
    Double lthdkd_08 = Double.parseDouble(dtcm(is.read_IS(company,14,2008)));
    Double lthdkd_09 = Double.parseDouble(dtcm(is.read_IS(company,14,2009)));
    Double lthdkd_10 = Double.parseDouble(dtcm(is.read_IS(company,14,2010)));
    Double lthdkd_11 = Double.parseDouble(dtcm(is.read_IS(company,14,2011)));
    Double lthdkd_12 = Double.parseDouble(dtcm(is.read_IS(company,14,2012)));
    Double lthdkd_13 = Double.parseDouble(dtcm(is.read_IS(company,14,2013)));
    
     //Thu nhập chi phí khác
    Double tncpk_05 = Double.parseDouble(dtcm(is.read_IS(company,14,2005)));
    Double tncpk_06 = Double.parseDouble(dtcm(is.read_IS(company,14,2006)));
    Double tncpk_07 = Double.parseDouble(dtcm(is.read_IS(company,14,2007)));
    Double tncpk_08 = Double.parseDouble(dtcm(is.read_IS(company,14,2008)));
    Double tncpk_09 = Double.parseDouble(dtcm(is.read_IS(company,14,2009)));
    Double tncpk_10 = Double.parseDouble(dtcm(is.read_IS(company,14,2010)));
    Double tncpk_11 = Double.parseDouble(dtcm(is.read_IS(company,14,2011)));
    Double tncpk_12 = Double.parseDouble(dtcm(is.read_IS(company,14,2012)));
    Double tncpk_13 = Double.parseDouble(dtcm(is.read_IS(company,14,2013)));
    
     //Lãi trước thuế
    Double ltt_05 = Double.parseDouble(dtcm(is.read_IS(company,17,2005)));
    Double ltt_06 = Double.parseDouble(dtcm(is.read_IS(company,17,2006)));
    Double ltt_07 = Double.parseDouble(dtcm(is.read_IS(company,17,2007)));
    Double ltt_08 = Double.parseDouble(dtcm(is.read_IS(company,17,2008)));
    Double ltt_09 = Double.parseDouble(dtcm(is.read_IS(company,17,2009)));
    Double ltt_10 = Double.parseDouble(dtcm(is.read_IS(company,17,2010)));
    Double ltt_11 = Double.parseDouble(dtcm(is.read_IS(company,17,2011)));
    Double ltt_12 = Double.parseDouble(dtcm(is.read_IS(company,17,2012)));
    Double ltt_13 = Double.parseDouble(dtcm(is.read_IS(company,17,2013)));
    //Thuế TNDN
    Double ttndn_05 = Double.parseDouble(dtcm(is.read_IS(company,18,2005)));
    Double ttndn_06 = Double.parseDouble(dtcm(is.read_IS(company,18,2006)));
    Double ttndn_07 = Double.parseDouble(dtcm(is.read_IS(company,18,2007)));
    Double ttndn_08 = Double.parseDouble(dtcm(is.read_IS(company,18,2008)));
    Double ttndn_09 = Double.parseDouble(dtcm(is.read_IS(company,18,2009)));
    Double ttndn_10 = Double.parseDouble(dtcm(is.read_IS(company,18,2010)));
    Double ttndn_11 = Double.parseDouble(dtcm(is.read_IS(company,18,2011)));
    Double ttndn_12 = Double.parseDouble(dtcm(is.read_IS(company,18,2012)));
    Double ttndn_13 = Double.parseDouble(dtcm(is.read_IS(company,18,2013)));
     
    //Lãi sau thuế
    Double lst_05 = Double.parseDouble(dtcm(is.read_IS(company,20,2005)));
    Double lst_06 = Double.parseDouble(dtcm(is.read_IS(company,20,2006)));
    Double lst_07 = Double.parseDouble(dtcm(is.read_IS(company,20,2007)));
    Double lst_08 = Double.parseDouble(dtcm(is.read_IS(company,20,2008)));
    Double lst_09 = Double.parseDouble(dtcm(is.read_IS(company,20,2009)));
    Double lst_10 = Double.parseDouble(dtcm(is.read_IS(company,20,2010)));
    Double lst_11 = Double.parseDouble(dtcm(is.read_IS(company,20,2011)));
    Double lst_12 = Double.parseDouble(dtcm(is.read_IS(company,20,2012)));
    Double lst_13 = Double.parseDouble(dtcm(is.read_IS(company,20,2013)));
    //lãi lỗ từ hoạt động kinh doanh
    Double llthdkd_05 = Double.parseDouble(dtcm(is.read_IS(company,14,2005)));
    Double llthdkd_06 = Double.parseDouble(dtcm(is.read_IS(company,14,2006)));
    Double llthdkd_07 = Double.parseDouble(dtcm(is.read_IS(company,14,2007)));
    Double llthdkd_08 = Double.parseDouble(dtcm(is.read_IS(company,14,2008)));
    Double llthdkd_09 = Double.parseDouble(dtcm(is.read_IS(company,14,2009)));
    Double llthdkd_10 = Double.parseDouble(dtcm(is.read_IS(company,14,2010)));
    Double llthdkd_11 = Double.parseDouble(dtcm(is.read_IS(company,14,2011)));
    Double llthdkd_12 = Double.parseDouble(dtcm(is.read_IS(company,14,2012)));
    Double llthdkd_13 = Double.parseDouble(dtcm(is.read_IS(company,14,2013)));
    // Lãi lỗ công ty mẹ
    Double llctm_05 = Double.parseDouble(dtcm(is.read_IS(company,22,2005)));
    Double llctm_06 = Double.parseDouble(dtcm(is.read_IS(company,22,2006)));
    Double llctm_07 = Double.parseDouble(dtcm(is.read_IS(company,22,2007)));
    Double llctm_08 = Double.parseDouble(dtcm(is.read_IS(company,22,2008)));
    Double llctm_09 = Double.parseDouble(dtcm(is.read_IS(company,22,2009)));
    Double llctm_10 = Double.parseDouble(dtcm(is.read_IS(company,22,2010)));
    Double llctm_11 = Double.parseDouble(dtcm(is.read_IS(company,22,2011)));
    Double llctm_12 = Double.parseDouble(dtcm(is.read_IS(company,22,2012)));
    Double llctm_13 = Double.parseDouble(dtcm(is.read_IS(company,22,2013)));
    
    // Chi phí khấu hao tài sản cố định
    Double cpkhtscd_05 = Double.parseDouble(dtcm(is.read_IS(company,22,2005)));
    Double cpkhtscd_06 = Double.parseDouble(dtcm(is.read_IS(company,22,2006)));
    Double cpkhtscd_07 = Double.parseDouble(dtcm(is.read_IS(company,22,2007)));
    Double cpkhtscd_08 = Double.parseDouble(dtcm(is.read_IS(company,22,2008)));
    Double cpkhtscd_09 = Double.parseDouble(dtcm(is.read_IS(company,22,2009)));
    Double cpkhtscd_10 = Double.parseDouble(dtcm(is.read_IS(company,22,2010)));
    Double cpkhtscd_11 = Double.parseDouble(dtcm(is.read_IS(company,22,2011)));
    Double cpkhtscd_12 = Double.parseDouble(dtcm(is.read_IS(company,22,2012)));
    Double cpkhtscd_13 = Double.parseDouble(dtcm(is.read_IS(company,22,2013)));
    
    // EBITDA
    Double ebitda_05 = Double.parseDouble(dtcm(is.read_IS(company,24,2005)));
    Double ebitda_06 = Double.parseDouble(dtcm(is.read_IS(company,24,2006)));
    Double ebitda_07 = Double.parseDouble(dtcm(is.read_IS(company,24,2007)));
    Double ebitda_08 = Double.parseDouble(dtcm(is.read_IS(company,24,2008)));
    Double ebitda_09 = Double.parseDouble(dtcm(is.read_IS(company,24,2009)));
    Double ebitda_10 = Double.parseDouble(dtcm(is.read_IS(company,24,2010)));
    Double ebitda_11 = Double.parseDouble(dtcm(is.read_IS(company,24,2011)));
    Double ebitda_12 = Double.parseDouble(dtcm(is.read_IS(company,24,2012)));
    Double ebitda_13 = Double.parseDouble(dtcm(is.read_IS(company,24,2013)));
    
    //EBIT
    Double ebit_05 = ebitda_05 - Double.parseDouble(dtcm(is.read_IS(company,23,2005)));
    Double ebit_06 = ebitda_06 - Double.parseDouble(dtcm(is.read_IS(company,23,2006)));
    Double ebit_07 = ebitda_07 - Double.parseDouble(dtcm(is.read_IS(company,23,2007)));
    Double ebit_08 = ebitda_08 - Double.parseDouble(dtcm(is.read_IS(company,23,2008)));
    Double ebit_09 = ebitda_09 - Double.parseDouble(dtcm(is.read_IS(company,23,2009)));
    Double ebit_10 = ebitda_10 - Double.parseDouble(dtcm(is.read_IS(company,23,2010)));
    Double ebit_11 = ebitda_11 - Double.parseDouble(dtcm(is.read_IS(company,23,2011)));
    Double ebit_12 = ebitda_12 - Double.parseDouble(dtcm(is.read_IS(company,23,2012)));
    Double ebit_13 = ebitda_13 - Double.parseDouble(dtcm(is.read_IS(company,23,2013)));
    
    
    
    
    
    //Chi phí bán hàng + quản lý doanh nghiệp
    Double cpbhcpqldn_05 = cpbh_05 + cpqldn_05;
    Double cpbhcpqldn_06 = cpbh_06 + cpqldn_06;
    Double cpbhcpqldn_07 = cpbh_07 + cpqldn_07;
    Double cpbhcpqldn_08 = cpbh_08 + cpqldn_08;
    Double cpbhcpqldn_09 = cpbh_09 + cpqldn_09;
    Double cpbhcpqldn_10 = cpbh_10 + cpqldn_10;
    Double cpbhcpqldn_11 = cpbh_11 + cpqldn_11;
    Double cpbhcpqldn_12 = cpbh_12 + cpqldn_12;
    Double cpbhcpqldn_13 = cpbh_13 + cpqldn_13;
    
    p1 = conn.prepareStatement("INSERT INTO `"+company+"_IS` (`clause`, `2013`, `2012`, `2011`, `2010`, `2009`, `2008`, `2007`, `2006`, `2005`) VALUES(N?,?,?,?,?,?,?,?,?,?);");
    p2 = conn.prepareStatement("INSERT INTO `"+company+"_FINA` (`clause`, `2013`, `2012`, `2011`, `2010`, `2009`, `2008`, `2007`, `2006`, `2005`) VALUES(N?,?,?,?,?,?,?,?,?,?);");
    p_percent = conn.prepareStatement("INSERT INTO `"+company+"_%FINA` (`clause`, `2013`, `2012`, `2011`, `2010`, `2009`,`2008`,`2007`,`2006`,`2005`) VALUES(N?,?,?,?,?,?,?,?,?,?);");
    
    //Import data
    linenumber = 6;
    while (linenumber < 26 && linenumber > 5) {
        if (linenumber == 25) {//EBIT
            clause = "EBIT";
            data_05 = dtcm(doubletostring(2,ebit_05));
            data_06 = dtcm(doubletostring(2,ebit_06));
            data_07 = dtcm(doubletostring(2,ebit_07));
            data_08 = dtcm(doubletostring(2,ebit_08));
            data_09 = dtcm(doubletostring(2,ebit_09));
            data_10 = dtcm(doubletostring(2,ebit_10));
            data_11 = dtcm(doubletostring(2,ebit_11));
            data_12 = dtcm(doubletostring(2,ebit_12));
            data_13 = dtcm(doubletostring(2,ebit_13)); 
        add_data2(conn,p1,company,"_IS",clause,data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_data2(conn,p2,company,"_FINA",clause,data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_percent_change(conn,p_percent,company,"_%FINA",clause,data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        } else {
            clause = is.read_IS(company,linenumber,999);
            data_05 = dtcm(is.read_IS(company, linenumber, 2005));
            data_06 = dtcm(is.read_IS(company, linenumber, 2006));
            data_07 = dtcm(is.read_IS(company, linenumber, 2007));
            data_08 = dtcm(is.read_IS(company, linenumber, 2008));
            data_09 = dtcm(is.read_IS(company, linenumber, 2009));
            data_10 = dtcm(is.read_IS(company, linenumber, 2010));
            data_11 = dtcm(is.read_IS(company, linenumber, 2011));
            data_12 = dtcm(is.read_IS(company, linenumber, 2012));
            data_13 = dtcm(is.read_IS(company, linenumber, 2013));
        add_data2(conn,p1,company,"_IS",clause,data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_data2(conn,p2,company,"_FINA",clause,data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_percent_change(conn,p_percent,company,"_%FINA",clause,data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
                }
        linenumber = linenumber+1;
    }
    
    p1.executeBatch();
    ////////////////////// MULTIPLE /////////////////////
        //Earning per share
        Double eps_05 = llctm_05*1000000/sn_05;
        Double eps_06 = llctm_06*1000000/sn_06;
        Double eps_07 = llctm_07*1000000/sn_07;
        Double eps_08 = llctm_08*1000000/sn_08;
        Double eps_09 = llctm_09*1000000/sn_09;
        Double eps_10 = llctm_10*1000000/sn_10;
        Double eps_11 = llctm_11*1000000/sn_11;
        Double eps_12 = llctm_12*1000000/sn_12;
        Double eps_13 = llctm_13*1000000/sn_13;
        
    add_data2(conn,p2,company,"_FINA","Earning Per Share",doubletostring(2,eps_13),doubletostring(2,eps_12),doubletostring(2,eps_11),doubletostring(2,eps_10),doubletostring(2,eps_09),
            doubletostring(2,eps_08),doubletostring(2,eps_07),doubletostring(2,eps_06),doubletostring(2,eps_05));
    add_data2(conn,p2,company,"_FINA","Dividend Per Share",doubletostring(2,ct_13),doubletostring(2,ct_12),doubletostring(2,ct_11),doubletostring(2,ct_10),doubletostring(2,ct_09),
            doubletostring(2,ct_08),doubletostring(2,ct_07),doubletostring(2,ct_06),doubletostring(2,ct_05));
    
    add_data2(conn,p2,company,"_FINA","","","","","","","","","","");
    add_data(conn,prestatement,company,"_%FINA","","","","","","","","","","");
    add_data2(conn,p2,company,"_FINA","BALANCE SHEET","","","","","","","","","");
    add_data(conn,prestatement,company,"_%FINA","BALANCE SHEET","","","","","","","","","");
    ///////////////////////////// BS
     add_company(conn,prestatement,company,"_BS");
    
    
    // Tài sản ngắn hạn
    Double tsnh_05 = Double.parseDouble(dtcm(bs.read_BS(company,5,2005)));
    Double tsnh_06 = Double.parseDouble(dtcm(bs.read_BS(company,5,2006)));
    Double tsnh_07 = Double.parseDouble(dtcm(bs.read_BS(company,5,2007)));
    Double tsnh_08 = Double.parseDouble(dtcm(bs.read_BS(company,5,2008)));
    Double tsnh_09 = Double.parseDouble(dtcm(bs.read_BS(company,5,2009)));
    Double tsnh_10 = Double.parseDouble(dtcm(bs.read_BS(company,5,2010)));
    Double tsnh_11 = Double.parseDouble(dtcm(bs.read_BS(company,5,2011)));
    Double tsnh_12 = Double.parseDouble(dtcm(bs.read_BS(company,5,2012)));
    Double tsnh_13 = Double.parseDouble(dtcm(bs.read_BS(company,5,2013)));
    // Tiền và tương đương tiền
    Double tvtdt_05 = Double.parseDouble(dtcm(bs.read_BS(company,6,2005)));
    Double tvtdt_06 = Double.parseDouble(dtcm(bs.read_BS(company,6,2006)));
    Double tvtdt_07 = Double.parseDouble(dtcm(bs.read_BS(company,6,2007)));
    Double tvtdt_08 = Double.parseDouble(dtcm(bs.read_BS(company,6,2008)));
    Double tvtdt_09 = Double.parseDouble(dtcm(bs.read_BS(company,6,2009)));
    Double tvtdt_10 = Double.parseDouble(dtcm(bs.read_BS(company,6,2010)));
    Double tvtdt_11 = Double.parseDouble(dtcm(bs.read_BS(company,6,2011)));
    Double tvtdt_12 = Double.parseDouble(dtcm(bs.read_BS(company,6,2012)));
    Double tvtdt_13 = Double.parseDouble(dtcm(bs.read_BS(company,6,2013)));
    // Giá trị đầu tư ngắn hạn
    Double gtdtnh_05 = Double.parseDouble(dtcm(bs.read_BS(company,7,2005)));
    Double gtdtnh_06 = Double.parseDouble(dtcm(bs.read_BS(company,7,2006)));
    Double gtdtnh_07 = Double.parseDouble(dtcm(bs.read_BS(company,7,2007)));
    Double gtdtnh_08 = Double.parseDouble(dtcm(bs.read_BS(company,7,2008)));
    Double gtdtnh_09 = Double.parseDouble(dtcm(bs.read_BS(company,7,2009)));
    Double gtdtnh_10 = Double.parseDouble(dtcm(bs.read_BS(company,7,2010)));
    Double gtdtnh_11 = Double.parseDouble(dtcm(bs.read_BS(company,7,2011)));
    Double gtdtnh_12 = Double.parseDouble(dtcm(bs.read_BS(company,7,2012)));
    Double gtdtnh_13 = Double.parseDouble(dtcm(bs.read_BS(company,7,2013)));
       
    //Hàng tồn kho
    Double htk_05 = Double.parseDouble(dtcm(bs.read_BS(company,10,2005)));
    Double htk_06 = Double.parseDouble(dtcm(bs.read_BS(company,10,2006)));
    Double htk_07 = Double.parseDouble(dtcm(bs.read_BS(company,10,2007)));
    Double htk_08 = Double.parseDouble(dtcm(bs.read_BS(company,10,2008)));
    Double htk_09 = Double.parseDouble(dtcm(bs.read_BS(company,10,2009)));
    Double htk_10 = Double.parseDouble(dtcm(bs.read_BS(company,10,2010)));
    Double htk_11 = Double.parseDouble(dtcm(bs.read_BS(company,10,2011)));
    Double htk_12 = Double.parseDouble(dtcm(bs.read_BS(company,10,2012)));
    Double htk_13 = Double.parseDouble(dtcm(bs.read_BS(company,10,2013)));
    
    //Tài sản lưu động khác
    Double tsldk_05 = Double.parseDouble(dtcm(bs.read_BS(company,11,2005)));
    Double tsldk_06 = Double.parseDouble(dtcm(bs.read_BS(company,11,2006)));
    Double tsldk_07 = Double.parseDouble(dtcm(bs.read_BS(company,11,2007)));
    Double tsldk_08 = Double.parseDouble(dtcm(bs.read_BS(company,11,2008)));
    Double tsldk_09 = Double.parseDouble(dtcm(bs.read_BS(company,11,2009)));
    Double tsldk_10 = Double.parseDouble(dtcm(bs.read_BS(company,11,2010)));
    Double tsldk_11 = Double.parseDouble(dtcm(bs.read_BS(company,11,2011)));
    Double tsldk_12 = Double.parseDouble(dtcm(bs.read_BS(company,11,2012)));
    Double tsldk_13 = Double.parseDouble(dtcm(bs.read_BS(company,11,2013)));
    
   //Các khoản phải thu
    Double ckpt_05 = tsnh_05 - tvtdt_05 - gtdtnh_05 - tsldk_05 - htk_05; 
    Double ckpt_06 = tsnh_06 - tvtdt_06 - gtdtnh_06 - tsldk_06 - htk_06; 
    Double ckpt_07 = tsnh_07 - tvtdt_07 - gtdtnh_07 - tsldk_07 - htk_07; 
    Double ckpt_08 = tsnh_08 - tvtdt_08 - gtdtnh_08 - tsldk_08 - htk_08; 
    Double ckpt_09 = tsnh_09 - tvtdt_09 - gtdtnh_09 - tsldk_09 - htk_09; 
    Double ckpt_10 = tsnh_10 - tvtdt_10 - gtdtnh_10 - tsldk_10 - htk_10; 
    Double ckpt_11 = tsnh_11 - tvtdt_11 - gtdtnh_11 - tsldk_11 - htk_11; 
    Double ckpt_12 = tsnh_12 - tvtdt_12 - gtdtnh_12 - tsldk_12 - htk_12; 
    Double ckpt_13 = tsnh_13 - tvtdt_13 - gtdtnh_13 - tsldk_13 - htk_13; 
    
    //Tài sản dài hạn
    Double tsdh_05 = Double.parseDouble(dtcm(bs.read_BS(company,12,2005)));
    Double tsdh_06 = Double.parseDouble(dtcm(bs.read_BS(company,12,2006)));
    Double tsdh_07 = Double.parseDouble(dtcm(bs.read_BS(company,12,2007)));
    Double tsdh_08 = Double.parseDouble(dtcm(bs.read_BS(company,12,2008)));
    Double tsdh_09 = Double.parseDouble(dtcm(bs.read_BS(company,12,2009)));
    Double tsdh_10 = Double.parseDouble(dtcm(bs.read_BS(company,12,2010)));
    Double tsdh_11 = Double.parseDouble(dtcm(bs.read_BS(company,12,2011)));
    Double tsdh_12 = Double.parseDouble(dtcm(bs.read_BS(company,12,2012)));
    Double tsdh_13 = Double.parseDouble(dtcm(bs.read_BS(company,12,2013)));
    
    //Phải thu dài hạn khác
    Double ptdhk_05 = Double.parseDouble(dtcm(bs.read_BS(company,13,2005)));
    Double ptdhk_06 = Double.parseDouble(dtcm(bs.read_BS(company,13,2006)));
    Double ptdhk_07 = Double.parseDouble(dtcm(bs.read_BS(company,13,2007)));
    Double ptdhk_08 = Double.parseDouble(dtcm(bs.read_BS(company,13,2008)));
    Double ptdhk_09 = Double.parseDouble(dtcm(bs.read_BS(company,13,2009)));
    Double ptdhk_10 = Double.parseDouble(dtcm(bs.read_BS(company,13,2010)));
    Double ptdhk_11 = Double.parseDouble(dtcm(bs.read_BS(company,13,2011)));
    Double ptdhk_12 = Double.parseDouble(dtcm(bs.read_BS(company,13,2012)));
    Double ptdhk_13 = Double.parseDouble(dtcm(bs.read_BS(company,13,2013)));
    
    //Tài sản cố định
    Double tscd_05 = Double.parseDouble(dtcm(bs.read_BS(company,15,2005)));
    Double tscd_06 = Double.parseDouble(dtcm(bs.read_BS(company,15,2006)));
    Double tscd_07 = Double.parseDouble(dtcm(bs.read_BS(company,15,2007)));
    Double tscd_08 = Double.parseDouble(dtcm(bs.read_BS(company,15,2008)));
    Double tscd_09 = Double.parseDouble(dtcm(bs.read_BS(company,15,2009)));
    Double tscd_10 = Double.parseDouble(dtcm(bs.read_BS(company,15,2010)));
    Double tscd_11 = Double.parseDouble(dtcm(bs.read_BS(company,15,2011)));
    Double tscd_12 = Double.parseDouble(dtcm(bs.read_BS(company,15,2012)));
    Double tscd_13 = Double.parseDouble(dtcm(bs.read_BS(company,15,2013)));
    
    //Giá trị ròng tài sản đầu tư
    Double gtrtsdt_05 = Double.parseDouble(dtcm(bs.read_BS(company,16,2005)));
    Double gtrtsdt_06 = Double.parseDouble(dtcm(bs.read_BS(company,16,2006)));
    Double gtrtsdt_07 = Double.parseDouble(dtcm(bs.read_BS(company,16,2007)));
    Double gtrtsdt_08 = Double.parseDouble(dtcm(bs.read_BS(company,16,2008)));
    Double gtrtsdt_09 = Double.parseDouble(dtcm(bs.read_BS(company,16,2009)));
    Double gtrtsdt_10 = Double.parseDouble(dtcm(bs.read_BS(company,16,2010)));
    Double gtrtsdt_11 = Double.parseDouble(dtcm(bs.read_BS(company,16,2011)));
    Double gtrtsdt_12 = Double.parseDouble(dtcm(bs.read_BS(company,16,2012)));
    Double gtrtsdt_13 = Double.parseDouble(dtcm(bs.read_BS(company,16,2013)));
    
    //Đầu tư dài hạn
    Double dtdh_05 = Double.parseDouble(dtcm(bs.read_BS(company,17,2005)));
    Double dtdh_06 = Double.parseDouble(dtcm(bs.read_BS(company,17,2006)));
    Double dtdh_07 = Double.parseDouble(dtcm(bs.read_BS(company,17,2007)));
    Double dtdh_08 = Double.parseDouble(dtcm(bs.read_BS(company,17,2008)));
    Double dtdh_09 = Double.parseDouble(dtcm(bs.read_BS(company,17,2009)));
    Double dtdh_10 = Double.parseDouble(dtcm(bs.read_BS(company,17,2010)));
    Double dtdh_11 = Double.parseDouble(dtcm(bs.read_BS(company,17,2011)));
    Double dtdh_12 = Double.parseDouble(dtcm(bs.read_BS(company,17,2012)));
    Double dtdh_13 = Double.parseDouble(dtcm(bs.read_BS(company,17,2013)));
    
    //Lợi thế thương mại
    Double lttm_05 = Double.parseDouble(dtcm(bs.read_BS(company,18,2005)));
    Double lttm_06 = Double.parseDouble(dtcm(bs.read_BS(company,18,2006)));
    Double lttm_07 = Double.parseDouble(dtcm(bs.read_BS(company,18,2007)));
    Double lttm_08 = Double.parseDouble(dtcm(bs.read_BS(company,18,2008)));
    Double lttm_09 = Double.parseDouble(dtcm(bs.read_BS(company,18,2009)));
    Double lttm_10 = Double.parseDouble(dtcm(bs.read_BS(company,18,2010)));
    Double lttm_11 = Double.parseDouble(dtcm(bs.read_BS(company,18,2011)));
    Double lttm_12 = Double.parseDouble(dtcm(bs.read_BS(company,18,2012)));
    Double lttm_13 = Double.parseDouble(dtcm(bs.read_BS(company,18,2013)));
    
    
    //Tổng tài sản
    Double tts_05 = Double.parseDouble(dtcm(bs.read_BS(company,19,2005)));
    Double tts_06 = Double.parseDouble(dtcm(bs.read_BS(company,19,2006)));
    Double tts_07 = Double.parseDouble(dtcm(bs.read_BS(company,19,2007)));
    Double tts_08 = Double.parseDouble(dtcm(bs.read_BS(company,19,2008)));
    Double tts_09 = Double.parseDouble(dtcm(bs.read_BS(company,19,2009)));
    Double tts_10 = Double.parseDouble(dtcm(bs.read_BS(company,19,2010)));
    Double tts_11 = Double.parseDouble(dtcm(bs.read_BS(company,19,2011)));
    Double tts_12 = Double.parseDouble(dtcm(bs.read_BS(company,19,2012)));
    Double tts_13 = Double.parseDouble(dtcm(bs.read_BS(company,19,2013)));
    
     //Tài sản dài hạn khác
    Double tsdhk_05 = tts_05 - ptdhk_05 - tscd_05 - gtrtsdt_05 - dtdh_05 - lttm_05;
    Double tsdhk_06 = tts_06 - ptdhk_06 - tscd_06 - gtrtsdt_06 - dtdh_06 - lttm_06;
    Double tsdhk_07 = tts_07 - ptdhk_07 - tscd_07 - gtrtsdt_07 - dtdh_07 - lttm_07;
    Double tsdhk_08 = tts_08 - ptdhk_08 - tscd_08 - gtrtsdt_08 - dtdh_08 - lttm_08;
    Double tsdhk_09 = tts_09 - ptdhk_09 - tscd_09 - gtrtsdt_09 - dtdh_09 - lttm_09;
    Double tsdhk_10 = tts_10 - ptdhk_10 - tscd_10 - gtrtsdt_10 - dtdh_10 - lttm_10;
    Double tsdhk_11 = tts_11 - ptdhk_11 - tscd_11 - gtrtsdt_11 - dtdh_11 - lttm_11;
    Double tsdhk_12 = tts_12 - ptdhk_12 - tscd_12 - gtrtsdt_12 - dtdh_12 - lttm_12;
    Double tsdhk_13 = tts_13 - ptdhk_13 - tscd_13 - gtrtsdt_13 - dtdh_13 - lttm_13;
    
    //Tổng nợ/nợ phải trả
    Double tn_05 = Double.parseDouble(dtcm(bs.read_BS(company,21,2005)));
    Double tn_06 = Double.parseDouble(dtcm(bs.read_BS(company,21,2006)));
    Double tn_07 = Double.parseDouble(dtcm(bs.read_BS(company,21,2007)));
    Double tn_08 = Double.parseDouble(dtcm(bs.read_BS(company,21,2008)));
    Double tn_09 = Double.parseDouble(dtcm(bs.read_BS(company,21,2009)));
    Double tn_10 = Double.parseDouble(dtcm(bs.read_BS(company,21,2010)));
    Double tn_11 = Double.parseDouble(dtcm(bs.read_BS(company,21,2011)));
    Double tn_12 = Double.parseDouble(dtcm(bs.read_BS(company,21,2012)));
    Double tn_13 = Double.parseDouble(dtcm(bs.read_BS(company,21,2013)));
    
    //Nợ ngắn hạn
    Double nnh_05 = Double.parseDouble(dtcm(bs.read_BS(company,22,2005)));
    Double nnh_06 = Double.parseDouble(dtcm(bs.read_BS(company,22,2006)));
    Double nnh_07 = Double.parseDouble(dtcm(bs.read_BS(company,22,2007)));
    Double nnh_08 = Double.parseDouble(dtcm(bs.read_BS(company,22,2008)));
    Double nnh_09 = Double.parseDouble(dtcm(bs.read_BS(company,22,2009)));
    Double nnh_10 = Double.parseDouble(dtcm(bs.read_BS(company,22,2010)));
    Double nnh_11 = Double.parseDouble(dtcm(bs.read_BS(company,22,2011)));
    Double nnh_12 = Double.parseDouble(dtcm(bs.read_BS(company,22,2012)));
    Double nnh_13 = Double.parseDouble(dtcm(bs.read_BS(company,22,2013)));
    
    //Nợ dài hạn
    Double ndh_05 = Double.parseDouble(dtcm(bs.read_BS(company,23,2005)));
    Double ndh_06 = Double.parseDouble(dtcm(bs.read_BS(company,23,2006)));
    Double ndh_07 = Double.parseDouble(dtcm(bs.read_BS(company,23,2007)));
    Double ndh_08 = Double.parseDouble(dtcm(bs.read_BS(company,23,2008)));
    Double ndh_09 = Double.parseDouble(dtcm(bs.read_BS(company,23,2009)));
    Double ndh_10 = Double.parseDouble(dtcm(bs.read_BS(company,23,2010)));
    Double ndh_11 = Double.parseDouble(dtcm(bs.read_BS(company,23,2011)));
    Double ndh_12 = Double.parseDouble(dtcm(bs.read_BS(company,23,2012)));
    Double ndh_13 = Double.parseDouble(dtcm(bs.read_BS(company,23,2013)));
    
   //Vốn chủ sở hữu
    Double vcsh_05 = Double.parseDouble(dtcm(bs.read_BS(company,24,2005)));
    Double vcsh_06 = Double.parseDouble(dtcm(bs.read_BS(company,24,2006)));
    Double vcsh_07 = Double.parseDouble(dtcm(bs.read_BS(company,24,2007)));
    Double vcsh_08 = Double.parseDouble(dtcm(bs.read_BS(company,24,2008)));
    Double vcsh_09 = Double.parseDouble(dtcm(bs.read_BS(company,24,2009)));
    Double vcsh_10 = Double.parseDouble(dtcm(bs.read_BS(company,24,2010)));
    Double vcsh_11 = Double.parseDouble(dtcm(bs.read_BS(company,24,2011)));
    Double vcsh_12 = Double.parseDouble(dtcm(bs.read_BS(company,24,2012)));
    Double vcsh_13 = Double.parseDouble(dtcm(bs.read_BS(company,24,2013)));
    
    //Vốn và các quĩ
    Double vvcq_05 = Double.parseDouble(dtcm(bs.read_BS(company,25,2005)));
    Double vvcq_06 = Double.parseDouble(dtcm(bs.read_BS(company,25,2006)));
    Double vvcq_07 = Double.parseDouble(dtcm(bs.read_BS(company,25,2007)));
    Double vvcq_08 = Double.parseDouble(dtcm(bs.read_BS(company,25,2008)));
    Double vvcq_09 = Double.parseDouble(dtcm(bs.read_BS(company,25,2009)));
    Double vvcq_10 = Double.parseDouble(dtcm(bs.read_BS(company,25,2010)));
    Double vvcq_11 = Double.parseDouble(dtcm(bs.read_BS(company,25,2011)));
    Double vvcq_12 = Double.parseDouble(dtcm(bs.read_BS(company,25,2012)));
    Double vvcq_13 = Double.parseDouble(dtcm(bs.read_BS(company,25,2013)));
    
    // Lãi chưa phân phối
    Double lcpp_05 = Double.parseDouble(dtcm(bs.read_BS(company,28,2005)));
    Double lcpp_06 = Double.parseDouble(dtcm(bs.read_BS(company,28,2006)));
    Double lcpp_07 = Double.parseDouble(dtcm(bs.read_BS(company,28,2007)));
    Double lcpp_08 = Double.parseDouble(dtcm(bs.read_BS(company,28,2008)));
    Double lcpp_09 = Double.parseDouble(dtcm(bs.read_BS(company,28,2009)));
    Double lcpp_10 = Double.parseDouble(dtcm(bs.read_BS(company,28,2010)));
    Double lcpp_11 = Double.parseDouble(dtcm(bs.read_BS(company,28,2011)));
    Double lcpp_12 = Double.parseDouble(dtcm(bs.read_BS(company,28,2012)));
    Double lcpp_13 = Double.parseDouble(dtcm(bs.read_BS(company,28,2013)));
    
    
    //MULTIPLES
    // Book value per share
        Double bvps_05 = vcsh_05*1000000/sn_05;
        Double bvps_06 = vcsh_06*1000000/sn_06;
        Double bvps_07 = vcsh_07*1000000/sn_07;
        Double bvps_08 = vcsh_08*1000000/sn_08;
        Double bvps_09 = vcsh_09*1000000/sn_09;
        Double bvps_10 = vcsh_10*1000000/sn_10;
        Double bvps_11 = vcsh_11*1000000/sn_11;
        Double bvps_12 = vcsh_12*1000000/sn_12;
        Double bvps_13 = vcsh_13*1000000/sn_13;
    
         //Enterprise value
    
    Double ev_05 = cp05*1000*sn_05;
    
    Double ev_06 = cp06*1000*sn_06;
    
    Double ev_07 = cp07*1000*sn_07;
    
    Double ev_08 = cp08*1000*sn_08;
    
    Double ev_09 = cp09*1000*sn_09;
    
    Double ev_10 = cp10*1000*sn_10;
    
    Double ev_11 = cp11*1000*sn_11;
    
    Double ev_12 = cp12*1000*sn_12;
    
    Double ev_13 = cp13*1000*sn_13;
   p1 = conn.prepareStatement("INSERT INTO `"+company+"_BS` (`clause`, `2013`, `2012`, `2011`, `2010`, `2009`, `2008`, `2007`, `2006`, `2005`) VALUES(N?,?,?,?,?,?,?,?,?,?);");
    
    //Import data
     linenumber = 5;
    while (linenumber < 30 && linenumber > 4) {
        if (linenumber == 29) {
            data_05 = dtcm(bs.read_BS(company, 19, 2005));
            data_06 = dtcm(bs.read_BS(company, 19, 2006));
            data_07 = dtcm(bs.read_BS(company, 19, 2007));
            data_08 = dtcm(bs.read_BS(company, 19, 2008));
            data_09 = dtcm(bs.read_BS(company, 19, 2009));
            data_10 = dtcm(bs.read_BS(company, 19, 2010));
            data_11 = dtcm(bs.read_BS(company, 19, 2011));
            data_12 = dtcm(bs.read_BS(company, 19, 2012));
            data_13 = dtcm(bs.read_BS(company, 19, 2013));
        add_data2(conn,p1,company,"_BS",bs.read_BS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_data2(conn,p2,company,"_FINA",bs.read_BS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_percent_change(conn,p_percent,company,"_%FINA",bs.read_BS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
                } else if (linenumber > 19) {
            data_05 = dtcm(bs.read_BS(company, linenumber+1, 2005));
            data_06 = dtcm(bs.read_BS(company, linenumber+1, 2006));
            data_07 = dtcm(bs.read_BS(company, linenumber+1, 2007));
            data_08 = dtcm(bs.read_BS(company, linenumber+1, 2008));
            data_09 = dtcm(bs.read_BS(company, linenumber+1, 2009));
            data_10 = dtcm(bs.read_BS(company, linenumber+1, 2010));
            data_11 = dtcm(bs.read_BS(company, linenumber+1, 2011));
            data_12 = dtcm(bs.read_BS(company, linenumber+1, 2012));
            data_13 = dtcm(bs.read_BS(company, linenumber+1, 2013));
        add_data2(conn,p1,company,"_BS",bs.read_BS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_data2(conn,p2,company,"_FINA",bs.read_BS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_percent_change(conn,p_percent,company,"_%FINA",bs.read_BS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
                } else if(linenumber == 19) {
            data_05 = dtcm(bs.read_BS(company, linenumber, 2005));
            data_06 = dtcm(bs.read_BS(company, linenumber, 2006));
            data_07 = dtcm(bs.read_BS(company, linenumber, 2007));
            data_08 = dtcm(bs.read_BS(company, linenumber, 2008));
            data_09 = dtcm(bs.read_BS(company, linenumber, 2009));
            data_10 = dtcm(bs.read_BS(company, linenumber, 2010));
            data_11 = dtcm(bs.read_BS(company, linenumber, 2011));
            data_12 = dtcm(bs.read_BS(company, linenumber, 2012));
            data_13 = dtcm(bs.read_BS(company, linenumber, 2013));
        add_data2(conn,p1,company,"_BS",bs.read_BS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_data2(conn,p2,company,"_FINA",bs.read_BS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_percent_change(conn,p_percent,company,"_%FINA",bs.read_BS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
                } else if(linenumber == 18) {
            
        add_data(conn,p1,company,"_BS",bs.read_BS(company, linenumber, 999),doubletostring(2,tsdhk_13),doubletostring(2,tsdhk_12),doubletostring(2,tsdhk_11),doubletostring(2,tsdhk_10),
                doubletostring(2,tsdhk_09),doubletostring(2,tsdhk_08),doubletostring(2,tsdhk_07),doubletostring(2,tsdhk_06),doubletostring(2,tsdhk_05));
       add_data(conn,p2,company,"_FINA",bs.read_BS(company, linenumber, 999),doubletostring(2,tsdhk_13),doubletostring(2,tsdhk_12),doubletostring(2,tsdhk_11),doubletostring(2,tsdhk_10),
                doubletostring(2,tsdhk_09),doubletostring(2,tsdhk_08),doubletostring(2,tsdhk_07),doubletostring(2,tsdhk_06),doubletostring(2,tsdhk_05));
        add_percent_change(conn,p_percent,company,"_%FINA",bs.read_BS(company, linenumber, 999),doubletostring(2,tsdhk_13),doubletostring(2,tsdhk_12),doubletostring(2,tsdhk_11),doubletostring(2,tsdhk_10),
                doubletostring(2,tsdhk_09),doubletostring(2,tsdhk_08),doubletostring(2,tsdhk_07),doubletostring(2,tsdhk_06),doubletostring(2,tsdhk_05));
                } else if (linenumber == 8) {
            
        add_data2(conn,p1,company,"_BS","Các khoản phải thu",doubletostring(2,ckpt_13),doubletostring(2,ckpt_12),doubletostring(2,ckpt_11),doubletostring(2,ckpt_10),doubletostring(2,ckpt_09),
                doubletostring(2,ckpt_08),doubletostring(2,ckpt_07),doubletostring(2,ckpt_06),doubletostring(2,ckpt_05));    
        add_data2(conn,p2,company,"_FINA","Các khoản phải thu",doubletostring(2,ckpt_13),doubletostring(2,ckpt_12),doubletostring(2,ckpt_11),doubletostring(2,ckpt_10),doubletostring(2,ckpt_09),
                doubletostring(2,ckpt_08),doubletostring(2,ckpt_07),doubletostring(2,ckpt_06),doubletostring(2,ckpt_05));    
        add_percent_change(conn,p_percent,company,"_%FINA","Các khoản phải thu",doubletostring(2,ckpt_13),doubletostring(2,ckpt_12),doubletostring(2,ckpt_11),doubletostring(2,ckpt_10),doubletostring(2,ckpt_09),
                doubletostring(2,ckpt_08),doubletostring(2,ckpt_07),doubletostring(2,ckpt_06),doubletostring(2,ckpt_05));    
                }
                    if (linenumber > 8 && linenumber < 18) {
            data_05 = dtcm(bs.read_BS(company, linenumber+1, 2005));
            data_06 = dtcm(bs.read_BS(company, linenumber+1, 2006));
            data_07 = dtcm(bs.read_BS(company, linenumber+1, 2007));
            data_08 = dtcm(bs.read_BS(company, linenumber+1, 2008));
            data_09 = dtcm(bs.read_BS(company, linenumber+1, 2009));
            data_10 = dtcm(bs.read_BS(company, linenumber+1, 2010));
            data_11 = dtcm(bs.read_BS(company, linenumber+1, 2011));
            data_12 = dtcm(bs.read_BS(company, linenumber+1, 2012));
            data_13 = dtcm(bs.read_BS(company, linenumber+1, 2013));
        add_data2(conn,p1,company,"_BS",bs.read_BS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_data2(conn,p2,company,"_FINA",bs.read_BS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
                }
        linenumber = linenumber+1;
    }
    
    p1.executeBatch();
    add_data2(conn,p2,company,"_FINA","Enterprise Value",doubletostring(2,ev_13),doubletostring(2,ev_12),doubletostring(2,ev_11),doubletostring(2,ev_10),doubletostring(2,ev_09),
            doubletostring(2,ev_08),doubletostring(2,ev_07),doubletostring(2,ev_06),doubletostring(2,ev_05));    
        
    add_data2(conn,p2,company,"_FINA","Book Value Per Share",doubletostring(2,bvps_13),doubletostring(2,bvps_12),doubletostring(2,bvps_11),doubletostring(2,bvps_10),doubletostring(2,bvps_09),
            doubletostring(2,bvps_08),doubletostring(2,bvps_07),doubletostring(2,bvps_06),doubletostring(2,bvps_05));
    
    add_data2(conn,p2,company,"_FINA","","","","","","","","","","");
    add_data(conn,prestatement,company,"_%FINA","","","","","","","","","","");
    add_data2(conn,p2,company,"_FINA","CASHFLOW STATEMENT","","","","","","","","","");
    add_data(conn,prestatement,company,"_%FINA","CASHFLOW STATEMENT","","","","","","","","","");
    
    ////////////////////////////CFS 
    add_company(conn,prestatement,company,"_CFS");
    p1 = conn.prepareStatement("INSERT INTO `"+company+"_IS` (`clause`, `2013`, `2012`, `2011`, `2010`, `2009`, `2008`, `2007`, `2006`, `2005`) VALUES(N?,?,?,?,?,?,?,?,?,?);");
    
    //Import data
    linenumber = 0;
    while (linenumber < 44) {
        if (linenumber > 5) {
            data_05 = dtcm(cfs.read_CFS(company, linenumber, 2005));
            data_06 = dtcm(cfs.read_CFS(company, linenumber, 2006));
            data_07 = dtcm(cfs.read_CFS(company, linenumber, 2007));
            data_08 = dtcm(cfs.read_CFS(company, linenumber, 2008));
            data_09 = dtcm(cfs.read_CFS(company, linenumber, 2009));
            data_10 = dtcm(cfs.read_CFS(company, linenumber, 2010));
            data_11 = dtcm(cfs.read_CFS(company, linenumber, 2011));
            data_12 = dtcm(cfs.read_CFS(company, linenumber, 2012));
            data_13 = dtcm(cfs.read_CFS(company, linenumber, 2013));
        add_data(conn,p1,company,"_CFS",cfs.read_CFS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_data(conn,p2,company,"_FINA",cfs.read_CFS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
        add_percent_change(conn,p_percent,company,"_%FINA",cfs.read_CFS(company, linenumber, 999),data_13,data_12,data_11,data_10,data_09,data_08,data_07,data_06,data_05);
                }
        linenumber = linenumber+1;
    }
    
      p1.executeBatch();
    //Khấu hao TSCĐ
    Double khtscd_05 = Double.parseDouble(dtcm(cfs.read_CFS(company,6,2005)));
    Double khtscd_06 = Double.parseDouble(dtcm(cfs.read_CFS(company,6,2006)));
    Double khtscd_07 = Double.parseDouble(dtcm(cfs.read_CFS(company,6,2007)));
    Double khtscd_08 = Double.parseDouble(dtcm(cfs.read_CFS(company,6,2008)));
    Double khtscd_09 = Double.parseDouble(dtcm(cfs.read_CFS(company,6,2009)));
    Double khtscd_10 = Double.parseDouble(dtcm(cfs.read_CFS(company,6,2010)));
    Double khtscd_11 = Double.parseDouble(dtcm(cfs.read_CFS(company,6,2011)));
    Double khtscd_12 = Double.parseDouble(dtcm(cfs.read_CFS(company,6,2012)));
    Double khtscd_13 = Double.parseDouble(dtcm(cfs.read_CFS(company,6,2013)));
    
     // Lưu chuyển tiền ròng từ hoạt động sản xuất kinh doanh
    Double lcttthdkd_05 = Double.parseDouble(dtcm(cfs.read_CFS(company,22,2005)));
    Double lcttthdkd_06 = Double.parseDouble(dtcm(cfs.read_CFS(company,22,2006)));
    Double lcttthdkd_07 = Double.parseDouble(dtcm(cfs.read_CFS(company,22,2007)));
    Double lcttthdkd_08 = Double.parseDouble(dtcm(cfs.read_CFS(company,22,2008)));
    Double lcttthdkd_09 = Double.parseDouble(dtcm(cfs.read_CFS(company,22,2009)));
    Double lcttthdkd_10 = Double.parseDouble(dtcm(cfs.read_CFS(company,22,2010)));
    Double lcttthdkd_11 = Double.parseDouble(dtcm(cfs.read_CFS(company,22,2011)));
    Double lcttthdkd_12 = Double.parseDouble(dtcm(cfs.read_CFS(company,22,2012)));
    Double lcttthdkd_13 = Double.parseDouble(dtcm(cfs.read_CFS(company,22,2013)));
    
    //Tiền mua tài sản cố định và các tài sản dài hạn khác
    Double tmtscdvctsdhk_05 = Double.parseDouble(dtcm(cfs.read_CFS(company,23,2005)));
    Double tmtscdvctsdhk_06 = Double.parseDouble(dtcm(cfs.read_CFS(company,23,2006)));
    Double tmtscdvctsdhk_07 = Double.parseDouble(dtcm(cfs.read_CFS(company,23,2007)));
    Double tmtscdvctsdhk_08 = Double.parseDouble(dtcm(cfs.read_CFS(company,23,2008)));
    Double tmtscdvctsdhk_09 = Double.parseDouble(dtcm(cfs.read_CFS(company,23,2009)));
    Double tmtscdvctsdhk_10 = Double.parseDouble(dtcm(cfs.read_CFS(company,23,2010)));
    Double tmtscdvctsdhk_11 = Double.parseDouble(dtcm(cfs.read_CFS(company,23,2011)));
    Double tmtscdvctsdhk_12 = Double.parseDouble(dtcm(cfs.read_CFS(company,23,2012)));
    Double tmtscdvctsdhk_13 = Double.parseDouble(dtcm(cfs.read_CFS(company,23,2013)));
    
     // Lưu chuyển tiền ròng từ hoạt động đầu tư
    Double lcttthddt_05 = Double.parseDouble(dtcm(cfs.read_CFS(company,30,2005)));
    Double lcttthddt_06 = Double.parseDouble(dtcm(cfs.read_CFS(company,30,2006)));
    Double lcttthddt_07 = Double.parseDouble(dtcm(cfs.read_CFS(company,30,2007)));
    Double lcttthddt_08 = Double.parseDouble(dtcm(cfs.read_CFS(company,30,2008)));
    Double lcttthddt_09 = Double.parseDouble(dtcm(cfs.read_CFS(company,30,2009)));
    Double lcttthddt_10 = Double.parseDouble(dtcm(cfs.read_CFS(company,30,2010)));
    Double lcttthddt_11 = Double.parseDouble(dtcm(cfs.read_CFS(company,30,2011)));
    Double lcttthddt_12 = Double.parseDouble(dtcm(cfs.read_CFS(company,30,2012)));
    Double lcttthddt_13 = Double.parseDouble(dtcm(cfs.read_CFS(company,30,2013)));
    
    //Tiền thu từ phát hành cổ phiếu
    Double tttphcp_05 = Double.parseDouble(dtcm(cfs.read_CFS(company,31,2005)));
    Double tttphcp_06 = Double.parseDouble(dtcm(cfs.read_CFS(company,31,2006)));
    Double tttphcp_07 = Double.parseDouble(dtcm(cfs.read_CFS(company,31,2007)));
    Double tttphcp_08 = Double.parseDouble(dtcm(cfs.read_CFS(company,31,2008)));
    Double tttphcp_09 = Double.parseDouble(dtcm(cfs.read_CFS(company,31,2009)));
    Double tttphcp_10 = Double.parseDouble(dtcm(cfs.read_CFS(company,31,2010)));
    Double tttphcp_11 = Double.parseDouble(dtcm(cfs.read_CFS(company,31,2011)));
    Double tttphcp_12 = Double.parseDouble(dtcm(cfs.read_CFS(company,31,2012)));
    Double tttphcp_13 = Double.parseDouble(dtcm(cfs.read_CFS(company,31,2013)));
    //Chi trả cho việc mua cổ phiếu
    Double ctcvmcp_05 = Double.parseDouble(dtcm(cfs.read_CFS(company,32,2005)));
    Double ctcvmcp_06 = Double.parseDouble(dtcm(cfs.read_CFS(company,32,2006)));
    Double ctcvmcp_07 = Double.parseDouble(dtcm(cfs.read_CFS(company,32,2007)));
    Double ctcvmcp_08 = Double.parseDouble(dtcm(cfs.read_CFS(company,32,2008)));
    Double ctcvmcp_09 = Double.parseDouble(dtcm(cfs.read_CFS(company,32,2009)));
    Double ctcvmcp_10 = Double.parseDouble(dtcm(cfs.read_CFS(company,32,2010)));
    Double ctcvmcp_11 = Double.parseDouble(dtcm(cfs.read_CFS(company,32,2011)));
    Double ctcvmcp_12 = Double.parseDouble(dtcm(cfs.read_CFS(company,32,2012)));
    Double ctcvmcp_13 = Double.parseDouble(dtcm(cfs.read_CFS(company,32,2013)));
    
    //Tiền thu từ phát hành cổ phiếu/ Cổ tức đã trả
    Double ctdt_05 = Double.parseDouble(dtcm(cfs.read_CFS(company,36,2005)));
    Double ctdt_06 = Double.parseDouble(dtcm(cfs.read_CFS(company,36,2006)));
    Double ctdt_07 = Double.parseDouble(dtcm(cfs.read_CFS(company,36,2007)));
    Double ctdt_08 = Double.parseDouble(dtcm(cfs.read_CFS(company,36,2008)));
    Double ctdt_09 = Double.parseDouble(dtcm(cfs.read_CFS(company,36,2009)));
    Double ctdt_10 = Double.parseDouble(dtcm(cfs.read_CFS(company,36,2010)));
    Double ctdt_11 = Double.parseDouble(dtcm(cfs.read_CFS(company,36,2011)));
    Double ctdt_12 = Double.parseDouble(dtcm(cfs.read_CFS(company,36,2012)));
    Double ctdt_13 = Double.parseDouble(dtcm(cfs.read_CFS(company,36,2013)));
    // Lưu chuyển tiền ròng từ hoạt động tài chính
    Double lcttthdtc_05 = Double.parseDouble(dtcm(cfs.read_CFS(company,38,2005)));
    Double lcttthdtc_06 = Double.parseDouble(dtcm(cfs.read_CFS(company,38,2006)));
    Double lcttthdtc_07 = Double.parseDouble(dtcm(cfs.read_CFS(company,38,2007)));
    Double lcttthdtc_08 = Double.parseDouble(dtcm(cfs.read_CFS(company,38,2008)));
    Double lcttthdtc_09 = Double.parseDouble(dtcm(cfs.read_CFS(company,38,2009)));
    Double lcttthdtc_10 = Double.parseDouble(dtcm(cfs.read_CFS(company,38,2010)));
    Double lcttthdtc_11 = Double.parseDouble(dtcm(cfs.read_CFS(company,38,2011)));
    Double lcttthdtc_12 = Double.parseDouble(dtcm(cfs.read_CFS(company,38,2012)));
    Double lcttthdtc_13 = Double.parseDouble(dtcm(cfs.read_CFS(company,38,2013)));
    
    //Ảnh hưởng của chênh lệch tỉ giá
    Double ahccltg_05 = Double.parseDouble(dtcm(cfs.read_CFS(company,41,2005)));
    Double ahccltg_06 = Double.parseDouble(dtcm(cfs.read_CFS(company,41,2006)));
    Double ahccltg_07 = Double.parseDouble(dtcm(cfs.read_CFS(company,41,2007)));
    Double ahccltg_08 = Double.parseDouble(dtcm(cfs.read_CFS(company,41,2008)));
    Double ahccltg_09 = Double.parseDouble(dtcm(cfs.read_CFS(company,41,2009)));
    Double ahccltg_10 = Double.parseDouble(dtcm(cfs.read_CFS(company,41,2010)));
    Double ahccltg_11 = Double.parseDouble(dtcm(cfs.read_CFS(company,41,2011)));
    Double ahccltg_12 = Double.parseDouble(dtcm(cfs.read_CFS(company,41,2012)));
    Double ahccltg_13 = Double.parseDouble(dtcm(cfs.read_CFS(company,41,2013)));
    
    //Tiền và tương đương tiền cuối kỳ
    Double tvtdtck_05 = Double.parseDouble(dtcm(cfs.read_CFS(company,42,2005)));
    Double tvtdtck_06 = Double.parseDouble(dtcm(cfs.read_CFS(company,42,2006)));
    Double tvtdtck_07 = Double.parseDouble(dtcm(cfs.read_CFS(company,42,2007)));
    Double tvtdtck_08 = Double.parseDouble(dtcm(cfs.read_CFS(company,42,2008)));
    Double tvtdtck_09 = Double.parseDouble(dtcm(cfs.read_CFS(company,42,2009)));
    Double tvtdtck_10 = Double.parseDouble(dtcm(cfs.read_CFS(company,42,2010)));
    Double tvtdtck_11 = Double.parseDouble(dtcm(cfs.read_CFS(company,42,2011)));
    Double tvtdtck_12 = Double.parseDouble(dtcm(cfs.read_CFS(company,42,2012)));
    Double tvtdtck_13 = Double.parseDouble(dtcm(cfs.read_CFS(company,42,2013)));
    
    
    
    //Extra info
     //%Khấu hao/%Thuế
    Double t_05 = (-ttndn_05)/ltt_05;
    Double t_06 = (-ttndn_06)/ltt_06;
    Double t_07 = (-ttndn_07)/ltt_07;
    Double t_08 = (-ttndn_08)/ltt_08;
    Double t_09 = (-ttndn_09)/ltt_09;
    Double t_10 = (-ttndn_10)/ltt_10;
    Double t_11 = (-ttndn_11)/ltt_11;
    Double t_12 = (-ttndn_12)/ltt_12;
    Double t_13 = (-ttndn_13)/ltt_13;
     
    //Working capital
    Double wc_05 = (tsnh_05 - nnh_05)*1000000;
    Double wc_06 = (tsnh_06 - nnh_06)*1000000;
    Double wc_07 = (tsnh_07 - nnh_07)*1000000;
    Double wc_08 = (tsnh_08 - nnh_08)*1000000;
    Double wc_09 = (tsnh_09 - nnh_09)*1000000;
    Double wc_10 = (tsnh_10 - nnh_10)*1000000;
    Double wc_11 = (tsnh_11 - nnh_11)*1000000;
    Double wc_12 = (tsnh_12 - nnh_12)*1000000;
    Double wc_13 = (tsnh_13 - nnh_13)*1000000;
    
   
        
        
        
        
        
        
        ////////////////////// MULTIPLE /////////////////////
        
        //Cashflow per share
        Double cfps_05 = lcttthdkd_05/sn_05*1000000;
        Double cfps_06 = lcttthdkd_06/sn_06*1000000;
        Double cfps_07 = lcttthdkd_07/sn_07*1000000;
        Double cfps_08 = lcttthdkd_08/sn_08*1000000;
        Double cfps_09 = lcttthdkd_09/sn_09*1000000;
        Double cfps_10 = lcttthdkd_10/sn_10*1000000;
        Double cfps_11 = lcttthdkd_11/sn_11*1000000;
        Double cfps_12 = lcttthdkd_12/sn_12*1000000;
        Double cfps_13 = lcttthdkd_13/sn_13*1000000;
        // Sales Per Share
        Double sps_05 = dtt_05/sn_05*1000000;
        Double sps_06 = dtt_06/sn_06*1000000;
        Double sps_07 = dtt_07/sn_07*1000000;
        Double sps_08 = dtt_08/sn_08*1000000;
        Double sps_09 = dtt_09/sn_09*1000000;
        Double sps_10 = dtt_10/sn_10*1000000;
        Double sps_11 = dtt_11/sn_11*1000000;
        Double sps_12 = dtt_12/sn_12*1000000;
        Double sps_13 = dtt_13/sn_13*1000000;
        
        
        // Dividend per share = Cổ tức
        
        
        //Price/Earning per share
        
        Double peps_05 = cp05*1000/eps_05;
        
        Double peps_06 = cp06*1000/eps_06;
        
        Double peps_07 = cp07*1000/eps_07;
        
        Double peps_08 = cp08*1000/eps_08;
        
        Double peps_09 = cp09*1000/eps_09;
        
        Double peps_10 = cp10*1000/eps_10;
        
        Double peps_11 = cp11*1000/eps_11;
        
        Double peps_12 = cp12*1000/eps_12;
        
        Double peps_13 = cp13*1000/eps_13;
         Double peps_avg3 = (peps_13+peps_12+peps_11)/3;
        Double peps_avg5 = (peps_13+peps_12+peps_11+peps_10+peps_09)/5;
        
        // Price/Cashflow per share
        
        Double pcfps_05 = cp05/cfps_05*1000000;
        
        Double pcfps_06 = cp06/cfps_06*1000;
        
        Double pcfps_07 = cp07/cfps_07*1000;
        
        Double pcfps_08 = cp08/cfps_08*1000;
        
        Double pcfps_09 = cp09/cfps_09*1000;
        
        Double pcfps_10 = cp10/cfps_10*1000;
        
        Double pcfps_11 = cp11/cfps_11*1000;
        
        Double pcfps_12 = cp12/cfps_12*1000;
        
        Double pcfps_13 = cp13/cfps_13*1000;
        Double pcfps_avg3 = (pcfps_13+pcfps_12+pcfps_11)/3;
        Double pcfps_avg5 = (pcfps_13+pcfps_12+pcfps_11+pcfps_10+pcfps_09)/5;
        
        // Price/ Sales per share
        
        Double psps_05 = cp05/sps_05*1000;
        
        Double psps_06 = cp06/sps_06*1000;
        
        Double psps_07 = cp07/sps_07*1000;
        
        Double psps_08 = cp08/sps_08*1000;
        
        Double psps_09 = cp09/sps_09*1000;
        
        Double psps_10 = cp10/sps_10*1000;
        
        Double psps_11 = cp11/sps_11*1000;
        
        Double psps_12 = cp12/sps_12*1000;
        
        Double psps_13 = cp13/sps_13*1000;
        Double psps_avg3 = (psps_13+psps_12+psps_11)/3;
        Double psps_avg5 = (psps_13+psps_12+psps_11+psps_10+psps_09)/5;
        
        //Free cashflow per share
        Double fcfps_05 = 0.0;
        Double fcfps_06 = (ebit_06 * (1-t_06) *1000000+ khtscd_06 *1000000 - (wc_06 - wc_05) - (tts_06 - tts_05)*1000000+ (tn_06 - tn_05)*1000000)/sn_06;
        Double fcfps_07 = (ebit_07 * (1-t_07) *1000000+ khtscd_07 *1000000 - (wc_07 - wc_06) - (tts_07 - tts_06)*1000000+ (tn_07 - tn_06)*1000000)/sn_07;
        Double fcfps_08 = (ebit_08 * (1-t_08) *1000000+ khtscd_08 *1000000 - (wc_08 - wc_07) - (tts_08 - tts_07)*1000000+ (tn_08 - tn_07)*1000000)/sn_08;
        Double fcfps_09 = (ebit_09 * (1-t_09) *1000000+ khtscd_09 *1000000 - (wc_09 - wc_08) - (tts_09 - tts_08)*1000000+ (tn_09 - tn_08)*1000000)/sn_09;
        Double fcfps_10 = (ebit_10 * (1-t_10) *1000000+ khtscd_10 *1000000 - (wc_10 - wc_09) - (tts_10 - tts_09)*1000000+ (tn_10 - tn_09)*1000000)/sn_10;
        Double fcfps_11 = (ebit_11 * (1-t_11) *1000000+ khtscd_11 *1000000 - (wc_11 - wc_10) - (tts_11 - tts_10)*1000000+ (tn_11 - tn_10)*1000000)/sn_11;
        Double fcfps_12 = (ebit_12 * (1-t_12) *1000000+ khtscd_12 *1000000 - (wc_12 - wc_11) - (tts_12 - tts_11)*1000000+ (tn_12 - tn_11)*1000000)/sn_12;
        Double fcfps_13 = (ebit_13 * (1-t_13) *1000000+ khtscd_13 *1000000 - (wc_13 - wc_12) - (tts_13 - tts_12)*1000000+ (tn_13 - tn_12)*1000000)/sn_13;
        
        //Input for FINA_Annual
        add_data2(conn,p2,company,"_FINA","Cashflow Per Share",doubletostring(2,cfps_13),doubletostring(2,cfps_12),doubletostring(2,cfps_11),doubletostring(2,cfps_10),doubletostring(2,cfps_09),
            doubletostring(2,cfps_08),doubletostring(2,cfps_07),doubletostring(2,cfps_06),doubletostring(2,cfps_05));    
        add_data2(conn,p2,company,"_FINA","Free Cashflow Per Share",doubletostring(2,fcfps_13),doubletostring(2,fcfps_12),doubletostring(2,fcfps_11),doubletostring(2,fcfps_10),doubletostring(2,fcfps_09),
            doubletostring(2,fcfps_08),doubletostring(2,fcfps_07),doubletostring(2,fcfps_06),doubletostring(2,fcfps_05));    
        
        //Price/Book Value Per Share
        
        Double pbvps_05 = cp05/bvps_05*1000;
        
        Double pbvps_06 = cp06/bvps_06*1000;
        
        Double pbvps_07 = cp07/bvps_07*1000;
        
        Double pbvps_08 = cp08/bvps_08*1000;
        
        Double pbvps_09 = cp09/bvps_09*1000;
       
        Double pbvps_10 = cp10/bvps_10*1000;
       
        Double pbvps_11 = cp11/bvps_11*1000;
       
        Double pbvps_12 = cp12/bvps_12*1000;
       
        Double pbvps_13 = cp13/bvps_13*1000;
        Double pbvps_avg3 = (pbvps_13+pbvps_12+pbvps_11)/3;
        Double pbvps_avg5 = (pbvps_13+pbvps_12+pbvps_11+pbvps_10+pbvps_09)/5;
        // Price/Free cashflow per share
        
        Double pfcfps_05 = 0.0;
        Double pfcfps_06 = cp06/fcfps_06*1000;
        
        Double pfcfps_07 = cp07/fcfps_07*1000;
        
        Double pfcfps_08 = cp08/fcfps_08*1000;
        
        Double pfcfps_09 = cp09/fcfps_09*1000;
        
        Double pfcfps_10 = cp10/fcfps_10*1000;
        Double pfcfps_11 = cp11/fcfps_11*1000;
        Double pfcfps_12 = cp12/fcfps_12*1000;
        Double pfcfps_13 = cp13/fcfps_13*1000;
         Double pfcfps_avg3 = (pfcfps_13+pfcfps_12+pfcfps_11)/3;
        Double pfcfps_avg5 = (pfcfps_13+pfcfps_12+pfcfps_11+pfcfps_10+pfcfps_09)/5;
        // %Yield 
        Double yield_05 = ct_05/cp05*100;
        Double yield_06 = ct_06/cp06*100;
        Double yield_07 = ct_07/cp07*100;
        Double yield_08 = ct_08/cp08*100;
        Double yield_09 = ct_09/cp09*100;
        Double yield_10 = ct_10/cp10*100;
        Double yield_11 = ct_11/cp11*100;
        Double yield_12 = ct_12/cp12*100;
        Double yield_13 = ct_13/cp13*100;
        Double yield_avg3 = (yield_13 + yield_12+yield_11)/3;
        Double yield_avg5 = (yield_13 + yield_12+yield_11+yield_10+yield_09)/5;
        //Buyback yield 
        Double bby_05 = 0.0;
        Double bby_06 = -ctcvmcp_06*1000000/ev_06*100;
        Double bby_07 = -ctcvmcp_07*1000000/ev_07*100;
        Double bby_08 = -ctcvmcp_08*1000000/ev_08*100;
        Double bby_09 = -ctcvmcp_09*1000000/ev_09*100;
        Double bby_10 = -ctcvmcp_10*1000000/ev_10*100;
        Double bby_11 = -ctcvmcp_11*1000000/ev_11*100;
        Double bby_12 = -ctcvmcp_12*1000000/ev_12*100;
        Double bby_13 = -ctcvmcp_13*1000000/ev_13*100;
        Double bby_avg3 = (bby_13 + bby_12+bby_11)/3;
        Double bby_avg5 = (bby_13 + bby_12+bby_11+bby_10+bby_09)/5;
        
        //Share holder yield
        Double shy_05 = 0.0;
        Double shy_06 = (ctdt_06*1000000+ctcvmcp_06*1000000-tttphcp_06*1000000)/ev_06*100;
        Double shy_07 = (ctdt_07*1000000+ctcvmcp_07*1000000-tttphcp_07*1000000)/ev_07*100;
        Double shy_08 = (ctdt_08*1000000+ctcvmcp_08*1000000-tttphcp_08*1000000)/ev_08*100;
        Double shy_09 = (ctdt_09*1000000+ctcvmcp_09*1000000-tttphcp_09*1000000)/ev_09*100;
        Double shy_10 = (ctdt_10*1000000+ctcvmcp_10*1000000-tttphcp_10*1000000)/ev_10*100;
        Double shy_11 = (ctdt_11*1000000+ctcvmcp_11*1000000-tttphcp_11*1000000)/ev_11*100;
        Double shy_12 = (ctdt_12*1000000+ctcvmcp_12*1000000-tttphcp_12*1000000)/ev_12*100;
        Double shy_13 = (ctdt_13*1000000+ctcvmcp_13*1000000-tttphcp_13*1000000)/ev_13*100;
       Double shy_avg3 = (shy_13 + shy_12+shy_11)/3;
        Double shy_avg5 = (shy_13 + shy_12+shy_11+shy_10+shy_09)/5;
        //Enterprise value/EBITDA
        Double evebitda_05 = 0.0;
        Double evebitda_06 = ev_06/(ebitda_06*1000000);
        Double evebitda_07 = ev_07/(ebitda_07*1000000);
        Double evebitda_08 = ev_08/(ebitda_08*1000000);
        Double evebitda_09 = ev_09/(ebitda_09*1000000);
        Double evebitda_10 = ev_10/(ebitda_10*1000000);
        Double evebitda_11 = ev_11/(ebitda_11*1000000);
        Double evebitda_12 = ev_12/(ebitda_12*1000000);
        Double evebitda_13 = ev_13/(ebitda_13*1000000);
        Double evebitda_avg3 = (evebitda_13+evebitda_12+evebitda_11)/3;
        Double evebitda_avg5 = (evebitda_13+evebitda_12+evebitda_11+evebitda_10+evebitda_09)/5;
        ////////////////////////// RATIO /////////////////////////////
        
        
        //Gross Profit Margin
        Double gpm_05 = lg_05/dtt_05;
        Double gpm_06 = lg_06/dtt_06;
        Double gpm_07 = lg_07/dtt_07;
        Double gpm_08 = lg_08/dtt_08;
        Double gpm_09 = lg_09/dtt_09;
        Double gpm_10 = lg_10/dtt_10;
        Double gpm_11 = lg_11/dtt_11;
        Double gpm_12 = lg_12/dtt_12;
        Double gpm_13 = lg_13/dtt_13;
        
        //Operating Margin
        Double om_05 = llthdkd_05/dtt_05;
        Double om_06 = llthdkd_06/dtt_06;
        Double om_07 = llthdkd_07/dtt_07;
        Double om_08 = llthdkd_08/dtt_08;
        Double om_09 = llthdkd_09/dtt_09;
        Double om_10 = llthdkd_10/dtt_10;
        Double om_11 = llthdkd_11/dtt_11;
        Double om_12 = llthdkd_12/dtt_12;
        Double om_13 = llthdkd_13/dtt_13;
        
        //Net Profit Margin
        Double npm_05 = llctm_05/dtt_05;
        Double npm_06 = llctm_06/dtt_06;
        Double npm_07 = llctm_07/dtt_07;
        Double npm_08 = llctm_08/dtt_08;
        Double npm_09 = llctm_09/dtt_09;
        Double npm_10 = llctm_10/dtt_10;
        Double npm_11 = llctm_11/dtt_11;
        Double npm_12 = llctm_12/dtt_12;
        Double npm_13 = llctm_13/dtt_13;
        
        //Return on Assets
        Double roa_05 = llctm_05/tts_05;
        Double roa_06 = llctm_06/tts_06;
        Double roa_07 = llctm_07/tts_07;
        Double roa_08 = llctm_08/tts_08;
        Double roa_09 = llctm_09/tts_09;
        Double roa_10 = llctm_10/tts_10;
        Double roa_11 = llctm_11/tts_11;
        Double roa_12 = llctm_12/tts_12;
        Double roa_13 = llctm_13/tts_13;
        
        //Return on Equity
        Double roe_05 = llctm_05/vcsh_05;
        Double roe_06 = llctm_06/vcsh_06;
        Double roe_07 = llctm_07/vcsh_07;
        Double roe_08 = llctm_08/vcsh_08;
        Double roe_09 = llctm_09/vcsh_09;
        Double roe_10 = llctm_10/vcsh_10;
        Double roe_11 = llctm_11/vcsh_11;
        Double roe_12 = llctm_12/vcsh_12;
        Double roe_13 = llctm_13/vcsh_13;
        
        // LIQUIDITY
        
        // Quick Ratio
        Double qr_05 = (tsnh_05 - htk_05)/nnh_05;
        Double qr_06 = (tsnh_06 - htk_06)/nnh_06;
        Double qr_07 = (tsnh_07 - htk_07)/nnh_07;
        Double qr_08 = (tsnh_08 - htk_08)/nnh_08;
        Double qr_09 = (tsnh_09 - htk_09)/nnh_09;
        Double qr_10 = (tsnh_10 - htk_10)/nnh_10;
        Double qr_11 = (tsnh_11 - htk_11)/nnh_11;
        Double qr_12 = (tsnh_12 - htk_12)/nnh_12;
        Double qr_13 = (tsnh_13 - htk_13)/nnh_13;
        
        // Current Ratio
        Double cr_05 = tsnh_05/nnh_05;
        Double cr_06 = tsnh_06/nnh_06;
        Double cr_07 = tsnh_07/nnh_07;
        Double cr_08 = tsnh_08/nnh_08;
        Double cr_09 = tsnh_09/nnh_09;
        Double cr_10 = tsnh_10/nnh_10;
        Double cr_11 = tsnh_11/nnh_11;
        Double cr_12 = tsnh_12/nnh_12;
        Double cr_13 = tsnh_13/nnh_13;
        
        //Payout Ratio
        Double pr_05 = ct_05*1000/eps_05;//eps đã được *1000000
        Double pr_06 = ct_06*1000/eps_06;
        Double pr_07 = ct_07*1000/eps_07;
        Double pr_08 = ct_08*1000/eps_08;
        Double pr_09 = ct_09*1000/eps_09;
        Double pr_10 = ct_10*1000/eps_10;
        Double pr_11 = ct_11*1000/eps_11;
        Double pr_12 = ct_12*1000/eps_12;
        Double pr_13 = ct_13*1000/eps_13;
        
        //Times Interest Earned
        Double tie_05 = ebit_05/cptlv_05;
        Double tie_06 = ebit_06/cptlv_06;
        Double tie_07 = ebit_07/cptlv_07;
        Double tie_08 = ebit_08/cptlv_08;
        Double tie_09 = ebit_09/cptlv_09;
        Double tie_10 = ebit_10/cptlv_10;
        Double tie_11 = ebit_11/cptlv_11;
        Double tie_12 = ebit_12/cptlv_12;
        Double tie_13 = ebit_13/cptlv_13;
        
        //DEBT MANAGEMENT;
        //Total Liability to Assets
        Double tlta_05 = tn_05/tts_05;
        Double tlta_06 = tn_06/tts_06;
        Double tlta_07 = tn_07/tts_07;
        Double tlta_08 = tn_08/tts_08;
        Double tlta_09 = tn_09/tts_09;
        Double tlta_10 = tn_10/tts_10;
        Double tlta_11 = tn_11/tts_11;
        Double tlta_12 = tn_12/tts_12;
        Double tlta_13 = tn_13/tts_13;
        
        //Long term debt to Equity
        Double ltdte_05 = ndh_05/vcsh_05;
        Double ltdte_06 = ndh_06/vcsh_06;
        Double ltdte_07 = ndh_07/vcsh_07;
        Double ltdte_08 = ndh_08/vcsh_08;
        Double ltdte_09 = ndh_09/vcsh_09;
        Double ltdte_10 = ndh_10/vcsh_10;
        Double ltdte_11 = ndh_11/vcsh_11;
        Double ltdte_12 = ndh_12/vcsh_12;
        Double ltdte_13 = ndh_13/vcsh_13;
        
        //Long term debt to Capital
        Double ltdtc_05 = ndh_05/vvcq_05;
        Double ltdtc_06 = ndh_06/vvcq_06;
        Double ltdtc_07 = ndh_07/vvcq_07;
        Double ltdtc_08 = ndh_08/vvcq_08;
        Double ltdtc_09 = ndh_09/vvcq_09;
        Double ltdtc_10 = ndh_10/vvcq_10;
        Double ltdtc_11 = ndh_11/vvcq_11;
        Double ltdtc_12 = ndh_12/vvcq_12;
        Double ltdtc_13 = ndh_13/vvcq_13;
        
        //ASSET MANAGEMENT
        //Receivable Turnover
        Double rt_05 = lg_05/ckpt_05;
        Double rt_06 = lg_06/ckpt_06;
        Double rt_07 = lg_07/ckpt_07;
        Double rt_08 = lg_08/ckpt_08;
        Double rt_09 = lg_09/ckpt_09;
        Double rt_10 = lg_10/ckpt_10;
        Double rt_11 = lg_11/ckpt_11;
        Double rt_12 = lg_12/ckpt_12;
        Double rt_13 = lg_13/ckpt_13;
        
        //Inventory Turnover
        Double it_05 = gvbh_05/htk_05;
        Double it_06 = gvbh_06/htk_06;
        Double it_07 = gvbh_07/htk_07;
        Double it_08 = gvbh_08/htk_08;
        Double it_09 = gvbh_09/htk_09;
        Double it_10 = gvbh_10/htk_10;
        Double it_11 = gvbh_11/htk_11;
        Double it_12 = gvbh_12/htk_12;
        Double it_13 = gvbh_13/htk_13;
        
        //Asset Turnover
        Double at_05 = dtt_05/tts_05;
        Double at_06 = dtt_06/tts_06;
        Double at_07 = dtt_07/tts_07;
        Double at_08 = dtt_08/tts_08;
        Double at_09 = dtt_09/tts_09;
        Double at_10 = dtt_10/tts_10;
        Double at_11 = dtt_11/tts_11;
        Double at_12 = dtt_12/tts_12;
        Double at_13 = dtt_13/tts_13;
        
        // FINANCIAL STRENGTH
        //F-Score
        Integer f_05 = 0;
        Integer f_06 = 0;
        Integer f_07 = 0;
        Integer f_08 = 0;
        Integer f_09 = 0;
        Integer f_10 = 0;
        Integer f_11 = 0;
        Integer f_12 = 0;
        Integer f_13 = 0;
        
        // ROA > 0
        if (roa_05 > 0) { f_05 = f_05 +1;}
        if (roa_06 > 0) { f_06 = f_06 +1;}
        if (roa_07 > 0) { f_07 = f_07 +1;}
        if (roa_08 > 0) { f_08 = f_08 +1;}  
        if (roa_09 > 0) { f_09 = f_09 +1;}
        if (roa_10 > 0) { f_10 = f_10 +1;}
        if (roa_11 > 0) { f_11 = f_11 +1;}
        if (roa_12 > 0) { f_12 = f_12 +1;}
        if (roa_13 > 0) { f_13 = f_13 +1;}
        
        //CF > 0
        if (lcttthdkd_05 > 0) { f_05 = f_05 +1;}
        if (lcttthdkd_06 > 0) { f_06 = f_06 +1;}
        if (lcttthdkd_07 > 0) { f_07 = f_07 +1;}
        if (lcttthdkd_08 > 0) { f_08 = f_08 +1;}  
        if (lcttthdkd_09 > 0) { f_09 = f_09 +1;}
        if (lcttthdkd_10 > 0) { f_10 = f_10 +1;}
        if (lcttthdkd_11 > 0) { f_11 = f_11 +1;}
        if (lcttthdkd_12 > 0) { f_12 = f_12 +1;}
        if (lcttthdkd_13 > 0) { f_13 = f_13 +1;}
        
        // ROA_06 > ROA_05?
        if (roa_06 > roa_05) { f_06 = f_06 +1;}
        if (roa_07 > roa_06) { f_07 = f_07 +1;}
        if (roa_08 > roa_07) { f_08 = f_08 +1;}  
        if (roa_09 > roa_08) { f_09 = f_09 +1;}
        if (roa_10 > roa_09) { f_10 = f_10 +1;}
        if (roa_11 > roa_10) { f_11 = f_11 +1;}
        if (roa_12 > roa_11) { f_12 = f_12 +1;}
        if (roa_13 > roa_12) { f_13 = f_13 +1;}
        
        // CF > ROA
        if (lcttthdkd_05 > roa_05) { f_05 = f_05 +1;}
        if (lcttthdkd_06 > roa_06) { f_06 = f_06 +1;}
        if (lcttthdkd_07 > roa_07) { f_07 = f_07 +1;}
        if (lcttthdkd_08 > roa_08) { f_08 = f_08 +1;}  
        if (lcttthdkd_09 > roa_09) { f_09 = f_09 +1;}
        if (lcttthdkd_10 > roa_10) { f_10 = f_10 +1;}
        if (lcttthdkd_11 > roa_11) { f_11 = f_11 +1;}
        if (lcttthdkd_12 > roa_12) { f_12 = f_12 +1;}
        if (lcttthdkd_13 > roa_13) { f_13 = f_13 +1;}
        
        //NDH_06 < NDH_05?
        if (ndh_06 < ndh_05) { f_06 = f_06 +1;};
        if (ndh_07 < ndh_06) { f_07 = f_07 +1;};
        if (ndh_08 < ndh_07) { f_08 = f_08 +1;};
        if (ndh_09 < ndh_08) { f_09 = f_09 +1;};
        if (ndh_10 < ndh_09) { f_10 = f_10 +1;};
        if (ndh_11 < ndh_10) { f_11 = f_11 +1;};
        if (ndh_12 < ndh_11) { f_12 = f_12 +1;};
        if (ndh_13 < ndh_12) { f_13 = f_13 +1;};
        
        // CR_06 > CR_05?
        if (cr_06 > cr_05) { f_06 = f_06 +1;}
        if (cr_07 > cr_06) { f_07 = f_07 +1;}
        if (cr_08 > cr_07) { f_08 = f_08 +1;}
        if (cr_09 > cr_08) { f_09 = f_09 +1;}
        if (cr_10 > cr_09) { f_10 = f_10 +1;}
        if (cr_11 > cr_10) { f_11 = f_11 +1;}
        if (cr_12 > cr_11) { f_12 = f_12 +1;}
        if (cr_13 > cr_12) { f_13 = f_13 +1;}
        
        //SN_06 = SN_05?
        if (sn_06 == sn_05) { f_06 = f_06 +1;}
        if (sn_07 == sn_06) { f_07 = f_07 +1;}
        if (sn_08 == sn_07) { f_08 = f_08 +1;}
        if (sn_09 == sn_08) { f_09 = f_09 +1;}
        if (sn_10 == sn_09) { f_10 = f_10 +1;}
        if (sn_11 == sn_10) { f_11 = f_11 +1;}
        if (sn_12 == sn_11) { f_12 = f_12 +1;}
        if (sn_13 == sn_12) { f_13 = f_13 +1;}
        
        // GPM_06 > GPM_05?
        if (gpm_06 > gpm_05) { f_06 = f_06 +1;}
        if (gpm_07 > gpm_06) { f_07 = f_07 +1;}
        if (gpm_08 > gpm_07) { f_08 = f_08 +1;}
        if (gpm_09 > gpm_08) { f_09 = f_09 +1;}
        if (gpm_10 > gpm_09) { f_10 = f_10 +1;}
        if (gpm_11 > gpm_10) { f_11 = f_11 +1;}
        if (gpm_12 > gpm_11) { f_12 = f_12 +1;}
        if (gpm_13 > gpm_12) { f_13 = f_13 +1;}
        
        // AT_06 > AT_05?
        
        if (at_06 > at_05) { f_06 = f_06 +1;}
        if (at_07 > at_06) { f_07 = f_07 +1;}
        if (at_08 > at_07) { f_08 = f_08 +1;}
        if (at_09 > at_08) { f_09 = f_09 +1;}
        if (at_10 > at_09) { f_10 = f_10 +1;}
        if (at_11 > at_10) { f_11 = f_11 +1;}
        if (at_12 > at_11) { f_12 = f_12 +1;}
        if (at_13 > at_12) { f_13 = f_13 +1;}
        
        // Z-Score
        Double a_05 = (tsnh_05 - nnh_05)/tts_05;
        Double a_06 = (tsnh_06 - nnh_06)/tts_06;
        Double a_07 = (tsnh_07 - nnh_07)/tts_07;
        Double a_08 = (tsnh_08 - nnh_08)/tts_08;
        Double a_09 = (tsnh_09 - nnh_09)/tts_09;
        Double a_10 = (tsnh_10 - nnh_10)/tts_10;
        Double a_11 = (tsnh_11 - nnh_11)/tts_11;
        Double a_12 = (tsnh_12 - nnh_12)/tts_12;
        Double a_13 = (tsnh_13 - nnh_13)/tts_13;
        
        Double b_05 = lcpp_05/tts_05;
        Double b_06 = lcpp_06/tts_06;
        Double b_07 = lcpp_07/tts_07;
        Double b_08 = lcpp_08/tts_08;
        Double b_09 = lcpp_09/tts_09;
        Double b_10 = lcpp_10/tts_10;
        Double b_11 = lcpp_11/tts_11;
        Double b_12 = lcpp_12/tts_12;
        Double b_13 = lcpp_13/tts_13;
        
        Double c_05 = ebit_05/tts_05;
        Double c_06 = ebit_06/tts_06;
        Double c_07 = ebit_07/tts_07;
        Double c_08 = ebit_08/tts_08;
        Double c_09 = ebit_09/tts_09;
        Double c_10 = ebit_10/tts_10;
        Double c_11 = ebit_11/tts_11;
        Double c_12 = ebit_12/tts_12;
        Double c_13 = ebit_13/tts_13;
        
        Double d_05 = sn_05*cp05/(tn_05*1000);
        Double d_06 = sn_06*cp06/(tn_06*1000);
        Double d_07 = sn_07*cp07/(tn_07*1000);
        Double d_08 = sn_08*cp08/(tn_08*1000);
        Double d_09 = sn_09*cp09/(tn_09*1000);
        Double d_10 = sn_10*cp10/(tn_10*1000);
        Double d_11 = sn_11*cp11/(tn_11*1000);
        Double d_12 = sn_12*cp12/(tn_12*1000);
        Double d_13 = sn_13*cp13/(tn_13*1000);
        
        Double e_05 = lg_05/tts_05;
        Double e_06 = lg_06/tts_06;
        Double e_07 = lg_07/tts_07;
        Double e_08 = lg_08/tts_08;
        Double e_09 = lg_09/tts_09;
        Double e_10 = lg_10/tts_10;
        Double e_11 = lg_11/tts_11;
        Double e_12 = lg_12/tts_12;
        Double e_13 = lg_13/tts_13;
        
        Double z_05 = 1.2*a_05 + 1.4*b_05 + 3.3*c_05 + 0.6*d_05 + e_05;
        Double z_06 = 1.2*a_06 + 1.4*b_06 + 3.3*c_06 + 0.6*d_06 + e_06;
        Double z_07 = 1.2*a_07 + 1.4*b_07 + 3.3*c_07 + 0.6*d_07 + e_07;
        Double z_08 = 1.2*a_08 + 1.4*b_08 + 3.3*c_08 + 0.6*d_08 + e_08;
        Double z_09 = 1.2*a_09 + 1.4*b_09 + 3.3*c_09 + 0.6*d_09 + e_09;
        Double z_10 = 1.2*a_10 + 1.4*b_10 + 3.3*c_10 + 0.6*d_10 + e_10;
        Double z_11 = 1.2*a_11 + 1.4*b_11 + 3.3*c_11 + 0.6*d_11 + e_11;
        Double z_12 = 1.2*a_12 + 1.4*b_12 + 3.3*c_12 + 0.6*d_12 + e_12;
        Double z_13 = 1.2*a_13 + 1.4*b_13 + 3.3*c_13 + 0.6*d_13 + e_13;
        
        
        //5 Year Annual Growth Rate
        Double eps_change_5 = (eps_13 - eps_09)/eps_09*100;
        Double ct_change_5 = (ct_13 - ct_09)/ct_09*100;
        Double cf_change_5 = (lcttthdkd_13 - lcttthdkd_09)/lcttthdkd_09*100;
        Double fcfps_change_5 = (fcfps_13 - fcfps_09)/fcfps_09*100;
        Double s_change_5 = (dtt_13 - dtt_09)/dtt_09*100;
        
        // Trend
        Double eps_trend = (1+eps_change_5/100)*eps_13;
        Double ct_trend = (1+ct_change_5/100)*ct_13;
        Double cf_trend = (1+cf_change_5/100)*lcttthdkd_13;
        Double fcf_trend = (1+fcfps_change_5/100)*fcfps_13;
        Double s_trend = (1+s_change_5/100)*(dtt_13*1000000);
        
        //Current Multiple
        Double eps_cm = IaA.close_price(company,2014)*1000/eps_13;
        Double ct_cm = IaA.close_price(company,2014)*1000/ct_13;
        Double cf_cm = IaA.close_price(company,2014)*1000/lcttthdkd_13;
        Double fcf_cm = IaA.close_price(company,2014)*1000/fcfps_13;
        Double s_cm = IaA.close_price(company,2014)*1000/(dtt_13*1000000);
        
        
        add_company_val(conn,prestatement,company,"_VAL");
        p_val = conn.prepareStatement("INSERT INTO `FINA_"+company+"_VAL` (`clause`, `EPS`, `Dividend`, `Cashflow`, `Free Cashflow`, `Sales`) VALUES(N?,?,?,?,?,?);");
        add_data_val(conn,p_val,company,"_VAL","Latest Report",doubletostring(2,eps_13),doubletostring(2,ct_13),doubletostring(2,lcttthdkd_13),doubletostring(2,fcfps_13),doubletostring(2,dtt_13*1000000));
        add_data_val(conn,p_val,company,"_VAL","5 Year Annual Growth Rate",doubletostring(2,eps_change_5),doubletostring(2,ct_change_5),doubletostring(2,cf_change_5),doubletostring(2,fcfps_change_5),doubletostring(2,s_change_5));
        add_data_val(conn,p_val,company,"_VAL","Trend",doubletostring(2,eps_trend),doubletostring(2,ct_trend),doubletostring(2,cf_trend),doubletostring(2,fcf_trend),doubletostring(2,s_trend));
         add_data_val(conn,p_val,company,"_VAL","Current Multiple",doubletostring(2,eps_cm),doubletostring(2,ct_cm),doubletostring(2,cf_cm),doubletostring(2,fcf_cm),doubletostring(2,s_cm));
     //   System.out.println(a_13+" , "+b_13+" , "+c_13+" , "+d_13+" , "+e_13);
        // UPLOAD MULTIPLES' DATA
        
        add_company_mult(conn,prestatement,company,"_MULT");
        p_mul = conn.prepareStatement("INSERT INTO `FINA_"+company+"_MULT` (`clause`, `Current`, `1 Year Ago`, `2 Years Ago`, `3 Years Ago`, `Average 3 Years`, `Average 5 Years`) VALUES(N?,?,?,?,?,?,?);");
         add_data_mult(conn,p_mul,company,"_MULT","Price/Earning per share",doubletostring(2,peps_13),doubletostring(2,peps_12),doubletostring(2,peps_11),doubletostring(2,peps_avg3),doubletostring(2,peps_avg5),doubletostring(2,peps_08),doubletostring(2,peps_07),doubletostring(2,peps_06),doubletostring(2,peps_05));
         add_data_mult(conn,p_mul,company,"_MULT","Price/Book value per share",doubletostring(2,pbvps_13),doubletostring(2,pbvps_12),doubletostring(2,pbvps_11),doubletostring(2,pbvps_avg3),doubletostring(2,pbvps_avg5),doubletostring(2,pbvps_08),doubletostring(2,pbvps_07),doubletostring(2,pbvps_06),doubletostring(2,pbvps_05));
         add_data_mult(conn,p_mul,company,"_MULT","Price/Sales per share",doubletostring(2,psps_13),doubletostring(2,psps_12),doubletostring(2,psps_11),doubletostring(2,psps_avg3),doubletostring(2,psps_avg5),doubletostring(2,psps_08),doubletostring(2,psps_07),doubletostring(2,psps_06),doubletostring(2,psps_05));
         add_data_mult(conn,p_mul,company,"_MULT","Price/Cash Flow per share",doubletostring(2,pcfps_13),doubletostring(2,pcfps_12),doubletostring(2,pcfps_11),doubletostring(2,pcfps_avg3),doubletostring(2,pcfps_avg5),doubletostring(2,pcfps_08),doubletostring(2,pcfps_07),doubletostring(2,pcfps_06),doubletostring(2,pcfps_05));
         add_data_mult(conn,p_mul,company,"_MULT","Price/Free Cash Flow per share",doubletostring(2,pfcfps_13),doubletostring(2,pfcfps_12),doubletostring(2,pfcfps_11),doubletostring(2,pfcfps_avg3),doubletostring(2,pfcfps_avg5),doubletostring(2,pfcfps_08),doubletostring(2,pfcfps_07),doubletostring(2,pfcfps_06),doubletostring(2,pfcfps_05));
         add_data_mult(conn,p_mul,company,"_MULT","Yield",doubletostring(2,yield_13),doubletostring(2,yield_12),doubletostring(2,yield_11),doubletostring(2,yield_avg3),doubletostring(2,yield_avg5),doubletostring(2,yield_08),doubletostring(2,yield_07),doubletostring(2,yield_06),doubletostring(2,yield_05));
         add_data_mult(conn,p_mul,company,"_MULT","Buy Back Yield",doubletostring(2,bby_13),doubletostring(2,bby_12),doubletostring(2,bby_11),doubletostring(2,bby_avg3),doubletostring(2,bby_avg5),doubletostring(2,bby_08),doubletostring(2,bby_07),doubletostring(2,bby_06),doubletostring(2,bby_05));
         add_data_mult(conn,p_mul,company,"_MULT","Share Holder Yield",doubletostring(2,shy_13),doubletostring(2,shy_12),doubletostring(2,shy_11),doubletostring(2,shy_avg3),doubletostring(2,shy_avg5),doubletostring(2,shy_08),doubletostring(2,shy_07),doubletostring(2,shy_06),doubletostring(2,shy_05));
         add_data_mult(conn,p_mul,company,"_MULT","Enterprise value/EBITDA",doubletostring(2,evebitda_13),doubletostring(2,evebitda_12),doubletostring(2,evebitda_11),doubletostring(2,evebitda_avg3),doubletostring(2,evebitda_avg5),doubletostring(2,evebitda_08),doubletostring(2,evebitda_07),doubletostring(2,evebitda_06),doubletostring(2,evebitda_05));
           
       // UPLOAD RATIO's DATA
        
        add_company_rat(conn,prestatement,company,"_RAT");
        p_rat = conn.prepareStatement("INSERT INTO `FINA_"+company+"_RAT` (`clause`, `Current`, `1 Year Ago`, `2 Years Ago`, `3 Years Ago`, `4 Years Ago`, `5 Years Ago`, `6 Years Ago`, `7 Years Ago`, `8 Years Ago`) VALUES(N?,?,?,?,?,?,?,?,?,?);");
            add_data_rat(conn,p_rat,company,"_RAT","PROFITABILITY","","","","","","","","","");
            add_data_rat(conn,p_rat,company,"_RAT","Gross Profit Margin",doubletostring(2,gpm_13),doubletostring(2,gpm_12),doubletostring(2,gpm_11),doubletostring(2,gpm_10),doubletostring(2,gpm_09),doubletostring(2,gpm_08),doubletostring(2,gpm_07),doubletostring(2,gpm_06),doubletostring(2,gpm_05));
            add_data_rat(conn,p_rat,company,"_RAT","Operating Margin",doubletostring(2,om_13),doubletostring(2,om_12),doubletostring(2,om_11),doubletostring(2,om_10),doubletostring(2,om_09),doubletostring(2,om_08),doubletostring(2,om_07),doubletostring(2,om_06),doubletostring(2,om_05));
            add_data_rat(conn,p_rat,company,"_RAT","Net Profit Margin",doubletostring(2,npm_13),doubletostring(2,npm_12),doubletostring(2,npm_11),doubletostring(2,npm_10),doubletostring(2,npm_09),doubletostring(2,npm_08),doubletostring(2,npm_07),doubletostring(2,npm_06),doubletostring(2,npm_05));
            add_data_rat(conn,p_rat,company,"_RAT","Return on Assets",doubletostring(2,roa_13),doubletostring(2,roa_12),doubletostring(2,roa_11),doubletostring(2,roa_10),doubletostring(2,roa_09),doubletostring(2,roa_08),doubletostring(2,roa_07),doubletostring(2,roa_06),doubletostring(2,roa_05));
            add_data_rat(conn,p_rat,company,"_RAT","Return on Equity",doubletostring(2,roe_13),doubletostring(2,roe_12),doubletostring(2,roe_11),doubletostring(2,roe_10),doubletostring(2,roe_09),doubletostring(2,roe_08),doubletostring(2,roe_07),doubletostring(2,roe_06),doubletostring(2,roe_05));
            add_data_rat(conn,p_rat,company,"_RAT","LIQUIDITY","","","","","","","","","");
            add_data_rat(conn,p_rat,company,"_RAT","Qucik Ratio",doubletostring(2,qr_13),doubletostring(2,qr_12),doubletostring(2,qr_11),doubletostring(2,qr_10),doubletostring(2,qr_09),doubletostring(2,qr_08),doubletostring(2,qr_07),doubletostring(2,qr_06),doubletostring(2,qr_05));
            add_data_rat(conn,p_rat,company,"_RAT","Current Ratio",doubletostring(2,cr_13),doubletostring(2,cr_12),doubletostring(2,cr_11),doubletostring(2,cr_10),doubletostring(2,cr_09),doubletostring(2,cr_08),doubletostring(2,cr_07),doubletostring(2,cr_06),doubletostring(2,cr_05));
            add_data_rat(conn,p_rat,company,"_RAT","Payout Ratio",doubletostring(2,pr_13),doubletostring(2,pr_12),doubletostring(2,pr_11),doubletostring(2,pr_10),doubletostring(2,pr_09),doubletostring(2,pr_08),doubletostring(2,pr_07),doubletostring(2,pr_06),doubletostring(2,pr_05));
            add_data_rat(conn,p_rat,company,"_RAT","Times Interest Earned",doubletostring(2,tie_13),doubletostring(2,tie_12),doubletostring(2,tie_11),doubletostring(2,tie_10),doubletostring(2,tie_09),doubletostring(2,tie_08),doubletostring(2,tie_07),doubletostring(2,tie_06),doubletostring(2,tie_05));
            add_data_rat(conn,p_rat,company,"_RAT","DEBT MANAGEMENT","","","","","","","","","");
            add_data_rat(conn,p_rat,company,"_RAT","Total Liabilities to Total Assets",doubletostring(2,tlta_13),doubletostring(2,tlta_12),doubletostring(2,tlta_11),doubletostring(2,tlta_10),doubletostring(2,tlta_09),doubletostring(2,tlta_08),doubletostring(2,tlta_07),doubletostring(2,tlta_06),doubletostring(2,tlta_05));
            add_data_rat(conn,p_rat,company,"_RAT","Long-term Debt to Capital",doubletostring(2,ltdtc_13),doubletostring(2,ltdtc_12),doubletostring(2,ltdtc_11),doubletostring(2,ltdtc_10),doubletostring(2,ltdtc_09),doubletostring(2,ltdtc_08),doubletostring(2,ltdtc_07),doubletostring(2,ltdtc_06),doubletostring(2,ltdtc_05));
            add_data_rat(conn,p_rat,company,"_RAT","Long-term Debt to Equity",doubletostring(2,ltdte_13),doubletostring(2,ltdte_12),doubletostring(2,ltdte_11),doubletostring(2,ltdte_10),doubletostring(2,ltdte_09),doubletostring(2,ltdte_08),doubletostring(2,ltdte_07),doubletostring(2,ltdte_06),doubletostring(2,ltdte_05));
            add_data_rat(conn,p_rat,company,"_RAT","ASSETS MANAGEMENT","","","","","","","","","");
            add_data_rat(conn,p_rat,company,"_RAT","Receivables Turnover",doubletostring(2,rt_13),doubletostring(2,rt_12),doubletostring(2,rt_11),doubletostring(2,rt_10),doubletostring(2,rt_09),doubletostring(2,rt_08),doubletostring(2,rt_07),doubletostring(2,rt_06),doubletostring(2,rt_05));
            add_data_rat(conn,p_rat,company,"_RAT","Inventory Turnover",doubletostring(2,it_13),doubletostring(2,it_12),doubletostring(2,it_11),doubletostring(2,it_10),doubletostring(2,it_09),doubletostring(2,it_08),doubletostring(2,it_07),doubletostring(2,it_06),doubletostring(2,it_05));
            add_data_rat(conn,p_rat,company,"_RAT","Assets Turnover",doubletostring(2,at_13),doubletostring(2,at_12),doubletostring(2,at_11),doubletostring(2,at_10),doubletostring(2,at_09),doubletostring(2,at_08),doubletostring(2,at_07),doubletostring(2,at_06),doubletostring(2,at_05));
            add_data_rat(conn,p_rat,company,"_RAT","FINANCIAL STRENGTH","","","","","","","","",""); 
            add_data_rat(conn,p_rat,company,"_RAT","F-Score",Integer.toString(f_13),Integer.toString(f_12),Integer.toString(f_11),Integer.toString(f_10),Integer.toString(f_09),Integer.toString(f_08),Integer.toString(f_07),Integer.toString(f_06),Integer.toString(f_05));
            add_data_rat(conn,p_rat,company,"_RAT","Z-Score",doubletostring(2,z_13),doubletostring(2,z_12),doubletostring(2,z_11),doubletostring(2,z_10),doubletostring(2,z_09),doubletostring(2,z_08),doubletostring(2,z_07),doubletostring(2,z_06),doubletostring(2,z_05));
            
            Double price_13 = IaA.close_price(company,2013);
        //add info to main menu
            
            add_searched_data_ver1(conn,p_main,company,doubletostring(2,tn_13),doubletostring(2,ckpt_13),doubletostring(2,tvtdt_13),doubletostring(2,tsnh_13),doubletostring(2,vcsh_13),
                    doubletostring(2,lttm_13),doubletostring(2,htk_13),doubletostring(2,dtdh_13),doubletostring(2,tscd_13),doubletostring(2,tsldk_13),
                    doubletostring(2,ckpt_13),doubletostring(2,tsdhk_13),doubletostring(2,ndh_13),doubletostring(2,lcpp_13),doubletostring(2,gtdtnh_13),
                    doubletostring(2,tmtscdvctsdhk_13),doubletostring(2,tvtdtck_13),doubletostring(2,lcttthdtc_13),doubletostring(2,lcttthddt_13),doubletostring(2,lcttthdkd_13),
                    doubletostring(2,ct_13),doubletostring(2,khtscd_13),doubletostring(2,ahccltg_13),"","",
                    doubletostring(2,gvbh_13),doubletostring(2,cpkhtscd_13),doubletostring(2,lg_13),doubletostring(2,lthdkd_13),doubletostring(2,lst_13),
                    doubletostring(2,ttndn_13),doubletostring(2,cptlv_13),doubletostring(2,llctm_13),doubletostring(2,tncpk_13),doubletostring(2,ltt_13),
                    doubletostring(2,dtt_13),doubletostring(2,cpbh_13+cpqldn_13),doubletostring(2,ttndn_13),doubletostring(2,sn_13),doubletostring(2,ev_13),
                    doubletostring(2,price_13));
        
        //add info for BS_Annual screening
        
            add_bs_annual(conn,p_bs_a,company,
                    doubletostring(2,tn_13),doubletostring(2,tn_12),doubletostring(2,tn_11),doubletostring(2,tn_10),doubletostring(2,tn_09),
                    doubletostring(2,ckpt_13),doubletostring(2,ckpt_12),doubletostring(2,ckpt_11),doubletostring(2,ckpt_10),doubletostring(2,ckpt_09),
                    doubletostring(2,bvps_13),doubletostring(2,bvps_12),doubletostring(2,bvps_11),doubletostring(2,bvps_10),doubletostring(2,bvps_09),
                    doubletostring(2,tvtdt_13),doubletostring(2,tvtdt_12),doubletostring(2,tvtdt_11),doubletostring(2,tvtdt_10),doubletostring(2,tvtdt_09),
                    doubletostring(2,tsnh_13),doubletostring(2,tsnh_12),doubletostring(2,tsnh_11),doubletostring(2,tsnh_10),doubletostring(2,tsnh_09),
                    doubletostring(2,nnh_13),doubletostring(2,nnh_12),doubletostring(2,nnh_11),doubletostring(2,nnh_10),doubletostring(2,nnh_09),
                    doubletostring(2,ev_13),doubletostring(2,ev_12),doubletostring(2,ev_11),doubletostring(2,ev_10),doubletostring(2,ev_09),
                    doubletostring(2,vcsh_13),doubletostring(2,vcsh_12),doubletostring(2,vcsh_11),doubletostring(2,vcsh_10),doubletostring(2,vcsh_09),
                    doubletostring(2,lttm_13),doubletostring(2,lttm_12),doubletostring(2,lttm_11),doubletostring(2,lttm_10),doubletostring(2,lttm_09),
                    doubletostring(2,htk_13),doubletostring(2,htk_12),doubletostring(2,htk_11),doubletostring(2,htk_10),doubletostring(2,htk_09),
                    doubletostring(2,ndh_13),doubletostring(2,ndh_12),doubletostring(2,ndh_11),doubletostring(2,ndh_10),doubletostring(2,ndh_09),
                    doubletostring(2,dtdh_13),doubletostring(2,dtdh_12),doubletostring(2,dtdh_11),doubletostring(2,dtdh_10),doubletostring(2,dtdh_09),
                    doubletostring(2,tscd_13),doubletostring(2,tscd_12),doubletostring(2,tscd_11),doubletostring(2,tscd_10),doubletostring(2,tscd_09),
                    doubletostring(2,tsldk_13),doubletostring(2,tsldk_12),doubletostring(2,tsldk_11),doubletostring(2,tsldk_10),doubletostring(2,tsldk_09),
                    doubletostring(2,ckpt_13),doubletostring(2,ckpt_12),doubletostring(2,ckpt_11),doubletostring(2,ckpt_10),doubletostring(2,ckpt_09),
                    doubletostring(2,tsdhk_13),doubletostring(2,tsdhk_12),doubletostring(2,tsdhk_11),doubletostring(2,tsdhk_10),doubletostring(2,tsdhk_09),
                    doubletostring(2,ndh_13),doubletostring(2,ndh_12),doubletostring(2,ndh_11),doubletostring(2,ndh_10),doubletostring(2,ndh_09),
                    doubletostring(2,lcpp_13),doubletostring(2,lcpp_12),doubletostring(2,lcpp_11),doubletostring(2,lcpp_10),doubletostring(2,lcpp_09),
                    doubletostring(2,nnh_13),doubletostring(2,nnh_12),doubletostring(2,nnh_11),doubletostring(2,nnh_10),doubletostring(2,nnh_09),
                    doubletostring(2,gtdtnh_13),doubletostring(2,gtdtnh_12),doubletostring(2,gtdtnh_11),doubletostring(2,gtdtnh_10),doubletostring(2,gtdtnh_09),
                    doubletostring(2,tts_13),doubletostring(2,tts_12),doubletostring(2,tts_11),doubletostring(2,tts_10),doubletostring(2,tts_09),
                    doubletostring(2,tn_13),doubletostring(2,tn_12),doubletostring(2,tn_11),doubletostring(2,tn_10),doubletostring(2,tn_09),
                    doubletostring(2,wc_13),doubletostring(2,wc_12),doubletostring(2,wc_11),doubletostring(2,wc_10),doubletostring(2,wc_09));
        
        
            //add info to cfs_annual
            add_cfs_annual(conn,p_cfs_a,company,
                    doubletostring(2,tmtscdvctsdhk_13),doubletostring(2,tmtscdvctsdhk_12),doubletostring(2,tmtscdvctsdhk_11),doubletostring(2,tmtscdvctsdhk_10),doubletostring(2,tmtscdvctsdhk_09),
                    doubletostring(2,tvtdtck_13),doubletostring(2,tvtdtck_12),doubletostring(2,tvtdtck_11),doubletostring(2,tvtdtck_10),doubletostring(2,tvtdtck_09),
                    doubletostring(2,cfps_13),doubletostring(2,cfps_12),doubletostring(2,cfps_11),doubletostring(2,cfps_10),doubletostring(2,cfps_09),
                    doubletostring(2,lcttthdtc_13),doubletostring(2,lcttthdtc_12),doubletostring(2,lcttthdtc_11),doubletostring(2,lcttthdtc_10),doubletostring(2,lcttthdtc_09),
                    doubletostring(2,lcttthddt_13),doubletostring(2,lcttthddt_12),doubletostring(2,lcttthddt_11),doubletostring(2,lcttthddt_10),doubletostring(2,lcttthddt_09),
                    doubletostring(2,lcttthdkd_13),doubletostring(2,lcttthdkd_12),doubletostring(2,lcttthdkd_11),doubletostring(2,lcttthdkd_10),doubletostring(2,lcttthdkd_09),
                    doubletostring(2,ct_13),doubletostring(2,ct_12),doubletostring(2,ct_11),doubletostring(2,ct_10),doubletostring(2,ct_09),
                    doubletostring(2,khtscd_13),doubletostring(2,khtscd_12),doubletostring(2,khtscd_11),doubletostring(2,khtscd_10),doubletostring(2,khtscd_09),
                    doubletostring(2,ahccltg_13),doubletostring(2,ahccltg_12),doubletostring(2,ahccltg_11),doubletostring(2,ahccltg_10),doubletostring(2,ahccltg_09),
                    doubletostring(2,fcfps_13),doubletostring(2,fcfps_12),doubletostring(2,fcfps_11),doubletostring(2,fcfps_10),doubletostring(2,fcfps_09));
        
            //add info to is_annual
            add_is_annual(conn,p_is_a,company,
                    doubletostring(2,gvbh_13),doubletostring(2,gvbh_12),doubletostring(2,gvbh_11),doubletostring(2,gvbh_10),doubletostring(2,gvbh_09),
                    doubletostring(2,cpkhtscd_13),doubletostring(2,cpkhtscd_12),doubletostring(2,cpkhtscd_11),doubletostring(2,cpkhtscd_10),doubletostring(2,cpkhtscd_09),
                    doubletostring(2,ebit_13),doubletostring(2,ebit_12),doubletostring(2,ebit_11),doubletostring(2,ebit_10),doubletostring(2,ebit_09),
                    doubletostring(2,ebitda_13),doubletostring(2,ebitda_12),doubletostring(2,ebitda_11),doubletostring(2,ebitda_10),doubletostring(2,ebitda_09),
                    doubletostring(2,eps_13),doubletostring(2,eps_12),doubletostring(2,eps_11),doubletostring(2,eps_10),doubletostring(2,eps_09),
                    doubletostring(2,lg_13),doubletostring(2,lg_12),doubletostring(2,lg_11),doubletostring(2,lg_10),doubletostring(2,lg_09),
                    doubletostring(2,lthdkd_13),doubletostring(2,lthdkd_12),doubletostring(2,lthdkd_11),doubletostring(2,lthdkd_10),doubletostring(2,lthdkd_09),
                    doubletostring(2,lst_13),doubletostring(2,lst_12),doubletostring(2,lst_11),doubletostring(2,lst_10),doubletostring(2,lst_09),
                    doubletostring(2,ttndn_13),doubletostring(2,ttndn_12),doubletostring(2,ttndn_11),doubletostring(2,ttndn_10),doubletostring(2,ttndn_09),
                    doubletostring(2,cptlv_13),doubletostring(2,cptlv_12),doubletostring(2,cptlv_11),doubletostring(2,cptlv_10),doubletostring(2,cptlv_09),
                    doubletostring(2,llctm_13),doubletostring(2,llctm_12),doubletostring(2,llctm_11),doubletostring(2,llctm_10),doubletostring(2,llctm_09),
                    doubletostring(2,tncpk_13),doubletostring(2,tncpk_12),doubletostring(2,tncpk_11),doubletostring(2,tncpk_10),doubletostring(2,tncpk_09),
                    doubletostring(2,ltt_13),doubletostring(2,ltt_12),doubletostring(2,ltt_11),doubletostring(2,ltt_10),doubletostring(2,ltt_09),
                    doubletostring(2,dtt_13),doubletostring(2,dtt_12),doubletostring(2,dtt_11),doubletostring(2,dtt_10),doubletostring(2,dtt_09),
                    doubletostring(2,cpbhcpqldn_13),doubletostring(2,cpbhcpqldn_12),doubletostring(2,cpbhcpqldn_11),doubletostring(2,cpbhcpqldn_10),doubletostring(2,cpbhcpqldn_09));
            
            
            p_percent.executeBatch();
            p_rat.executeBatch();
            p_val.executeBatch();
            p_mul.executeBatch();
        } catch (FileNotFoundException e) {
            System.out.println(company+" not found");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                    
       
        if (prestatement != null) try{prestatement.close();} catch(Exception ignore) {}
                }
    }
    // add the data to the database
     public void add_data(Connection conn, PreparedStatement prestatement, String name,String part, String clause, String ad_13, String ad_12, String ad_11, String ad_10, String ad_09, String ad_08, String ad_07, String ad_06, String ad_05) throws SQLException {
        
        
       prestatement = conn.prepareStatement("INSERT INTO `"+name+part+"` (`clause`, `2013`, `2012`, `2011`, `2010`, `2009`, `2008`, `2007`, `2006`, `2005`) VALUES(N?,?,?,?,?,?,?,?,?,?);");
        
       prestatement.setString(1, clause);
       prestatement.setString(2, ad_13);
       prestatement.setString(3, ad_12);
       prestatement.setString(4, ad_11);
       prestatement.setString(5, ad_10);
       prestatement.setString(6, ad_09);
       prestatement.setString(7, ad_08);
       prestatement.setString(8, ad_07);
       prestatement.setString(9, ad_06);
       prestatement.setString(10, ad_05);
       
       prestatement.executeUpdate();
       
    }
     public void add_data2(Connection conn, PreparedStatement prestatement, String name,String part, String clause, String ad_13, String ad_12, String ad_11, String ad_10, String ad_09, String ad_08, String ad_07, String ad_06, String ad_05) throws SQLException {
        
       prestatement.setString(1, clause);
       prestatement.setString(2, ad_13);
       prestatement.setString(3, ad_12);
       prestatement.setString(4, ad_11);
       prestatement.setString(5, ad_10);
       prestatement.setString(6, ad_09);
       prestatement.setString(7, ad_08);
       prestatement.setString(8, ad_07);
       prestatement.setString(9, ad_06);
       prestatement.setString(10, ad_05);
       
       prestatement.addBatch();
       
    }
     public void add_data_rat(Connection conn, PreparedStatement prestatement, String name,String part, String clause, String ad_13, String ad_12, String ad_11, String ad_10, String ad_09, String ad_08, String ad_07, String ad_06, String ad_05) throws SQLException {
        
       
        
       prestatement.setString(1, clause);
       prestatement.setString(2, ad_13);
       prestatement.setString(3, ad_12);
       prestatement.setString(4, ad_11);
       prestatement.setString(5, ad_10);
       prestatement.setString(6, ad_09);
       prestatement.setString(7, ad_08);
       prestatement.setString(8, ad_07);
       prestatement.setString(9, ad_06);
       prestatement.setString(10, ad_05);
       
        prestatement.addBatch();
       
    }
     public void add_data_mult(Connection conn, PreparedStatement prestatement, String name,String part, String clause, String ad_13, String ad_12, String ad_11, String ad_10, String ad_09, String ad_08, String ad_07, String ad_06, String ad_05) throws SQLException {
        
        
        
       prestatement.setString(1, clause);
       prestatement.setString(2, ad_13);
       prestatement.setString(3, ad_12);
       prestatement.setString(4, ad_11);
       prestatement.setString(5, ad_10);
       prestatement.setString(6, ad_09);
       prestatement.setString(7, ad_08);
       
        prestatement.addBatch();
       
    }
    // add the result of change() to the db
    public void add_change(Connection conn, PreparedStatement prestatement, String name,String part, String clause, String ad_13, String ad_12, String ad_11, String ad_10, String ad_09, String ad_08, String ad_07, String ad_06, String ad_05) throws SQLException {
        
        prestatement = conn.prepareStatement("INSERT INTO `FINA_"+name+part+"` (`clause`, `2013`, `2012`, `2011`, `2010`, `2009`, `2008`, `2007`, `2006`, `2005`) VALUES(N?,?,?,?,?,?,?,?,?,?);");
        
       prestatement.setString(1, clause);
       prestatement.setString(2, ad_13);
       prestatement.setString(3, ad_12);
       prestatement.setString(4, ad_11);
       prestatement.setString(5, ad_10);
       prestatement.setString(6, ad_09);
       prestatement.setString(7, ad_08);
       prestatement.setString(8, ad_07);
       prestatement.setString(9, ad_06);
       prestatement.setString(10, ad_05);
       
        prestatement.executeUpdate();
       
    }
    
    
    
    public void add_searched_data_ver1(Connection conn, PreparedStatement prestatement, String name, String npt,String ckpt,String tvtdt,String tsnh,
            String vcsh, String lttm,String htk,String dtdh,String tscd,
            String tsldk, String ptk,String tsdhk,String ndhk,String lcpp, String gtdtnh, String tmtscdvctsdhk,String tvtdtck, String lcttthdtc,String lcttthddt,String lcttthdkd,String ct,
            String khtscd, String ahccltg,String earningestimate,String growthrate,
            String gvbh, String cpkhtscd, String lg,String lthdkd,
            String lst,String ttndnhthl, String tdcptlv, String lltctm,String tncpk,
            String lltt,String dtt, String cpbhcpqldn, String ttn,String slcpdlh,
            String ev,String price) throws SQLException {
        
       prestatement.setString(1, name);
       prestatement.setString(2, npt);
       prestatement.setString(3, ckpt);
       prestatement.setString(4, tvtdt);
       prestatement.setString(5, tsnh);
       prestatement.setString(6, vcsh);
       prestatement.setString(7, lttm);
       prestatement.setString(8, htk);
       prestatement.setString(9, dtdh);
       prestatement.setString(10, tscd);
       prestatement.setString(11, tsldk);
       prestatement.setString(12, ptk);
       prestatement.setString(13, tsdhk);
       prestatement.setString(14, ndhk);
       prestatement.setString(15, lcpp);
       prestatement.setString(16, gtdtnh);
       prestatement.setString(17, tmtscdvctsdhk);
       prestatement.setString(18, tvtdtck);
       prestatement.setString(19, lcttthdtc);
       prestatement.setString(20, lcttthddt);
       prestatement.setString(21, lcttthdkd);
       prestatement.setString(22, ct);
       prestatement.setString(23, khtscd);
       prestatement.setString(24, ahccltg);
       prestatement.setString(25, earningestimate);
       prestatement.setString(26, growthrate);
       prestatement.setString(27, gvbh);
       prestatement.setString(28, cpkhtscd);
       prestatement.setString(29, lg);
       prestatement.setString(30, lthdkd);
       prestatement.setString(31, lst);
       prestatement.setString(32, ttndnhthl);
       prestatement.setString(33, tdcptlv);
       prestatement.setString(34, lltctm);
       prestatement.setString(35, tncpk);
       prestatement.setString(36, lltt);
       prestatement.setString(37, dtt);
       prestatement.setString(38, cpbhcpqldn);
       prestatement.setString(39, ttn);
       prestatement.setString(40, slcpdlh);
       prestatement.setString(41,  ev);
       prestatement.setString(42,  price);
       
       
      prestatement.addBatch();
       
       
       
       
       
       
       
        
    }
    public void add_company(Connection conn,PreparedStatement prestatement, String name,String part) throws SQLException//creating templates for prepared statement
    {
       
        prestatement = conn.prepareStatement ("DROP TABLE IF EXISTS `"+name+part+"`;");
        prestatement.executeUpdate();
        prestatement = conn.prepareStatement ("CREATE TABLE `"+name+part+"` ( ID INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL, `clause` VARCHAR(255) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci, `2013` VARCHAR(255), `2012` VARCHAR(255), `2011` VARCHAR(255), `2010` VARCHAR(255), `2009` VARCHAR(255), `2008` VARCHAR(255), `2007` VARCHAR(255), `2006` VARCHAR(255), `2005` VARCHAR(255))");
       
     
      prestatement.executeUpdate();
        
    }
    
    
    public static void add_company_mult(Connection conn,PreparedStatement prestatement, String name,String part) throws SQLException//creating templates for prepared statement
    {
       prestatement = conn.prepareStatement ("DROP TABLE IF EXISTS `FINA_"+name+part+"`;");
       prestatement.executeUpdate();
       prestatement = conn.prepareStatement ("CREATE TABLE `FINA_"+ name+part+ "` ( ID INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL, `clause` VARCHAR(255) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci, `Current` VARCHAR(255), `1 Year Ago` VARCHAR(255), `2 Years Ago` VARCHAR(255), `3 Years Ago` VARCHAR(255), `Average 3 Years` VARCHAR(255), `Average 5 Years` VARCHAR(255))");
       prestatement.executeUpdate();
        
    }
     public void add_company_rat(Connection conn,PreparedStatement prestatement, String name,String part) throws SQLException//creating templates for prepared statement
    {
       prestatement = conn.prepareStatement ("DROP TABLE IF EXISTS `FINA_"+name+part+"`;");
       prestatement.executeUpdate();
       prestatement = conn.prepareStatement ("CREATE TABLE `FINA_"+ name+part+ "` ( ID INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL, `clause` VARCHAR(255) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci, `Current` VARCHAR(255), `1 Year Ago` VARCHAR(255), `2 Years Ago` VARCHAR(255), `3 Years Ago` VARCHAR(255), `4 Years Ago` VARCHAR(255), `5 Years Ago` VARCHAR(255), `6 Years Ago` VARCHAR(255), `7 Years Ago` VARCHAR(255), `8 Years Ago` VARCHAR(255))");
       prestatement.executeUpdate();
        
    }
     public static void add_data_val(Connection conn, PreparedStatement prestatement, String name,String part, String clause, String ad_13, String ad_12, String ad_11, String ad_10, String ad_09) throws SQLException {
        
        
        
       prestatement.setString(1, clause);
       prestatement.setString(2, ad_13);
       prestatement.setString(3, ad_12);
       prestatement.setString(4, ad_11);
       prestatement.setString(5, ad_10);
       prestatement.setString(6, ad_09);
       
       prestatement.addBatch();
       
    }
    public void add_company_val(Connection conn,PreparedStatement prestatement, String name,String part) throws SQLException//creating templates for prepared statement
    {
       prestatement = conn.prepareStatement ("DROP TABLE IF EXISTS `FINA_"+name+part+"`;");
       prestatement.executeUpdate();
       prestatement = conn.prepareStatement ("CREATE TABLE `FINA_"+ name+part+ "` ( ID INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL, `clause` VARCHAR(255) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci, `EPS` VARCHAR(255), `Dividend` VARCHAR(255), `Cashflow` VARCHAR(255), `Free Cashflow` VARCHAR(255), `Sales` VARCHAR(255))");
       prestatement.executeUpdate();
       
       
       
        
    }
     public void add_bs_annual(Connection conn,PreparedStatement prestatement, String name,String npt1,String npt2,String npt3,String npt4,String npt5,
             String ckpt1,String ckpt2,String ckpt3,String ckpt4,String ckpt5,
             String bvs1,String bvs2,String bvs3,String bvs4,String bvs5,
             String tvtdt1,String tvtdt2,String tvtdt3,String tvtdt4,String tvtdt5,
             String tsnh1,String tsnh2,String tsnh3,String tsnh4,String tsnh5,
             String nnh1,String nnh2,String nnh3,String nnh4,String nnh5,
             String ev1,String ev2,String ev3,String ev4,String ev5,
             String vcsh1,String vcsh2,String vcsh3,String vcsh4,String vcsh5,
             String lttm1,String lttm2,String lttm3,String lttm4,String lttm5,
             String htk1,String htk2,String htk3,String htk4,String htk5,
             String ndh1,String ndh2,String ndh3,String ndh4,String ndh5,
             String dtdh1,String dtdh2,String dtdh3,String dtdh4,String dtdh5,
             String tscd1,String tscd2,String tscd3,String tscd4,String tscd5,
             String tsldk1,String tsldk2,String tsldk3,String tsldk4,String tsldk5,
             String ptk1,String ptk2,String ptk3,String ptk4,String ptk5,
             String tsdhk1,String tsdhk2,String tsdhk3,String tsdhk4,String tsdhk5,
             String ndhk1,String ndhk2,String ndhk3,String ndhk4,String ndhk5,
             String lcpp1,String lcpp2,String lcpp3,String lcpp4,String lcpp5,
             String nonh1,String nonh2,String nonh3,String nonh4,String nonh5,
             String gtdtnh1,String gtdtnh2,String gtdtnh3,String gtdtnh4,String gtdtnh5,
             String tts1,String tts2,String tts3,String tts4,String tts5,
             String tn1,String tn2,String tn3,String tn4,String tn5,
             String wc1,String wc2,String wc3,String wc4,String wc5) throws SQLException //creating templates for prepared statement 
    {
       
      
       prestatement.setString(1, name);
       prestatement.setString(2, npt1);
       prestatement.setString(3, npt2);
       prestatement.setString(4, npt3);
       prestatement.setString(5, npt4);
       prestatement.setString(6, npt5);
       prestatement.setString(7, ckpt1);
       prestatement.setString(8, ckpt2);
       prestatement.setString(9, ckpt3);
       prestatement.setString(10, ckpt4);
       prestatement.setString(11, ckpt5);
       prestatement.setString(12, bvs1);
       prestatement.setString(13, bvs2);
       prestatement.setString(14, bvs3);
       prestatement.setString(15, bvs4);
       prestatement.setString(16, bvs5);
       prestatement.setString(17, tvtdt1);
       prestatement.setString(18, tvtdt2);
       prestatement.setString(19, tvtdt3);
       prestatement.setString(20, tvtdt4);
       prestatement.setString(21, tvtdt5);
       prestatement.setString(22, tsnh1);
       prestatement.setString(23, tsnh2);
       prestatement.setString(24, tsnh3);
       prestatement.setString(25, tsnh4);
       prestatement.setString(26, tsnh5);
       prestatement.setString(27, nnh1);
       prestatement.setString(28, nnh2);
       prestatement.setString(29, nnh3);
       prestatement.setString(30, nnh4);
       prestatement.setString(31, nnh5);
       prestatement.setString(32, ev1);
       prestatement.setString(33, ev2);
       prestatement.setString(34, ev3);
       prestatement.setString(35, ev4);
       prestatement.setString(36, ev5);
       prestatement.setString(37, vcsh1);
       prestatement.setString(38, vcsh2);
       prestatement.setString(39, vcsh3);
       prestatement.setString(40, vcsh4);
       prestatement.setString(41, vcsh5);
       prestatement.setString(42, lttm1);
       prestatement.setString(43, lttm2);
       prestatement.setString(44, lttm3);
       prestatement.setString(45, lttm4);
       prestatement.setString(46, lttm5);
       prestatement.setString(47, htk1);
       prestatement.setString(48, htk2);
       prestatement.setString(49, htk3);
       prestatement.setString(50, htk4);
       prestatement.setString(51, htk5);
       prestatement.setString(52, ndh1);
       prestatement.setString(53, ndh2);
       prestatement.setString(54, ndh3);
       prestatement.setString(55, ndh4);
       prestatement.setString(56, ndh5);
       prestatement.setString(57, dtdh1);
       prestatement.setString(58, dtdh2);
       prestatement.setString(59, dtdh3);
       prestatement.setString(60, dtdh4);
       prestatement.setString(61, dtdh5);
       prestatement.setString(62, tscd1);
       prestatement.setString(63, tscd2);
       prestatement.setString(64, tscd3);
       prestatement.setString(65, tscd4);
       prestatement.setString(66, tscd5);
       prestatement.setString(67, tsldk1);
       prestatement.setString(68, tsldk2);
       prestatement.setString(69, tsldk3);
       prestatement.setString(70, tsldk4);
       prestatement.setString(71, tsldk5);
       prestatement.setString(72, ptk1);
       prestatement.setString(73, ptk2);
       prestatement.setString(74, ptk3);
       prestatement.setString(75, ptk4);
       prestatement.setString(76, ptk5);
       prestatement.setString(77, tsdhk1);
       prestatement.setString(78, tsdhk2);
       prestatement.setString(79, tsdhk3);
       prestatement.setString(80, tsdhk4);
       prestatement.setString(81, tsdhk5);
       prestatement.setString(82, ndhk1);
       prestatement.setString(83, ndhk2);
       prestatement.setString(84, ndhk3);
       prestatement.setString(85, ndhk4);
       prestatement.setString(86, ndhk5);
       prestatement.setString(87, lcpp1);
       prestatement.setString(88, lcpp2);
       prestatement.setString(89, lcpp3);
       prestatement.setString(90, lcpp4);
       prestatement.setString(91, lcpp5);
       prestatement.setString(92, nonh1);
       prestatement.setString(93, nonh2);
       prestatement.setString(94, nonh3);
       prestatement.setString(95, nonh4);
       prestatement.setString(96, nonh5);
       prestatement.setString(97, gtdtnh1);
       prestatement.setString(98, gtdtnh2);
       prestatement.setString(99, gtdtnh3);
       prestatement.setString(100, gtdtnh4);
       prestatement.setString(101,gtdtnh5 );
       prestatement.setString(102, tts1);
       prestatement.setString(103, tts2);
       prestatement.setString(104, tts3);
       prestatement.setString(105, tts4);
       prestatement.setString(106, tts5);
       prestatement.setString(107, tn1);
       prestatement.setString(108, tn2);
       prestatement.setString(109, tn3);
       prestatement.setString(110, tn4);
       prestatement.setString(111, tn5);
       prestatement.setString(112, wc1);
       prestatement.setString(113, wc2);
       prestatement.setString(114, wc3);
       prestatement.setString(115, wc4);
       prestatement.setString(116, wc5);
       
      
       prestatement.addBatch();
        
    }
     
     
    public void add_cfs_annual(Connection conn,PreparedStatement prestatement, String company,
            String tmtscdvctsdhk1, String tmtscdvctsdhk2, String tmtscdvctsdhk3, String tmtscdvctsdhk4, String tmtscdvctsdhk5,
             String tvtdtcky1,String tvtdtcky2,String tvtdtcky3,String tvtdtcky4,String tvtdtcky5,
             String cfps1,String cfps2,String cfps3,String cfps4,String cfps5,
             String lcttthdtc1,String lcttthdtc2,String lcttthdtc3,String lcttthdtc4,String lcttthdtc5,
             String lcttthddt1,String lcttthddt2,String lcttthddt3,String lcttthddt4,String lcttthddt5,
             String lcttthdkd1,String lcttthdkd2,String lcttthdkd3,String lcttthdkd4,String lcttthdkd5,
             String ct1,String ct2,String ct3,String ct4,String ct5,
             String khtscd1,String khtscd2,String khtscd3,String khtscd4,String khtscd5,
             String ahccltg1,String ahccltg2,String ahccltg3,String ahccltg4,String ahccltg5,
             String fcfps1,String fcfps2,String fcfps3,String fcfps4,String fcfps5) throws SQLException {
        
       
        prestatement.setString(1, company);
       prestatement.setString(2, tmtscdvctsdhk1);
       prestatement.setString(3, tmtscdvctsdhk2);
       prestatement.setString(4, tmtscdvctsdhk3);
       prestatement.setString(5, tmtscdvctsdhk4);
       prestatement.setString(6, tmtscdvctsdhk5);
       prestatement.setString(7, tvtdtcky1);
       prestatement.setString(8, tvtdtcky2);
       prestatement.setString(9, tvtdtcky3);
       prestatement.setString(10, tvtdtcky4);
       prestatement.setString(11, tvtdtcky5);
       prestatement.setString(12, cfps1);
       prestatement.setString(13, cfps2);
       prestatement.setString(14, cfps3);
       prestatement.setString(15, cfps4);
       prestatement.setString(16, cfps5);
       prestatement.setString(17, lcttthdtc1);
       prestatement.setString(18, lcttthdtc2);
       prestatement.setString(19, lcttthdtc3);
       prestatement.setString(20, lcttthdtc4);
       prestatement.setString(21, lcttthdtc5);
       prestatement.setString(22, lcttthddt1);
       prestatement.setString(23, lcttthddt2);
       prestatement.setString(24, lcttthddt3);
       prestatement.setString(25, lcttthddt4);
       prestatement.setString(26, lcttthddt5);
       prestatement.setString(27, lcttthdkd1);
       prestatement.setString(28, lcttthdkd2);
       prestatement.setString(29, lcttthdkd3);
       prestatement.setString(30, lcttthdkd4);
       prestatement.setString(31, lcttthdkd5);
       prestatement.setString(32, ct1);
       prestatement.setString(33, ct2);
       prestatement.setString(34, ct3);
       prestatement.setString(35, ct4);
       prestatement.setString(36, ct5);
       prestatement.setString(37, khtscd1);
       prestatement.setString(38, khtscd2);
       prestatement.setString(39, khtscd3);
       prestatement.setString(40, khtscd4);
       prestatement.setString(41, khtscd5);
       prestatement.setString(42, ahccltg1);
       prestatement.setString(43, ahccltg2);
       prestatement.setString(44, ahccltg3);
       prestatement.setString(45, ahccltg4);
       prestatement.setString(46, ahccltg5);
       prestatement.setString(47, fcfps1);
       prestatement.setString(48, fcfps2);
       prestatement.setString(49, fcfps3);
       prestatement.setString(50, fcfps4);
       prestatement.setString(51, fcfps5);
        
        
        prestatement.addBatch();
        
    }
            
    
    public void add_is_annual(Connection conn,PreparedStatement prestatement, String company,
            String gvbh1,String gvbh2,String gvbh3,String gvbh4,String gvbh5,
            String cpkhtscd1,String cpkhtscd2,String cpkhtscd3,String cpkhtscd4,String cpkhtscd5,
            String ebit1,String ebit2,String ebit3,String ebit4,String ebit5,
            String ebitda1,String ebitda2,String ebitda3,String ebitda4,String ebitda5,
            String eps1,String eps2,String eps3,String eps4,String eps5,
            String lg1,String lg2,String lg3,String lg4,String lg5,
            String lthdkd1,String lthdkd2,String lthdkd3,String lthdkd4,String lthdkd5,
            String lst1,String lst2,String lst3,String lst4,String lst5,
            String ttndn1,String ttndn2,String ttndn3,String ttndn4,String ttndn5,
            String cptlv1,String cptlv2,String cptlv3,String cptlv4,String cptlv5,
            String lltctm1,String lltctm2,String lltctm3,String lltctm4,String lltctm5,
            String tncpk1,String tncpk2,String tncpk3,String tncpk4,String tncpk5,
            String ltt1,String ltt2,String ltt3,String ltt4,String ltt5,
            String dtt1,String dtt2,String dtt3,String dtt4,String dtt5,
            String cpbhcpqldn1,String cpbhcpqldn2,String cpbhcpqldn3,String cpbhcpqldn4,String cpbhcpqldn5) throws SQLException {
        
        
        
        prestatement.setString(1, company);
       prestatement.setString(2, gvbh1);
       prestatement.setString(3, gvbh2);
       prestatement.setString(4, gvbh3);
       prestatement.setString(5, gvbh4);
       prestatement.setString(6, gvbh5);
       prestatement.setString(7, cpkhtscd1);
       prestatement.setString(8, cpkhtscd2);
       prestatement.setString(9, cpkhtscd3);
       prestatement.setString(10, cpkhtscd4);
       prestatement.setString(11, cpkhtscd5);
       prestatement.setString(12, ebit1);
       prestatement.setString(13, ebit2);
       prestatement.setString(14, ebit3);
       prestatement.setString(15, ebit4);
       prestatement.setString(16, ebit5);
       prestatement.setString(17, ebitda1);
       prestatement.setString(18, ebitda2);
       prestatement.setString(19, ebitda3);
       prestatement.setString(20, ebitda4);
       prestatement.setString(21, ebitda5);
       prestatement.setString(22, eps1);
       prestatement.setString(23, eps2);
       prestatement.setString(24, eps3);
       prestatement.setString(25, eps4);
       prestatement.setString(26, eps5);
       prestatement.setString(27, lg1);
       prestatement.setString(28, lg2);
       prestatement.setString(29, lg3);
       prestatement.setString(30, lg4);
       prestatement.setString(31, lg5);
       prestatement.setString(32, lthdkd1);
       prestatement.setString(33, lthdkd2);
       prestatement.setString(34, lthdkd3);
       prestatement.setString(35, lthdkd4);
       prestatement.setString(36, lthdkd5);
       prestatement.setString(37, lst1);
       prestatement.setString(38, lst2);
       prestatement.setString(39, lst3);
       prestatement.setString(40, lst4);
       prestatement.setString(41, lst5);
       prestatement.setString(42, ttndn1);
       prestatement.setString(43, ttndn2);
       prestatement.setString(44, ttndn3);
       prestatement.setString(45, ttndn4);
       prestatement.setString(46, ttndn5);
       prestatement.setString(47, cptlv1);
       prestatement.setString(48, cptlv2);
       prestatement.setString(49, cptlv3);
       prestatement.setString(50, cptlv4);
       prestatement.setString(51, cptlv5);
       prestatement.setString(52, lltctm1);
       prestatement.setString(53, lltctm2);
       prestatement.setString(54, lltctm3);
       prestatement.setString(55, lltctm4);
       prestatement.setString(56, lltctm5);
       prestatement.setString(57, tncpk1);
       prestatement.setString(58, tncpk2);
       prestatement.setString(59, tncpk3);
       prestatement.setString(60, tncpk4);
       prestatement.setString(61, tncpk5);
       prestatement.setString(62, ltt1);
       prestatement.setString(63, ltt2);
       prestatement.setString(64, ltt3);
       prestatement.setString(65, ltt4);
       prestatement.setString(66, ltt5);
       prestatement.setString(67, dtt1);
       prestatement.setString(68, dtt2);
       prestatement.setString(69, dtt3);
       prestatement.setString(70, dtt4);
       prestatement.setString(71, dtt5);
       prestatement.setString(72, cpbhcpqldn1);
       prestatement.setString(73, cpbhcpqldn2);
       prestatement.setString(74, cpbhcpqldn3);
       prestatement.setString(75, cpbhcpqldn4);
       prestatement.setString(76, cpbhcpqldn5);
       
       
        prestatement.addBatch();
        
        
    }
            
            
    //return latest close price in the year of a company 
     public Double close_price (String name, Integer year) {
         String csvFilename = "C:\\Users\\tri\\Google Drive\\Data\\EXCEL_"+name+".csv";
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
// calculate the annual percentage change of a company
     public static String change (String numer,String deno) {
       Double rs = 0.0;  
       
       try {
           
           if (numer.equals("N/A") || numer.equals("-")) {
               numer = "0.0";
           }
           if (deno.equals("N/A") || deno.equals("-")) {
               deno = "0.0";
           }
           
           numer = dtcm(numer);
           deno = dtcm(deno);
           
         if (("0.0").equals(doubletostring(1,Double.parseDouble(deno)))) {
             rs = 0.0;
         } else {
             rs = (Double.parseDouble(numer)-Double.parseDouble(deno))/Double.parseDouble(deno)*100;
         }
       } catch(Exception e) {
        e.printStackTrace();
       }finally {
             
           return doubletostring(2,rs);
       }
    }
     public static void add_percent_change(Connection conn, PreparedStatement prestatement, String name,String part, String clause, String output_13, String output_12, String output_11, String output_10, String output_09
     , String output_08, String output_07, String output_06, String output_05) throws SQLException {
        
       
        
         
        
       prestatement.setString(1, clause);
       prestatement.setString(2, change(output_13,output_12));
       prestatement.setString(3, change(output_12,output_11));
       prestatement.setString(4, change(output_11,output_10));
       prestatement.setString(5, change(output_10,output_09));
       prestatement.setString(6, change(output_09,output_08));
       prestatement.setString(7, change(output_08,output_07));
       prestatement.setString(8, change(output_07,output_06));
       prestatement.setString(9, change(output_06,output_05));
       prestatement.setString(10
               , "N/A");
       
        prestatement.addBatch();
       
    }
     public static String dtcm(String currency) throws Exception {
         
         if (currency == null) {
             return "0.0";
         }
    
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
     
    public static String doubletostring(int dp, Double value) {
        try {
        if (dp < 0) throw new IllegalArgumentException();

         BigDecimal bd = new BigDecimal(value);
         bd = bd.setScale(dp, RoundingMode.HALF_UP);
       return bd.toString();
        }
        catch (NumberFormatException e) {//this is for Infinite or NaN case (denominator = 0)
            return "N/A";
        }
    } 
}

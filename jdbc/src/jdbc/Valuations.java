/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author tri
 */
public class Valuations {
    
    public static void main(String[] args) throws Exception {
        Valuations obj = new Valuations();
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
    
    
    
    static void run(String company) throws Exception {
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
    Integer year = 2015;
     try {
       Class.forName(driver).newInstance();
       conn = DriverManager.getConnection(url+dbName,userName,password);
       add_company_val(conn,prestatement,company,"_VAL");
      
       Import_all_Annual IaA = new Import_all_Annual();
      IS is = new IS();
    BS bs = new BS();
    CFS cfs = new CFS();
    FI fi = new FI();
  
    /////////////////////////// IS
   
    
    
    
    
    //Doanh thu thuần
    Double dtt_05 = Double.parseDouble(rs(is.read_IS(company,5,2005)));
    Double dtt_06 = Double.parseDouble(rs(is.read_IS(company,5,2006)));
    Double dtt_07 = Double.parseDouble(rs(is.read_IS(company,5,2007)));
    Double dtt_08 = Double.parseDouble(rs(is.read_IS(company,5,2008)));
    Double dtt_09 = Double.parseDouble(rs(is.read_IS(company,5,2009)));
    Double dtt_10 = Double.parseDouble(rs(is.read_IS(company,5,2010)));
    Double dtt_11 = Double.parseDouble(rs(is.read_IS(company,5,2011)));
    Double dtt_12 = Double.parseDouble(rs(is.read_IS(company,5,2012)));
    Double dtt_13 = Double.parseDouble(rs(is.read_IS(company,5,2013)));
    //Lãi gộp
    Double lg_05 = Double.parseDouble(rs(is.read_IS(company,7,2005)));
    Double lg_06 = Double.parseDouble(rs(is.read_IS(company,7,2006)));
    Double lg_07 = Double.parseDouble(rs(is.read_IS(company,7,2007)));
    Double lg_08 = Double.parseDouble(rs(is.read_IS(company,7,2008)));
    Double lg_09 = Double.parseDouble(rs(is.read_IS(company,7,2009)));
    Double lg_10 = Double.parseDouble(rs(is.read_IS(company,7,2010)));
    Double lg_11 = Double.parseDouble(rs(is.read_IS(company,7,2011)));
    Double lg_12 = Double.parseDouble(rs(is.read_IS(company,7,2012)));
    Double lg_13 = Double.parseDouble(rs(is.read_IS(company,7,2013)));
    //Chi phí tiền lãi vay
    Double cptlv_05 = Double.parseDouble(rs(is.read_IS(company,11,2005)));
    Double cptlv_06 = Double.parseDouble(rs(is.read_IS(company,11,2006)));
    Double cptlv_07 = Double.parseDouble(rs(is.read_IS(company,11,2007)));
    Double cptlv_08 = Double.parseDouble(rs(is.read_IS(company,11,2008)));
    Double cptlv_09 = Double.parseDouble(rs(is.read_IS(company,11,2009)));
    Double cptlv_10 = Double.parseDouble(rs(is.read_IS(company,11,2010)));
    Double cptlv_11 = Double.parseDouble(rs(is.read_IS(company,11,2011)));
    Double cptlv_12 = Double.parseDouble(rs(is.read_IS(company,11,2012)));
    Double cptlv_13 = Double.parseDouble(rs(is.read_IS(company,11,2013)));
    
     //Lãi trước thuế
    Double ltt_05 = Double.parseDouble(rs(is.read_IS(company,17,2005)));
    Double ltt_06 = Double.parseDouble(rs(is.read_IS(company,17,2006)));
    Double ltt_07 = Double.parseDouble(rs(is.read_IS(company,17,2007)));
    Double ltt_08 = Double.parseDouble(rs(is.read_IS(company,17,2008)));
    Double ltt_09 = Double.parseDouble(rs(is.read_IS(company,17,2009)));
    Double ltt_10 = Double.parseDouble(rs(is.read_IS(company,17,2010)));
    Double ltt_11 = Double.parseDouble(rs(is.read_IS(company,17,2011)));
    Double ltt_12 = Double.parseDouble(rs(is.read_IS(company,17,2012)));
    Double ltt_13 = Double.parseDouble(rs(is.read_IS(company,17,2013)));
    //Thuế TNDN
    Double ttndn_05 = Double.parseDouble(rs(is.read_IS(company,18,2005)));
    Double ttndn_06 = Double.parseDouble(rs(is.read_IS(company,18,2006)));
    Double ttndn_07 = Double.parseDouble(rs(is.read_IS(company,18,2007)));
    Double ttndn_08 = Double.parseDouble(rs(is.read_IS(company,18,2008)));
    Double ttndn_09 = Double.parseDouble(rs(is.read_IS(company,18,2009)));
    Double ttndn_10 = Double.parseDouble(rs(is.read_IS(company,18,2010)));
    Double ttndn_11 = Double.parseDouble(rs(is.read_IS(company,18,2011)));
    Double ttndn_12 = Double.parseDouble(rs(is.read_IS(company,18,2012)));
    Double ttndn_13 = Double.parseDouble(rs(is.read_IS(company,18,2013)));
     //Giá vốn bán hàng
    Double gvbh_05 = Double.parseDouble(rs(is.read_IS(company,6,2005)));
    Double gvbh_06 = Double.parseDouble(rs(is.read_IS(company,6,2006)));
    Double gvbh_07 = Double.parseDouble(rs(is.read_IS(company,6,2007)));
    Double gvbh_08 = Double.parseDouble(rs(is.read_IS(company,6,2008)));
    Double gvbh_09 = Double.parseDouble(rs(is.read_IS(company,6,2009)));
    Double gvbh_10 = Double.parseDouble(rs(is.read_IS(company,6,2010)));
    Double gvbh_11 = Double.parseDouble(rs(is.read_IS(company,6,2011)));
    Double gvbh_12 = Double.parseDouble(rs(is.read_IS(company,6,2012)));
    Double gvbh_13 = Double.parseDouble(rs(is.read_IS(company,6,2013)));
    
    //Lãi sau thuế
    Double lst_05 = Double.parseDouble(rs(is.read_IS(company,20,2005)));
    Double lst_06 = Double.parseDouble(rs(is.read_IS(company,20,2006)));
    Double lst_07 = Double.parseDouble(rs(is.read_IS(company,20,2007)));
    Double lst_08 = Double.parseDouble(rs(is.read_IS(company,20,2008)));
    Double lst_09 = Double.parseDouble(rs(is.read_IS(company,20,2009)));
    Double lst_10 = Double.parseDouble(rs(is.read_IS(company,20,2010)));
    Double lst_11 = Double.parseDouble(rs(is.read_IS(company,20,2011)));
    Double lst_12 = Double.parseDouble(rs(is.read_IS(company,20,2012)));
    Double lst_13 = Double.parseDouble(rs(is.read_IS(company,20,2013)));
    //lãi lỗ từ hoạt động kinh doanh
    Double llthdkd_05 = Double.parseDouble(rs(is.read_IS(company,14,2005)));
    Double llthdkd_06 = Double.parseDouble(rs(is.read_IS(company,14,2006)));
    Double llthdkd_07 = Double.parseDouble(rs(is.read_IS(company,14,2007)));
    Double llthdkd_08 = Double.parseDouble(rs(is.read_IS(company,14,2008)));
    Double llthdkd_09 = Double.parseDouble(rs(is.read_IS(company,14,2009)));
    Double llthdkd_10 = Double.parseDouble(rs(is.read_IS(company,14,2010)));
    Double llthdkd_11 = Double.parseDouble(rs(is.read_IS(company,14,2011)));
    Double llthdkd_12 = Double.parseDouble(rs(is.read_IS(company,14,2012)));
    Double llthdkd_13 = Double.parseDouble(rs(is.read_IS(company,14,2013)));
    // EBITDA
    Double ebitda_05 = Double.parseDouble(rs(is.read_IS(company,24,2005)));
    Double ebitda_06 = Double.parseDouble(rs(is.read_IS(company,24,2006)));
    Double ebitda_07 = Double.parseDouble(rs(is.read_IS(company,24,2007)));
    Double ebitda_08 = Double.parseDouble(rs(is.read_IS(company,24,2008)));
    Double ebitda_09 = Double.parseDouble(rs(is.read_IS(company,24,2009)));
    Double ebitda_10 = Double.parseDouble(rs(is.read_IS(company,24,2010)));
    Double ebitda_11 = Double.parseDouble(rs(is.read_IS(company,24,2011)));
    Double ebitda_12 = Double.parseDouble(rs(is.read_IS(company,24,2012)));
    Double ebitda_13 = Double.parseDouble(rs(is.read_IS(company,24,2013)));
    //EBIT
    Double ebit_05 = ebitda_05 - Double.parseDouble(rs(is.read_IS(company,23,2005)));
    Double ebit_06 = ebitda_06 - Double.parseDouble(rs(is.read_IS(company,23,2006)));
    Double ebit_07 = ebitda_07 - Double.parseDouble(rs(is.read_IS(company,23,2007)));
    Double ebit_08 = ebitda_08 - Double.parseDouble(rs(is.read_IS(company,23,2008)));
    Double ebit_09 = ebitda_09 - Double.parseDouble(rs(is.read_IS(company,23,2009)));
    Double ebit_10 = ebitda_10 - Double.parseDouble(rs(is.read_IS(company,23,2010)));
    Double ebit_11 = ebitda_11 - Double.parseDouble(rs(is.read_IS(company,23,2011)));
    Double ebit_12 = ebitda_12 - Double.parseDouble(rs(is.read_IS(company,23,2012)));
    Double ebit_13 = ebitda_13 - Double.parseDouble(rs(is.read_IS(company,23,2013)));
    // Lãi lỗ công ty mẹ
    Double llctm_05 = Double.parseDouble(rs(is.read_IS(company,22,2005)));
    Double llctm_06 = Double.parseDouble(rs(is.read_IS(company,22,2006)));
    Double llctm_07 = Double.parseDouble(rs(is.read_IS(company,22,2007)));
    Double llctm_08 = Double.parseDouble(rs(is.read_IS(company,22,2008)));
    Double llctm_09 = Double.parseDouble(rs(is.read_IS(company,22,2009)));
    Double llctm_10 = Double.parseDouble(rs(is.read_IS(company,22,2010)));
    Double llctm_11 = Double.parseDouble(rs(is.read_IS(company,22,2011)));
    Double llctm_12 = Double.parseDouble(rs(is.read_IS(company,22,2012)));
    Double llctm_13 = Double.parseDouble(rs(is.read_IS(company,22,2013)));
    
    
    //Import data

    
    
    
    
    
    
    ///////////////////////////// BS
   
    
   // Tài sản ngắn hạn
    Double tsnh_05 = Double.parseDouble(rs(bs.read_BS(company,5,2005)));
    Double tsnh_06 = Double.parseDouble(rs(bs.read_BS(company,5,2006)));
    Double tsnh_07 = Double.parseDouble(rs(bs.read_BS(company,5,2007)));
    Double tsnh_08 = Double.parseDouble(rs(bs.read_BS(company,5,2008)));
    Double tsnh_09 = Double.parseDouble(rs(bs.read_BS(company,5,2009)));
    Double tsnh_10 = Double.parseDouble(rs(bs.read_BS(company,5,2010)));
    Double tsnh_11 = Double.parseDouble(rs(bs.read_BS(company,5,2011)));
    Double tsnh_12 = Double.parseDouble(rs(bs.read_BS(company,5,2012)));
    Double tsnh_13 = Double.parseDouble(rs(bs.read_BS(company,5,2013)));
    // Tiền và tương đương tiền
    Double tvtdt_05 = Double.parseDouble(rs(bs.read_BS(company,6,2005)));
    Double tvtdt_06 = Double.parseDouble(rs(bs.read_BS(company,6,2006)));
    Double tvtdt_07 = Double.parseDouble(rs(bs.read_BS(company,6,2007)));
    Double tvtdt_08 = Double.parseDouble(rs(bs.read_BS(company,6,2008)));
    Double tvtdt_09 = Double.parseDouble(rs(bs.read_BS(company,6,2009)));
    Double tvtdt_10 = Double.parseDouble(rs(bs.read_BS(company,6,2010)));
    Double tvtdt_11 = Double.parseDouble(rs(bs.read_BS(company,6,2011)));
    Double tvtdt_12 = Double.parseDouble(rs(bs.read_BS(company,6,2012)));
    Double tvtdt_13 = Double.parseDouble(rs(bs.read_BS(company,6,2013)));
    // Giá trị đầu tư ngắn hạn
    Double gtdtnh_05 = Double.parseDouble(rs(bs.read_BS(company,7,2005)));
    Double gtdtnh_06 = Double.parseDouble(rs(bs.read_BS(company,7,2006)));
    Double gtdtnh_07 = Double.parseDouble(rs(bs.read_BS(company,7,2007)));
    Double gtdtnh_08 = Double.parseDouble(rs(bs.read_BS(company,7,2008)));
    Double gtdtnh_09 = Double.parseDouble(rs(bs.read_BS(company,7,2009)));
    Double gtdtnh_10 = Double.parseDouble(rs(bs.read_BS(company,7,2010)));
    Double gtdtnh_11 = Double.parseDouble(rs(bs.read_BS(company,7,2011)));
    Double gtdtnh_12 = Double.parseDouble(rs(bs.read_BS(company,7,2012)));
    Double gtdtnh_13 = Double.parseDouble(rs(bs.read_BS(company,7,2013)));
       
    //Hàng tồn kho
    Double htk_05 = Double.parseDouble(rs(bs.read_BS(company,10,2005)));
    Double htk_06 = Double.parseDouble(rs(bs.read_BS(company,10,2006)));
    Double htk_07 = Double.parseDouble(rs(bs.read_BS(company,10,2007)));
    Double htk_08 = Double.parseDouble(rs(bs.read_BS(company,10,2008)));
    Double htk_09 = Double.parseDouble(rs(bs.read_BS(company,10,2009)));
    Double htk_10 = Double.parseDouble(rs(bs.read_BS(company,10,2010)));
    Double htk_11 = Double.parseDouble(rs(bs.read_BS(company,10,2011)));
    Double htk_12 = Double.parseDouble(rs(bs.read_BS(company,10,2012)));
    Double htk_13 = Double.parseDouble(rs(bs.read_BS(company,10,2013)));
    //Vốn và các quĩ
    Double vvcq_05 = Double.parseDouble(rs(bs.read_BS(company,25,2005)));
    Double vvcq_06 = Double.parseDouble(rs(bs.read_BS(company,25,2006)));
    Double vvcq_07 = Double.parseDouble(rs(bs.read_BS(company,25,2007)));
    Double vvcq_08 = Double.parseDouble(rs(bs.read_BS(company,25,2008)));
    Double vvcq_09 = Double.parseDouble(rs(bs.read_BS(company,25,2009)));
    Double vvcq_10 = Double.parseDouble(rs(bs.read_BS(company,25,2010)));
    Double vvcq_11 = Double.parseDouble(rs(bs.read_BS(company,25,2011)));
    Double vvcq_12 = Double.parseDouble(rs(bs.read_BS(company,25,2012)));
    Double vvcq_13 = Double.parseDouble(rs(bs.read_BS(company,25,2013)));
    //Tài sản lưu động khác
    Double tsldk_05 = Double.parseDouble(rs(bs.read_BS(company,11,2005)));
    Double tsldk_06 = Double.parseDouble(rs(bs.read_BS(company,11,2006)));
    Double tsldk_07 = Double.parseDouble(rs(bs.read_BS(company,11,2007)));
    Double tsldk_08 = Double.parseDouble(rs(bs.read_BS(company,11,2008)));
    Double tsldk_09 = Double.parseDouble(rs(bs.read_BS(company,11,2009)));
    Double tsldk_10 = Double.parseDouble(rs(bs.read_BS(company,11,2010)));
    Double tsldk_11 = Double.parseDouble(rs(bs.read_BS(company,11,2011)));
    Double tsldk_12 = Double.parseDouble(rs(bs.read_BS(company,11,2012)));
    Double tsldk_13 = Double.parseDouble(rs(bs.read_BS(company,11,2013)));
    
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
    // Lãi chưa phân phối
    Double lcpp_05 = Double.parseDouble(rs(bs.read_BS(company,28,2005)));
    Double lcpp_06 = Double.parseDouble(rs(bs.read_BS(company,28,2006)));
    Double lcpp_07 = Double.parseDouble(rs(bs.read_BS(company,28,2007)));
    Double lcpp_08 = Double.parseDouble(rs(bs.read_BS(company,28,2008)));
    Double lcpp_09 = Double.parseDouble(rs(bs.read_BS(company,28,2009)));
    Double lcpp_10 = Double.parseDouble(rs(bs.read_BS(company,28,2010)));
    Double lcpp_11 = Double.parseDouble(rs(bs.read_BS(company,28,2011)));
    Double lcpp_12 = Double.parseDouble(rs(bs.read_BS(company,28,2012)));
    Double lcpp_13 = Double.parseDouble(rs(bs.read_BS(company,28,2013)));
    //Tổng tài sản
    Double tts_05 = Double.parseDouble(rs(bs.read_BS(company,19,2005)));
    Double tts_06 = Double.parseDouble(rs(bs.read_BS(company,19,2006)));
    Double tts_07 = Double.parseDouble(rs(bs.read_BS(company,19,2007)));
    Double tts_08 = Double.parseDouble(rs(bs.read_BS(company,19,2008)));
    Double tts_09 = Double.parseDouble(rs(bs.read_BS(company,19,2009)));
    Double tts_10 = Double.parseDouble(rs(bs.read_BS(company,19,2010)));
    Double tts_11 = Double.parseDouble(rs(bs.read_BS(company,19,2011)));
    Double tts_12 = Double.parseDouble(rs(bs.read_BS(company,19,2012)));
    Double tts_13 = Double.parseDouble(rs(bs.read_BS(company,19,2013)));
    //Tổng nợ
    Double tn_05 = Double.parseDouble(rs(bs.read_BS(company,21,2005)));
    Double tn_06 = Double.parseDouble(rs(bs.read_BS(company,21,2006)));
    Double tn_07 = Double.parseDouble(rs(bs.read_BS(company,21,2007)));
    Double tn_08 = Double.parseDouble(rs(bs.read_BS(company,21,2008)));
    Double tn_09 = Double.parseDouble(rs(bs.read_BS(company,21,2009)));
    Double tn_10 = Double.parseDouble(rs(bs.read_BS(company,21,2010)));
    Double tn_11 = Double.parseDouble(rs(bs.read_BS(company,21,2011)));
    Double tn_12 = Double.parseDouble(rs(bs.read_BS(company,21,2012)));
    Double tn_13 = Double.parseDouble(rs(bs.read_BS(company,21,2013)));
    //Nợ ngắn hạn
    Double nnh_05 = Double.parseDouble(rs(bs.read_BS(company,22,2005)));
    Double nnh_06 = Double.parseDouble(rs(bs.read_BS(company,22,2006)));
    Double nnh_07 = Double.parseDouble(rs(bs.read_BS(company,22,2007)));
    Double nnh_08 = Double.parseDouble(rs(bs.read_BS(company,22,2008)));
    Double nnh_09 = Double.parseDouble(rs(bs.read_BS(company,22,2009)));
    Double nnh_10 = Double.parseDouble(rs(bs.read_BS(company,22,2010)));
    Double nnh_11 = Double.parseDouble(rs(bs.read_BS(company,22,2011)));
    Double nnh_12 = Double.parseDouble(rs(bs.read_BS(company,22,2012)));
    Double nnh_13 = Double.parseDouble(rs(bs.read_BS(company,22,2013)));
    //Nợ dài hạn
    Double ndh_05 = Double.parseDouble(rs(bs.read_BS(company,23,2005)));
    Double ndh_06 = Double.parseDouble(rs(bs.read_BS(company,23,2006)));
    Double ndh_07 = Double.parseDouble(rs(bs.read_BS(company,23,2007)));
    Double ndh_08 = Double.parseDouble(rs(bs.read_BS(company,23,2008)));
    Double ndh_09 = Double.parseDouble(rs(bs.read_BS(company,23,2009)));
    Double ndh_10 = Double.parseDouble(rs(bs.read_BS(company,23,2010)));
    Double ndh_11 = Double.parseDouble(rs(bs.read_BS(company,23,2011)));
    Double ndh_12 = Double.parseDouble(rs(bs.read_BS(company,23,2012)));
    Double ndh_13 = Double.parseDouble(rs(bs.read_BS(company,23,2013)));
   //Vốn chủ sở hữu
    Double vcsh_05 = Double.parseDouble(rs(bs.read_BS(company,24,2005)));
    Double vcsh_06 = Double.parseDouble(rs(bs.read_BS(company,24,2006)));
    Double vcsh_07 = Double.parseDouble(rs(bs.read_BS(company,24,2007)));
    Double vcsh_08 = Double.parseDouble(rs(bs.read_BS(company,24,2008)));
    Double vcsh_09 = Double.parseDouble(rs(bs.read_BS(company,24,2009)));
    Double vcsh_10 = Double.parseDouble(rs(bs.read_BS(company,24,2010)));
    Double vcsh_11 = Double.parseDouble(rs(bs.read_BS(company,24,2011)));
    Double vcsh_12 = Double.parseDouble(rs(bs.read_BS(company,24,2012)));
    Double vcsh_13 = Double.parseDouble(rs(bs.read_BS(company,24,2013)));
    
    
    
    
    
    ////////////////////////////CFS 

    //Khấu hao TSCĐ
    Double kh_05 = Double.parseDouble(rs(cfs.read_CFS(company,6,2005)));
    Double kh_06 = Double.parseDouble(rs(cfs.read_CFS(company,6,2006)));
    Double kh_07 = Double.parseDouble(rs(cfs.read_CFS(company,6,2007)));
    Double kh_08 = Double.parseDouble(rs(cfs.read_CFS(company,6,2008)));
    Double kh_09 = Double.parseDouble(rs(cfs.read_CFS(company,6,2009)));
    Double kh_10 = Double.parseDouble(rs(cfs.read_CFS(company,6,2010)));
    Double kh_11 = Double.parseDouble(rs(cfs.read_CFS(company,6,2011)));
    Double kh_12 = Double.parseDouble(rs(cfs.read_CFS(company,6,2012)));
    Double kh_13 = Double.parseDouble(rs(cfs.read_CFS(company,6,2013)));
    
    
    //Tiền thu từ phát hành cổ phiếu
    Double tttphcp_05 = Double.parseDouble(rs(cfs.read_CFS(company,31,2005)));
    Double tttphcp_06 = Double.parseDouble(rs(cfs.read_CFS(company,31,2006)));
    Double tttphcp_07 = Double.parseDouble(rs(cfs.read_CFS(company,31,2007)));
    Double tttphcp_08 = Double.parseDouble(rs(cfs.read_CFS(company,31,2008)));
    Double tttphcp_09 = Double.parseDouble(rs(cfs.read_CFS(company,31,2009)));
    Double tttphcp_10 = Double.parseDouble(rs(cfs.read_CFS(company,31,2010)));
    Double tttphcp_11 = Double.parseDouble(rs(cfs.read_CFS(company,31,2011)));
    Double tttphcp_12 = Double.parseDouble(rs(cfs.read_CFS(company,31,2012)));
    Double tttphcp_13 = Double.parseDouble(rs(cfs.read_CFS(company,31,2013)));
    //Tiền thu từ phát hành cổ phiếu
    Double ctdt_05 = Double.parseDouble(rs(cfs.read_CFS(company,36,2005)));
    Double ctdt_06 = Double.parseDouble(rs(cfs.read_CFS(company,36,2006)));
    Double ctdt_07 = Double.parseDouble(rs(cfs.read_CFS(company,36,2007)));
    Double ctdt_08 = Double.parseDouble(rs(cfs.read_CFS(company,36,2008)));
    Double ctdt_09 = Double.parseDouble(rs(cfs.read_CFS(company,36,2009)));
    Double ctdt_10 = Double.parseDouble(rs(cfs.read_CFS(company,36,2010)));
    Double ctdt_11 = Double.parseDouble(rs(cfs.read_CFS(company,36,2011)));
    Double ctdt_12 = Double.parseDouble(rs(cfs.read_CFS(company,36,2012)));
    Double ctdt_13 = Double.parseDouble(rs(cfs.read_CFS(company,36,2013)));
    //Chi trả cho việc mua cổ phiếu
    Double ctcvmcp_05 = Double.parseDouble(rs(cfs.read_CFS(company,32,2005)));
    Double ctcvmcp_06 = Double.parseDouble(rs(cfs.read_CFS(company,32,2006)));
    Double ctcvmcp_07 = Double.parseDouble(rs(cfs.read_CFS(company,32,2007)));
    Double ctcvmcp_08 = Double.parseDouble(rs(cfs.read_CFS(company,32,2008)));
    Double ctcvmcp_09 = Double.parseDouble(rs(cfs.read_CFS(company,32,2009)));
    Double ctcvmcp_10 = Double.parseDouble(rs(cfs.read_CFS(company,32,2010)));
    Double ctcvmcp_11 = Double.parseDouble(rs(cfs.read_CFS(company,32,2011)));
    Double ctcvmcp_12 = Double.parseDouble(rs(cfs.read_CFS(company,32,2012)));
    Double ctcvmcp_13 = Double.parseDouble(rs(cfs.read_CFS(company,32,2013)));
     // Lưu chuyển tiền ròng từ hoạt động đầu tư
    Double cf_05 = Double.parseDouble(rs(cfs.read_CFS(company,22,2005)));
    Double cf_06 = Double.parseDouble(rs(cfs.read_CFS(company,22,2006)));
    Double cf_07 = Double.parseDouble(rs(cfs.read_CFS(company,22,2007)));
    Double cf_08 = Double.parseDouble(rs(cfs.read_CFS(company,22,2008)));
    Double cf_09 = Double.parseDouble(rs(cfs.read_CFS(company,22,2009)));
    Double cf_10 = Double.parseDouble(rs(cfs.read_CFS(company,22,2010)));
    Double cf_11 = Double.parseDouble(rs(cfs.read_CFS(company,22,2011)));
    Double cf_12 = Double.parseDouble(rs(cfs.read_CFS(company,22,2012)));
    Double cf_13 = Double.parseDouble(rs(cfs.read_CFS(company,22,2013)));
    
    //////////////////////////////FI
     //Cổ phiếu
    Double sn_05 = Double.parseDouble(rs(fi.read_FI(company,7,2005)));
    Double sn_06 = Double.parseDouble(rs(fi.read_FI(company,7,2006)));
    Double sn_07 = Double.parseDouble(rs(fi.read_FI(company,7,2007)));
    Double sn_08 = Double.parseDouble(rs(fi.read_FI(company,7,2008)));
    Double sn_09 = Double.parseDouble(rs(fi.read_FI(company,7,2009)));
    Double sn_10 = Double.parseDouble(rs(fi.read_FI(company,7,2010)));
    Double sn_11 = Double.parseDouble(rs(fi.read_FI(company,7,2011)));
    Double sn_12 = Double.parseDouble(rs(fi.read_FI(company,7,2012)));
    Double sn_13 = Double.parseDouble(rs(fi.read_FI(company,7,2013)));
    
    
    if ("0.0".equals(sn_12)) {sn_12 = sn_13;}
    if ("0.0".equals(sn_11)) {sn_11 = sn_12;}
    if ("0.0".equals(sn_10)) {sn_10 = sn_11;}
    if ("0.0".equals(sn_09)) {sn_09 = sn_10;}
    if ("0.0".equals(sn_08)) {sn_08 = sn_09;}
    if ("0.0".equals(sn_07)) {sn_07 = sn_08;}
    if ("0.0".equals(sn_06)) {sn_06 = sn_07;}
    if ("0.0".equals(sn_05)) {sn_05 = sn_06;}
    // Cổ tức
    Double ct_05 = Double.parseDouble(rs(fi.read_FI(company,10,2005)));
    Double ct_06 = Double.parseDouble(rs(fi.read_FI(company,10,2006)));
    Double ct_07 = Double.parseDouble(rs(fi.read_FI(company,10,2007)));
    Double ct_08 = Double.parseDouble(rs(fi.read_FI(company,10,2008)));
    Double ct_09 = Double.parseDouble(rs(fi.read_FI(company,10,2009)));
    Double ct_10 = Double.parseDouble(rs(fi.read_FI(company,10,2010)));
    Double ct_11 = Double.parseDouble(rs(fi.read_FI(company,10,2011)));
    Double ct_12 = Double.parseDouble(rs(fi.read_FI(company,10,2012)));
    Double ct_13 = Double.parseDouble(rs(fi.read_FI(company,10,2013)));
    
    
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
    
    //Enterprise value
    
    Double ev_05 = IaA.close_price(company,year-8)*1000*sn_05;
    Double ev_06 = IaA.close_price(company,year-7)*1000*sn_06;
    Double ev_07 = IaA.close_price(company,year-6)*1000*sn_07;
    Double ev_08 = IaA.close_price(company,year-5)*1000*sn_08;
    Double ev_09 = IaA.close_price(company,year-4)*1000*sn_09;
    Double ev_10 = IaA.close_price(company,year-3)*1000*sn_10;
    Double ev_11 = IaA.close_price(company,year-2)*1000*sn_11;
    Double ev_12 = IaA.close_price(company,year-1)*1000*sn_12;
    Double ev_13 = IaA.close_price(company,year)*1000*sn_13;
   
    
       
        
        
        
        
        
        
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
        //Cashflow per share
        Double cfps_05 = cf_05/sn_05*1000000;
        Double cfps_06 = cf_06/sn_06*1000000;
        Double cfps_07 = cf_07/sn_07*1000000;
        Double cfps_08 = cf_08/sn_08*1000000;
        Double cfps_09 = cf_09/sn_09*1000000;
        Double cfps_10 = cf_10/sn_10*1000000;
        Double cfps_11 = cf_11/sn_11*1000000;
        Double cfps_12 = cf_12/sn_12*1000000;
        Double cfps_13 = cf_13/sn_13*1000000;
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
        Double s_09 = dtt_09*1000000;
        Double s_10 = dtt_10*1000000;
        Double s_11 = dtt_11*1000000;
        Double s_12 = dtt_12*1000000;
        Double s_13 = dtt_13*1000000;
        
        // Dividend per share = Cổ tức
        //Price/Earning per share
        Double peps_05 = IaA.close_price(company, year-8)*1000/eps_05;
        
        Double peps_06 = IaA.close_price(company, year-7)*1000/eps_06;
        
        Double peps_07 = IaA.close_price(company, year-6)*1000/eps_07;
        
        Double peps_08 = IaA.close_price(company, year-5)*1000/eps_08;
        
        Double peps_09 = IaA.close_price(company, year-4)*1000/eps_09;
        
        Double peps_10 = IaA.close_price(company, year-3)*1000/eps_10;
        
        Double peps_11 = IaA.close_price(company, year-2)*1000/eps_11;
        
        Double peps_12 = IaA.close_price(company, year-1)*1000/eps_12;
        
        Double peps_13 = IaA.close_price(company, year)*1000/eps_13;
         Double peps_avg3 = (peps_13+peps_12+peps_11)/3;
        Double peps_avg5 = (peps_13+peps_12+peps_11+peps_10+peps_09)/5;
        
        // Price/Cashflow per share
        
        Double pcfps_05 = IaA.close_price(company,year-8)/cfps_05*1000000;
        
        Double pcfps_06 = IaA.close_price(company,year-7)/cfps_06*1000;
        
        Double pcfps_07 = IaA.close_price(company,year-6)/cfps_07*1000;
        
        Double pcfps_08 = IaA.close_price(company,year-5)/cfps_08*1000;
        
        Double pcfps_09 = IaA.close_price(company,year-4)/cfps_09*1000;
        
        Double pcfps_10 = IaA.close_price(company,year-3)/cfps_10*1000;
        
        Double pcfps_11 = IaA.close_price(company,year-2)/cfps_11*1000;
        
        Double pcfps_12 = IaA.close_price(company,year-1)/cfps_12*1000;
        
        Double pcfps_13 = IaA.close_price(company,year)/cfps_13*1000;
        Double pcfps_avg3 = (pcfps_13+pcfps_12+pcfps_11)/3;
        Double pcfps_avg5 = (pcfps_13+pcfps_12+pcfps_11+pcfps_10+pcfps_09)/5;
        
        // Price/ Sales per share
        
        Double psps_05 = IaA.close_price(company,year-8)/sps_05*1000;
        
        Double psps_06 = IaA.close_price(company,year-7)/sps_06*1000;
        
        Double psps_07 = IaA.close_price(company,year-6)/sps_07*1000;
        
        Double psps_08 = IaA.close_price(company,year-5)/sps_08*1000;
        
        Double psps_09 = IaA.close_price(company,year-4)/sps_09*1000;
        
        Double psps_10 = IaA.close_price(company,year-3)/sps_10*1000;
        
        Double psps_11 = IaA.close_price(company,year-2)/sps_11*1000;
        
        Double psps_12 = IaA.close_price(company,year-1)/sps_12*1000;
        
        Double psps_13 = IaA.close_price(company,year)/sps_13*1000;
        Double psps_avg3 = (psps_13+psps_12+psps_11)/3;
        Double psps_avg5 = (psps_13+psps_12+psps_11+psps_10+psps_09)/5;
        
        //Free cashflow per share
        Double fcfps_05 = 0.0;
        Double fcfps_06 = (ebit_06 * (1-t_06) *1000000+ kh_06 *1000000 - (wc_06 - wc_05) - (tts_06 - tts_05)*1000000+ (tn_06 - tn_05)*1000000)/sn_06;
        Double fcfps_07 = (ebit_07 * (1-t_07) *1000000+ kh_07 *1000000 - (wc_07 - wc_06) - (tts_07 - tts_06)*1000000+ (tn_07 - tn_06)*1000000)/sn_07;
        Double fcfps_08 = (ebit_08 * (1-t_08) *1000000+ kh_08 *1000000 - (wc_08 - wc_07) - (tts_08 - tts_07)*1000000+ (tn_08 - tn_07)*1000000)/sn_08;
        Double fcfps_09 = (ebit_09 * (1-t_09) *1000000+ kh_09 *1000000 - (wc_09 - wc_08) - (tts_09 - tts_08)*1000000+ (tn_09 - tn_08)*1000000)/sn_09;
        Double fcfps_10 = (ebit_10 * (1-t_10) *1000000+ kh_10 *1000000 - (wc_10 - wc_09) - (tts_10 - tts_09)*1000000+ (tn_10 - tn_09)*1000000)/sn_10;
        Double fcfps_11 = (ebit_11 * (1-t_11) *1000000+ kh_11 *1000000 - (wc_11 - wc_10) - (tts_11 - tts_10)*1000000+ (tn_11 - tn_10)*1000000)/sn_11;
        Double fcfps_12 = (ebit_12 * (1-t_12) *1000000+ kh_12 *1000000 - (wc_12 - wc_11) - (tts_12 - tts_11)*1000000+ (tn_12 - tn_11)*1000000)/sn_12;
        Double fcfps_13 = (ebit_13 * (1-t_13) *1000000+ kh_13 *1000000 - (wc_13 - wc_12) - (tts_13 - tts_12)*1000000+ (tn_13 - tn_12)*1000000)/sn_13;
        //Free cashflow per share
        Double fcf_05 = 0.0;
        Double fcf_06 = (ebit_06 * (1-t_06) *1000000+ kh_06 *1000000 - (wc_06 - wc_05) - (tts_06 - tts_05)*1000000+ (tn_06 - tn_05)*1000000);
        Double fcf_07 = (ebit_07 * (1-t_07) *1000000+ kh_07 *1000000 - (wc_07 - wc_06) - (tts_07 - tts_06)*1000000+ (tn_07 - tn_06)*1000000);
        Double fcf_08 = (ebit_08 * (1-t_08) *1000000+ kh_08 *1000000 - (wc_08 - wc_07) - (tts_08 - tts_07)*1000000+ (tn_08 - tn_07)*1000000);
        Double fcf_09 = (ebit_09 * (1-t_09) *1000000+ kh_09 *1000000 - (wc_09 - wc_08) - (tts_09 - tts_08)*1000000+ (tn_09 - tn_08)*1000000);
        Double fcf_10 = (ebit_10 * (1-t_10) *1000000+ kh_10 *1000000 - (wc_10 - wc_09) - (tts_10 - tts_09)*1000000+ (tn_10 - tn_09)*1000000);
        Double fcf_11 = (ebit_11 * (1-t_11) *1000000+ kh_11 *1000000 - (wc_11 - wc_10) - (tts_11 - tts_10)*1000000+ (tn_11 - tn_10)*1000000);
        Double fcf_12 = (ebit_12 * (1-t_12) *1000000+ kh_12 *1000000 - (wc_12 - wc_11) - (tts_12 - tts_11)*1000000+ (tn_12 - tn_11)*1000000);
        Double fcf_13 = (ebit_13 * (1-t_13) *1000000+ kh_13 *1000000 - (wc_13 - wc_12) - (tts_13 - tts_12)*1000000+ (tn_13 - tn_12)*1000000);
        
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
        
        //Price/Book Value Per Share
        Double pbvps_05 = IaA.close_price(company,year-8)/bvps_05*1000;
        
        Double pbvps_06 = IaA.close_price(company,year-7)/bvps_06*1000;
        
        Double pbvps_07 = IaA.close_price(company,year-6)/bvps_07*1000;
        
        Double pbvps_08 = IaA.close_price(company,year-5)/bvps_08*1000;
        
        Double pbvps_09 = IaA.close_price(company,year-4)/bvps_09*1000;
       
        Double pbvps_10 = IaA.close_price(company,year-3)/bvps_10*1000;
       
        Double pbvps_11 = IaA.close_price(company,year-2)/bvps_11*1000;
       
        Double pbvps_12 = IaA.close_price(company,year-1)/bvps_12*1000;
       
        Double pbvps_13 = IaA.close_price(company,year)/bvps_13*1000;
        Double pbvps_avg3 = (pbvps_13+pbvps_12+pbvps_11)/3;
        Double pbvps_avg5 = (pbvps_13+pbvps_12+pbvps_11+pbvps_10+pbvps_09)/5;
        // Price/Free cashflow per share
        
        Double pfcfps_05 = 0.0;
        Double pfcfps_06 = IaA.close_price(company,year-8)/fcfps_06*1000;
        
        Double pfcfps_07 = IaA.close_price(company,year-7)/fcfps_07*1000;
        
        Double pfcfps_08 = IaA.close_price(company,year-6)/fcfps_08*1000;
        
        Double pfcfps_09 = IaA.close_price(company,year-5)/fcfps_09*1000;
        
        Double pfcfps_10 = IaA.close_price(company,year-4)/fcfps_10*1000;
        Double pfcfps_11 = IaA.close_price(company,year-3)/fcfps_11*1000;
        Double pfcfps_12 = IaA.close_price(company,year-2)/fcfps_12*1000;
        Double pfcfps_13 = IaA.close_price(company,year-1)/fcfps_13*1000;
         Double pfcfps_avg3 = (pfcfps_13+pfcfps_12+pfcfps_11)/3;
        Double pfcfps_avg5 = (pfcfps_13+pfcfps_12+pfcfps_11+pfcfps_10+pfcfps_09)/5;
        // %Yield 
        Double yield_05 = ct_05/IaA.close_price(company,year-8)*100;
        Double yield_06 = ct_06/IaA.close_price(company,year-7)*100;
        Double yield_07 = ct_07/IaA.close_price(company,year-6)*100;
        Double yield_08 = ct_08/IaA.close_price(company,year-5)*100;
        Double yield_09 = ct_09/IaA.close_price(company,year-4)*100;
        Double yield_10 = ct_10/IaA.close_price(company,year-3)*100;
        Double yield_11 = ct_11/IaA.close_price(company,year-2)*100;
        Double yield_12 = ct_12/IaA.close_price(company,year-1)*100;
        Double yield_13 = ct_13/IaA.close_price(company,year)*100;
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
        
        //5 Year Annual Growth Rate
        Double eps_change_5 = (eps_13 - eps_09)/eps_09*100;
        Double ct_change_5 = (ct_13 - ct_09)/ct_09*100;
        Double cf_change_5 = (cf_13 - cf_09)/cf_09*100;
        Double fcf_change_5 = (fcf_13 - fcf_09)/fcf_09*100;
        Double s_change_5 = (s_13 - s_09)/s_09*100;
        
        // Trend
        Double eps_trend = (1+eps_change_5/100)*eps_13;
        Double ct_trend = (1+ct_change_5/100)*ct_13;
        Double cf_trend = (1+cf_change_5/100)*cf_13;
        Double fcf_trend = (1+fcf_change_5/100)*fcf_13;
        Double s_trend = (1+s_change_5/100)*s_13;
        
        //Current Multiple
        Double eps_cm = IaA.close_price(company,2014)*1000/eps_13;
        Double ct_cm = IaA.close_price(company,2014)*1000/ct_13;
        Double cf_cm = IaA.close_price(company,2014)*1000/cf_13;
        Double fcf_cm = IaA.close_price(company,2014)*1000/fcf_13;
        Double s_cm = IaA.close_price(company,2014)*1000/s_13;
        
        
        add_company_val(conn,prestatement,company,"_VAL");
        add_data_val(conn,prestatement,company,"_VAL","Latest Report",Double.toString(eps_13),Double.toString(ct_13),Double.toString(cf_13),Double.toString(fcf_13),Double.toString(s_13));
        add_data_val(conn,prestatement,company,"_VAL","5 Year Annual Growth Rate",Double.toString(eps_change_5),Double.toString(ct_change_5),Double.toString(cf_change_5),Double.toString(fcf_change_5),Double.toString(s_change_5));
        add_data_val(conn,prestatement,company,"_VAL","Trend",Double.toString(eps_trend),Double.toString(ct_trend),Double.toString(cf_trend),Double.toString(fcf_trend),Double.toString(s_trend));
         add_data_val(conn,prestatement,company,"_VAL","Current Multiple",Double.toString(eps_cm),Double.toString(ct_cm),Double.toString(cf_cm),Double.toString(fcf_cm),Double.toString(s_cm));
        
        
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
    public static void add_data_val(Connection conn, PreparedStatement prestatement, String name,String part, String clause, String ad_13, String ad_12, String ad_11, String ad_10, String ad_09) throws SQLException {
        
        prestatement = conn.prepareStatement("INSERT INTO `FINA_"+name+part+"` (`clause`, `EPS`, `Dividend`, `Cashflow`, `Free Cashflow`, `Sales`) VALUES(N?,?,?,?,?,?);");
        
       prestatement.setString(1, clause);
       prestatement.setString(2, ad_13);
       prestatement.setString(3, ad_12);
       prestatement.setString(4, ad_11);
       prestatement.setString(5, ad_10);
       prestatement.setString(6, ad_09);
       
        prestatement.executeUpdate();
       
    }
    public static void add_company_val(Connection conn,PreparedStatement prestatement, String name,String part) throws SQLException//creating templates for prepared statement
    {
       prestatement = conn.prepareStatement ("DROP TABLE IF EXISTS `FINA_"+name+part+"`;");
       prestatement.executeUpdate();
       prestatement = conn.prepareStatement ("CREATE TABLE `FINA_"+ name+part+ "` ( ID INT(9) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL, `clause` VARCHAR(255) CHARACTER SET utf8mb4  COLLATE utf8mb4_unicode_ci, `EPS` VARCHAR(255), `Dividend` VARCHAR(255), `Cashflow` VARCHAR(255), `Free Cashflow` VARCHAR(255), `Sales` VARCHAR(255))");
       prestatement.executeUpdate();
        
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
}
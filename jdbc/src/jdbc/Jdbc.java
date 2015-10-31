/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.sql.*; 
import java.math.*;
import jdbc.ReadCSV;
/**
 *
 * @author tri
 */
public class Jdbc {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Connection conn = null;    
    String url = "jdbc:mysql://localhost:3308/";
    String dbName = "company";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root"; 
    String password = "root";
    Statement statement = null;
    ResultSet result = null;
    PreparedStatement prestatement = null;
    String company = "AMC";
    
    try {
    //    System.out.println("Connection to driver...");
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url+dbName,userName,password);
        
        statement = conn.createStatement();
       // statement.execute("CREATE TABLE books (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), author VARCHAR (100))");
      // statement.execute("INSERT INTO books (name,author)VALUES ('abc','tri'),('bcd','son'),('cdf','tran'),('dfe','tri');");
       
        addCompany(conn, prestatement, company);//following method predetermined in addBook()
  //      result = statement.executeQuery("SELECT * FROM books;");
  //     while (result.next())
  //      {
  //          Long id = result.getLong("id");
  //          String name = result.getString("name");
  //          String author = result.getString("author");
          
  //          System.out.printf("ID: %o \tName: %s\tAuthor: %s \n",id,name,author);
  //      }
    }
    catch (Exception e) {
            e.printStackTrace();
        }
    finally {
    
        if (conn != null) try{conn.close();} catch(Exception ignore) {}
        if (statement != null) try{statement.close();} catch(Exception ignore) {}
        if (result != null) try{result.close();} catch(Exception ignore) {}
        if (prestatement != null) try{prestatement.close();} catch(Exception ignore) {}
    }
    }
    
    public static void addCompany(Connection conn,PreparedStatement prestatement, String name) throws SQLException//creating templates for prepared statement
    {
       prestatement = conn.prepareStatement ("CREATE TABLE "+ name + " (Date INT(9) UNSIGNED PRIMARY KEY, High DOUBLE(5,5) NOT NULL,Low DOUBLE(5,5) NOT NULL,Close DOUBLE(5,5),Volume INT(9);");
       
        
        
    }
    public static void addData(Connection conn,PreparedStatement prestatement, String name, Double Date, Double High, Double Low, Double Close,Double Volume) throws SQLException//creating templates for prepared statement
    {
       prestatement = conn.prepareStatement("INSERT INTO "+name+" (Date,High,Low,Close,Volume) VALUES (?, ?, ?, ?, ?);"); //watchout for prepareStament,it is a query,not variable
       prestatement.setDouble(1, Date); //set string value to the first "?"
       prestatement.setDouble(2, High); // set string value to the second "?"
       prestatement.setDouble(3, Low);
       prestatement.setDouble(4, Close);
       prestatement.setDouble(5, Volume);
       
       prestatement.executeUpdate();
           
    
    }
        
}

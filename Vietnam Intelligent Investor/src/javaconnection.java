/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tri
 */
import java.sql.*;
import javax.swing.*;
public class javaconnection {
    
    Connection conn = null;
    public static Connection ConnectDb(){
    
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Proma.db");
        } catch{
    
}

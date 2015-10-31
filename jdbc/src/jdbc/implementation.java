/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.lang.ClassNotFoundException;
import java.sql.*;

/**
 *
 * @author tri
 */
public class implementation {
    public static void main(String[] args)
    { 
        Connection connection = null;
        Statement statement = null;
                
        try
        {
    System.out.println("Connection to driver...");
    
    System.out.println("Connection Successful");    }
    
    catch (ClassNotFoundException error)
        {
        System.out.println("Error: "+ error.getMessage());
     }
    }
    
    
    
   }


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

/**
 *
 * @author tri
 */
public class Myauth extends Authenticator{
    public static final String USERNAME_KEY = "hello_nguyenson@live.com";
    public static final String PASSWORD_KEY = "19931994";
    private final PasswordAuthentication authentication;
     
public  Myauth(Properties properties) {
    String userName = properties.getProperty(USERNAME_KEY);
    String password = properties.getProperty(PASSWORD_KEY);
    if (userName == null || password == null) {
        authentication = null;
    } else {
        authentication = new PasswordAuthentication(userName, password.toCharArray());
    }
}


protected PasswordAuthentication getPasswordAuthentication() {
    return authentication;
}
  
    
}

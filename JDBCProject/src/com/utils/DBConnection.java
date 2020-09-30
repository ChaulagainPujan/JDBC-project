/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pujan Chaulagain
 */
public class DBConnection {
    
    public Connection con=null;
    public DBConnection() throws ClassNotFoundException, SQLException
    {
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/niit","root","");
      
    }
}

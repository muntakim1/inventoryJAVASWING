/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DataBaseHelperClass {
    Connection conn=null;
    public static Connection ConnecrDB(){
     try{
     Class.forName("org.sqlite.JDBC");
     Connection conn;
         conn = DriverManager.getConnection("jdbc:sqlite:E:\\sqlite\\inventory.db");
     System.out.print("Connected!!!");
     return conn;
     
     }
     catch(ClassNotFoundException | SQLException e){
         JOptionPane.showMessageDialog(null,e);
          return null;
     }
    }
}

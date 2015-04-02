/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package check;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author meghana gupta
 */
public class TestConn {
    
    public static void main(String arg[])
    {
         try{  
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","megs");
          Statement stmt=conn.createStatement();
          
          PreparedStatement ps = conn.prepareStatement("select * from book where bookid=101");
          ///ps.setString(1, str1);
          //ps.setString(2, str2);
          //ps.setInt(3, ent);
          ResultSet rs = ps.executeQuery();
          int i=0;
          while(rs.next())
          {
          //System.out.println(rs.getString(0));
          System.out.println(rs.getString(1));
          System.out.println(rs.getString(2));
         System.out.println(rs.getString(3));
          System.out.println(rs.getString(4));
          System.out.println(rs.getString(5));
          
          }
         } 
    }
}

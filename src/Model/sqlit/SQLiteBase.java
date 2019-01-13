///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
package Model.sqlit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  PedroMarinho pedro.marinho238@gmail.com
 * 
 */
public class SQLiteBase {
 
    protected  Connection conn;
    public Connection open(){
        try {
            conn= DriverManager.getConnection("jdbc:sqlite:corrida");
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
     public void close(){
       
            try {
                 if(conn!=null)
                conn.close();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        
    }
}

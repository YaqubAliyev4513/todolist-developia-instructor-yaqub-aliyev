/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.developia.main.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;


/**
 *
 * @author user
 */
public class Database {
   private Connection conn = null;
   
    public Database(){
        connect();
    }

    public Connection getConn() {
        return conn;
    }
    
    public void connect(){
        
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/todolist-developia-instructor-yaqub-aliyev", "root", "1234");
                    
            
            System.out.println("Ugurlu baglantı");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        finally{
//            try {
//               conn.close();
//                System.out.println("Baglanti kesildi");
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
    }
    
    public void disconnect(){
       try{
            
          conn.close();
          System.out.println("Baglanti kesildi");
       }catch(Exception err){
           err.printStackTrace();
       }
    }
    
    
    
   
    
}

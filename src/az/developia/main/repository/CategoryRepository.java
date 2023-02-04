/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.developia.main.repository;

import az.developia.main.model.Category;
import az.developia.main.model.Exercise;
import az.developia.main.util.ProjectProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class CategoryRepository {
    private Connection connection;
    private final ProjectProperties properties = new ProjectProperties();
    
    public void createConnection(){
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             connection=DriverManager.getConnection("jdbc:mysql://"+properties.getHost()+":"+properties.getPort()+"/"+properties.getDatabase(), properties.getUsername(), properties.getPassword());          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public  void insertCategory(Category c) {
        try {
            createConnection();
            Statement s = connection.createStatement();
            s.execute("insert into categories (category) values ('" + c.getCategory() + "') ");
            s.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
     public void deleteCategory(Category c) {
        try {
            createConnection();
            Statement s = connection.createStatement();
            s.execute("delete from categories where category = '"+c.getCategory()+"' ");
            s.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
     
     public  ArrayList<String> getCategories() {
        
        
        ArrayList<String> categories=new ArrayList<String>();
        
        try {
             createConnection();
             Statement s=connection.createStatement();
           
             ResultSet r=s.executeQuery("SELECT * FROM categories");
             
             
             while(r.next()) {
                 
                 categories.add(r.getString("category"));
                 
             }
             
             
           r.close();
           s.close();
           connection.close();
        } catch (Exception ex) {
           
            ex.printStackTrace();
        }
        
        return categories;
        
    }
}

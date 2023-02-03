/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.developia.main.repository;

import az.developia.main.model.Exercise;
import java.sql.*;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class ExerciseRepository {

    private Connection connection;
    
    
    public void createConnection(){
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/todolist-developia-instructor-yaqub-aliyev", "root", "1234");          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    

    public  void insertExercise(Exercise e) {
        try {
            createConnection();
            Statement s = connection.createStatement();
            s.execute("insert into exercises (task,category,day,registerdate,status) values ('" + e.getTask() + "','" + e.getCategory() + "','" + e.getDay() + "','" + e.getRegisterDate() + "','" + e.getStatus() + "') ");
            s.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void updateExercise(Exercise e) {
        try {
            createConnection();
            Statement s = connection.createStatement();
            s.execute("update exercises set task = '" + e.getTask() + "',category = '" + e.getCategory() + "', day = '" + e.getDay() + "', registerdate = '" + e.getRegisterDate() + "' where id="+e.getId()+"   ");
            s.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void updateStatusColumnInExercise(Integer id,String status){
        try {
            createConnection();
            Statement s = connection.createStatement();
            s.execute("update exercises set status = '"+status+"'  where id="+id+"   ");
            s.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public  void deleteAllExercises(){
        try {
            createConnection();
            Statement s = connection.createStatement();
            s.execute("delete  from exercises");
            s.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public  void deleteExercise(Integer id){
        try {
            createConnection();
            Statement s = connection.createStatement();
            s.execute("delete from exercises  where id="+id+"   ");
            s.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    
    public  ObservableList<Exercise> getExercises() {
        
        
        ObservableList<Exercise> exercises=FXCollections.observableArrayList();
        
        try {
             createConnection();
             Statement s=connection.createStatement();
           
             ResultSet r=s.executeQuery("SELECT * FROM exercises");
             
             
             while(r.next()) {
                 Exercise e=new Exercise();
                 e.setId(r.getInt("id"));
                 e.setTask(r.getString("task"));
                 e.setCategory(r.getString("category"));
                 e.setDay(r.getInt("day"));
                 e.setRegisterDate( r.getObject("registerdate", LocalDateTime.class) );
                 e.setStatus(r.getString("status"));
                 exercises.add(e);
             }
             
             
           r.close();
           s.close();
           connection.close();
        } catch (Exception ex) {
           
            ex.printStackTrace();
        }
        
        return exercises;
        
    }
    
    

}

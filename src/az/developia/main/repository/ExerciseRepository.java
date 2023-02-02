/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.developia.main.repository;

import az.developia.main.database.Database;
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

    private static Connection conn = null;

    public static void insertExercise(Exercise e) {
        try {
            conn = new Database().getConn();
            Statement s = conn.createStatement();
            s.execute("insert into exercises (task,category,day,registerdate,status) values ('" + e.getTask() + "','" + e.getCategory() + "','" + e.getDay() + "','" + e.getRegisterDate() + "','" + e.getStatus() + "') ");
            s.close();
            conn.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public static void updateExercise(Exercise e) {
        try {
            conn = new Database().getConn();
            Statement s = conn.createStatement();
            s.execute("update exercises set task = '" + e.getTask() + "',category = '" + e.getCategory() + "', day = '" + e.getDay() + "', registerdate = '" + e.getRegisterDate() + "' where id="+e.getId()+"   ");
            s.close();
            conn.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    
    public static ObservableList<Exercise> getExercises() {
        
        
        ObservableList<Exercise> exercises=FXCollections.observableArrayList();
        
        try {
             conn = new Database().getConn();
             Statement s=conn.createStatement();
           
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
        } catch (Exception ex) {
           
            ex.printStackTrace();
        }
        
        return exercises;
        
    }
    
    

}

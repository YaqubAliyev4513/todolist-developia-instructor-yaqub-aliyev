/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.developia.main.repository;

import az.developia.main.database.Database;
import az.developia.main.model.Exercise;
import java.sql.*;

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
            s.execute("insert into exercises (task,category,day,registerDate,status) values ('" + e.getTask() + "','" + e.getCategory() + "','" + e.getDay() + "','" + e.getRegisterDate() + "','" + e.getStatus() + "') ");
            s.close();
            conn.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.developia.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class LauncherClass extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("resources/index.fxml"));
       stage.setTitle("To Do List project(by DEA Instructor Yaqub Aliyev)");
       stage.setScene(new Scene(root,stage.getWidth(),stage.getHeight()));
       
       stage.setResizable(false);
       stage.setFullScreen(false);
       
       stage.show();
    }
    
}

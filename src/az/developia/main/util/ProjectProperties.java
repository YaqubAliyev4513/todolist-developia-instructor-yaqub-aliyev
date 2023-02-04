/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.developia.main.util;

import java.io.File;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ProjectProperties {

    private Properties properties;

    private String driverName;
    private String host;
    private String port;
    private String database;

    private String username;
    private String password;

    public String getDriverName() {
        return driverName;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    

    public ProjectProperties() {
        properties = new Properties();

        try {
            properties.load(new FileInputStream("src/az/developia/main/resources/application.properties"));
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
            driverName = properties.getProperty("mysql.driver");
            host = properties.getProperty("mysql.host");
            port = properties.getProperty("mysql.port");
            database = properties.getProperty("mysql.database");
            username = properties.getProperty("mysql.username");
            password  = properties.getProperty("mysql.password");

    }

}

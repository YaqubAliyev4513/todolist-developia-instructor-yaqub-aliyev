/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.developia.main.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author user
 */
public class Exercise {
   private Integer id;
   private String task;
   private String category;
   private Integer day;
   private LocalDateTime registerDate;
   private String status;

    public void setId(Integer id) {
        this.id = id;
    }

   
   
   
    public Integer getId() {
        return id;
    }
   
   

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }
   
   

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Exercise{" + "id=" + id + ", task=" + task + ", category=" + category + ", day=" + day + ", registerDate=" + registerDate + ", status=" + status + '}';
    }
    
    
   
   
   
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.developia.main.service;

import az.developia.main.model.Exercise;
import az.developia.main.repository.ExerciseRepository;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class ExerciseService {
   private final  ExerciseRepository exerciseRepository =  new ExerciseRepository();
   
   public  void insertExercise(Exercise e){
       exerciseRepository.insertExercise(e);
   }
   
   public  void updateExercise(Exercise e){
       exerciseRepository.updateExercise(e);
   }
   
   public  void deleteExercise(Integer id){
       exerciseRepository.deleteExercise(id);
   }
   
   public void deleteAllExercises(){
       exerciseRepository.deleteAllExercises();
   }
   
   public void changeStatus(Integer id,String status){
       exerciseRepository.updateStatusColumnInExercise(id, status);
   }
   
   public  ObservableList<Exercise> getExercises(){
       return exerciseRepository.getExercises();
   }
    
}

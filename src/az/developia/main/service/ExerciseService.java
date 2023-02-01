/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.developia.main.service;

import az.developia.main.model.Exercise;
import az.developia.main.repository.ExerciseRepository;

/**
 *
 * @author user
 */
public class ExerciseService {
   private static ExerciseRepository exerciseRepository;
   
   public static void insertExercise(Exercise e){
       exerciseRepository.insertExercise(e);
   }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.developia.main.service;

import az.developia.main.model.Category;
import az.developia.main.repository.CategoryRepository;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class CategoryService {
    private final CategoryRepository categoryRepository = new CategoryRepository();
    
    public void insertCategory(Category c){
        categoryRepository.insertCategory(c);
    }
    
    public void deleteCategory(Category c){
        categoryRepository.deleteCategory(c);
    }
    
    public ArrayList<String> getCategories(){
        return categoryRepository.getCategories();
    }
}

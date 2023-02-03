package az.developia.main.controller;

import az.developia.main.model.Exercise;
import az.developia.main.service.ExerciseService;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ExerciseController implements Initializable{

    @FXML
    private RadioButton allRB;

    @FXML
    private ComboBox<String> categoryCB;

    @FXML
    private TableColumn<?, ?> categoryCol;

    @FXML
    private Button changeStatusButton;

    @FXML
    private RadioButton completedRB;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private DatePicker dateDP;

    @FXML
    private TableColumn<?, ?> dayCol;

    @FXML
    private TextField dayTF;

    @FXML
    private CheckBox deleteAllCheckBox;

    @FXML
    private Button deleteButton;

    @FXML
    private Button deleteCategoryButton;

    @FXML
    private TableColumn<?, ?> exerciseCol;

    @FXML
    private TableView<Exercise> exercisesTable;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private Label infoLB;

    @FXML
    private Button insertButton;

    @FXML
    private Button newCategoryButton;

    @FXML
    private RadioButton noCompletedRB;

    @FXML
    private TextField searchTF;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private TextField taskTF;

    @FXML
    private Button updateButton;
    
    private final ExerciseService exerciseService = new ExerciseService();
    
    
    @FXML
    void insertButtonPressed(ActionEvent event){
         
         
         String task = taskTF.getText();
         String category = String.valueOf(categoryCB.getValue());
         String day = dayTF.getText();
         LocalDateTime registerDate = LocalDateTime.of(dateDP.getValue(), LocalDateTime.now().toLocalTime());
         String status = "Həll olunmayan";
         
         
         if(task.trim().length()>0&&category!=null&&day.trim().length()>0&&registerDate!=null){
         Exercise e = new Exercise();    
         e.setTask(task);
         e.setCategory(category);
         e.setDay(Integer.parseInt(day));
         e.setRegisterDate(registerDate);
         e.setStatus(status);
         exerciseService.insertExercise(e);
         loadExercises();
         }else{
             System.out.println("Melumatlar tam deyil");
         }
         
         
    }
    
     @FXML
    void deleteButtonPressed(ActionEvent event) {
         Exercise selectedExercise = exercisesTable.getSelectionModel().getSelectedItem();
         
         if(selectedExercise == null){
             System.out.println("Element seçilməyib");
         }else{
             Integer id  = selectedExercise.getId();
             exerciseService.deleteExercise(id);
             loadExercises();
         }
         
    }

    

    @FXML
    void updateButtonPressed(ActionEvent event) {
      Exercise selectedExercise = exercisesTable.getSelectionModel().getSelectedItem();
      
      if(selectedExercise==null){
          System.out.println("Element seçilməyib");
      }else{
         Integer id = selectedExercise.getId();
          
         String task = taskTF.getText();
         String category = String.valueOf(categoryCB.getValue());
         String day = dayTF.getText();
         LocalDateTime registerDate = LocalDateTime.of(dateDP.getValue(), LocalDateTime.now().toLocalTime());
         if(task.trim().length()>0&&category!=null&&day.trim().length()>0&&registerDate!=null){
         Exercise e = new Exercise();    
         e.setId(id);
         e.setTask(task);
         e.setCategory(category);
         e.setDay(Integer.parseInt(day));
         e.setRegisterDate(registerDate);
         exerciseService.updateExercise(e);
         loadExercises();
         }else{
             System.out.println("Melumatlar duzgun deyil");
         }
         
         } 
      }
    
      @FXML
    void exercisesTableMousePressed(MouseEvent event) {
        Exercise selectedExercise = exercisesTable.getSelectionModel().getSelectedItem();
        if(selectedExercise != null){
            taskTF.setText(selectedExercise.getTask());
            categoryCB.setValue(selectedExercise.getCategory());
            dayTF.setText(String.valueOf(selectedExercise.getDay()));
            dateDP.setValue(selectedExercise.getRegisterDate().toLocalDate());
        }
    }
    
    private void loadExercises(){
         exercisesTable.setItems(exerciseService.getExercises());
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
         idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
         exerciseCol.setCellValueFactory(new PropertyValueFactory<>("task"));
         categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
         dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));
         dateCol.setCellValueFactory(new PropertyValueFactory<>("registerDate"));
         statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));  
        
      categoryCB.getItems().addAll("Education","IT");
      loadExercises();
       
    }
    

}


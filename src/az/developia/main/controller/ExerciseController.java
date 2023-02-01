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
    private TableView<?> exercisesTable;

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
    
    private ExerciseService exerciseService;
    
    
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
         }else{
             System.out.println("Melumatlar tam deyil");
         }
         
         
    }
    
     @FXML
    void deleteButtonPressed(ActionEvent event) {

    }

    

    @FXML
    void updateButtonPressed(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      categoryCB.getItems().addAll("Education","IT");
    }
    

}


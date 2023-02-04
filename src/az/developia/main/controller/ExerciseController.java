package az.developia.main.controller;

import az.developia.main.model.Category;
import az.developia.main.model.Exercise;
import az.developia.main.service.CategoryService;
import az.developia.main.service.ExerciseService;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

public class ExerciseController implements Initializable {

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
    private RadioButton notCompletedRB;

    @FXML
    private TextField searchTF;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private TextField taskTF;

    @FXML
    private Button updateButton;

    private final ExerciseService exerciseService = new ExerciseService();

    private final CategoryService categoryService = new CategoryService();

    @FXML
    void insertButtonPressed(ActionEvent event) {

        String task = taskTF.getText();
        String category = String.valueOf(categoryCB.getValue());
        String day = dayTF.getText();
        LocalDateTime registerDate;
        if (dateDP.getValue() == null) {
            registerDate = LocalDateTime.now();
        } else {
            registerDate = LocalDateTime.of(dateDP.getValue(), LocalDateTime.now().toLocalTime());
        }

        String status = "Həll olunmayan";

        if (task.trim().length() > 0 && category != null && day.trim().length() > 0 && registerDate != null) {
            Exercise e = new Exercise();
            e.setTask(task);
            e.setCategory(category);
            e.setDay(Integer.parseInt(day));
            e.setRegisterDate(registerDate);
            e.setStatus(status);
            exerciseService.insertExercise(e);
            loadExercises();
        } else {
            System.out.println("Melumatlar tam deyil");
        }

    }

    @FXML
    void deleteButtonPressed(ActionEvent event) {

        if (deleteAllCheckBox.isSelected()) {

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bütün tapşırıqları silməkdə əminsizmi?", "Təhlükə", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                exerciseService.deleteAllExercises();
            }

        } else {
            Exercise selectedExercise = exercisesTable.getSelectionModel().getSelectedItem();

            if (selectedExercise == null) {
                System.out.println("Element seçilməyib");
            } else {
                Integer id = selectedExercise.getId();
                exerciseService.deleteExercise(id);
            }
        }
        loadExercises();

    }

    @FXML
    void updateButtonPressed(ActionEvent event) {
        Exercise selectedExercise = exercisesTable.getSelectionModel().getSelectedItem();

        if (selectedExercise == null) {
            System.out.println("Element seçilməyib");
        } else {
            Integer id = selectedExercise.getId();

            String task = taskTF.getText();
            String category = String.valueOf(categoryCB.getValue());
            String day = dayTF.getText();
            LocalDateTime registerDate;
            if (dateDP.getValue() == null) {
                registerDate = LocalDateTime.now();
            } else {
                registerDate = LocalDateTime.of(dateDP.getValue(), LocalDateTime.now().toLocalTime());
            }

            if (task.trim().length() > 0 && category != null && day.trim().length() > 0 && registerDate != null) {
                Exercise e = new Exercise();
                e.setId(id);
                e.setTask(task);
                e.setCategory(category);
                e.setDay(Integer.parseInt(day));
                e.setRegisterDate(registerDate);
                exerciseService.updateExercise(e);
                loadExercises();
            } else {
                System.out.println("Melumatlar duzgun deyil");
            }

        }
    }

    @FXML
    void exercisesTableMousePressed(MouseEvent event) {
        Exercise selectedExercise = exercisesTable.getSelectionModel().getSelectedItem();
        if (selectedExercise != null) {
            taskTF.setText(selectedExercise.getTask());
            categoryCB.setValue(selectedExercise.getCategory());
            dayTF.setText(String.valueOf(selectedExercise.getDay()));
            dateDP.setValue(selectedExercise.getRegisterDate().toLocalDate());
            
              String status = selectedExercise.getStatus();
            if (status.equals("Həll olunmayan")) { 
               infoLB.setPadding(new Insets(3,3,3,23));
               infoLB.setTextFill(Color.web("#FF2819"));
            } else {
                infoLB.setPadding(new Insets(3,3,3,34));
                infoLB.setTextFill(Color.web("#50FFDC"));
            }
            infoLB.setText(status);
        }
    }

    @FXML
    void newCategoryButtonPressed(ActionEvent event) {
        String category = JOptionPane.showInputDialog("Yeni kateqoriyanin adini daxil edin");

        if (category != null) {
            Category c = new Category();
            c.setCategory(category);
            categoryService.insertCategory(c);
            loadCategories();
        }
    }

    @FXML
    void deleteCategoryButtonPressed(ActionEvent event) {

        String category = categoryCB.getValue();

        if (category != null) {

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, category + " kateqoriyasını silməkdə əminsizmi?", "Təhlükə", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                Category c = new Category();
                c.setCategory(category);
                categoryService.deleteCategory(c);
                loadCategories();
            }

        }
    }

    @FXML
    void allRBPressed(ActionEvent event) {

    }

    @FXML
    void completedRBPressed(ActionEvent event) {

    }

    @FXML
    void notCompletedRBPressed(ActionEvent event) {

    }

    @FXML
    void changeStatusButtonPressed(ActionEvent event) {
        Exercise selectedExercise = exercisesTable.getSelectionModel().getSelectedItem();

        if (selectedExercise != null) {

            Integer id = selectedExercise.getId();
            String status = selectedExercise.getStatus();

            if (status.equals("Həll olunmayan")) {
                
                status = "Həll olunan";                
                exerciseService.changeStatus(id, status);
                
            } else {
                status = "Həll olunmayan";
                exerciseService.changeStatus(id, status);
                
            }
            loadExercises();

        }

    }
    
    public void searchTFKeyReleased(KeyEvent event){
       String search = searchTF.getText();
        loadExercisesBySearch(search);
        
    }

    private void loadExercises() {
        exercisesTable.setItems(exerciseService.getExercises());
    }

    private void loadCategories() {
        categoryCB.getItems().clear();
        categoryCB.getItems().addAll(categoryService.getCategories());
    }
    
    private void loadExercisesBySearch(String search){
        ObservableList<Exercise> exercises = exerciseService.getExercises();
        ObservableList<Exercise>  newExercises = FXCollections.observableArrayList();
        for( int i = 0; i < exercises.toArray().length; i++){
            if(exercises.get(i).getTask().contains(search)||exercises.get(i).getCategory().contains(search)){
                newExercises.add(exercises.get(i));
            }
        }
        exercisesTable.setItems(newExercises);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        exerciseCol.setCellValueFactory(new PropertyValueFactory<>("task"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("registerDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadExercises();
        loadCategories();
    }

}

package az.developia.main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ExerciseController {

    @FXML
    private RadioButton allRB;

    @FXML
    private ComboBox<?> categoryCB;

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

}


package UI.Controllers.Receptionist;

import UI.Elements.AdmBed;
import UI.Elements.PopUpBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdmissionAddController implements Initializable {

    @FXML
    private TableView<AdmBed> table;
    ObservableList<AdmBed> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<AdmBed, Long> bedID;

    @FXML
    private TableColumn<AdmBed, String> department;

    @FXML
    private Button cancelButton;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField patID;

    @FXML
    private TextField patName;

    @FXML
    private BorderPane admissionAddPane;

    @FXML
    private TextField staffID;

    @FXML
    void cancelAdd(MouseEvent event) {
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirmAdd(MouseEvent event) throws IOException {
        if (patName.getText().trim().isEmpty() || patID.getText().trim().isEmpty() || staffID.getText().trim().isEmpty()){
            PopUpBox.displayAlert("TextField Data cannot be Empty!", "Please fill the text-boxes with valid data to add Admission!");
        }
        // add data to backend
    }

    void displayBedList(){
        //add bed to table
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bedID.setCellValueFactory(new PropertyValueFactory<>("bedID"));
        department.setCellValueFactory(new PropertyValueFactory<>("department"));
        table.setItems(list);

        displayBedList();
    }
}

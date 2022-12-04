package UI.Controllers.Doctor;

import UI.Elements.PopUpBox;
import UI.Elements.Test;
import UI.Functions.JumpScene;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LabRequestController implements Initializable {

    @FXML
    private Button homeButton;

    @FXML
    private TextField patID;

    @FXML
    private BorderPane labRequestPane;

    @FXML
    private TextField reportID;
    ObservableList<Test> list = FXCollections.observableArrayList();
    @FXML
    private TableView<Test> table;

    @FXML
    private TableColumn<Test, String> tests;

    @FXML
    private TableColumn<Test, Long> ID;

    @FXML
    void gotoAppointmentTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(labRequestPane,"UI/appointmentTab_doctor.fxml",event);
    }

    @FXML
    void gotoHomeTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(labRequestPane,"UI/homeTabDoctor.fxml",event);
    }

    @FXML
    void gotoPatientTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(labRequestPane,"UI/patientsTab_doctor.fxml",event);
    }

    @FXML
    void gotoSettingsTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(labRequestPane,"UI/patientsTab_doctor.fxml",event);
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        PopUpBox.logout("Confirm Logout?");
        if(PopUpBox.log) JumpScene.changeScene(labRequestPane,"UI/login_staff.fxml",event);
    }

    @FXML
    void requestLab(MouseEvent event) {

    }

    void displayTests(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tests.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.setItems(list);
    }
}

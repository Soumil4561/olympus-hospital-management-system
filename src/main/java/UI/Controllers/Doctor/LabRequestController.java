package UI.Controllers.Doctor;

import UI.Elements.PopUpBox;
import UI.Elements.Test;
import UI.Functions.JumpScene;
import currentsession.CurrentUserInfo;
import database.DBFetchers.getLabInfo;
import hospital.Lab.LabTests;
import hospital.Staff.Doctor;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LabRequestController implements Initializable {

    @FXML
    private Button homeButton;

    @FXML
    private TextField patID;

    @FXML
    private BorderPane labRequestPane;

    @FXML
    private TextField remarks;

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
    void logout(MouseEvent event) throws IOException{
        PopUpBox.logout("Confirm Logout?");
        if(PopUpBox.log) JumpScene.changeScene(labRequestPane,"UI/login_staff.fxml",event);
    }

    @FXML
    void requestLab(MouseEvent event) throws SQLException {
        long patid = Long.parseLong(patID.getText());
        long reportid = Long.parseLong(reportID.getText());
        Test test = table.getSelectionModel().getSelectedItem();
        long test_id = test.getTestID();
        Doctor.createLabRequest(patid,test_id, CurrentUserInfo.getStaff().getStaff_id(), reportid);
    }

    void displayTests() throws SQLException {
        LabTests[] list = getLabInfo.getTestList();
        for (LabTests labTests : list) {
            Test test = new Test(labTests.getTest_name(), labTests.getTest_id());
            table.getItems().add(test);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new PropertyValueFactory<>("testID"));
        tests.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.setItems(list);

        try {
            displayTests();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

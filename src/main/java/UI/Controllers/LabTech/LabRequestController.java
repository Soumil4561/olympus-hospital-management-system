package UI.Controllers.LabTech;

import UI.Elements.LabReport;
import UI.Elements.PopUpBox;
import UI.Elements.Report;
import UI.Functions.JumpScene;
import database.DBFetchers.getLabInfo;
import hospital.Lab.LabRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LabRequestController implements Initializable {

    @FXML
    private Button homeButton;

    @FXML
    private TableColumn<LabReport, Long> patientID;

    @FXML
    private TableColumn<LabReport, String> remarks;

    @FXML
    private TableColumn<LabReport, Long> reportID;

    @FXML
    private TableColumn<LabReport, Long> staffID;

    @FXML
    private TableView<LabReport> table;
    ObservableList<LabReport> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<LabReport, String> test;

    @FXML
    private TableColumn<LabReport, Long> testID;

    @FXML
    private BorderPane patientPane;

    @FXML
    void gotoHome(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientPane,"UI/homeTabLabTech.fxml", event);
    }

    @FXML
    void gotoLabReport(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientPane,"UI/labReportForm_labtech.fxml", event);
    }

    @FXML
    void gotoSettingsTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientPane,"UI/settingsTab.fxml", event);
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        PopUpBox.logout("Confirm Logout?");
        if(PopUpBox.log) JumpScene.changeScene(patientPane,"UI/login_staff.fxml",event);
    }

    void displayList() throws SQLException {
        LabRequest[] list = getLabInfo.getLabRequests();
        for (LabRequest labRequest: list){
            LabReport report = new LabReport(
                    labRequest.getRemarks(),
                    labRequest.getTest_name(),
                    labRequest.getPatient_id(),
                    labRequest.getReport_id(),
                    labRequest.getStaff_id(),
                    labRequest.getTest_id());
            table.getItems().add(report);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        test.setCellValueFactory(new PropertyValueFactory<>("test"));
        testID.setCellValueFactory(new PropertyValueFactory<>("testID"));
        patientID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        reportID.setCellValueFactory(new PropertyValueFactory<>("reportID"));
        remarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        staffID.setCellValueFactory(new PropertyValueFactory<>("staffID"));
        table.setItems(list);

        try {
            displayList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

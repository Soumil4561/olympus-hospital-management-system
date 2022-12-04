package UI.Controllers.Nurse;

import UI.Elements.Admission;
import UI.Elements.PopUpBox;
import UI.Functions.JumpScene;
import database.DBFetchers.getAdmissionInfo;
import hospital.Admissions.AdmissionView;
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
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdmissionController implements Initializable {

    @FXML
    private TableColumn<?, ?> DIC;
    ObservableList<Admission> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> admissionID;

    @FXML
    private BorderPane admissionPane;

    @FXML
    private TableColumn<?, ?> bedID;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private GridPane gridpane;

    @FXML
    private Button homeButton;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> patientID;

    @FXML
    private TextField searchbox;

    @FXML
    private Button searchbutton;
    public String searchBoxContents;

    @FXML
    private TableView<Admission> table;

    @FXML
    void getAdmissionID(MouseEvent event) {
        table.getItems().clear();
        searchBoxContents= searchbox.getText();

    }

    @FXML
    void gotoHome(MouseEvent event) throws IOException {
      JumpScene.changeScene(admissionPane,"UI/homeTabNurse.fxml",event);
    }

    @FXML
    void gotoPatientTab(MouseEvent event) throws IOException {
      JumpScene.changeScene(admissionPane,"UI/patientsTab_nurser.fxml",event);
    }

    @FXML
    void gotoSettingsTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(admissionPane,"UI/settingsTab.fxml",event);
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        PopUpBox.logout("Confirm Logout?");
        if(PopUpBox.log) JumpScene.changeScene(admissionPane,"UI/login_staff.fxml",event);
    }



    private void viewDefaultAdmission() throws SQLException {
        AdmissionView[] admissionlist = getAdmissionInfo.currentAdmissions();
        for (AdmissionView admissionView : admissionlist) {
            Admission admission = new Admission();
            admission.setAdmissionID(admissionView.getAdmission_id());
            admission.setBedID(admissionView.getBed_id());
            admission.setDate((admissionView.getAdmission_date()));
            admission.setDIC(admissionView.getDoctor_name());
            admission.setName((admissionView.getPatient_name()));
            admission.setPatientID(admissionView.getPatient_id());

            table.getItems().add(admission);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        admissionID.setCellValueFactory(new PropertyValueFactory<>("admissionID"));
        patientID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        bedID.setCellValueFactory(new PropertyValueFactory<>("bedID"));
        DIC.setCellValueFactory(new PropertyValueFactory<>("DIC"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        try {
            viewDefaultAdmission();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

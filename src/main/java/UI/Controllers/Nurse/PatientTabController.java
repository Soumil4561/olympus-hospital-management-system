package UI.Controllers.Nurse;

import UI.Elements.PopUpBox;
import UI.Elements.User;
import UI.Functions.JumpScene;
import database.DBFetchers.getPatientInfo;
import hospital.Patient.Patient;
import javafx.beans.Observable;
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

public class PatientTabController implements Initializable {

    ObservableList<User> list = FXCollections.observableArrayList();
    @FXML
    private TableColumn<?, ?> fname;

    @FXML
    private TableColumn<?, ?> gender;

    @FXML
    private GridPane gridpane;

    @FXML
    private Button homeButton;

    @FXML
    private TableColumn<?, ?> lname;

    @FXML
    private BorderPane patientTabPane;

    @FXML
    private Button searchbutton;

    @FXML
    private TextField searchpatients;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<?, ?> uid;

    @FXML
    void getPatientDetails(MouseEvent event) throws SQLException {
        table.getItems().clear();
        Patient[] pat = getPatientInfo.searchPatients(searchpatients.getText());
        for (Patient patient : pat) {
            User user = new User();
            user.setUid(patient.getPatient_id());
            user.setFname((patient.getFname()));
            user.setLname((patient.getLname()));
            user.setStatus(patient.getStatus());
            user.setContact_no(patient.getContact_no());
            user.setDOB(patient.getDOB());
            user.setEmail(patient.getEmail());
            user.setGender(patient.getGender());

            table.getItems().add(user);

        }
    }

    @FXML
    void gotoAdmissionsTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientTabPane, "UI/admissionsTab_nurse.fxml", event);
    }

    @FXML
    void gotoHomeTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientTabPane, "UI/homeTabNurse.fxml", event);
    }

    @FXML
    void gotoSettingsTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientTabPane, "UI/settingsTab.fxml", event);
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        PopUpBox.logout("Confirm Logout?");
        if (PopUpBox.log) JumpScene.changeScene(patientTabPane, "UI/login_staff.fxml", event);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        uid.setCellValueFactory(new PropertyValueFactory<>("uid"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        table.setItems(list);

        table.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {


            }
        });
    }
}

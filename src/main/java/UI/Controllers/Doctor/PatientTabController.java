package UI.Controllers.Doctor;

import UI.Elements.PopUpBox;
import UI.Elements.User;
import UI.Functions.JumpScene;
import currentsession.CurrentPatientInfo;
import database.DBFetchers.getPatientInfo;
import hospital.Patient.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

import static UI.Controllers.Receptionist.PatientReceptionistController.inheritableUser;

public class PatientTabController implements Initializable {

    public static User inhtUser = new User();

    @FXML
    private TableColumn<User, String> fname;

    @FXML
    private TableColumn<User, String> lname;

    @FXML
    private TableColumn<User, String> status;

    @FXML
    private TableView<User> table;
    ObservableList<User> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<User, Integer> uid;

    @FXML
    private TableColumn<User, String> gender;

    @FXML
    private TextField searchpatients;

    @FXML
    private BorderPane patientTabPane;

    @FXML
    void getPatientDetails(MouseEvent event) throws SQLException {
        table.getItems().clear();
        Patient[] pat= getPatientInfo.searchPatients(searchpatients.getText());
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
    void gotoAppointmentTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientTabPane,"UI/appointmentTab_doctor.fxml", event);
    }

    @FXML
    void gotoHomeTab(MouseEvent event) throws IOException {
     JumpScene.changeScene(patientTabPane,"UI/homeTabDoctor.fxml", event);
    }

    @FXML
    void gotoLabRequestTab(MouseEvent event) throws IOException {
       JumpScene.changeScene(patientTabPane,"UI/labRequestTab_Doctor.fxml",event);
    }

    @FXML
    void gotoSettingsTab(MouseEvent event) throws IOException {
    JumpScene.changeScene(patientTabPane,"UI/settingsTab.fxml", event);
    }
    @FXML
    void logout(MouseEvent event) throws IOException {
        PopUpBox.logout("Confirm Logout?");
        if(PopUpBox.log) JumpScene.changeScene(patientTabPane,"UI/login_staff.fxml",event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        uid.setCellValueFactory(new PropertyValueFactory<>("uid"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        table.setItems(list);

        table.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                inhtUser = table.getSelectionModel().getSelectedItem();
                try {
                    CurrentPatientInfo.setPatient(getPatientInfo.searchPatients(inhtUser.getUid())[0]);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    PopUpBox.PastReportPopUp();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}

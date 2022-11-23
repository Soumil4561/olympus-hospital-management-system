package UI.Controllers;

import UI.Elements.PopUpBox;
import UI.Elements.User;
import UI.Functions.JumpScene;
import database.DBFetchers.getPatientInfo;
import hospital.Patient.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PatientReceptionistController implements Initializable {

    public static Long inheritableUser = 0L;

    @FXML
    private TableColumn<User, Long> contact_no;

    @FXML
    private TableColumn<User, String> fname;

    @FXML
    private TableColumn<User, String> lname;

    @FXML
    private BorderPane patientPane;

    @FXML
    private TableColumn<User, String> status;

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, Integer> uid;

    @FXML
    private TableColumn<User, Date> DOB;

    @FXML
    private TableColumn<User, String> gender;

    @FXML
    private TableColumn<User, String> email;

    @FXML
    private TextField searchbox;

    public String searchBoxContents;


    @FXML
    void getPatientDetails(MouseEvent event) throws SQLException {
        table.getItems().clear();
        searchBoxContents= searchbox.getText();
        Patient[] pat= getPatientInfo.searchPatients(searchBoxContents);
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
    void gotoHome(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientPane,"UI/homeTab.fxml",event);

    }

    @FXML
    void gotoAddPatient(MouseEvent event) throws IOException {
        PopUpBox.addPatientPopUp("Add Patient Details");
    }
    @FXML
    void gotoAdmissionsTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientPane,"UI/admissionsTab_receptionist.fxml",event);

    }

    ObservableList<User> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        contact_no.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        uid.setCellValueFactory(new PropertyValueFactory<>("uid"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        DOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        table.setItems(list);

        table.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                User tempUser = table.getSelectionModel().getSelectedItem();
                inheritableUser = tempUser.getUid();
               try {
                   PopUpBox.editformDisplay("Edit Patient Details");
              } catch (IOException e) {
                   throw new RuntimeException(e);
                }
            }
        });
    }
}

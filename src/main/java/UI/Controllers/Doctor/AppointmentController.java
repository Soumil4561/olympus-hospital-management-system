package UI.Controllers.Doctor;
import UI.Elements.PopUpBox;
import UI.Functions.JumpScene;
import hospital.Appointments.NewAppointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;

public class AppointmentController implements Initializable {

    @FXML
    private TableView<NewAppointment> table;
    ObservableList<NewAppointment> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<NewAppointment, Long> ID;

    @FXML
    private TableColumn<NewAppointment, String> fName;

    @FXML
    private TableColumn<NewAppointment, String> lName;

    @FXML
    private TableColumn<NewAppointment, Date> appDate;

    @FXML
    private TableColumn<NewAppointment, Time> appTime;

    @FXML
    private TableColumn<NewAppointment, String> status;

    @FXML
    private BorderPane appointmentPane;


    @FXML
    void gotoHome(MouseEvent event) throws IOException {
        JumpScene.changeScene(appointmentPane,"UI/homeTabDoctor.fxml",event);

    }
    @FXML
    void gotoPatientTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(appointmentPane,"UI/patientsTab_doctor.fxml",event);

    }
    @FXML
    void gotoSettingsTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(appointmentPane,"UI/settingsTab.fxml" ,event);
    }
    @FXML
    void logout(MouseEvent event) throws IOException {
        PopUpBox.logout("Confirm Logout?");
        JumpScene.changeScene(appointmentPane,"UI/login_staff.fxml",event);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
     ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
     fName.setCellValueFactory(new PropertyValueFactory<>("First Name"));
     lName.setCellValueFactory(new PropertyValueFactory<>("Last Name"));
     appDate.setCellValueFactory(new PropertyValueFactory<>("Appointment Date"));
     appTime.setCellValueFactory(new PropertyValueFactory<>("Appointment Time"));
     status.setCellValueFactory(new PropertyValueFactory<>("Status"));
     table.setItems(list);

    }

}

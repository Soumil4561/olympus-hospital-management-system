package UI.Controllers.Doctor;
import UI.Elements.Appointment;
import UI.Elements.PopUpBox;
import UI.Functions.JumpScene;
import database.DBFetchers.getAppointmentInfo;
import hospital.Appointments.AppointmentView;
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
import java.sql.SQLException;
import java.sql.Time;
import java.util.ResourceBundle;

public class AppointmentController implements Initializable {

    public static Appointment inhtAppointment;

    @FXML
    private TableView<Appointment> table;
    ObservableList<Appointment> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Appointment, Long> ID;

    @FXML
    private TableColumn<Appointment, String> Name;

    @FXML
    private TableColumn<Appointment, Long> reportID;

    @FXML
    private TableColumn<Appointment, Date> appDate;

    @FXML
    private TableColumn<Appointment, Time> appTime;

    @FXML
    private TableColumn<Appointment, String> status;

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
        if(PopUpBox.log) JumpScene.changeScene(appointmentPane,"UI/login_staff.fxml",event);
    }

    @FXML
    void gotoLabRequestTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(appointmentPane,"UI/labRequestTab_Doctor.fxml",event);
    }

    void displayAppointments() throws SQLException {
        long millis= System.currentTimeMillis();
        Date date = new Date(millis);
        AppointmentView[] list = getAppointmentInfo.appointmentOnDate(date);
        for (int i = 0; i < list.length; i++){
            Appointment appointment = new Appointment();
            appointment.setName(list[i].getPatient_name());
            appointment.setReportID(list[i].getReport_id());
            appointment.setID(list[i].getAppointment_id());
            appointment.setAppDate(list[i].getDate());
            appointment.setAppTime(list[i].getTime());
            appointment.setStatus(list[i].getStatus());
            appointment.setPatientID(list[i].getPatient_id());
            table.getItems().add(appointment);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
     ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
     Name.setCellValueFactory(new PropertyValueFactory<>("name"));
     reportID.setCellValueFactory(new PropertyValueFactory<>("reportID"));
     appDate.setCellValueFactory(new PropertyValueFactory<>("appDate"));
     appTime.setCellValueFactory(new PropertyValueFactory<>("appTime"));
     status.setCellValueFactory(new PropertyValueFactory<>("status"));
     table.setItems(list);

        try {
            displayAppointments();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        table.setOnMousePressed(event -> {
         if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                inhtAppointment = table.getSelectionModel().getSelectedItem();
             try {
                 PopUpBox.viewReportPopUp();
             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
         }
     });

    }
}




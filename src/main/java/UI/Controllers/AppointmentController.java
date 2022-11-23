package UI.Controllers;
import UI.Functions.JumpScene;
import hospital.Appointments.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;

public class AppointmentController implements Initializable {

    @FXML
    private TableView<Appointment> table;
    ObservableList<Appointment> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Appointment, Long> ID;

    @FXML
    private TableColumn<Appointment , String> fName;

    @FXML
    private TableColumn<Appointment , String> lName;

    @FXML
    private TableColumn<Appointment , Date> appDate;

    @FXML
    private TableColumn<Appointment , Time> appTime;

    @FXML
    private TableColumn<Appointment , String> status;

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

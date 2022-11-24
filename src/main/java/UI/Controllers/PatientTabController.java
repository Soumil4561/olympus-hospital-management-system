package UI.Controllers;

import UI.Functions.JumpScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class PatientTabController {


    @FXML
    private TableColumn<?, ?> contact_no;

    @FXML
    private TableColumn<?, ?> fname;

    @FXML
    private GridPane gridpane;



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
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> uid;

    @FXML
    void getPatientDetails(MouseEvent event) {

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
    void gotoLabRequestTab(MouseEvent event) {

    }

    @FXML
    void gotoSettingsTab(MouseEvent event) throws IOException {
    JumpScene.changeScene(patientTabPane,"UI/homeTabDoctor.fxml", event);
    }

}

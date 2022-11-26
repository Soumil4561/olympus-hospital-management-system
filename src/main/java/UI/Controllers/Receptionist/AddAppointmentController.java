package UI.Controllers.Receptionist;

import UI.Elements.Report;
import currentsession.CurrentPatientInfo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;

public class AddAppointmentController implements Initializable {
     private Report report = PatientEditController.inheritedReport;

    @FXML
    private TextField appointDate;

    @FXML
    private TextField appointTime;

    @FXML
    private Button cancelButton;

    @FXML
    private Button confirmButton;

    @FXML
    private Label deptname;

    @FXML
    private Label dic;

    @FXML
    private BorderPane patientAddPane;

    @FXML
    private Label patname;

    @FXML
    private Label reportid;

    @FXML
    void cancelAdd(MouseEvent event) {
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirmAdd(MouseEvent event) {
       Date appointdate = Date.valueOf(appointDate.getText());
       Time appointtime = Time.valueOf(appointTime.getText());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patname.setText(CurrentPatientInfo.getPatient().getFname()+" "+CurrentPatientInfo.getPatient().getLname());
        reportid.setText(String.valueOf(report.getReportid()));
        deptname.setText(report.getDeptname());
        dic.setText(report.getDic());
    }
}

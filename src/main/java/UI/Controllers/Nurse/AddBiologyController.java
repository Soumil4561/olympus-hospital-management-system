package UI.Controllers.Nurse;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import currentsession.CurrentPatientInfo;
import database.FileWriter.ReportGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;

public class AddBiologyController implements Initializable {

    public static String biology = null;

    @FXML
    private Button closebutton;

    @FXML
    private Button confirmbutton;

    @FXML
    private Label patientID;

    @FXML
    private Label patientName;

    @FXML
    private TextArea prescriptionField;

    @FXML
    private Label reportID;

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirm(MouseEvent event) throws JSchException, SftpException, IOException {
        biology = prescriptionField.getText();
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        Time time = new Time(millis);
        String type = "Patient Biology";
        String text = date +"~"+ time +"~"+type+"~"+biology;
        ReportGenerator.append(AdmissionController.inhtAdmission.getReportID(), text);
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patientID.setText(String.valueOf(CurrentPatientInfo.getPatient().getPatient_id()));
        patientName.setText(CurrentPatientInfo.getPatient().getFname() + " " + CurrentPatientInfo.getPatient().getLname());
        reportID.setText(String.valueOf(AdmissionController.inhtAdmission.getReportID()));
    }

}

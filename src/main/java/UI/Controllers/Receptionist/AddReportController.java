package UI.Controllers.Receptionist;

import UI.Elements.PopUpBox;
import currentsession.CurrentPatientInfo;
import database.DBFetchers.getDepartmentInfo;
import hospital.Department.Department;
import hospital.Patient.Patient;
import hospital.Patient.PatientReport;
import hospital.Staff.Reception;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddReportController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ChoiceBox<String> deptname;

    @FXML
    private TextField dic;

    @FXML
    private Label patid;

    @FXML
    private BorderPane patientAddPane;

    @FXML
    private Label patname;

    @FXML
    void cancelAdd(MouseEvent event) {
        Stage stage = (Stage) patid.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirmAdd(MouseEvent event) throws Exception {
        String dept_name = deptname.getValue();
        Patient patient = CurrentPatientInfo.getPatient();
        long staff_id = Long.parseLong(dic.getText());
        PatientReport report = new PatientReport(patient,dept_name,staff_id);
        Reception.createNewReport(report);
        Stage stage = (Stage) patid.getScene().getWindow();
        stage.close();
    }
    private void setChoices() throws SQLException {
        String[] dept = getDepartmentInfo.getDeptNames();
        deptname.getItems().addAll(dept);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patid.setText(String.valueOf(CurrentPatientInfo.getPatient().getPatient_id()));
        patname.setText(CurrentPatientInfo.getPatient().getFname()+" "+CurrentPatientInfo.getPatient().getLname());

        try {
            setChoices();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

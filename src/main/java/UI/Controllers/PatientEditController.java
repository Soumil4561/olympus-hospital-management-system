package UI.Controllers;

import database.DBFetchers.getPatientInfo;
import hospital.Patient.Patient;
import hospital.Staff.Reception;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PatientEditController implements Initializable {

    @FXML
    private TableColumn<?, ?> reportid;

    @FXML
    private TableView<?> table;
    @FXML
    private Label buttonnotif;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private Label patientNameLabel;

    @FXML
    private TextField patient_contact_no;

    @FXML
    private TextField patient_dob;

    @FXML
    private TextField patient_email;

    @FXML
    private TextField patient_fname;

    @FXML
    private TextField patient_gender;

    @FXML
    private TextField patient_lname;

    @FXML
    private TextField patient_status;

    @FXML
    private TextField patient_uid;


    @FXML
    void makeFieldsEditable(MouseEvent event) throws SQLException {
        patient_dob.setEditable(true);
        patient_fname.setEditable(true);
        patient_lname.setEditable(true);
        patient_gender.setEditable(true);
        patient_status.setEditable(true);
        patient_email.setEditable(true);
        patient_contact_no.setEditable(true);
    }

    @FXML
    void setValues(MouseEvent event) throws SQLException {
        String fname = patient_fname.getText();
        String lname= patient_lname.getText();
        String gender=patient_gender.getText();
        Long number= Long.valueOf(patient_contact_no.getText());
        String email=patient_email.getText();
        String status=patient_status.getText();
        Date date= Date.valueOf(patient_dob.getText());
        Patient patient=new Patient(PatientReceptionistController.inheritableUser,fname,lname,date,gender,number,email,status);
        Reception.editPatientDetails(patient);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patient_dob.setEditable(false);
        patient_fname.setEditable(false);
        patient_lname.setEditable(false);
        patient_gender.setEditable(false);
        patient_status.setEditable(false);
        patient_email.setEditable(false);
        patient_contact_no.setEditable(false);

        try {
            Patient[] pat= getPatientInfo.searchPatients(PatientReceptionistController.inheritableUser);
            patient_dob.setText(pat[0].getDOB().toString());
            patient_fname.setText(pat[0].getFname());
            patient_lname.setText(pat[0].getLname());
            patient_email.setText(pat[0].getEmail());
            patient_uid.setText(String.valueOf(pat[0].getPatient_id()));
            patient_contact_no.setText(String.valueOf(pat[0].getContact_no()));
            patient_gender.setText(pat[0].getGender());
            patient_status.setText(pat[0].getStatus());
            patientNameLabel.setText(pat[0].getFname() + pat[0].getLname());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package UI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class EditController implements Initializable {

    @FXML
    private Button editDetailsButton;

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
    private TextField patient_reports;

    @FXML
    private TextField patient_status;

    @FXML
    private TextField patient_uid;

    @FXML
    private Button saveChangesButton;


    @FXML
    void makeFieldsEditable(MouseEvent event) {
        patient_dob.setEditable(true);
        patient_fname.setEditable(true);
        patient_lname.setEditable(true);
        patient_gender.setEditable(true);
        patient_reports.setEditable(true);
        patient_status.setEditable(true);
        patient_email.setEditable(true);
        patient_contact_no.setEditable(true);
    }

    @FXML
    void setValues(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patient_dob.setEditable(false);
        patient_fname.setEditable(false);
        patient_lname.setEditable(false);
        patient_gender.setEditable(false);
        patient_reports.setEditable(false);
        patient_status.setEditable(false);
        patient_email.setEditable(false);
        patient_contact_no.setEditable(false);
    }
}

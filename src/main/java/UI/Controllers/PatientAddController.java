package UI.Controllers;

import UI.Elements.PopUpBox;
import hospital.Patient.Patient;
import hospital.Staff.Reception;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class PatientAddController {

    @FXML
    private BorderPane patientAddPane;

    @FXML
    private Button cancelButton;

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
    void cancelAdd(MouseEvent event) {
       Stage stage = (Stage) cancelButton.getScene().getWindow();
       stage.close();
    }

    @FXML
    void confirmAdd(MouseEvent event) throws SQLException, IOException {
        String fname = patient_fname.getText();
        String lname= patient_lname.getText();
        String gender=patient_gender.getText();
        Long number= Long.valueOf(patient_contact_no.getText());
        String email=patient_email.getText();
        Date date= Date.valueOf(patient_dob.getText());
        Patient patient = new Patient(fname,lname,date,gender,number,email);
        if(Reception.createNewPatient(patient)) {
            PopUpBox.confirmAdd("Patient Added Successfully!");
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
        else {
            PopUpBox.display("YOU SUCK!");
        }
    }

}

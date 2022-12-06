package UI.Controllers.Receptionist;

import UI.Elements.PopUpBox;
import UI.Functions.JumpScene;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import hospital.Staff.Reception;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdmissionViewController implements Initializable {

    @FXML
    private Label admissionID;

    @FXML
    private BorderPane admissionPane;

    @FXML
    private Label bedID;

    @FXML
    private Button closeButton;

    @FXML
    private Label dic;

    @FXML
    private Label doa;

    @FXML
    private Label patientID;

    @FXML
    private Label patientName;

    @FXML
    private Label patientNameLabel;

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void viewConfirmPopUp(MouseEvent event) throws IOException, JSchException, SQLException, SftpException {
        PopUpBox.confirmRemoveAdmissions();
        if(PopUpBox.confirm) {
            Reception.removeAdmission(AdmissionController.inhtadm.getBedID(),AdmissionController.inhtadm.getReportID(),AdmissionController.inhtadm.getAdmissionID(),AdmissionController.inhtadm.getPatientID());
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        admissionID.setText(String.valueOf(AdmissionController.inhtadm.getAdmissionID()));
        patientID.setText(String.valueOf(AdmissionController.inhtadm.getPatientID()));
        patientName.setText(AdmissionController.inhtadm.getName());
        dic.setText(AdmissionController.inhtadm.getDIC());
        bedID.setText(String.valueOf(AdmissionController.inhtadm.getBedID()));
        doa.setText(String.valueOf(AdmissionController.inhtadm.getDate()));
    }
}

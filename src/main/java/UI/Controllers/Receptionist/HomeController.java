package UI.Controllers.Receptionist;

import UI.Functions.JumpScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class HomeController {
    @FXML
    private BorderPane homePane;

    @FXML
    private Button patientButton;

    @FXML
    void gotoAdmissionTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/admissionsTab_receptionist.fxml", event);
    }

    @FXML
    void gotoPatientTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/patientsTab_receptionist.fxml", event);
    }

    @FXML
    void gotoSettingsTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/settingsTab.fxml", event);

    }

    public void logout(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/confirmLogout.fxml",event);
    }
}

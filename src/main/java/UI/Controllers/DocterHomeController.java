package UI.Controllers;

import UI.Functions.JumpScene;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.awt.*;
import java.io.IOException;


public class DocterHomeController {

@FXML
private BorderPane homePane;

@FXML
private Button patButton;

@FXML
private Button appButton;

@FXML
private Button mailButton;

    @FXML
    void gotoPatientTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/patientsTab_doctor.fxml",event);
    }
    @FXML
    void gotoAppointmentTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/appointmentTab_doctor.fxml",event);
    }

    @FXML
    void gotoMailTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/mailTab.fxml",event);
    }
    @FXML
    void gotoSettingsTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/settingsTab.fxml",event);
    }

}

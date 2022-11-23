package UI.Controllers;

import UI.Functions.JumpScene;
import currentsession.CurrentUserInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


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

}

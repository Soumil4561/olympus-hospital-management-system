package UI.Controllers;

import UI.Functions.JumpScene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsController {

    @FXML
    private TextField DOB;

    @FXML
    private Button changePassButton;

    @FXML
    private Button editButton;

    @FXML
    private TextField email;

    @FXML
    private TextField gender;

    @FXML
    private Button homeButton;

    @FXML
    private TextField mobNumber;

    @FXML
    private TextField name;

    @FXML
    private BorderPane patientPane;

    @FXML
    private TextField resiAddress;

    @FXML
    private TextField uid;

    @FXML
    void gotoChangePassTab(MouseEvent event) {

    }

    @FXML
    void gotoEditTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientPane,"UI/editTab.fxml",event);
    }

    @FXML
    void gotoHomeTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientPane,"UI/homeTabDoctor.fxml",event);
    }

}

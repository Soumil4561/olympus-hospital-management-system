package UI.Controllers;

import UI.Functions.JumpScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class EditTabController {

    @FXML
    private TextField DOB;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField email;

    @FXML
    private TextField gender;

    @FXML
    private Button homeButton;

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private Button profileButton;

    @FXML
    private TextField resiAddress;

    @FXML
    private Button saveButton;

    @FXML
    private BorderPane pane;

    @FXML
    void gotoHomeTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(pane,"UI/homeTabDoctor.fxml",event);
    }

    @FXML
    void gotoProfileOverview(MouseEvent event) throws IOException {
        JumpScene.changeScene(pane,"UI/settingsTab.fxml",event);
    }

    @FXML
    void saveChanges(MouseEvent event) {

    }

}

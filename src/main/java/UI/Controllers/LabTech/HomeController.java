package UI.Controllers.LabTech;

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
    private Button setButton;

    @FXML
    void gotoLabReports(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/labReportForm_labtech.fxml", event);
    }

    @FXML
    void gotoLabRequests(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/labRequests_labtech.fxml", event);
    }

    @FXML
    void gotoMailTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/mailTab.fxml", event);
    }

    @FXML
    void gotoSettingsTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/settingsTab.fxml", event);
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        JumpScene.changeScene(homePane,"UI/homeTabLabTech.fxml", event);
    }

}

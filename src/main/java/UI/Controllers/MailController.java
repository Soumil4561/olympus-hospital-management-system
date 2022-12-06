package UI.Controllers;

import UI.Functions.JumpScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MailController {
    @FXML
    private BorderPane mailPane;

    @FXML
    private TextField searchbox;

    @FXML
    private Button searchbutton;

    @FXML
    private TableView<?> table;


    @FXML
    void gotoHome(MouseEvent event) throws IOException {
        switch (LoginController.USER) {
            case 1 -> JumpScene.changeScene(mailPane, "UI/homeTab.fxml", event);
            case 2 -> JumpScene.changeScene(mailPane, "UI/homeTabDoctor.fxml", event);
            case 3 -> JumpScene.changeScene(mailPane, "UI/homeTabNurse.fxml", event);
            case 4 -> JumpScene.changeScene(mailPane, "UI/homeTabLabTech.fxml", event);
        }
    }

}



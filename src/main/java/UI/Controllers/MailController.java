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
        JumpScene.changeScene(mailPane,"UI/homeTabDoctor.fxml",event);

    }

}



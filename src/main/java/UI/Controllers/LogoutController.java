package UI.Controllers;

import UI.Functions.JumpScene;
import currentsession.CurrentUserInfo;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class LogoutController {

    @FXML
    private BorderPane pane;

    @FXML
    void gotoHome(MouseEvent event) throws IOException {
      if(CurrentUserInfo.getStaff().getType().equals("Doctor")){
          JumpScene.changeScene(pane,"UI/homeTabDoctor.fxml",event);
      }
      else if(CurrentUserInfo.getStaff().getType().equals("Receptionist")){
          JumpScene.changeScene(pane,"UI/homeTab.fxml",event);
      }
    }

    @FXML
    void gotoLogin(MouseEvent event) throws IOException {
      JumpScene.changeScene(pane,"UI/login_staff.fxml",event);
    }

}

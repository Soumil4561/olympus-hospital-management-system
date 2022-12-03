package UI.Controllers.Settings;
import UI.Elements.PopUpBox;
import UI.Functions.JumpScene;
import currentsession.CurrentUserInfo;
import database.DBFetchers.CredentialCheck;
import hospital.Staff.Staff;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ChangePasswordController {

    @FXML
    private TextField confirmPassword;

    @FXML
    private TextField cuurPassword;

    @FXML
    private Button homeButton;

    @FXML
    private TextField newPassword;

    @FXML
    private BorderPane pane;

    @FXML
    private Button profileButton;

    @FXML
    void gotoEditTab(MouseEvent event) throws IOException {
      JumpScene.changeScene(pane,"UI/editTab.fxml", event);
    }

    @FXML
    void gotoHomeTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(pane,"UI/homeTabDoctor.fxml", event);
    }

    @FXML
    void gotoProfileOverview(MouseEvent event) throws IOException {
      JumpScene.changeScene(pane,"UI/settingsTab.fxml",event);
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        PopUpBox.logout("Confirm Logout?");
        if(PopUpBox.log) JumpScene.changeScene(pane,"UI/login_staff.fxml",event);
    }
    @FXML
    void confirmPassword(MouseEvent event) throws SQLException {
        String current = cuurPassword.getText();
        long id=CurrentUserInfo.getStaff().getStaff_id();
        if (!Objects.equals(CredentialCheck.loginCredentials(id, current), "")){
            String newPass= newPassword.getText();
            String confPass= confirmPassword.getText();
            if(Objects.equals(newPass, confPass)){
                Staff.changePassword(CurrentUserInfo.getStaff().getStaff_id(),confPass);
            }
            else{
                try {
                PopUpBox.newPassNotMatchingPopUp("Error");
            }
                catch (Exception e){
                System.out.println("cant open alertbox");
            }
            }
        }
        else{
            try {
                PopUpBox.oldPasswordNotMatching("Error");
            }
            catch (Exception e){
                System.out.println("cant open alertbox");
            }

        }
        }
    }




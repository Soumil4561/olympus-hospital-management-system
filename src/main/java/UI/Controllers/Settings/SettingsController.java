package UI.Controllers.Settings;

import UI.Functions.JumpScene;
import currentsession.CurrentUserInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

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
    void gotoEditTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientPane,"UI/editTab.fxml",event);
    }

    @FXML
    void gotoHomeTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientPane,"UI/homeTabDoctor.fxml",event);
    }
    @FXML
    void gotoChangePassTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientPane,"UI/changePassword.fxml",event);
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientPane,"UI/login_staff.fxml",event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uid.setEditable(false);
        name.setEditable(false);
        DOB.setEditable(false);
        gender.setEditable(false);
        mobNumber.setEditable(false);
        email.setEditable(false);
        resiAddress.setEditable(false);

        uid.setText(String.valueOf(CurrentUserInfo.getStaff().getStaff_id()));
        name.setText(CurrentUserInfo.getStaff().getFname()+ " " + CurrentUserInfo.getStaff().getLname());
        DOB.setText(String.valueOf(CurrentUserInfo.getStaff().getDate_of_birth()));
        gender.setText(CurrentUserInfo.getStaff().getGender());
        mobNumber.setText(String.valueOf(CurrentUserInfo.getStaff().getContact_no()));
        email.setText(CurrentUserInfo.getStaff().getEmail());
        resiAddress.setText(CurrentUserInfo.getStaff().getResidential_address());

    }
}

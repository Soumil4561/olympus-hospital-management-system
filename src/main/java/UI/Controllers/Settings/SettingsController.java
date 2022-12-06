package UI.Controllers.Settings;

import UI.Controllers.LoginController;
import UI.Elements.PopUpBox;
import UI.Functions.JumpScene;
import currentsession.CurrentUserInfo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

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
        JumpScene.changeScene(patientPane, "UI/Settings_editTab.fxml",event);
    }

    @FXML
    void gotoHomeTab(MouseEvent event) throws IOException {
        switch (LoginController.USER) {
            case 1 -> JumpScene.changeScene(patientPane, "UI/homeTab.fxml", event);
            case 2 -> JumpScene.changeScene(patientPane, "UI/homeTabDoctor.fxml", event);
            case 3 -> JumpScene.changeScene(patientPane, "UI/homeTabNurse.fxml", event);
            case 4 -> JumpScene.changeScene(patientPane, "UI/homeTabLabTech.fxml", event);
        }
    }
    @FXML
    void gotoChangePassTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(patientPane, "UI/Settings_changePassword.fxml",event);
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        PopUpBox.logout("Confirm Logout?");
        if(PopUpBox.log) JumpScene.changeScene(patientPane,"UI/login_staff.fxml",event);
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

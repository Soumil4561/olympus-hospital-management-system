package UI.Controllers.Settings;

import UI.Elements.PopUpBox;
import UI.Functions.JumpScene;
import currentsession.CurrentUserInfo;
import database.DBFetchers.getDepartmentInfo;
import hospital.Staff.Staff;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditTabController implements Initializable {

    @FXML
    private TextField DOB;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField email;

    @FXML
    private TextField fName;


    @FXML
    private Button homeButton;

    @FXML
    private TextField lName;

    @FXML
    private BorderPane pane;

    @FXML
    private TextField phone;

    @FXML
    private Button profileButton;

    @FXML
    private TextField resiAddress;

    @FXML
    private ChoiceBox<String> genderSelection;

    @FXML
    private Button saveButton;

    @FXML
    void gotoHomeTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(pane,"UI/homeTabDoctor.fxml",event);
    }

    @FXML
    void gotoProfileOverview(MouseEvent event) throws IOException {
        JumpScene.changeScene(pane,"UI/settingsTab.fxml",event);
    }
    @FXML
    void exit(MouseEvent event) throws IOException {
        PopUpBox.logout("Confirm Logout?");
        if(PopUpBox.log) JumpScene.changeScene(pane,"UI/login_staff.fxml",event);
    }
    @FXML
    void gotoChangePassword(MouseEvent event) throws IOException {
        JumpScene.changeScene(pane,"UI/changePassword.fxml",event);
    }

    private void setChoices() throws SQLException {
        String[] dept = {"Male", "Female", "Other"};
        genderSelection.getItems().addAll(dept);
    }

    @FXML
    void saveChanges(MouseEvent event) throws SQLException {
        String fname = fName.getText();
        String lname = lName.getText();
        Date date= Date.valueOf(DOB.getText());
        String sex = genderSelection.getValue();
        Long mobnum = Long.valueOf(phone.getText());
        String mail = email.getText();
        String homeaddress = resiAddress.getText();
        Staff staff = new Staff(CurrentUserInfo.getStaff().getStaff_id(),fname,lname,sex,mobnum,date,CurrentUserInfo.getStaff().getDepartment_id(),mail,homeaddress);
        Staff.editAccountDetails(staff);
        CurrentUserInfo.setStaff(staff);
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fName.setEditable(true);
        lName.setEditable(true);
        DOB.setEditable(true);
        phone.setEditable(true);
        email.setEditable(true);
        resiAddress.setEditable(true);

        fName.setText(CurrentUserInfo.getStaff().getFname());
        lName.setText(CurrentUserInfo.getStaff().getLname());
        DOB.setText(String.valueOf(CurrentUserInfo.getStaff().getDate_of_birth()));
        phone.setText(String.valueOf(CurrentUserInfo.getStaff().getContact_no()));
        email.setText(CurrentUserInfo.getStaff().getEmail());
        resiAddress.setText(CurrentUserInfo.getStaff().getResidential_address());
        try {
            setChoices();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

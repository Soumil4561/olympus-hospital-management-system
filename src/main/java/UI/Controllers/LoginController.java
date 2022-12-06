package UI.Controllers;

import UI.Elements.PopUpBox;
import UI.Functions.JumpScene;
import currentsession.CurrentUserInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.SQLException;

import hospital.Staff.Staff;


public class LoginController {
    public static byte USER = 0;
    long uid;
    String pass;

    @FXML
    private BorderPane loginPane;
    @FXML
    private TextField pass_input;

    @FXML
    private TextField uid_input;

    @FXML
    void gotoStaffScene(MouseEvent event) throws IOException, SQLException {
        uid = Long.parseLong(uid_input.getText());
        pass = pass_input.getText();
        if(Staff.Login(uid,pass)){
            String typeOfStaff = CurrentUserInfo.getStaff().getType();
            switch (typeOfStaff) {
                case "Receptionist" -> {
                    JumpScene.changeScene(loginPane, "UI/homeTab.fxml", event);
                    USER = 1;
                }
                case "Doctor" -> {
                    JumpScene.changeScene(loginPane, "UI/homeTabDoctor.fxml", event);
                    USER = 3;
                }
                case "Nurse" -> {
                    JumpScene.changeScene(loginPane, "UI/homeTabNurse.fxml", event);
                    USER = 3;
                }
                case "Lab Tech" -> {
                    JumpScene.changeScene(loginPane, "UI/homeTabLabTech.fxml", event);
                    USER = 4;
                }
            }

        }
        else {
            try {
                PopUpBox.display("Wrong Username or Password");
            } catch (Exception e){
                System.out.println("cant open alertbox");
            }
        }
    }


    @FXML
    void gotoStaffHome(ActionEvent event) throws SQLException, IOException {
        uid = Long.parseLong(uid_input.getText());
        pass = pass_input.getText();
        if(Staff.Login(uid,pass)){
            String typeOfStaff = CurrentUserInfo.getStaff().getType();
            switch (typeOfStaff) {
                case "Receptionist" -> {
                    JumpScene.changeScene(loginPane, "UI/homeTab.fxml", event);
                    USER = 1;
                }
                case "Doctor" -> {
                    JumpScene.changeScene(loginPane, "UI/homeTabDoctor.fxml", event);
                    USER = 3;
                }
                case "Nurse" -> {
                    JumpScene.changeScene(loginPane, "UI/homeTabNurse.fxml", event);
                    USER = 3;
                }
                case "Lab Tech" -> {
                    JumpScene.changeScene(loginPane, "UI/homeTabLabTech.fxml", event);
                    USER = 4;
                }
            }

        }
        else {
            try {
                PopUpBox.display("Wrong Username or Password");
            } catch (Exception e){
                System.out.println("Can't Open Alert-Box!");
            }
        }
    }
}
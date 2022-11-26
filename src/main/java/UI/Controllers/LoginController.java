package UI.Controllers;

import UI.Elements.PopUpBox;
import UI.Functions.JumpScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.SQLException;

import hospital.Staff.Staff;


public class LoginController {
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
        String typeOfStaff=LoginRequest(uid,pass);
        if(typeOfStaff.equals("Receptionist")){
            JumpScene.changeScene(loginPane,"UI/homeTab.fxml",event);
        }
        else if(typeOfStaff.equals("Doctor")){
            JumpScene.changeScene(loginPane,"UI/homeTabDoctor.fxml",event);

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
        String typeOfStaff=LoginRequest(uid,pass);
        if(typeOfStaff.equals("Receptionist")){
            JumpScene.changeScene(loginPane,"UI/homeTab.fxml",event);
        }
        else if(typeOfStaff.equals("Doctor")){
            JumpScene.changeScene(loginPane,"UI/homeTabDoctor.fxml",event);

        }
        else {
            try {
                PopUpBox.display("Wrong Username or Password");
            } catch (Exception e){
                System.out.println("cant open alertbox");
            }
        }
    }

    public String LoginRequest(long id,String password) throws SQLException {
       return Staff.Login(id,password);
    }

}
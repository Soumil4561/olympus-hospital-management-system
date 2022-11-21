package UI.Controllers;

import UI.Elements.AlertBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import hospital.Staff.Staff;


public class LoginController {
    long uid;
    String pass;
    @FXML
    private Button logInButton;

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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("UI/homeTab.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            loginPane = loader.load();
            stage.getScene().setRoot(loginPane);
            stage.show();
        }
        else {
            try {
                AlertBox.display("Wrong Username or Password");
            } catch (Exception e){
                System.out.println("cant open alertbox");
            }
        }
    }

    public String LoginRequest(long id,String password) throws SQLException {
       return Staff.Login(id,password);
    }

}
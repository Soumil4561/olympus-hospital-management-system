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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import hospital.Staff.Staff;


public class LoginController implements Initializable {
    long uid;
    String pass;
    long uidBack = 1;
    String passBack = "q";
    @FXML
    private Button logInButton;

    @FXML
    private ChoiceBox<String> staff_choice;
    private final String[] staff = {"Receptionist", "Doctor", "Nurse"};
    @FXML
    private TextField pass_input;

    @FXML
    private TextField uid_input;

    @FXML
    void gotoStaffScene(MouseEvent event) throws IOException, SQLException {
        uid = Long.parseLong(uid_input.getText());
        pass = pass_input.getText();

        if(isReceptionist(uid,pass)){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("UI/patientsTab_receptionist.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            try {
                AlertBox.display("Wrong Username or Password");
            } catch (Exception e){
                System.out.println("cant open alertbox");
            }
        }

    }

    public boolean isReceptionist(long id,String password) throws SQLException {
       return Staff.Login(id,password);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staff_choice.getItems().addAll(staff);
    }
}
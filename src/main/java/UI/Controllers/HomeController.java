package UI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HomeController {
    @FXML
    private BorderPane homePane;

    @FXML
    private Button patientButton;

    @FXML
    void gotoAdmissionTab(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("UI/admissionsTab_receptionist.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        homePane = loader.load();
        stage.getScene().setRoot(homePane);
        stage.show();
    }

    @FXML
    void gotoPatientTab(MouseEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("UI/patientsTab_receptionist.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            homePane = loader.load();
            stage.getScene().setRoot(homePane);
            stage.show();
    }

}

package UI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class docterHomeController {

@FXML
private BorderPane homePane;

@FXML
private Button patButton;

@FXML
private Button appButton;

@FXML
private Button mailButton;

    @FXML
    void gotoPatientTab(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("/UI/patientsTab_doctor.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        homePane = loader.load();
        stage.getScene().setRoot(homePane);
        stage.show();
    }

    @FXML
    void gotoMailTab(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("/UI/mail.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        homePane = loader.load();
        stage.getScene().setRoot(homePane);
        stage.show();
    }



}

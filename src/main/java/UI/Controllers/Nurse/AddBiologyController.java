package UI.Controllers.Nurse;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBiologyController implements Initializable {

    public static String biology = null;

    @FXML
    private Button closebutton;

    @FXML
    private Button confirmbutton;

    @FXML
    private Label patientID;

    @FXML
    private Label patientName;

    @FXML
    private TextArea prescriptionField;

    @FXML
    private Label reportID;

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirm(MouseEvent event) {
        biology = prescriptionField.getText();
        // add to table n database code
        //
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}

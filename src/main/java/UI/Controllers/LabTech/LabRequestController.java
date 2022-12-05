package UI.Controllers.LabTech;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class LabRequestController {

    @FXML
    private GridPane gridpane;

    @FXML
    private Button homeButton;

    @FXML
    private TableColumn<?, ?> patientID;

    @FXML
    private BorderPane patientPane;

    @FXML
    private TableColumn<?, ?> remarks;

    @FXML
    private TableColumn<?, ?> reportID;

    @FXML
    private TableColumn<?, ?> staffID;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> test;

    @FXML
    private TableColumn<?, ?> testID;

    @FXML
    void gotoHome(MouseEvent event) {

    }

    @FXML
    void gotoLabReport(MouseEvent event) {

    }

    @FXML
    void gotoSettingsTab(MouseEvent event) {

    }

    @FXML
    void logout(MouseEvent event) {

    }

}

package UI.Controllers;

import UI.Elements.Admission;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class AdmissionController implements Initializable {
    @FXML
    private TableView<Admission> table;
    ObservableList<Admission> list = FXCollections.observableArrayList(

    );

    @FXML
    private TableColumn<Admission, Long> bedID;

    @FXML
    private TableColumn<Admission, Date> date;
    @FXML
    private TableColumn<Admission, Long> admissionID;

    @FXML
    private BorderPane admissionPane;

    @FXML
    private TableColumn<Admission, String> DIC;

    @FXML
    private TableColumn<Admission, String> name;

    @FXML
    private GridPane gridpane;

    @FXML
    private TableColumn<Admission, Long> patientID;

    @FXML
    private TextField searchbox;

    @FXML
    private Button searchbutton;
    public String searchBoxContents;

    public AdmissionController() {
    }

    @FXML
    void getAdmissionID(MouseEvent event) {
        table.getItems().clear();
        searchBoxContents= searchbox.getText();

        for () {

            table.getItems().add();
        }
    }

    @FXML
    void gotoAddAdmissionPopOut(MouseEvent event) {

    }

    @FXML
    void gotoHome(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("UI/homeTab.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        admissionPane = loader.load();
        stage.getScene().setRoot(admissionPane);
        stage.show();
    }

    @FXML
    void gotoPatientTab(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("UI/patientsTab_receptionist.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        admissionPane = loader.load();
        stage.getScene().setRoot(admissionPane);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        admissionID.setCellValueFactory(new PropertyValueFactory<>("admissionID"));
        patientID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        bedID.setCellValueFactory(new PropertyValueFactory<>("bedID"));
        DIC.setCellValueFactory(new PropertyValueFactory<>("DIC"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        table.setItems(list);
    }
}

package UI.Controllers;

import UI.Elements.User;
import database.DBFetchers.getPatientInfo;
import hospital.Patient.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public String searchBoxContents;

    @FXML
    private TableColumn<User, Long> contact_no;

    @FXML
    private TableColumn<User, String> fname;

    @FXML
    private Button searchButton;
    @FXML
    private TableColumn<User, String> lname;

    @FXML
    private TextField searchbox;

    @FXML
    void getPatientDetails(MouseEvent event) throws SQLException {
        table.getItems().clear();
        searchBoxContents= searchbox.getText();
        Patient[] pat= getPatientInfo.searchPatients(searchBoxContents);
        for (int i = 0; i<pat.length; i++) {
            User user = new User();
            user.setUid(pat[i].getPatient_id());
            user.setFname((pat[i].getFname()));
            user.setLname((pat[i].getLname()));
            user.setStatus(pat[i].getStatus());
            user.setContact_no(pat[i].getContact_no());
            table.getItems().add(user);
        }
    }

    @FXML
    void gotoHome(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UI/homeTab.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private TableColumn<User, String> status;

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, Integer> uid;

    ObservableList<User> list = FXCollections.observableArrayList(
            );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        contact_no.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        uid.setCellValueFactory(new PropertyValueFactory<>("uid"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        table.setItems(list);
    }
}

package UI.Controllers;

import UI.Elements.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
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
    void getPatientDetails(MouseEvent event) {
        searchBoxContents= searchbox.getText();

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

package UI.Controllers.Receptionist;

import UI.Elements.AdmBed;
import UI.Elements.PopUpBox;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import database.DBFetchers.getBedInfo;
import hospital.Admissions.NewAdmission;
import hospital.Bed.Bed;
import hospital.Staff.Reception;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdmissionAddController implements Initializable {

    @FXML
    private TableView<AdmBed> table;
    ObservableList<AdmBed> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<AdmBed, Long> bedID;

    @FXML
    private TableColumn<AdmBed, String> department;

    @FXML
    private Button cancelButton;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField patID;

    @FXML
    private TextField reportID;

    @FXML
    private BorderPane admissionAddPane;

    @FXML
    private TextField staffID;

    @FXML
    void cancelAdd(MouseEvent event) {
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirmAdd(MouseEvent event) throws IOException, SQLException, JSchException, SftpException {
        if(table.getSelectionModel().getSelectedItem() == null){
            PopUpBox.displayAlert("FUCK ON BED!", "PLeASe SeLecT a BeD tO fUck!");
        }
        if (reportID.getText().trim().isEmpty() || patID.getText().trim().isEmpty() || staffID.getText().trim().isEmpty()){
            PopUpBox.displayAlert("TextField Data cannot be Empty!", "Please fill the text-boxes with valid data to add Admission!");
        }

        long patid = Long.parseLong(patID.getText());
        long staffid = Long.parseLong(staffID.getText());

        long reportid = Long.parseLong(reportID.getText());
        AdmBed bed = table.getSelectionModel().getSelectedItem();
        long bedID = bed.getBedID();
        NewAdmission admission = new NewAdmission(patid,staffid, reportid,bedID);
        Reception.createNewAdmission(admission);
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    void displayBedList() throws SQLException {
        Bed[] emptyBeds = getBedInfo.emptyBeds();
        for(int i=0; i<emptyBeds.length; i++){
            AdmBed bed = new AdmBed();
            bed.setBedID(emptyBeds[i].getBed_id());
            bed.setDepartment(emptyBeds[i].getDept_name());

            table.getItems().add(bed);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bedID.setCellValueFactory(new PropertyValueFactory<>("bedID"));
        department.setCellValueFactory(new PropertyValueFactory<>("department"));
        table.setItems(list);

        try {
            displayBedList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

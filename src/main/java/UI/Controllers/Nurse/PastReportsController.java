package UI.Controllers.Nurse;

import UI.Controllers.Doctor.PatientTabController;
import UI.Elements.PopUpBox;
import UI.Elements.Report;
import currentsession.CurrentPatientInfo;
import currentsession.CurrentUserInfo;
import database.DBFetchers.getReportInfo;
import hospital.Patient.PatientReportView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PastReportsController implements Initializable {

    public static Report inhtReport = new Report();

    @FXML
    private TableColumn<Report, Date> date;

    @FXML
    private TableColumn<Report, Long> reportid;

    @FXML
    private TableColumn<Report, String> deptname;

    @FXML
    private TableColumn<Report, String> dic;

    @FXML
    private TableView<Report> table;
    ObservableList<Report> list = FXCollections.observableArrayList();

    @FXML
    private BorderPane reportListPane;

    @FXML
    private Label patientNameLabel;

    @FXML
    private TextField patient_name;

    @FXML
    private TextField patient_uid;

    @FXML
    private Button closeButton;

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    void displayReports() throws SQLException {
        PatientReportView[] list = getReportInfo.searchPatientReportsforDN(CurrentPatientInfo.getPatient().getPatient_id(), CurrentUserInfo.getStaff().getDepartment_id());
        for (PatientReportView patientReportView : list) {
            Report report = new Report();
            report.setReportid(patientReportView.getReport_id());
            report.setDate(patientReportView.getStart_date());
            report.setDic(patientReportView.getDoctor_name());
            report.setDeptname(patientReportView.getDepartment_name());
            report.setDic_id(patientReportView.getStaff_id());
            table.getItems().add(report);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patient_name.setEditable(false);
        patient_uid.setEditable(false);

        patient_name.setText(UI.Controllers.Nurse.PatientTabController.inhtedUser.getFname()+" "+ UI.Controllers.Nurse.PatientTabController.inhtedUser.getLname());
        patientNameLabel.setText(UI.Controllers.Nurse.PatientTabController.inhtedUser.getFname()+" "+ UI.Controllers.Nurse.PatientTabController.inhtedUser.getLname());
        patient_uid.setText(String.valueOf(UI.Controllers.Nurse.PatientTabController.inhtedUser.getUid()));

        reportid.setCellValueFactory(new PropertyValueFactory<>("reportid"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        dic.setCellValueFactory(new PropertyValueFactory<>("dic"));
        deptname.setCellValueFactory(new PropertyValueFactory<>("deptname"));

        table.setItems(list);

        try {
            displayReports();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        table.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 2){
                inhtReport = table.getSelectionModel().getSelectedItem();
                try {
                    PopUpBox.nurseViewReport();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}

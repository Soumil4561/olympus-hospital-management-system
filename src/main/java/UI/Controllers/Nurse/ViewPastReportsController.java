package UI.Controllers.Nurse;

import UI.Elements.ParsedReport;
import database.FileWriter.FileReader;
import hospital.Patient.PatientFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewPastReportsController implements Initializable {


    @FXML
    private TableView<ParsedReport> table;
    ObservableList<ParsedReport> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<ParsedReport, Time> time;

    @FXML
    private TableColumn<ParsedReport, String> type;

    @FXML
    private TableColumn<ParsedReport, Date> date;

    @FXML
    private TableColumn<ParsedReport, String> description;

    @FXML
    private Button closeButton;

    @FXML
    private Label patientID;

    @FXML
    private Label patientName;

    @FXML
    private Label patientNameLabel;

    @FXML
    private Label reportID;

    @FXML
    private BorderPane reportPane;

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    void displayReportContent() throws Exception {
        ArrayList<String> output = FileReader.readReports(PastReportsController.inhtReport.getReportid());
        PatientFile file = PatientFile.parseFile(output);

        for (int i = 0; i < file.getNodeList().size(); i++) {
            ParsedReport report = new ParsedReport();
            report.setTime(file.getNodeList().get(i).getTime());
            report.setDate(file.getNodeList().get(i).getDate());
            report.setDescription(file.getNodeList().get(i).getDescription());
            report.setType(file.getNodeList().get(i).getType());

            table.getItems().add(report);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patientName.setText(PatientTabController.inhtedUser.getFname()+" "+ PatientTabController.inhtedUser.getLname());
        patientID.setText(String.valueOf(PatientTabController.inhtedUser.getUid()));
        reportID.setText(String.valueOf(PastReportsController.inhtReport.getReportid()));
        patientNameLabel.setText(PatientTabController.inhtedUser.getFname()+" "+ PatientTabController.inhtedUser.getLname());

        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        table.setItems(list);

        try {
            displayReportContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

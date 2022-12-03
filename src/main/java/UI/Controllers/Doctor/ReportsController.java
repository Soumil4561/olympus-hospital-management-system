package UI.Controllers.Doctor;

import UI.Elements.ParsedReport;
import UI.Elements.PopUpBox;
import database.FileWriter.FileReader;
import hospital.Patient.PatientFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReportsController implements Initializable {

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
    private Button editDetailsButton;

    @FXML
    private Label onclicknotif;

    @FXML
    private Label patientID;

    @FXML
    private Label patientName;

    @FXML
    private Label patientNameLabel;

    @FXML
    private Label reportID;

    @FXML
    private Button saveChangesButton;

    @FXML
    private TextArea desriptionField;

    void displayReportContent() throws IOException {
        ArrayList<String> output = FileReader.readReports(121216);
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

    @FXML
    void addDiagnosis(MouseEvent event) {
        //
        // add data to table and database
        //
        desriptionField.clear();
    }

    @FXML
    void setDiagnosis(MouseEvent event) {
        // add data to file
    }


    @FXML
    void gotoAddPrescription(MouseEvent event) throws IOException {
        PopUpBox.viewPrescriptionPopUp();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));

        try {
            displayReportContent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

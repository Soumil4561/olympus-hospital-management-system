package UI.Controllers.Doctor;

import UI.Elements.Appointment;
import UI.Elements.ParsedReport;
import UI.Elements.PopUpBox;
import UI.Functions.JumpScene;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import database.FileWriter.FileReader;
import database.FileWriter.ReportGenerator;
import hospital.Patient.PatientFile;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReportsController implements Initializable {
    ParsedReport transf = new ParsedReport();
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
    private BorderPane reportPane;

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

    void displayReportContent() throws Exception {
        ArrayList<String> output = FileReader.readReports(AppointmentController.inhtAppointment.getReportID());
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
    void refresh(MouseEvent event) throws IOException {
        JumpScene.changeScene(reportPane,"UI/viewReportDoctor_PopUp.fxml",event);
    }

    @FXML
    void addDiagnosis(MouseEvent event) {
        ParsedReport report = new ParsedReport();
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        Time time = new Time(millis);

        report.setDate(date);
        report.setTime(time);
        report.setDescription(desriptionField.getText());
        report.setType("Diagnosis");

        transf= report;
        table.getItems().add(report);

        desriptionField.clear();

        onclicknotif.setText("The Diagnosis has been added!");
        onclicknotif.setVisible(true);
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> onclicknotif.setVisible(false));
        pause.play();
    }

    @FXML
    void setDiagnosis(MouseEvent event) throws IOException {
        Date date = transf.getDate();
        Time time = transf.getTime();
        String type = transf.getType();
        String dis= transf.getDescription();
        String text = date+"~"+time+"~"+type+"~"+dis;
        try{
            ReportGenerator.append(AppointmentController.inhtAppointment.getReportID(), text);
        }
        catch (IOException e) {
            UI.Elements.PopUpBox.displayAlert("Error", "Cannot update Report. Please try again later.");
        } catch (JSchException e) {
            throw new RuntimeException(e);
        } catch (SftpException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) saveChangesButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    void gotoAddPrescription(MouseEvent event) throws IOException {
        PopUpBox.viewPrescriptionPopUp();
    }

    public void addPrescriptionToTable(){
        if (AddPrescriptionController.prescription == null) return;

        ParsedReport report = new ParsedReport();
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        Time time = new Time(millis);

        report.setDate(date);
        report.setTime(time);
        report.setDescription(AddPrescriptionController.prescription);
        AddPrescriptionController.prescription = null;
        report.setType("Prescription");

        table.getItems().add(report);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        onclicknotif.setVisible(false);
        patientName.setText(AppointmentController.inhtAppointment.getName());
        patientID.setText(String.valueOf(AppointmentController.inhtAppointment.getPatientID()));
        reportID.setText(String.valueOf(AppointmentController.inhtAppointment.getReportID()));
        patientNameLabel.setText(AppointmentController.inhtAppointment.getName());

        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        table.setItems(list);

        addPrescriptionToTable();

        try {
            displayReportContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

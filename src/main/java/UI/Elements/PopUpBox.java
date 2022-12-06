package UI.Elements;

import UI.Functions.JumpScene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpBox {
    public static Boolean log = false;
    public static Boolean confirm = false;
    @FXML
    private Button closeButton;

    @FXML
    private BorderPane pane;

    @FXML
    private static Label warninglabel;

    @FXML
    void removeAdm(MouseEvent event) {
        boolean remove = true;
        confirm = remove;
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void gotoLogin(MouseEvent event) throws IOException {
        boolean logout = true;
        log = logout;
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public static void popUp(String title,String location) throws IOException {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(location));
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);

        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.showAndWait();
    }

    public static void displayAlert(String title, String warning) throws IOException {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/UI/warningbox.fxml"));
        window.initModality(Modality.APPLICATION_MODAL);
        warninglabel.setText(warning);
        window.setTitle(title);
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.showAndWait();
    }

    public static void display(String title) throws IOException {
        popUp(title,"/UI/alertbox.fxml");
    }

    public static void confirmRemoveAdmissions() throws IOException {
        popUp("Confirm Admission Removal","/UI/confirmRemoveAdm.fxml" );
    }

    public static void editformDisplay(String title) throws IOException {
        popUp(title,"/UI/patientEditForm_PopUp.fxml");
    }

    public static void confirmAdd(String title) throws IOException {
        popUp(title,"/UI/confirmAdd_PopUp.fxml");
    }

    public static void addPatientPopUp(String title) throws IOException {
        popUp(title,"/UI/patientAddForm_PopOut.fxml");
    }

    public static void newPassNotMatchingPopUp(String title) throws IOException {
       popUp(title,"/UI/newPassNotMatchingAlert.fxml");
    }

    public static void oldPasswordNotMatching(String title) throws IOException {
        popUp(title,"/UI/oldPasswordErrorAlert.fxml");

    }
    public static void logout(String title) throws IOException {
        popUp(title,"/UI/confirmLogout.fxml");
    }

    public static void addAppointmentPopUp(String title) throws IOException {
        popUp(title,"/UI/addAppointmentForm_receptionist.fxml");
    }

    public static void addReportPopUp(String title) throws IOException {
        popUp(title,"/UI/createReportForm_PopUp.fxml");
    }

    public static void viewReportPopUp() throws IOException {
        popUp("View Patient Report","/UI/viewReportDoctor_PopUp.fxml" );
    }

    public static void viewPrescriptionPopUp() throws IOException {
        popUp("Add Prescription in Report","/UI/addPrescription_PopUp.fxml" );
    }

    public static void viewAddAdmissionPopUp() throws IOException {
        popUp("Add Admission Details","/UI/addAdmissionsForm_receptionist.fxml" );
    }

    public static void viewPastReportPopUp() throws IOException {
        popUp("View Patient's Report","/UI/viewPastReportDoctor_PopUp.fxml" );
    }

    public static void PastReportPopUp() throws IOException {
        popUp("View Patient's Past Reports","/UI/patientPastReports_PopUp_Doctor.fxml" );
    }

    public static void ReportNursePopUp() throws IOException {
        popUp("View Patient's Past Report for Nurse","/UI/patientPastReports_PopUp_Nurse.fxml" );
    }

    public static void nurseViewReport() throws IOException {
        popUp("View Patient's Report","/UI/viewPastReportNurse_PopUp.fxml" );
    }

    public static void viewAdmissionViewPopUp() throws IOException {
        popUp("Patient's Admission Details","/UI/addmissionDetails_receptionist.fxml" );

    }

}

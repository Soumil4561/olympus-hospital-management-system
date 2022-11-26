package UI.Elements;

import UI.Functions.JumpScene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpBox {

    @FXML
    private Button closeButton;

    @FXML
    private BorderPane pane;

    @FXML
    void gotoLogin(MouseEvent event) throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public static void display(String title) throws IOException {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/UI/alertbox.fxml"));
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);

        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.showAndWait();
    }

    public static void editformDisplay(String title) throws IOException {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/UI/patientEditForm_PopUp.fxml"));
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);

        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.showAndWait();
    }

    public static void confirmAdd(String title) throws IOException {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/UI/confirmAdd_PopUp.fxml"));
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);

        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.showAndWait();
    }

    public static void addPatientPopUp(String title) throws IOException {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/UI/patientAddForm_PopOut.fxml"));
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);

        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.showAndWait();
    }

    public static void newPassNotMatchingPopUp(String title) throws IOException {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/UI/newPassNotMatchingAlert.fxml"));
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.showAndWait();

    }

    public static void oldPasswordNotMatching(String title) throws IOException {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/UI/oldPasswordErrorAlert.fxml"));
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.showAndWait();

    }
    public static void logout(String title) throws IOException {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/UI/confirmLogout.fxml"));
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.showAndWait();

    }
}

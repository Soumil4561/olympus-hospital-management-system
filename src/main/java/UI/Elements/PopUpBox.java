package UI.Elements;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpBox {

    @FXML
    private Button closeButton;

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public static void display(String title) throws IOException {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("UI/alertbox.fxml"));
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
}

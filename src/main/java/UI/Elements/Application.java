package UI.Elements;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/UI/login_staff.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("HMS");
        stage.setScene(scene);
        stage.show();
    }

    public static void launchApp() {
        launch();
    }
}
package UI.Controllers;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.Buffer;
import java.util.ResourceBundle;

public class LoginTemp implements Initializable {
    @FXML
    private VBox loginBox;

    public void applyBlur(){
        Image image = new Image("C:\\Users\\manis\\IdeaProjects\\olympus-hospital-management-system\\src\\main\\resources\\UI\\css\\images\\bg2.jpeg");
        ImageView imageView = new ImageView(image);
        BoxBlur blur = new BoxBlur(3,3,3);
//        loginBox.setEffect(blur);
        BackgroundImage bgImage = new BackgroundImage(imageView.getImage(),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        loginBox.setBackground(new Background(bgImage));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        applyBlur();
    }
}

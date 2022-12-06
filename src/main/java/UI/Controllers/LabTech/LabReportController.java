package UI.Controllers.LabTech;

import UI.Elements.PopUpBox;
import UI.Functions.JumpScene;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import ssh.sshConnect;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LabReportController {

    @FXML
    private TextField filedest;

    @FXML
    private Button homeButton;

    @FXML
    private TextField labID;

    @FXML
    private BorderPane labRequestPane;

    @FXML
    private TextField patID;

    @FXML
    private TextField reportID;

    private List<File> files;

    @FXML
    void applyChanges(MouseEvent event) throws IOException, JSchException, SftpException {
        for (File files: files){
            if ( !reportID.getText().isEmpty() && !patID.getText().isEmpty()) {
                String filepath = files.getAbsolutePath();
                String filename = files.getName();
                long reportid = Long.parseLong(reportID.getText());
                sshConnect.uploadReport(filepath, reportid, filename);
            }
        }
        JumpScene.changeScene(labRequestPane,"UI/homeTabLabTech.fxml", event);
    }

    @FXML
    void chooseFile(MouseEvent event) {
        FileChooser fc = new FileChooser();
        List<File> fileList = fc.showOpenMultipleDialog(null);
        files = fileList;
        for (File file: fileList){
            filedest.setText(file.getAbsolutePath());
        }
    }

    @FXML
    void gotoHomeTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(labRequestPane,"UI/homeTabLabTech.fxml", event);
    }

    @FXML
    void gotoLabRequests(MouseEvent event) throws IOException {
        JumpScene.changeScene(labRequestPane,"UI/labRequests_labtech.fxml", event);
    }

    @FXML
    void gotoSettingsTab(MouseEvent event) throws IOException {
        JumpScene.changeScene(labRequestPane,"UI/settingsTab.fxml", event);
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        PopUpBox.logout("Confirm Logout?");
        if(PopUpBox.log) JumpScene.changeScene(labRequestPane,"UI/login_staff.fxml",event);
    }

}

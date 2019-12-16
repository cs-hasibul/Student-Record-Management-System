package studentrecordmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class InfController implements Initializable {

    @FXML
    private Button insert_btn;
    @FXML
    private Button view_btn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Insert(ActionEvent event) throws IOException {
        StudentRecordManagementSystem.load("Login.fxml");
    }

    @FXML
    private void View(ActionEvent event) throws IOException {
        StudentRecordManagementSystem.load("RegistryLogin.fxml");
    }

}

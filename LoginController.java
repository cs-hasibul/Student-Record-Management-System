package studentrecordmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {

    @FXML
    private TextField user_field;
    @FXML
    private PasswordField pass_field;
    @FXML
    private Button login_btn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Login(ActionEvent event) throws IOException {
        DBC connect = new DBC();
        Connection conn = connect.getConnect();
        try {
            String query = "SELECT * FROM admin";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int flag = 0;
            while (rs.next()) {
                if (user_field.getText().equals(rs.getString("username"))) {
                    if (pass_field.getText().equals(rs.getString("password"))) {
                        StudentRecordManagementSystem.load("Insert.fxml");
                    } else {
                        flag = 1;
                    }
                }

            }
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Connection error");
        }
    }

}

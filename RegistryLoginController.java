
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
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;


public class RegistryLoginController implements Initializable {
   
    @FXML
    private TextField usr_fld;
    @FXML
    private TextField psw_fld;
    @FXML
    private Button lgin_btn;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      @FXML
    private void lgn(ActionEvent event) throws IOException {
        DBC connect = new DBC();
        Connection conn = connect.getConnect();
        try {
            String query = "SELECT * FROM registry";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int flag = 0;
            while (rs.next()) {
                if (usr_fld.getText().equals(rs.getString("usrname"))) {
                    if (psw_fld.getText().equals(rs.getString("pw"))) {
                        StudentRecordManagementSystem.load("search.fxml");
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

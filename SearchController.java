
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class SearchController implements Initializable {
    @FXML
    private TextField id_field;
    @FXML
    private Button search_btn;
    @FXML
    private Label name;
    @FXML
    private Label program;
    @FXML
    private Label phone;
    @FXML
    private Label email;
    @FXML
    private Button bck_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Search(ActionEvent event) throws IOException{
        DBC connect = new DBC();
        Connection conn = connect.getConnect();
        try{
            String query = "SELECT * FROM student WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id_field.getText()));
            ResultSet rs = ps.executeQuery();
            rs.next();
            name.setText(rs.getString("name"));
            program.setText(rs.getString("program"));
            phone.setText(rs.getString("phone"));
            email.setText(rs.getString("email"));
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    void Back(ActionEvent event) throws IOException
    {
        StudentRecordManagementSystem.load("inf.fxml");
    }
    
}

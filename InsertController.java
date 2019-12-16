
package studentrecordmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class InsertController implements Initializable {
    @FXML
    private TextField id_field;
    @FXML
    private TextField program_field;
    @FXML
    private TextField name_field;
    @FXML
    private TextField phn_field;
    @FXML
    private TextField email_field;
    @FXML
    private Button submit_btn;
    @FXML
    private Button logout_field;

    @FXML
    private Button update_btn;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    void Update(ActionEvent event) throws IOException
    {
        DBC connect = new DBC();
        Connection conn = connect.getConnect();
        try
        {
            String query ="UPDATE student SET name = ?, program = ?, phone = ?, email = ? WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1,name_field.getText());
            ps.setString(2,program_field.getText());
            ps.setString(3,phn_field.getText());
            ps.setString(4,email_field.getText());
            ps.setInt(5, Integer.parseInt(id_field.getText()));
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void Submit(ActionEvent event) {
        DBC connect = new DBC();
        Connection conn = connect.getConnect();
        try
        {
            String query = "INSERT INTO student(id,name,program,phone,email) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id_field.getText()));
            ps.setString(2,name_field.getText());
            ps.setString(3,program_field.getText());
            ps.setString(4,phn_field.getText());
            ps.setString(5,email_field.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Data insertion failed");
        }
    }

    @FXML
    private void Logout(ActionEvent event) throws IOException{
        StudentRecordManagementSystem.load("inf.fxml");
    }
    
}

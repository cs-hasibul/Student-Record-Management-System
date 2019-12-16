package studentrecordmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
    Connection connect;
    Connection getConnect()
    {
        try{
        String url="jdbc:mysql://localhost:3306/db_student";
        String user="root";
        String pass="";
        connect = DriverManager.getConnection(url,user,pass);
        return connect;
        }
        catch (SQLException e)
        {
            return null;
        }
    }
    
}

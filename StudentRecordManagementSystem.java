package studentrecordmanagementsystem;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StudentRecordManagementSystem extends Application {
    static Stage stage;
    static AnchorPane base = new AnchorPane();
    
    static void load(String link) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(StudentRecordManagementSystem.class.getResource(link));
        base.getChildren().removeAll();
        base = loader.load();
        Scene scne = new Scene(base);
        stage.setScene(scne);
        stage.show();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
      this.stage=stage;
      load("inf.fxml");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

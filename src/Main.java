import javafx.FXMLLoader;
import javafx.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Application;

import java.net.URL;
import java.sql.SQLException;


public class Main extends Application {

    public static void main(String[] args) {

        MainService mainService = new MainService();
        try {
            mainService.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("main.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    
}

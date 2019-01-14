package sample;

import db.ModelDriver;
import db.SamochodDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import db.Driver;


public class Main extends Application {

	private static Stage pStage;
	
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Views/Logowanie.fxml"));

        pStage = primaryStage;
        primaryStage.setTitle("Logowanie");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return pStage;
    }
    
    public static void main(String[] args) {

        launch(args);
        Driver.closeSharedConnection();
        System.exit(0);
    }
}

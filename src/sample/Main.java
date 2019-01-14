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

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Views/Aplikacja.fxml"));

        primaryStage.setTitle("Aplikacja");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
        Driver.closeSharedConnection();
        System.exit(0);
    }
}

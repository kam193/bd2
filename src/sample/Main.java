package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import db.Driver;


public class Main extends Application {

	private static Stage pStage;
	
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Views/Logowanie/Logowanie.fxml"));

        pStage = primaryStage;
        primaryStage.getIcons().add(new Image("icons/icon.png"));
        primaryStage.setTitle("Logowanie");
        primaryStage.setScene(new Scene(root, 370, 170));
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

package sample;

import data_structure.Komis;
import data_structure.Model;
import data_structure.Samochod;
import db.KomisDriver;
import db.ModelDriver;
import db.SamochodDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import db.Driver;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Komis samochodowy");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Model model = new Model("model1", "marka1", 5, 100, 2);
        Komis komis = new Komis(1, "Nazwa1", "Ulicowa", "1/2", "Warszawa", "00", "123456789");
        Samochod samochod = new Samochod(1, "Czarny", "Dostepny", 0, "jakis", 200,
                "manualna", "AAA", 5, "Taki tam samochodzik", model, komis);
//        ModelDriver.insert(model);
//        KomisDriver.insert(komis);
        SamochodDriver.insert(samochod);
        for (Samochod sam : SamochodDriver.getAll())
            System.out.println(sam.toString());
//        launch(args);
        Driver.closeSharedConnection();
        System.exit(0);
    }
}

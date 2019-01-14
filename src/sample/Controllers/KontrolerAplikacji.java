package sample.Controllers;

import db.ModelDriver;
import db.SamochodDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class KontrolerAplikacji {

    public void WyszukajSamochod(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/WyszukajSamochod.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Wyszukaj Samochód");
        stage.setScene(new Scene(root, 450, 400));
        stage.show();
    }

    public void WyszukajSpotkanie(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/WyszukajSpotkanie.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Wyszukaj Spotkanie");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }

    public void SzukajSpotkania(ActionEvent actionEvent) {
        // zaprogramowac sytuacje
    }

    public void WyszukajJazde(ActionEvent keyEvent) {
    }

    public void WyszukajTransakcje(ActionEvent keyEvent) {
    }

    public void DodajSamochod(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/DodajSamochod.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Dodaj Samochód");
        stage.setScene(new Scene(root, 450, 400));
        stage.show();
    }

    public void DodajHistorie(ActionEvent keyEvent) {
    }

    public void DodajSpotkanie(ActionEvent keyEvent) {
    }

    public void DodajTransakcje(ActionEvent keyEvent) {
    }

    public void ModyfikujSamochod(ActionEvent keyEvent) {
    }

    public void ModyfikujSpotkanie(ActionEvent keyEvent) {
    }

    public void ModyfikujJazde(ActionEvent keyEvent) {
    }

    public void ModyfikujTransakcje(ActionEvent keyEvent) {
    }

    public void UsunSamochod(ActionEvent keyEvent) {
    }

    public void OdwolajSpotkanie(ActionEvent keyEvent) {
    }

    public void OdwolajJazde(ActionEvent keyEvent) {
    }

    public void OdwolajTransakcje(ActionEvent keyEvent) {
    }
}

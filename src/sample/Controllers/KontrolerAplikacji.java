package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KontrolerAplikacji {

    public void WyszukajSamochod(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Wyszukaj/WyszukajSamochod.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Wyszukaj Samochód");
        stage.setScene(new Scene(root, 450, 400));
        stage.show();
    }

    public void WyszukajSpotkanie(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Wyszukaj/WyszukajSpotkanie.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Wyszukaj Spotkanie");
        stage.setScene(new Scene(root, 450, 250));
        stage.show();
    }

    public void WyszukajJazde(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Wyszukaj/WyszukajJazdeProbna.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Wyszukaj Jazde");
        stage.setScene(new Scene(root, 450, 200));
        stage.show();
    }

    public void WyszukajTransakcje(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Wyszukaj/WyszukajTransakcje.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Wyszukaj Transakcje");
        stage.setScene(new Scene(root, 500, 250));
        stage.show();
    }

    public void DodajSamochod(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Dodaj/DodajSamochod.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Dodaj Samochód");
        stage.setScene(new Scene(root, 450, 400));
        stage.show();
    }

    public void DodajHistorie(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Dodaj/DodajHistorie.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Dodaj Historię");
        stage.setScene(new Scene(root, 450, 300));
        stage.show();
    }

    public void DodajJazde(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Dodaj/DodajJazdeProbna.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Dodaj Jazde");
        stage.setScene(new Scene(root, 425, 200));
        stage.show();
    }

    public void DodajSpotkanie(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Dodaj/DodajSpotkanie.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Dodaj Spotkanie");
        stage.setScene(new Scene(root, 450, 400));
        stage.show();
    }

    public void DodajTransakcje(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Dodaj/DodajTransakcje.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Dodaj Transakcje");
        stage.setScene(new Scene(root, 450, 250));
        stage.show();
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

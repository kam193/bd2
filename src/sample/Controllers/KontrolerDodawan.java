package sample.Controllers;

import data_structure.Komis;
import data_structure.Model;
import data_structure.Samochod;
import db.KomisDriver;
import db.ModelDriver;
import db.SamochodDriver;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KontrolerDodawan {
    public TextField VIN;
    public TextField day;
    public TextField month;
    public TextField year;
    public TextArea komentarz;
    public ChoiceBox Kolor;
    public ChoiceBox Status;
    public TextField Przebieg;
    public TextField Silnik;
    public TextField Moc;
    public ChoiceBox Skrzynia;
    public ChoiceBox Paliwo;
    public TextField Spalanie;
    public TextField Model;
    public TextField Marka;
    public TextField Cena;
    public ChoiceBox Platnosc;
    public TextField KlientID;
    public TextField SamochodID;
    public TextField PracownikID;
    public TextField KomisID;
    public TextField Opis;

    public void initialize() {
        if (Kolor != (null)) {
            Kolor.getItems().add("Czerwony");
            Kolor.getItems().add("Szary");
            Kolor.getItems().add("Zolty");
            Kolor.getItems().add("Srebrny");
            Kolor.getItems().add("Niebieski");
            Kolor.getItems().add("Czarny");
            Kolor.getItems().add("Rozowy");
            Kolor.getItems().add("Zielony");
            Kolor.getItems().add("Granatowy");
            Kolor.getItems().add("Fioletowy");
            Kolor.getItems().add("Bialy");
            Kolor.getItems().add("Brazowy");
            Kolor.getItems().add("Pomaranczowy");
            Kolor.getItems().add("Turkusowy");
        }
        if (Status != (null)) {
            Status.getItems().add("Sprzedany");
            Status.getItems().add("Dostepny");
            Status.getItems().add("Niedost.");
        }
        if (Skrzynia != (null)) {
            Skrzynia.getItems().add("Manualna");
            Skrzynia.getItems().add("Automat.");
        }
        if (Paliwo != (null)) {
            Paliwo.getItems().add("Diesel");
            Paliwo.getItems().add("Benzyna");
            Paliwo.getItems().add("Gaz");
            Paliwo.getItems().add("Hybryda");
        }
        if (Platnosc != (null)) {
            Platnosc.getItems().add("Karta");
            Platnosc.getItems().add("Gotowka");
        }
    }

    public void DodajSpotkanie(ActionEvent actionEvent) {

    }

    public void DodajSamochod(ActionEvent actionEvent) {
        try {
            if (!ModelDriver.isExist(Model.getText(), Marka.getText()) ||
                    !KomisDriver.isExist(Integer.parseInt(KomisID.getText()))) {
                ShowAlert("Model lub komis nie istnieją");
                return;
            }
            Model mockModel = new Model(Model.getText(), Marka.getText(), 0, 0, "");
            Komis mockKomis = new Komis(Integer.parseInt(KomisID.getText()), "Kup Pan Auto", "", "", "", "", "");
            Samochod s = new Samochod(Integer.parseInt(VIN.getText()), Kolor.getSelectionModel().getSelectedItem().toString(),
                    Status.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(Przebieg.getText()),
                    Silnik.getText(), Integer.parseInt(Moc.getText()), Skrzynia.getSelectionModel().getSelectedItem().toString(),
                    Paliwo.getSelectionModel().getSelectedItem().toString(), Float.parseFloat(Spalanie.getText()), Opis.getText(), mockModel, mockKomis);
            SamochodDriver.insert(s);
            ShowOkMessage("Dodano samochod");
            Stage stage = (Stage) VIN.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            ShowAlert("Blad podczas dodawania");
            e.printStackTrace();
        }
    }

    public void DodajTransakcje(ActionEvent actionEvent) {
    }

    private void ShowAlert(String messege){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Blad");
        alert.setHeaderText(messege);
        alert.setContentText("Sprawdz dane i sprobuj ponownie");

        alert.showAndWait();
    }

    private void ShowOkMessage(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Blad");
        alert.setHeaderText(message);

        alert.showAndWait();
    }
}

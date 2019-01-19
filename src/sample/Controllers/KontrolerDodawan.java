package sample.Controllers;

import db.Driver;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    public ChoiceBox Skrzynia;
    public ChoiceBox Paliwo;
    public TextField Spalanie;
    public TextField Model;
    public TextField Cena;
    public ChoiceBox Platnosc;
    public TextField KlientID;
    public TextField SamochodID;
    public TextField PracownikID;
    public TextField komisID;

    public void initialize() {
    	if(Kolor!=(null)) {
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
    	Kolor.getItems().add("Turkusowy");}
    	if(Status!=(null)) {
    	Status.getItems().add("Sprzedany");
    	Status.getItems().add("Dostepny");
    	Status.getItems().add("Niedost.");}
    	if(Skrzynia!=(null)) {
    	Skrzynia.getItems().add("Manualna");
    	Skrzynia.getItems().add("Automat.");}
    	if(Paliwo!=(null)) {
    	Paliwo.getItems().add("Diesel");
    	Paliwo.getItems().add("Benzyna");
    	Paliwo.getItems().add("Gaz");
    	Paliwo.getItems().add("Hybryda");}
    	if(Platnosc!=(null)) {
    	Platnosc.getItems().add("Karta");
    	Platnosc.getItems().add("Gotowka");}
    }
    
    
    public void DodajSpotkanie(ActionEvent actionEvent) {
    	String dzien,miesiac,rok,komis,samochodID,kom;
    	dzien=day.getText();
    	miesiac=month.getText();
    	rok=year.getText();
    	komis=komisID.getText();
    	samochodID=VIN.getText();
    	kom=komentarz.getText();
    }

    public void DodajSamochod(ActionEvent actionEvent) {

    }

    public void DodajTransakcje(ActionEvent actionEvent) {
    }
}

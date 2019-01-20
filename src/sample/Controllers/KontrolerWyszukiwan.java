package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class KontrolerWyszukiwan {

    public TextField VIN;
    public ChoiceBox Kolor;
    public ChoiceBox Status;
    public TextField PrzebiegMin;
    public TextField PrzebiegMax;
    public TextField Silnik;
    public TextField MocMin;
    public TextField MocMax;
    public ChoiceBox Skrzynia;
    public ChoiceBox Paliwo;
    public TextField SpalanieMin;
    public TextField SpalanieMax;
    public TextField Model;
    public TextField KomisID;
    public TextField day;
    public TextField month;
    public TextField year;
    public TextField KlientID;
    public TextField CenaMin;
    public TextField CenaMax;
    public ChoiceBox Platnosc;
    public TextField PracownikID;

    public void initialize() {
    	if(Kolor!=(null)) {
    	Kolor.getItems().add("");
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
    	Status.getItems().add("");
    	Status.getItems().add("Sprzedany");
    	Status.getItems().add("Dostepny");
    	Status.getItems().add("Niedost.");}
    	if(Skrzynia!=(null)) {
    	Skrzynia.getItems().add("");
    	Skrzynia.getItems().add("Manualna");
    	Skrzynia.getItems().add("Automat.");}
    	if(Paliwo!=(null)) {
    	Paliwo.getItems().add("");
    	Paliwo.getItems().add("Diesel");
    	Paliwo.getItems().add("Benzyna");
    	Paliwo.getItems().add("Gaz");
    	Paliwo.getItems().add("Hybryda");}
    	if(Platnosc!=(null)) {
    	Platnosc.getItems().add("");
    	Platnosc.getItems().add("Karta");
    	Platnosc.getItems().add("Gotowka");}
    }
    
    public void WyszukajSamochod(ActionEvent actionEvent) {
    }

    public void WyszukajSpotkanie(ActionEvent actionEvent) {
    }

    public void WyszukajTransakcje(ActionEvent actionEvent) {
    }
}

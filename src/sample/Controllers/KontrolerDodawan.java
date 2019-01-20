package sample.Controllers;

import data_structure.Spotkanie;
import db.Driver;
import db.SpotkanieDriver;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
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
    
    
    public void DodajSpotkanie(ActionEvent actionEvent) {
    	String dzien,miesiac,rok,kom;
    	int komis, samochodID;
    	dzien=day.getText();
    	miesiac=month.getText();
    	rok=year.getText();
    	kom=komentarz.getText();
    	if(komisID.getText().length()==0 || VIN.getText().length()==0 || dzien.length()==0 || miesiac.length()==0 || rok.length()==0) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Blad");
			alert.setHeaderText("Brak danych!");
			alert.setContentText("Sprobuj ponownie!");
			alert.showAndWait();
    	}
    	else {
    	komis=Integer.parseInt(komisID.getText());
    	samochodID=Integer.parseInt(VIN.getText());
    	if (komis>10 || komis<1 || samochodID<1 || samochodID>Integer.parseInt(Driver.returnMaxID("Samochod"))) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Blad");
			alert.setHeaderText("Niepoprawne dane!");
			alert.setContentText("Sprobuj ponownie!");
			alert.showAndWait();
    	}
    	else {
    	Spotkanie toADD= new Spotkanie(rok+"-"+miesiac+"-"+dzien,kom,KontrolerLogowania.getID(),komis,samochodID);
    	SpotkanieDriver.insert(toADD);}}
    }

    public void DodajSamochod(ActionEvent actionEvent) {

    }

    public void DodajTransakcje(ActionEvent actionEvent) {
    }
}

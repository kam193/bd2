package sample.Controllers;

import db.SamochodDriver;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    public void WyszukajSamochod(ActionEvent actionEvent) {
    	
    	String VINS =VIN.getText();
    	String PrzebiegMinS =PrzebiegMin.getText();
    	String PrzebiegMaxS =PrzebiegMax.getText();
    	String SilnikS =Silnik.getText();
    	String MocMinS =MocMin.getText();
    	String MocMaxS =MocMax.getText();
    	String SpalanieMinS =SpalanieMin.getText();
    	String SpalanieMaxS =SpalanieMax.getText();
    	String ModelS =Model.getText();
    	String KomisIDS =KomisID.getText();
    	
    	String KolorS = "";
    	String PaliwoS = "";
       	String SkrzyniaS = "";
    	String StatusS = "";
    	
		if(!Kolor.getSelectionModel().isEmpty())
    		KolorS = Kolor.getSelectionModel().getSelectedItem().toString();
		if(!Status.getSelectionModel().isEmpty())
    		StatusS = Status.getSelectionModel().getSelectedItem().toString();
		if(!Skrzynia.getSelectionModel().isEmpty())
    		SkrzyniaS = Skrzynia.getSelectionModel().getSelectedItem().toString();
		if(!Paliwo.getSelectionModel().isEmpty())
    		PaliwoS =Paliwo.getSelectionModel().getSelectedItem().toString();
	
    	System.out.println(KolorS);
    	
        TableView tableView = db.SamochodDriver.getAll(VINS,PrzebiegMinS,PrzebiegMaxS,SilnikS,MocMinS,MocMaxS,SpalanieMinS,SpalanieMaxS,ModelS,KomisIDS,KolorS,StatusS,SkrzyniaS,PaliwoS);
        Scene scene = new Scene(tableView,1500,1000);
    	
        Stage stage = new Stage();
        stage.setTitle("Wyszukaj samochod");
        stage.setScene(scene);
        stage.show();
    }

    public void WyszukajSpotkanie(ActionEvent actionEvent) {
    	
    	String dayS =day.getText();
    	String monthS =month.getText();
    	String yearS =year.getText();
    	String KomisIDS =KomisID.getText();
    	String VINS ="";
    	String KlientIDS;
    	String date = "";
		
		
	 	
    	if(dayS.length()>0 && monthS.length()>0 && yearS.length()>0) {
    		date = yearS+"-"+monthS+"-"+dayS;
    	}
    
    	if(KontrolerLogowania.getTyp().equals("klient")) {
    		KlientIDS = KontrolerLogowania.getID();
    	}
    	else {
    		KlientIDS =KlientID.getText();
    		VINS=VIN.getText();
    	}
    	
    	TableView tableView = db.SpotkanieDriver.getAll(VINS,KomisIDS,KlientIDS,date);

    	Scene scene = null;
		if(KontrolerLogowania.getTyp().equals("klient"))
	         scene = new Scene(tableView, 830,400);
     	else if (KontrolerLogowania.getTyp().equals("sprzedawca") || KontrolerLogowania.getTyp().equals("admin"))
			scene = new Scene(tableView, 1100,400);

         Stage stage = new Stage();
         stage.setTitle("Wyszukaj spotkanie");
         stage.setScene(scene);
         stage.show();
    	
    }

    public void WyszukajTransakcje(ActionEvent actionEvent) {

    	String dayS =day.getText();
    	String monthS =month.getText();
    	String yearS =year.getText();
    	String PracownikIDS ="";
    	String VINS =VIN.getText();
    	String CenaMinS =CenaMin.getText();
    	String CenaMaxS =CenaMax.getText();
    	String KlientIDS;
    	String date = "";
    	String PlatnoscS = "";
    	
    	if(!Platnosc.getSelectionModel().isEmpty())
			PlatnoscS = Platnosc.getSelectionModel().getSelectedItem().toString();
   
    	
    	if(dayS.length()>0 && monthS.length()>0 && yearS.length()>0) {
    		date = yearS+"-"+monthS+"-"+dayS;
    		PracownikIDS =PracownikID.getText();
    	}
    
    	if(KontrolerLogowania.getTyp().equals("klient")) {
    		KlientIDS = KontrolerLogowania.getID();
    	}
    	else {
    		KlientIDS =KlientID.getText();
    	}
    	
    	 TableView tableView = db.TransakcjaDriver.getAll(VINS,PracownikIDS,KlientIDS,date,CenaMinS,CenaMaxS,PlatnoscS);
         Scene scene = new Scene(tableView,680,400);
     	
         Stage stage = new Stage();
         stage.setTitle("Wyszukaj transakcje");
         stage.setScene(scene);
         stage.show();
    }
}

package sample.Controllers;

import db.SamochodDriver;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
	public TextField Marka;
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
    	Kolor.getItems().add("Turkusowy"); }

    	if(Status!=(null)) {
			Status.getItems().add("");
    	Status.getItems().add("Sprzedany");
    	Status.getItems().add("Dostepny");
    	Status.getItems().add("Niedost."); }

    	if(Skrzynia!=(null)) {
		Skrzynia.getItems().add("");
    	Skrzynia.getItems().add("Manualna");
    	Skrzynia.getItems().add("Automat."); }
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
    	
    	String VINS =VIN.getText();
    	String PrzebiegMinS =PrzebiegMin.getText();
    	String PrzebiegMaxS =PrzebiegMax.getText();
    	String SilnikS =Silnik.getText();
    	String MocMinS =MocMin.getText();
    	String MocMaxS =MocMax.getText();
    	String SpalanieMinS =SpalanieMin.getText();
    	String SpalanieMaxS =SpalanieMax.getText();
    	String MarkaS = Marka.getText();
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
    	
        TableView tableView = db.SamochodDriver.getAll(VINS,PrzebiegMinS,PrzebiegMaxS,SilnikS,MocMinS,MocMaxS,SpalanieMinS,SpalanieMaxS,ModelS,MarkaS,KomisIDS,KolorS,StatusS,SkrzyniaS,PaliwoS);
        Scene scene = new Scene(tableView,1650,1000);
    	
        Stage stage = new Stage();
        stage.getIcons().add(new Image("icons/icon.png"));
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
    
    	if(KontrolerLogowania.getTyp().equals("klient")) {
    		KlientIDS = KontrolerLogowania.getID();
    	}
    	else {
    		KlientIDS =KlientID.getText();
    		VINS=VIN.getText();
    	}
    	
    	TableView tableView = db.SpotkanieDriver.getAll(VINS,KomisIDS,KlientIDS,dayS, monthS, yearS);

    	Scene scene = null;
		if(KontrolerLogowania.getTyp().equals("klient"))
	         scene = new Scene(tableView, 930,400);
     	else if (KontrolerLogowania.getTyp().equals("sprzedawca") || KontrolerLogowania.getTyp().equals("admin"))
			scene = new Scene(tableView, 1250,1000);

         Stage stage = new Stage();
         stage.getIcons().add(new Image("icons/icon.png"));
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
    	String PlatnoscS = "";
    	
    	if(!Platnosc.getSelectionModel().isEmpty())
			PlatnoscS = Platnosc.getSelectionModel().getSelectedItem().toString();
   
    	
    	if(KontrolerLogowania.getTyp().equals("klient")) {
    		KlientIDS = KontrolerLogowania.getID();
    	}
    	else {
    		KlientIDS =KlientID.getText();
    		PracownikIDS =PracownikID.getText();
    	}
    	
    	 TableView tableView = db.TransakcjaDriver.getAll(VINS,PracownikIDS,KlientIDS,dayS, monthS, yearS,CenaMinS,CenaMaxS,PlatnoscS);

		Scene scene = null;
    	if(KontrolerLogowania.getTyp().equals("klient"))
			scene = new Scene(tableView,680,400);
		else if (KontrolerLogowania.getTyp().equals("sprzedawca") || KontrolerLogowania.getTyp().equals("admin"))
			scene = new Scene(tableView,680,1000);
     	
         Stage stage = new Stage();
         stage.getIcons().add(new Image("icons/icon.png"));
         stage.setTitle("Wyszukaj transakcje");
         stage.setScene(scene);
         stage.show();
    }
}

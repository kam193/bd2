package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class KontrolerAplikacji {

    private final String admin = "admin";
    private final String client = "klient";
    private final String seller = "sprzedawca";
    
    @FXML
    private Label pomocLogin;
    @FXML
    private Label pomocKonto;
    @FXML
    private Label pomocID;

    public void initialize() {
    	pomocLogin.setText("Login: "+KontrolerLogowania.getUser());
    	pomocKonto.setText("Typ Konta: "+KontrolerLogowania.getTyp());
    	pomocID.setText("ID: "+KontrolerLogowania.getID());
    }
    

    public void WyszukajSamochod(ActionEvent keyEvent) throws IOException {
        Parent root = null;

        if(KontrolerLogowania.getTyp().equals(admin) || KontrolerLogowania.getTyp().equals(seller))
            root = FXMLLoader.load(getClass().getResource("../Views/WidokiSprzedawcy/Wyszukaj/WyszukajSamochod.fxml"));
        else if(KontrolerLogowania.getTyp().equals(client))
            root = FXMLLoader.load(getClass().getResource("../Views/WidokiKlienta/Wyszukaj/WyszukajSamochod.fxml"));

        Stage stage = new Stage();
        stage.getIcons().add(new Image("icons/icon.png"));
        stage.setTitle("Wyszukaj auto");
        stage.setScene(new Scene(root, 450, 400));
        stage.show();
    }

    public void WyszukajSpotkanie(ActionEvent keyEvent) throws IOException {
        Parent root = null;

        if(KontrolerLogowania.getTyp().equals(admin) || KontrolerLogowania.getTyp().equals(seller))
            root = FXMLLoader.load(getClass().getResource("../Views/WidokiSprzedawcy/Wyszukaj/WyszukajSpotkanie.fxml"));
        else if(KontrolerLogowania.getTyp().equals(client))
            root = FXMLLoader.load(getClass().getResource("../Views/WidokiKlienta/Wyszukaj/WyszukajSpotkanie.fxml"));

        Stage stage = new Stage();
        stage.getIcons().add(new Image("icons/icon.png"));
        stage.setTitle("Wyszukaj Spotkanie");
        stage.setScene(new Scene(root, 450, 225));
        stage.show();
    }

    public void WyszukajTransakcje(ActionEvent keyEvent) throws IOException {
        Parent root = null;

        if(KontrolerLogowania.getTyp().equals(admin) || KontrolerLogowania.getTyp().equals(seller))
            root = FXMLLoader.load(getClass().getResource("../Views/WidokiSprzedawcy/Wyszukaj/WyszukajTransakcje.fxml"));
        else if(KontrolerLogowania.getTyp().equals(client))
            root = FXMLLoader.load(getClass().getResource("../Views/WidokiKlienta/Wyszukaj/WyszukajTransakcje.fxml"));

        Stage stage = new Stage();
        stage.getIcons().add(new Image("icons/icon.png"));
        stage.setTitle("Wyszukaj Transakcje");
        stage.setScene(new Scene(root, 500, 250));
        stage.show();
    }

    public void DodajSamochod(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/WidokiSprzedawcy/Dodaj/DodajSamochod.fxml"));

        Stage stage = new Stage();

        stage.getIcons().add(new Image("icons/icon.png"));
        stage.setTitle("Dodaj auto");
        stage.setScene(new Scene(root, 450, 530));
        stage.show();
    }

    public void DodajSpotkanie(ActionEvent keyEvent) throws IOException {
        Parent root = null;

        if(KontrolerLogowania.getTyp().equals(admin) || KontrolerLogowania.getTyp().equals(seller))
            root = FXMLLoader.load(getClass().getResource("../Views/WidokiSprzedawcy/Dodaj/DodajSpotkanie.fxml"));
        else if(KontrolerLogowania.getTyp().equals(client))
            root = FXMLLoader.load(getClass().getResource("../Views/WidokiKlienta/Dodaj/DodajSpotkanie.fxml"));

        Stage stage = new Stage();
        stage.getIcons().add(new Image("icons/icon.png"));
        stage.setTitle("Dodaj Spotkanie");
        stage.setScene(new Scene(root, 450, 400));
        stage.show();
    }

    public void DodajTransakcje(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/WidokiSprzedawcy/Dodaj/DodajTransakcje.fxml"));

        Stage stage = new Stage();
        stage.getIcons().add(new Image("icons/icon.png"));
        stage.setTitle("Dodaj Transakcje");
        stage.setScene(new Scene(root, 450, 250));
        stage.show();
    }

    public void UsunSamochod(ActionEvent keyEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/WidokiSprzedawcy/Usuwanie/UsunSamochod.fxml"));

        Stage stage = new Stage();
        stage.getIcons().add(new Image("icons/icon.png"));
        stage.setTitle("Usun Samochod z bazy");
        stage.setScene(new Scene(root, 400, 100));
        stage.show();
    }

    public void OdwolajSpotkanie(ActionEvent keyEvent) throws IOException {
        Parent root = null;

        if(KontrolerLogowania.getTyp().equals(admin) || KontrolerLogowania.getTyp().equals(seller))
            root = FXMLLoader.load(getClass().getResource("../Views/WidokiSprzedawcy/Usuwanie/UsunSpotkanie.fxml"));
        else if(KontrolerLogowania.getTyp().equals(client))
            root = FXMLLoader.load(getClass().getResource("../Views/WidokiKlienta/Usuwanie/UsunSpotkanie.fxml"));

        Stage stage = new Stage();
        stage.getIcons().add(new Image("icons/icon.png"));
        stage.setTitle("Usun Spotkanie z bazy");
        stage.setScene(new Scene(root, 400, 100));
        stage.show();
    }

}

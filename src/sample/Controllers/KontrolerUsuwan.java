package sample.Controllers;

import db.SamochodDriver;
import db.SpotkanieDriver;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KontrolerUsuwan {
    public TextField SpotkanieID;
    public TextField VIN;

    public void SprzedajSamochod(ActionEvent actionEvent) {
    	try {
            if (!SamochodDriver.isExist(VIN.getText())) {
                ShowAlert("Nie istnieje samochod o danym VINie");
                return;
            }
            int s = Integer.parseInt(VIN.getText());
            int w = SamochodDriver.sell(s);
            if(w==0) ShowAlert("Blad podczas sprzedawania");
            else {
            ShowOkMessage("Sprzedano samochod");
            Stage stage = (Stage) VIN.getScene().getWindow();
            stage.close();}
        } catch (Exception e) {
            ShowAlert("Blad podczas sprzedawania");
            e.printStackTrace();
        }
    }

    public void UsunSpotkanie(ActionEvent actionEvent) {
    	try {
            int s = Integer.parseInt(SpotkanieID.getText());
            int w = SpotkanieDriver.delete(s);
            if(w==0) ShowAlert("Blad podczas usuwania");
            else {ShowOkMessage("Usunieto spotkanie");
            Stage stage = (Stage) SpotkanieID.getScene().getWindow();
            stage.close();}

        } catch (Exception e) {
            ShowAlert("Blad podczas usuwania");
            e.printStackTrace();
        }
    }
    
    private void ShowAlert(String messege) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Blad");
        alert.setHeaderText(messege);
        alert.setContentText("Sprawdz dane i sprobuj ponownie");

        alert.showAndWait();
    }

    private void ShowOkMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText(message);

        alert.showAndWait();
    }

}

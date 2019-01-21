package sample.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KontrolerLogowania {

	private static String Password;
	private static String Login;
	private static String Typ;
	private static String ID;

	@FXML TextField login_input;
	@FXML PasswordField password_input;

	public void SignIn(ActionEvent keyEvent) throws IOException { // check login and password

		Login = login_input.getText();
		Password = password_input.getText();

		try {
			Connection connection = Driver.getConnection();
			getUserFromDB(connection);
			
			Parent root = null;
			if(Typ.equals("admin") || Typ.equals("sprzedawca")){
				root = FXMLLoader.load(getClass().getResource("../Views/WidokiSprzedawcy/AplikacjaSprzedawcy.fxml"));
			} else if(Typ.equals("klient")){
				root = FXMLLoader.load(getClass().getResource("../Views/WidokiKlienta/AplikacjaKlienta.fxml"));
			}

			Stage stage = new Stage();
			stage.setTitle("Aplikacja");
			stage.setScene(new Scene(root, 600, 500));
			sample.Main.getPrimaryStage().close();
			stage.show();

		}
		catch(Exception e)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Blad");
			alert.setHeaderText("Bledny login lub haslo");
			alert.setContentText("Sprobuj ponownie!");

			alert.showAndWait();
		}
	}

	public static String getPassword() {
		return Password;
	}

	public static String getUser() {
		return Login;
	}

	public static String getID() {
		return ID;
	}

	public static String getTyp() {
		return Typ;
	}

	private static void getUserFromDB(Connection con) throws SQLException {
		Statement stmt = null;

		String query = "select * from User where login = '" + Login + "'";

		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ID = rs.getString("ID");
				Typ = rs.getString("typ");
			}
		} catch (SQLException e ) {
			System.out.println(e.getMessage());
		} finally {
			if (stmt != null) { stmt.close(); }
		}
	}
}

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KontrolerLogowania {

	private static String Password;
	private static String Login;
	private static String Typ;
	private static int ID;

	@FXML TextField login_input;
	@FXML PasswordField password_input;


	public void SignIn(ActionEvent keyEvent) throws IOException { // check login and password

		Login = login_input.getText();
		Password = password_input.getText();

		try {
			Connection connection = Driver.getConnection();
			getUserFromDB(connection);

			System.out.println(Login +" "+Password +" "+ID +" "+Typ +" ");


			//TODO stworzyæ 2 wersje Aplikacja.fxml - dla klientów i sprzedawców.
			//£adowaæ odpowiedni¹ w zale¿noœci od parametru Typ
			Parent root = FXMLLoader.load(getClass().getResource("../Views/Aplikacja.fxml"));

			Stage stage = new Stage();
			stage.setTitle("Aplikacja");
			stage.setScene(new Scene(root, 600, 500));
			sample.Main.getPrimaryStage().close();
			stage.show();

		}
		catch(Exception e)
		{
			Parent root = FXMLLoader.load(getClass().getResource("../Views/Logowanie_2.fxml"));

			Stage stage2 = new Stage();
			stage2.close();
			stage2.setTitle("B³¹d");
			stage2.setScene(new Scene(root, 160, 50));
			stage2.show();
		}
	}

	public static String getPassword() {
		return Password;
	}

	public static String getUser() {
		return Login;
	}

	public static int getID() {
		return ID;
	}

	private static void getUserFromDB(Connection con) throws SQLException {
		Statement stmt = null;

		String query = "select * from User where login = '" + Login + "'";

		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ID = rs.getInt("ID");
				Typ = rs.getString("typ");
			}
		} catch (SQLException e ) {
			System.out.println(e.getMessage());
		} finally {
			if (stmt != null) { stmt.close(); }
		}
	}
}

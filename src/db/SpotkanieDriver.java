package db;

import data_structure.Spotkanie;
import javafx.scene.control.TableView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpotkanieDriver {
    public static TableView getAll(String VINS,String KomisIDS,String KlientIDS,String date) {
        try {
			return getFromDB(VINS,KomisIDS,KlientIDS,date);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }

    private static TableView getFromDB(String VINS,String KomisIDS,String KlientIDS,String date) throws SQLException {
 //       Statement statement = null;

        String query = "select Samochod_VIN, Nazwa, Miasto, Ulica, Nr_Domu,Telefon, Data, Komentarz from Spotkanie as a join Komis as b on a.Komis_ID=b.ID where a.ID <> -1";

    	if(VINS.length()>0)
    		query +=" and Samochod_VIN= ? ";
    	if(KomisIDS.length()>0)
    		query +=" and Komis_ID= ? ";
    	if(KlientIDS.length()>0)
    		query +=" and Klient_ID= ? ";
    	if(date.length()>1)
    		query +=" and Data <= ? and Data >= ? ";

        PreparedStatement pstmt = Driver.conn.prepareStatement( query );
        
        int filters = 1;
        
    	if(VINS.length()>0) {
    		pstmt.setInt( filters, Integer.parseInt(VINS));
    		filters++;
    	}
    	if(KomisIDS.length()>0) {
    		pstmt.setString( filters, KomisIDS);
			filters++;
    	}
    	if(KlientIDS.length()>0) {
    		pstmt.setString( filters, KlientIDS);
			filters++;
    	}
    	if(date.length()>1) {
    		String date1 = date + " 00:00:00";
    		String date2 = date + " 23:59:59";
    		pstmt.setString( filters, date2);
    		pstmt.setString( filters+1, date1);
			filters++;
    	}

    	System.out.println(pstmt);
    	ResultSet results = pstmt.executeQuery( );
        
        return Driver.getResult(results);
    }

	public static void insert(Spotkanie spotkanie) throws SQLException {
		String query = String.format("insert into Spotkanie values (%s)", spotkanie.toString());
		Driver.insertWithoutAutoId(query);
	}
}

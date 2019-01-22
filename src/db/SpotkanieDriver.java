package db;

import data_structure.Spotkanie;
import javafx.scene.control.TableView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpotkanieDriver {
    public static TableView getAll(String VINS,String KomisIDS,String KlientIDS,String day, String month, String year) {
        try {
			return getFromDB(VINS,KomisIDS,KlientIDS,day, month, year);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }

    private static TableView getFromDB(String VINS,String KomisIDS,String KlientIDS,String day, String month, String year) throws SQLException {

        String query = "select a.ID, Samochod_VIN, Nazwa, Miasto, Ulica, Nr_Domu,Telefon, Data, Komis_ID, Komentarz from Spotkanie as a join Komis as b on a.Komis_ID=b.ID where a.ID <> -1";

    	if(VINS.length()>0)
    		query +=" and Samochod_VIN= ? ";
    	if(KomisIDS.length()>0)
    		query +=" and Komis_ID= ? ";
    	if(KlientIDS.length()>0)
    		query +=" and Klient_ID= ? ";
    	if(day.length()>0)
    		query +=" and DAY(Data) = ? ";
		if(month.length()>0)
			query +=" and MONTH(Data) = ? ";
		if(year.length()>0)
			query +=" and YEAR(Data) = ? ";

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
    	if(day.length()>0) {
    		pstmt.setString( filters, day);
    		filters++;
    	}
    	if(month.length()>0){
    		pstmt.setString(filters, month);
    		filters++;
		}
		if(year.length()>0){
			pstmt.setString(filters, year);
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

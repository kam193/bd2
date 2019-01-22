package db;

import data_structure.Transakcja;
import javafx.scene.control.TableView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransakcjaDriver {
    public static TableView getAll(String VINS,String PracownikIDS,String KlientIDS,String day, String month, String year,String CenaMinS,String CenaMaxS, String PlatnoscS) {
        try {
			return getFromDB(VINS,PracownikIDS,KlientIDS,day,month,year,CenaMinS,CenaMaxS,PlatnoscS);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }

	public static void insert(Transakcja transakcja) throws SQLException {
		String query = String.format("insert into Transakcja values (%s)", transakcja.toString());
		Driver.insertWithoutAutoId(query);
	}

    private static TableView getFromDB(String VINS,String PracownikIDS,String KlientIDS,String day, String month, String year,String CenaMinS,String CenaMaxS, String PlatnoscS) throws SQLException {
        String query = "select Samochod_VIN, Pracownik_ID, Klient_ID, Cena, Data, Metoda_Platnosci from Transakcja where ID <> -1 ";
        
    	if(VINS.length()>0)
    		query +=" and Samochod_VIN= ? ";
    	if(PracownikIDS.length()>0)
    		query +=" and Pracownik= ? ";
    	if(KlientIDS.length()>0)
    		query +=" and Klient_ID= ? ";
    	if(CenaMinS.length()>0)
    		query +=" and Cena>= ? ";
    	if(CenaMaxS.length()>0)
    		query +=" and Cena<= ? ";
    	if(PlatnoscS.length()>0)
    		query +=" and Metoda_Platnosci= ? ";
		if(day.length()>0)
			query +=" and DAY(Data) = ? ";
		if(month.length()>0)
			query +=" and MONTH(Data) = ? ";
		if(year.length()>0)
			query +=" and YEAR(Data) = ? ";

        PreparedStatement pstmt = Driver.conn.prepareStatement( query );
        
        int filters = 1;
        
    	if(VINS.length()>0) {
    		pstmt.setString( filters, VINS);
    		filters++;
    	}
    	if(PracownikIDS.length()>0) {
    		pstmt.setString( filters, PracownikIDS);
			filters++;
    	}
    	if(KlientIDS.length()>0) {
    		pstmt.setString( filters, KlientIDS);
			filters++;
    	}
    	if(CenaMinS.length()>0) {
    		pstmt.setString( filters, CenaMinS);
			filters++;
    	}
    	if(CenaMaxS.length()>0) {
    		pstmt.setString( filters, CenaMaxS);
			filters++;
    	}
    	if(PlatnoscS.length()>0) {
    		pstmt.setString( filters, PlatnoscS);
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
}

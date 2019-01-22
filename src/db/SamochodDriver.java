package db;

import data_structure.Samochod;
import javafx.scene.control.TableView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SamochodDriver {
    public static TableView getAll(String VINS,String PrzebiegMinS,String PrzebiegMaxS,String SilnikS,String MocMinS,String MocMaxS,String SpalanieMinS,String SpalanieMaxS,String ModelS,String KomisIDS,String KolorS,String StatusS,String SkrzyniaS,String PaliwoS) {
        try {
			return getFromDB(VINS,PrzebiegMinS,PrzebiegMaxS,SilnikS,MocMinS,MocMaxS,SpalanieMinS,SpalanieMaxS,ModelS,KomisIDS,KolorS,StatusS,SkrzyniaS,PaliwoS);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }

//    public static List<Samochod> getByStatus(String status){
//        String filters = String.format("Status='%s'", status);
//        return getFromDB(filters);
//    }
//
//    public static Samochod get(int VIN){
//        String filters = String.format("VIN=%d", VIN);
//        List<Samochod> results = getFromDB(filters);
//        if (results.size() != 1)
//            return null;
//        return results.get(0);
//    }

    public static void insert(Samochod samochod) throws SQLException {
        String query = String.format("insert into Samochod values (%s)", samochod.toString());

        Driver.insertWithoutAutoId(query);
    }
    
    public static int sell(int VIN) throws SQLException {
    	String query = String.format("update Samochod set Status='Sprzedany' where VIN=%d", VIN);
    	return Driver.insertWithoutAutoId(query);
    }

    public static boolean isExist(String VIN)
	{
		try {
			return getFromDB(VIN, "", "", "", "", "", "", "",
				"", "", "", "", "", "").getItems().size() > 0;
		} catch (Exception e){
			return false;
		}
	}

    private static TableView getFromDB(String VINS,String PrzebiegMinS,String PrzebiegMaxS,String SilnikS,String MocMinS,String MocMaxS,String SpalanieMinS,String SpalanieMaxS,String ModelS,String KomisIDS,String KolorS,String StatusS,String SkrzyniaS,String PaliwoS) throws SQLException {

        String query = "select Marka,Model,Ilosc_drzwi,Kolor,Naped,Skrzynia_biegow,Silnik,Spalanie,Moc,Paliwo,Przebieg,VIN,Status,Miasto,Opis"
        		+ " from Model as a join Samochod as b on a.Model=b.Model_Model and a.Marka=b.Model_Marka "
        		+ "join Komis as c on b.Komis_ID=c.ID where VIN <> -1";
        
    	if(VINS.length()>0)
    		query +=" and VIN= ? ";
    	if(PrzebiegMinS.length()>0)
    		query +=" and Przebieg>= ?";
    	if(PrzebiegMaxS.length()>0)
    		query +=" and Przebieg<= ?";
    	if(SilnikS.length()>0)
    		query +=" and Silnik= ?";
    	if(MocMinS.length()>0)
    		query +=" and Moc>= ?";
    	if(MocMaxS.length()>0)
    		query +=" and Moc<= ?";
    	if(SpalanieMinS.length()>0)
    		query +=" and Spalanie>= ?";
    	if(SpalanieMaxS.length()>0)
    		query +=" and Spalanie<= ?";
    	if(ModelS.length()>0)
    		query +=" and Model= ?";
    	if(KomisIDS.length()>0)
    		query +=" and Miasto= ?";
    	if(KolorS.length()>0)
    		query +=" and Kolor= ?";
    	if(StatusS.length()>0)
    		query +=" and Status= ?";
    	if(SkrzyniaS.length()>0)
    		query +=" and Skrzynia_biegow= ?";
    	if(PaliwoS.length()>0)
    		query +=" and Paliwo= ?";

    	query +=" limit 200";
        
        PreparedStatement pstmt = Driver.conn.prepareStatement( query );
        
        int filters = 1;
        
    	if(VINS.length()>0) {
    		pstmt.setString( filters, VINS);
    		filters++;
    	}
    	if(PrzebiegMinS.length()>0) {
    		pstmt.setString( filters, PrzebiegMinS);
			filters++;
    	}
    	if(PrzebiegMaxS.length()>0) {
    		pstmt.setString( filters, PrzebiegMaxS);
			filters++;
    	}
    	if(SilnikS.length()>0) {
    		pstmt.setString( filters, SilnikS);
			filters++;
    	}
    	if(MocMinS.length()>0) {
    		pstmt.setString( filters, MocMinS);
			filters++;
    	}
    	if(MocMaxS.length()>0) {
    		pstmt.setString( filters, MocMaxS);
			filters++;
    	}
    	if(SpalanieMinS.length()>0) {
    		pstmt.setString( filters, SpalanieMinS);
			filters++;
    	}
    	if(SpalanieMaxS.length()>0) {
    		pstmt.setString( filters, SpalanieMaxS);
			filters++;
    	}
    	if(ModelS.length()>0) {
    		pstmt.setString( filters, ModelS);
			filters++;
    	}
    	if(KomisIDS.length()>0) {
    		pstmt.setString( filters, KomisIDS);
    		filters++;
    	}
    	if(KolorS.length()>0) {
    		pstmt.setString( filters, KolorS);
    		filters++;
    	}
    	if(StatusS.length()>0) {
    		pstmt.setString( filters, StatusS);
    		filters++;
    	}
    	if(SkrzyniaS.length()>0) {
    		pstmt.setString( filters, SkrzyniaS);
    		filters++;
    	}
    	if(PaliwoS.length()>0) {
    		pstmt.setString( filters, PaliwoS);
    		filters++;
    	}
    	
    	System.out.println(pstmt);
    	ResultSet results = pstmt.executeQuery( );
        
        return Driver.getResult(results);
    }
}

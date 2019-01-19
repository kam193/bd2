package db;

import data_structure.Samochod;
import javafx.scene.control.TableView;

import java.sql.Statement;

public class SamochodDriver {
    public static TableView getAll() {
        return getFromDB("");
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

    public static void insert(Samochod samochod){
        String query = String.format("insert into Samochod values (%s)", samochod.toString());

        Driver.insertWithoutAutoId(query);
    }

    private static TableView getFromDB(String filters) {
        Statement statement = null;

        String query = "select * from Samochod";
        if (filters != null && filters.length() > 0)
            query += " where " + filters;

        return Driver.getResult(query);
    }
    
}

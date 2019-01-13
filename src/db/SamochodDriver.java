package db;

import data_structure.Samochod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SamochodDriver {
    public static List<Samochod> getAll() {
        return getFromDB("");
    }

    public static List<Samochod> getByStatus(String status){
        String filters = String.format("Status='%s'", status);
        return getFromDB(filters);
    }

    public static Samochod get(int VIN){
        String filters = String.format("VIN=%d", VIN);
        List<Samochod> results = getFromDB(filters);
        if (results.size() != 1)
            return null;
        return results.get(0);
    }

    public static void insert(Samochod samochod){
        Statement statement = null;
        String query = String.format("insert into Samochod values (%s)", samochod.toString());

        try {
            statement = Driver.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) { /* ignore */ }
        }
    }

    private static List<Samochod> getFromDB(String filters) {
        Statement statement = null;

        String query = "select * from Samochod";
        if (filters != null && filters.length() > 0)
            query += " where " + filters;

        List<Samochod> results = new ArrayList<>();
        try {
            statement = Driver.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Samochod samochod = new Samochod(rs.getInt("VIN"),
                        rs.getString("Kolor"),
                        rs.getString("Status"),
                        rs.getInt("Przebieg"),
                        rs.getString("Silnik"),
                        rs.getInt("Moc"),
                        rs.getString("Skrzynia_biegow"),
                        rs.getString("Paliwo"),
                        rs.getFloat("Spalanie"),
                        rs.getString("Opis"), null, null);
                results.add(samochod);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            results.clear();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) { /* ignore */ }
        }

        return results;
    }
}

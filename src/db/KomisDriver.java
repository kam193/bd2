package db;

import data_structure.Komis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KomisDriver {
    public static void insert(Komis komis) {
        String query = String.format("insert into Komis values (%s)", komis.toString());
        Driver.insertWithoutAutoId(query);
    }

    public static List<Komis> getAll() {
        return getFromDB("");
    }

    public static Komis get(int ID) {
        String filters = String.format("ID=%d", ID);
        List<Komis> results = getFromDB(filters);
        if (results.size() != 1)
            return null;
        return results.get(0);
    }

    private static List<Komis> getFromDB(String filters) {
        Statement statement = null;

        String query = "select * from Komis";
        if (filters != null && filters.length() > 0)
            query += " where " + filters;

        List<Komis> results = new ArrayList<>();
        try {
            statement = Driver.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Komis komis = new Komis(rs.getInt("ID"),
                        rs.getString("Nazwa"),
                        rs.getString("Ulica"),
                        rs.getString("Nr_Domu"),
                        rs.getString("Miasto"),
                        rs.getString("Kod_Pocztowy"),
                        rs.getString("Telefon"));
                results.add(komis);
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

package db;

import com.sun.org.apache.xpath.internal.operations.Mod;
import data_structure.Model;
import data_structure.Samochod;

import javax.jws.WebParam;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModelDriver {
    public static void insert(Model model){
        String query = String.format("insert into Model values (%s)", model.toString());
        Driver.insertWithoutAutoId(query);
    }

    public static List<Model> getAll() {
        return getFromDB("");
    }

    public static Model get(String model, String marka){
        String filters = String.format("Model='%s' and Marka='%s'", model, marka);
        List<Model> results = getFromDB(filters);
        if (results.size() != 1)
            return null;
        return results.get(0);
    }

    private static List<Model> getFromDB(String filters) {
        Statement statement = null;

        String query = "select * from Model";
        if (filters != null && filters.length() > 0)
            query += " where " + filters;

        List<Model> results = new ArrayList<>();
        try {
            statement = Driver.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Model model = new Model(rs.getString("Model"),
                        rs.getString("Marka"),
                        rs.getInt("Ilosc_drzwi"),
                        rs.getInt("Masa"),
                        rs.getString("Naped"));
                results.add(model);
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

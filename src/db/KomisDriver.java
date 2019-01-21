package db;

import data_structure.Komis;
import javafx.scene.control.TableView;

import java.sql.Statement;

public class KomisDriver {
//    public static void insert(Komis komis) {
//        String query = String.format("insert into Komis values (%s)", komis.toString());
//        Driver.insertWithoutAutoId(query);
//    }

    public static TableView getAll() {
        return getFromDB("");
    }

//    public static Komis get(int ID) {
//        String filters = String.format("ID=%d", ID);
//        List<Komis> results = getFromDB(filters);
//        if (results.size() != 1)
//            return null;
//        return results.get(0);
//    }

    private static TableView getFromDB(String filters) {
        Statement statement = null;

        String query = "select * from Komis";
        if (filters != null && filters.length() > 0)
            query += " where " + filters;

        return Driver.getResult(query);
    }

    public static boolean isExist(int id) {
        String filters = String.format(" ID = %d", id);

        return getFromDB(filters).getItems().size() > 0;
    }
}

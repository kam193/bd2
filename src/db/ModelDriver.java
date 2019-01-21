package db;

import data_structure.Model;
import javafx.scene.control.TableView;
import java.sql.Statement;


public class ModelDriver {
//    public static void insert(Model model){
//        String query = String.format("insert into Model values (%s)", model.toString());
//        Driver.insertWithoutAutoId(query);
//    }

    public static TableView getAll() {
        return getFromDB("");
    }

//    public static Model get(String model, String marka){
//        String filters = String.format("Model='%s' and Marka='%s'", model, marka);
//        List<Model> results = getFromDB(filters);
//        if (results.size() != 1)
//            return null;
//        return results.get(0);
//    }

    private static TableView getFromDB(String filters) {
        Statement statement = null;

        String query = "select * from Model";
        if (filters != null && filters.length() > 0)
            query += " where " + filters;
        return Driver.getResult(query);
    }

    public static boolean isExist(String model, String marka){
        String filter = String.format("Model = '%s' and Marka = '%s'", model, marka);
        return getFromDB(filter).getItems().size() > 0;
    }
}

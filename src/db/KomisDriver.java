package db;

import data_structure.Komis;
import data_structure.Model;

public class KomisDriver {
    public static void insert(Komis komis){
        String query = String.format("insert into Komis values (%s)", komis.toString());
        Driver.insertWithoutAutoId(query);
    }
}

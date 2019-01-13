package db;

import data_structure.Model;
import data_structure.Samochod;

import java.sql.SQLException;
import java.sql.Statement;

public class ModelDriver {
    public static void insert(Model model){
        String query = String.format("insert into Model values (%s)", model.toString());
        Driver.insertWithoutAutoId(query);
    }
}

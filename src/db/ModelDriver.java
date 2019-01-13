package db;

import com.sun.org.apache.xpath.internal.operations.Mod;
import data_structure.Model;
import data_structure.Samochod;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

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

    public static void buildData(TableView tableview) {
        Statement statement;
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        try{
            statement = Driver.getConnection().createStatement();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * from Model";
            //ResultSet
            ResultSet rs = statement.executeQuery(SQL);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableview.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }
}

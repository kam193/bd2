package db;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import sample.Controllers.KontrolerLogowania;

import java.sql.*;

public class Driver {
    static Connection conn = null;

    public static Connection getConnection(){
        if (conn == null) {
        	String user = KontrolerLogowania.getUser();
        	String password = KontrolerLogowania.getPassword();
            conn = createConnection(user, password, "mydb2");
        }
        return conn;
    }

    public static void closeSharedConnection(){
        closeConnection(conn);
    }

    public static int insertWithoutAutoId(String query) throws SQLException{
        Statement statement = null;
        int toReturn=0;
        try {
            statement = Driver.getConnection().createStatement();
            toReturn= statement.executeUpdate(query);
        } finally {
            try {
                if (statement != null)
                    statement.close();
                return toReturn;
            } catch (SQLException e) { /* ignore */ }
        }
		return toReturn;
    }

    private static Connection createConnection(String username, String password, String dbname) {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://tombaky.com:3307/mydb2";

            connection = DriverManager.getConnection(url, username, password);
            connection.setCatalog(dbname);

            System.out.println("Successfully Connected to the database!");

        } catch (SQLException e) {
            System.out.println("Could not connect to the database " + e.getMessage());
        }
        return connection;
    }

    private static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Successfully unconnected from the database!");
            } catch (SQLException e) { /* ignored */}
        }
    }

    public static void viewTable(Connection con, String dbName) throws SQLException {

        Statement stmt = null;
        String query = "select ID, Imie, Nazwisko " +
                "from " + dbName + ".Klient";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String Imie = rs.getString("Imie");
                String Nazwisko = rs.getString("Nazwisko");
                int ID = rs.getInt("ID");
                System.out.println(Imie + "\t" + Nazwisko + "\t" + ID + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static TableView getResult(String query){
        TableView tableview = new TableView();
        Statement statement;
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
			try {
				statement = Driver.getConnection().createStatement();
				ResultSet rs = statement.executeQuery(query);
				return getResult(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return null;
    }
    
    public static TableView getResult(ResultSet rs) {
        TableView tableview = new TableView();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        try{

            for(int i = 0; i < rs.getMetaData().getColumnCount(); ++i){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                tableview.getColumns().addAll(col);
            }

            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1 ; i <= rs.getMetaData().getColumnCount(); ++i){
                    if(rs.getString(i) != null)
                        row.add(rs.getString(i));
                    else
                        row.add("");
                }
                data.add(row);
            }
            tableview.setItems(data);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }

        return tableview;
    }

}
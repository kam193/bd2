package db;

import java.sql.*;

public class Driver {
    static Connection conn = null;

    public static void main() {
        Connection connection = createConnection("user", "passwd", "mydb");

        try {
            viewTable(connection, "mydb");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection(connection);
    }

    public static Connection getConnection(){
        if (conn == null)
            conn = createConnection("dbadmin", "baza_do_BD2", "mydb");
        return conn;
    }

    public static void closeSharedConnection(){
        closeConnection(conn);
    }

    public static void insertWithoutAutoId(String query){
        Statement statement = null;
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

    private static Connection createConnection(String username, String password, String dbname) {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://tombaky.com:3307/mydb";

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
}
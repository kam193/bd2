
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Driver {

	public static void main(String args[]){
		Connection connection = createConnection();
		
		try {
			viewTable(connection, "mydb");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection(connection);
	}

	static Connection createConnection() {
		Connection connection = null;
		try {
			  String url = "jdbc:mysql://tombaky.com:3307/mydb";
			  String username = "root";
			  String password = "komis1918";
		
			  connection = DriverManager.getConnection(url, username, password); 
			     
			  System.out.println("Successfully Connected to the database!");
		 
		} 
		catch (SQLException e) {
			System.out.println("Could not connect to the database " + e.getMessage());
		}
		return connection;
	}
	static void closeConnection(Connection connection) {
	    if (connection != null) {
	        try {
	            connection.close();
	            System.out.println("Successfully unconnected from the database!");
	        } catch (SQLException e) { /* ignored */}
	    }
	}

	public static void viewTable(Connection con, String dbName)throws SQLException {
	
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
		    } catch (SQLException e ) {
		    	System.out.println(e.getMessage());
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
	}
}
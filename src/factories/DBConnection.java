package factories;
import java.awt.print.Printable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {

	private static Connection myConn;
	private static String url = "jdbc:mysql;//localhost:3306/";
	private static String username = "root";
	private static String password = "";
	
	public static Connection getDatabaseConnection() {
		myConn = null;
		try {
			myConn = DriverManager.getConnection(url,username,password);
			System.out.println("Database Connected");
		} catch (SQLException e) {	
			e.printStackTrace();
	}
	return myConn;
	}
}

package factories;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection myConnection;
	private static String url = "jdbc:mysql://localhost:3306/apgrpproject";
	private static String username = "root";
	private static String password = "";
	
	public static Connection getdatabaseConnection() {
		myConnection = null;
		if(myConnection == null) {
			try {
				myConnection = DriverManager.getConnection(url, username,password);
				System.out.println("Database connected");
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return myConnection;
	}

}

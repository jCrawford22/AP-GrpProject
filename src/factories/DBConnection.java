package factories;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class DBConnection {

	private static Connection myConnection;
	private static String url = "jdbc:mysql://localhost:3306/apgrpproject";
	private static String username = "root";
	private static String password = "";
	
	private static final Logger logger= LogManager.getLogger(DBConnection.class.getName());
	
	public static Connection getdatabaseConnection() {
		myConnection = null;
		if(myConnection == null) {
			try {
				myConnection = DriverManager.getConnection(url, username,password);
				
				logger.info("database is connnected");
				
				
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return myConnection;
	}

}

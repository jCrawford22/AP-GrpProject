package factories;
import java.awt.print.Printable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DBConnection {

	private static Connection myConn;
	private static String url = "jdbc:mysql;//localhost:3306/";
	private static String username = "root";
	private static String password = "";
	
	private static	final Logger logger = LogManager.getLogger(DBConnection.class);
	
	public static Connection getDatabaseConnection() {
		myConn = null;
		try {
			myConn = DriverManager.getConnection(url,username,password);
			System.out.println("Database Connected");
			logger.info("Connected to database");
		} catch (SQLException e) {	
			e.printStackTrace();
			logger.error("Failure to connect to database");
	}
	return myConn;
	}
}

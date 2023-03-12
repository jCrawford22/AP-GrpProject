package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import factories.DBConnection;

public class StudentLoginTest {
 DBConnection DB;
 private Connection dbConnection;
 
	public StudentLoginTest() {
		dbConnection = DB.getdatabaseConnection();
		if (dbConnection != null) {
			System.out.println("Database Connected");
		}
	}
	
	public void create() {
		 Statement stmt;
			try {
				stmt = dbConnection.createStatement();
				String sql = "CREATE TABLE TEST " + "(id INTEGER not NULL, " +" first VARCHAR(255), " + " last VARCHAR(255), " + " age INTEGER, " + " PRIMARY KEY ( id ))"; 

		       stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	}
	
	public void insert() {
		try {
			String query = "INSERT INTO student (studentid, firstname, lastname, contactnumber, emailaddress)" + "VALUES(?,?,?,?,?)";
			PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
			preparedStmt.setString(1, "124");
			preparedStmt.setString(2, "Justin");
			preparedStmt.setString(3, "Alder");
			preparedStmt.setString(4, "18764825567");
			preparedStmt.setString(5, "justinalder@gmail.com");
		    preparedStmt.execute();
			 dbConnection.close();
			System.out.println("Data added");
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
   StudentLoginTest slt = new StudentLoginTest();
   slt.insert();

	}

}

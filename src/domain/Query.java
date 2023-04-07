package domain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import factories.DBConnection;
import factories.SessionFactoryBuilder;
import main.Driver;

@Entity
@Table(name="query")
public class Query {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="complaintid")
	private int complaintid;
	
	@Column(name="studentid")
	private String studentid;
	
	@Column(name="category")
	private String category;
	
	@Column(name="details")
	private String details;
	
	@Column(name="date")
	private String date;
	
	@Column(name="staffid")
	private int staffid;
	
	
	private static final Logger logger = LogManager.getLogger(Query.class.getName());
	
	public Query() {
		
	}
	
	

}

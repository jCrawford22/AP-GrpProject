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

	public Query(int complaintid, String studentid, String category, String details, String date, int staffid) {
		super();
		this.complaintid = complaintid;
		this.studentid = studentid;
		this.category = category;
		this.details = details;
		this.date = date;
		this.staffid = staffid;
	}

	public int getComplaintid() {
		return complaintid;
	}

	public void setComplaintid(int complaintid) {
		this.complaintid = complaintid;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	@Override
	public String toString() {
		return "Query [complaintid=" + complaintid + ", studentid=" + studentid + ", category=" + category
				+ ", details=" + details + ", date=" + date + ", staffid=" + staffid + "]";
	}
	
	
	

}

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
@Table(name="complaints")
public class Complaints {
	
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
	
	
	private static final Logger logger = LogManager.getLogger(Complaints.class.getName());
	
	public Complaints() {
		
	}
	
	


	public Complaints(int complaintid,String studentid, String category, String details, String date, int staffid) {
		super();
		this.complaintid=complaintid;
		this.studentid = studentid;
		this.category = category;
		this.details = details;
		this.date = date;
		this.staffid = staffid;
	}
	
	
	
	public void createComplaint() {
	
		
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(this);
		transaction.commit();
		session.close();
	}
	
	//method to retrieve complaint by complaintid
	public Complaints retrieveComplaint(int id) {
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Complaints obj = (Complaints) session.get(Complaints.class, id);
		transaction.commit();
		session.close();
		logger.info("Complaint retrieved");
		return obj;
	}
	
	
	//method to retrieve complaint from specific student by student id
	//implement to show a student their past complaints
	public List retrieveStudentComplaint(int id) {
List complaints = new ArrayList();
		
		Statement stat=null;
		Connection conn=null;
		ResultSet result=null;
		String sql="SELECT * FROM complaints WHERE studentid= "+id;
		DBConnection dbconn=new DBConnection();
		conn=dbconn.getdatabaseConnection();
		
		try {
			stat=conn.createStatement();
			result=stat.executeQuery(sql);
			while(result.next()) {
				Complaints complaint=new Complaints();
				complaint.setComplaintID(result.getInt(1));
				complaint.setStudentid(result.getString("studentid"));
				complaint.setCategory(result.getString("category"));
				complaint.setDetails(result.getString("details"));
				complaint.setDate(result.getString("date"));
				complaint.setStaffid(result.getInt("staffid"));
				complaints.add(complaint);
			}
			logger.info("Complaint records retrieved");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error in retrieving record");
		}
		
		
		
		
		
		
		return complaints;
	}
	
	//ingnore this method
	public List selectAllComplaint() {
		List complaintLists=null;
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		complaintLists= session.createSQLQuery("SELECT * FROM complaints").getResultList();
		transaction.commit();
		session.close();
		for(Object obj: complaintLists) {
			System.out.println(obj.toString());
		}
		return complaintLists;
		
	}
	
	
	//implement this method to read all from table
	public List readComplaints() {
		List complaints = new ArrayList();
		
		Statement stat=null;
		Connection conn=null;
		ResultSet result=null;
		String sql="SELECT * FROM complaints";
		DBConnection dbconn=new DBConnection();
		conn=dbconn.getdatabaseConnection();
		
		try {
			stat=conn.createStatement();
			result=stat.executeQuery(sql);
			while(result.next()) {
				Complaints complaint=new Complaints();
				complaint.setComplaintID(result.getInt(1));
				complaint.setStudentid(result.getString("studentid"));
				complaint.setCategory(result.getString("category"));
				complaint.setDetails(result.getString("details"));
				complaint.setDate(result.getString("date"));
				complaint.setStaffid(result.getInt("staffid"));
				complaints.add(complaint);
			}
			logger.info("Complaint records retrieved");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error in retrieving record");
		}
		
		
		
		
		
		
		return complaints;
	}
	
	public void updateComplaint(Complaints complaint) {
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(complaint);
		transaction.commit();
		session.close();
		JOptionPane.showMessageDialog(null, "Complaint record updated", "Complaint Update",JOptionPane.INFORMATION_MESSAGE);

		logger.info("record updated");
		
		
		
	}
	
	public void deleteComplaint(Complaints complaint) {
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(complaint);;
		transaction.commit();
		session.close();
		JOptionPane.showMessageDialog(null, "Complaint record deleted", "Complaint delete",JOptionPane.INFORMATION_MESSAGE);

		logger.info("record deleted");
	}
	
	




	

	public void setComplaintID(int complaintid) {
		this.complaintid=complaintid;
		
	}
	
	public int getComplaintID() {
		return complaintid;
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
		return "Complaints [complaintid=" + complaintid + ", studentid=" + studentid + ", category=" + category
				+ ", details=" + details + ", date=" + date + ", staffid=" + staffid + "]";
	}
	
	
}

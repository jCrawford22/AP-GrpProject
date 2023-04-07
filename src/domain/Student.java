package domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="student")
public class Student {
	@Id
	@Column(name="studentid")
	private int studentID;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="emailAddress")
	private String emailAddress;
	
	@Column(name="contactnumber")
	private String contactNumber;
	
	
	
	private static final Logger logger = LogManager.getLogger(Driver.class.getName());
	
	public Student() {
	 
	}
	
	public Student(int studentID, String firstname, String lastname, String emailAddress, String contactNumber) {
		super();
		this.studentID = studentID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailAddress = emailAddress;
		this.contactNumber = contactNumber;
	}
	
	
	//creating student record
	public void createRecord() {
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(this);
		transaction.commit();
		session.close();
	}
	
	
	
	//implement this method to read all from table
		public List readStudent() {
			List students = new ArrayList();
			
			Statement stat=null;
			Connection conn=null;
			ResultSet result=null;
			String sql="SELECT * FROM student";
			DBConnection dbconn=new DBConnection();
			conn=dbconn.getdatabaseConnection();
			
			try {
				stat=conn.createStatement();
				result=stat.executeQuery(sql);
				while(result.next()) {
					Student student= new Student();
					student.setStudentID(result.getInt(1));
					student.setFirstname(result.getString("firstname"));
					student.setLastname(result.getString("lastname"));
					student.setEmailAddress(result.getString("emailaddress"));
					student.setContactNumber(result.getString("contactnumber"));
					
					students.add(student);
				}
				logger.info("Complaint records retrieved");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("Error in retrieving record");
			}
			
			return students;
		}
		
		//read student by student id
		public Student retrieveStudent(int id) {
			Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Student obj = (Student) session.get(Student.class, id);
			transaction.commit();
			session.close();
			logger.info("Student record retrieved");
			return obj;
		}
		
		
		
		public void updateStudent(Student student) {
			Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.update(student);
			transaction.commit();
			session.close();
			JOptionPane.showMessageDialog(null, "Student record updated", "Student Update",JOptionPane.INFORMATION_MESSAGE);
			logger.info("record updated");
		
		}
		public void deleteStudent(Student student) {
			Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.delete(student);;
			transaction.commit();
			session.close();
			JOptionPane.showMessageDialog(null, "Student record deleted", "Student delete",JOptionPane.INFORMATION_MESSAGE);

			logger.info("record deleted");
		}

	
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return " studentID=" + studentID + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", emailAddress=" + emailAddress + ", contactNumber=" + contactNumber +"\n";
	}
	
	
	
}

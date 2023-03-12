package domain;

public class Student {
 
	private int studentID;
	private String firstname;
	private String lastname;
	private String emailAddress;
	private double contactNumber;
	
	public Student() {
	 
	}
	
	public Student(int studentID, String firstname, String lastname, String emailAddress, double contactNumber) {
		super();
		this.studentID = studentID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailAddress = emailAddress;
		this.contactNumber = contactNumber;
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

	public double getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(double contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", emailAddress=" + emailAddress + ", contactNumber=" + contactNumber + "]";
	}
	
	
	
}

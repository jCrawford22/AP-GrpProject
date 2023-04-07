package main;



import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import domain.Complaints;
import domain.Student;
import view.HomeDashboard;
import view.StudentLogin;

public class Driver {
	private static final Logger logger = LogManager.getLogger(Driver.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
       HomeDashboard homeboard = new HomeDashboard();
 homeboard.homeDashboardGUI();
logger.info("Info test");

	Student student = new Student (30,"Paul", "Joohnson", "PJ@email.com", "8765672132" );
	
	//student.updateStudent(student);
	System.out.println(student.retrieveStudent(30));

	//System.out.println(student.readStudent());

	//student.createRecord();
//Complaints com = new Complaints (0,"3", "Missing Grades", "My grades are incorrect", "4/5/2023", 123);
//	
//	System.out.println(com.getStudentid());
	//com.createComplaint();
	//System.out.println(com.retrieveStudentComplaint(3));

	/*
	Complaints obj=com.retrieveComplaint(8);
	System.out.println(obj);
	*/
//	List myList = new ArrayList<>();
//	
//	myList.add(com.selectAllComplaint());
//	
	
		//System.out.println(com.readComplaints());
	//com.deleteComplaint(com);
	
	
	
	
 
	

}
}

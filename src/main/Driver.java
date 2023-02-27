package main;

import factories.IDandPasswords;
import view.StudentLogin;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       IDandPasswords iDnPasswords = new IDandPasswords();
       
       StudentLogin stl = new StudentLogin(iDnPasswords.getStudentLoginInfo());
       stl.StudentLoginGUI();
	}

}

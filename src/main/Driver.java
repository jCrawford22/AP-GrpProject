package main;

import view.HomeDashboard;
import view.StudentLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {
	private static final Logger logger = LogManager.getLogger(Driver.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       HomeDashboard homeboard = new HomeDashboard();
 homeboard.homeDashboardGUI();
 logger.info("Test Info message");
	}

}

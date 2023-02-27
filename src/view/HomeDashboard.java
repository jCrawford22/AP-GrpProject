package view;

import java.awt.Button;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class HomeDashboard {

	//declaration of Variables for HomeDashboard
	public JFrame frame;
	public JPanel  homePanel;
	public JPanel headerPanel;
	public JPanel buttonPanel;
	public JButton studentButton;
	public JButton staffButton;
	public JLabel header;
	
	//GUI Method
	public void homeDashboardGUI() {
		 //initializing GUI Variables
		 frame = new JFrame("Home- Dashboard");
		 homePanel = new JPanel();
		 buttonPanel = new JPanel();
		 headerPanel = new JPanel();
		 header = new JLabel("Elite Java System");
		 studentButton = new JButton("Student");
		 staffButton = new JButton("Staff");
		 
	    //Using a BoxLayout
	 	 homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.PAGE_AXIS));
		
	 	 //adding components to layout
	 	 headerPanel.add(header);
	 	 buttonPanel.add(studentButton);
	 	 buttonPanel.add(staffButton);
	 	 
	 	
	 	 //adding panels to main HomePanel
	 	 homePanel.add(headerPanel);
	 	 homePanel.add(buttonPanel);
	 	 
	 	 //intializing frame components
		 frame.setSize(400,400);
		 frame.setVisible(true);
		 frame.add(homePanel);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       HomeDashboard hb = new HomeDashboard();
       hb.homeDashboardGUI();
 }
}

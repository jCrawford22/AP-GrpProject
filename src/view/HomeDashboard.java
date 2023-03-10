package view;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class HomeDashboard implements ActionListener {

	//declaration of Variables for HomeDashboard
	public JFrame frame;
	public JPanel  homePanel;
	public JPanel headerPanel;
	public JPanel buttonPanel;
	public JButton studentButton;
	public JButton staffButton;
	public JLabel header;
	public JLabel messageLabel;
	StudentLogin stlogin = new StudentLogin();
	StaffLogin stafflogin = new StaffLogin();
	

		

	
	//GUI Method
	public void homeDashboardGUI() {
		 //initializing GUI Variables
		 frame = new JFrame("Home- Dashboard");
		 homePanel = new JPanel();
		 buttonPanel = new JPanel();
		 headerPanel = new JPanel();
		 header = new JLabel("Elite Java System");
		 studentButton = new JButton("Student");
		 studentButton.addActionListener(this);
		 staffButton = new JButton("Staff");
		 staffButton.addActionListener(this);
		 messageLabel = new JLabel();
	    //Using a BoxLayout
	 	 homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.PAGE_AXIS));
		
	 	 //adding components to layout
	 	 headerPanel.add(header);
	 	 buttonPanel.add(studentButton);
	 	 buttonPanel.add(staffButton);
	 	 
	 	
	 	 //adding panels to main HomePanel
	 	 homePanel.add(headerPanel);
	 	 homePanel.add(buttonPanel);
	 	 homePanel.add(messageLabel);
	 	 //intializing frame components
		 frame.setSize(600,600);
		 frame.setVisible(true);
		 frame.add(homePanel);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == staffButton) {
			frame.dispose();
			stafflogin.StaffGUI();
		}else if (e.getSource() == studentButton) {
			frame.dispose();
			stlogin.StudentLoginGUI();
		}
		
	}
}

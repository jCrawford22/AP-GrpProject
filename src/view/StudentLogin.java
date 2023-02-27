package view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StudentLogin implements ActionListener{

	public JFrame frame;
	public JPanel mainPanel;
	public JPanel headerPanel;
	public JPanel usernamePanel;
	public JPanel passwordPanel;
	public JButton loginButton;
	public JLabel header;
	public JLabel username;
	public JLabel passwordJLabel;
	public JTextField usernameField;
	public JPasswordField passwordField;
	public JLabel messageLabel;
	
	//hashmap copy of studentLoginInfo
	public HashMap<String, String> stdLogInfo = new HashMap<String,String>();
	
	public StudentLogin(){
		
	}
	//constructor that takes hashmap as an argument
	public StudentLogin(HashMap<String, String> studentLoginInfo){
		
		stdLogInfo = studentLoginInfo;
		
	}
	
	public void StudentLoginGUI() {
		//initialization of components
		frame = new JFrame("Student Login");
		mainPanel = new JPanel();
		headerPanel = new JPanel();
		usernamePanel = new JPanel();
		passwordPanel = new JPanel();
		header = new JLabel("Student Login");
		username = new JLabel("Student ID");
		usernameField = new JTextField(50);
		passwordJLabel = new JLabel("Password");
		passwordField = new JPasswordField(50);
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		messageLabel = new JLabel();
		//setting the layout of the mainPanel
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		headerPanel.add(header);
		usernamePanel.add(username);
		usernamePanel.add(usernameField);
		passwordPanel.add(passwordJLabel);
		passwordPanel.add(passwordField);
		
		mainPanel.add(headerPanel);
		mainPanel.add(usernamePanel);
		mainPanel.add(passwordPanel);
		mainPanel.add(messageLabel);
		mainPanel.add(loginButton);
		
		
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == loginButton) {
			String userID = usernameField.getText();
			String password = String.valueOf(passwordField.getPassword());
			
			if (stdLogInfo.containsKey(userID)) {
				if (stdLogInfo.get(userID).equals(password)) {
					messageLabel.setText("Login Successful");
				}else {
					messageLabel.setText("Login Unsuccessful");
				}
				
			}
		}
		
	}

	
}

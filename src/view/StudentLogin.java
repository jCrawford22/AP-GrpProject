package view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.exceptions.RSAException;

import factories.DBConnection;
import main.Driver;
import view.StudentDashboard;

public class StudentLogin implements ActionListener{

	public JFrame frame;
	public JPanel mainPanel;
	public JPanel headerPanel;
	public JPanel usernamePanel;
	public JPanel passwordPanel;
	public JPanel buttonPanel;
	public JButton loginButton;
	public JButton resetButton;
	public JLabel header;
	public JLabel username;
	public JLabel passwordJLabel;
	public JTextField usernameField;
	public JPasswordField passwordField;
	public JButton backArrowButton;
	public ImageIcon icon;

	private static final Logger logger = LogManager.getLogger(Driver.class.getName());
	
   StaffLogin stafflog = new StaffLogin();
	DBConnection DB;
	public Connection dbconn;
	//hashmap copy of studentLoginInfo
	public StudentLogin() {
		dbconn = DBConnection.getdatabaseConnection();
	}
	
	public void StudentLoginGUI() {
		//initialization of components
		frame = new JFrame("Student Login");
		mainPanel = new JPanel();
		headerPanel = new JPanel();
		usernamePanel = new JPanel();
		passwordPanel = new JPanel();
		buttonPanel = new JPanel();
		header = new JLabel("Student Login");
		username = new JLabel("Student ID:");
		usernameField = new JTextField(50);
		usernameField.setColumns(20);
		passwordJLabel = new JLabel("Password:");
		passwordField = new JPasswordField(50);
		passwordField.setColumns(20);
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		resetButton = new JButton("Reset");
		resetButton.setBackground(Color.RED);
		resetButton.addActionListener(this);
		icon = new ImageIcon(getClass().getResource("backarrowbutton.png"));
		Image img = icon.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		backArrowButton = new JButton(icon);
		backArrowButton.setActionCommand("back");
		backArrowButton.addActionListener(this);
		//setting the layout of the mainPanel
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		headerPanel.add(header);
		usernamePanel.add(username);
		usernamePanel.add(usernameField);
		passwordPanel.add(passwordJLabel);
		passwordPanel.add(passwordField);
		buttonPanel.add(backArrowButton);
		buttonPanel.add(loginButton);
		buttonPanel.add(resetButton);
		mainPanel.add(headerPanel);
		mainPanel.add(usernamePanel);
		mainPanel.add(passwordPanel);
		mainPanel.add(buttonPanel);
		
		
		frame.setSize(600,600);
		frame.setVisible(true);
		frame.add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == loginButton) {
			String userID = usernameField.getText();
			String password = String.valueOf(passwordField.getPassword());
			StudentDashboard sb = new StudentDashboard(userID);
			try {
				Statement stm = dbconn.createStatement();
				String query = "select * from studentlogin where studentid='" + userID + "' and password='" + password + "'";
				ResultSet rs = stm.executeQuery(query);
				if (rs.next()) {
					frame.dispose();
					logger.info("Student login successful");
					sb.StudentDashboardGui();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				logger.info("Student Login incorrect");
			}
		}
		if (e.getSource() == resetButton) {
			usernameField.setText("");
			passwordField.setText("");
		}
			
			if (e.getSource() == backArrowButton) {
				String cmd = e.getActionCommand();
				 if (cmd.equals("back")) {
			            frame.dispose();
                  HomeDashboard hb = new HomeDashboard();
                  hb.homeDashboardGUI();
			        }
			}
		
	}

	
}

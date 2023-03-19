package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import factories.DBConnection;

public class StaffLogin implements ActionListener {

	public JFrame frame;
	public JPanel mainPanel;
	public JPanel headerPanel;
	public JPanel usernamePanel;
	public JPanel passwordPanel;
	public JPanel buttonPanel;
	public JButton staffloginButton;
	public JButton resetButton;
	public JLabel header;
	public JLabel staffusername;
	public JLabel passwordJLabel;
	public JTextField staffusernameField;
	public JPasswordField staffpasswordField;
	public static JButton backArrowButton;
	public static ImageIcon icon;
	 
	DBConnection DB;
	public Connection dbconn;
	
	public StaffLogin() {
		dbconn = DBConnection.getdatabaseConnection();
		if (dbconn != null) {
			System.out.println("Database Connected");
		}
	}
	public void StaffGUI() {
		frame = new JFrame("Staff Login");
		mainPanel = new JPanel();
		headerPanel = new JPanel();
		usernamePanel = new JPanel();
		passwordPanel = new JPanel();
		buttonPanel = new JPanel();
		header = new JLabel("Staff Login");
		staffusername = new JLabel("Staff ID:");
		staffusernameField = new JTextField(50);
		staffusernameField.setColumns(20);
		passwordJLabel = new JLabel("Password:");
		staffpasswordField = new JPasswordField(50);
		staffpasswordField.setColumns(20);
		staffloginButton = new JButton("Login");
		staffloginButton.addActionListener(this);
		resetButton = new JButton("Reset");
		resetButton.setBackground(Color.RED);
		resetButton.setOpaque(true);
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
		usernamePanel.add(staffusername);
		usernamePanel.add(staffusernameField);
		passwordPanel.add(passwordJLabel);
		passwordPanel.add(staffpasswordField);
		buttonPanel.add(backArrowButton);
		buttonPanel.add(staffloginButton);
		buttonPanel.add(resetButton);
		mainPanel.add(headerPanel);
		mainPanel.add(usernamePanel);
		mainPanel.add(passwordPanel);
		mainPanel.add(buttonPanel);
		
		
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == staffloginButton) {
			String staffuserID = staffusernameField.getText();
			String staffpassword = String.valueOf(staffpasswordField.getPassword());
			try {
				Statement stm = dbconn.createStatement();
				String query = "select * from stafflogin where staffid='" + staffuserID + "' and password='" + staffpassword + "'";
				ResultSet rs = stm.executeQuery(query);
				if (rs.next()) {
					frame.dispose();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		}
		if (e.getSource() == resetButton) {
			staffusernameField.setText("");
			staffpasswordField.setText("");
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

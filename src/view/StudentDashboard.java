package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.Connection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import factories.DBConnection;

public class StudentDashboard implements ActionListener {
	
	DBConnection dbconn;
	private Connection conn;
	public JFrame frame;
	public JPanel sidebarPanel;
	public JPanel dashboardPanel;
	public JPanel mainPanel;
	public JSplitPane splitPane;
	public JLabel usernameText;
	public JLabel dashboardText;
	public JLabel headerText;
	public JLabel home;
	public JLabel pastComplaints;
	public JLabel pastQueries;
	public JButton logoutButton;
	public JButton button1;
	public JButton button2;
	private final int hGap = 25;
    private final int vGap = 25;
	
	public StudentDashboard() {
		
		conn = DBConnection.getdatabaseConnection();
		if (conn != null) {
			System.out.println("Dashboard Connected");
		}
	}
	
	public void StudentDashboardGui() {
		frame = new JFrame("Student Dashboard GUI");
		sidebarPanel = new JPanel();
		dashboardPanel = new JPanel();
		mainPanel = new JPanel(new BorderLayout(hGap, vGap));
		sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.PAGE_AXIS));
		sidebarPanel.setBackground(Color.green);
		sidebarPanel.setOpaque(true);
		dashboardPanel.setLayout(new BoxLayout(dashboardPanel, BoxLayout.PAGE_AXIS));
		usernameText = new JLabel();
		dashboardText = new JLabel("Dashboard");
		headerText = new JLabel("Student Dashboard");
		home = new JLabel("Home");
		pastComplaints = new JLabel("Past Complaints");
		pastQueries = new JLabel("Past Queries");
		logoutButton = new JButton("Logout");
		button1 = new JButton("btn1");
		button2 = new JButton("btn2");
		sidebarPanel.add(dashboardText);
		sidebarPanel.add(Box.createRigidArea(new Dimension(0, 25)));
		sidebarPanel.add(home);
		sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		sidebarPanel.add(pastComplaints);
		sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		sidebarPanel.add(pastQueries);
		sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		sidebarPanel.add(logoutButton);
		dashboardPanel.add(headerText);
		dashboardPanel.add(button2);
		mainPanel.add(sidebarPanel,BorderLayout.WEST);
		mainPanel.add(dashboardPanel,BorderLayout.CENTER);
		
		frame.add(mainPanel);
		frame.setSize(600,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
	
StudentDashboard sb = new StudentDashboard();
sb.StudentDashboardGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

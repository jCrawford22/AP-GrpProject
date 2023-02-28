import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;

public class TestingYute extends JFrame {

	private JPanel contentPane;
	
	private int mouseX, mouseY;

	/**
	 * Create the application.
	 */
	public TestingYute() {
		initialise();
	}
	
	public void initialise() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getX() + e.getX() - mouseX, getY() + e.getY() - mouseY);
			}
		});
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 64, 64));
		panel.setBounds(0, 0, 333, 442);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel bigPicture = new JLabel("");
		bigPicture.setBounds(0, 0, 333, 187);
		panel.add(bigPicture);
		bigPicture.setIcon(new ImageIcon(TestingYute.class.getResource("/images/Scarlet deserves fi get him tire slash.jpg")));
		
		JLabel preaching = new JLabel("Fuck Scarlet");
		preaching.setForeground(Color.WHITE);
		preaching.setFont(new Font("Tahoma", Font.PLAIN, 22));
		preaching.setBounds(100, 213, 171, 35);
		panel.add(preaching);
		
		JLabel toTheChoir = new JLabel("All my homies hate Scarlet");
		toTheChoir.setForeground(Color.WHITE);
		toTheChoir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		toTheChoir.setBounds(56, 259, 252, 35);
		panel.add(toTheChoir);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		lblNewLabel.setForeground(new Color(241, 57, 83));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(653, 0, 46, 14);
		contentPane.add(lblNewLabel);
		
		Button studentButton = new Button("Student ");
		studentButton.setForeground(Color.WHITE);
		studentButton.setBackground(new Color(241, 57, 83));
		studentButton.setBounds(367, 101, 280, 41);
		contentPane.add(studentButton);
		
		Button staffButton = new Button("Staff");
		staffButton.setForeground(Color.WHITE);
		staffButton.setBackground(new Color(241, 57, 83));
		staffButton.setBounds(367, 196, 280, 41);
		contentPane.add(staffButton);
		
		JLabel lblNewLabel_1 = new JLabel("Java Elitist Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(427, 38, 171, 35);
		contentPane.add(lblNewLabel_1);
	}
}

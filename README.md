# AP-GrpProject
package database;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class JTableExamples implements ActionListener {

	JFrame frame = new JFrame();
	JTable j;
	JButton submitButton = new JButton();
	
	public JTableExamples() {
		// constructor
		
		frame.setTitle("New Request");
		
		//sample data
		String [][] data={
			{
				"", "","","","",""
			}
	};
		
		//column names
		String []column= {
				"ID#","Last name","First Name","Email Address","Contact #", "Type of Issue(Query)"
		};
		
		j = new JTable(data, column);
		j.setBounds(30,40,200,300);
		
		TableColumn testColumn = j.getColumnModel().getColumn(5);
	      JComboBox<String> comboBox = new JComboBox<>();
	      comboBox.addItem("Grade query");
	      comboBox.addItem("Possible upcoming event");
	      comboBox.addItem("Class space query");
	      comboBox.addItem("Course query");
	      comboBox.addItem("Mental health advisory query");
	      testColumn.setCellEditor(new DefaultCellEditor(comboBox));
	      
		 
		 //submitButton.setBackground(Color.CYAN);
		 //submitButton.addActionListener(this);
		 
		
		JScrollPane scrollPane = new JScrollPane(j);
	
		//frame.add(submitButton);
		frame.add(scrollPane);
		
		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new JTableExamples();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

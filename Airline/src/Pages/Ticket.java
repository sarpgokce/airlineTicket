package Pages;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Panel;
import javax.swing.JComboBox;
import java.awt.Label;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JSpinner;
import java.awt.Button;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Ticket extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	Connection con;
	PreparedStatement pat;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket frame = new Ticket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ticket() {
		setBounds(100, 100, 874, 715);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(49, 66, 308, 184);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"America", "Russia", "China", "North Korea", "Turkey", "France", "England"}));
		comboBox.setBounds(23, 62, 128, 22);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Turkey", "America", "Russia", "China", "North Korea", "France", "England"}));
		comboBox_1.setBounds(161, 62, 137, 22);
		panel.add(comboBox_1);
		
		Label label = new Label("Source");
		label.setBounds(23, 21, 62, 22);
		panel.add(label);
		
		Label label_1 = new Label("Depart");
		label_1.setBounds(174, 21, 62, 22);
		panel.add(label_1);
		
		Button button_2 = new Button("Search");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String source=comboBox.getSelectedItem().toString();
				String depart=comboBox_1.getSelectedItem().toString();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
					
					pat=con.prepareStatement("select * from flight where source=? and depart=? ");
					pat.setString(1, source);
					pat.setString(2, depart);
					ResultSet rs=pat.executeQuery();
					
					ResultSetMetaData rsm=rs.getMetaData();
					
					int c=rsm.getColumnCount();
					
					DefaultTableModel df =(DefaultTableModel)table.getModel();
					df.setRowCount(0);
					
					while(rs.next()) {
						Vector v2=new Vector();
						
						for(int i=1;i<=c;i++)
						{
							v2.add(rs.getString("id"));
							v2.add(rs.getString("flightname"));
							v2.add(rs.getString("source"));
							v2.add(rs.getString("departure"));
							v2.add(rs.getString("date"));
							v2.add(rs.getString("departuretime"));
							v2.add(rs.getString("arrivaltime"));
							v2.add(rs.getString("flightchange"));
							
						}
						
						df.addRow(v2);
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_2.setBounds(199, 120, 70, 22);
		panel.add(button_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Flight No", "Arr Time", "Dep Time", "Departure", "Date", "Source", "Flight Name", "Change"
			}
		));
		table.setBounds(49, 278, 440, 274);
		getContentPane().add(table);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(409, 52, 416, 198);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Label label_4 = new Label("Customer ID:");
		label_4.setBounds(21, 21, 69, 22);
		panel_1.add(label_4);
		
		TextField textField = new TextField();
		textField.setBounds(139, 21, 136, 22);
		panel_1.add(textField);
		
		Label label_5 = new Label("First Name");
		label_5.setBounds(21, 64, 62, 22);
		panel_1.add(label_5);
		
		Label label_6 = new Label("Last Name");
		label_6.setBounds(21, 110, 62, 22);
		panel_1.add(label_6);
		
		Label label_7 = new Label("Passport No");
		label_7.setBounds(21, 154, 69, 22);
		panel_1.add(label_7);
		
		Label label_8 = new Label("New label");
		label_8.setForeground(new Color(255, 0, 0));
		label_8.setFont(new Font("Dialog", Font.BOLD, 15));
		label_8.setBounds(139, 64, 105, 22);
		panel_1.add(label_8);
		
		Label label_9 = new Label("New label");
		label_9.setForeground(new Color(255, 0, 0));
		label_9.setFont(new Font("Dialog", Font.BOLD, 15));
		label_9.setBounds(139, 110, 105, 22);
		panel_1.add(label_9);
		
		Label label_10 = new Label("New label");
		label_10.setForeground(new Color(255, 0, 0));
		label_10.setFont(new Font("Dialog", Font.BOLD, 15));
		label_10.setBounds(139, 154, 105, 22);
		panel_1.add(label_10);
		
		Label label_2 = new Label("Ticket No");
		label_2.setBounds(254, 23, 62, 22);
		getContentPane().add(label_2);
		
		Label label_3 = new Label("New label");
		label_3.setFont(new Font("Dialog", Font.BOLD, 18));
		label_3.setForeground(new Color(0, 255, 0));
		label_3.setBackground(new Color(255, 0, 0));
		label_3.setBounds(322, 10, 146, 36);
		getContentPane().add(label_3);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(508, 278, 329, 274);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		Label label_11 = new Label("Flight No");
		label_11.setBounds(10, 10, 62, 22);
		panel_2.add(label_11);
		
		Label label_12 = new Label("Flight Name");
		label_12.setBounds(10, 53, 62, 22);
		panel_2.add(label_12);
		
		Label label_13 = new Label("Depart Time");
		label_13.setBounds(10, 102, 62, 22);
		panel_2.add(label_13);
		
		Label label_14 = new Label("Class");
		label_14.setBounds(10, 152, 62, 22);
		panel_2.add(label_14);
		
		Label label_15 = new Label("Price");
		label_15.setBounds(10, 203, 62, 22);
		panel_2.add(label_15);
		
		Label label_16 = new Label("Seats");
		label_16.setBounds(10, 242, 62, 22);
		panel_2.add(label_16);
		
		Label label_17 = new Label("New label");
		label_17.setForeground(new Color(128, 0, 128));
		label_17.setFont(new Font("Dialog", Font.BOLD, 15));
		label_17.setBounds(157, 10, 77, 22);
		panel_2.add(label_17);
		
		Label label_18 = new Label("New label");
		label_18.setForeground(new Color(128, 0, 128));
		label_18.setFont(new Font("Dialog", Font.BOLD, 15));
		label_18.setBounds(157, 53, 77, 22);
		panel_2.add(label_18);
		
		Label label_19 = new Label("New label");
		label_19.setForeground(new Color(128, 0, 128));
		label_19.setFont(new Font("Dialog", Font.BOLD, 15));
		label_19.setBounds(157, 102, 77, 22);
		panel_2.add(label_19);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(157, 152, 77, 22);
		panel_2.add(comboBox_2);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(157, 203, 77, 22);
		panel_2.add(textField_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(166, 244, 53, 20);
		panel_2.add(spinner);
		
		Button button = new Button("Book");
		button.setBounds(538, 601, 70, 22);
		getContentPane().add(button);
		
		Button button_1 = new Button("Cancel");
		button_1.setBounds(670, 601, 70, 22);
		getContentPane().add(button_1);

	}
}

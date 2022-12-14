package Pages;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import java.awt.Panel;
import javax.swing.JComboBox;
import java.awt.Label;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import javax.swing.JSpinner;
import java.awt.Button;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Ticket extends JInternalFrame {
	private JTable table;
	private Label label_3;

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

	public Ticket() {
		
				
		setBounds(100, 100, 855, 493);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(49, 66, 308, 136);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"America", "Russia", "China", "North Korea", "Turkey", "France", "England"}));
		comboBox.setBounds(23, 49, 128, 22);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Turkey", "America", "Russia", "China", "North Korea", "France", "England"}));
		comboBox_1.setBounds(161, 49, 137, 22);
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
					
					pat=con.prepareStatement("select * from flight where source=? and departure=?");
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
		button_2.setBounds(197, 77, 70, 22);
		panel.add(button_2);
		
		
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(409, 52, 416, 150);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Label label_4 = new Label("Customer ID:");
		label_4.setBounds(21, 21, 81, 22);
		panel_1.add(label_4);
		
		TextField textField = new TextField();
		textField.setBounds(139, 21, 136, 22);
		panel_1.add(textField);
		
		Label label_5 = new Label("First Name");
		label_5.setBounds(21, 49, 62, 22);
		panel_1.add(label_5);
		
		Label label_6 = new Label("Last Name");
		label_6.setBounds(21, 77, 62, 22);
		panel_1.add(label_6);
		
		Label label_7 = new Label("Passport No");
		label_7.setBounds(21, 105, 69, 22);
		panel_1.add(label_7);
		
		Label label_8 = new Label("New label");
		label_8.setForeground(new Color(255, 0, 0));
		label_8.setFont(new Font("Dialog", Font.BOLD, 15));
		label_8.setBounds(139, 49, 105, 22);
		panel_1.add(label_8);
		
		Label label_9 = new Label("New label");
		label_9.setForeground(new Color(255, 0, 0));
		label_9.setFont(new Font("Dialog", Font.BOLD, 15));
		label_9.setBounds(139, 77, 105, 22);
		panel_1.add(label_9);
		
		Label label_10 = new Label("New label");
		label_10.setForeground(new Color(255, 0, 0));
		label_10.setFont(new Font("Dialog", Font.BOLD, 15));
		label_10.setBounds(139, 105, 105, 22);
		panel_1.add(label_10);
		
		
		
		Label label_2 = new Label("Ticket No");
		label_2.setBounds(254, 23, 62, 22);
		getContentPane().add(label_2);
		
		label_3 = new Label("");
		label_3.setFont(new Font("Dialog", Font.BOLD, 18));
		label_3.setForeground(new Color(0, 255, 0));
		label_3.setBackground(new Color(255, 0, 0));
		label_3.setBounds(322, 10, 129, 36);
		getContentPane().add(label_3);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(495, 208, 329, 198);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		Label label_11 = new Label("Flight No");
		label_11.setBounds(10, 10, 62, 22);
		panel_2.add(label_11);
		
		Label label_12 = new Label("Flight Name");
		label_12.setBounds(10, 38, 62, 22);
		panel_2.add(label_12);
		
		Label label_13 = new Label("Depart Time");
		label_13.setBounds(10, 66, 62, 22);
		panel_2.add(label_13);
		
		Label label_14 = new Label("Class");
		label_14.setBounds(10, 94, 62, 22);
		panel_2.add(label_14);
		
		Label label_15 = new Label("Price");
		label_15.setBounds(10, 122, 62, 22);
		panel_2.add(label_15);
		
		Label label_16 = new Label("Seats");
		label_16.setBounds(10, 150, 62, 22);
		panel_2.add(label_16);
		
		Label label_17 = new Label("New label");
		label_17.setForeground(new Color(128, 0, 128));
		label_17.setFont(new Font("Dialog", Font.BOLD, 15));
		label_17.setBounds(157, 10, 77, 22);
		panel_2.add(label_17);
		
		Label label_18 = new Label("New label");
		label_18.setForeground(new Color(128, 0, 128));
		label_18.setFont(new Font("Dialog", Font.BOLD, 15));
		label_18.setBounds(157, 38, 77, 22);
		panel_2.add(label_18);
		
		Label label_19 = new Label("New label");
		label_19.setForeground(new Color(128, 0, 128));
		label_19.setFont(new Font("Dialog", Font.BOLD, 15));
		label_19.setBounds(157, 66, 77, 22);
		panel_2.add(label_19);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Economy", "Business"}));
		comboBox_2.setBounds(157, 94, 77, 22);
		panel_2.add(comboBox_2);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(157, 122, 77, 22);
		panel_2.add(textField_1);
		
		
		
		Button button = new Button("Book");
		button.setBounds(543, 431, 70, 22);
		getContentPane().add(button);
		
		Button button_1 = new Button("Cancel");
		button_1.setBounds(658, 431, 70, 22);
		getContentPane().add(button_1);
		
		Button button_3 = new Button("Search");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id=textField.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
					
					pat=con.prepareStatement("select * from customer where id = ?");
					pat.setString(1, id);
					ResultSet rs=pat.executeQuery();
					
					
					if(rs.next() == false)
						JOptionPane.showMessageDialog(button, "record not found");
					
					else
					{
						String fname=rs.getString("firstname");
						String lname=rs.getString("lastname");
						String passport=rs.getString("passport");
						
						
					
						
							
						
						label_8.setText(fname.trim());
						label_9.setText(lname.trim());
						label_10.setText(passport.trim());
						
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
		button_3.setBounds(297, 21, 70, 22);
		panel_1.add(button_3);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel df =(DefaultTableModel)table.getModel();
				int s=table.getSelectedRow();
				label_17.setText(df.getValueAt(	s, 0).toString());
				label_18.setText(df.getValueAt(	s, 1).toString());
				label_19.setText(df.getValueAt(	s, 5).toString());
				textField_1.setText(df.getValueAt(	s, 7).toString());
				
				
			
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Flight No", "Flight Name", "Arr Time", "Dep Time", "Departure", "Date", "Source", "Charge"
			}
		));
		table.setBounds(49, 208, 440, 198);
		getContentPane().add(table);
		
		Label label_20 = new Label("Total Price");
		label_20.setBounds(158, 420, 62, 22);
		getContentPane().add(label_20);
		
		Label label_21 = new Label("New label");
		label_21.setForeground(new Color(0, 64, 0));
		label_21.setFont(new Font("Dialog", Font.BOLD, 15));
		label_21.setBounds(226, 412, 117, 41);
		getContentPane().add(label_21);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				int price=Integer.parseInt(textField_1.getText());
				int qty=Integer.parseInt(spinner.getValue().toString());
				
				int tot=price*qty;
				
				label_21.setText(String.valueOf(tot));
				
			}
		});
		spinner.setBounds(157, 150, 53, 20);
		panel_2.add(spinner);
		
		autoID();

		
		

	}
	
	public void autoID() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("Select MAX(id) from ticket");
			rs.next();
			rs.getString("MAX(id)");
			
			if(rs.getString("MAX(id)") == null)
			{
				label_3.setText("T001");
			}
			
			else
			{
				long id= Long.parseLong(rs.getString("MAX(id)").substring(2,rs.getString("MAX(id)").length()));
				id++;
				label_3.setText("T"+String.format("%03d", id));
				
				
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

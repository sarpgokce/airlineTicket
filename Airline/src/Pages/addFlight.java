package Pages;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class addFlight extends JInternalFrame {

	
	private JTextField textField_1;
	private Label label_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addFlight frame = new addFlight();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con;
	PreparedStatement pat;
	String path=null;
	byte[] userimage=null;

	/**
	 * Create the frame.
	 */
	public addFlight() {
		
		initComponents();
		autoID();

	}
	
	private void initComponents() {
		
		getContentPane().setBackground(new Color(0, 128, 255));
		setBounds(100, 100, 866, 563);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(63, 86, 651, 322);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		Label label = new Label("Flight ID:");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(36, 35, 48, 22);
		panel.add(label);
		
		label_1 = new Label("");
		label_1.setForeground(new Color(0, 255, 0));
		label_1.setBounds(123, 35, 62, 22);
		panel.add(label_1);
		
		
		
		Label label_2 = new Label("Flight Name");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(36, 81, 71, 22);
		panel.add(label_2);
		
		Label label_3 = new Label("Source");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Dialog", Font.BOLD, 12));
		label_3.setBounds(36, 133, 62, 22);
		panel.add(label_3);
		
		Label label_4 = new Label("Departure");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		label_4.setBounds(36, 185, 62, 22);
		panel.add(label_4);
		
		TextField textField = new TextField();
		textField.setBounds(126, 81, 113, 22);
		panel.add(textField);
		
		Label label_5 = new Label("Date");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setFont(new Font("Dialog", Font.BOLD, 12));
		label_5.setBounds(329, 35, 62, 22);
		panel.add(label_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(455, 37, 130, 20);
		panel.add(dateChooser);
		
		Label label_6 = new Label("Departure time");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Dialog", Font.BOLD, 12));
		label_6.setBounds(329, 105, 89, 22);
		panel.add(label_6);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(455, 105, 135, 22);
		panel.add(textField_3);
		
		Label label_7 = new Label("Arrival Time");
		label_7.setForeground(new Color(255, 255, 255));
		label_7.setFont(new Font("Dialog", Font.BOLD, 12));
		label_7.setBounds(329, 173, 94, 22);
		panel.add(label_7);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(455, 173, 130, 22);
		panel.add(textField_4);
		
		Label label_8 = new Label("Flight Change");
		label_8.setForeground(new Color(255, 255, 255));
		label_8.setFont(new Font("Dialog", Font.BOLD, 12));
		label_8.setBounds(329, 239, 89, 22);
		panel.add(label_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"America", "Russia", "China", "North Korea", "Turkey", "France", "England"}));
		comboBox.setBounds(129, 133, 110, 22);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"China", "Russia", "America", "Turkey", "England", "North Korea", "France"}));
		comboBox_1.setBounds(126, 185, 113, 22);
		panel.add(comboBox_1);
		
		
		TextField textField_5 = new TextField();
		textField_5.setBounds(455, 239, 130, 22);
		panel.add(textField_5);
		
		Button button = new Button("Add");		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=label_1.getText();
				String fname=textField.getText();
				String source=comboBox.getSelectedItem().toString();
				String departure=comboBox_1.getSelectedItem().toString();
				String deptime=textField_3.getText();
				String arrtime=textField_4.getText();
				String fchange=textField_5.getText();
				
				
				DateFormat da=new SimpleDateFormat("yyyy-MM-dd");
				String date=da.format(dateChooser.getDate());
				
				
				
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
					
					pat=con.prepareStatement("insert into flight(id,flightname,source,departure,date,departuretime,arrivaltime,flightchange)values(?,?,?,?,?,?,?,?)");
					pat.setString(1, id);
					pat.setString(2, fname);
					pat.setString(3, source);
					pat.setString(4, departure);
					pat.setString(5, date);
					pat.setString(6, deptime);
					pat.setString(7, arrtime);
					pat.setString(8, fchange);
					
					
					pat.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Flight Created");

					
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		button.setBounds(368, 279, 70, 22);
		panel.add(button);
		
		Button button_1 = new Button("Cancel");
		button_1.setBounds(489, 279, 70, 22);
		panel.add(button_1);
		
	
	}
	
	public void autoID() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("Select MAX(id) from flight");
			rs.next();
			rs.getString("MAX(id)");
			
			if(rs.getString("MAX(id)") == null)
			{
				label_1.setText("F001");
			}
			
			else
			{
				long id= Long.parseLong(rs.getString("MAX(id)").substring(2,rs.getString("MAX(id)").length()));
				id++;
				label_1.setText("F"+String.format("%03d", id));
				
				
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

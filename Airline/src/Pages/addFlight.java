package Pages;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class addFlight extends JInternalFrame {

	/**
	 * Launch the application.
	 */
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
		
		Label label_1 = new Label("New label");
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
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(126, 133, 117, 22);
		panel.add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(126, 185, 113, 22);
		panel.add(textField_2);
		
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
		
		TextField textField_5 = new TextField();
		textField_5.setBounds(455, 239, 130, 22);
		panel.add(textField_5);
		
		Button button = new Button("Add");		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=label_6.getText();
				String fname=textField.getText();
				String lname=textField_1.getText();
				String nicno=textField_2.getText();
				String ppid=textField_3.getText();
				//String adress=textArea.getText();
				
				DateFormat da=new SimpleDateFormat("yyyy-MM-dd");
				String date=da.format(dateChooser.getDate());
				
				String gender;
				
				
				
				String contact=textField_4.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
					
					pat=con.prepareStatement("insert into customer(id,firstname,lastname,nic,passport,address,dob,gender,contact,photo)values(?,?,?,?,?,?,?,?,?,?)");
					pat.setString(1, id);
					pat.setString(2, fname);
					pat.setString(3, lname);
					pat.setString(4, nicno);
					pat.setString(5, ppid);
					//pat.setString(6, adress);
					pat.setString(7, date);
					//pat.setString(8, gender);
					pat.setString(9, contact);
					pat.setBytes(10, userimage);
					
					pat.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Registration Created");

					
					
					
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
}

package Pages;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import java.awt.Panel;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class userCreation extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	Connection con;
	PreparedStatement pat;
	
	private Label label_6;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userCreation frame = new userCreation();
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
	public userCreation() {
		setBounds(100, 100, 761, 491);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(28, 28, 578, 328);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		Label label = new Label("User Creation");
		label.setBounds(243, 10, 93, 22);
		panel.add(label);
		
		Label label_1 = new Label("User Id");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(25, 52, 62, 22);
		panel.add(label_1);
		
		Label label_2 = new Label("First name");
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(25, 101, 62, 22);
		panel.add(label_2);
		
		Label label_3 = new Label("Last Name");
		label_3.setFont(new Font("Dialog", Font.BOLD, 12));
		label_3.setBounds(25, 144, 62, 22);
		panel.add(label_3);
		
		Label label_4 = new Label("Username");
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		label_4.setBounds(25, 198, 62, 22);
		panel.add(label_4);
		
		Label label_5 = new Label("Password");
		label_5.setFont(new Font("Dialog", Font.BOLD, 12));
		label_5.setBounds(25, 256, 62, 22);
		panel.add(label_5);
		
		label_6 = new Label("New label");
		label_6.setBounds(161, 52, 62, 22);
		panel.add(label_6);
		
		TextField textField = new TextField();
		textField.setBounds(161, 101, 98, 22);
		panel.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(161, 144, 103, 22);
		panel.add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(162, 198, 102, 22);
		panel.add(textField_2);
		
		
		Button button_1 = new Button("Cancel");
		button_1.setBounds(457, 281, 70, 22);
		panel.add(button_1);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 258, 103, 20);
		panel.add(passwordField);
		

		Button button = new Button("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id=label_6.getText();
				String fname=textField.getText();
				String lname=textField_1.getText();
				String username=textField_2.getText();
				String password=passwordField.getText();
				
	
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
					
					pat=con.prepareStatement("insert into user(id,firstname,lastname,username,password)values(?,?,?,?,?)");
					pat.setString(1, id);
					pat.setString(2, fname);
					pat.setString(3, lname);
					pat.setString(4, username);
					pat.setString(5, password);
					
					pat.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"User Created");

					
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		button.setBounds(364, 281, 70, 22);
		panel.add(button);
		
		
		
		autoID();

	}
	
	public void autoID() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("Select MAX(id) from user");
			rs.next();
			rs.getString("MAX(id)");
			
			if(rs.getString("MAX(id)") == null)
			{
				label_6.setText("U001");
			}
			
			else
			{
				long id= Long.parseLong(rs.getString("MAX(id)").substring(2,rs.getString("MAX(id)").length()));
				id++;
				label_6.setText("U"+String.format("%03d", id));
				
				
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

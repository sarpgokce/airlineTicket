package Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	Connection con;
	PreparedStatement pat;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Login");
		label.setBounds(277, 23, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Username");
		label_1.setBounds(54, 89, 62, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Password");
		label_2.setBounds(54, 164, 62, 22);
		contentPane.add(label_2);
		
		TextField textField = new TextField();
		textField.setBounds(164, 89, 129, 22);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 164, 134, 22);
		contentPane.add(passwordField);
		
		
		
		Button button_1 = new Button("Cancel");
		button_1.setBounds(407, 164, 70, 22);
		contentPane.add(button_1);
		
		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username=textField.getText();
				String password=passwordField.getText();
				
				if(username.isEmpty() || password.isEmpty())
				{
					//JOptionPane.showMessageDialog(this, "usern4me or password blank");
					
				}
				else
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
						
						pat=con.prepareStatement("select * from user where username=? and password=? ");
						pat.setString(1, username);
						pat.setString(2, password);
						
						ResultSet rs;
						
						rs=pat.executeQuery();
						
						if(rs.next())
						{
							Main m=new Main();
							//this.hide;
							m.setVisible(true);
							
							
						}
						
						else {
							//JOptionPane.showMessageDialog(this, "username and password doesnt match");
							textField.setText("");
							passwordField.setText("");
							textField.requestFocus();
						}
						
						
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
					
				
			}
		});
		button.setBounds(407, 89, 70, 22);
		contentPane.add(button);
		
	}
}

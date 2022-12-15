package Pages;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Button;

public class userCreation extends JInternalFrame {

	/**
	 * Launch the application.
	 */
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
		
		Label label_6 = new Label("New label");
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
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(161, 256, 103, 22);
		panel.add(textField_3);
		
		Button button = new Button("Add");
		button.setBounds(364, 281, 70, 22);
		panel.add(button);
		
		Button button_1 = new Button("Cancel");
		button_1.setBounds(457, 281, 70, 22);
		panel.add(button_1);

	}
}

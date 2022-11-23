package Pages;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;

public class addCustomer extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//gfgfgfg
					addCustomer frame = new addCustomer();
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
	public addCustomer() {
		setBounds(100, 100, 655, 429);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(36, 61, 265, 240);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		Label label = new Label("First Name");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(20, 22, 62, 22);
		panel.add(label);
		
		Label label_1 = new Label("Last Name");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(20, 43, 62, 22);
		panel.add(label_1);
		
		Label label_2 = new Label("NIC No");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setBounds(20, 65, 62, 22);
		panel.add(label_2);
		
		Label label_3 = new Label("Passport ID");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setBounds(20, 86, 62, 22);
		panel.add(label_3);
		
		Label label_4 = new Label("Adress");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setBounds(20, 108, 62, 22);
		panel.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(88, 22, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 45, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(88, 67, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(88, 88, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(87, 111, 136, 61);
		panel.add(textArea);
		
		Label label_5 = new Label("Customer ID");
		label_5.setFont(new Font("Dialog", Font.BOLD, 16));
		label_5.setBounds(36, 22, 116, 22);
		getContentPane().add(label_5);
		
		Label label_6 = new Label("New label");
		label_6.setForeground(new Color(255, 0, 0));
		label_6.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_6.setBounds(202, 22, 62, 22);
		getContentPane().add(label_6);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 255));
		panel_1.setBounds(307, 61, 305, 240);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date Of Birth");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(26, 42, 63, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gender");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(26, 90, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(26, 139, 46, 14);
		panel_1.add(lblNewLabel_2);

	}
}

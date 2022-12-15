package Pages;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TicketReport extends JInternalFrame {
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
					TicketReport frame = new TicketReport();
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
	public TicketReport() {
		setBounds(100, 100, 833, 531);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ticket No", "Flight No", "Customer Id", "Class", "Price", "Seats", "Date"
			}
		));
		table.setBounds(38, 34, 394, 247);
		getContentPane().add(table);
		
		LoadData();

	}
	
	public void LoadData() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
			
			pat=con.prepareStatement("select * from ticket");
			
			

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
					v2.add(rs.getString("flightid"));
					v2.add(rs.getString("customerid"));
					v2.add(rs.getString("class"));
					v2.add(rs.getString("price"));
					v2.add(rs.getString("seats"));
					v2.add(rs.getString("date"));
				
					
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
}

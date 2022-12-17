package Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*eksikler: table'daki üst kısım, cancel butonu,gui design,this,messagedialog,main'i mainden logine alma
	 
	
	*/
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 702);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Customer");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Add Customer");
		
		mnNewMenu.add(mntmNewMenuItem_4);
		
		
		
		
		JMenu mnNewMenu_1 = new JMenu("Tickets");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Book Ticket");
		
		
		JMenu mnNewMenu_2 = new JMenu("Flight");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Flight");
		
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("User");
		menuBar.add(mnNewMenu_3);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1016, 641);
		contentPane.add(desktopPane);
		
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomer cus=new addCustomer();
				
				desktopPane.add(cus);
				cus.setVisible(true);
				
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Search Customer");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				searchCustomer scus=new searchCustomer();
				
				desktopPane.add(scus);
				scus.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFlight f1=new addFlight();
				
				desktopPane.add(f1);
				f1.setVisible(true);
				
			}
		});
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ticket rcus=new Ticket();
				
				desktopPane.add(rcus);
				rcus.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1); 
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Ticket Report");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TicketReport tcus=new TicketReport();
				
				desktopPane.add(tcus);
				tcus.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("User Creation");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userCreation ucus=new userCreation();
				
				desktopPane.add(ucus);
				ucus.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
	}
	
}

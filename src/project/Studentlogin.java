package project;

import java.awt.EventQueue;
//import java.sql.Connection;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Studentlogin {

	private JFrame frame;
	private JTextField txtname;
	private JPasswordField txtpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studentlogin window = new Studentlogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Studentlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ROLLNO");
		lblNewLabel.setBounds(64, 120, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(64, 81, 46, 14);
		frame.getContentPane().add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(203, 78, 86, 20);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtpwd = new JPasswordField();
		txtpwd.setBounds(203, 117, 86, 20);
		frame.getContentPane().add(txtpwd);
		
		JButton btlLogin = new JButton("login");
		btlLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:welcome","msc","msc");
					PreparedStatement pst=con.prepareStatement("select * from addstudent where rollno=? and name=?");
					pst.setString(1,txtpwd.getText());
					pst.setString(2,txtname.getText());
					
					ResultSet rs=pst.executeQuery();
					if(rs.next()) {
						System.out.println("User exist");
					
						JOptionPane.showMessageDialog(null, "User Logged In");
						
						Studenthome sh=new Studenthome();
						Studenthome.main(null);
					}
					else {
						JOptionPane.showMessageDialog(null,"User not Loggedin");
					}
					rs.close();
					pst.close();
					
				}
				catch(Exception h) {
					System.out.println(h);
				}
			}
		});
		btlLogin.setBounds(49, 178, 89, 23);
		frame.getContentPane().add(btlLogin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(203, 178, 89, 23);
		frame.getContentPane().add(btnExit);
	}

}

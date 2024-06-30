package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class LoginPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
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
		
		JButton btnNewButton = new JButton("ADMIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminlogin al=new Adminlogin();
				Adminlogin.main(null);
			}
		});
		btnNewButton.setBounds(58, 102, 89, 93);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnStudent = new JButton("STUDENT");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Studentlogin sh=new Studentlogin();
				Studentlogin.main(null);;
			}
		});
		btnStudent.setBounds(282, 102, 89, 93);
		frame.getContentPane().add(btnStudent);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO EXAMINATION MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(33, 41, 414, 50);
		frame.getContentPane().add(lblNewLabel);
	}
}

package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome window = new AdminHome();
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
	public AdminHome() {
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
		
		JLabel lblNewLabel = new JLabel("WELCOME ADMIN!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(117, 26, 156, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser au=new AddUser();
				AddUser.main(null);
				/*
				*/
			}
		});
		btnNewButton.setBounds(30, 106, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnQuestion = new JButton("Question");
		btnQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addquestion aq=new Addquestion();
				Addquestion.main(null);
				
			}
		});
		btnQuestion.setBounds(30, 161, 89, 23);
		frame.getContentPane().add(btnQuestion);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp=new LoginPage();
				LoginPage.main(null);			}
		});
		btnNewButton_1.setBounds(299, 184, 89, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("STUDENT MARKS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminstudentmarks asm=new Adminstudentmarks();
				Adminstudentmarks.main(null);;
				
			}
		});
		btnNewButton_2.setBounds(236, 106, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}

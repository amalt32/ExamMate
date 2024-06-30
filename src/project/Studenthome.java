package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Studenthome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studenthome window = new Studenthome();
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
	public Studenthome() {
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
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(70, 53, 107, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("VIEW MARKS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Studentmarks sm=new Studentmarks();
				Studentmarks.main(null);
				
				
			}
		});
		btnNewButton.setBounds(58, 135, 95, 54);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PROFILE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Studentinfo si=new Studentinfo();
				Studentinfo.main(null);
				
				
			}
		});
		btnNewButton_1.setBounds(296, 36, 89, 54);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp=new LoginPage();
				LoginPage.main(null);;
			}
		});
		btnNewButton_2.setBounds(296, 122, 89, 48);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("EXIT");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2_1.setBounds(296, 190, 89, 48);
		frame.getContentPane().add(btnNewButton_2_1);
	}

}

package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Studentinfo {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studentinfo window = new Studentinfo();
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
	public Studentinfo() {
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
		lblNewLabel.setBounds(169, 35, 69, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblRollNumber = new JLabel("ROLL NUMBER:");
		lblRollNumber.setBounds(25, 73, 89, 14);
		frame.getContentPane().add(lblRollNumber);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setBounds(25, 114, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblCourse = new JLabel("COURSE:");
		lblCourse.setBounds(25, 148, 46, 14);
		frame.getContentPane().add(lblCourse);
		
		JLabel lblSemester = new JLabel("SEMESTER:");
		lblSemester.setBounds(25, 188, 61, 14);
		frame.getContentPane().add(lblSemester);
		
		tf1 = new JTextField();
		tf1.setBounds(121, 70, 86, 20);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(121, 111, 86, 20);
		frame.getContentPane().add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(121, 145, 86, 20);
		frame.getContentPane().add(tf3);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(121, 185, 86, 20);
		frame.getContentPane().add(tf4);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rollno=tf1.getText();
				String name1=tf2.getText();
				String course1=tf3.getText();
				String semester1=tf4.getText();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:welcome","msc","msc");
					PreparedStatement pst=con.prepareStatement("insert into studentinfo(rno,name,course,semester) values(?,?,?,?)");
					pst.setString(1, rollno);
					pst.setString(2, name1);
					pst.setString(3, course1);
					pst.setString(4, semester1);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Records added succefully");
					Studentinstruction si=new Studentinstruction();
					//si.tfone.setText(tf1.getText());
					//si.setVisible(true);
					/*
					 * 
					
				
					 */
					
				}
				catch(Exception i) {
					System.out.println(i);
				}
				
				Studentinstruction au=new Studentinstruction();
				Studentinstruction.main(null);
				
				
			}
		});
		btnNewButton.setBounds(279, 73, 89, 52);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Studenthome sh=new Studenthome();
				Studenthome.main(null);
			}
		});
		btnBack.setBounds(279, 150, 89, 52);
		frame.getContentPane().add(btnBack);
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

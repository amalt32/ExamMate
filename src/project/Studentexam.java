package project;
//import Project.ConnectionProvider;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class Studentexam {
	public String questionId="1";
	public String answer;
	public int marks=0;
	public String number;
	public void answercheck() {
		String studentAnswer="";
		if(r1.isSelected()) {
			studentAnswer=r1.getText();
		}
		else if(r2.isSelected()) {
			studentAnswer=r2.getText();
			}
		else {
			studentAnswer=r3.getText();
		}
		
		if(studentAnswer.equals(answer)) {
			
			marks=marks+1;
			String marks1=String.valueOf(marks);
			tmarks.setText(marks1);
			
			
			int questionId1=Integer.parseInt(questionId);
			questionId1=questionId1+1;
			questionId=String.valueOf(questionId1);
			
			r1.setSelected(false);
			r2.setSelected(false);
			r3.setSelected(false);
		}
		else {
			int questionId1=Integer.parseInt(questionId);
			questionId1=questionId1+1;
			questionId=String.valueOf(questionId1);
		}
		
			
		}
	public void question() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:welcome","msc","msc");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from question where qno='"+questionId+"'" );
			while(rs.next()) {
				t1.setText(rs.getString(1));
				t2.setText(rs.getString(2));
				r1.setText(rs.getString(3));
				r2.setText(rs.getString(4));
				r3.setText(rs.getString(5));
				answer=rs.getString(6);
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	public void submit() {
		String marks1=String.valueOf(marks);
		
		tmarks.setText(marks1);
		JOptionPane.showMessageDialog(null, marks1);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:welcome","msc","msc");
			PreparedStatement pst=con.prepareStatement("UPDATE studentinfo set marks=? WHERE rno=?");
			
			pst.setString(1,marks1);
			pst.setString(2,number);
			
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Marks updated successfully!");
			//System.exit(0);
			Studenthome sh=new Studenthome();
			Studenthome.main(null);;
			
		}
		catch(Exception y) {
			System.out.println(y);
		}
	}

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JRadioButton r2;
	private JRadioButton r1;
	private JRadioButton r3;
	private JLabel lblMarks;
	private JTextField tmarks;
	private JLabel lblNewLabel_1;
	private JTextField trollno;
	private JButton btnClickHere;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studentexam window = new Studentexam();
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
	public Studentexam() {
		initialize();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:welcome","msc","msc");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from question where qno='"+questionId+"'" );
			while(rs.next()) {
				t1.setText(rs.getString(1));
				t2.setText(rs.getString(2));
				r1.setText(rs.getString(3));
				r2.setText(rs.getString(4));
				r3.setText(rs.getString(5));
				answer=rs.getString(6);
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		t1 = new JTextField();
		t1.setBounds(140, 138, 46, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("QNO:");
		lblNewLabel.setBounds(47, 141, 46, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblQuestion = new JLabel("Question:");
		lblQuestion.setBounds(47, 178, 83, 14);
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblQuestion);
		
		JLabel lblOptions = new JLabel("OPTIONS");
		lblOptions.setBounds(233, 230, 92, 14);
		lblOptions.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblOptions);
		
		t2 = new JTextField();
		t2.setBounds(140, 169, 386, 33);
		t2.setColumns(10);
		frame.getContentPane().add(t2);
		
		r2 = new JRadioButton("New radio button");
		r2.setBounds(223, 286, 109, 23);
		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r2.isSelected()) {
					r1.setSelected(false);
					r3.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(r2);
		
		r1 = new JRadioButton("New radio button");
		r1.setBounds(66, 286, 109, 23);
		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(r1.isSelected()) {
					r2.setSelected(false);
					r3.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(r1);
		
		r3 = new JRadioButton("New radio button");
		r3.setBounds(371, 286, 109, 23);
		r3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r3.isSelected()) {
					r1.setSelected(false);
					r2.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(r3);
		
		lblMarks = new JLabel("MARKS");
		lblMarks.setBounds(47, 378, 46, 14);
		frame.getContentPane().add(lblMarks);
		
		tmarks = new JTextField();
		tmarks.setBounds(103, 375, 86, 20);
		tmarks.setColumns(10);
		frame.getContentPane().add(tmarks);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.setBounds(298, 374, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				answercheck();
				question();
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(437, 374, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a=JOptionPane.showConfirmDialog(null,"Do you want to exit","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					answercheck();
					submit();
				}
			}
		});
		frame.getContentPane().add(btnSubmit);
		
		lblNewLabel_1 = new JLabel("Enter your rollnumber:");
		lblNewLabel_1.setBounds(31, 45, 182, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_1);
		
		trollno = new JTextField();
		trollno.setBounds(223, 44, 60, 20);
		trollno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				}
				catch(Exception u) {
					System.out.println(u);
				}
			}
		});
		frame.getContentPane().add(trollno);
		trollno.setColumns(10);
		
		btnClickHere = new JButton("Click here");
		btnClickHere.setBounds(319, 41, 89, 40);
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 number=trollno.getText();
				
				
			}
		});
		frame.getContentPane().add(btnClickHere);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setForeground(SystemColor.activeCaption);
		panel.setBounds(31, 92, 506, 260);
		frame.getContentPane().add(panel);
	}
}

package project;

import java.awt.EventQueue;
import java.sql.*;
import java.sql.PreparedStatement;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Addquestion {

	private JFrame frame;
	private JTextField quesno;
	private JTextField q;
	private JTextField opt1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addquestion window = new Addquestion();
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
	public Addquestion() {
		initialize();
		Connect();
		table_load();
		
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	private JTextField textField;
	private JTextField opt2;
	private JTextField opt3;
	private JTextField ans;
	
	public void Connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:welcome","msc","msc");
			
			
		}
		
		catch(Exception i)
		{
			System.out.println(i);
		}
	}
	
	
	public void table_load() {
		try {
			pst=con.prepareStatement("select * from question");
			rs=pst.executeQuery();
			TableModel model=DbUtils.resultSetToTableModel(rs);
			table.setModel(model);
		}
		catch(Exception h) {
			System.out.println(h);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 596, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane add_srno = new JLayeredPane();
		add_srno.setBounds(27, 32, 438, 164);
		add_srno.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Questions", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(add_srno);
		add_srno.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Question no:");
		lblNewLabel.setBounds(6, 36, 96, 14);
		add_srno.add(lblNewLabel);
		
		JLabel lblStudentCourse = new JLabel("QUESTION");
		lblStudentCourse.setBounds(6, 68, 96, 14);
		add_srno.add(lblStudentCourse);
		
		JLabel opt1qq = new JLabel("OPTION 1");
		opt1qq.setBounds(6, 112, 96, 14);
		add_srno.add(opt1qq);
		
		quesno = new JTextField();
		quesno.setBounds(115, 33, 43, 20);
		add_srno.add(quesno);
		quesno.setColumns(10);
		
		q = new JTextField();
		q.setColumns(10);
		q.setBounds(112, 65, 261, 20);
		add_srno.add(q);
		
		opt1 = new JTextField();
		opt1.setColumns(10);
		opt1.setBounds(75, 109, 86, 20);
		add_srno.add(opt1);
		
		JLabel opt2a = new JLabel("OPTION 2");
		opt2a.setBounds(6, 137, 96, 14);
		add_srno.add(opt2a);
		
		JLabel lblOption_1 = new JLabel("OPTION 3");
		lblOption_1.setBounds(215, 112, 96, 14);
		add_srno.add(lblOption_1);
		
		opt2 = new JTextField();
		opt2.setColumns(10);
		opt2.setBounds(75, 134, 86, 20);
		add_srno.add(opt2);
		
		opt3 = new JTextField();
		opt3.setColumns(10);
		opt3.setBounds(287, 109, 86, 20);
		add_srno.add(opt3);
		
		ans = new JTextField();
		ans.setColumns(10);
		ans.setBounds(287, 134, 86, 20);
		add_srno.add(ans);
		
		JLabel lblOption_1_1 = new JLabel("ANSWER");
		lblOption_1_1.setBounds(215, 137, 96, 14);
		add_srno.add(lblOption_1_1);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBounds(31, 207, 74, 42);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q_no,question,opt_1,opt_2,opt_3,answer;
				q_no=quesno.getText();
				question=q.getText();
				opt_1=opt1.getText();
				opt_2=opt2.getText();
				opt_3=opt3.getText();
				answer=ans.getText();
				
				try {
					pst= con.prepareStatement("insert into question(qno,q,opt_1,opt_2,opt_3,ans)values(?,?,?,?,?,?)");
					pst.setString(1,q_no);
					pst.setString(2,question);
					pst.setString(3,opt_1);
					pst.setString(4,opt_2);
					pst.setString(5,opt_3);
					pst.setString(6,answer);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Records added succefully");
					table_load();
					quesno.setText("");
					q.setText("");
					opt1.setText("");
					opt2.setText("");
					opt3.setText("");
					ans.setText("");
					quesno.requestFocus();
					
					
					
					
				}
				catch(Exception w) {
					System.out.println(w);
				}
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(127, 207, 64, 42);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			
			}
			
		});
		frame.getContentPane().add(btnExit);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(199, 207, 64, 42);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quesno.setText("");
				q.setText("");
				opt1.setText("");
				quesno.requestFocus();
				
			}
		});
		frame.getContentPane().add(btnClear);
		
		JButton btnClear_1 = new JButton("DELETE");
		btnClear_1.setBounds(453, 305, 74, 37);
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String q_no;
				q_no=quesno.getText();
				String urno;
				urno=opt1.getText();
				
				try {
					pst= con.prepareStatement("delete from  question where qno =?");
					pst.setString(1,q_no);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Records deleted succefully");
					table_load();
					quesno.setText("");
					q.setText("");
					opt1.setText("");
					opt2.setText("");
					opt3.setText("");
					ans.setText("");
					quesno.requestFocus();
					
					
					
					
				}
				catch(Exception w) {
					System.out.println(w);
				}
				
				
			}
		});
		frame.getContentPane().add(btnClear_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 260, 392, 150);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(283, 207, 258, 53);
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel);
		
		JLabel lblRollNumber_1 = new JLabel("Question no:");
		panel.add(lblRollNumber_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String qno=textField.getText();
					pst=con.prepareStatement("select qno,q,opt_1,opt_2,opt_3,ans from question where qno=?");
					pst.setString(1,qno);
					ResultSet rs=pst.executeQuery();
					
					if(rs.next()==true) {
						String question_no=rs.getString(1);
						String ques=rs.getString(2);
						String optone=rs.getString(3);
						String opttwo=rs.getString(4);
						String optthree=rs.getString(5);
						String answer=rs.getString(6);
						
						quesno.setText(question_no);
						q.setText(ques);
						opt1.setText(optone);
						opt2.setText(opttwo);
						opt3.setText(optthree);
						ans.setText(answer);
						
						
						
					}
					else {
						quesno.setText("");
						q.setText("");
						opt1.setText("");
						opt2.setText("");
						opt3.setText("");
						ans.setText("");
						
					}
					
					
				}
				catch(Exception s) {
					System.out.println(s);
				}
			}
		});
		textField.setColumns(10);
		panel.add(textField);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(453, 271, 74, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHome ah=new AdminHome();
				AdminHome.main(null);
			}
		});
		btnNewButton_1.setBounds(453, 369, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q_no,question,opt_1,opt_2,opt_3,answer;
				q_no=quesno.getText();
				question=q.getText();
				opt_1=opt1.getText();
				opt_2=opt2.getText();
				opt_3=opt3.getText();
				answer=ans.getText();
				
				try {
					
					ans.setText(answer);
					pst= con.prepareStatement("update question set qno=?,q=?,opt_1=?,opt_2=?,opt_3=?,ans=? where qno =?");
					pst.setString(1,q_no);
					pst.setString(2,question);
					pst.setString(3,opt_1);
					pst.setString(4,opt_2);
					pst.setString(5,opt_3);
					pst.setString(6,answer);
					pst.setString(7,q_no);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Records added succefully");
					table_load();
					quesno.setText("");
					q.setText("");
					opt1.setText("");
					opt2.setText("");
					opt3.setText("");
					ans.setText("");
					quesno.requestFocus();
					
					
					
					
				}
				catch(Exception w) {
					System.out.println(w);
				}
			}
		});
	}
}

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
public class AddUser {

	private JFrame frame;
	private JTextField add_sname;
	private JTextField add_scourse;
	private JTextField add_rno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser window = new AddUser();
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
	public AddUser() {
		initialize();
		Connect();
		table_load();
		
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	private JTextField textField;
	
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
			pst=con.prepareStatement("select * from addstudent");
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
		frame.setBounds(100, 100, 567, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane add_srno = new JLayeredPane();
		add_srno.setBounds(28, 51, 250, 164);
		add_srno.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(add_srno);
		add_srno.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name:");
		lblNewLabel.setBounds(6, 36, 96, 14);
		add_srno.add(lblNewLabel);
		
		JLabel lblStudentCourse = new JLabel("Student Course:");
		lblStudentCourse.setBounds(6, 68, 96, 14);
		add_srno.add(lblStudentCourse);
		
		JLabel lblRollNumber = new JLabel("Roll Number:");
		lblRollNumber.setBounds(6, 112, 96, 14);
		add_srno.add(lblRollNumber);
		
		add_sname = new JTextField();
		add_sname.setBounds(150, 33, 86, 20);
		add_srno.add(add_sname);
		add_sname.setColumns(10);
		
		add_scourse = new JTextField();
		add_scourse.setColumns(10);
		add_scourse.setBounds(150, 65, 86, 20);
		add_srno.add(add_scourse);
		
		add_rno = new JTextField();
		add_rno.setColumns(10);
		add_rno.setBounds(150, 109, 86, 20);
		add_srno.add(add_rno);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBounds(31, 237, 74, 42);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname,ucourse,urno;
				uname=add_sname.getText();
				ucourse=add_scourse.getText();
				urno=add_rno.getText();
				
				try {
					pst= con.prepareStatement("insert into addstudent(name,course,rollno)values(?,?,?)");
					pst.setString(1,uname);
					pst.setString(2,ucourse);
					pst.setString(3,urno);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Records added succefully");
					table_load();
					add_sname.setText("");
					add_scourse.setText("");
					add_rno.setText("");
					add_sname.requestFocus();
					
					
					
					
				}
				catch(Exception w) {
					System.out.println(w);
				}
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(130, 237, 64, 42);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			
			}
			
		});
		frame.getContentPane().add(btnExit);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_sname.setText("");
				add_scourse.setText("");
				add_rno.setText("");
				add_sname.requestFocus();
				
			}
		});
		btnClear.setBounds(204, 237, 64, 42);
		frame.getContentPane().add(btnClear);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname,ucourse,urno;
				uname=add_sname.getText();
				ucourse=add_scourse.getText();
				urno=add_rno.getText();
				
				try {
					pst= con.prepareStatement("update addstudent set name=?,course=?,rollno=? where rollno =?");
					pst.setString(1,uname);
					pst.setString(2,ucourse);
					pst.setString(3,urno);
					pst.setString(4, urno);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Records added succefully");
					table_load();
					add_sname.setText("");
					add_scourse.setText("");
					add_rno.setText("");
					add_sname.requestFocus();
					
					
					
					
				}
				catch(Exception w) {
					System.out.println(w);
				}
			}
		});
		btnUpdate.setBounds(305, 237, 114, 42);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnClear_1 = new JButton("DELETE");
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String urno;
				urno=add_rno.getText();
				
				try {
					pst= con.prepareStatement("delete from  addstudent where rollno =?");
					pst.setString(1,urno);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Records deleted succefully");
					table_load();
					add_sname.setText("");
					add_scourse.setText("");
					add_rno.setText("");
					add_sname.requestFocus();
					
					
					
					
				}
				catch(Exception w) {
					System.out.println(w);
				}
				
				
			}
		});
		btnClear_1.setBounds(305, 290, 114, 36);
		frame.getContentPane().add(btnClear_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 58, 240, 157);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(28, 293, 258, 53);
		frame.getContentPane().add(panel);
		
		JLabel lblRollNumber_1 = new JLabel("Roll Number:");
		panel.add(lblRollNumber_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String rno=textField.getText();
					pst=con.prepareStatement("select name,course,rollno from addstudent where rollno=?");
					pst.setString(1,rno);
					ResultSet rs=pst.executeQuery();
					
					if(rs.next()==true) {
						String sname=rs.getString(1);
						String scourse=rs.getString(2);
						String srno=rs.getString(3);
						
						add_sname.setText(sname);
						add_scourse.setText(scourse);
						add_rno.setText(srno);
						
					}
					else {
						add_sname.setText("");
						add_scourse.setText("");
						add_rno.setText("");
						
					}
					
					
				}
				catch(Exception s) {
					System.out.println(s);
				}
			}
		});
		textField.setColumns(10);
		panel.add(textField);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHome ah=new AdminHome();
				AdminHome.main(null);
			}
		});
		btnBack.setBounds(444, 250, 74, 76);
		frame.getContentPane().add(btnBack);
	}
}

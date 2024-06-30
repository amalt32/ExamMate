package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class Studentinstruction {
	public String rollno;

	private JFrame frame;

	protected Object tfl1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studentinstruction window = new Studentinstruction();
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
	public Studentinstruction() {
		initialize();
	}
	/*public Studentinstruction(String rollno1) {
		initialize();
		tfone.setText(rollno);
		tfone.setVisible(true);;
		//JOptionPane.showMessageDialog(null,rollno1);
		
	}*/

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSTRUCTION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(145, 21, 165, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("START EXAM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Studentexam se=new Studentexam();
				Studentexam.main(null);;
			}
		});
		btnNewButton.setBounds(145, 227, 135, 23);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setForeground(Color.WHITE);
		panel.setBounds(33, 55, 361, 161);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("*There are total of 5 questions");
		lblNewLabel_1.setBounds(10, 11, 226, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("*All 5 questions are of type MCQ");
		lblNewLabel_1_1.setBounds(10, 41, 226, 26);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("*Make sure to attend all the questions.");
		lblNewLabel_1_1_1.setBounds(10, 78, 226, 26);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("*you can attempt the exam multiple times, but first attempted");
		lblNewLabel_1_1_1_1.setBounds(10, 108, 308, 46);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("mark is recorded..");
		lblNewLabel_2.setBounds(24, 140, 118, 14);
		panel.add(lblNewLabel_2);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

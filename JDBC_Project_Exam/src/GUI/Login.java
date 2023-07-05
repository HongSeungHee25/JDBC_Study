package GUI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JFrame{

	private JLabel label;
	private JButton button;
	
	public Login() {
		setBounds(100,100,900,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("렌트가 예약 프로그램");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		label = new JLabel("ID : ");
		label.setBounds(280,450,100,30);
		getContentPane().add(label);
		
		JTextField textField = new JTextField();
		textField.setBounds(330,450,220,30);
		getContentPane().add(textField);
		
		label = new JLabel("PW : ");
		label.setBounds(280,500,100,30);
		getContentPane().add(label);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(330,500,220,30);
		getContentPane().add(passwordField);
		
		button = new JButton("로그인");
		button.setBounds(330,550,100,30);
		getContentPane().add(button);
		
		button = new JButton("회원 가입");
		button.setBounds(450,550,100,30);
		getContentPane().add(button);
		
	}
	
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {
	            	Login window = new Login();
	            	Join join = new Join();
	               window.setVisible(true);
	               join.setVisible(true);
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	      });
	   }
	
}

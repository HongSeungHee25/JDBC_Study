package GUI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

public class Pay extends JFrame{

	private JLabel label;
	private JLabel label_3;
	private JLabel label_2;
	private JLabel label_1;
	private JButton button;
	
	public Pay() {
		setBounds(100, 100, 900, 800);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("결제 화면");
	    getContentPane().setLayout(null);
	    setLocationRelativeTo(null);
		
		label = new JLabel("대여 날짜 : ");
		label.setFont(new Font("굴림", Font.PLAIN, 20));
		label.setBounds(200,150,150,30);
		label.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(label);
		
		JTextField textField = new JTextField();
		textField.setBounds(350, 150, 300, 40);
		getContentPane().add(textField);
		
		
		label_1 = new JLabel("반납 날짜 : ");
		label_1.setFont(new Font("굴림", Font.PLAIN, 20));
		label_1.setBounds(200,250,150,30);
		label_1.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(350, 250, 300, 40);
		getContentPane().add(textField);
		
		
		label_2 = new JLabel("결제 할 금액 : ");
		label_2.setFont(new Font("굴림", Font.PLAIN, 20));
		label_2.setBounds(200,350,150,30);
		label_2.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(label_2);
		
		JLabel lblNewLabel = new JLabel("금액 출력");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 17));
		lblNewLabel.setBounds(350, 350, 300, 40);
		getContentPane().add(lblNewLabel);
		
		
		label_3 = new JLabel("결제 방법 : ");
		label_3.setFont(new Font("굴림", Font.PLAIN, 20));
		label_3.setBounds(200,450,150,30);
		label_3.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(label_3);
		
		String[] temp = {"신용카드","계좌이체"};
		JComboBox<String> jc = new JComboBox<>(temp);
		jc.setFont(new Font("굴림", Font.PLAIN, 18));
		jc.setBounds(350, 450, 300, 40);
		getContentPane().add(jc);
		
		button = new JButton("결제하기");
		button.setFont(new Font("굴림", Font.PLAIN, 17));
		button.setBounds(380, 600, 150, 50);
		getContentPane().add(button);
		
		
		
	}
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {
	            	Pay window = new Pay();
	               window.setVisible(true);
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	      });
	   }
}

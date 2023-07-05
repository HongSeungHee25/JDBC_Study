package partD.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Ex extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex frame = new Ex();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ex() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ID ");
		contentPane.add(lblNewLabel);
		contentPane.setBounds(100, 200, 100, 100);
		
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setBounds(200, 200, 300, 100);
		
		JLabel lblNewLabel_1 = new JLabel("PW");
		contentPane.add(lblNewLabel_1);
		contentPane.setBounds(100, 300, 100, 100);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		contentPane.add(passwordField);
		textField.setBounds(200, 300, 300, 100);
	}

}

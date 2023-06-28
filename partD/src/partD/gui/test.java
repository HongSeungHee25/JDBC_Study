package partD.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 341);
		contentPane = new JPanel();
		FlowLayout flowLayout = (FlowLayout) contentPane.getLayout();
		contentPane.setBackground(new Color(255, 128, 192));
		contentPane.setForeground(new Color(0, 255, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton_1 = new JButton("button2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_2 = new JButton("button1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("radio button");
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel = new JLabel("test");
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("button3");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);
	}

}

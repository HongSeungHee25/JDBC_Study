package partD.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class TEST1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JComboBox comboBox;
	private JSlider slider;
	private JLabel lblNewJgoodiesLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TEST1 frame = new TEST1();
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
	public TEST1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("ID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PASSWORD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		contentPane.add(passwordField);
		
		comboBox = new JComboBox();
		contentPane.add(comboBox);
		
		lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
		contentPane.add(lblNewJgoodiesLabel);
		
		slider = new JSlider();
		contentPane.add(slider);
	}

}

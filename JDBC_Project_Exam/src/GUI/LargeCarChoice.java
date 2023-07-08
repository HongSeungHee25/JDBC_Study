package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LargeCarChoice extends JFrame {
	Container c;
	JPanel panel;
	
	LargeCarChoice(){
		setTitle("대형차 종류 선택하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		c = getContentPane();
		panel = new JPanel();
		setBounds(100,100,900,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		  gbc.insets.top = 5;
		  gbc.insets.bottom = 5;
		  gbc.insets.left = 10;
		  gbc.insets.right = 10;
		
		JButton button1 = new JButton();
		// 이미지 파일 경로 지정
		ImageIcon imageIcon1 = new ImageIcon("/Users/kimjisoo/eclipse-workspace/rv/2023 Carnival.png");
		// 이미지 크기 조정
		Image image1 = imageIcon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	    Dimension buttonSize1 = new Dimension(200, 200);
		 
	      button1.setIcon(new ImageIcon(image1.getScaledInstance(buttonSize1.width, buttonSize1.height, Image.SCALE_SMOOTH)));
		  button1.setPreferredSize(buttonSize1);
		  gbc.gridx = 0;
		  gbc.gridy = 0;
		  gbc.anchor = GridBagConstraints.WEST;
		  panel.add(button1, gbc);
		
		JLabel label1 = new JLabel("카니발 ");
	      gbc.gridx = 0;
	      gbc.gridy = 1;
	      gbc.anchor = GridBagConstraints.CENTER;
	      panel.add(label1, gbc);
	      label1.setFont(new Font("맑은 고딕" , Font.BOLD, 20));
		
		JButton button2 = new JButton();
		ImageIcon imageIcon2 = new ImageIcon("/Users/kimjisoo/eclipse-workspace/rv/2023 Staria.jpg");

	    Image image2 = imageIcon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	    Dimension buttonSize2 = new Dimension(200, 200);
	      
	      button2.setIcon(new ImageIcon(image2.getScaledInstance(buttonSize1.width, buttonSize1.height, Image.SCALE_SMOOTH)));
	      button2.setPreferredSize(buttonSize2);
	      gbc.gridx = 2;
	      gbc.gridy = 0;
	      gbc.anchor = GridBagConstraints.EAST;
	      panel.add(button2, gbc);

	      
	    JLabel label2 = new JLabel("스타리아 ");
	    label2.setFont(new Font("맑은 고딕" , Font.BOLD, 20));
	      gbc.gridx = 2;
	      gbc.gridy = 1;
	      gbc.anchor = GridBagConstraints.CENTER;
	      panel.add(label2, gbc);

	    JButton button3 = new JButton("뒤로가기 ");
	      gbc.gridx = 1;
	      gbc.gridy = 4;
	      gbc.anchor = GridBagConstraints.CENTER;
	      panel.add(button3, gbc);
	      button3.setFont(new Font("맑은 고딕" , Font.BOLD, 20));

	      
	      c.add(panel);
		
	}


	public static void main(String[] args) {
		LargeCarChoice c = new LargeCarChoice();
		c.setVisible(true);
	}
	
}
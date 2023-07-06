package gui_ex;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class background_Join extends JFrame {

    private JScrollPane jScrollPane;
    private ImageIcon icon;
    private JLabel label;
    private JCheckBox licenseCheckBox; // 수정: licenseCheckBox 변수 선언
    private JTextField nameTextField;
    private JTextField idTextField;
    private JPasswordField passwordField;
    private JTextField phoneTextField;
    private JButton joinbutton;
    private JButton cancelButton;
    
    public background_Join() {
        setTitle("main");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);

        icon = new ImageIcon("C:\\Users\\82108\\OneDrive\\바탕 화면\\자동차 로고\\라벨2.jpeg");

        JPanel back = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };

        back.setLayout(null);

        label = new JLabel("회원 이름 : ");
        label.setBounds(150, 100, 80, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        back.add(label);

        nameTextField = new JTextField();
        nameTextField.setBounds(250, 100, 250, 30);
        back.add(nameTextField);

        label = new JLabel("회원 ID : ");
        label.setBounds(150, 150, 80, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        back.add(label);

        idTextField = new JTextField();
        idTextField.setBounds(250, 150, 250, 30);
        back.add(idTextField);

        label = new JLabel("비밀번호 : ");
        label.setBounds(150, 200, 80, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        back.add(label);

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 200, 250, 30);
        back.add(passwordField);

        label = new JLabel("전화번호 : ");
        label.setBounds(150, 250, 80, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        back.add(label);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(250, 250, 250, 30);
        back.add(phoneTextField);

        label = new JLabel("면허증 여부 ");
        label.setBounds(300, 300, 80, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        back.add(label);

        licenseCheckBox = new JCheckBox();
        licenseCheckBox.setBounds(380, 300, 250, 30);
        licenseCheckBox.setOpaque(false);
        back.add(licenseCheckBox);

        joinbutton = new JButton("회원가입");
        joinbutton.setBounds(350, 400, 90, 30);
        joinbutton.setHorizontalAlignment(JLabel.CENTER);
        back.add(joinbutton);

        cancelButton = new JButton("취소");
        cancelButton.setBounds(260, 400, 60, 30);
        cancelButton.setHorizontalAlignment(JLabel.CENTER);
        back.add(cancelButton);

        jScrollPane = new JScrollPane(back);
        setContentPane(jScrollPane);
    }

    public static void main(String[] args) {
        background_Join frame = new background_Join();
        frame.setVisible(true);
    }
}

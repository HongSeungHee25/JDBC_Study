package gui_ex;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class background_Login extends JFrame {

    private JScrollPane jScrollPane;
    private ImageIcon icon;
    private JLabel label;
    private JLabel label_1;
    private JButton loginButton;
    private JButton joinButton;
    private JButton managerButton;

    public background_Login() {
        setTitle("main");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 800);
        setLocationRelativeTo(null);

        icon = new ImageIcon("C:\\Users\\82108\\OneDrive\\바탕 화면\\자동차 로고\\로그인Test.jpg");

        JPanel back = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };

        back.setLayout(null);

        label = new JLabel("ID : ");
        label.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
        label.setBounds(280, 450, 100, 30);
        back.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(330, 450, 220, 30);
        back.add(textField);

        label_1 = new JLabel("PW : ");
        label_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
        label_1.setBounds(280, 500, 100, 30);
        back.add(label_1);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(330, 500, 220, 30);
        back.add(passwordField);

        loginButton = new JButton("로그인");
        loginButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
        loginButton.setBounds(330, 550, 100, 30);
        back.add(loginButton);

        joinButton = new JButton("회원 가입");
        joinButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
        joinButton.setBounds(450, 550, 100, 30);
        back.add(joinButton);

        managerButton = new JButton("관리자로 로그인");
        managerButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
        managerButton.setBounds(370, 600, 150, 30);
        back.add(managerButton);

        jScrollPane = new JScrollPane(back);
        setContentPane(jScrollPane);
    }

    public static void main(String[] args) {
        background_Login frame = new background_Login();
        frame.setVisible(true);
    }
}

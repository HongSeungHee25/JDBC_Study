package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.CustomerDAO;
import DTO.Customer;
import java.awt.Toolkit;
import java.awt.Font;

@SuppressWarnings("serial")
public class Login extends JFrame {

    private JLabel label;
    private JLabel label_1;
    private JButton loginButton;
    private JButton joinButton;
    private JButton Managerbutton;

    public Login() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\82108\\OneDrive\\바탕 화면\\로그인Test.jpg"));
        setBounds(100, 100, 900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("렌트가 예약 프로그램");
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        label = new JLabel("ID : ");
        label.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
        label.setBounds(280, 450, 100, 30);
        getContentPane().add(label);

        JTextField textField = new JTextField();
        textField.setBounds(330, 450, 220, 30);
        getContentPane().add(textField);

        label_1 = new JLabel("PW : ");
        label_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
        label_1.setBounds(280, 500, 100, 30);
        getContentPane().add(label_1);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(330, 500, 220, 30);
        getContentPane().add(passwordField);

        loginButton = new JButton("로그인");
        loginButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
        loginButton.setBounds(330, 550, 100, 30);
        getContentPane().add(loginButton);

        joinButton = new JButton("회원 가입");
        joinButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
        joinButton.setBounds(450, 550, 100, 30);
        getContentPane().add(joinButton);

        Managerbutton = new JButton("관리자로 로그인");
        Managerbutton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
        Managerbutton.setBounds(370, 600, 150, 30);
        getContentPane().add(Managerbutton);

        // 로그인 버튼에 액션 리스너 추가
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField.getText();
                String password = new String(passwordField.getPassword());
                try {
                    Customer customer = CustomerDAO.getCustomerDAO().login(id, password);
                    if (customer != null) {
                        // 로그인 성공 시 실행할 코드 작성
                        JOptionPane.showMessageDialog(null, "로그인 성공!");
                    } else {
                        // 로그인 실패 시 실행할 코드 작성
                        JOptionPane.showMessageDialog(null, "로그인 실패!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // 회원 가입 버튼에 액션 리스너 추가
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원 가입 창을 띄우는 코드 작성
                Join join = new Join();
                join.setVisible(true);
            }
        });
    
    
        Managerbutton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String password = new String(passwordField.getPassword());

            // Check if the entered password matches the manager's password
            if (password.equals("1234")) {
                // Open the manager management window
                Manager_Ex managerManagement = new Manager_Ex();
                managerManagement.setVisible(true);
                dispose(); // Close the login window
            } else {
                // Display an error message for incorrect password
                JOptionPane.showMessageDialog(null, "잘못된 비밀번호 입니다.");
            }
        }
    });

    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

package GUI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Join extends JFrame{
   private JLabel label;
   private JCheckBox checkBox;
   private JButton button;
   
   public Join() {
      setBounds(100, 100, 700, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("회원 가입");
      getContentPane().setLayout(null);
      setLocationRelativeTo(null);
      
      label = new JLabel("회원 이름 : ");
      label.setBounds(150, 100, 80, 30);
      label.setHorizontalAlignment(JLabel.CENTER);
      add(label);
      
      JTextField textfield = new JTextField();
      textfield.setBounds(250, 100, 250, 30);
      add(textfield);
      
      label = new JLabel("회원 ID : ");
      label.setBounds(150, 150, 80, 30);
      label.setHorizontalAlignment(JLabel.CENTER);
      add(label);
      
      textfield = new JTextField();
      textfield.setBounds(250, 150, 250, 30);
      add(textfield);
      
      label = new JLabel("비밀번호 : ");
      label.setBounds(150, 200, 80, 30);
      label.setHorizontalAlignment(JLabel.CENTER);
      add(label);
      
      JPasswordField passwordField = new JPasswordField();
      passwordField.setBounds(250, 200, 250, 30);
      add(passwordField);
      
      label = new JLabel("전화번호 : ");
      label.setBounds(150, 250, 80, 30);
      label.setHorizontalAlignment(JLabel.CENTER);
      add(label);
      
      textfield = new JTextField();
      textfield.setBounds(250, 250, 250, 30);
      add(textfield);
      
      label = new JLabel("면허증 여부 ");
      label.setBounds(300, 300, 80, 30);
      label.setHorizontalAlignment(JLabel.CENTER);
      add(label);
      
      checkBox = new JCheckBox();
        checkBox.setBounds(380, 300, 250, 30);
        add(checkBox);
        
        button = new JButton("회원가입");
        button.setBounds(350, 400, 90, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(button);
        
        button = new JButton("취소");
        button.setBounds(260, 400, 60, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(button);
      
   }
   
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
            	Join window = new Join();
               window.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
}
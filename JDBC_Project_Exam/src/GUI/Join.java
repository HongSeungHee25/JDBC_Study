package GUI;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.CustomerDAO;
import DTO.Customer;

@SuppressWarnings("serial")
public class Join extends JFrame {
    private JLabel label;
    private JCheckBox licenseCheckBox; // 수정: licenseCheckBox 변수 선언
    private JTextField nameTextField;
    private JTextField idTextField;
    private JPasswordField passwordField;
    private JTextField phoneTextField;
    private JButton joinbutton;
    private JButton cancelButton;

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

        nameTextField = new JTextField();
        nameTextField.setBounds(250, 100, 250, 30);
        add(nameTextField);

        label = new JLabel("회원 ID : ");
        label.setBounds(150, 150, 80, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);

        idTextField = new JTextField();
        idTextField.setBounds(250, 150, 250, 30);
        add(idTextField);

        label = new JLabel("비밀번호 : ");
        label.setBounds(150, 200, 80, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 200, 250, 30);
        add(passwordField);

        label = new JLabel("전화번호 : ");
        label.setBounds(150, 250, 80, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(250, 250, 250, 30);
        add(phoneTextField);

        label = new JLabel("면허증 여부 ");
        label.setBounds(300, 300, 80, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);

        licenseCheckBox = new JCheckBox(); // 수정: licenseCheckBox 초기화
        licenseCheckBox.setBounds(380, 300, 250, 30);
        add(licenseCheckBox);

        joinbutton = new JButton("회원가입");
        joinbutton.setBounds(350, 400, 90, 30);
        joinbutton.setHorizontalAlignment(JLabel.CENTER);
        add(joinbutton);

        cancelButton = new JButton("취소");
        cancelButton.setBounds(260, 400, 60, 30);
        cancelButton.setHorizontalAlignment(JLabel.CENTER);
        add(cancelButton);

     // Modify the "회원가입" button ActionListener as follows:
        joinbutton.addActionListener(e -> {
            // Check if any input field is empty
            if (nameTextField.getText().isEmpty()
                    || idTextField.getText().isEmpty()
                    || new String(passwordField.getPassword()).isEmpty()
                    || phoneTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "회원 가입 정보를 모두 입력해야 합니다.");
            } else if (!licenseCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "면허증을 체크해야 회원 가입이 가능합니다.");
            } else {
                Customer customer = join(); // Get the customer details

                if (customer != null) {
                    try {
                        if (CustomerDAO.getCustomerDAO().join(customer)) {
                            JOptionPane.showMessageDialog(null, "회원 가입 성공!");
                            dispose(); // Close the Join window
                        } else {
                            JOptionPane.showMessageDialog(null, "회원 가입 실패!");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "회원 가입 실패!");
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "회원 가입 실패!");
                }
            }
        });

        // Modify the "취소" button ActionListener as follows:
        cancelButton.addActionListener(e -> {
            dispose(); // Close the Join window
        });
    }
    public Customer join() {
        // Get the details entered by the user and create a Customer object
        String name = nameTextField.getText();
        String id = idTextField.getText();
        String password = new String(passwordField.getPassword());
        String phone = phoneTextField.getText();
        String license = licenseCheckBox.isSelected() ? "Y" : "N";

        // Validate the input (optional): Check if the input values are valid as per your requirements

        return Customer.builder()
                .name(name)
                .customer_id(id)
                .pw(password)
                .phone(phone)
                .licence(license)
                .build();
    }


}

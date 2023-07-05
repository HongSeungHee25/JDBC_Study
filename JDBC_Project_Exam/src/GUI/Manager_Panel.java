package GUI;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import DAO.ManagerDAO;
import DTO.Month_total;
import DTO.Payment;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("serial")
public class Manager_Panel extends JFrame {

    String[] customer = { "순서", "회원 이름", "결제한 날짜", "결제 금액", "결제 방법", "차량 번호" };
    DefaultTableModel dm;
    JTable jt;
    String[] price = { "날짜", "결제 방법", "금액" };

    public Manager_Panel() throws SQLException {

        dm = new DefaultTableModel(null, price);
        jt = new JTable(dm);

        Container ctn = getContentPane();
        JScrollPane jsp = new JScrollPane(jt);

        JLabel la1 = new JLabel("검색 내용");
        la1.setBounds(10, 10, 100, 30);

        JTextField jtf1 = new JTextField(); // 텍스트 입력
        jtf1.setBounds(120, 10, 200, 30); // 텍스트 입력창 크기

        String[] temp = { "날짜", "결제 방법", "금액" };
        JComboBox<String> jc = new JComboBox<>(temp); // 선택항목
        jc.setBounds(330, 10, 100, 30); // 선택항목 크기

        JButton btn = new JButton("검  색"); // 상품 검색 버튼
        btn.setBounds(440, 10, 100, 30); // 상품 검색 버튼 크기

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String find = jtf1.getText();
                String selectedOption = (String) jc.getSelectedItem();
                searchAndDisplayData(find, selectedOption);
            }

        });
        jsp.setBounds(10, 60, 550, 500);
        dm = new DefaultTableModel(null, customer);
        jt = new JTable(dm);

        Container ctn1 = getContentPane();
        JScrollPane jsp1 = new JScrollPane(jt);

        JLabel la2 = new JLabel("검색 내용");
        la2.setBounds(10, 10, 100, 30);

        JTextField jtf2 = new JTextField(); // 텍스트 입력
        jtf2.setBounds(120, 10, 200, 30); // 텍스트 입력창 크기

        String[] temp1 = { "순서", "회원 이름", "결제한 날짜", "결제 금액", "결제 방법", "차량 번호" };
        JComboBox<String> jc1 = new JComboBox<>(temp1); // 선택항목
        jc1.setBounds(330, 10, 100, 30); // 선택항목 크기

        JButton btn1 = new JButton("검  색"); // 검색 버튼
        btn1.setBounds(440, 10, 100, 30); // 검색 버튼 크기

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String find = jtf2.getText();
                String selectedOption = (String) jc1.getSelectedItem();
                displayAllData_c(find, selectedOption);
            }

        });
        jsp1.setBounds(10, 60, 550, 500);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        setTitle("관리자 모드");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 800);

        UIManager.put("TabbedPane.tabAreaInsets", new Dimension(0, 300));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        tabbedPane.addTab("회원 별 매출", panel1);
        panel1.setLayout(new BorderLayout());
        panel1.setLayout(null);
        panel1.add(la2);
        panel1.add(jtf2);
        panel1.add(jc1);
        panel1.add(btn1);
        ctn1.add(tabbedPane);
        panel1.add(jsp1, BorderLayout.CENTER);
        displayAllData1();
        
        

        tabbedPane.addTab("예약 상태 조회", panel2);

        ///////////////////////////////////
        tabbedPane.addTab("월별 토탈", panel3);
        panel3.setLayout(new BorderLayout());

        panel3.setLayout(null);
        panel3.add(la1);
        panel3.add(jtf1);
        panel3.add(jc);
        panel3.add(btn);
        ctn.add(tabbedPane);
        panel3.add(jsp, BorderLayout.CENTER);
        
        // 초기 데이터 표시
        displayAllData();
        ///////////////////////////////////////
        tabbedPane.addTab("월별 결제 방법", panel4);

        setResizable(false);
        setVisible(true);

        
    }
    
    //회원 별 매출 데이터 보여주기
    public void displayAllData1() {
    	try {
			List<Payment> pay = ManagerDAO.getManagerDAO().sales();
			dm.setRowCount(0);
			
			for (Payment payment : pay) {
				String[] data = new String[6];
				data[0] = String.valueOf(payment.getPayment_id());
				data[1] = payment.getName();
				data[2] = payment.getPayment_day();
				data[3] = String.valueOf(payment.getMoney());
				data[4] = payment.getPayment_method();
				data[5] = payment.getCar_no();
				dm.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    //월 별 매출 데이터 보여주기
    public void displayAllData() {
        try {
            List<Month_total> monthTotalList = ManagerDAO.getManagerDAO().month_total();
            dm.setRowCount(0); // 기존 테이블 데이터 초기화

            for (Month_total mt : monthTotalList) {
                String[] rowData = new String[3];
                rowData[0] = mt.getMonths();
                rowData[1] = mt.getPayment_method();
                rowData[2] = String.valueOf(mt.getTotal());
                dm.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //회원 검색해서 보기
    public void displayAllData_c(String find, String selectedOption) {
    	try {
			List<Payment> pay = ManagerDAO.getManagerDAO().sales();
			dm.setRowCount(0);
			
			for (Payment payment : pay) {
				String[] data = new String[6];
				data[0] = String.valueOf(payment.getPayment_id());
				data[1] = payment.getName();
				data[2] = payment.getPayment_day();
				data[3] = String.valueOf(payment.getMoney());
				data[4] = payment.getPayment_method();
				data[5] = payment.getCar_no();
				dm.addRow(data);
				
				if(selectedOption.equals("순서") && data[0].contains(find)){
					dm.addRow(data);
				}else if(selectedOption.equals("회원 이름") && data[1].contains(find)){
					dm.addRow(data);
				}else if(selectedOption.equals("결제 날짜") && data[2].contains(find)){
					dm.addRow(data);
				}else if(selectedOption.equals("결제 금액") && data[3].contains(find)){
					dm.addRow(data);
				}else if(selectedOption.equals("결제 방법") && data[4].contains(find)){
					dm.addRow(data);
				}else if(selectedOption.equals("차량 번호") && data[5].contains(find)){
					dm.addRow(data);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    
    //검색해서 보기
    public void searchAndDisplayData(String find, String selectedOption) {
        try {
            List<Month_total> monthTotalList = ManagerDAO.getManagerDAO().month_total();
            dm.setRowCount(0); // 기존 테이블 데이터 초기화

            for (Month_total mt : monthTotalList) {
                String[] rowData = new String[3];
                rowData[0] = mt.getMonths();
                rowData[1] = mt.getPayment_method();
                rowData[2] = String.valueOf(mt.getTotal());

                if (selectedOption.equals("날짜") && rowData[0].contains(find)) {
                    dm.addRow(rowData);
                } else if (selectedOption.equals("결제 방법") && rowData[1].contains(find)) {
                    dm.addRow(rowData);
                } else if (selectedOption.equals("금액") && rowData[2].contains(find)) {
                    dm.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        new Manager_Panel();
    }
}

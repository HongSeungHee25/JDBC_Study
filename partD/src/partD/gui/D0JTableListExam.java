package partD.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import partD.day4.JProductDAO;
import partD.day4.JProductDTO;

@SuppressWarnings("serial")
public class D0JTableListExam extends JFrame{
	DefaultTableModel dm;
	JTable jt;
	String[] cols = {"상품코드","카테고리","상품이름","상품가격"};
	
	public D0JTableListExam() throws SQLException{
		List<JProductDTO> list = new JProductDAO().selectAll();
		String find = "";
		
		dm = new DefaultTableModel(null,cols);	// cols = 테이블 제목
		jt = new JTable(dm);
		
		String[] data = new String[4];
		
		for (int i = 0; i < list.size(); i++) {
			JProductDTO temp = list.get(i);
			boolean flag;
			if(find.equals("")) flag = true;
			else
				flag = temp.getPname().equals(find);
			if(flag) {
				data[0] = temp.getPcode();
				data[1] = temp.getCategory();
				data[2] = temp.getPname();
				data[3] = String.valueOf(temp.getPrice());
				dm.addRow(data);
			}
		}
		
		Container ctn = getContentPane();
		JScrollPane jsp = new JScrollPane(jt);
		
		JLabel la1 = new JLabel("검색 내용");		
		la1.setBounds(10, 10, 100, 30);
		
		JTextField jtf1 = new JTextField();		//텍스트 입력
		jtf1.setBounds(120, 10, 200, 30);		//텍스트 입력창 크기
		
		String[] temp = {"상품코드","카테고리","상품이름"};
		JComboBox<String> jc = new JComboBox<>(temp);	//선택항목
		jc.setBounds(330,10,100,30);					//선택항목 크기
		
		JButton btn = new JButton("상품 검색");			//상품 검색 버튼
		btn.setBounds(440, 10, 100, 30);				//상품 검색 버튼 크기
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dm = new DefaultTableModel(null, cols);
				jt.setModel(dm);
				for(int k=dm.getRowCount()-1;k>=0;k--)
					dm.removeRow(k);
				
				String find = jtf1.getText();
				
				for(int i=0;i<list.size();i++) {
					JProductDTO temp = list.get(i);
					boolean flag;
					if(find.equals("")) flag = true;
					else {
						if(jc.getSelectedIndex()==0)
						flag = temp.getPcode().equals(find);
						if(jc.getSelectedIndex()==1)
						flag = temp.getCategory().equals(find);
						else
						flag = temp.getPname().equals(find);
					}
					
					if(flag) {
						data[0] = temp.getPcode();
						data[1] = temp.getCategory();
						data[2] = temp.getPname();
						data[3] = String.valueOf(temp.getPrice());
						dm.addRow(data);
					}
					
				}
			}
		});
		jsp.setBounds(10, 60, 550, 500);
		
		ctn.setLayout(null);
		ctn.add(btn);
		ctn.add(la1);
		ctn.add(jtf1);
		ctn.add(jc);
		ctn.add(jsp);
		
		setBounds(500,50,600,600);
		setTitle("Product List");
		setVisible(true);
	}
	
	public static void main(String[] args) throws SQLException{
		new D0JTableListExam();
	}
	
	
	
}

package partD.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import partD.day5.MoneyDAO;
import partD.day5.MoneyDTO;

@SuppressWarnings("serial")
public class D3JTableListEx extends JFrame{
	DefaultTableModel dm;
	JTable jt;
	String[] cols = {"회원 번호","회원 성명","등급","매출 금액"};
	
	public D3JTableListEx() throws SQLException{
		
		List<MoneyDTO> list = MoneyDAO.getSalesByAmountDesc();
		String find = "";
		
		//테이블 컴포넌트 생성 : DefaultTableModel 객체 생성 후 JTable 생성자 인자로 전달
				dm = new DefaultTableModel(null, cols);   //cols는 테이블 제목. 배열로 전달.
				jt = new JTable(dm);
				
				String[] data = new String[4];
				
				//list 에 저장된 데이터를 테이블 행으로 추가하기 - 검색기능 관련된 flag 변수는 참고하세요
				//							┗> 데이터는 배열로 전달해야 합니다.
				DecimalFormat df = new DecimalFormat("###,###,###");		//정수 세자리마다, 출력하는 패턴
				for(int i=0;i<list.size();i++) {
					MoneyDTO temp = list.get(i);
					boolean flag;
					if(find.equals("")) flag =true;
					else
						flag = temp.getCustname().equals(find);
					
					if(flag) {
						//String.valueOf(인자) : 인자가 기본형 타입만 가능. 기본형 타입 데이터를 문자열로 변환
						//								┗> boolean, char, short, int, long, float, double
						//toString() 메소드는 객체를 대표하는 문자열. 대부분은 재정의를 해서 사용.
						data[0] = String.valueOf(temp.getCustno());			//Word 객체의 영어를 배열로 저장
						data[1] = temp.getCustname();						//Word 객체의 한글을 배열로 저장
						data[2] = temp.getGrade();							//Word 객체의 레벨을 배열로 저장
						data[3] = df.format(temp.getPrice());				//Word 객체의 날짜를 배열로 저장
						dm.addRow(data);									//테이블 모델 객체의 배열 추가 	
					}
				}
			
				//Container 는 프레임안에서 다른 컴포넌트들을 그룹화 역할
				// 			  다른 Pane 객체들도 포함 할 수 있습ㅈ니다.
				// 			  여기서는 JScrollPane 을 포함하는데 , 이것은 스크롤 표시하는 역할의 Pane 입니다.
				//			  단순 컴포넌트가 아닌 특정한 기능을 갖는 Pane 들이 있습니다.
				Container ctn = getContentPane();   
				JScrollPane jsp = new JScrollPane(jt);  
				//JScrollPane 에 테이블을 담아서 테이블에 내용이 많아지면 스트롤을 표시합니다.

				JLabel la1 = new JLabel("검색할 고객");
				la1.setBounds(10,10,100,30);

				JTextField jtf1 = new JTextField();
				jtf1.setBounds(120,10,200,30);
				
				String[] temp = {"회원 번호","회원 성명","등급"};
				JComboBox<String> jc = new JComboBox<>(temp);
				jc.setBounds(330, 10, 100, 30);
				
				JButton btn = new JButton("고객 검색");
				btn.setBounds(440, 10, 100, 30);
				
				//ActionListener 설정하는 두번째 다른 형태
				//implements 하지 않고 익명 클래스(익명 구현체)
				btn.addActionListener(new ActionListener() {   
					//ActionListener 익명 구현 클래스 - 필요한 재정의 메소드를 구현
					
					@Override   
					public void actionPerformed(ActionEvent e) {
						dm = new DefaultTableModel(null, cols);
						jt.setModel(dm);
						for(int k=dm.getRowCount()-1;k>=0;k--)    
							//테이블에서 기존 데이터 삭제 -> 마지막 행부터 삭제 
							dm.removeRow(k);
						
						String find = jtf1.getText();
						
						for(int i=0;i<list.size();i++) {           		//새로운 결과데이터 추가 보여주기
							MoneyDTO temp = list.get(i);
							boolean flag;
							if(find.equals("")) flag =true;		   		//검색단어 입력내용 없으면 flag 참(전체내용 출력)
							else { 
								if(jc.getSelectedIndex() == 0)	   		//검색 기준 영어일때 각각 equals 실행
								flag = String.valueOf(temp.getCustno()).equals(find);
								if(jc.getSelectedIndex() == 1)									//검색 기준 한글일때 각각 equals 실행
								flag = temp.getCustname().equals(find);
								else 
								flag = temp.getGrade().equals(find);
							}
							
							if(flag) {
								data[0] = String.valueOf(temp.getCustno());							//Word 객체의 영어를 배열로 저장
								data[1] = temp.getCustname();						//Word 객체의 한글을 배열로 저장
								data[2] = temp.getGrade();							//Word 객체의 레벨을 배열로 저장
								data[3] = String.valueOf(temp.getPrice());
								dm.addRow(data);
							}
						}
						
					}
				});
				
				//JScrollPane 객체의 좌표(컨테이너 기준)와 크기
				jsp.setBounds(10, 60, 550, 500);
				
				//컨테이너에 담기는 컴포넌트들 
				ctn.setLayout(null);
				ctn.add(btn);
				ctn.add(la1); 
				ctn.add(jtf1);
				ctn.add(jc);
				ctn.add(jsp);			//JScrollPane 도 (최상위) 컨테이너 ctn 에 담기기
				
				pack();
					
				setBounds(500,50,600,600);		//프레임의 속성들 설정. 프레임의 좌표는 화면 기준
				setTitle("WordBook List");
				setVisible(true);
				
			}
			
			
			public static void main(String[] args) throws SQLException {
				new D3JTableListEx();
			}
		}

package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//oo고등학교 성적처리 관리 시스템입니다. 학생을 등록(입력) 하는 기능을 만드는 프로그램 
public class HighSchoolGradeManagementSystem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//입력용 변수
		int studentNo = 0;			//학번
		String studentName = ""; 	//이름
		int day = 0;				//생년월일
		String address = "";		//주소
		int recordMidterm = 0;		//중간고사 점수
		int recordfinal = 0;		//기말고사 점수
		
		double avg = 0;				//평균 점수
		
		int choice = 0;				//메뉴선택
		
		
		//드라이버 연결용 변수
		String url = "jdbc:oracle:thin:@localhost:1521:xe";		//데이터베이스 URL
		String user = "exam";									//데이터베이스 ID
		String password = "1234";								//데이터베이스 비밀번호
		
		try(
				Connection conn = DriverManager.getConnection(url,user,password);
				){
			
		while(true) {
			System.out.println("━".repeat(20)+" 학생 정보관리 시스템 입니다. "+"━".repeat(20));
			System.out.println("1.학생 정보 등록 | 2.학생 정보 열람 | 3.종료");
			choice = Integer.parseInt(sc.nextLine());
		
			if(choice == 1) {
				System.out.println("━".repeat(20)+" 학생 등록 메뉴 입니다."+"━".repeat(20));
				while(true) {
					String sql = "insert into tbl_student values(?,?,?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(sql);
					
					System.out.println("[학생번호 입력시 0000 입력은 종료입니다.]");
					System.out.print("학번을 입력해주세요(4자리) ▶▶ ");
					studentNo = Integer.parseInt(sc.nextLine());
					if(studentNo == 0000) break;	//0000 입력 시 종료
					System.out.print("이름을 입력해주세요 ▶▶ ");
					studentName = sc.nextLine();
					System.out.print("생년월일을 입력해주세요(8자리) ▶▶ ");
					day = Integer.parseInt(sc.nextLine());
					System.out.print("주소를 입력해주세요 ▶▶ ");
					address = sc.nextLine();
					System.out.print("중간고사 점수를 입력해주세요 ▶▶ ");
					recordMidterm = Integer.parseInt(sc.nextLine());
					System.out.print("기말고사 점수를 입력해주세요 ▶▶ ");
					recordfinal = Integer.parseInt(sc.nextLine());
			
					 avg = (recordMidterm + recordfinal) / 2.0;
					
					//insert 하기
					pst.setInt(1, studentNo);
					pst.setString(2, studentName);
					pst.setInt(3, day);
					pst.setString(4, address);
					pst.setInt(5, recordMidterm);
					pst.setInt(6, recordfinal);
					pst.setDouble(7, avg);
					
					//PreparedStatement 객체로 execute 하면 SQL이 실행됩니다.
					pst.execute();
					
					System.out.println(studentName+" 학생의 정보가 정상적으로 등록되었습니다.");
				}//choice 1 while end
			}//choice 1 if end
			if(choice == 2) {
				String sql2 = "select * from tbl_student";
				
				Statement st = conn.createStatement();
				
				ResultSet rs = st.executeQuery(sql2);
				
				System.out.println("━".repeat(20)+" 학생 정보 및 성적 열람 메뉴 입니다."+"━".repeat(20));
					
				while(rs.next()) {
					System.out.print("학번 : "+rs.getInt(1)+"\t");
					System.out.print("이름 : "+rs.getString(2)+"\t");
					System.out.print("생년월일 : "+rs.getInt(3)+"\t");
					System.out.print("주소 : "+rs.getString(4)+"\t\n");
					System.out.print("중간고사 점수 : "+rs.getInt(5)+"\t     ");
					System.out.print("기말고사 점수 : "+rs.getInt(6)+"\t   ");
					System.out.print("한 학기 평균 점수 : " + rs.getDouble(7) + "\t\n");
					System.out.println("━".repeat(69));
				}//choice 2 while end
			}//choice 2 if end
			if(choice == 3) break;
		}//while end
		System.out.println("━".repeat(20)+" 학생 등록 메뉴를 종료합니다."+"━".repeat(20));
		}//try end
		catch(Exception e) {
			System.err.println("오류 메시지 : "+e.getMessage());
		}//catch end
	}//main end
}//class end

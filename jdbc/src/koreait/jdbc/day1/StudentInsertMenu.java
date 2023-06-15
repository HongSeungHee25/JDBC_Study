package koreait.jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Statement;

public class StudentInsertMenu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//입력용 변수
		int stuno = 0;			//학번
		String name = "";		//이름
		int age = 0;			//나이
		String  address = "";	//주소
		int choice = 0;			//메뉴선택
		
		//드라이버 연결용 변수
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "iclass";
		String password = "0419";
		
		
		
		try (//try with resources 형식
				Connection conn = DriverManager.getConnection(url,user,password);
				){
		while(true) {
		System.out.println("━".repeat(20)+" 학생 정보관리 시스템 입니다. "+"━".repeat(20));
		System.out.println("1.학생 등록 | 2.학생 정보 열람 | 3.종료");
		choice = Integer.parseInt(sc.nextLine());
		
		
		if(choice == 1) {
		System.out.println("━".repeat(20)+" 학생 등록 메뉴 입니다."+"━".repeat(20));
		while(true) {
			String sql = "insert into TBL_STUDENT values(?,?,?,?)";	
			PreparedStatement ppst = conn.prepareStatement(sql);
			
		System.out.println("[학생번호 입력시 0000 입력은 종료입니다.]");
		System.out.print("학번을 입력해주세요(7자리) ▶▶ ");
		stuno = Integer.parseInt(sc.nextLine());
		if(stuno == 0000) break;	//0000 입력 시 종료
		System.out.print("이름을 입력해주세요 ▶▶ ");
		name = sc.nextLine();
		System.out.print("나이를 입력해주세요 ▶▶ ");
		age = Integer.parseInt(sc.nextLine());
		System.out.print("주소를 입력해주세요 ▶▶ ");
		address = sc.nextLine();
		
		//insert 하기
		ppst.setInt(1, stuno);
		ppst.setString(2, name);
		ppst.setInt(3, age);
		ppst.setString(4, address);
		
		ppst.execute();		//PreparedStatement 객체로 execute 하면 SQL이 실행됩니다.
		
		System.out.println(name+" 학생의 정보가 등록되었습니다.");
			}//while end
		}//if end
		if(choice == 2) {
			String sql2 = "SELECT * FROM TBL_STUDENT";
			
			Statement st = conn.createStatement();
			
			ResultSet res = st.executeQuery(sql2);
			
			System.out.println("━".repeat(20)+" 학생 열람 메뉴 입니다."+"━".repeat(20));
			
			while(res.next()) {
				System.out.print("학번 : "+res.getInt(1)+"\t");
				System.out.print("이름 : "+res.getString(2)+"\t");
				System.out.print("나이 : "+res.getInt(3)+"\t");
				System.out.print("주소 : "+res.getString(4)+"\t");
				System.out.println();
			}
			
		}//if choice end
		if(choice == 3) break;
		
		}//while choice end
		System.out.println("━".repeat(20)+" 학생 등록 메뉴를 종료합니다."+"━".repeat(20));
		}catch(Exception e) {
			System.err.println("오류 메시지 : "+e.getMessage());
		}//catch end
		
		
	}//main end
	
}//main class end

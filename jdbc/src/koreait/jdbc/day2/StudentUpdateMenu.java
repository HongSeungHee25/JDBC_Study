package koreait.jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentUpdateMenu {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "iclass";
		String password = "0419";
		
		System.out.println("::::::::::::::::::::학생 정보 수정 메뉴입니다.::::::::::::::::::::");
		System.out.println(">>지정된 학번에 대해 나이와 주소를 수정할 수 있습니다.<<");
		
		try(Connection conn = DriverManager.getConnection(url,user,password);
		){
			updateStudent(conn);
		}catch(Exception e) {
			System.out.println("오류 메시지 : "+e.getMessage());
		}
	}//main end
	//반복없이 1개만 수정하게 하세요.
	private static void updateStudent(Connection connection) throws Exception{
		Scanner sc = new Scanner(System.in);
		String stuno,address,age;
		//특정 컬럼을 수정할때는 '컬럼명 = ?' 으로 컬럼명을 입력해서 작성한다.
		String sql = "update tbl_student set age = ?,address = ? where stuno = ?";
		System.out.println("학생번호 0000 입력은 수정 취소 입니다.");
		
		System.out.print("수정할 학생번호를 입력해주세요 >> ");
		stuno = sc.nextLine();
		if (stuno.equals("0000")) {
			System.out.println("학생 정보 수정(입력)을 취소합니다.");
			return;		//리턴에 값이 없을 때는 단순하게 메소드 종료로 실행됩니다.
		}
		System.out.print("수정될 나이를 입력해주세요 >> ");
		age = sc.nextLine();
		System.out.print("수정될 주소를 입력해주세요 >> ");
		address = sc.nextLine();
		
		try(
				PreparedStatement ps = connection.prepareStatement(sql);
				) { //매개변수의 순서와 형식을 확인하고 전달하는 setXXX 메소드 실행합니다.
			ps.setInt(1, Integer.parseInt(age));
			ps.setString(2, address);
			ps.setString(3, stuno);
			//ps.execute();		//insert(create), update, delete, select(read) 모두 실행 = CRUD 구현 
			int count = ps.executeUpdate();		//*리턴값은 반영된 행의 개수 -> 새로운 메소드 써보기
					//insert, update, delete 를 실행합니다.
			System.out.println("학생 정보 수정 "+count+" 건이 완료되었습니다.");
			ps.close();
		}catch(Exception e) {
			System.err.println("입력 메시지 : "+e.getMessage());
		}
		sc.close();
	}

}//main class end

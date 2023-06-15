package koreait.jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDeletemenu {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "iclass";
		String password = "0419";
		
		StudentDeletemenu del = new StudentDeletemenu();
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				){
			del.deleteStudent(conn);
		} catch (Exception e) {
			System.out.println("예외 메시지 : "+e.getMessage());
		}
	
	}//main end
	
	private static void deleteStudent(Connection connection){
		Scanner sc = new Scanner(System.in);
		String sql = "delete from tbl_student where stuno = ?";
		System.out.println("학생 번호 0000 입력은 삭제 취소 입니다.");
		System.out.print("삭제할 학생의 학번을 입력하세요 >> ");
		String stuno = sc.nextLine();
		if(stuno.equals("0000")) {
			System.out.println("학생 정보 삭제를 취소합니다.");
			sc.close();
			return;
		}
		
		try(
				PreparedStatement ps = connection.prepareStatement(sql);
				) {
			ps.setInt(1, Integer.parseInt(stuno));
			//ps.execute();
			int count = ps.executeUpdate();		//*리턴값은 반영된 행의 개수
			System.out.println("학생 정보 삭제 "+count+" 건이 완료되었습니다.");
			
		} catch (SQLException e) {
			System.out.println("학번을 잘못 입력하셨습니다.");
		}
}//deleteStudent end

}//main class end

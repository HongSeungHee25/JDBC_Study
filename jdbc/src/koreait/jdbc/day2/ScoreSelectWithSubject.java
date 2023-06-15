package koreait.jdbc.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ScoreSelectWithSubject {
// 과목명을 입력하면 해당 과목 조회하는 ScoreSelectWithSubject 클래스
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		
		Connection conn = OracleUtility.getConnection();
		
		String subject;
		
		System.out.print("조회할 과목을 입력해주세요 >> ");
		subject = sc.nextLine();
		
		System.out.println(subject+" 과목을 수강한 학생 목록");
		
		selectScoreSubject(conn,subject);
		
		OracleUtility.close(conn);
		sc.close();
	}//main end

	private static void selectScoreSubject(Connection conn, String subject) {
	
		String sql = "select a.name, s.subject, s.jumsu\r\n"
				+ "from TBL_STUDENT a left join TBL_SCORE s on a.stuno = s.stuno where s.subject = ?";
		try(
				PreparedStatement ps = conn.prepareStatement(sql);
				){
			ps.setString(1, subject);
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getInt(3)+"\t");
				System.out.println();
			}
		}catch(SQLException e) {
			System.out.println("예외 메시지 : "+e.getMessage());
		}
}
}//main class end

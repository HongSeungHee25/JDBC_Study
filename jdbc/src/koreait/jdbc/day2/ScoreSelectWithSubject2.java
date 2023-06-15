package koreait.jdbc.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ScoreSelectWithSubject2 {
// 과목명을 입력하면 해당 과목 조회하는 ScoreSelectWithSubject 클래스
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		
		Connection conn = OracleUtility.getConnection();
		
		String subject;
		
		System.out.print("조회할 과목을 입력해주세요 >> ");
		subject = sc.nextLine();
		
		System.out.println(subject+" 과목을 수강한 학생 목록");
		
		selectScoreSubject(conn,subject);
		selectCount(conn, subject);
		OracleUtility.close(conn);
		sc.close();
	}//main end

	//굳이 이 메서드를 만들 필요는 없음
	private static void selectCount(Connection conn,String subject) {
		String sql = "select count(*) \r\n"
				+ "from TBL_SCORE where subject = ?";
		//★★★1. count 와 같은 함수 결과는 항상 행 1개 ,컬럼 1개
		try(
				PreparedStatement ps = conn.prepareStatement(sql);
				){
			ps.setString(1, subject);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			if(rs.next()) {		//★★★1. 다른 조회문과 다르게 if 문 안써도 됩니다. rs.next() 만 단독으로 사용 가능
				count = rs.getInt(1);
			}
			//참고 : 입력한 과목의 건(행) 수를 조회할수 있습니다.
			System.out.println("과목 << "+subject+" >> "+count+" 건이 조회 되었습니다.");
		}catch(SQLException e) {
			System.out.println("예외 메시지 : "+e.getMessage());
		}
	}

	private static void selectScoreSubject(Connection conn, String subject) {
	
		String sql = "select stuno, jumsu, term, teacher \r\n"
				+ "from TBL_SCORE where subject = ?";
		//★★★2. 조건절에 사용하는 컬럼이 기본키와 유니크 일 때는 0 또는 1 개 행이 조회되고		-> rs.next() 를 if 에 사용
		//							기본키와 유니크가 아닐때는 0~N 개 행이 조회됩니다.		-> rs.next() 를 while 에 사용
		try(	
				PreparedStatement ps = conn.prepareStatement(sql);
				){
			ps.setString(1, subject);
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(String.format("%10s %10d %10s %10s",
						rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
			}
			//참고 : 입력한 과목의 건(행) 수를 조회할수 있습니다.
			System.out.println("총 조회된 수 : "+ps.executeUpdate()+" 건 입니다.");
			//sql = "select count(*) from tbl_score where subject = ?";
		}catch(SQLException e) {
			System.out.println("예외 메시지 : "+e.getMessage());
		}
}
}//main class end

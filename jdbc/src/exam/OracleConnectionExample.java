package exam;

import java.sql.*;

public class OracleConnectionExample {

	public static void main(String[] args) {
		//JDBC 연결에 필요한 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 URL 
		String user = "iclass"; 							// 데이터베이스 사용자명
		String password = "0419";							// 데이터베이스 비밀번호
		
		Connection conn = null;
		
		try {
			//JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//데이터베이스 연결
			conn = DriverManager.getConnection(url,user,password);
			
			//연결 성공 메시지 출력
			System.out.println("데이터베이스에 정상적으로 연결되었습니다.");
			
		}catch(ClassNotFoundException e) {
			System.err.println("JDBC 드라이버를 찾을 수 없습니다." );
			e.printStackTrace();
		}catch(SQLException e) {
			System.err.println("데이터베이스 연결 실패 : "+e.getMessage());
			e.printStackTrace();
		}finally {
			//데이터베이스 연결 종료
			if(conn != null) {
				try {
					conn.close();
					System.out.println("데이터베이스 연결이 종료되었습니다.");
				}catch(SQLException e) {
					System.err.println("데이터베이스 연결 종료 실패 : "+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
		
	}

}

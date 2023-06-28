package partD.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//select 부터는 지금 만든 유틸리티 클래스로 Connection 만들어줍니다.
public class OracleUtility {	//Connection 생성하여 제공해주고, 리소스 해제 메소드를 작성.
	
	public static Connection getConnection() { 
		Connection conn = null;         
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "iclass";
		String password = "0419";
		
		try {
			//Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 및 사용에 문제가 생겼습니다. : "+ e.getMessage());
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
				System.out.println("연결 종료!");
			}else {
				System.out.println("Connection 이 null 입니다.");
			}
		}catch(SQLException e) {
			System.out.println("데이터베이스 연결 종료 오류 : "+e.getMessage());
		}
	}
	
	
}//main class end

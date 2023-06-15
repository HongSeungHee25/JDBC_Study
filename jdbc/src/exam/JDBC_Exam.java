package exam;

import java.sql.*;

public class JDBC_Exam {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";		
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "iclass";
	private static final String password = "0419";
	
	public static void main(String[] args) {
		
		Connection conn;
		Statement stmt;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("Connection 생성 성공");
			
			stmt = conn.createStatement();
			System.out.println("Statement 객체 생성 성공");
			
			String sql = "insert into tbl_student values('1020304','차범근',18,'서초')";
			System.out.println(sql);
			
			stmt.executeUpdate(sql);
			
			String sql2 = "select * from tbl_student";
			System.out.println(sql2);
			
			while(rs.next()) {
				System.out.println("학번 >> "+rs.getInt("stuno"));
				System.out.println("이름 >> "+rs.getString("name"));
				System.out.println("나이 >> "+rs.getInt("age"));
				System.out.println("주소 >> "+rs.getInt("address"));
				System.out.println();
			}
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외 : "+e.getMessage());
		}
		
		
		
		
		
		
	}//main end
}//class end

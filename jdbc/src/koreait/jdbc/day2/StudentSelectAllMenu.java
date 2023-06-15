package koreait.jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentSelectAllMenu {

	public static void main(String[] args) {

		Connection conn = OracleUtility.getConnection();
		System.out.println("::::::::::::: 모든 학생 조회 :::::::::::::");
		
		selectAllMenu(conn);
		
		OracleUtility.close(conn);
		
	}//main end

	private static void selectAllMenu(Connection conn) {
		String sql = "select * from tbl_student";
		
		try(
				PreparedStatement ps = conn.prepareStatement(sql);
				){
			ResultSet rs = ps.executeQuery();
			
			//출력문을 담을 객체 선언
//			StringBuilder result = new StringBuilder();
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getInt(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.println();
//				result.append(rs.getInt(1)+"\t").append(rs.getString(2)+"\t").append(rs.getInt(3)+"\t").append(rs.getString(4));
//				System.out.println(result);
			}
			System.out.println("모든 학생 조회 완료");
		}catch(SQLException e) {
			System.out.println("예외 메시지 : "+e.getMessage());
		}
		
		
	}
}//main class end

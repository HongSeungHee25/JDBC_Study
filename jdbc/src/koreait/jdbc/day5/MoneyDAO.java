package koreait.jdbc.day5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import koreait.jdbc.day2.OracleUtility;

public class MoneyDAO {

	//회원 매출조회
	//회원번호, 회원이름, 고객등급, 매출
	
	//1) 회원번호 입력받아서 회원번호에 맞는 매출 조회하기
	public int history(int no)throws SQLException{
		
		Connection connection = OracleUtility.getConnection();
		
		String sql = "SELECT b.custno, a.custname, a.grade, SUM(b.amount * b.price) AS total\r\n"
				+ "FROM money_tbl_02 b\r\n"
				+ "JOIN member_tbl_02 a ON a.custno = b.custno\r\n"
				+ "WHERE b.custno = ?\r\n"
				+ "GROUP BY b.custno, a.custname, a.grade";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, no);
		ps.execute();
		
		ResultSet rs = ps.executeQuery();
		int count = 0;
		
		while(rs.next()) {
			System.out.println(String.format("▶ 회원번호 : %-10d \t ┃ \t회원이름 : %-10s \t ┃ \t회원등급 : %-5s \t ┃ \t매출 : %-5d", 
					rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4))+" ◀");
		count++;
		}
		return count;
	}//history end
	
	public int historyAll() throws SQLException{
		Connection connection = OracleUtility.getConnection();
		
		String sql = "SELECT b.custno, a.custname, a.grade, SUM(b.amount * b.price) AS total\r\n"
				+ "FROM money_tbl_02 b\r\n"
				+ "JOIN member_tbl_02 a ON a.custno = b.custno\r\n"
				+ "GROUP BY b.custno, a.custname, a.grade";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		int count = 0;
		
		while(rs.next()) {
			System.out.println(String.format("▶ 회원번호 : %-10d \t ┃ \t회원이름 : %-5s \t ┃ \t회원등급 : %-5s \t ┃ \t매출 : %-5d", 
					rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4))+" ◀");
			count++;
		}
		return count;
		
	}//historyAll end
	
	 public static List<MoneyDTO> getSalesByAmountDesc(Connection conn) throws SQLException {
	        List<MoneyDTO> salesList = new ArrayList<>();

	        String sql = "SELECT a.custno 회원번호, a.custname 회원성명,\r\n"
	              + "CASE \r\n"
	              + "   WHEN grade = 'A' THEN 'VIP'\r\n"
	              + "   WHEN grade = 'B' THEN '일반'\r\n"
	              + "   WHEN grade = 'C' THEN '직원'\r\n"
	              + "END AS 고객등급,\r\n"
	              + "b.sales 매출\r\n"
	              + "FROM MEMBER_TBL_02 a\r\n"
	              + "JOIN \r\n"
	              + "(SELECT CUSTNO , sum(price) sales FROM MONEY_TBL_02 mt \r\n"
	              + "GROUP BY CUSTNO) b \r\n"
	              + "ON a.custno = b.custno\r\n"
	              + "ORDER BY sales DESC";
	        try (PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                int custno = rs.getInt("custno");
	                String custname = rs.getString("custname");
	                String pcode = rs.getString("pcode");
	                int price = rs.getInt("price");

	                MoneyDTO money = MoneyDTO.builder()
	                        .custno(custno)
	                        .custname(custname)
	                        .pcode(pcode)
	                        .price(price)
	                        .build();

	                salesList.add(돈);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return salesList;
	    }
	}
	
	
}//MoneyDAO

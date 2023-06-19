package koreait.jdbc.day5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import koreait.jdbc.day2.OracleUtility;

public class MoneyDAO {
	
	//싱글톤 패턴
	//객체 생성 - private static
	private static MoneyDAO dao = new MoneyDAO();
	//기본생성자
	private MoneyDAO() {}
	//객체를 리턴할 메소드 - 다른데서 불러와야되니깐 public static
	public static MoneyDAO getMoneyDAO() {
		return dao;
	}

	//회원 매출조회
	//회원번호, 회원이름, 고객등급, 매출
	
	//1) 회원번호 입력받아서 회원번호에 맞는 매출 조회하기(가격 기준)
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
	
	//2) 고객별 가격 기준 총 매출액 조회하기 
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
	
	//3) 고객별 단가 기준 총 매출액 조회하기 
	 public static List<MoneyDTO> getSalesByAmountDesc() throws SQLException {
		 Connection connection = OracleUtility.getConnection();
	        List<MoneyDTO> salesList = new ArrayList<>();

	        String sql = "select * from total_sales";
	        try (PreparedStatement ps = connection.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                int custno = rs.getInt(1);
	                String custname = rs.getString(2);
	                String grade = rs.getString(3);
	                int price = rs.getInt(4);

	                MoneyDTO money = MoneyDTO.builder()
	                        .custno(custno)
	                        .custname(custname)
	                        .grade(grade)
	                        .price(price)
	                        .build();

	                salesList.add(money);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return salesList;
	    }//getSalesByAmountDesc end
	 // 4) 회원번호 입력받아서 회원번호에 맞는 단가기준 총 매출액 조회하기
	 public List<MoneyDTO> getSalesByAmountDescOne(int custno) throws SQLException {
		 Connection connection = OracleUtility.getConnection();
		 List<MoneyDTO> list = new ArrayList<>();
	        String sql = "SELECT a.custno AS \"회원번호\", a.custname AS \"회원성명\",\r\n"
	        		+ "CASE \r\n"
	        		+ "   WHEN a.grade = 'A' THEN 'VIP'\r\n"
	        		+ "   WHEN a.grade = 'B' THEN '일반'\r\n"
	        		+ "   WHEN a.grade = 'C' THEN '직원'\r\n"
	        		+ "END AS \"고객등급\",\r\n"
	        		+ "b.sales AS \"매출\"\r\n"
	        		+ "FROM MEMBER_TBL_02 a\r\n"
	        		+ "JOIN \r\n"
	        		+ "(SELECT CUSTNO , sum(price) AS sales FROM MONEY_TBL_02 mt \r\n"
	        		+ "GROUP BY CUSTNO) b \r\n"
	        		+ "ON a.custno = b.custno\r\n"
	        		+ "WHERE a.custno = ?";
	        
		        PreparedStatement ps = connection.prepareStatement(sql);
		        		ps.setInt(1, custno);
		             ResultSet rs = ps.executeQuery();
		            		 
		       
		            while (rs.next()) {
		            	list.add(new MoneyDTO(rs.getInt("회원번호"), rs.getString("회원성명"), rs.getString("고객등급"), rs.getInt("매출")));
		            }
		        
		        connection.close();
		        ps.close();
		        rs.close();
		        return list;
	 }
	 
	}//MoneyDAO end
	
	

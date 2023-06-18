package koreait.jdbc.day4.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import koreait.jdbc.day2.OracleUtility;

public class JCustomerDAO {
	//CRUD 실행 SQL
	
	public void insert(JCustomerDTO dto){
		String customer_ID;
		String name;
		String email;
		int age;
		/////////////////////////////////////////////////////
		try(
		Scanner sc = new Scanner(System.in);
		Connection connection = OracleUtility.getConnection();
		 ){
		String sql = "insert into j_custom values (?,?,?,?,SYSDATE)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		//회원가입
		System.out.print("아이디를 입력해주세요 >> ");
		customer_ID = sc.nextLine();
		
		System.out.print("이름을 입력해주세요 >> ");
		name = sc.nextLine();
		
		System.out.print("이메일을 입력해주세요 >> ");
		email = sc.nextLine();
		
		System.out.print("나이를 입력해주세요 >> ");
		age = Integer.parseInt(sc.nextLine());
		
		ps.setString(1, customer_ID);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setInt(4, age);

		ps.execute();
		
		}catch(SQLException e) {
			System.out.println("예외 : "+e.getMessage());
		}
	}//insert end
	
	public List<JCustomerDTO> selectAll() throws SQLException{
		Connection connection = OracleUtility.getConnection();
		String sql = "select * from j_custom";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<JCustomerDTO> list = new ArrayList<>();
		
		while(rs.next()) {
			JCustomerDTO dt = new JCustomerDTO(
			rs.getString("custom_ID"),
			rs.getString("name"),
			rs.getString("email"),
			rs.getInt("age"),
			rs.getString("reg_date"));
			
			list.add(dt);
		}
		
		connection.close();
		ps.close();
		rs.close();
		
		return list;
	}//selectAll() end
	
	public void update(JCustomerDTO dto) throws SQLException{
		
		Connection connection = OracleUtility.getConnection();
		String sql = "update j_custom set email = ? where custom_ID = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, dto.getEmail());
		ps.setString(2, dto.getCustom_id());
		
		ps.execute();
		
		connection.close();
		ps.close();
		
		
	}//update end
	
	public void delete(String custom_id) throws SQLException{
		Connection connection = OracleUtility.getConnection();
		
		String sql = "delete from j_custom where custom_ID = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, custom_id);

		ps.execute();
		
		ps.close();
		connection.close();
		
	}//delete end
	
	//1. 회원 로그인 - 간단히 회원아이디를 입력해서 존재하면 로그인 성공
	public JCustomerDTO selectById(String customid) throws SQLException{
		Connection connection = OracleUtility.getConnection();
		String sql = "select * from j_custom where custom_ID = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		JCustomerDTO temp = null;
		
		ps.setString(1, customid);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			temp  =  new JCustomerDTO(rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4),
					rs.getString(5));
		}
		
		ps.close();
		connection.close();
		
		return temp;
	}//selectById end
	
	
}

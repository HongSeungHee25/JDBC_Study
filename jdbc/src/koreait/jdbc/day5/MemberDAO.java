package koreait.jdbc.day5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


import koreait.jdbc.day2.OracleUtility;

public class MemberDAO {

	//회원 등록하기
	public void insert(MemberDTO dto) {
		
		try (
				Scanner sc = new Scanner(System.in);
				Connection connection = OracleUtility.getConnection();
				){
			String sql = "insert into member_tbl_02 values (?,?,?,?,sysdate,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, dto.getCustno());
			ps.setString(2, dto.getCustname());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getAddress());
			ps.setString(5, dto.getGrade());
			ps.setString(6, dto.getCity());
			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("예외 : "+e.getMessage());
		}
	}//insert end
	
	//전체목록 조회하기
	public int select() throws SQLException{
		Connection connection = OracleUtility.getConnection();
		
		String sql = "select * from member_tbl_02";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MemberDTO> list = new ArrayList<>();
		
		while(rs.next()) {
			MemberDTO dto = new MemberDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			list.add(dto);
		}
		for (MemberDTO member : list) {
			System.out.println(member);
		}
		int count = ps.executeUpdate();
		rs.close();
		connection.close();
		ps.close();
		return count;
	}//select end
	
	//회원번호 1개 입력 받아서 회원번호에 맞는 정보 출력
	public MemberDTO selectOne(int custno) throws SQLException{
		Connection connection = OracleUtility.getConnection();
		
		String sql = "select * from member_tbl_02 where custno = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, custno);
		
		ResultSet rs = ps.executeQuery();
		
		MemberDTO dto = null;
		
		if(rs.next()) {
			String name = rs.getString("custname");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			String date = rs.getString("joindate");
			String grade = rs.getString("grade");
			String city = rs.getString("city");
			dto = new MemberDTO(custno, name, phone, address, date, grade, city);
		}
		return dto;
	}//selectOne end
	
	//수정하기
	public int update(MemberDTO member) throws SQLException{
		Connection connection = OracleUtility.getConnection();
		
		String sql = "update member_tbl_02 set custname = ?, phone = ?, address = ?, sysdate, grade = ?, city = ? where custno = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, member.getCustname());
		ps.setString(2, member.getPhone());
		ps.setString(3, member.getAddress());
		ps.setString(4, member.getGrade());
		ps.setString(5, member.getCity());
		ps.setInt(5, member.getCustno());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result;
	}//update end
	
	
	
	
	
	
	
	
	
}//MemberDAO end

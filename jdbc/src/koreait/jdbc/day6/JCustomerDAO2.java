package koreait.jdbc.day6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import koreait.jdbc.day2.OracleUtility;

public class JCustomerDAO2 {

	private static JCustomerDAO2 dao = new JCustomerDAO2();
	private JCustomerDAO2() {}
	public static JCustomerDAO2 getCustomerDAO2() {
		return dao;
	}
	public JCustomerDTO2 login(String id, String password) throws SQLException{
		Connection connection = OracleUtility.getConnection();
		String sql = "select custom_id, name from j_custom where custom_id = ? and password = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		JCustomerDTO2 result = null;
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			result = JCustomerDTO2.builder()
					.custom_id(rs.getString(1))
					.name(rs.getString(2))
					.build();
		}
		connection.close();
		ps.close();
		rs.close();
		
		return result;	//result 가 null 이 아니면 로그인 성공
	}
//LoginMain 에서 사용자에게 아이디 >>> , 패스워드 >>> 
//로그인 처리 결과 : '로그인 성공했습니다. xxx 님 환영합니다.' 또는 '입력한 계정정보가 틀립니다.' 출력
	
	public void join(JCustomerDTO2 dto)throws SQLException{
		Connection connection = OracleUtility.getConnection();
		String sql = "insert into j_custom values(?,?,?,?,sysdate,?)";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, dto.getCustom_id());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getEmail());
		ps.setInt(4, dto.getAge());
		ps.setString(5, dto.getPassword());
		
		ps.execute();
		
		connection.close();
		ps.close();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}//JCustomerDAO2 end

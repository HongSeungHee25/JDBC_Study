package koreait.jdbc.day4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import koreait.jdbc.day2.OracleUtility;

public class JProductDAO {

	//2. 상품 목록 보기
	public List<JProductDTO> selectAll() throws SQLException{
		Connection connection = OracleUtility.getConnection();
		String sql = "select * from j_product";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<JProductDTO> list = new ArrayList<>();
		while(rs.next()) {
			list.add(new JProductDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		ps.close();
		connection.close();
		return list;
	}//selectAll end
	
	//3. 상품명으로 검색하기 (그외에 가격대 별 검색)(유사검색 -> **'검색어가 포함된 상품명'**을 조회하기)
	public List<JProductDTO> selectByPname (String pname) throws SQLException{
		//pname은 사용자가 입력한 검색어
		Connection connection = OracleUtility.getConnection();
		String sql = "select * from j_product where pname like '%' || ? || '%'"; //Like는 유사 비교. % 기호 사용
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, pname);
		ResultSet rs = ps.executeQuery();
		
		List<JProductDTO> list = new ArrayList<>();
		while(rs.next()) {
			list.add(new JProductDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
		}
		ps.close();
		connection.close();
		rs.close();
		
		return list;
	}//selectByPname end
	
}

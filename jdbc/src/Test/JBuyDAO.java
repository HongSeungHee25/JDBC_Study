package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import koreait.jdbc.day2.OracleUtility;

public class JBuyDAO {	//구매와 관련된 CRUD 실행 SQL. DAO : JCustomerDao, ProductDao
//메소드 이름은 insert, update, delete, select, selectByPname 등등으로 이름을 작성하세요.

	private List<JProductDTO> productList;
	
	public void setProductList(List<JProductDTO> productList) {
        this.productList = productList;
    }
//	public List<JProductDTO> pay() throws SQLException{
//		// * 5. JProduct - 4에서 담은 List 를 JBuy에 입력
//		// * 6. JBuy - 아이디 입력하면 '해당 아이디의 구매내역 출력'
//		Connection connection = OracleUtility.getConnection();
//		String sql = "select sum(price) as total from j_product";
//		PreparedStatement ps = connection.prepareStatement(sql);
//		
//		ResultSet rs = ps.executeQuery();
//		
//		List<JProductDTO> list = new ArrayList<>();
//		
//		if(rs.next()) {
//			int total = rs.getInt("total");
//			System.out.println("총 결제할 금액 : "+total+"원 입니다.");
//		}
//		JProductDAO proDto = new JProductDAO();
//		
//		ps.execute();
//		rs.close();
//		ps.close();
//		connection.close();
//		
//		return list;
//	}
	
	public JBuyDTO selectBuyID(String customid) throws SQLException{
		Connection connection = OracleUtility.getConnection();
		String sql = "select * from j_buy where customid = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		JBuyDTO temp = null;
		
		ps.setString(1, customid);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			temp = new JBuyDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
		}
		ps.close();
		connection.close();
		rs.close();
		
		return temp;
	}
	
	
	
}

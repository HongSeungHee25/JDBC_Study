package partD.day5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

//DAO 에는 입력과 출력은 포함시키지 않습니다. 오직 어떤 형식의 데이터를 받아서
//어떤 SQL을 실행하여 , 어떤 값을 리턴할 것인가를 중점을 두고 정의하면 됩니다.
//DTO 는 데이터를 저장하기 위한 목적의 클래스 , DAO 는 어떤 동작을 할것인지를 정의한 메소드만 있습니다.
public class MemberDAO {
	//싱글톤으로 만들어 봅니다.
	
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getMemberDAO() {	//메소드 getInstance외에 내용을 알수 있는 이름으로 정하기 
		return dao;
	}

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
		
		String sql = "select custno,custname,phone,address,joindate,decode(grade,'A','VIP','B','일반','C','직원')as grade from member_tbl_02";
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
		//수정 가능한 항목(컬럼)은 모두 set에 포함시키기
		String sql = "update member_tbl_02 set custname = ?, phone = ?, address = ?, grade = ?, city = ? where custno = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, member.getCustname());
		ps.setString(2, member.getPhone());
		ps.setString(3, member.getAddress());
		ps.setString(4, member.getCity());
		ps.setInt(5, member.getCustno());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result;
	}//update end
	
	
	
	
	
	
	
	
	
}//MemberDAO end

package koreait.jdbc.day3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import koreait.jdbc.day2.OracleUtility;

//DAO : Data Access(접근-읽기와 쓰기) Object
//		└> SQL 실행 메소드를 모아 놓은 클래스.
//      └> save, read, delete

/*
- StudentDAO 의 내용을 요약.
insert, update 는 sql 파라미터에 전달한 데이터의 타입을 dto
delete는 sql 파라미터에 전달한 데이터의 타입을 원시형 또는 String
delete sql 의 조건절 컬럼이 여러개 일때는 dto 가 될 수 있습니다. map 도 종종 사용합니다.

insert, update, delete 는 정수 리턴값으로 반영된 행의 개수를 전달.

selectOne : sql 파라미터에 전달할 데이터를 메소드 인자로 함.
selectAll : 파라미터 없으며 여러개의 행을 저장할 객체는 list 타입.
*/

public class StudentDAO {
	
	//나중에 db를 '쉽게 코딩'하기 위한 '프레임워크'를 사용하면 Exception 처리 안해도 됩니다.
	
	//추가하기
	public int insert(StudentDTO student) throws SQLException{
		
		Connection connection = OracleUtility.getConnection();
		
		String sql = "insert into TBL_STUDENT values(?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, student.getStuno());
		ps.setString(2, student.getName());
		ps.setInt(3, student.getAge());
		ps.setString(4, student.getAddress());
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		return result;
	}//insert end
	
	//수정하기
	public int update(StudentDTO student) throws SQLException{
		
		Connection connection = OracleUtility.getConnection();
		
		String sql = "update TBL_STUDENT set name = ?, age = ?, address = ? where stuno = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, student.getName());
		ps.setInt(2, student.getAge());
		ps.setString(3, student.getAddress());
		//ps.setInt(4, Integer.parseInt(student.getStuno()));
		ps.setString(4, student.getStuno());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result;
	}//update end
	
	//특정 학번 삭제
	public int delete(String stuno) throws SQLException {
		
		Connection connection = OracleUtility.getConnection();
		
		String sql = "delete from tbl_student where stuno =?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, stuno);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result;
	}//delete end
	
	//전체 정보 출력
	public int printAll () throws SQLException{
		
		Connection connection = OracleUtility.getConnection();
		
		String sql = "select * from tbl_student";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		//결과를 담을 배열 생성
		ArrayList<StudentDTO> list = new ArrayList<>();
		
		while(rs.next()) {
			//객체 생성
			StudentDTO dto = new StudentDTO(rs.getString("stuno"), rs.getString("name"), rs.getInt("age"), rs.getString("address"));
			list.add(dto);
		}
		for (StudentDTO student : list) {
			System.out.println(student);
		}
		int count = ps.executeUpdate();
		rs.close();
		connection.close();
		return count;
	}//printAll end
	
	//학번 1개 main에서 입력받아서 학번에 맞는 정보 출력
	public StudentDTO selectOne(String stuno) throws SQLException{
		Connection connection = OracleUtility.getConnection();
		
		String sql = "select * from tbl_student where stuno = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, stuno);
		
		ResultSet rs = ps.executeQuery();
		
		StudentDTO dto = null;
		
		if(rs.next()) {
			String name = rs.getString("NAME");
			int age = rs.getInt("AGE");
			String address = rs.getString("ADDRESS");
			dto = new StudentDTO(stuno,name,age,address);
		// 코드 줄이면 아래와 같이 쓸수 있다.
		//	return new StudentDTO(stuno, rs.getString("NAME"),rs.getInt("AGE"),rs.getString("ADDRESS"));
			
		}
		return dto;
		
	}//selectOne end
	
	
	//select 모두 조회 - 조회 결과 값들을 list 객체로 리턴. 메소드에서 조회된 결과만을 리턴.
	//     출력 등 기타기능들은 이 메소드를 사용하는 프로그램에서 구현합니다.
	public List<StudentDTO> selectAll() throws SQLException{
		Connection connection = OracleUtility.getConnection();
		String sql = "select * from tbl_student";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		List<StudentDTO> results = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			StudentDTO dto = new StudentDTO(rs.getString("STUNO"), rs.getString("NAME"), rs.getInt("AGE"), rs.getString("ADDRESS"));
			results.add(dto);
		}
		return results;
	}//selectAll end
	

}

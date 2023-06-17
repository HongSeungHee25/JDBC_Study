package koreait.jdbc.day5.Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import koreait.jdbc.day2.OracleUtility;

public class MemberDAO {

	// 회원 등록
    public void addMember(MemberDTO member) throws SQLException {
    	Connection connection = OracleUtility.getConnection();
        String query = "INSERT INTO member_tbl_02 (custno, custname, phone, address, joindate, grade, city) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, member.getCustno());
            statement.setString(2, member.getCustname());
            statement.setString(3, member.getPhone());
            statement.setString(4, member.getAddress());
            statement.setDate(5, member.getJoindate());
            statement.setString(6, member.getGrade());
            statement.setString(7, member.getCity());

            statement.executeUpdate();
        }
    }

    // 회원 정보 조회
    public List<MemberDTO> getAllMembers() throws SQLException {
    	Connection connection = OracleUtility.getConnection();
        List<MemberDTO> members = new ArrayList<>();
        String query = "SELECT custno, custname, phone, address, joindate, grade, city FROM member_tbl_02";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int custno = resultSet.getInt("custno");
                String custname = resultSet.getString("custname");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                java.sql.Date joindate = resultSet.getDate("joindate");
                String grade = resultSet.getString("grade");
                String city = resultSet.getString("city");

                MemberDTO member = new MemberDTO(custno, custname, phone, address, joindate, grade, city);
                members.add(member);
            }
        }
        return members;
    }

    // 회원 정보 수정
    public void updateMember(MemberDTO member) throws SQLException {
    	Connection connection = OracleUtility.getConnection();
        String query = "UPDATE member_tbl_02 SET custname = ?, phone = ?, address = ?, grade = ?, city = ? " +
                "WHERE custno = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, member.getCustname());
            statement.setString(2, member.getPhone());
            statement.setString(3, member.getAddress());
            statement.setString(4, member.getGrade());
            statement.setString(5, member.getCity());
            statement.setInt(6, member.getCustno());

            statement.executeUpdate();
        }
    }
}
	
	
	


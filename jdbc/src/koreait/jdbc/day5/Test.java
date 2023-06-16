package koreait.jdbc.day5;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {

		MoneyDAO money = new MoneyDAO();
		
		try {
			
			System.out.println("회원 총 "+money.historyAll()+"명의 총 매출액입니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("━".repeat(218));
		
		MemberDAO member = new MemberDAO();
		try {
			System.out.println("회원 총 "+member.select()+"명의 정보입니다.");
			System.out.println("━".repeat(218));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

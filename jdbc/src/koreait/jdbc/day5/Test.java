package koreait.jdbc.day5;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		MoneyDAO money = MoneyDAO.getMoneyDAO();
		MemberDTO memberDto = new MemberDTO();
		MoneyDTO moneyDto = new MoneyDTO();
		
		try {
			
			System.out.println("회원 총 "+money.historyAll()+"명의 가격 기준 총 매출액입니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("━".repeat(218));
		
		MemberDAO dao = MemberDAO.getMemberDAO();
		try {
			System.out.println("회원 총 "+dao.select()+"명의 정보입니다.");
			System.out.println("━".repeat(218));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			List<MoneyDTO> mdto = MoneyDAO.getSalesByAmountDesc();
			for (MoneyDTO moneyDTO : mdto) {
				System.out.println(moneyDTO);
			}
			System.out.println("고객별 단가 기준 총 매출액입니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("━".repeat(218));
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 번호 입력 >>");
		int custno = Integer.parseInt(sc.nextLine());
		try {
			List<MoneyDTO> list = money.getSalesByAmountDescOne(custno);
			System.out.println("━".repeat(218));
			for (MoneyDTO moneyDTO : list) {
				System.out.println(String.format(String.format("▶ 회원번호 : %-10d \t ┃ \t회원이름 : %-10s \t ┃ \t고객등급 : %-10s \t ┃ \t매출 : %-5d", 
				custno,moneyDTO.getCustname(),moneyDTO.getPcode(),moneyDTO.getPrice())+" ◀"));
				System.out.println(moneyDTO.getCustname()+"("+custno+") 고객님의 총 매출액입니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

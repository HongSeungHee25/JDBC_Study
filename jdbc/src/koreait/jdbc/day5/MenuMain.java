package koreait.jdbc.day5;

import java.sql.SQLException;

public class MenuMain {

	public static void main(String[] args) {
		//우리가 만든 DAO를 정상적으로 동작하는지 확인하려면 데이터를 직접 주고
		//메소드를 호출해서 main 을 만들어야 합니다.
		//main 메소드는 '응용프로그램'을 만들기 위해서 작성하는 것으로 테스트용은 아닙니다.
		
		//특정 메소드가 잘 실행되는지 검증(테스트)하는 것을 단위테스트(unit test) 라고 합니다.
		//자바에서 기본적으로 사용한느 단위테스트 라이브러리로 JUnit 이 있습니다.
		//테스트 케이스는 테스트 메소드 또는 이것을 포함하는 클래스입니다. 테스트 케이스는 test 폴더에 작성
		//테스트 케이스는 빌드에 포함시키지 않습니다. src 폴더 : 프로덕션 코드.(빌드에 포함되는 코드)
		
		
		//하나의 DAO 클래스를 완성하기 위해 main 까지 만들지 않고도 검증하는 목적으로 사용할 수 있습니다.
		
		//싱글톤 DAO 사용하기
		MemberDAO dao = MemberDAO.getMemberDAO();
		dao.insert(null);
		
		MoneyDAO money = MoneyDAO.getMoneyDAO();
		try {
			money.historyAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}

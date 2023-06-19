package jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import koreait.jdbc.day4.JBuyDTO;
import koreait.jdbc.day4.JBuyDAO;

//테스트 케이스 입니다.
//테스트 할 메소드 앞에는 @Test 애노테이션을 작성하기.@DisplayName 는 테스트 내용 작성
//테스트 결과는 성공 또는 실패입니다. 테스트 메소드에는 대부분의 경우 리턴이 없습니다.
class BuyDAOTest {

	private JBuyDAO dao = new JBuyDAO();
	
	@DisplayName("buy 테이블에 insert 성공하면 리턴값을 1(기대값)이 되어야 합니다.")
	@Test
	void insertTest() {
		JBuyDTO buy = JBuyDTO.builder()
				.customID("hongGD")
				.pcode("")
				.qty(5).build();
		int i = dao.insert(buy);
		
		//성공 또는 실패 결과를 확인하는 테스트 메소드를 실행하기
		assertEquals(1, i);	//기대값, 실제값
							//기대값과 실제값이 같으면 성공
		
	}
	
	@DisplayName("buy 테이블에서 buy_seq 컬럼으로 조회하면 null이 아닌 DTO가 리턴한다.")
	@Test
	void selectOneTest() {
		JBuyDTO jbuy;
		try {
			jbuy = dao.selectOne(11111);
			assertNotNull(jbuy);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Disabled
	@Test
	void test() {
		fail("테스트를 비활성화 하는 연습");
	}
	//테스트 메소드 아닌 것도 정의 하여 호출할 수 있습니다.
	void print() {
		System.out.println("테스트 중입니다.");
	}
}

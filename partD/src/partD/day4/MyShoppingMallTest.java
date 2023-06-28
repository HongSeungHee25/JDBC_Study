package partD.day4;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyShoppingMallTest {

	public static void main(String[] args) {
		/*
		1. 회원 로그인 - 간단히 회원아이디를 입력해서 존재하면 로그인 성공
		2. 상품 목록 보기
		3. 상품명으로 검색하기 (그외에 가격대 별 검색)
		4. 상품 장바구니 담기 - 장바구니 테이블이 없으므로 구매를 원하는 상품을 List 에 담기
		5. 상품 구매(결제)하기 - 장바구니의 데이터를 '구매' 테이블에 입력하기 (여러개 insert)
		6. 나의 구매 내역 보기. 총 구매 금액을 출력해 주기
		*/
		
		/*
		 * 1. JCostomer	- 아이디 입력해서 해당 아이디 있을 경우 >> 로그인 성공 출력
		 * 2. JProduct - selectAll 메소드
		 * 3. JProduct - selectOne 메소드
		 * 4. *3번과 연결* JProduct 에서 검색 후 List에 담기
		 * 5. JProduct - 4에서 담은 List 를 JBuy에 입력
		 * 6. JBuy - 아이디 입력하면 '해당 아이디의 구매내역 출력'
		 */
		
		/*
		 * << 상품 구매를 위해 로그인 하기 >>
		 *	간편 로그인 - 사용자 id입력  >>   
		 *	김땡떙 고객님 환영합니다. 
         *
		 *	구매할 상품 코드 입력하세요. >>> 
		 *	구매할 수량을 입력하세요. >>>
		 *	
		 *	장바구니에 담기 합니다. 그만하려면 상품코드 0000 입력하세요.
		 *
		 *	구매할 상품 코드 입력하세요. >>> 
		 *	구매할 수량을 입력하세요. >>>
		 *
		 *	장바구니에 담기 합니다. 그만하려면 상품코드 0000 입력하세요.
		 *
		 *	장바구니에 담긴 상품을 결제하시겠습까? Y
		 *
		 *	결제를 완료했습니다. 현재까지 김땡땡 회원님의 구매 내역 입니다.
		 */
		
		Scanner sc = new Scanner(System.in);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
		JCustomerDAO cutdao = new JCustomerDAO();
		boolean isLogin = false;		//로그인 성공 여부 저장
		String id = null;
		System.out.println("::::::: 승희 쇼핑몰에 오신걸 환영합니다. :::::::");
		System.out.println("━".repeat(100));
		System.out.println("<<상품 소개>>");
		JProductDAO pdao = new JProductDAO();
		try {
		List<JProductDTO> product = pdao.selectAll();
			for(JProductDTO products : product) {
				System.out.println(products);
			}
		}catch(SQLException e) {
			System.out.println("상품소개 예외 : "+e.getMessage());
		}
		System.out.println("━".repeat(100));
		System.out.println("<< 장바구니 담기와 상품 구매를 위해 로그인 하기 >>");
		while(!isLogin) {
		System.out.print("간편 로그인 - 사용자 ID입력 >> ");
		id = sc.nextLine();
		if(id.equals("0000")) break;	//반복 종료
		try {
			JCustomerDTO cutdto = cutdao.selectById(id);
			if(id != null) {
				System.out.println(cutdto.getName()+" 고객님 환영합니다.");
				isLogin = true;
			}else
				System.out.println("존재하지 않은 ID입니다.");
		} catch (SQLException e) {
			System.out.println("간편 로그인 예외 : "+e.getMessage());
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JBuyDAO Jdao = new JBuyDAO();
		List<JBuyDTO> carts = new ArrayList<>();
		String pcode;
		if(isLogin) {
			while(true) {
					System.out.println("\n<< 편리한 상품구매를 위한 검색하기 >>");
					System.out.print("구매할 상품 코드 입력하세요.(0000 입력은 종료) >>> ");
					pcode = sc.nextLine();
						if(pcode.equals("0000")) break;
					System.out.print("구매할 수량을 입력하세요. >>> ");
						String temp = sc.nextLine();
						int qty = Integer.parseInt(temp);
					carts.add(new JBuyDTO(0, id, pcode, qty, null));
					System.out.print("장바구니에 담긴 상품을 결제하시겠습니까? (Y/N)");
					String choice = sc.nextLine();
					if(choice.toLowerCase().equals("y")) break;
		}
			System.out.println("장바구니 확인 : "+carts);
			//dao에서 carts 를 전달받아 list 만큼 반복하는 insert 실행하기
		try {
			List<JProductDTO> product = pdao.selectByPname(pcode);
				for(JProductDTO products : product) {
					System.out.println(products);
				}
			}catch(SQLException e) {
				System.out.println("상품검색 예외 : "+e.getMessage());
			}
		sc.close();
		
		
		}
	}//main end
}//main class end

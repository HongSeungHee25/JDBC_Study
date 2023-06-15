package Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySopingMall {

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
		JCustomerDTO dto = null;
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		while(run) {
			System.out.println("━".repeat(100));
			System.out.println("::::::: 승희 쇼핑몰에 오신걸 환영합니다. :::::::");
			System.out.println("━".repeat(100));
			System.out.println("1. 로그인 | 2. 회원가입");
			System.out.print("선택해주세요 >> ");
			String temp = sc.nextLine();
			int choice = Integer.parseInt(temp); 
			switch(choice) {
			case 1:
				try {
				JCustomerDAO cdao = new JCustomerDAO();
				System.out.print("아이디를 입력해주세요 >> ");
				String id = sc.nextLine();
					cdao.selectById(id);
					System.out.println("회원 아이디 "+id+"님 환영합니다.");
					System.out.println("━".repeat(100));
					System.out.println("1. 전체 상품 보기 | 2. 장바구니 | 3. 결제내역 확인하기 | 4. 종료하기");
					System.out.print("메뉴를 선택해주세요 >>");
					int choice1 = Integer.parseInt(sc.nextLine());
					switch(choice1) {
					case 1:
						System.out.println("▶▶ 전체 상품 메뉴입니다.◀◀");
						System.out.println("<< 상품 소개 >>");
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
						System.out.print("\n검색해서 보시겠습니까? (Y/N) ");
						String yn = sc.nextLine();
						if(yn.equals("y")) {
						System.out.println("<< 편리한 상품구매를 위한 검색하기 >>");
						System.out.print("검색어 입력 >>> ");
						String pname = sc.nextLine();
						try {
							List<JProductDTO> product = pdao.selectByPname(pname);
								for(JProductDTO products : product) {
									System.out.println(products);
								}
							}catch(SQLException e) {
								System.out.println("상품검색 예외 : "+e.getMessage());
							}
						}
						break;
					case 2:
						System.out.println("━".repeat(100));
						System.out.println("<< 전체 상품 >>");
						JProductDAO pdao2 = new JProductDAO();
						try {
						List<JProductDTO> products = pdao2.selectAll();
							for(JProductDTO product : products) {
								System.out.println(product);
							}
						}catch(SQLException e) {
							System.out.println("상품소개 예외 : "+e.getMessage());
						}
						while(true) {
							System.out.println("━".repeat(100));
						System.out.print("\n구매할 상품명을 입력해주세요(그만하려면 (x) 입력) >> ");
						String pname1 = sc.nextLine();
						if(pname1.equals("x")) {
							break;
						}
							try {
								System.out.println("━".repeat(100));
								System.out.println("<< 장바구니 목록 >>");
								List<JProductDTO> product = pdao2.selectByPname1(pname1);
								for(JProductDTO products : product) {
									System.out.println(products);
								}
							
								System.out.print("\n결제 하시겠습니까? (Y/N) ");
								String pay = sc.nextLine();
								if(pay.equals("y")) {
									System.out.print("결제할 금액을 입력해주세요 >> ");
									int money = Integer.parseInt(sc.nextLine());
									int totalPrice = 0;
									for(JProductDTO proDto : product) {
										totalPrice += proDto.getPrice();
									}
									int remainingmoney = money - totalPrice;
									System.out.println("남은 돈 : "+remainingmoney+"원 입니다.");
								}else {
									System.out.println("결제가 취소되었습니다.");
								}
							}catch(SQLException e) {
								System.out.println("상품검색 예외 : "+e.getMessage());
							}
						}
						break;
					case 3:
						System.out.println("━".repeat(100));
						JBuyDAO sel = new JBuyDAO();
						System.out.println(id+"님이 구매하신 목록입니다.");
						System.out.println(sel.selectBuyID(id)+"\n");
						break;
					case 4:
						run = false;
						break;
					}
				} catch (SQLException e) {
					System.out.println("로그인 오류 : "+e.getMessage());
				}
				break;
			case 2:
				try {
					JCustomerDAO jdao = new JCustomerDAO();
					System.out.println("회원가입을 시작하겠습니다.");
					jdao.insert(dto);
					System.out.println("회원가입이 완료되었습니다. 감사합니다.");
				} catch (Exception e) {
					System.out.println("회원가입 오류 : "+e.getMessage());
				}
				break;
			}//switch end
		}//while end
		
		sc.close();
		
	}//main end
}//main class end

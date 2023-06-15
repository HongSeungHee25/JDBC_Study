package koreait.jdbc.day4;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyShoppingMall {

	public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				System.out.println("★☆★☆★☆★☆★☆ 승희 쇼핑몰에 오신걸 환영합니다.★☆★☆★☆★☆★☆");
				///////////////////////////////////////////////////////////
				// 2. 상품 목록 보기
				System.out.println("\n━━━━━━━━━━━━━━━━━━━━━ 상품 소개 ━━━━━━━━━━━━━━━━━━━━━");
				JProductDAO pDao = new JProductDAO();
				try {
					List<JProductDTO> pDto = pDao.selectAll();
						for (JProductDTO product : pDto) {
							System.out.println(String.format("상품명 : %-10s \t ┃ \t가격 : %-10s원", 
									product.getPname(), product.getPrice()));
						}
				} catch (SQLException e) {
					System.out.println("상품 소개 예외 : "+e.getMessage());
				}
				System.out.println("━".repeat(51));
				///////////////////////////////////////////////////////////
				// 3. 상품명으로 검색하기 (유사검색 ▶ 검색어가 포함된 상품명을 조회하기)
				System.out.println("\n━━━━━━━━━━━━━━━━━━━ 상품 코드 검색 ━━━━━━━━━━━━━━━━━━━");
				System.out.println("⚠️ '종료' 입력시 상품 코드 검색 메뉴를 종료합니다. ▶▶ ");
				String pName;
				while(true) {
					System.out.print("\n검색어 입력 ▶▶ ");
					pName = sc.nextLine();

					if(pName.equals("종료")) {
						System.out.println("상품 코드 검색 메뉴를 종료합니다.");
						break;
					}
					try {
						List<JProductDTO> pDto = pDao.selectByPname(pName);
						for (JProductDTO product : pDto) {
							System.out.println(String.format("상품명 : %-10s \t ┃ \t상품 코드 : %-10s",
									product.getPname(),product.getPcode()));
						}
					} catch (SQLException e) {
						System.out.println("상품 검색 예외 : "+e.getMessage());
					}
				}//while end
				///////////////////////////////////////////////////////////////////////////////////////////////////
				JCustomerDAO cutdao = new JCustomerDAO();
				JCustomerDTO cutdto = new JCustomerDTO();
				boolean isLogin = false;
				String id = null;
				
				System.out.println("━".repeat(51));
				System.out.println("◆◇ 장바구니 담기와 상품 구매를 위해 로그인 하기 ◆◇");
				while(!isLogin) {
			         System.out.print("간편 로그인 - 사용자 ID입력 (로그인 취소는 0000) ▶▶ ");
			         id = sc.nextLine();
			         if(id.equals("0000")) break;
			         try {
			            cutdto = cutdao.selectById(id);
			            if(cutdto != null) {
			               System.out.println("👸🏻 "+cutdto.getName() + " 고객님 환영합니다.");
			               isLogin=true;
			            }
			         } catch (SQLException e) {
			            System.out.println("로그인 예외 : "+e.getMessage());
			         }
			      }		
		
				/////////////////////////////////////////////////////////////////////////////////////////////
				// 4. 상품 장바구니 담기 - 장바구니 테이블이 없으므로 구매를 원하는 상품을 List 에 담기
				System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━ 장바구니 ━━━━━━━━━━━━━━━━━━━━━━");
				
				String pCode;
				int qet;
				JBuyDAO buydao = new JBuyDAO();
				List<JBuyDTO> cart = new ArrayList<>();
				
				while(true) {
					System.out.println("\n◆◇ 장바구니에 담을 상품의 '상품 코드'를 입력하세요. ◆◇");
					System.out.print("⚠️ '종료' 입력시 장바구니 메뉴를 종료합니다. ▶▶ ");
					
					pCode = sc.nextLine();
					if(pCode.equals("종료")) {
						System.out.println("장바구니 메뉴를 종료합니다.");
						break;
					}
					
					System.out.print("\""+pCode+"\" 상품 몇개 담으시겠습니까? ▶▶ ");
					qet = Integer.parseInt(sc.nextLine());
					
					cart.add(new JBuyDTO(0,id, pCode, qet, null));
					
				
		            }//while end
				//구매내역(buy 테이블) 보여주기
				
				//장바구니 확인
				if(cart.size()>0) {
					System.out.println("\n장바구니 목록은 다음과 같습니다.");
					for (JBuyDTO list : cart) {
						System.out.println(String.format("상품코드 : %-5s \t ┃ \t수량 : %-5d개",list.getPcode(),list.getQty()));
					}
				
				//buy 테이블에 입력(insert)
					//BuyDAO 에 메소드 생성
				System.out.print("장바구니에 담긴 상품을 결제하시겠습니까? (y/Y)");
	               if(sc.nextLine().toLowerCase().equals("y")) {
	               
				try {
					buydao.credit(cart);
					System.out.println("구매를 완료했습니다.");
					System.out.println("━".repeat(51));
					System.out.println("\n현재까지 👸🏻 "+cutdto.getName()+"("+id+")"+"고객님의 구매내역 입니다.");
					System.out.println("━".repeat(51));
					//구매내역 select id 메소드 출력 메소드
//					List<JBuyDTO> list =buydao.history(id);
//					for (JBuyDTO jBuyDTO : list) {
//						System.out.println(jBuyDTO);
//					}
					int count = buydao.history(id);
					System.out.println("총 "+count+"개의 구매내역이 있습니다.");
					
				} catch (SQLException e) {
					System.out.println("구매 오류 : "+e.getMessage());
				}
	            }//상품 결제 if문 end
				}else System.out.println("결제를 취소했습니다. 프로그램을 종료합니다.");
					
		sc.close();
	}//main end
}//main class end

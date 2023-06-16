package koreait.jdbc.day5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoneyDTO {
   private int custno;
   private String custname;
   private String pcode;
   private int price;

}
	
//	@Override
//	public String toString() {
//		return String.format("▶ 회원번호 : %-10d \t ┃ \t판매번호 : %-10d \t ┃ \t단가 : %-10d \t ┃ \t수량 : %-5d \t ┃ \t가격 : %-10d \t ┃ \t상품코드 : %-10s \t ┃ \t판매일자 : %-10s", 
//				custno,selenol,pcost,amount,price,pcode,date)+" ◀";
//	}


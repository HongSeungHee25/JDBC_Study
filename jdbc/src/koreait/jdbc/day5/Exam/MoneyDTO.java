package koreait.jdbc.day5.Exam;

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
    private int salenol;
    private int pcost;
    private int amount;
    private int price;
    private String pcode;
    private java.sql.Date sdate;
   
   
   @Override
	public String toString() {
		return String.format("▶ 회원번호 : %-10d \t ┃ \t판매번호 : %-10d \t ┃ \t단가 : %-8d \t ┃ \t수량 : %-5d \t ┃ \t가격 : %-8d \t ┃ \t상품코드 : %-8s \t ┃ \t판매일자 : %-8", 
				custno,salenol,pcost,amount,price,pcode,sdate)+" ◀";
	}

}


package koreait.jdbc.day4.copy;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JBuyDTO {
	private int buy_seq;
	private String customID;
	private String pcode;
	private int qty;
	private String buy_date;
	
	@Override
	public String toString() {
		return String.format("▶ 구매번호 : %-7d  구매한 사용자ID : %-7s 구매한 상품 코드 : %-10s 구매한 수량 : %-3d 구매한 날짜 : %-10s", 
				buy_seq, customID, pcode,qty, buy_date)+" ◀";
				
	}
}

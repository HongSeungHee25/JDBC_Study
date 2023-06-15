package koreait.jdbc.day4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JProductDTO {
	private String pcode;
	private String category;
	private String pname;
	private int price;
	
	@Override
	public String toString() {
		return String.format("▶ 상품 코드 : %-10s 카테고리 : %-7s 상품 이름 : %-10s\t 상품 가격 : %d", 
				pcode,category,pname,price)+" ◀";
		
	}
}

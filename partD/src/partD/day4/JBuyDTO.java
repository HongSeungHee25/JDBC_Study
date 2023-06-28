package partD.day4;


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
//필드값이 모두 같으면 equals 로 true 되도록 하고싶다.
//-> equals 와 hashcode 를 재정의해야 합니다. (불변객체)
//-> vo 입니다. vo 는 테스트 케이스에서 객체를 비교할 때 사용할 수 있습니다.
//   ┗> assertEquals 비교.
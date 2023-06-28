package partD.day5;

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
   private String grade;
   private int price;
   
   
   @Override
	public String toString() {
		return String.format("▶ 회원번호 : %-10d \t ┃ \t회원이름 : %-10s \t ┃ \t고객등급 : %-10s \t ┃ \t매출 : %-5d", 
				custno,custname,grade,price)+" ◀";
	}

}


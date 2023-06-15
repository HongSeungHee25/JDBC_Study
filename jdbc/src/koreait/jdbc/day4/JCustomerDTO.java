package koreait.jdbc.day4;

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
public class JCustomerDTO {	//DTO : JBuy, JProduct
	private String custom_id;
	private String name;
	private String email;
	private int age;
	private String reg_date;
	
	@Override
		public String toString() {
		return  String.format("[사용자 ID : %-10s 사용자 이름 : %-10s 사용자 이메일 : %-20s 사용자 나이 : %-8d 가입 날짜 : %-10s]",
				custom_id,name,email,age,reg_date);
			
		}
}

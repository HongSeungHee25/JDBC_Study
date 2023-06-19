package koreait.jdbc.day6;

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
public class JCustomerDTO2 {	//DTO : JBuy, JProduct
	private String custom_id;
	private String name;
	private String email;
	private int age;
	private String reg_date;
	private String password;
	
	@Override
		public String toString() {
		return  String.format("[사용자 ID : %-10s 사용자 이름 : %-10s 사용자 이메일 : %-20s 사용자 나이 : %-8d 가입 날짜 : %-10s 비밀번호 : %100s]",
				custom_id,name,email,age,reg_date,password);
			
		}
}

package koreait.jdbc.day5.Exam;

import java.sql.Date;

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
public class MemberDTO {

	private int custno;				//회원번호
	private String custname;		//회원이름
	private String phone;			//회원전화번호
	private String address;			//회원주소
	private Date joindate;			//가입일자
	private String grade;			//회원등급
	private String city;			//거주도시
	
	@Override
	public String toString() {
		return String.format("▶ 회원번호 : %-10d \t ┃ \t회원이름 : %-10s \t ┃ \t회원전화 : %-10s \t ┃ \t주소 : %-15s \t ┃ \t가입일자 : %-10s \t ┃ \t고객등급 : %-5s \t ┃ \t거주도시 : %-5s ", 
				custno,custname,phone,address,joindate,grade,city)+" ◀";
	}
}

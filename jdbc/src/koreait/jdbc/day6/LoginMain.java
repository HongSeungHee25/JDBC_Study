package koreait.jdbc.day6;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.common.hash.Hashing;


public class LoginMain {

	public static void main(String[] args) throws SQLException {
		//LoginMain 에서 사용자에게 아이디 >>> , 패스워드 >>> 
		//로그인 처리 결과 : '로그인 성공했습니다. xxx 님 환영합니다.' 또는 '입력한 계정정보가 틀립니다.' 출력
		
		Scanner sc = new Scanner(System.in);
		
		JCustomerDAO2 dao = JCustomerDAO2.getCustomerDAO2();
		String id;
		String password;
		///////////////////////////////////////////////////////////////
		String name;
		String email;
		int age;
		///////////////////////////////////////////////////////////////
		int count = 0;
		boolean isLogin = true;
		
		while(isLogin) {
			
		System.out.print("아이디를 입력해주세요 >> ");
		id = sc.nextLine();
		
		System.out.print("비밀번호를 입력해주세요 >> ");
		password = Hashing.sha256()
				.hashString(sc.nextLine(),StandardCharsets.UTF_8)
				.toString();
		
		JCustomerDTO2 dto = dao.login(id, password);
		
		if(dto == null) {
			++count;	
			System.out.println(count+"회 틀렸습니다.");
			if(count == 5) {
				System.out.println("입력한 Id 와 Password 가 5번 잘못입력되었습니다. 프로그램을 종료합니다.");
				return;
			}
			System.out.println("입력한 계정정보가 틀립니다.");
			System.out.println(); 		//줄바꿈용
			
		}else {
			System.out.println("'"+dto.getName()+"'님 로그인 성공했습니다.");
			isLogin = false;
		}
		}
		
		System.out.print("ID를 입력해주세요 >> ");
		id = sc.nextLine();
		System.out.print("이름을 입력해주세요 >> ");
		name = sc.nextLine();
		System.out.print("이메일을 입력해주세요 >> ");
		email = sc.nextLine();
		System.out.print("나이를 입력해주세요 >> ");
		age = Integer.parseInt(sc.nextLine());
		System.out.print("비밀번호를 입력해주세요 >> ");
		password = Hashing.sha256()
				.hashString(sc.nextLine(), StandardCharsets.UTF_8)
				.toString();
		
		dao.join(new JCustomerDTO2(id, name, email, age, email, password));
		
		
		
		
		
	}//main end
}//main class end

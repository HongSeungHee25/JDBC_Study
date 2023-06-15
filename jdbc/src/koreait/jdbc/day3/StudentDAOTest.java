package koreait.jdbc.day3;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentDAOTest {

	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAO();
		
		
		System.out.println("━━━━━━━━━━━━━━ 1. insert 테스트 ━━━━━━━━━━━━━━ ");
		System.out.println("2023009 김땡구 17 강남구 - 데이터 입력");
		StudentDTO dto = new StudentDTO("2023009", "김땡구", 16, "강남구");
		try {
			int count = dao.insert(dto);
			System.out.println("학생 등록 "+count+"건 입력 성공!!");
			System.out.println("입력 결과 조회 : "+dao.selectOne(dto.getStuno()));
		} catch (SQLException e) {
			System.out.println("예외 : "+e.getMessage());
		}
		
		System.out.println("\n━━━━━━━━━━━━━━ 2. update 테스트 ━━━━━━━━━━━━━━");
		System.out.println("2023009 김땡구 16 용산구 - 데이터 수정");
		dto = new StudentDTO("2023009", "김땡구", 16, "용산구");
		try {
			int count = dao.update(dto);
			System.out.println("학생 수정 "+count+"건 수정 완료!!");
			System.out.println("수정 결과 조회 : "+dao.selectOne(dto.getStuno()));
		} catch (SQLException e) {
			System.out.println("예외 : "+e.getMessage());
		}
		
		System.out.println("\n━━━━━━━━━━━━━━ 3. delete 테스트 ━━━━━━━━━━━━━━");
		System.out.println("2023009 김땡구 16 용산구 - 데이터 삭제");
		try {
			int count = dao.delete("2023009");
			System.out.println("학생 등록 "+count+"건 삭제 성공!!");
			System.out.println("삭제 결과 조회 : "+dao.selectOne("2023009"));
		} catch (SQLException e) {
			System.out.println("예외 : "+e.getMessage());
		}
		
		System.out.println("\n━━━━━━━━━━━━━━ 4. printAll 테스트 ━━━━━━━━━━━━━━");
		try {
			int count = dao.printAll();
			System.out.println("학생 정보 "+count+"건 출력 완료!!");
		} catch (SQLException e) {
			System.out.println("예외 : "+e.getMessage());
		}
		System.out.println("\n━━━━━━━━━━━━━━ 5. selectOne 테스트 ━━━━━━━━━━━━━━");
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 학번을 입력해주세요 >> ");
		String st = sc.nextLine();
		try {
			dto = dao.selectOne(st);
			System.out.println(dto);
			System.out.println(dto.getName()+" 학생의 정보를 출력 했습니다.");
		} catch (SQLException e) {
			System.out.println("예외 : "+e.getMessage());
		}
		System.out.println("\n━━━━━━━━━━━━━━ 6. selectAll 테스트 ━━━━━━━━━━━━━━");
		try {
			List<StudentDTO> list = dao.selectAll();
			for (StudentDTO student : list) {
				System.out.println(student);
			}
			System.out.println("학생 정보 "+list.size()+" 건 출력 완료!!");
		} catch (SQLException e) {
			System.out.println("예외 : "+e.getMessage());
		}
		
		
	}

}

# 해시함수
: 문자열을 전달받아서 해시코드(평문 -> 암호문)로 변환하는것을 해시함수라고 합니다.그러나 해시코드는 평문으로 변환하지 못합니다.해시함수는 패스워드를 저장할 때 해시값으로 저장하고 해시값은 해시함수에 따라 고정된 길이로 생성됩니다. 대표적인 해시함수로는 sha256,sha512 함수 등은 각각 256비트 또는 512비트 길이 해시값으로 만듭니다. 외부라이브러리 guava(google) 를 사용하면 sha256 메소드가 있습니다. 

    ┗> Google의 Guava 라이브러리는 자바 개발자들을 위한 유용한 유틸리티 클래스와 컬렉션을 제공하는 오픈 소스 라이브러리입니다. 
    Guava 라이브러리는 다양한 기능을 포함하고 있으며, 그 중에는 해시 함수를 사용하는 기능도 있습니다.

## 해시함수 사용하는 기본적인 문법 예시 코드 & 해석
    public class HashExample {
        public static void main(String[] args) {
            String plaintext = "password123"; -> 해시할 평문 문자열

        - SHA-256 해시 함수를 사용하여 해시 코드 생성
        String hashed = Hashing.sha256()
                .hashString(plaintext, StandardCharsets.UTF_8)
                .toString();

        System.out.println("해시 코드: " + hashed);
        }
    }
    ┗> 해석 : 위의 예시 코드에서는 ①'Hashing.sha256()'을 통해 SHA-256 해시 함수를 선택하고,
    	     ②'hashString()' 메서드를 사용하여 해시할 평문 문자열과 문자 인코딩을 지정합니다. 
    	     그리고 ③'toString()'을 호출하여 해시 코드를 문자열로 변환합니다.

-------------

## 해시함수 기본적인 문법 & 해석
		- 암호룰 '1234' 로 정하면 db에는 해시코드로 변환해서 저장합니다.
		- 해시함수는 평문이 같으면 해시코드값도 항상 같습니다.
		String hashval = Hashing.sha256()		            -> 적용할 해시함수 실행
				.hashString("1234", StandardCharsets.UTF_8)	-> 평문, 인코딩 형식
				.toString();
		
		System.out.println("'1234' 평문의 해시코드값은 ? "+hashval);
		┗> 결과 : 03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4
		┗> 결과 해석 : 256비트 나누기 4 하면 64개의 16진수 문자열로 만들어집니다.
		
		*참고 : 해시값으로 평문을 예측할 수 없어야 하므로 해시함수는 수학적 알고리즘이 검증된 것을 사용해야 합니다.

-----------

## 위의 기본적인 문법 예시 코드를 보고 활용 해본 코드
    JCustomerDAO2 dao = JCustomerDAO2.getCustomerDAO2();
    System.out.print("아이디를 입력해주세요 >> ");
		id = sc.nextLine();
    System.out.print("비밀번호를 입력해주세요 >> ");
		password = Hashing.sha256()
				.hashString(sc.nextLine(),StandardCharsets.UTF_8)
				.toString();
    JCustomerDTO2 dto = dao.login(id, password);
    ┗> 해석 : JCustomerDAO2 클래스에서 싱글톤 메서드 선언 후 아이디와 패스워드를 입력받는다. 
    패스워드는 sha256 해시함수를 활용하여 입력받은 문자열을 sha256 해시함수로 변환해줘서 저장했습니다. 



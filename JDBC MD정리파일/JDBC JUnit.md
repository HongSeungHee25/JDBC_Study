# JUnit
: JUnit은 자바 언어로 작성된 소프트웨어 테스트 프레임워크입니다. 소프트웨어 개발 프로세스에서 자동화된 단위 테스트를 작성하고 실행하기 위해 사용됩니다. JUnit은 테스트 주도 개발(Test-Driven Development, TDD) 및 애자일 개발 방법론과 함께 널리 사용되며, 소프트웨어의 품질 향상과 버그를 줄이는 데 도움을 줍니다.

## JUnit 개념과 가능
1. **테스트 케이스(Test Case)** : 테스트의 단위로, 특정한 조건에서 특정한 동작이 예상대로 수행되는지를 검증하는 코드입니다. JUnit은 **'@Test'** 어노테이션을 사용하여 테스트 케이스를 정의합니다.
2. **어설션(Assertion)** : 테스트 케이스에서 예상 결과와 실제 결과를 비교하는 데 사용되는 메서드입니다. JUnit은 다양한 어설션 메서드를 제공하여 테스트 결과를 평가합니다. 예를 들어, **'assertEquals(expected, actual)'**  메서드를 사용하여 예상 값과 실제 값이 일치하는지 확인할 수 있습니다.
3. **테스트 픽스처(Test Fixture)** : 테스트를 실행하기 전에 필요한 환경을 설정하고, 테스트를 실행한 후에 정리하는 작업을 말합니다. JUnit은 **'@Before'** 와 **'@After'** 어노테이션을 사용하여 테스트 픽스처를 설정하고 정리하는 메서드를 정의할 수 있습니다.
4. **테스트 스위트(Test Suite)** : 여러 개의 테스트 케이스를 그룹화하여 한 번에 실행할 수 있는 단위입니다. JUnit은 **'@RunWith'** 와 **'@Suite'** 어노테이션을 사용하여 테스트 스위트를 정의할 수 있습니다.

## JUnit 실행방법
1. JUnit 라이브러리를 프로젝트에 추가합니다. 일반적으로 Maven, Gradle 등의 빌드 도구를 사용하여 의존성을 관리합니다.
2. 테스트 케이스 클래스를 작성합니다. **'@Test'** 어노테이션을 사용하여 각 테스트 메서드를 정의하고, 필요한 어설션 메서드를 사용하여 예상 결과를 확인합니다.
3. 필요한 경우 **'@Before'** 어노테이션을 사용하여 테스트 픽스처를 설정하는 메서드를 작성합니다. 마찬가지로, **'@After'** 어노테이션을 사용하여 테스트 이후에 정리 작업을 수행하는 메서드를 작성할 수 있습니다.
4. JUnit 실행 환경에서 테스트를 실행합니다. 대부분의 통합 개발 환경(IDE)은 JUnit 테스트 실행을 지원하며, 명령줄에서도 실행할 수 있습니다.</br></br>
*JUnit은 단위 테스트의 자동화와 테스트 결과의 가독성을 향상시키는 많은 기능과 어노테이션을 제공합니다. 추가로 JUnit 5는 JUnit Platform, JUnit Jupiter, JUnit Vintage 등의 모듈로 구성되어 확장성과 유연성을 높였습니다.JUnit을 사용하면 소프트웨어의 안정성과 신뢰성을 검증하는 효과적인 테스트를 작성할 수 있으며, 개발 프로세스의 일부로 테스트 주도 개발(TDD) 방법론을 적용할 수 있습니다.*

---------
## JUnit 예시 코드
    //테스트 케이스 입니다.
    //테스트 할 메소드 앞에는 @Test 애노테이션을 작성하기.@DisplayName 는 테스트 내용 작성
    //테스트 결과는 성공 또는 실패입니다. 테스트 메소드에는 대부분의 경우 리턴이 없습니다.
    class BuyDAOTest {

	    private JBuyDAO dao = new JBuyDAO();
	
	    @DisplayName("buy 테이블에 insert 성공하면 리턴값을 1(기대값)이 되어야 합니다.")
	    @Test
	    void insertTest() {
		    JBuyDTO buy = JBuyDTO.builder()
				    .customID("hongGD")
				    .pcode("")
				    .qty(5).build();
		    int i = dao.insert(buy);
		
		    //성공 또는 실패 결과를 확인하는 테스트 메소드를 실행하기
		    assertEquals(1, i);	//기대값, 실제값
							    //기대값과 실제값이 같으면 성공
		
	    }
	
	    @DisplayName("buy 테이블에서 buy_seq 컬럼으로 조회하면 null이 아닌 DTO가 리턴한다.")
	    @Test
	    void selectOneTest() {
		    JBuyDTO jbuy;
		    try {
			    jbuy = dao.selectOne(11111);
			    assertNotNull(jbuy);
		    } catch (SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
		    }
		
    	}
	
	    @Disabled
	    @Test
	    void test() {
		    fail("테스트를 비활성화 하는 연습");
	    }
	    //테스트 메소드 아닌 것도 정의 하여 호출할 수 있습니다.
	    void print() {
		    System.out.println("테스트 중입니다.");
    	}
    }

# Statement-PreparedStatement 
: 'Statement' 와 'PreparedStatement' 는 JDBC에서 데이터에비스에 SQL 문을 실행하기 위해 사용되는 인터페이스입니다. 

## Statement
+ Statement 는 *'정적인'* SQL 문을 실행하는 데 사용됩니다. SQL 문은 문자열로 직접 작성되며, 실행하기 전에 컴파일되지 않습니다. 
+ Statement 는 매번 SQL 문을 실행할 때마다 전체 SQL 문을 데이터베이스 서버에 보내고 컴파일됩니다.
+ Statement 는 주로 실행할 SQL 문이 단순하고 반복적이며 동적인 값이 포함되지 않는 경웨 사용됩니다.
+ 예시)
    + **Statement stmt = connection.createStatement();** </br>
    **String sql = "SELECT * FROM tbl_student";** </br>
    **ResultSet rs = stmt.executeQuery(sql);** </br></br>

## PreparedStatement
+ PreparedStatement 는 *'동적인'* SQL 문을 살행하는 데 사용됩니다. SQL 문에는 '?' 와 같은 매개변수를 사용하여 동적인 값을 전달할 수 있습니다.
+ PreparedStatement 는 SQL 문을 먼저 컴파일하여 데이터베이스 서버에 저장하고, 실행 시에는 매개변수 값을 전달하여 실행합니다. 이로 인해 반복적인 실행에 대해 더 높은 성능을 제공합니다.
+ PreparedStatement 는 SQL 쿼리를 더 안전하게 처리하고 SQL 인젝션 공격을 방지하는 데 도움이 됩니다.
+ 예시)
    + **PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM TBL_STUDENT WHERE age > ?");** </br>
    **pstmt.setInt(1,25);** // 첫 번째 매개변수(1)에 25 값을 설정 </br>
    **ResultSet rs = pstmt.executeQuery();** </br></br>

***'PreparedStatement'** 는 **'Statement'** 보다 매개변수를 사용하고 컴파일 단계를 거치므로 성능과 보안 면에서 더 우수합니다. 따라서 대부분의 경우 **'PreparedStatement'** 를 사용하는 것이 권장됩니다. 그러나 간단한 정적인 SQL 문을 실행하는 경우에는 **'Statement'** 를 사용할 수도 있습니다.*
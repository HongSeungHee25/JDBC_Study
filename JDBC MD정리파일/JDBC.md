# JDBC
: JDBC(Java Database Connectivity)는 자바프로그램에서 다른 기종 간의 데이터베이스를 표준화된 방법으로 접속할 수 있도록 만든 API(Application Programming Interface) 규격으로써 자바와 외부 데이터베이스 간의 연결을 지원합니다. JDBC는 데이터베이스에 대한 연결,쿼리 실행,데이터 검색,수정,추가,삭제 등의 작업을 수행할 수 있는 기능을 제공합니다.JDBC는 Driver Manager 를 통해 각각의 데이터베이스에 접근할 수 있는 Driver 객체를 관리하고 있으며 데이터베이스를 변경해야 하는 경우가 생길 때 별도의 코드 수정 없이 드라이버만 변경해 주면 됩니다. 해당 클래스는 각 DBMS 제조사에서 제공합니다.

# JDBC 를 사용하여 데이터베이스와 상호작용하는 과정
## 1. JDBC 드라이버 로드 : 
+ 먼저, 사용할 데이터베이스에 대한 JDBC 드라이버를 클래스 패스에 로드해야 합니다. JDBC 드라이버는 각 데이터베이스 공급업체에서 제공되며, 데이터베이스 시스템과의 통신을 담당합니다.
## 2. 데이터베이스 연결 설정 : 
+ JDBC 드라이버를 로드한 후, 데이터베이스 서버와의 연결을 설정해야 합니다. 연결 정보에는 데이터베이스의 URL,사용자 이름,비밀번호 등이 포함됩니다.
## 3. 쿼리 실행 : 
+ 연결이 설정되면 SQL 쿼리를 생성하고 실행할 수 있습니다. JDBC는 Statement, PreparedStatement,CallableStatement와 같은 인터페이스를 제공하여 쿼리 실행을 지원합니다.
## 4. 결과 처리 : 
+ 쿼리 실행 결과로 데이터베이스에서 반환된 데이터를 처리해야 합니다. SELECT 문의 경우 결과 집합을 반복하여 데이터를 추출하고 처리할 수 있습니다.
## 5. 자원 관리 : 
+ 데이터베이스 연결, Statement, ResultSet 등의 자원은 사용이 끝나면 반드시 명시적으로 닫아야 합니다. 이는 메모리 누수와 같은 문제를 방지하기 위해 중요합니다.</br></br>
*오라클은 세계적으로 널리 사용되는 관계형 데이터베이스 관리 시스템(RDBMS)입니다. 오라클은 대규모 기업용 응용 프로그램에 널리 사용되며, 고성능, 안정성, 확장성, 보안 등의 기능을 제공합니다. 오라클은 SQL을 사용하여 데이터베이스에 엑세스하고 관리할 수 있으며, JDBC를 통해 자바 언어와 통합하여 데이터베이스 작업을 수행할 수 있습니다.*</br></br>
*JDBC는 오라클과 같은 다양한 데이터베이스 관리 시스템과 상호 작용할 수 있는 유연하고 강력한 도구입니다. 개발자는 JDBC를 사용하여 자바 언어로 데이터베이스 애플리케이션을 개발하고, 데이터베이스 연결, 쿼리 실행, 결과 처리, 자원 관리 등을 수행할 수 있습니다.*

-----
# JDBC와 오라클 데이터베이스 접속 후 작업 수행방법
## 1. JDBC 드라이버 로드 : 
+ 오라클 JDBC 드라이버를 클래스 패스에 추가하고 드라이버를 제공합니다. 오라클에서는 "ojdbc"라는 이름의 JDBC 드라이버를 제공합니다.
    + **Class.forName("oracle.jdbc.driver.OracleDriver");**
## 2. 데이터베이스 연결 설정 : 
+ JDBC 드라이버를 로드한 후에는 데이터베이스 서버와의 연결을 설정해야 합니다. 연결 정보로는 데이터베이스 URL, 사용자 이름, 비밀번호가 필요합니다.
    + **String url = "jdbc:oracle:thin:@hostname:port:databaseName";**</BR>
**String username = "yourUsername";**</BR>
**String password = "yourPassword";**</BR>
**Connection connection = DriverManager.getConnection(url, username, password);**</BR>
## 3. 쿼리 실행 : 
+ 연결이 설정되면 SQL 쿼리를 실행할 수 있습니다. Statement, PreparedStatement, CallableStatement와 같은 JDBC 인터페이스를 사용하여 쿼리를 실행할 수 있습니다.
+ *SELECT 쿼리 실행 후 결과 처리 코드*
    + **String sql = "SELECT * FROM yourTable";** </BR>
    **Statement statement = connection.createStatement();**</BR>
    **ResultSet resultSet = statement.executeQuery(sql);**</BR>
    **while (resultSet.next()) {**</BR>
         // 결과 처리</BR>
    **String columnName = resultSet.getString("columnName");      }** </BR></BR>
+ *INSERT,UPDATE,DELETE와 같은 DML(Data Manipulation Language) 문을 실행할때 사용하는 코드*</br></br>
    + **String sql = "INSERT INTO yourTable (column1, column2) VALUES (?, ?)";**</br>
    **PreparedStatement statement = connection.prepareStatement(sql);**</br>
    **statement.setString(1, value1);**</br>
    **statement.setString(2, value2);**</br>
    **statement.executeUpdate();**</br>
## 4. 자원 관리 : 
+ 데이터베이스 작업을 마치며 연결, Statement, ResultSet 등의 자원을 명시적으로 닫아야 합니다. 이를 위해 'close()'메소드를 호출합니다.
    + **resultSet.close();**</br>
    **statement.close();**</br>
    **connection.close();**</br></br>
*위의 코드는 JDBC를 사용하여 오라클 데이터베이스에 접속하고 작업을 수행하는 기본적인 방법이고 필요에 따라 예외 처리를 추가하고, 쿼리 실행 결과를 적절하게 처리 해야 합니다.*

    




# JDBC 주요 기능과 메소드
## 1. 연결 관리 : 
+ DriverManager : **'getConnection()'** 메소드를 통해 데이터 베이스와의 연결을 생성합니다.
+ Connection : **'close()'** 메소드를 사용하여 연결을 닫습니다.
## 2. 쿼리 실행 : 
+ Statement : 정적 SQL 문을 실행하고 결과를 반환합니다. **'executeQuery()'**,**'executeUpdate()'** 등의 메소드를 사용합니다.
+ PreparedStatement : 동적 SQL 문을 실행하고 매개 변수를 사용할 수 있습니다. **'setX()'** 메소드를 사용하여 매개 변수를 설정한 후, **'executeQuery()'**, **'executeUpdate()'** 등의 메소드를 호출합니다.
+ CallableStatement : 저장 프로시저 또는 함수를 실행합니다.
## 3. 결과 처리 : 
+ ResultSet : 쿼리 실행 결과를 저장하고, 결과 집합에서 데이터를 추출합니다. **'next()'**,**'getString()'**,**'getInt()'** 등의 메소드를 사용하여 데이터를 읽을수 있습니다.
## 4. 트랜잭션 관리 : 
+ Connection : 트랜잭션을 시작하고 커밋 또는 롤백을 수행합니다. **'setAutoCommit()'**,**'commit()'**,**'rollback()'** 등의 메소드를 사용합니다.
## 5. 예외 처리 : 
+ SQLException : 데이터베이스 작업 중에 발생하는 예외를 처리합니다. **'try-catch'** 문을 사용하여 예외를 처리하고, 예외 처리에 따라 적절한 조치를 취합니다.
## 6. 메타데이터 조회 : 
+ DatabaseMetaData : 데이터베이스에 대한 정보를 조회합니다. **'getTables()'**,**'getColumns()'** 등의 메소드를 사용하여 테이블, 열, 인덱스, 제약 조건 등의 정보를 가져올 수 있습니다.
## 7. 배치 처리 : 
+ Statement, PreparedStatement : 여러 개의 SQL 문을 배치로 실행할 수 있습니다. **'addBatch()'**,**'executeBatch()'**,**'clearBatch()'** 등의 메소드를 사용하여 배치 작업을 처리합니다.
## 8. 커서 조작 : 
+ ResultSet : 커러를 이동시켜 결과 집합에서 원하는 위치의 데이터를 읽을 수 있습니다. **'next()'**,**'previous()'**,**'first()'**,**'last()'** 등의 메소드를 사용하여 커서를 조작합니다.
## 9. 배치 업데이트 : 
+ Statement, PreparedStatement : **'addBatch()'** 메소드를 사용하여 여러 개의 SQL 문을 배치로 추가할 수 있습니다. 그리고 **'executeBatch()'** 메소드를 호출하여 배치 작업을 실행합니다. 이를 통해 여러 개의 업데이트나 쿼리를 한 번에 실행하여 성능을 향상시킬 수 있습니다.
## 10. 트렌잭션 설정 : 
+ Connection : **'setAutoCommit(false)'** 메소드를 사용하여 자동 커밋을 비활성화하고, 여러 개의 SQL 문을 하나의 트랜잭션으로 묶을 수 있습니다. 그리고 **'commit()'** 메소드를 호출하여 트랜잭션을 커밋하거나, **'rollback()'** 메소드를 호출하여 롤백할 수 있습니다.
## 11. 저장 프로시저 호출 : 
+ CallableStatement : 저장 프로시저를 호출할 때 사용됩니다. **'prepareCall()'** 메소드로 CallableStatement 를 생성한 후, **'registerOutParameter()'** 메소드를 사용하여 출력 매개 변수를 등록하고, **'execute()'** 메소드를 호출하여 저장 프로시저를 실행합니다.
## 12. SQL 경고 처리 : 
+ SQLWarning : SQL 문 실행 시 발생하는 경고를 처리하는 데 사용됩니다. **'getWarnings()'** 메소드를 호출하여 경고를 가져올 수 있고, 경고 메시지를 확인하고 처리할 수 있습니다.
## 13. 결과 집합 업데이트 : 
+ ResultSet : **'updateXXX()'** 메소드를 사용하여 결과 집합에서 데이터를 수정할 수 있습니다. 예를 들어, **'updateString()'**,**'updateInt()'** 등의 메소드를 사용하여 열 값을 수정한 후, **'updateRow()'** 메소드를 호출하여 업데이트를 반영할 수 있습니다.
## 14. 저장소 접근 : 
+ Blob, Clob : 대용량의 바이너리 데이터나 문자열 데이터를 다룰 때 사용됩니다. **'getBlob()'** 메소드로 Blob 객체를 가져오거나, **'getClob()'** 메소드로 Clob 객체를 가져와서 데이터를 읽거나 쓸 수 있습니다.
## 15. 커서 기반의 조작 : 
+ ResultSet : **'absolute()'** 메소드를 사용하여 커서를 지정한 위치로 이동시킬 수 있습니다. 또한, **'relative()'**,**'first()'**,**'lase()'** 등의 메소드를 사용하여 커서를 이동시킬 수 있습니다.
## 16. 연결 풀링 : 
+ DataSource : 커넥션 풀을 관리하기 위해 사용됩니다. 커넥션 풀링은 애플리케이션에서 데이터베이스 연결을 유지하고 재사용하여 성능을 향상시킵니다. DataSource 를 사용하여 커넥션 풀을 설정하고 커넥션을 가져올 수 있습니다.

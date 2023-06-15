# Connection 인터페이스
: Connection 인터페이스는 자바에서 DBMS와의 연결을 관리하기 위한 인터페이스입니다. Connection 인터페이스를 사용하여 DBMS와의 연결을 설정하고 관리함으로써 데이터베이스 작업을 수행할 수 있습니다. 이를 통해 SQL 문을 실행하고 결과를 반환받을 수 있으며, 트랜잭션을 관리하여 데이터 일관성과 안전성을 유지할 수 있습니다.

## Connection 인터페이스 주요 개념
### 1. 연결(Connection)
+ Connection 인터페이스는 DBMS와의 연결을 나타내는 객체입니다.
+ 연결을 통해 DBMS에 대한 작업을 수행할 수 있습니다.

### 2. 연결 설정
+ **'DriverManager.getConnection()'** 메서드를 사용하여 DBMS와의 연결을 설정합니다. 
+ 연결 설정에는 DBMS의 URL, 사용자 이름, 비밀번호 등이 필요합니다.

### 3. 트랜잭션 관리
+ Connection 객체를 사용하여 트랜잭셩을 시작하고 커밋 또는 롤백하는 등의 트랜잭션 관리 작업을 수행할 수 있습니다.

### 4. Statement 생성
+ **'Connection.createStatement()'** 메서드를 사용하여 **'Statement'** 객체를 생성할 수 있습니다.
+ **'Statement'** 객체는 SQL 문을 실행하기 위해 사용됩니다.

### 5. PreparedStatement 생성
+ **'Connection.prepareStatement()'** 메서드를 사용하여 **'PreparedStatement'** 객체를 생성할 수 있습니다.
+ **'PreparedStatement'** 객체는 미리 컴파일된 SQL 문을 실행하기 위해 사용됩니다. 매개변수화된 쿼리를 사용할 수 있습니다.


### 6. 자원관리
+ Connection 객체는 사용이 끝나면 반드시 닫아야 합니다. 이는 리소스 누수를 방지하고 성능을 향상시키는 데 도움이 됩니다.
+ **'Connection.close()'** 메서드를 사용하여 연결을 닫을 수 있습니다.

--------
## Connection 인터페이스 주요 메서드
### 1. createStatement()
+ Statement 객체를 생성하여 SQL 문을 실행하는 데 사용됩니다.
+ 반환된 Statement 객체를 사용하여 **'executeQuery()'** 나 **'executeUpdate()'** 등의 메서드를 호출하여 SQL 문을 실행할 수 있습니다.

### 2. prepareStatement(String sql)
+ **'PreparedStatement'** 객체를 생성하여 SQL 문을 실행하는 데 사용됩니다.
+ SQL 문에 파라미터가 있을 경우, '?' 와 같은 플레이스 홀더를 사용하여 SQL 문을 작성한후, 이 메서드를 호출하여 **'PreraredStatement'** 객체를 얻습니다.
+ PreparedStatement 객체는 파라미터 값을 설정한 후 **'executeQuery()'** 나 **'executeUpdate()'** 등의 메서드를 호출하여 SQL 문을 실행합니다.

### 3. close()
+ 데이터베이스 연결을 닫습니다.
+ Connection 객체를 더 이상 사용하지 않을 때, 명시적으로 연결을 닫아 리소스를 해제해야 합니다.
+ **'close()'** 를 호출하면 연결이 닫히고, 관련된 리소스가 해제됩니다.

### 4. commit()
+ 현재 트랜잭션을 커밋하여 변경 사항을 영구적으로 저장합니다.
+ **'commit()'** 을 호출하면, 이전에 수행한 모든 데이터베이스 작업이 영구적으로 적용됩니다.

### 5. rollback()
+ 현재 트랜잭션을 롤백하여 변경 사항을 취소합니다.
+ 트랜잭션 내에서 오류가 발생했거나 특정 조건을 충족하지 못한 경우, **'rollback()'** 을 호출하여 이전 상태로 되돌릴 수 있습니다.

### 6. setAutoCommit(boolean autoCommit)
+ 자동 커밋 모드를 설정합니다.
+ **'autoCommit'** 매개변수를 **'true'** 로 설정하면 자동 커밋이 활성화되어 각 SQL 문이 실행될 때마다 자동으로 커밋이 수행됩니다.
+ **'autoCommit'** 매개변수를 **'false'** 로 설정하면 자동 커밋이 비활성화되며, 여러 개의 SQL 문을 하나의 트랜잭션으로 그룹화하여 커밋 또는 롤백할 수 있습니다.

### 7. setTransactionIsolation(int level)
+ 트랜잭션 격리 수준을 설정합니다.
+ **'level'** 매개변수에는 **'Connection'** 상수인 **'TRANSACTION_READ_UNCOMMITTED'** , **'TRANSACTION_READ_COMMITTED'** , **'TRANSACTION_REPEATABLE_READ'** , **'TRANSACTION_SERIALIZABLE'** 등을 사용할 수 있습니다.
+ 격리 수준은 트랜잭션 동시성 및 일관성에 영향을 줄 수 있으며, 각 수준마다 동시 접근 및 변경 가능 여부가 다릅니다.

### 8. getMetaData()
+ **'DatabaseMetaData'** 객체를 반환하여 데이터베이스에 대한 메타데이터를 검색합니다.
+ 이를 통해 데이터베이스의 테이블, 열, 제약 조건 등의 정보를 얻을 수 있습니다.

### 9. isClosed()
+ 데이터베이스 연결이 닫혔는지 여부를 확인합니다.
+ 연결이 닫혔으면 **'true'** 를 반환하고, 그렇지 않으면 **'false'** 를 반환합니다.

### 10. isValid(int timeout)
+ 지정된 시간 내에 데이터베이스 연결이 유효한지 여부를 확인합니다. 
+ 유효하면 **'true'** 를 반환하고, 그렇지 않으면 **'false'** 를 반환합니다.

### 11. setReadOnly(boolean readOnly)
+ 연결을 읽기 전용으로 설정합니다.
+ 읽기 전용 모드에서는 데이터베이스 내의 데이터를 수정할 수 없습니다.

### 12. setCatalog(String catalog)
+ 현재 연결된 데이터베이스의 카탈로그를 설정합니다.
+ 카탈로그는 데이터베이스 내의 다른 데이터베이스나 스키마를 선택하는 데 사용됩니다.

### 13. setSchema(String schema)
+ 현재 연결된 데이터베이스의 스키마를 설정합니다.
+ 스키마는 데이터베이스 내의 특정 사용자에 대한 이름 공간을 나타내며 테이블, 뷰, 함수 등의 개체를 포함합니다.

### 14. getWarnings()
+ 연결에 대한 경고 메시지를 가져옵니다. 
+ 연결 시 발생한 경고 메시지가 없으면 **'null'** 을 반환합니다.

### 15. clearWarnings()
+ 연결에 대한 경고 메시지를 지웁니다.
+ 경고 메시지를 지우면 **'getWarnings()'** 메서드는 **'null'** 을 반환합니다.

### 16. nativeSQL(String sql)
+ 데이터베이스 고유의 SQL 문으로 변환합니다.
+ 데이터베이스별로 SQL 문법이 조금씩 다를 수 있으므로, 이 메서드를 사용하여 데이터베이스에 특정한 SQL을 전달할 수 있습니다.
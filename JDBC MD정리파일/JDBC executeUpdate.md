# executeUpdate 란?
: JDBC에서 사용되는 메서드 중 하나로, 데이터베이스에 대한 업데이트 작업을 수행하는 데 사용됩니다. 이 메서드는 INSERT, UPDATE, DELETE 와 같은 DML(데이터 조작 언어)문장을 실행할 때 사용됩니다.

## executeUpdate() 메서드 기능과 동작 방식
+ 1. executeUpdate() 메서드는 int 형을 반환합니다. 반환되는 값은 해당 쿼리로 인해 영향을 받은 행의 수입니다.
+ 2. executeUpdate() 는 SQL 문장을 실행하고 데이터베이스에서 변경된 레코드의 수를 반환합니다.
+ 3. executeUpdate() 메서드는 PreparedStatement 객체나 Statement 객체에서 호출될 수 있습니다.
+ 4. executeUpdate() 메서드는 주로 INSERT, UPDATE, DELETE 문장을 실행하는 데 사용됩니다.
+ 5. executeUpdate() 메서드는 데이터베이스 연결 상탱화 권한에 따라 실행 가능한 쿼리에 대해서만 동작합니다.

## executeUpdate() 주의사항
+ 1. executeUpdate() 메서드를 실행하기 전에 반드시 Connection 객체를 생성하고 데이터베이스에 연결해야 합니다.
+ 2. executeUpdate() 메서드를 사용할 때는 데이터베이스 작업의 안정성을 위해 트랜잭션 관리를 고려해야 합니다. 필요에 따라 커밋(commit) 또는 롤백(rollback)을 수행하여 데이터의 일관성을 유지할 수 있습니다.
+ 3. executeUpdate() 메서드는 파라미터로 전달되는 SQL 문장을 실행하기 때문에 쿼리문의 안정성과 쿼리 인젝션(SQL Injection)공격에 대한 방어를 위해 PreparedStatement 를 사용하는 것이 좋습니다. PreparedStatement은 SQL 쿼리에 파라미터를 동적으로 바인딩할 수 있는 기능을 제공하여 보안과 성능 면에서 유리합니다.
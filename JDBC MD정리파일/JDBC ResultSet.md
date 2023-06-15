# ResultSet 
: ResultSet 은 JDBC 에서 데이터베이스로부터 쿼리 결과를 가져오는 데 사용되는 인터페이스입니다. ResultSet 은 데이터베이스 결과 집합을 나타내며, 쿼리 실행 결과에 따라 행과 열의 데이터를 읽고 조작할 수 있습니다.

## ResultSet 주요 기능
### 1. 데이터 탐색
+ **'next()'** : 결과 집합에서 다음 행으로 이동하고, 그 행이 존재하는 경우 **'true'** 를 반환합니다.
+ **'previous'** , **'first'** , **'last'** : 결과 집합에서 이전, 첫 번째, 마지막 행으로 이동합니다.
+ **'absolute(row)'** , **'relative(rows)'** : 지정된 행 번호로 이동하거나 상대적인 행 수 만큼 이동합니다.
+ 예시)
    + **while(resultSet.next()) {** </br>
    //현재 행의 데이터를 읽어옴
    **int id = resultSet.getInt("id");** </br>
    **String name = resultSet.getString("name");** </br>
    //데이터 처리 **}** </br></br>

### 2. 열 값 읽기
+ **'getInt(컬럼)'** , **'getString(컬럼)'** , **'getDate(컬럼)'** : 지정된 컬럼의 데이터를 가져옵니다.
+ **'getXXX(컬럼)'** : 'XXX' 는 해당 데이터 유형에 따라 다양한 유형 메서드가 제공됩니다.
+ 예시)
    + int id = resultSet.getInt("id"); </br>
    String name = resultSet.getString("name"); </br>
    Date date = resultSet.getDate("date"); </br></br>

### 3. 커서 위치 조작
+ **'getRow()'** : 현재 행의 인덱스를 반환합니다.
+ **'isBeforeFirst()'** , **'isAfterLast()'** : 커서가 첫 번째 행 이전이거나 마지막 행 이후인지 여부를 확인합니다.

### 4. 결과 집합 메타데이터
+ **'getMetaData()'** : 결과 집합의 메타데이터를 가져옵니다. 메타데이터에는 결과 집합의 컬럼 이름, 데아터 유형 등이 포함됩니다.

### 5. 결과 집합 종료 
+ **'close()'** : 결과 집합을 닫고 리소스를 해제합니다. </br></br>

-----
***'ResultSet'** 을 사용하여 데이터 베이스 결과는 반복하고 읽을 수 있습니다. **'next()'** 메서드를 사용하여 다음 행으로 이동하고, 각 컬럼의 값을 적절한 메서드를 사용하여 읽을 수 있습니다. 데이터를 모두 처리한 후에는 **'close()'** 메서드를 호출하여 결과 집합을 닫아야 합니다.*
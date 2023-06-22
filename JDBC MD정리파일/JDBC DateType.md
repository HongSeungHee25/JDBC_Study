# java.time API
+ 1. 'LocalDate' : 날짜 정보를 나타내는 클래스입니다. 연,월,일을 나타낼 수 있으며, 날짜 계산, 비교, 형식화 등 다양한 기능을 제공합니다.
+ 2. 'LocalTime' : 시간 정보를 나타내는 클래스입니다. 시간, 분, 초, 밀리초를 나타낼 수 있으며, 시간 계산, 비교, 형식화 등 다양한 기능을 제공합니다.
+ 3. 'LocalDateTime' : 날짜와 시간 정보를 함께 나타내는 클래스입니다. 'LocalDate'와 'LocalTime'을 조합하여 사용할 수 있으며, 날짜와 시간에 대한 계산, 비교, 형식화 등을 제공합니다.
+ 4. 'ZonedDateTime' : 특정 시간대(Time Zone)에서의 날짜와 시간 정보를 나타내는 클래스입니다. 'LocalDateTime'에 시간대 정보를 추가하여 사용할 수 있습니다.

## java.time API 사용방법
+ 1. 클래스의 인스턴스 생성: 각 클래스는 'of' 또는 'now' 메서드 등을 사용하여 인스턴스를 생성할 수 있습니다. 예를 들어, 'LocalDate' 클래스는 'of' 메서드를 사용하여 특정 날짜를 생성할 수 있습니다.
    + **LocalDate date = LocalDate.of(2023, 6, 17);**
+ 2. 날짜 및 시간 정보 읽기: 각 클래스는 해당하는 필드에 접근하여 날짜 및 시간 정보를 읽을 수 있습니다. 예를 들어, 'LocalDateTime' 클래스는 'getYear()', 'getMonth()', 'getDayOfMonth()' 등의 메서드를 사용하여 연도, 월, 일 정보를 얻을 수 있습니다.
    + **LocalDateTime dateTime = LocalDateTime.now();**
    + **int year = dateTime.getYear();**
    + **Month month = dateTime.getMonth();**
    + **int dayOfMonth = dateTime.getDayOfMonth();**
+ 3. 날짜 및 시간 연산: 'java.time' API는 날짜 및 시간 연산을 지원합니다. 각 클래스는 'plus', 'minus' 메서드 등을 사용하여 날짜와 시간을 더하거나 빼는 연산을 수행할 수 있습니다.
    + **LocalDate tomorrow = LocalDate.now().plusDays(1);**
    + **LocalDateTime nextHour = LocalDateTime.now().plusHours(1);**
+ 4. 날짜 및 시간 형식화: 'java.time.format.DateTimeFormatter' 클래스를 사용하여 날짜와 시간을 원하는 형식으로 형식화할 수 있습니다.
    + **LocalDateTime dateTime = LocalDateTime.now();**
    + **DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");**
    + **String formattedDateTime = dateTime.format(formatter);**

----------------
# java.util.Date & Calendar
+ 1. 'java.util.Date' 클래스
    + 'java.util.Date' 클래스는 날짜와 시간 정보를 나타내는 가장 기본적인 클래스입니다.
    + 'Date' 객체는 특정 시점의 타임스탬프를 나타냅니다.
    + 'Date' 객체는 변경 가능(mutable)하므로 스레드 안전성이 없습니다.
    + 'Date' 클래스는 다양한 메서드를 제공하여 날짜와 시간 정보를 읽고, 설정하고, 비교할 수 있습니다.
        + **Date date = new Date();** // 현재 시간으로 Date 객체 생성
        + **long timestamp = date.getTime();** // 타임스탬프 값 얻기
+ 2. 'java.util.Calendar' 클래스
    + 'java.util.Calendar' 클래스는 날짜와 시간을 다루는 더 많은 기능을 제공하는 클래스입니다.
    + 'Calendar' 클래스는 추상 클래스이므로 직접 인스턴스를 생성할 수 없고, 'getInstance()' 메서드를 사용하여 'Calendar' 객체를 얻어야 합니다.
    + 'Calendar' 객체는 변경 가능(mutable)하므로 스레드 안전성이 없습니다.
    + 'Calendar' 클래스는 날짜와 시간 정보를 읽고, 설정하고, 비교할 수 있는 다양한 메서드를 제공합니다.
        + **Calendar calendar = Calendar.getInstance();** // 현재 시간으로 Calendar 객체 생성
        + **int year = calendar.get(Calendar.YEAR);** // 연도 정보 얻기
        + **calendar.set(Calendar.MONTH, Calendar.MARCH);** // 월 정보 설정

-----------------
# java.sql.Date & Timestamp
+ 1. 'java.sql.Date' 클래스
    + 'java.sql.Date' 클래스는 SQL 데이터베이스에서 사용되는 날짜 정보를 나타냅니다.
    + 'java.util.Date' 클래스를 상속받은 클래스로, 날짜 정보만을 저장하고 시간 정보는 저장하지 않습니다.
    + 'java.sql.Date' 객체는 변경 가능(mutable)하지 않으므로 스레드 안전성을 가집니다.
        + **java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());** // 현재 시간으로 SQL 날짜 객체 생성
+ 2. 'java.sql.Timestamp' 클래스
    + 'java.sql.Timestamp' 클래스는 SQL 데이터베이스에서 사용되는 날짜와 시간 정보를 나타냅니다.
    + 'java.util.Date' 클래스를 상속받은 클래스로, 날짜와 시간 정보를 저장합니다.
    + 'java.sql.Timestamp' 객체는 변경 가능(mutable)하지 않으므로 스레드 안전성을 가집니다.
        + **java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());** // 현재 시간으로 타임스탬프 객체 생성




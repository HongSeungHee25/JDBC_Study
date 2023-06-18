CREATE OR REPLACE PROCEDURE prc_get_member(
    p_mno IN NUMBER,
    p_name OUT VARCHAR2,
    p_email OUT VARCHAR2,
    p_join_date OUT DATE
)
AS
BEGIN
    SELECT name, email, join_date
    INTO p_name, p_email, p_join_date
    FROM tbl_member
    WHERE mno = p_mno
END;

-- 변수 선언
VAR p_name VARCHAR2(50);
VAR p_email VARCHAR2(100);
VAR p_join_date DATE;

-- 프로시저 호출
EXEC prc_get_member(p_mno => 1, p_name => :p_name, p_email => :p_email, p_join_date => :p_join_date);

-- 결과 출력
PRINT p_name;
PRINT p_email;
PRINT p_join_date;

VAR p_name VARCHAR2(50);
VAR p_email VARCHAR2(100);
VAR p_join_date DATE;
EXEC prc_get_member(p_mno => 1, p_name => :p_name, p_email => :p_email, p_join_date => :p_join_date);

-- 결과 출력
PRINT p_name;
PRINT p_email;
PRINT p_join_date;


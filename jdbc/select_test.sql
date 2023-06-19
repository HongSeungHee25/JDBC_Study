-- update 문
-- update TBL_STUDENT set name = ?, age = ?, address = ? where stuno = ?
-- update 테이블명 set 바꿀 내용 where 조건식
select * from TBL_STUDENT;

-- 여기서부터 다른 테이블로 연습 합니다.
/*
1. 회원 로그인 - 간단히 회원아이디를 입력해서 존재하면 로그인 성공
2. 상품 목록 보기
3. 상품명으로 검색하기 (그외에 가격대 별 검색)
4. 상품 장바구니 담기 - 장바구니 테이블이 없으므로 구매를 원하는 상품을 List 에 담기
5. 상품 구매(결제)하기 - 장바구니의 데이터를 '구매' 테이블에 입력하기 (여러개 insert)
6. 나의 구매 내역 보기. 총 구매 금액을 출력해 주기
*/
select * from TBL_CUSTOM;
select * from TBL_PRODUCT;
select * from TBL_PRODUCT where pname like '%' || '동원' || '%';
select * from TBL_BUY;			-- 구매 정보 테이블

create table j_custom as select * from tbl_custom;
select * from j_custom;

create table j_product as select * from tbl_product;
select * from j_product;

create table j_buy as select * from tbl_buy;
select * from j_buy;

-- pk,fk 는 필요하면 제약조건을 추가 합니다.
-- custom_id, pcode, buy_seq 컬럼으로 pk 설정하기
-- tbl_buy 테이블에는 외래키도 2개가 있습니다.(j_buy 외래키 설정 제외하고 하겠습니다.)

alter table j_custom add constraint custom_pk primary key (custom_id);
alter table j_product add constraint pcode_pk primary key (pcode);
alter table j_buy add constraint buy_pk primary key (buy_seq);

-- 추가 데이터 입력
insert into j_product values ('ZZZ01','B1','오뚜기바몬드카레',2400);
insert into j_product values ('APP11','A1','얼음골사과 1박스',32500);
insert into j_product values ('APP99','A1','씻은사과 10개',25000);

-- j_buy 테이블에 사용될 시퀀스
create sequence jbuy_seq start with 1008;
select jbuy_seq.nextval from dual;


-- 2개 테이블 join 하여 행단위로 합계(수량*가격) 수식까지 조회하기
select buy_date , p.pcode, pname, qty, price, qty*price total
from j_buy b join j_product p
on p.pcode = b.pcode
and b.customid = 'twice'
order by buy_date desc;

-- 2개 테이블 join 하여 행단위로 합계(수량*가격) 수식까지 조회하기


-- 자주 사용될 join 결과는 view 로 만들기. view 는 create or replace 로 생성후 에 수정까지 가능.
create or replace view mypage_buy as 
select buy_date , p.pcode, pname, qty, price, qty*price total
from j_buy b join j_product p
on p.pcode = b.pcode
and b.customid = 'twice'
order by buy_date desc;

select * from mypage_buy where customid = 'twice';

select * from member_tbl_02;
select * from money_tbl_02;

select b.custno, custname, grade, amount * price total 
from money_tbl_02 b join member_tbl_02 a
on a.custno = b.custno
and b.custno;

SELECT b.custno, a.custname, a.grade, SUM(b.amount * b.price) AS total
FROM money_tbl_02 b
JOIN member_tbl_02 a ON a.custno = b.custno
WHERE b.custno
GROUP BY b.custno, a.custname, a.grade;

create or replace view mypage_buy as 
SELECT b.custno, a.custname, a.grade, SUM(b.amount * b.price) AS total
FROM money_tbl_02 b
JOIN member_tbl_02 a ON a.custno = b.custno
GROUP BY b.custno, a.custname, a.grade;


SELECT * FROM MEMBER_TBL_02 mt ;

SELECT a.custno 회원번호, a.custname 회원성명,
CASE 
   WHEN grade = 'A' THEN 'VIP'
   WHEN grade = 'B' THEN '일반'
   WHEN grade = 'C' THEN '직원'
END AS 고객등급,
b.sales 매출
FROM MEMBER_TBL_02 a
JOIN 
(SELECT CUSTNO , sum(price) sales FROM MONEY_TBL_02 mt 
GROUP BY CUSTNO) b 
ON a.custno = b.custno
ORDER BY sales DESC;

SELECT a.custno AS "회원번호", a.custname AS "회원성명",
CASE 
   WHEN a.grade = 'A' THEN 'VIP'
   WHEN a.grade = 'B' THEN '일반'
   WHEN a.grade = 'C' THEN '직원'
END AS "고객등급",
b.sales AS "매출"
FROM MEMBER_TBL_02 a
JOIN 
(SELECT CUSTNO , sum(price) AS sales FROM MONEY_TBL_02 mt 
GROUP BY CUSTNO) b 
ON a.custno = b.custno
WHERE a.custno = 100001;

-- 6월 19일 로그인 구현하기 위한 패스워드 컬럼 추가를 합니다.
-- 패스워드 컬럼은 해시값 64문자를 저장합니다.

alter table j_custom add password char(64);

-- twice 만 패스워드 값 저장하기
update j_custom set password = '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'
where custom_id = 'twice';

select * from j_custom;

-- A : VIP B : 일반  C : 직원
-- decode(컬럼명,조건1,값1,조건2,값2,..........,나머지값)
-- nvl(컬럼명, null일경우 '값')

select custno ,custname, DECODE(grade,'A','VIP','B','일반','C','직원')
from member_tbl_02 mt;

create sequence join_seq start with 100007;

select * from money_tbl_02;

select custno, sum(price)as sales from money_tbl_02
group by custno 
order by custno;

create or replace view money_02
as
select custno, sum(price)as sales from money_tbl_02
group by custno 
order by custno;

select * from money_02;

select a.custno,a.custname,decode(a.grade,'A','VIP','B','일반','C','직원') as grade,b.sales
from member_tbl_02 a left join money_02 b
on a.custno = b.custno
order by a.custno;

create or replace view total_sales
as 
select a.custno,a.custname,decode(a.grade,'A','VIP','B','일반','C','직원') as grade,b.sales
from member_tbl_02 a left join money_02 b
on a.custno = b.custno
order by a.custno;

select * from total_sales;

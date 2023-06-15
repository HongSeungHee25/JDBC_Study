-- CRUD : 데이터의 생성, 읽기, 갱신, 삭제를 가리키는 약자.
-- 프로그램이 가져야할 사용자 인터페이스(메뉴) 기본 기능.


-- 단순 조회(read)
select * from TBL_STUDENT;
select * from TBL_SCORE;

select * from TBL_SCORE where subject = '국어';

select a.name, s.subject, s.jumsu
from TBL_STUDENT a left join TBL_SCORE s on a.stuno = s.stuno where s.subject = '국어';

select count(*) from TBL_STUDENT;

select * from TBL_STUDENT where stuno = '2023002';

-- insert 테스트(create)
insert into TBL_STUDENT values('2023001','김땡땡',16,'경기도');

-- update 테스트
update tbl_student
set age = 17, address = '종로구'
where stuno = '2021001';

-- delete 테스트
delete from tbl_student where stuno = '2000925';
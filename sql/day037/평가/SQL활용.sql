--입력
insert into TEST.MEMBER(ID, NAME, PASSWORD, PHONE, EMAIL)
values ('hong', '홍길동', 'hong1234', '010-1111-1111', 'hong@test.com');

insert into TEST.MEMBER(ID, NAME, PASSWORD, PHONE, EMAIL)
values ('kim', '김유신', 'kim1234', '010-2222-2222', 'kim@test.com');

insert into TEST.MEMBER(ID, NAME, PASSWORD, PHONE, EMAIL)
values ('kang', '강감찬', 'kang1234', '010-3333-3333', 'kang@test.com');
    --조회
    select * from TEST.MEMBER;

-- 추가 2개 더 입력
insert into TEST.MEMBER(ID, NAME, PASSWORD, PHONE, EMAIL)
values ('kimdami', '김다미', 'kim1234', '010-4444-4444', 'kimdami@test.com');

insert into TEST.MEMBER(ID, NAME, PASSWORD, PHONE, EMAIL)
values ('jo', '조이서', 'jo1234', '010-5555-5555', 'jo@test.com');
    --조회
    select * from TEST.MEMBER;

-- BOARD테이블에 홍길동이 작성한 게시글 2개 입력
insert into TEST.BOARD(BNO, TITLE, CONTENT, ID)
values (1, '홍길동은', '동해번쩍 서해번쩍', 'hong');

insert into TEST.BOARD(BNO, TITLE, CONTENT, ID)
values (2, '길동은', '아버지를 아버지라 부르고 싶습니다.', 'hong');
    -- BOARD 테이블 조회
    select * from TEST.BOARD;

--수정
update TEST.MEMBER
set PHONE = '010-2222-1234', EMAIL = 'kim@mystudy.com'
where ID = 'kim';
    --조회
    select * from TEST.MEMBER;

--삭제
delete from TEST.MEMBER
where ID in ('kimdami', 'jo');
    --조회
    select * from TEST.MEMBER;

-- 문제1.4 제약조건 확인
select col.TABLE_NAME,
       col.COLUMN_NAME,
       col.CONSTRAINT_NAME,
       DECODE(c.CONSTRAINT_TYPE,
           'P','PRIMARY KEY',
           'U','UNIQUE KEY',
           'C','CHECK OR NOT NULL',
           'R','FOREIGN KEY') CONSTRAINT_TYPE
from ALL_CONS_COLUMNS col join ALL_CONSTRAINTS c
    on col.CONSTRAINT_NAME = c.CONSTRAINT_NAME
where col.TABLE_NAME in ('BOARD', 'MEMBER')
order by TABLE_NAME, COLUMN_NAME;

-- 문제2 시나리오 작성

--2.1
create index TEST.MEMBER_IDX_NAME on TEST.MEMBER(NAME);

--2.2
create or replace view TEST.VIEW_MEMBER_BOARD as
select m.ID, m.NAME, m.PHONE, m.EMAIL, b.BNO, b.TITLE, b.REGDATE
from TEST.MEMBER m full outer join TEST.BOARD b
    on m.ID = b.ID
order by m.ID, b.BNO;
    --조회
    select * from TEST.VIEW_MEMBER_BOARD;

-- 정렬 확인하려고 날짜 바꿈
update TEST.BOARD
set REGDATE = TO_DATE('2020-12-22 15:33:30', 'YYYY-MM-DD HH24:MI:SS')
where BNO = 2

--2.3
select m.NAME, b.TITLE, b.REGDATE from TEST.MEMBER m right join TEST.BOARD b
    on m.ID = b.ID
where m.ID = 'hong'
order by REGDATE;
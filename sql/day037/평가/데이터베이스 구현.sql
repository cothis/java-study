-- TEST USER 생성
create user TEST identified by testpw
    default tablespace users
    temporary tablespace temp;

grant CONNECT, RESOURCE to test;
grant create view to test;


-- MEMBER TABLE 생성
create table TEST.MEMBER
(
    ID       VARCHAR2(20),
    NAME     VARCHAR2(30) NOT NULL,
    PASSWORD VARCHAR2(20) NOT NULL,
    PHONE    VARCHAR2(20),
    EMAIL    VARCHAR2(50),
    constraint MEMBER_ID_PK primary key (ID)
);
comment on column TEST.MEMBER.ID is '아이디';
comment on column TEST.MEMBER.NAME is '성명';
comment on column TEST.MEMBER.PASSWORD is '암호';
comment on column TEST.MEMBER.PHONE is '전화번호';
comment on column TEST.MEMBER.EMAIL is '이메일';

-- BOARD TABLE 생성
create table TEST.BOARD
(
    BNO     NUMBER               NOT NULL,
    TITLE   VARCHAR2(150)        NOT NULL,
    CONTENT VARCHAR2(3000)       NOT NULL,
    ID      VARCHAR2(20)         NOT NULL,
    REGDATE DATE default SYSDATE NOT NULL,
    constraint BOARD_BNO_PK primary key (BNO),
    constraint BOARD_MEMBER_FK foreign key (ID) references TEST.MEMBER (ID) ON DELETE CASCADE
);
comment on column TEST.BOARD.BNO is '글번호';
comment on column TEST.BOARD.TITLE is '글제목';
comment on column TEST.BOARD.CONTENT is '글내용';
comment on column TEST.BOARD.ID is '작성자아이디';
comment on column TEST.BOARD.REGDATE is '작성일시';


-- 인덱스 생성 : BOARD 테이블 ID 컬럼에 인덱스 생성
create index TEST.BOARD_IDX_ID ON TEST.BOARD(ID);



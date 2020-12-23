/********** 트리거(TRIGGER) ******************
트리거(TRIGGER) : 특정 이벤트나 DDL, DML 문장이 실행되었을 때,
   자동적으로 어떤 일련의 동작(Operation)이나 처리를 수행하도록 하는
   데이타베이스 객체의 하나
  -일반적으로 임의의 테이블에 데이타를 추가(NSERT), 삭제(DELETE), 수정(UPDATE) 할 때,
    다른 연관 관계에 있는 테이블의 데이타를 자동적으로 조작할 경우에 사용

CREATE [OR REPLACE] TRIGGER 트리거명
  BEFORE [OR AFTER]
  UPDATE [OR DELETE OR INSERT] ON 테이블명
  [FOR EACH ROW]
DECLARE
  변수선언부;
BEGIN
  프로그램 로직 구현부;
END;
-------------------------------
<트리거 적용시기 지정>
BEFORE : 데이터 처리가 수행되기 전 수행(INSERT, UPDATE, DELETE 문 실행전)
AFTER : 데이터 처리가 수행된 후 수행(INSERT, UPDATE, DELETE 문 실행후)

이벤트 형태 지정 : INSERT, UPDATE, DELETE
이벤트 발생 테이블 지정 : ON 테이블명

<처리형태 지정>
FOR EACH ROW : 데이타 처리시 건건이 트리거 실행. 이 옵션이 없으면
  기본값인 문장 레벨 트리거로 실행되며 수행전, 후에 한번씩만 트리거 실행

DECLARE : 변수 선언 시 사용 키워드
--------------------
<컬럼값 사용>
:OLD.컬럼명 : SQL 반영 전의 컬럼 데이타를 의미
:NEW.컬럼명 : SQL 반영 후의 컬럼 데이타를 의미
---------------------
<트리거 삭제, 활성, 비활성>
- 삭제 : DROP TRIGGER 트리거명;
- 활성 : ALTER TRIGGER 트리거명 enable;
- 비활성 : ALTER TRIGGER 트리거명 disable;
*****************************************/

-- BOOK 테이블에 대한 로그(LOG 이력) 남길 테이블 작성
CREATE TABLE BOOK_LOG
(
    BOOKID    NUMBER(5),
    BOOKNAME  VARCHAR2(300),
    PUBLISHER VARCHAR2(200),
    PRICE     VARCHAR2(200),
    LOGDATE   DATE DEFAULT SYSDATE,
    JOB_GUBUN VARCHAR2(10)
);

-- 트리거 작성
-- BOOK 테이블에 데이터가 입력(INSERT)되면 BOOK_LOG 테이블에 이력 남기기
-- 트리거명 : AFTER_INSERT_BOOK
create or replace trigger AFTER_INSERT_BOOK
    after insert
    on BOOK
    for each row
declare
begin
    DBMS_OUTPUT.PUT_LINE('BOOK 테이블에 data가 입력되었습니다.');
    -- 입력된 데이터 이력 남기기
    insert into BOOK_LOG(BOOKID, BOOKNAME, PUBLISHER, PRICE, JOB_GUBUN)
    values (:new.BOOKID, :new.BOOKNAME, :new.PUBLISHER, :new.PRICE, 'INSERT');
end;

-- insert 트리거 동작여부 확인
select *
from BOOK;
select *
from BOOK_LOG;

insert into BOOK
values (30, '데이터베이스의 이해', 'ITBOOK', 25000);

insert into BOOK
values (31, '데이터베이스의 이해2', 'ITBOOK', 30000);

select *
from BOOK;
select *
from BOOK_LOG;

commit;
rollback;

-- update trigger : AFTER_UPDATE_BOOK
create or replace trigger AFTER_UPDATE_BOOK
    after update
    on BOOK
    for each row
declare -- 없으면 생략 가능
    V_BOOKNAME BOOK_LOG.BOOKNAME%type := :old.BOOKNAME;
begin
    DBMS_OUTPUT.PUT_LINE('BOOK 테이블에 update가 입력되었습니다.');

    if (:old.BOOKNAME != :new.BOOKNAME) then
        V_BOOKNAME := :old.BOOKNAME || ' -> ' || :new.BOOKNAME;
    end if;

    insert into BOOK_LOG(BOOKID, BOOKNAME, PUBLISHER, PRICE, JOB_GUBUN)
    values (:old.BOOKID,
            V_BOOKNAME,
            :old.PUBLISHER || ' -> ' || :new.PUBLISHER,
            :old.PRICE || ' -> ' || :new.PRICE,
            'UPDATE');
end;

-- update trigger 동작 확인
select *
from BOOK;
select *
from BOOK_LOG;

update BOOK
set BOOKNAME = '오라클 데이터베이스의 이해2',
    PRICE    = 30000
where BOOKID = 31;

update BOOK
set BOOKNAME = '오라클 데이터베이스의 이해',
    PRICE    = 40000
where BOOKID = 30;

commit;

select *
from BOOK;
select *
from BOOK_LOG;

--======================================
--(실습) DELETE 트리거 작성하고 동작 테스트 진행
-- 트리거명 : AFTER_DELETE_BOOK
-- 동작은 BOOK 테이블 데이터가 삭제되면 BOOK_LOG 테이블에 이력 남기기
---------------------------------------
create or replace trigger AFTER_DELETE_BOOK
    after delete
    on BOOK
    for each row
begin
    DBMS_OUTPUT.PUT_LINE('BOOK 테이블에 delete가 동작되었습니다.');

    insert into BOOK_LOG(BOOKID, BOOKNAME, PUBLISHER, PRICE, JOB_GUBUN)
    values (:old.BOOKID, :old.BOOKNAME, :old.PUBLISHER, :old.PRICE, 'DELETE');
end;

-- delete trigger 동작 확인
select *
from BOOK;
select *
from BOOK_LOG;

delete
from BOOK
where BOOKID = 31;

select *
from BOOK;
select *
from BOOK_LOG;

commit;
rollback;

DELETE
FROM BOOK_LOG
WHERE BOOKID IS NULL;

-- 전체 동작
create or replace trigger AFTER_CHANGE_BOOK
    after insert or update or delete
    on BOOK
    FOR EACH ROW
declare
    V_BOOKID    BOOK_LOG.BOOKID%type;
    V_BOOKNAME  BOOK_LOG.BOOKNAME%type;
    V_PUBLISHER BOOK_LOG.PUBLISHER%type;
    V_PRICE     BOOK_LOG.PRICE%type;
    V_JOB       BOOK_LOG.JOB_GUBUN%type;
begin
    if deleting then
        DBMS_OUTPUT.PUT_LINE('delete 중입니다');
        V_BOOKID := :OLD.BOOKID;
        V_BOOKNAME := :OLD.BOOKNAME;
        V_PUBLISHER := :OLD.PUBLISHER;
        V_PRICE := :OLD.PRICE;
        V_JOB := 'DELETE-mh';
    end if;

    if inserting then
        DBMS_OUTPUT.PUT_LINE('insert 중입니다');
        V_BOOKID := :NEW.BOOKID;
        V_BOOKNAME := :NEW.BOOKNAME;
        V_PUBLISHER := :NEW.PUBLISHER;
        V_PRICE := :NEW.PRICE;
        V_JOB := 'INSERT-mh';
    end if;

    if updating then
        DBMS_OUTPUT.PUT_LINE('update 중입니다');
        V_BOOKID := :OLD.BOOKID;
        V_BOOKNAME := :OLD.BOOKNAME;
        V_PUBLISHER := :OLD.PUBLISHER;
        V_PRICE := :OLD.PRICE;

        IF (:OLD.BOOKNAME != :NEW.BOOKNAME) THEN
            V_BOOKNAME := :OLD.BOOKNAME || ' -> ' || :NEW.BOOKNAME;
        end if;

        IF (:OLD.PUBLISHER != :NEW.PUBLISHER) THEN
            V_PUBLISHER := :OLD.PUBLISHER || ' -> ' || :NEW.PUBLISHER;
        end if;

        IF (:OLD.PRICE != :NEW.PRICE) THEN
            V_PRICE := :OLD.PRICE || ' -> ' || :NEW.PRICE;
        end if;

        V_JOB := 'UPDATE-mh';
    end if;

    insert into BOOK_LOG(BOOKID, BOOKNAME, PUBLISHER, PRICE, JOB_GUBUN)
    values (V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE, V_JOB);
end;

alter trigger AFTER_DELETE_BOOK disable;
alter trigger AFTER_INSERT_BOOK disable;
alter trigger AFTER_UPDATE_BOOK disable;

select *
from book_log;
COMMIT;


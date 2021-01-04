-- 물건 테이블
create table ITEM
(
    ITEM_ID       NUMBER(8),
    NAME          VARCHAR2(60) not null,
    PRICE_BY_HOUR NUMBER(8)    not null,
    constraint ITEM_ID_PK primary key (ITEM_ID),
    constraint ITEM_PRICE_CHK check (PRICE_BY_HOUR >= 0),
    constraint ITEM_NAME_UK unique (NAME)
);
create sequence ITEM_ID_SEQ start with 1001 increment by 1 nocache;

-- 보관소 테이블
create table SPOT
(
    SPOT_ID       NUMBER(8),
    SPOT_NAME     VARCHAR2(30)  not null,
    SPOT_LOCATION VARCHAR2(300) not null,
    constraint SPOT_ID_PK primary key (SPOT_ID),
    constraint SPOT_NAME_UK unique (SPOT_NAME)
);
create sequence SPOT_ID_SEQ start with 2001 increment by 1 nocache;

-- 회원 테이블
create table MEMBER
(
    MEMBER_ID VARCHAR2(60),
    PW        VARCHAR2(60)           not null,
    NAME      VARCHAR2(60)           not null,
    PHONE     VARCHAR2(20)           not null,
    EMAIL     VARCHAR2(60),
    CASH      NUMBER(8) default 1000 not null,
    SPOT_ID   NUMBER(8),
    GRADE     VARCHAR2(20)           not null,
    constraint MEMBER_ID_PK primary key (MEMBER_ID),
    constraint MEMBER_SPOT_FK foreign key (SPOT_ID) references SPOT (SPOT_ID)
);
create index MEMBER_NAME_IDX ON MEMBER (NAME);

/*
alter table MEMBER
add (CASH NUMBER(8) default 1000);
*/

alter trigger MEMBER_LOG_TRIGGER disable;
insert into MEMBER(MEMBER_ID, PW, NAME, PHONE, EMAIL, GRADE)
values ('admin', 'admin', 'admin', '010-1234-5678', 'admin@momo.com', 'ADMIN');
alter trigger MEMBER_LOG_TRIGGER enable;

select * from MEMBER;
select * from MEMBER_LOG;

-- ITEM_LIST 테이블
create table MomoInfo
(
    MOMO_ID       NUMBER(8),
    SPOT_ID       NUMBER(8)                 not null,
    ITEM_ID       NUMBER(8)                 not null,
    MEMBER_ID     VARCHAR2(60)              not null,
    IN_TIME       DATE         default SYSDATE,
    OUT_TIME      DATE,
    PRICE_BY_HOUR NUMBER(8)                 not null,
    STATUS        VARCHAR2(20) default '입고' not null,
    constraint MOMO_ID_PK primary key (MOMO_ID),
    constraint MOMO_SPOT_FK foreign key (SPOT_ID) references SPOT (SPOT_ID),
    constraint MOMO_ITEM_FK foreign key (ITEM_ID) references ITEM (ITEM_ID),
    constraint MOMO_MEMBER_FK foreign key (MEMBER_ID) references MEMBER (MEMBER_ID),
    constraint MOMO_TIME_CHK check ( OUT_TIME >= IN_TIME )
);
create sequence MOMO_ID_SEQ start with 3001 increment by 1 nocache;
create index MOMO_IN_TIME_IDX on MomoInfo(IN_TIME);
create index MOMO_STATUS_IDX on MomoInfo(STATUS);

-- 회원정보 변경 로그 테이블
create table MEMBER_LOG
(
    LOG_ID    NUMBER(8),
    MEMBER_ID VARCHAR2(60)         not null,
    PW        VARCHAR2(60)         not null,
    NAME      VARCHAR2(60)         not null,
    PHONE     VARCHAR2(20)         not null,
    EMAIL     VARCHAR2(60),
    LOG_DATE  DATE default SYSDATE not null,
    LOG_MODE  VARCHAR2(30)         not null,
    constraint LOG_ID_PK primary key (LOG_ID)
);
create sequence LOG_ID_SEQ start with 10001 increment by 1 nocache;
create index LOG_DATE_IDX on MEMBER_LOG (LOG_DATE);
create index LOG_MODE_IDX on MEMBER_LOG (LOG_MODE);
create index LOG_MEMBER_ID_IDX on MEMBER_LOG (MEMBER_ID);
create index LOG_MEMBER_NAME_IDX on MEMBER_LOG (NAME);

-- 시퀀스 삭제
DROP SEQUENCE LOG_ID_SEQ;

-- 회원정보 변경 시, 로그 기록 트리거
create or replace trigger MEMBER_LOG_TRIGGER
    after insert or update or delete on MEMBER
    for each row
declare
    V_MEMBER_ID MEMBER_LOG.MEMBER_ID%type;
    V_PW MEMBER_LOG.PW%type;
    V_NAME MEMBER_LOG.NAME%type;
    V_PHONE MEMBER_LOG.PHONE%type;
    V_EMAIL MEMBER_LOG.EMAIL%type;
    V_LOG_MODE MEMBER_LOG.LOG_MODE%type;
BEGIN
    IF INSERTING THEN
        V_MEMBER_ID := :NEW.MEMBER_ID;
        V_PW := :NEW.PW;
        V_NAME := :NEW.NAME;
        V_PHONE := :NEW.PHONE;
        V_EMAIL := :NEW.EMAIL;
        V_LOG_MODE := '회원가입';
    ELSIF UPDATING THEN
        V_MEMBER_ID := :OLD.MEMBER_ID;
        V_PW := :OLD.PW;
        V_NAME := :OLD.NAME;
        V_PHONE := :OLD.PHONE;
        V_EMAIL := :OLD.EMAIL;
        V_LOG_MODE := '회원수정';
        
        IF :OLD.MEMBER_ID != :NEW.MEMBER_ID THEN
            V_MEMBER_ID := :OLD.MEMBER_ID || ' -> ' || :NEW.MEMBER_ID; 
        end if;
        IF :OLD.PW != :NEW.PW THEN
            V_PW := :OLD.PW || ' -> ' || :NEW.PW;
        end if;
        IF :OLD.NAME != :NEW.NAME THEN
            V_NAME := :OLD.NAME || ' -> ' || :NEW.NAME;
        end if;
        IF :OLD.PHONE != :NEW.PHONE THEN
            V_PHONE := :OLD.PHONE || ' -> ' || :NEW.PHONE;
        end if;
        IF :OLD.EMAIL != :NEW.EMAIL THEN
            V_EMAIL := :OLD.EMAIL || ' -> ' || :NEW.EMAIL;
        end if;
    ELSIF DELETING THEN
        V_MEMBER_ID := :OLD.MEMBER_ID;
        V_PW := :OLD.PW;
        V_NAME := :OLD.NAME;
        V_PHONE := :OLD.PHONE;
        V_EMAIL := :OLD.EMAIL;
        V_LOG_MODE := '회원탈퇴';
    END IF;

    DBMS_OUTPUT.PUT_LINE(V_MEMBER_ID || '유저 : ' || V_LOG_MODE);

    INSERT INTO MEMBER_LOG(LOG_ID, MEMBER_ID, PW, NAME, PHONE, EMAIL, LOG_MODE)
    VALUES(LOG_ID_SEQ.nextval, V_MEMBER_ID, V_PW, V_NAME, V_PHONE, V_EMAIL, V_LOG_MODE);
END;

INSERT INTO MEMBER(MEMBER_ID, PW, NAME, PHONE, EMAIL)
VALUES ('MINHO', '1234', 'YUNMINHO', '010-2232-2342', 'MINHO@HA.COM');

UPDATE MEMBER SET PW='5678' WHERE 1 = 1;
DELETE FROM MEMBER WHERE 1 = 1;
DELETE FROM MEMBER_LOG WHERE 1 = 1;

SELECT * FROM MEMBER;
SELECT * FROM MEMBER_LOG;



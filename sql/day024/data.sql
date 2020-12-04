select * from employees;

-- 한줄 주석문

/*
범위 주석문
*/

-- table : column(항목), row(하나의 레코드)

-- table space memory공간 -> 파일

-- table 생성

-- 자료형 제외하고 한글 가능

/*
CREATE TABLE 테이블명(
    컬럼명1 자료형,
    컬렴명2 자료형,
    컬럼명3 자료형
)

DROP TABLE 테이블명;
*/

-- 자료형
/*
    JAVA        Oracle
    int         Integer, NUMBER
    double      NUMBER(총 자릿수, 소수부 자릿수)
    String      VARCHAR2, CHAR, LONG(2기가까지 저장가능)
    Date        DATE
    
*/

-- 문자열
-- CHAR

CREATE TABLE TB_CHAR(
    COL1 CHAR(10 BYTE),
    COL2 CHAR(10 CHAR),
    COL3 CHAR(10)
);

/*
    INSERT INTO 테이블명(컬럼명1, 컬럼명2, 컬렴명3) VALUES(값1, 값2, 값3);
    
    INTEGER -> 123
    STRING -> "Hello" X  / 'Hello' O
    
    영어 1문자 -> 1BYTE
    한글 1문자 -> 3BYTE

*/

INSERT INTO TB_CHAR(COL1, COL2, COL3) VALUES('ABC', 'ABC', 'ABC');

SELECT * FROM TB_CHAR;

INSERT INTO TB_CHAR(COL1, COL2, COL3) VALUES('가나', '가나', '가나');

INSERT INTO TB_CHAR(COL1, COL2, COL3) VALUES('가나다', '가나다', '가나다');

SELECT COL1, COL2, COL3, LENGTHB(COL1), LENGTHB(COL2), LENGTHB(COL3)
FROM TB_CHAR;

/*
    CHAR : 10 BYTE          00000 00000
    ABC ->                  ABC00 00000
    가(3BYTE) + 9 = 12      가0000 00000
    가나(6BYTE) + 8 = 14    가나000 00000
    가나다(9byte) + 7 = 16  가나다00 00000
    
    이렇게 거지같아서 VARCHAR2를 쓴다
*/

-- VAR CHAR 2
CREATE TABLE TB_VARCHAR(
    COL1 VARCHAR2(10 BYTE),
    COL2 VARCHAR2(10 CHAR),
    COL3 VARCHAR2(10)
)

INSERT INTO tb_varchar(col1, col2, col3)
values('ABC', 'ABC', 'ABC');

INSERT INTO tb_varchar(col1, col2, col3)
values('가나다', '가나다', '가나다');

INSERT into tb_varchar(col1, col2, col3)
values('!!!', '!!!', '!!!');

SELECT COL1, COL2, COL3, LENGTHB(COL1), LENGTHB(COL2), LENGTHB(COL3)
FROM tb_varchar;

-- 에러
INSERT INTO tb_varchar(col1, col2, col3)
values('가나다', '가나다라', '가나다');

/*
    LONG
    최대 2GB 크기의 가변길이 문자형
    TABLE 1개당 1개만 사용가능
    
*/

CREATE TABLE TB_LONG (
    COL1 LONG
    --COL2 LONG
);

CREATE TABLE BOOK (
    TITLE VARCHAR2(20),
    BOOKCONTENT LONG,
    BOOKNUMBER NUMBER,
    PRICE NUMBER
);

INSERT INTO tb_long(COL1) VALUES('GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG');
SELECT * FROM TB_LONG;
SELECT COL1, LENGTHB(COL1) FROM TB_LONG;


-- 숫자(정수, 실수)
-- INTEGER 정수
CREATE TABLE TB_INTEGER(
    COL1 INTEGER,
    COL2 INTEGER
);

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES(123, 456.1);

SELECT * FROM TB_INTEGER;

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES('123', '456.1'); -- 가능

SELECT * FROM TB_INTEGER;

-- NUMBER (정수, 실수)
CREATE TABLE TB_NUMBER(
    COL1 NUMBER,
    COL2 NUMBER(5),
    COL3 NUMBER(5, 2),
    COL4 NUMBER(*, 2)
);

INSERT INTO TB_NUMBER(COL1, COL2, COL3, COL4)
VALUES(1234.5678, 12345.12, 123.456, 1234.56789);

SELECT * FROM TB_NUMBER;

-- 날짜 DATE
-- 연도, 월, 일, 시, 분, 초

CREATE TABLE TB_DATE (
    COL1 DATE,
    COL2 DATE
);

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, SYSDATE-1);

SELECT * FROM TB_DATE;

-- TO_DATE(날짜 문자열, 형식문자열)
INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, TO_DATE('2020-12-25 12:30:25', 'YYYY-MM-DD HH:MI:SS'));

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, '2020-12-31');

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, '20/12/30');

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, TO_DATE('20201225123025', 'YYYYMMDDHHMISS'));

DROP TABLE TB_CHAR;
DROP TABLE TB_VARCHAR;
DROP TABLE TB_LONG;
DROP TABLE TB_INTEGER;
DROP TABLE TB_NUMBER;
DROP TABLE TB_DATE;
DROP TABLE BOOK;













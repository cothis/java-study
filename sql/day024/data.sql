select * from employees;

-- ���� �ּ���

/*
���� �ּ���
*/

-- table : column(�׸�), row(�ϳ��� ���ڵ�)

-- table space memory���� -> ����

-- table ����

-- �ڷ��� �����ϰ� �ѱ� ����

/*
CREATE TABLE ���̺��(
    �÷���1 �ڷ���,
    �÷Ÿ�2 �ڷ���,
    �÷���3 �ڷ���
)

DROP TABLE ���̺��;
*/

-- �ڷ���
/*
    JAVA        Oracle
    int         Integer, NUMBER
    double      NUMBER(�� �ڸ���, �Ҽ��� �ڸ���)
    String      VARCHAR2, CHAR, LONG(2�Ⱑ���� ���尡��)
    Date        DATE
    
*/

-- ���ڿ�
-- CHAR

CREATE TABLE TB_CHAR(
    COL1 CHAR(10 BYTE),
    COL2 CHAR(10 CHAR),
    COL3 CHAR(10)
);

/*
    INSERT INTO ���̺��(�÷���1, �÷���2, �÷Ÿ�3) VALUES(��1, ��2, ��3);
    
    INTEGER -> 123
    STRING -> "Hello" X  / 'Hello' O
    
    ���� 1���� -> 1BYTE
    �ѱ� 1���� -> 3BYTE

*/

INSERT INTO TB_CHAR(COL1, COL2, COL3) VALUES('ABC', 'ABC', 'ABC');

SELECT * FROM TB_CHAR;

INSERT INTO TB_CHAR(COL1, COL2, COL3) VALUES('����', '����', '����');

INSERT INTO TB_CHAR(COL1, COL2, COL3) VALUES('������', '������', '������');

SELECT COL1, COL2, COL3, LENGTHB(COL1), LENGTHB(COL2), LENGTHB(COL3)
FROM TB_CHAR;

/*
    CHAR : 10 BYTE          00000 00000
    ABC ->                  ABC00 00000
    ��(3BYTE) + 9 = 12      ��0000 00000
    ����(6BYTE) + 8 = 14    ����000 00000
    ������(9byte) + 7 = 16  ������00 00000
    
    �̷��� �������Ƽ� VARCHAR2�� ����
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
values('������', '������', '������');

INSERT into tb_varchar(col1, col2, col3)
values('!!!', '!!!', '!!!');

SELECT COL1, COL2, COL3, LENGTHB(COL1), LENGTHB(COL2), LENGTHB(COL3)
FROM tb_varchar;

-- ����
INSERT INTO tb_varchar(col1, col2, col3)
values('������', '�����ٶ�', '������');

/*
    LONG
    �ִ� 2GB ũ���� �������� ������
    TABLE 1���� 1���� ��밡��
    
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


-- ����(����, �Ǽ�)
-- INTEGER ����
CREATE TABLE TB_INTEGER(
    COL1 INTEGER,
    COL2 INTEGER
);

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES(123, 456.1);

SELECT * FROM TB_INTEGER;

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES('123', '456.1'); -- ����

SELECT * FROM TB_INTEGER;

-- NUMBER (����, �Ǽ�)
CREATE TABLE TB_NUMBER(
    COL1 NUMBER,
    COL2 NUMBER(5),
    COL3 NUMBER(5, 2),
    COL4 NUMBER(*, 2)
);

INSERT INTO TB_NUMBER(COL1, COL2, COL3, COL4)
VALUES(1234.5678, 12345.12, 123.456, 1234.56789);

SELECT * FROM TB_NUMBER;

-- ��¥ DATE
-- ����, ��, ��, ��, ��, ��

CREATE TABLE TB_DATE (
    COL1 DATE,
    COL2 DATE
);

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, SYSDATE-1);

SELECT * FROM TB_DATE;

-- TO_DATE(��¥ ���ڿ�, ���Ĺ��ڿ�)
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













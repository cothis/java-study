/* 함수(FUNCTION)
   실행 후 값을 리턴(return) 하는 프로그램

   CREATE OR REPLACE FUNCTION FUNCTION1 (
    PARAM1 IN VARCHAR2 --파라미터 작성
   ) RETURN VARCHAR2 --리턴 데이터 타입 선언
   AS
   BEGIN
    RETURN 리턴값; --리턴값
   END;
 ***************************************/

-- BOOKID로 책의 제목을 확인하는 함수
CREATE OR REPLACE FUNCTION GET_BOOKNAME(IN_BOOKID NUMBER)
    RETURN VARCHAR2
AS
    BOOKNAME BOOK.BOOKNAME%TYPE;
BEGIN
    SELECT BOOKNAME
    INTO GET_BOOKNAME.BOOKNAME
    FROM BOOK
    WHERE BOOKID = IN_BOOKID;

    RETURN GET_BOOKNAME.BOOKNAME;
end;

SELECT BOOKID, BOOKNAME, GET_BOOKNAME(BOOKID)
FROM BOOK;

-- SELECT절에 사용
SELECT O.*, GET_BOOKNAME(O.BOOKID)
FROM ORDERS O;

-- WHERE절에 사용
SELECT O.*, GET_BOOKNAME(O.BOOKID)
FROM ORDERS O
WHERE GET_BOOKNAME(BOOKID) LIKE '야구%';

-- ====================================
-- 10분간 휴식 후 17:15분 부터 실습하세요~~~
/* (실습) 고객ID 값을 받아서 고객명을 돌려주는 함수 작성(CUSTOMER 테이블 사용)
함수명 : GET_CUSTNAME
함수를 사용해서 ORDERS 테이블 데이터 조회
    GET_BOOKNAME, GET_CUSTNAME 함수사용 주문(판매)정보와 책제목, 고객명 조회
***************************************/
CREATE OR REPLACE FUNCTION GET_CUSTNAME(IN_CUSTID NUMBER)
    RETURN VARCHAR2
AS
    V_NAME CUSTOMER.NAME%TYPE;
BEGIN
    SELECT NAME
    INTO V_NAME
    FROM CUSTOMER
    WHERE CUSTID = IN_CUSTID;

    DBMS_OUTPUT.PUT_LINE('냥냥 펀치~~!');

    RETURN V_NAME;
end;

SELECT O.*, GET_BOOKNAME(O.BOOKID), GET_CUSTNAME(O.CUSTID)
FROM ORDERS O;
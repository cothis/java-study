SET SERVEROUTPUT ON; -- ENABLE DBMSOUTPUT

DECLARE --변수선언
    V_EMPID NUMBER(5);
    V_NAME  VARCHAR2(30);

BEGIN
    --실행문 시작
    V_EMPID := 100; --치환분 부호 :=
    V_NAME := '홍길동';

    DBMS_OUTPUT.PUT_LINE(V_EMPID || ' : ' || V_NAME);
END;
--실행문(프로시저) 끝

-- BOOK 테이블 데이터 중 일부를 화면 출력
DECLARE
    V_BOOKID    NUMBER(2);
    V_BOOKNAME  VARCHAR2(40);
    V_PUBLISHER VARCHAR2(40);
    V_PRICE     NUMBER(8);
BEGIN
    -- SELECT ~ INTO ~ FROM 형태로 DB데이터 선택하고 INTO절의 변수에 저장
    -- (주의) 1개의 데이터만 처리가능
    SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
    INTO V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE -- 1대 1 대입됨(데이터가 1개만 있거나, 없거나)
    FROM BOOK
    WHERE BOOKID = 1;

    DBMS_OUTPUT.PUT_LINE(V_BOOKID || ', ' || V_BOOKNAME || ', ' || V_PUBLISHER || ', ' || V_PRICE);

END;

--===========================================================================
-- 저장 프로시저!(stored procedure)
-- 자바라면 : public int procedure1(int param1, String param2)

CREATE OR REPLACE PROCEDURE PROCEDURE1(PARAM1 IN NUMBER,
                                       PARAM2 OUT VARCHAR2,
                                       PARAM3 IN OUT VARCHAR2) AS
    -- 변수 선언 영역
BEGIN
    -- 실행문 작성
    NULL;
END PROCEDURE1;

-- 매개변수(파라미터, parameter) 유형
-- IN     : 입력을 받기만 하는 매개변수(기본값)
-- OUT    : 출력만 하는 변수 (값을 받을 수는 없고, 프로시져 내부에서 저장을 해서 외부로 출력될 데이터)
-- IN OUT : 입력도 받고, 값을 변수를 통해 출력도 한다.

-- 프로시저 선언부
CREATE OR REPLACE PROCEDURE BOOK_DISP
-- 매개변수 선언부( ) 안에 작성, 구분 문자는 콤마(',')
(
    IN_BOOKID IN NUMBER
) AS
    -- 변수 선언부(AS 또는 IS ~ BEGIN 사이)
    V_BOOKID    NUMBER(2);
    V_BOOKNAME  VARCHAR2(40);
    V_PUBLISHER VARCHAR2(40);
    V_PRICE     NUMBER(8);
BEGIN
    SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
    INTO V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE -- 1대 1 대입됨(데이터가 1개만 있거나, 없거나)
    FROM BOOK
    WHERE BOOKID = IN_BOOKID;

    DBMS_OUTPUT.PUT_LINE(V_BOOKID || ', ' || V_BOOKNAME || ', ' || V_PUBLISHER || ', ' || V_PRICE);
END BOOK_DISP;

-- AS IS 차이
-- END 이후 프로시저 이름 유무

-- 프로시저 실행 : EXECUTE 프로시저명;
EXECUTE BOOK_DISP(3);

EXEC BOOK_DISP(4);

-- 프로시저 삭제 : DROP PROCEDURE 프로시저명;

-- 프로시저 파라미터 유형 : in, out 사용
-- OUT 매개변수 사용 프로시져
CREATE OR REPLACE PROCEDURE GET_BOOKINFO(IN_BOOKID IN NUMBER,
                                         OUT_BOOKNAME OUT VARCHAR2,
                                         OUT_PUBLISHER OUT VARCHAR2,
                                         OUT_PRICE OUT NUMBER) AS
    -- %TYPE 사용 : 테이블명.컬럼명%TYPE 해당 타입정보 가져온다.
    -- 테이블 컬럼과 동일한 타입으로 선언
    V_BOOKID    BOOK.BOOKID%TYPE;
    V_BOOKNAME  BOOK.BOOKNAME%TYPE;
    V_PUBLISHER BOOK.PUBLISHER%TYPE;
    V_PRICE     BOOK.PRICE%TYPE;
BEGIN
    -- 매개변수값 출력 확인
    DBMS_OUTPUT.PUT_LINE('매개변수값: ' || IN_BOOKID || ', ' || OUT_BOOKNAME || ', '
        || OUT_PUBLISHER || ', ' || OUT_PRICE);

    SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
    INTO V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE -- 1대 1 대입됨(데이터가 1개만 있거나, 없거나)
    FROM BOOK
    WHERE BOOKID = IN_BOOKID;

    -- 호출한 곳으로 데이터를 전달하기 위해서 OUT 유형의 변수에 저장
    OUT_BOOKNAME := V_BOOKNAME;
    OUT_PUBLISHER := V_PUBLISHER;
    OUT_PRICE := V_PRICE;

    DBMS_OUTPUT.PUT_LINE(V_BOOKID || ', ' || V_BOOKNAME || ', ' || V_PUBLISHER || ', ' || V_PRICE);
END;

--===================================================================
--위의 프로시저를 호출해서 값을 OUT으로 전달된 값 확인용 프로시저
CREATE OR REPLACE PROCEDURE GET_BOOKINFO_TEST(IN_BOOKID IN NUMBER)
AS
    V_BOOKNAME  BOOK.BOOKNAME%TYPE;
    V_PUBLISHER BOOK.PUBLISHER%TYPE;
    V_PRICE     BOOK.PRICE%TYPE;
BEGIN

    -- GET_BOOKINFO 프로시저 실행(호출)
    GET_BOOKINFO(IN_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE);

    -- GET_BOOKINFO 프로시저 실행 후 전달받은 값 확인
    DBMS_OUTPUT.PUT_LINE('>>OUT값 : ' || IN_BOOKID || ', ' || V_BOOKNAME || ', ' || V_PUBLISHER || ', ' || V_PRICE);
END;

-- 인텔리제이 프로시저 실행은 CALL
CALL GET_BOOKINFO_TEST(4);

----------------------------------------------------------------------------------------
/* (실습) 프로시저 작성하고 실행하기
   고객테이블(customer)에 있는 데이터 조회 프로시저 작성
   - 프로시저명 : GET_CUSTINFO
   - 입력받는 값 : 고객ID
   - 처리 : 입력받은 고객ID에 해당하는 데이터를 찾아서 화면에 출력
   - 출력항목 : 고객ID, 고객명, 주소, 전화번호
 */
SELECT *
FROM CUSTOMER;

CREATE OR REPLACE PROCEDURE GET_CUSTINFO(IN_CUSTID IN NUMBER)
AS
    V_CUSTID  CUSTOMER.CUSTID%TYPE;
    V_NAME    CUSTOMER.NAME%TYPE;
    V_ADDRESS CUSTOMER.ADDRESS%TYPE;
    V_PHONE   CUSTOMER.PHONE%TYPE;
BEGIN
    SELECT CUSTID, NAME, ADDRESS, PHONE
    INTO V_CUSTID, V_NAME, V_ADDRESS, V_PHONE
    FROM CUSTOMER
    WHERE CUSTID = IN_CUSTID;

    DBMS_OUTPUT.PUT_LINE(V_CUSTID || ', ' || V_NAME || ', ' || V_ADDRESS || ', ' || V_PHONE);
end;

CALL GET_CUSTINFO(2);

/*
 비교구문(분기처리) IF문
 IF (조건식) THEN ~ END IF;
 IF (조건식) THEN ~ ELSE ~ END IF;
 IF (조건식) THEN ~ ELSIF ~ ELSIF ~ ELSE ~ END IF;
 */
-- 홀수, 짝수 판별
CREATE OR REPLACE PROCEDURE PRC_IF(IN_NUM NUMBER)
AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('>> 입력값 : ' || IN_NUM);
    IF (MOD(IN_NUM, 2) = 0) THEN
        DBMS_OUTPUT.PUT_LINE(IN_NUM || ' : 짝수');
    ELSE
        DBMS_OUTPUT.PUT_LINE(IN_NUM || ' : 홀수');
    end if;
end;

CALL PRC_IF(3);

-- ELSIF 사용예제
-- ==============================================
-- 입력받은 숫자값을 4로 나눈 나머지 값 확인
CREATE OR REPLACE PROCEDURE PRC_IF2(IN_NUM NUMBER)
AS
    MODVAL NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('>> 입력값 : ' || IN_NUM);
    -- 4로 나눈 나머지 값 출력
    MODVAL := MOD(IN_NUM, 4);

    IF (MODVAL = 0) THEN
        DBMS_OUTPUT.PUT_LINE('>> 4로 나눈 나머지 0');
    ELSIF (MODVAL = 1) THEN
        DBMS_OUTPUT.PUT_LINE('>> 4로 나눈 나머지 1');
    ELSIF (MODVAL = 2) THEN
        DBMS_OUTPUT.PUT_LINE('>> 4로 나눈 나머지 2');
    ELSE
        DBMS_OUTPUT.PUT_LINE('>> 4로 나눈 나머지 3');
    end if;
end;

CALL PRC_IF2(12313);

-- ===============================================
-- 반복문 : FOR, WHILE

-- FOR 문
---- FOR 변수 IN 초기값 .. 최종값 LOOP ~ END LOOP;
--------------------------------------------------

--숫자 하나를 입력받아서 합계 출력(1~N 까지의 합)
CREATE OR REPLACE PROCEDURE PRC_FOR_SUM(IN_NUM IN NUMBER)
AS
    V_SUM number := 0;
BEGIN
    -- 입력받은 값 화면 출력
    DBMS_OUTPUT.PUT_LINE('>>>입력값 : ' || IN_NUM);

    -- 누적 : FOR문으로 반복처리
    FOR I IN 1 .. IN_NUM LOOP
        V_SUM := V_SUM + I;
        DBMS_OUTPUT.PUT_LINE('>> ' || I || ', SUM = ' || V_SUM);
    end loop;

    DBMS_OUTPUT.PUT_LINE('>>>합계값 : ' || V_SUM);
end;
CALL PRC_FOR_SUM(5);

-- ============================
-- WHILE 문
---- WHILE (조건식) LOOP ~ END LOOP;

CREATE OR REPLACE PROCEDURE PRC_WHILE_SUM(IN_NUM IN NUMBER)
AS
    V_SUM number := 0;
    I NUMBER := 1;
BEGIN
    -- 입력받은 값 화면 출력
    DBMS_OUTPUT.PUT_LINE('>>>입력값 : ' || IN_NUM);

    -- 누적 : FOR문으로 반복처리
    WHILE (I <= IN_NUM) LOOP
            V_SUM := V_SUM + I;
            DBMS_OUTPUT.PUT_LINE('>> ' || I || ', SUM = ' || V_SUM);
            I := I + 1;
    end loop;

    DBMS_OUTPUT.PUT_LINE('>>>합계값 : ' || V_SUM);
end;

CALL PRC_WHILE_SUM(5);

-- ===========================================
/* LOOP ~ END LOOP;

LOOP
   실행문
   EXIT WHEN (종료조건)
END LOOP;
 ********************************************/
CREATE OR REPLACE PROCEDURE LOOP1
AS
    I NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE('I = ' || I);
        I := I + 1;
        EXIT WHEN (I > 10);
    end loop;
end;

CALL LOOP1();

-- ====================================
/* (실습) 숫자를 하나 입력 받아서 1 ~ 숫자까지의 합계 구하기
프로시저명 : PRC_SUM_EVENODD
— 입력값이 홀수면 홀수값만 더하고
— 입력값이 짝수면 짝수값만 더해서
최종 합계값을 화면에 출력
<출력형태>
— 입력숫자: 입력값, 홀수/짝수, 합계 : 합계결과
   출력예) 입력숫자 : 4, 짝수, 합계 : 6
   출력예) 입력숫자 : 5, 홀수, 합계 : 9
******************************************/
CREATE OR REPLACE PROCEDURE PRC_SUM_EVENODD(IN_NUM NUMBER)
AS
    FIRST_NUM NUMBER;
    TOT_NUM NUMBER := 0;
BEGIN
    FIRST_NUM := MOD(IN_NUM, 2);
    DBMS_OUTPUT.PUT('입력숫자 : ' || IN_NUM);
    IF(FIRST_NUM = 0) THEN
        FIRST_NUM := 2;
        DBMS_OUTPUT.PUT(', 짝수');
    ELSE
        DBMS_OUTPUT.PUT(', 홀수');
    end if;
    WHILE (FIRST_NUM <= IN_NUM) LOOP
        TOT_NUM := TOT_NUM + FIRST_NUM;
        FIRST_NUM := FIRST_NUM + 2;
        end loop;
    DBMS_OUTPUT.PUT_LINE(', 합계 : ' || TOT_NUM);
end;

CALL PRC_SUM_EVENODD(5);

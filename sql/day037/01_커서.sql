select *
from tab;
/* ******** CURSOR(커서) **************
데이터베이스 커서(Cursor)는 일련의 데이터에 순차적으로 액세스할 때
검색 및 "현재 위치"를 포함하는 데이터 요소

묵시적커서 : SELECT, INSERT, UPDATE, DELETE 문장이 실행될 때
     DBMS가 CURSOR(커서)의 Open, Fetch, Close 자동 처리
명시적커서 : 프로그램내에서 명시적으로 커서(CURSOR)를 선언한 경우

<커서(CURSOR) 사용 절차>
1. 선언(CURSOR 커서명 IS SELECT문)
2. 커서오픈(OPEN 커서명)
3. 데이타추출(FETCH 커서명 INTO)
4. 커서닫기(CLOSE 커서명)
------------------------------------------
- SQL%ROWCOUNT : 행의 수
- SQL%FOUND : 1개 이상일 경우 (결과값이 있으면 true)
- SQL%NOTFOUND : 결과값이 하나도 없을때 true
- SQL%ISOPEN : 항상 false, 암시적 커서가 열려 있으면 true
**************************************/
create or replace procedure DISP_ORDERS
as
    -- 1. 커서 선언(cursor 커서명 is select문)
    CURSOR C_ORDERS is
        select o.ORDERID, c.NAME, b.BOOKNAME, o.SALEPRICE, o.ORDERDATE
        from ORDERS o
                 inner join BOOK b on b.BOOKID = o.BOOKID
                 inner join CUSTOMER c on o.CUSTID = c.CUSTID
        order by o.ORDERID desc;
    -- 사용할 변수 선언
    V_ORDERID   ORDERS.ORDERID%type;
    V_CUSTNAME  CUSTOMER.NAME%type;
    V_BOOKNAME  BOOK.BOOKNAME%type;
    V_SALEPRICE ORDERS.SALEPRICE%type;
    V_ORDERDATE ORDERS.ORDERDATE%type;
begin
    -- 2. 커서 오픈(open 커서명) : 선택된 데이터를 화면에 출력
    open C_ORDERS;

    -- 3. 데이타추출(FETCH 커서명 INTO)
    loop
        fetch C_ORDERS
            into V_ORDERID, V_CUSTNAME, V_BOOKNAME, V_SALEPRICE, V_ORDERDATE;

        exit when C_ORDERS%NOTFOUND;

        -- 커서로부터 가져온 데이터 화면 출력
        DBMS_OUTPUT.PUT_LINE(
                    V_ORDERID || ', ' || V_CUSTNAME || ', ' || V_BOOKNAME || ', ' || V_SALEPRICE || ', ' ||
                    V_ORDERDATE);
    end loop;

    -- 4. 커서닫기(CLOSE 커서명)
    close C_ORDERS;
end;

call disp_orders();


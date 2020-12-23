/* 시퀀스(SEQUENCE)
DB에서 제공하는 자동체번 객체
*/

CREATE SEQUENCE MY_SEQ START WITH 1 INCREMENT BY 1 cache 20 noorder nocycle;

/* **** 시퀀스(SEQUENCE)
SEQUENCE : DB에서 제공하는 자동채번 객체
생성 : CREATE SEQUENCE 시퀀스명;
삭제 : DROP SEQUENCE 시퀀스명;

시퀀스명.NEXTVAL : 시퀀스 번호(값) 생성
시퀀스명.CURRVAL : 현재 시퀀스값 확인(NEXTVAL 한 번 이상 실행 후)
****************************/
select *
from tabs;

select max(BOOKID), max(BOOKID) + 1
from BOOK;

select max(AAA), nvl(max(AAA), 0) + 1
from AAA;

--------------------------
-- BOOK 테이블에 INSERT 작업
insert into BOOK(BOOKID, BOOKNAME, PUBLISHER, PRICE)
VALUES (NVL((SELECT MAX(BOOKID) FROM BOOK), 0) + 1, 'MY BOOK', 'ITBOOK', 20000);
COMMIT;

SELECT *
FROM BOOK
ORDER BY BOOKID DESC;

SELECT *
FROM BOOK_LOG;

--------------------------
CREATE SEQUENCE SEQ_BOOK
    START WITH 50
    INCREMENT BY 1 -- 생략 시 DEFAULT 1
    NOCACHE; -- 캐시 사용 안함
---------------------------

-- BOOK 테이블에 INSERT 작업(SEQUENCE)
insert into BOOK(BOOKID, BOOKNAME, PUBLISHER, PRICE)
VALUES (SEQ_BOOK.nextval, 'MY BOOK', 'ITBOOK', 20000);
COMMIT;

SELECT SEQ_BOOK.currval FROM DUAL;
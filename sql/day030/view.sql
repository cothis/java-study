/**
  VIEW : 하나 또는 둘 이상의 테이블로부터 데이터의 부분집합을
         테이블인 것처럼 사용하는 객체(가상테이블)

  CREATE [OR REPLACE] VIEW 뷰명칭 [(컬럼 별칭...)]
  AS
  SELECT 문
  [옵션];

  -- 읽기전용 옵션 : WITH READ ONLY

  create view query
*/
CREATE OR REPLACE VIEW COUNTRIES as
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       E.JOB_ID,
       E.SALARY,
       E.DEPARTMENT_ID,
       D.DEPARTMENT_NAME,
       D.MANAGER_ID
FROM EMPLOYEES E
         INNER JOIN DEPARTMENTS D on D.DEPARTMENT_ID = E.DEPARTMENT_ID;

SELECT *
FROM EMP_DEPT
ORDER BY EMPLOYEE_ID;
--------------------------------------------------------------------------

 -- FORCE : 테이블이 없어도 뷰를 강제로 생성
CREATE FORCE VIEW MY_TEST AS
SELECT *
FROM TEST999;

DROP VIEW MY_TEST;
DROP TABLE TEST999;

CREATE TABLE TEST999
(
    AAA VARCHAR2(30)
);


INSERT INTO TEST999 VALUES ('홍길동');
COMMIT;


----------------------------------------------------------------------------
-- TABLE 을 작성하라.
-- TEAM : 팀아이디, 지역, 팀명, 창단일, 전화번호, 홈페이지
-- PLAYER : 선수번호, 선수명, 등록일, 포지션, 키(신장), 팀아이디
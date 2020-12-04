-- 문제 1 EMPLOYEES table의 모든 자료를 출력하여라.
SELECT * FROM EMPLOYEES;

-- 문제 2 EMPLOYESS Table의 컬럼들을 모두 출력하라.
SELECT * FROM COLS WHERE LOWER(TABLE_NAME) like lower('EMPLOYEES');
SELECT * FROM COLS;
SELECT * FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='EMPLOYEES';
SELECT COLUMN_NAME 이름, NULLABLE 널, DATA_TYPE 유형 FROM COLS WHERE TABLE_NAME='EMPLOYEES';

-- 문제 3 EMPLOYEES Table에서 사원 번호, 이름, 급여, 담당업무를 출력하라.
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, JOB_ID FROM EMPLOYEES;

-- 문제 4 모든 종업원의 급여를 $300 증가시키기 위해 덧셈 연산자를 사용하고 결과에 SALARAY+300을 디스플레이 합니다.
SELECT FIRST_NAME, SALARY, SALARY+300 FROM EMPLOYEES;

-- 문제 5 EMP 테이블에서 사원번호, 이름, 급여, 보너스, 보너스(월급 + (월급*커미션)) 금액을 출력하여라.
SELECT EMPLOYEE_ID,
       FIRST_NAME,
       SALARY,
       NVL2(COMMISSION_PCT, COMMISSION_PCT, 0) * SALARY,
       SALARY + NVL(COMMISSION_PCT, 0) * SALARY
FROM EMPLOYEES;

SELECT EMPLOYEE_ID,
       FIRST_NAME,
       SALARY,
       CASE
           WHEN COMMISSION_PCT IS NULL THEN 0

           ELSE COMMISSION_PCT END * SALARY AS BONUS,
       CASE
           WHEN COMMISSION_PCT IS NULL THEN 0
           ELSE COMMISSION_PCT END * SALARY + SALARY
                                            AS "TOTAL SALARY"
FROM EMPLOYEES;

SELECT EMPLOYEE_ID,
       FIRST_NAME,
       SALARY,
       EMPLOYEES.COMMISSION_PCT,
       COMMISSION_PCT * SALARY,
       COMMISSION_PCT * SALARY + SALARY
FROM EMPLOYEES;






-- 문제 6 EMPLOYEES 테이블에서 LAST_NAME을 이름으로 SALARY을 급여로 출력하라.
SELECT LAST_NAME 이름, SALARY 급여 FROM EMPLOYEES;

-- 문제 7 EMPLOYEES 테이블에서 LAST_NAME을 Name으로 SALARY*12를 Annual Salary(연봉)로 출력하라
SELECT LAST_NAME "Name", SALARY*12 AS "Annual Salary" FROM EMPLOYEES;

-- 문제 9 EMPLOYEES 테이블에서 이름과 업무를 연결하여 출력하여라.
SELECT LAST_NAME || JOB_ID AS "Employees" FROM EMPLOYEES;

-- 문제 10 EMPLOYEES 테이블에서 이름과 업무를 KING is a PRESIDENT 형식으로 출력하여라.
SELECT LAST_NAME || ' is a ' || JOB_ID "Employees Details" FROM EMPLOYEES;

-- 문제 11 EMPLOYEES 테이블에서 이름과 연봉을 "KING: 1 Year salary = 60000" 형식으로 출력하여라.
SELECT LAST_NAME || ': 1 Year salary = ' || SALARY * 12 AS MONTHLY FROM EMPLOYEES;

-- 문제 12 EMPLOYEES 테이블에서 JOB을 모두 출력하라.
SELECT JOB_ID FROM EMPLOYEES;

select
case
    when 'a' like 'A' then 'Y'
    else 'N'
END
from dual;
/*
    SELECT COLUMN, ALIAS, FUNCTION, SUB_QUERY
    FROM TABLE, SUB_QUERY
    WHERE 조건
        비교연산자( =, >, <, !=, >=, <=, <> )
        NULL: IS NULL, IS NOT NULL
        ( ), NOT, AND, OR
*/

-- First_Name = Julia
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE FIRST_NAME = 'Julia';

-- 월급 $9000이상인 사원
SELECT *
FROM EMPLOYEES
WHERE SALARY >= 9000;

-- 이름이 Shanta 보다 큰 이름
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME > 'Shanta';

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME >= 'a';

SELECT FIRST_NAME, MANAGER_ID
FROM EMPLOYEES
WHERE MANAGER_ID IS NULL;

-- AND
SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME = 'Shanta'
  AND FIRST_NAME = 'John';

-- OR
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE FIRST_NAME = 'Shanta'
   OR FIRST_NAME = 'John';

-- 이름이 John 이고 월급이 5000이상인 사원
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE FIRST_NAME = 'John'
  AND SALARY >= 5000;

-- 2007년 12월 31일 이후에 입사한 사원의 정보
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
--WHERE HIRE_DATE > '07/12/31';
WHERE HIRE_DATE > TO_DATE('071231', 'YYMMDD');

-- ALL(AND), ANY(OR)
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME = ALL('Julia', 'John');

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME = ANY('Julia', 'John');

-- IN, NOT IN
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY IN (8000, 3200, 6000);

SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY NOT IN (8000, 3200, 6000);

SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE FIRST_NAME IN ('Julia', 'John');

-- BETWEEN 범위 연산자
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 3200 AND 9000;

SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY NOT BETWEEN 3200 AND 9000;

-- LIKE <- *****
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'G_ra_d'; -- '_' : 한 문자

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'Al%'; -- '%' : 뒤로 여러 문자(0개 이상)

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%Al%'; -- '%' : 앞 뒤로 여러 문자(0개 이상)

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'K%y'; -- '%' : 중간에 여러 문자(0개 이상)

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%y'; -- '%' : 앞에 여러 문자(0개 이상)

-- 20006년도에 입사한 사원
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE LIKE '06%';

SELECT *
FROM EMPLOYEES
WHERE TO_CHAR(HIRE_DATE, 'YYYYMMDD') LIKE '2006%';

SELECT *
FROM EMPLOYEES
WHERE SALARY > ALL(5000, 1000, 12000);
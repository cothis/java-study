-- 문제1) EMPLOYEES 테이블에서 급여가 3000이상인 사원의 정보를 사원번호, 이름, 담당업무, 급여를 출력하라.
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY >= 3000;

-- 문제2) EMPLOYEES 테이블에서 담당 업무가 Manager인 사원의 정보를
-- 사원번호, 성명, 담당업무, 급여, 부서번호를 출력하라. (Manager == ST_MAN)
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE JOB_ID = 'ST_MAN';

-- 문제3) EMPLOYEES 테이블에서 입사일자가 1982년 1월 1일 이후에 입사한
-- 사원의 정보를 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라.
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID
FROM EMPLOYEES
WHERE TO_CHAR(HIRE_DATE, 'YYYYMMDD') > '19820101';

-- 문제4) EMPLOYEES 테이블에서 급여가 3000에서 5000사이의 정보를 성명,
-- 담당업무, 급여, 부서번호를 출력하라. (AND만 사용, BETWEEN도 함께 사용)
SELECT FIRST_NAME, JOB_ID, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE SALARY BETWEEN 3000 AND 5000;

SELECT FIRST_NAME, JOB_ID, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE SALARY >= 3000
  AND SALARY <= 5000;


-- 문제5) EMPLOYEES 테이블에서 사원번호가 145,152,203인 사원의 정보를
-- 사원번호, 성명, 담당업무, 급여, 입사일자를 출력하라. (IN만 사용, OR만 사용)
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, HIRE_DATE
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN (145, 152, 203);

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, HIRE_DATE
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 145
   OR EMPLOYEE_ID = 152
   OR EMPLOYEE_ID = 203;

-- 문제6) EMPLOYEES 테이블에서 입사일자가 05년도에 입사한 사원의 정보를
-- 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라. (LIKE 사용)
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID
FROM EMPLOYEES
WHERE TO_CHAR(HIRE_DATE, 'YYMMDD') LIKE '05%';

-- 문제7) EMPLOYEES 테이블에서 보너스가 NULL인 사원의 정보를 사원번호,
-- 성명, 담당업무, 급여, 입사일자, 보너스, 부서번호를 출력하라. (IS 사용)
SELECT FIRST_NAME, JOB_ID, SALARY, HIRE_DATE, COMMISSION_PCT, DEPARTMENT_ID
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NULL;

-- 문제8) EMPLOYEES 테이블에서 급여가 1100이상이고 JOB이 Manager인
-- 사원의 정보를 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라 (AND사용, ST_MAN)
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID
FROM EMPLOYEES
WHERE SALARY >= 1100
  AND JOB_ID = 'ST_MAN';

-- 문제9) EMPLOYEES 테이블에서 급여가 10000이상이거나 JOB이 Manager인
-- 사원의 정보를 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라 (OR사용, ST_MAN)
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID
FROM EMPLOYEES
WHERE SALARY >= 10000
   OR JOB_ID = 'ST_MAN';

-- 문제10) EMPLOYEES 테이블에서 급여가 JOB이 ST_MAN, SA_MAN, SA_REP
-- 가 아닌 사원의 정보를 사원번호, 성명, 담당업무, 급여, 부서번호를 출력하라 (NOT IN 사용)
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE JOB_ID NOT IN ('ST_MAN', 'SA_MAN', 'SA_REP');

-- 문제11) 업무가 PRESIDENT이고 급여가 12000이상이거나 업무가
-- SALESMAN인 사원의 정보를 사원번호, 이름, 업무, 급여를 출력하라.
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE (JOB_ID = 'AD_PRES'
    AND SALARY >= 12000)
   OR JOB_ID = 'SA_MAN';

-- 문제12) 업무가 PRESIDENT또는 SALESMAN이고 급여가 12000이상이거나
-- 사원의 정보를 사원번호, 이름, 업무, 급여를 출력하라.
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE JOB_ID IN ('AD_PRES', 'SA_MAN')
  AND SALARY >= 12000;

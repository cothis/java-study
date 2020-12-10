/*
    Sub Query 서브쿼리
    Query 안의 Query

    SELECT 단일 row, 단일 column
    FROM   다중 row, 다중 column
    WHERE  다중 row, 다중 column
*/

/* SELECT */
SELECT EMPLOYEE_ID,
       FIRST_NAME,
       (SELECT FIRST_NAME FROM EMPLOYEES WHERE EMPLOYEE_ID = 100)
FROM EMPLOYEES;

-- COLUMN 1 ROW 5 : X
SELECT EMPLOYEE_ID, FIRST_NAME, (SELECT FIRST_NAME FROM EMPLOYEES WHERE JOB_ID = 'IT_PROG')
FROM EMPLOYEES;

-- COLUMN 2, ROW 1 : X
SELECT EMPLOYEE_ID,
       FIRST_NAME,
       (SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE EMPLOYEE_ID = 100)
FROM EMPLOYEES;

SELECT EMPLOYEE_ID,
       FIRST_NAME,
       (SELECT COUNT(*) FROM EMPLOYEES)
FROM EMPLOYEES;


/* FROM */
SELECT *
FROM (SELECT EMPLOYEE_ID AS EMPNO, FIRST_NAME, SALARY
      FROM EMPLOYEES
      WHERE JOB_ID = 'IT_PROG')
WHERE SALARY > 5000;

-- 부서번호 50번, 급여 6000이상인 사원
SELECT *
FROM (SELECT *
      FROM EMPLOYEES
      WHERE DEPARTMENT_ID = 50)
WHERE SALARY >= 6000;

-- 급여의 합계, 인원수, 사원명, 월급

-- GROUP BY 에서 사원명과 월급을 뽑기 힘들다
SELECT SUM(SALARY), COUNT(*)
FROM EMPLOYEES
GROUP BY JOB_ID;

SELECT E.FIRST_NAME, E.SALARY, E.JOB_ID, J.JOB_ID, J.SALSUM, J.JOBCOUNT
FROM EMPLOYEES E
         INNER JOIN (SELECT JOB_ID, SUM(SALARY) SALSUM, COUNT(*) AS JOBCOUNT
                     FROM EMPLOYEES
                     GROUP BY JOB_ID) J
                    ON E.JOB_ID = J.JOB_ID;


/* WHERE */
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES);

-- DEPARTMENT_ID = 90 의 JOB_ID 출력
SELECT JOB_ID
FROM EMPLOYEES
WHERE JOB_ID IN (SELECT JOB_ID FROM EMPLOYEES WHERE DEPARTMENT_ID = 90);

-- 부서별로 가장 월급을 적게 받는 사원과 같은 급여를 받는 사원
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE SALARY IN (SELECT MIN(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID)

-- 부서별로 가장 월급을 적게 받는 사원명과 월급
SELECT DEPARTMENT_ID, MIN(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID;

SELECT DEPARTMENT_ID, FIRST_NAME, SALARY FROM EMPLOYEES
WHERE (DEPARTMENT_ID, SALARY) IN (SELECT DEPARTMENT_ID, MIN(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID)
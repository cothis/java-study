-- 문제1) EMPLOYEES 테이블과 DEPARTMENTS 테이블을 Cartesian
-- Product(모든 가능한 행들의 Join)하여 사원번호,이름,업무,부서번호,부서명,
-- 근무지를 출력하여라.
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.JOB_ID, D.DEPARTMENT_ID, D.DEPARTMENT_NAME, D.LOCATION_ID
FROM EMPLOYEES E,
     DEPARTMENTS D;

-- 문제2) EMPLOYEES 테이블에서 사원번호,이름,업무, EMPLOYEES 테이블의
-- 부서번호, DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라.
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.JOB_ID, E.DEPARTMENT_ID, D.DEPARTMENT_ID, D.DEPARTMENT_NAME, D.LOCATION_ID
FROM EMPLOYEES E
         INNER JOIN DEPARTMENTS D on D.DEPARTMENT_ID = E.DEPARTMENT_ID;

-- 문제3) Alexander Hunold 의 부서명을 출력하라.
SELECT D.DEPARTMENT_NAME
FROM EMPLOYEES E
         INNER JOIN DEPARTMENTS D on D.DEPARTMENT_ID = E.DEPARTMENT_ID
WHERE E.FIRST_NAME = 'Alexander'
  and E.LAST_NAME = 'Hunold';

-- 문제4) 세일즈 부서에서 근무하고 있는 사람들을 출력하라.
SELECT *
FROM EMPLOYEES E
         INNER JOIN DEPARTMENTS D on D.DEPARTMENT_ID = E.DEPARTMENT_ID
WHERE D.DEPARTMENT_NAME = 'Sales';

-- 문제5) EMPLOYEES 테이블과 DEPARTMENTS 테이블의 부서번호를 조인하고
-- SA_MAN 사원만의 사원번호,이름,급여,부서명,근무지를 출력하라.
-- (Alias를 사용)
SELECT E.EMPLOYEE_ID 사원번호, E.FIRST_NAME 이름, E.SALARY 급여, D.DEPARTMENT_NAME 부서명, D.LOCATION_ID 근무지
FROM EMPLOYEES E
         INNER JOIN DEPARTMENTS D on D.DEPARTMENT_ID = E.DEPARTMENT_ID
WHERE JOB_ID = 'SA_MAN';

-- 문제6) EMPLOYEES 테이블과 DEPARTMENTS 테이블에서 DEPARTMENTS 테
-- 이블에 있는 모든 자료를 사원번호,이름,업무, EMPLOYEES 테이블의 부서번
-- 호, DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라
-- (Outer Join)
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.JOB_ID, E.DEPARTMENT_ID, D.DEPARTMENT_ID, D.DEPARTMENT_NAME, D.LOCATION_ID
FROM EMPLOYEES E
         RIGHT JOIN DEPARTMENTS D on D.DEPARTMENT_ID = E.DEPARTMENT_ID;

-- 문제7) EMPLOYEES 테이블에서 Self join하여 관리자(매니저)를 출력하여라.
SELECT A.EMPLOYEE_ID 사원, A.FIRST_NAME 사원이름, B.EMPLOYEE_ID 상사, B.FIRST_NAME 상사이름
FROM EMPLOYEES A LEFT JOIN EMPLOYEES B ON A.MANAGER_ID = B.EMPLOYEE_ID

-- 문제8) EMPLOYEES 테이블에서 left join하여 관리자(매니저)를 출력하고
-- 매니저 아이디가 없는 사람은 배제하고 하향식으로 하며, 급여는 역순으로
-- 출력하라.
SELECT A.EMPLOYEE_ID, LPAD(' ', (LEVEL - 1) * 2) || A.FIRST_NAME, B.EMPLOYEE_ID, B.FIRST_NAME, A.SALARY
FROM EMPLOYEES A
         LEFT JOIN EMPLOYEES B ON A.MANAGER_ID = B.EMPLOYEE_ID
WHERE A.MANAGER_ID IS NOT NULL
CONNECT BY A.MANAGER_ID = PRIOR A.EMPLOYEE_ID
ORDER SIBLINGS BY SALARY DESC;

-- 문제9) EMPLOYEES 테이블에서 right join하여 관리자(매니저)가 108번
-- 상향식으로 급여는 역순으로 출력하라.
SELECT B.EMPLOYEE_ID, LPAD(' ', (LEVEL - 1) * 2) || B.FIRST_NAME, A.EMPLOYEE_ID, A.FIRST_NAME, B.SALARY
FROM EMPLOYEES A
         RIGHT JOIN EMPLOYEES B ON A.EMPLOYEE_ID = B.MANAGER_ID
WHERE B.MANAGER_ID = 108
CONNECT BY PRIOR B.MANAGER_ID = B.EMPLOYEE_ID
ORDER SIBLINGS BY SALARY DESC;


-- 문제10) 각 직원의 직업이름(줄임말 말고)과 부서번호, 부서명, 부서의 우편번호를 출력해보시오~
SELECT E.FIRST_NAME, J.JOB_TITLE, D.DEPARTMENT_ID, D.DEPARTMENT_NAME, L.POSTAL_CODE
FROM EMPLOYEES E
INNER JOIN JOBS J ON E.JOB_ID = J.JOB_ID
INNER JOIN DEPARTMENTS D on E.DEPARTMENT_ID = D.DEPARTMENT_ID
INNER JOIN LOCATIONS L on D.LOCATION_ID = L.LOCATION_ID


SELECT e.first_name || ' ' || e.last_name AS NAME,
       j.job_title, d.department_id, d.department_name,
       l.postal_code
FROM employees e
         INNER JOIN departments d ON e.department_id = d.department_id
    INNER JOIN jobs j ON e.job_id = j.job_id
    INNER JOIN locations l ON d.location_id = l.location_id;
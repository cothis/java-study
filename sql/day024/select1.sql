-- DML
-- insert delete select(90%) update

/*
    Query
        Dao                 <- Database(Container)
            list <- file
            save -> file
        Dto

    SELECT (값, column, 함수, sub query)
    FROM (Table, sub query)
*/

SELECT 1 FROM DUAL;

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES;

SELECT EMPLOYEE_ID AS "사원 번호", FIRST_NAME as 이름, SALARY 월급
FROM EMPLOYEES;

SELECT EMPLOYEE_ID || FIRST_NAME || SALARY
FROM EMPLOYEES;

SELECT FIRST_NAME, LAST_NAME, SALARY, SALARY * 12 AS 연봉
FROM EMPLOYEES;






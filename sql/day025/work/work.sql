-- 1) EMP 테이블에서 사원번호, 사원이름, 월급을 출력하시오.
SELECT EMPNO, ENAME, SAL
FROM EMP;


-- 2) EMP 테이블에서 사원이름과 월급을 출력하는데 컬럼명은 이 름, 월 급으로 바꿔서 출력하시오.
SELECT ENAME AS "이 름", SAL AS "월 급"
FROM EMP;


-- 3) EMP 테이블에서 사원번호, 사원이름, 월급, 연봉을 구하고 각각 컬럼명은 사원번호, 사원이름, 월급, 연봉으로 출력하시오.
SELECT EMPNO AS 사원번호, ENAME AS 사원이름, SAL AS 월급, SAL * 12 AS 연봉
FROM EMP;

-- 4) EMP 테이블의 업무(JOB)을 중복되지 않게 표시하시오.
SELECT DISTINCT JOB
FROM EMP;

-- 5) EMP 테이블의 사원명과 업무로 연결(SMITH, CLERK)해서 표시하고 컬럼명은 Employee and Job 으로 표시하시오.
SELECT ENAME || ', ' || EMP.JOB AS "Employee and Job"
FROM EMP;
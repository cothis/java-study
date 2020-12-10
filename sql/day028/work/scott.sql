-- 37)DECODE 또는 CASE WHEN THEN 함수를 사용하여 다음 데이터에 따라 JOB열의 값을 기준으로
-- 모든 사원의 등급을 표시하시오.
--
-- 업무        등급
-- PRESIDENT   A
-- ANALYST     B
-- MANAGER     C
-- SALESMAN    D
-- CLERK       E
-- 기타         0

SELECT EMPNO,
       ENAME,
       JOB,
       DECODE(JOB,
              'PRESIDENT', 'A',
              'ANALYST', 'B',
              'MANAGER', 'C',
              'SALESMAN', 'D',
              'CLERK', 'E',
              '0') JOB_GRADE
FROM EMP;

-- -- 60) BLAKE와 같은 부서에 있는 사원들의 이름과 입사일을 구하는데
-- -- BLAKE는 제외하고 출력하시오.(BLAKE가 여러명일 수 있음)
SELECT ENAME, HIREDATE
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO
                FROM EMP
                WHERE ENAME = 'BLAKE')
  AND ENAME != 'BLAKE';

-- -- 61) 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을 출력하는데
-- -- 월급이 높은 사람순으로 출력하시오.
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (
    SELECT AVG(SAL)
    FROM EMP)
ORDER BY SAL DESC;

-- -- 62) 10번부서에서 급여를 가장 적게 받는 사원과 동일한 급여를 받는 사원의 이름을 출력하시오.
SELECT ENAME
FROM EMP
WHERE SAL IN (
    SELECT SAL
    FROM EMP
    WHERE DEPTNO = 10);

-- -- 63) 사원수가 3명이 넘는 부서의 부서명과 사원수를 출력하시오.
SELECT DNAME, ECOUNT
FROM DEPT
         INNER JOIN (SELECT DEPTNO, COUNT(*) ECOUNT FROM EMP GROUP BY DEPTNO) E
                    ON DEPT.DEPTNO = E.DEPTNO
WHERE ECOUNT > 3;

-- -- 64) 사원번호가 7844인 사원보다 빨리 입사한 사원의 이름과 입사일을 출력하시오.
SELECT ENAME, HIREDATE
FROM EMP
WHERE HIREDATE <
      (SELECT HIREDATE
       FROM EMP
       WHERE EMPNO = 7844)

-- -- 65) 직속상사가 KING인 모든 사원의 이름과 급여를 출력하시오.
SELECT ENAME, SAL, MGR
FROM EMP
WHERE MGR =
      (SELECT EMPNO FROM EMP WHERE ENAME = 'KING')

-- -- 66) 20번 부서에서 가장 급여를 많이 받는 사원과 동일한 급여를 받는
-- -- 사원의 이름과 부서명,급여, 급여등급을 출력하시오.(emp, dept, salgrade)
SELECT ENAME, DNAME, SAL, S.GRADE
FROM EMP
         INNER JOIN DEPT D on EMP.DEPTNO = D.DEPTNO
         INNER JOIN SALGRADE S ON SAL BETWEEN S.LOSAL AND S.HISAL
WHERE SAL = (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 20)

-- --67) 총급여sal+comm가 평균 급여보다 많은 급여를 받는 사람의 부서번호, 이름, 총급여,
-- --    커미션을 출력하시오.(커미션은 유(O),무(X)로 표시하고 컬럼명은 "comm유무" 출력)
SELECT DEPTNO,
       ENAME,
       SAL + NVL(COMM, 0),
       NVL2(COMM, CASE
                      WHEN COMM <> 0 THEN '유'
                      ELSE '무' END, '무') COMM유무
FROM EMP
WHERE SAL + NVL(COMM, 0) >
      (SELECT AVG(SAL) FROM EMP);

-- -- 68) CHICAGO 지역에서 근무하는 사원의 평균 급여보다 높은 급여를 받는 사원의 이름과 급여,
-- --    지역명을 출력하시오.
SELECT ENAME, SAL, LOC
FROM EMP
         INNER JOIN DEPT D on D.DEPTNO = EMP.DEPTNO
WHERE SAL >
      (SELECT AVG(E.SAL)
       FROM DEPT
                INNER JOIN EMP E on DEPT.DEPTNO = E.DEPTNO
       WHERE LOC = 'CHICAGO');

-- -- 69) 업무가 SALESMAN인 직원이 2명 이상인 부서의 이름, 근무하는 사원의 이름, 업무를 출력
-- --    하시오.(컬럼명은 부서명, 사원명, 업무로 출력)
SELECT DNAME 부서명, ENAME 사원명, JOB 업무
FROM EMP E
         INNER JOIN DEPT D on D.DEPTNO = E.DEPTNO
WHERE E.DEPTNO = (
    SELECT DEPTNO
    FROM EMP
    WHERE JOB = 'SALESMAN'
    GROUP BY DEPTNO
    HAVING COUNT(*) >= 4);

-- -- 70) 커미션이 없는 사원들 중 월급이 가장 높은 사원의 이름과 급여등급을 출력하시오.
SELECT ENAME, GRADE
FROM EMP E
         INNER JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE SAL = (
    SELECT MAX(SAL) MAXSAL
    FROM (
             SELECT SAL
             FROM EMP
             WHERE COMM IS NOT NULL
               AND COMM <> 0))

-- -- 71) SMITH의 관리자의 이름과 부서명, 근무지역을 출력하시오.
SELECT ENAME, DNAME, LOC
FROM EMP E
         INNER JOIN DEPT D on D.DEPTNO = E.DEPTNO
WHERE EMPNO =
      (SELECT MGR
       FROM EMP
       WHERE ENAME = 'SMITH')
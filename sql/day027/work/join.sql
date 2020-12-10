-- 50) 모든 사원의 이름, 부서번호, 부서이름을 표시하시오.(emp,dept)
SELECT E.ENAME, D.DEPTNO, D.DNAME
FROM EMP E
         INNER JOIN DEPT D on D.DEPTNO = E.DEPTNO;

--51) 업무가 MANAGER인 사원의 정보를 이름,업무,부서명,근무지 순으로
--    출력하시오.(emp,dept)
SELECT E.ENAME, E.JOB, D.DNAME, D.LOC
FROM EMP E
         INNER JOIN DEPT D on D.DEPTNO = E.DEPTNO
WHERE JOB = 'MANAGER';

-- 52) 커미션을 받고 급여가 1,600이상인 사원의 사원이름,부서명,근무지를 출력하시오
SELECT E.ENAME, D.DNAME, D.LOC, E.SAL, E.COMM
FROM EMP E
         INNER JOIN DEPT D on D.DEPTNO = E.DEPTNO
WHERE SAL >= 1600 and E.COMM IS NOT NULL AND E.COMM <> 0;

-- 53) 근무지가 CHICAGO인 모든 사원의 이름,업무,부서번호 및 부서이름을 표시하시오.
SELECT E.ENAME, E.JOB, D.DEPTNO, D.DNAME
FROM EMP E
         LEFT JOIN DEPT D on D.DEPTNO = E.DEPTNO
WHERE LOC = 'CHICAGO';

-- 54) 근무지별로 근무하는 사원의 수가 5명 이하인 경우, 인원이 적은 도시순으로 정렬하시오.
-- (근무 인원이 0명인 곳도 표시)
SELECT LOC, COUNT(E.EMPNO)
FROM EMP E
         RIGHT JOIN DEPT D on D.DEPTNO = E.DEPTNO
GROUP BY D.LOC
HAVING COUNT(*) <= 3
ORDER BY COUNT(E.EMPNO);

-- 55) 사원의 이름 및 사원 번호를 관리자의 이름과 관리자 번호와 함께 표시하고
-- 각각의 열 레이블은 employee, emp#, manager, mgr#로 지정하시오.
SELECT A.ENAME employee, A.EMPNO emp#, B.ENAME manager, B.EMPNO mgr#
FROM EMP A INNER JOIN EMP B ON A.MGR = B.EMPNO;

-- 56) 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 표시하고 관리자보다 입사일이 빠른 사원을 산출하라.
-- 열 레이블을 각각 employee, emp hired, manager, mgr hired로 지정
SELECT A.ENAME employee, A.HIREDATE "emp hired", B.ENAME manager, B.HIREDATE "mgr hired"
FROM EMP A INNER JOIN EMP B ON A.MGR = B.EMPNO
WHERE A.HIREDATE < B.HIREDATE;

-- 57) 사원의 이름 및 사원번호를 관리자의 이름과 관리자 번호와 함께 표시하고
-- 각각의 열 레이블은 employee, emp#, manager, mgr#로 지정하는데
-- King을 포함하여 관리자가 없는 모든 사원을 표시하도록 하고
-- 결과를 사원번호를 기준으로 정렬
SELECT A.ENAME employee, A.EMPNO emp#, B.ENAME manager, B.EMPNO mgr#
FROM EMP A LEFT JOIN EMP B ON A.MGR = B.EMPNO
ORDER BY A.EMPNO;

-- 58) 지정한 부서번호, 사원이름 및 지정한 사원과 동일한 부서에서 근무하는
-- 모든 사원을 표시하도록 질의를 작성하고
-- 부서번호는 department, 사원이름은 employee, 동일한 부서에서 근무하는 사원은 colleague로 표시하시오.
-- (부서번호, 사원이름,동료 순으로 오름차순 정렬)
SELECT D.DEPTNO department, A.ENAME employee, B.ENAME colleage
FROM EMP A
         INNER JOIN EMP B ON A.DEPTNO = B.DEPTNO AND A.EMPNO != B.EMPNO
         INNER JOIN DEPT D on D.DEPTNO = A.DEPTNO
ORDER BY D.DEPTNO, A.ENAME, B.ENAME;

-- 59)10번 부서에서 근무하는 사원들의
-- 부서번호, 부서이름, 사원이름, 월급, 급여등급을 출력하시오.
SELECT D.DEPTNO, D.DNAME, E.ENAME, E.SAL, S.GRADE
FROM EMP E
         INNER JOIN DEPT D on E.DEPTNO = D.DEPTNO
         INNER JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE D.DEPTNO = 10;

SELECT D.DEPTNO, D.DNAME, E.ENAME, E.SAL, S.GRADE
FROM EMP E,
     DEPT D,
     SALGRADE S
WHERE E.DEPTNO = D.DEPTNO
  and E.SAL between S.LOSAL and S.HISAL
  and D.DEPTNO = 10;


-- 58) 부서번호, 사원이름 및 사원과 동일한 부서에서 근무하는
-- 모든 사원을 표시하도록 질의를 작성하고
-- 부서번호는 department, 사원이름은 employee, 동일한 부서에서 근무하는 사원은 colleague로 표시하시오.
-- (부서번호, 사원이름,동료 순으로 오름차순 정렬)

SELECT DEPTNO, listagg(ename, ', ') within group (order by ename) as names
FROM EMP
group by DEPTNO


SELECT LISTAGG(ename, ',') WITHIN GROUP(ORDER BY ename) AS names
FROM emp
WHERE job = 'MANAGER'






















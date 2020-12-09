-- 23) emp테이블의 업무(job)을 첫글자는 대문자 나머지는 소문자로 출력하시오.
SELECT initcap(JOB)
FROM EMP;

SELECT UPPER(SUBSTR(JOB, 1, 1)) || LOWER(SUBSTR(JOB, -(LENGTH(JOB) - 1)))
FROM EMP;

-- 24) emp테이블에서 사원이름 중 A가 포함된 사원이름을 구하고 그 이름 중 앞에서 3자만 추출하여 출력
SELECT SUBSTR(ENAME, 1, 3)
FROM EMP
WHERE ENAME LIKE '%A%'

-- 25) 이름의 세번째 문자가 A인 모든 사원의 이름을 표시하시오.
SELECT ENAME
FROM EMP
WHERE ENAME LIKE '__A%';

-- 26) 이름이 J,A 또는 M으로 시작하는 모든 사원의 이름(첫 글자는 대문자로, 나머지 글자는 소문자로
--     표시) 및 이름의 길이를 표시하시오.(열 레이블은 name과 length로 표시)
SELECT INITCAP(ENAME) name, LENGTH(ENAME) length
FROM EMP
WHERE ENAME LIKE 'J%'
   OR ENAME LIKE 'A%'
   OR ENAME LIKE 'M%';

-- 27) 이름의 글자수가 6자 이상인 사원의 이름을 소문자로 이름만 출력하시오
SELECT LOWER(ENAME)
FROM EMP
WHERE LENGTH(ENAME) >= 6;

-- 28) 이름의 글자수가 6자 이상인 사람의 이름을 앞에서 3자만 구하여 소문자로 출력하시오.
SELECT LOWER(SUBSTR(ENAME, 1, 3))
FROM EMP
WHERE LENGTH(ENAME) >= 6;

-- 29) 모든 사원의 이름과 급여를 표시하시오. 급여는 15자 길이로 왼쪽에 $기호가 채워진 형식으로
--     표기하고 열레이블을 SALARY로 지정하시오.
SELECT ENAME, TO_CHAR(SAL, '$99999999999999') AS SALARY
FROM EMP

SELECT ENAME, LPAD(SAL, 15, '$') SALARY
FROM EMP;

-- 30) 오늘부터 이번달의 마지막날까지의 남은 날 수를 구하시오.
SELECT LAST_DAY(SYSDATE) - SYSDATE
FROM DUAL

-- 31) emp테이블에서 각 사원에 대해 사원번호, 이름, 급여 및 15% 인상된 급여를 정수(반올림)로 표시하시오.
--     인상된 급여열의 레이블을 New Salary로 지정하시오.
SELECT EMPNO, ENAME, SAL, ROUND(SAL * 1.15) AS "New Salary"
FROM EMP;

-- 32) emp테이블에서 월급의 4의 배수(mod(sal,4)=0)인 사원의 이름과 월급을 출력하시오.(세자리 단위 쉼표 표시)
SELECT ENAME, TO_CHAR(SAL, 'FM999,999')
FROM EMP
WHERE MOD(SAL,4) = 0;

-- 33) 각 사원의 이름을 표시하고 근무 달 수(입사일로부터 현재까지의 달수)를 계산하여
-- 열 레이블을 MONTHS_WORKED로 지정하시오. 결과는 정수로 반올림하여 표시하고 근무달 수를
-- 기준으로 오름차순으로 정렬하시오.
SELECT ENAME, ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE)) AS MONTHS_WORKED
FROM EMP
ORDER BY MONTHS_WORKED;

-- 34)emp테이블에서 이름, 업무, 근무연차를 출력하시오.
SELECT ENAME, JOB, TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(HIREDATE, 'YYYY') + 1
FROM EMP

-- 35)emp테이블에서 사원이름, 월급, 월급과 커미션을 더한 값을 컬럼명 실급여라고 해서 출력.
-- 단, NULL값은 나타나지 않게 작성하시오.
SELECT ENAME, SAL, SAL + NVL(COMM, 0) 실급여
FROM EMP

-- 36)월급과 커미션을 합친 금액이 2,000이상인 급여를 받는 사원의 이름,업무,월급,커미션,고용날짜
-- 를 출력하시오. 단, 고용날짜는 1980-12-17 형태로 출력하시오.
SELECT ENAME, JOB, SAL, NVL(COMM, 0), TO_CHAR(HIREDATE, 'YYYY-MM-DD')
FROM EMP
WHERE SAL + NVL(COMM, 0) >= 2000;

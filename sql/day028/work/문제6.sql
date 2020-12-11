-- 문제6) EMPLOYEES 테이블에서 가장 많은 사원을 갖는 MANAGER의
-- 사원번호를 출력하라.

-- 매니저를 가지고 GROUP BY를 하면 같은 MANAGER를 가진 사원들의 숫자를 알 수 있다.
SELECT MANAGER_ID, COUNT(*)
FROM EMPLOYEES
GROUP BY MANAGER_ID;

-- 여기서 가장 많은 숫자는 14를 볼 수 있다.
-- 그런데 14을 얻으려면 GROUP 함수 MAX를 써야 한다.
SELECT MAX(COUNT(*))
FROM EMPLOYEES
GROUP BY MANAGER_ID;
-- 이게 된다면 정말 편했겠지만, 그룹 함수를 연속해서 쓸수가 없다..MANAGER_ID때문에!
-- MANAGER_ID를 빼면 연속해서도 쓸수가 있다.
-- 왜냐하면 MANAGER_ID 로 GROUP BY를 하면 MANAGER가 19명이 나오는데 MAX를 걸면 ROW를 1개만 표시해야되기 때문

-- 그러면 이 두 쿼리를 합쳐보자
-- 지금 하려는 방법은 위의 카운트를 얻는 쿼리를 대상으로 하고
-- 조건으로 COUNT가 14인 행을 찾으려고 한다.

-- 우선 간단하게 14인 항목을 찾아본다.
SELECT MANAGER_ID, COUNT(*)
FROM EMPLOYEES
GROUP BY MANAGER_ID WHERE COUNT(*) = 14;
-- 젠장 이것도 안된다. WHERE 절에 그룹함수가 들어갈수 없기때문에

-- 그렇다면 위의 쿼리를 서브쿼리로 쓰는 간단한 문장을 작성해보겠당
SELECT MANAGER_ID
FROM (SELECT MANAGER_ID, COUNT(*) EMP_COUNT -- 외부에서 접근을 위해 ALIAS 설정
      FROM EMPLOYEES
      GROUP BY MANAGER_ID)
WHERE EMP_COUNT = 14;
-- 원하는 결과를 얻을 수 있다!

-- 근데 14를 받아올 수 있는 쿼리가 위에 만들어져있다. 밑으로 복사해왔다.
SELECT MAX(COUNT(*))
FROM EMPLOYEES
GROUP BY MANAGER_ID;

-- 이 쿼리의 출력값은 14가 나오니까 윗쪽의 상수 14에 이 쿼리를 넣어보자
SELECT MANAGER_ID
FROM (SELECT MANAGER_ID, COUNT(*) EMP_COUNT -- 외부에서 접근을 위해 ALIAS 설정
      FROM EMPLOYEES
      GROUP BY MANAGER_ID)
WHERE EMP_COUNT = (SELECT MAX(COUNT(*))
                   FROM EMPLOYEES
                   GROUP BY MANAGER_ID);

-- 원하는 결과 출력 성공!

SELECT A.MANAGER_ID
FROM (SELECT MANAGER_ID, COUNT(*) EMP_COUNT -- 외부에서 접근을 위해 ALIAS 설정
      FROM EMPLOYEES
      GROUP BY MANAGER_ID) A
         INNER JOIN
     (SELECT MAX(COUNT(*)) MAX_COUNT
      FROM EMPLOYEES
      GROUP BY MANAGER_ID) M
     ON A.EMP_COUNT = M.MAX_COUNT


-- FROM - WHERE - GROUP BY - HAVING - SELECT - ORDER BY

-- ROWNUM
SELECT ROWNUM, MANAGER_ID
FROM (
         SELECT MANAGER_ID, COUNT(*) EMP_COUNT -- 외부에서 접근을 위해 ALIAS 설정
         FROM EMPLOYEES
         GROUP BY MANAGER_ID
         ORDER BY EMP_COUNT DESC)
WHERE ROWNUM < 10;



-- ROW_NUMBER()

-- ROW_NUMBER() OVER (ORDER BY / PARTITION BY 컬럼? ) alias

SELECT MANAGER_ID
FROM (SELECT ROW_NUMBER() OVER (ORDER BY COUNT(*) DESC) ROW_COUNT, MANAGER_ID, COUNT(*)
      FROM EMPLOYEES
      GROUP BY MANAGER_ID)
WHERE ROW_COUNT = 1;

-- 오늘의 방송은 여기까지~







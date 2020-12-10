/*
    특수 쿼리

    CASE
    DECODE


*/


-- CASE => SWITCH
SELECT EMPLOYEE_ID,
       FIRST_NAME,
       PHONE_NUMBER,
       CASE SUBSTR(PHONE_NUMBER, 1, 3)
           WHEN '515' THEN '서울'
           WHEN '590' THEN '부산'
           WHEN '659' THEN '광주'
           WHEN '603' THEN '강릉'
           ELSE '기타'
       END
FROM EMPLOYEES;

SELECT EMPLOYEE_ID,
       FIRST_NAME,
       PHONE_NUMBER,
       CASE
           WHEN SUBSTR(PHONE_NUMBER, 1, 3) = '515' THEN '서울'
           WHEN SUBSTR(PHONE_NUMBER, 1, 3) = '590' THEN '부산'
           WHEN SUBSTR(PHONE_NUMBER, 1, 3) = '659' THEN '광주'
           WHEN SUBSTR(PHONE_NUMBER, 1, 3) = '603' THEN '강릉'
           ELSE '기타'
           END
FROM EMPLOYEES;

-- DECODE
SELECT EMPLOYEE_ID,
       FIRST_NAME,
       PHONE_NUMBER,
       DECODE(SUBSTR(PHONE_NUMBER, 1, 3),
              '515', '서울',
              '590', '부산',
              '659', '광주',
              '603', '강릉',
              '기타'
           )
FROM EMPLOYEES;

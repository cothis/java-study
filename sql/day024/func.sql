-- Standard Function

-- dual table : 가상 테이블 -> 결과 확인용 임시 테이블
SELECT 1 from DUAL;
select 'A' from dual;
select '가' from dual;
select 23*34 from dual;

-- 문자 함수
-- CHR (N) : ASCII 값을 문자로 변환
select chr(65) from dual;
select chr(97) from dual;

-- 자바에서는 "안녕하세요" + "건강하세요" = "안녕하세요건강하세요"
-- 문자열 연결 '문자열'||'문자열'
select '안녕하세요'||'건강하세요' from dual;
select '내점수는 ' || chr(65) || '입니다' from dual;

-- LPAD(RPAD) : 빈칸을 지정문자로 채운다
SELECT lpad('BBB', 10) from DUAL;
select rpad('BBB', 10) from dual;
select lpad('BBB', 10, '-') from DUAL;

-- INSTR == indexOf
select instr('123ABC456ABC', 'A') from DUAL;
select instr('123ABC456ABC', 'A', 6) from DUAL;
select instr('123ABC456ABC', 'A', 6, 1) from DUAL;
select instr('123ABC456ABCABC', 'A', 6, 2) from DUAL;
select instr('123ABC456ABC', 'D') from DUAL;

-- REPLACE : 문자열 치환
select replace('AAAAABC', 'A') from dual;
select replace('AAAAABC', 'A', 'a') from dual;
select replace('AAAAABC', 'AA', 'a') from dual;

-- TRANSLATE : 문자 치환(문자열X) 비교문자, 변환문자가 문자열이 아님
select translate('AAAAABC', 'A', 'a') from dual;
select translate('AAAAABC', 'AA', 'a') from dual;

-- 숫자
-- 올림
select ceil(13.1) from DUAL;

-- 내림
select floor(13.9) from DUAL;

-- 반올림
select round(13.6) from DUAL;

-- 제곱
select POWER(3, 4) from DUAL;

-- 부호(양수: 1 / 0: 0 / 음수: -1)
select sign(12) from dual;
select sign(0) from dual;
select sign(-15) from dual;

-- 버림
select trunc(12.34567) from dual;
select trunc(12.34567, 2) from dual;
select trunc(12.34567, -1) from dual;

-- ASCII
select ASCII('A') from dual;

-- 변환함수
-- TO_CHAR (DATE --> VARCHAR2)
select to_char(sysdate) from DUAL;
select sysdate from DUAL;
select to_char(sysdate, 'YYYY-MM-DD HH:MI:SS') from dual;
select to_char(sysdate, 'YYYY/MM/DD HH:MI:SS') from dual;
select to_char(to_date('20201225 12-33-29','YYYYMMDD HH-MI-SS'), 'YYYY/MM/DD HH:MI:SS') from dual;
select to_char(10000000000, '$999,999,999,999') from DUAL;

-- TO_DATE (VARCHAR2 --> DATE)
select to_date('20201205', 'YYYYMMDD') from dual;
select to_date('12052020', 'MMDDYYYY') from dual;

-- TO_NUMBER (VARCHAR2 --> NUMBER)     Integer.parseInt()
select '123' + 1 from DUAL;
select to_number('123') + 1 from DUAL;

-- LAST_DAY
select last_day('20/11/01') from DUAL;

-- SUBSTR
select substr('ABCDEFG', 3) from DUAL;
select substr('ABCDEFG', 3, 3) from DUAL;
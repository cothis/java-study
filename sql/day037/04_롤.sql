/* ********* 역할(롤 ROLE) ***********
역할(롤, ROLE) : DB 객체 및 시스템에 대한 권한을 모아둔 집합을 의미
역할 생성 : CREATE ROLE 역할이름
역할 제거 : DROP ROLE 역할이름
역할에 권한 부여 : GRANT 권한 [ON 객체] TO 역할이름
역할의 권한 회수 : REVOKE 권한 [ON 객체] FROM 역할이름
사용자에게 역할 부여 : GRANT 역할이름 TO 사용자

<역할 생성부터 사용자 추가까지의 단계>
CREATE ROLE - 역할생성
GRANT - 만들어진 역할에 권한 부여
GRANT - 사용자에게 역할 부여
-->>역할 제거할 경우 반대로 수행
DROP ROLE - 역할 삭제(사용자에게 부여된 역할에 대한 권한 역시 제거됨)
***************************************/

-- 사용자 계정에서 역할(롤) 조회
select * from USER_ROLE_PRIVS;

-- (System) connect, resource 롤에 대한 권한 확인
select * from DBA_SYS_PRIVS where GRANTEE in ('CONNECT', 'RESOURCE')
order by GRANTEE, PRIVILEGE;

-- (System) 롤(ROLE) 생성 : PROGRAMMER(개발자)
CREATE ROLE PROGRAMMER;
GRANT CREATE ANY TABLE, CREATE ANY VIEW TO PROGRAMMER;

CREATE USER MDGUEST IDENTIFIED BY mdguest
default tablespace users
temporary tablespace temp;

grant connect, resource to mdguest;

grant programmer to mdguest; -- MDGUEST 에게 role 부여

-- (MDGUEST) create table
create table HR.aaa
(
    AAA number
);

-- (System) 롤(권한) 회수(취소)
revoke programmer from mdguest;

-- (System) 롤(ROLE) 삭제
drop role PROGRAMMER;
/* ********* 사용자 생성, 삭제 *********
-- 사용자 생성 : CREATE USER
CREATE USER 사용자명(유저명) --"MDGUEST"
IDENTIFIED BY 비밀번호 --"mdguest"
DEFAULT TABLESPACE 테이블스페이스 --"USERS"
TEMPORARY TABLESPACE 임시작업테이블스페이스 --"TEMP";

-- 사용할 용량 지정(수정)
ALTER USER "MDGUEST" QUOTA UNLIMITED ON "USERS";

-- 사용자 수정 : ALTER USER
ALTER USER 사용자명(유저명) IDENTIFIED BY 비밀번호;

-- 권한부여(롤 사용 권한 부여, 롤 부여)
GRANT "CONNECT" TO "MDGUEST" ;
GRANT "RESOURCE" TO "MDGUEST" ;

-- 사용자 삭제 : DROP USER
DROP USER 유저명 [CASCADE];
--CASCADE : 삭제시점에 사용자(유저)가 보유한 모든 데이타 삭제
*************************************/
create user MDGUEST identified by mdguest
default tablespace USERS
temporary tablespace TEMP;

grant connect, resource to MDGUEST;
grant create view, create synonym to MDGUEST;

-- (SYSTEM) connect, resource 롤(ROLE)에 있는 권한 조회
select * from DBA_SYS_PRIVS
where GRANTEE IN ('CONNECT', 'RESOURCE', 'MDGUEST');

select * from DBA_ROLE_PRIVS where GRANTEE = 'MDGUEST';

select P.GRANTEE, P.PRIVILEGE from DBA_SYS_PRIVS P left join DBA_ROLE_PRIVS R on P.GRANTEE = R.GRANTED_ROLE
where r.GRANTEE = 'MDGUEST' or p.GRANTEE = 'MDGUEST'
order by P.GRANTEE, P.PRIVILEGE;

--=============================
/****** 권한 부여(GRANT), 권한 취소(REVOKE) **********************
GRANT 권한 [ON 객체] TO {사용자|ROLE|PUBLIC,.., n} [WITH GRANT OPTION]
--PUBLIC은 모든 사용자에게 적용을 의미

GRANT 권한 TO 사용자; --권한을 사용자에게 부여
GRANT 권한 ON 객체 TO 사용자; -객체에 대한 권한을 사용자에게 부여
-->> WITH GRANT OPTION :객체에 대한 권한을 사용자에게 부여
-- 권한을 받은 사용자가 다른 사용자에게 권한부여할 권리 포함
GRANT 권한 ON 객체 TO 사용자 WITH GRANT OPTION;
--------------------
-->>>권한 취소(REVOKE)
REVOKE 권한 [ON 객체] FROM {사용자|ROLE|PUBLIC,.., n} CASCADE
--CASCADE는 사용자가 다른 사용자에게 부여한 권한까지 취소시킴
  (확인 및 검증 후 작업)

REVOKE 권한 FROM 사용자; --권한을 사용자에게 해제
REVOKE 권한 ON 객체 FROM 사용자; -객체에 대한 권한을 사용자에게 해제
*************************************************/

-- (SYSTEM) 권한부여 : MADANG 유저의 BOOK 테이블에 대한 SELECT 권한을 MDGUEST에게 부여
grant select on MADANG.BOOK to mdguest;
revoke select on MADANG.BOOK from mdguest;

-- (MDGUEST 예시) CUSTOMER 테이블 select update
-- 권한을 부여받아서 select, update 작업 가능
grant select on madang.customer to mdguest;
select * from madang.customer;
update madang.customer
set phone = '010-1111-2222'
where name = '박세리';

-- (MDGUEST 에서 실행) 권한 부여할 능력까지 같이 주기
grant select on customer to mdguest;
grant select on customer to mdguest with grant option;
revoke select on CUSTOMER from mdguest;

-- (관리자에서) 유저 삭제
drop user MDGUEST cascade;
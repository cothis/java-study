create user WHADMIN identified by whadmin
default tablespace users
temporary tablespace temp;
grant connect, resource to WHADMIN;
grant create view to WHADMIN;
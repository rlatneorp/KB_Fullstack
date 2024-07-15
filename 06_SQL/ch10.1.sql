-- 데이터 베이스 생성
CREATE DATABASE jdbc_ex;

-- CREATE USER : 'jdbc_ex'라는 이름의 사용자 생성 
-- INDENTIFIED BY : 비밀번호를 'jdbc_ex'로 설정
CREATE USER 'jdbc_ex'@'%' IDENTIFIED BY 'jdbc_ex';
-- GRANT ~ ON : 권한 부여하는 명령어
-- ALL PRIVILEGES : 모든 권한 부여
-- 'jdbc_ex'라는 사용자에게 jdbc_ex 데이터베이스 내의 모든 권한 부여
GRANT ALL PRIVILEGES ON jdbc_ex.* TO 'jdbc_ex'@'%';
-- 권한 즉시 서버에 적용
FLUSH PRIVILEGES;
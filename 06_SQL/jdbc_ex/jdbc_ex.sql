-- 데이터베이스 준비
CREATE DATABASE jdbc_ex;
-- 사용자 준비
CREATE USER 'jdbc_ex'@'%' IDENTIFIED BY 'jdbc_ex';
GRANT ALL PRIVILEGES ON jdbc_ex.* TO 'jdbc_ex'@'%';
FLUSH PRIVILEGES;

-- 기본 데이터베이스 설정
use jdbc_ex;
-- USERS 데이터 있는 경우 삭제
DROP TABLE IF EXISTS USERS;
-- USERS 테이블과 컬럼들 생성
CREATE TABLE USERS (
   ID VARCHAR(12) NOT NULL PRIMARY KEY,
   PASSWORD VARCHAR(12) NOT NULL,
   NAME VARCHAR(30) NOT NULL,
   ROLE VARCHAR(6) NOT NULL
);
-- USERS 테이블에 실제 데이터 추가
INSERT INTO USERS(ID, PASSWORD, NAME, ROLE)
VALUES('guest', 'guest123', '방문자', 'USER');
INSERT INTO USERS(ID, PASSWORD, NAME, ROLE)
VALUES('admin', 'admin123', '관리자', 'ADMIN');
INSERT INTO USERS(ID, PASSWORD, NAME, ROLE)
VALUES('member', 'member123', '일반회원', 'USER');
-- USERS 테이블 전체 조회
SELECT * FROM USERS;
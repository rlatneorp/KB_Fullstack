-- 기존에 테이블이 존재하면 삭제함
DROP DATABASE IF EXISTS usertbl;
-- usertbl
CREATE TABLE usertbl(
	userID VARCHAR(8) NOT NULL PRIMARY KEY,
    name CHAR(10) NOT NULL,
    birthyear INT NOT NULL);

-- buytbl    
DROP DATABASE IF EXISTS buytbl;
CREATE TABLE buytbl(
	num INT NOT NULL PRIMARY KEY,
    userID VARCHAR(8) NOT NULL,
    prodName VARCHAR(6) NOT NULL,
	CONSTRAINT FOREIGN KEY(userID) REFERENCES usertbl(userID));

-- 기존 usertbl을 삭제하세요
-- 기존 buytbl 삭제하세요    
DROP TABLE usertbl;
DROP TABLE buytbl;
-- 컬럼
CREATE TABLE usertbl(
	userID VARCHAR(8) NOT NULL PRIMARY KEY,
    name CHAR(10) NOT NULL,
    birthyear INT NOT NULL,
    email VARCHAR(30) NULL UNIQUE);
    
-- 기존 usertbl을 삭제하세요    
DROP TABLE usertbl;
-- 컬럼
CREATE TABLE usertbl(
	userID VARCHAR(8) NOT NULL PRIMARY KEY,
    name CHAR(10) NULL,
    birthyear INT NULL CHECK(birthyear >= 1900 AND birthyear <= 2023),
    mobile VARCHAR(3) NOT NULL);

-- 기존 usertbl을 삭제하세요
DROP TABLE usertbl;

-- 컬럼 정의
CREATE TABLE usertbl(
	userID VARCHAR(8) NOT NULL PRIMARY KEY,
    name CHAR(10) NOT NULL,
    birthyear INT NOT NULL DEFAULT -1,
    addr VARCHAR(2) NOT NULL DEFAULT '서울',
    mobile1 VARCHAR(3) NULL,
    mobile2 VARCHAR(8) NULL,
    height SMALLINT NULL DEFAULT 170,
    mDate DATE NULL);
    
-- 기본값 추가를 확인할 수 있는 데이터를 추가하세요
INSERT INTO usertbl VALUES('HI', '김수대', DEFAULT, DEFAULT, '010', '12344564', DEFAULT, '2024-07-15'); 

-- mobile1 컬럼을 삭제함
ALTER TABLE usertbl DROP COLUMN mobile1;

-- name 컬럼명을 uName으로 변경함
ALTER TABLE usertbl CHANGE COLUMN name uName VARCHAR(20) NULL;

-- 기본키를 제거함
ALTER TABLE usertbl DROP PRIMARY KEY;


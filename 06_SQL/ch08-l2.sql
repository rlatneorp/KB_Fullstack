DROP DATABASE IF EXISTS usertbl;
CREATE TABLE usertbl(
	userID VARCHAR(8) NOT NULL PRIMARY KEY,
    name CHAR(10) NOT NULL,
    birthyear INT NOT NULL);
    
DROP DATABASE IF EXISTS buytbl;
CREATE TABLE buytbl(
	num INT NOT NULL PRIMARY KEY,
    userID VARCHAR(8) NOT NULL,
    prodName VARCHAR(6) NOT NULL,
	CONSTRAINT FOREIGN KEY(userID) REFERENCES usertbl(userID));
    
DROP TABLE usertbl;
DROP TABLE buytbl;

CREATE TABLE usertbl(
	userID VARCHAR(8) NOT NULL PRIMARY KEY,
    name CHAR(10) NOT NULL,
    birthyear INT NOT NULL,
    email VARCHAR(30) NULL UNIQUE);
    
DROP TABLE usertbl;
    
CREATE TABLE usertbl(
	userID VARCHAR(8) NOT NULL PRIMARY KEY,
    name CHAR(10) NULL,
    birthyear INT NULL CHECK(birthyear >= 1900 AND birthyear <= 2023),
    mobile VARCHAR(3) NOT NULL);
    
DROP TABLE usertbl;

CREATE TABLE usertbl(
	userID VARCHAR(8) NOT NULL PRIMARY KEY,
    name CHAR(10) NOT NULL,
    birthyear INT NOT NULL DEFAULT -1,
    addr VARCHAR(2) NOT NULL DEFAULT '서울',
    mobile1 VARCHAR(3) NULL,
    mobile2 VARCHAR(8) NULL,
    height SMALLINT NULL DEFAULT 170,
    mDate DATE NULL);
    
INSERT INTO usertbl VALUES('HI', '김수대', DEFAULT, DEFAULT, '010', '12344564', DEFAULT, '2024-07-15'); 

ALTER TABLE usertbl DROP COLUMN mobile1;

ALTER TABLE usertbl CHANGE COLUMN name uName VARCHAR(20) NULL;

ALTER TABLE usertbl DROP PRIMARY KEY;










    
    
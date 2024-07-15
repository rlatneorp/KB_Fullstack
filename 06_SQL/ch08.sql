-- tabledb 생성, 만약 존재한다면 삭제
DROP DATABASE IF EXISTS tabledb;
CREATE DATABASE tabledb;
-- usertbl 테이블 생성
DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl (
	-- CHAR : 고정문자, NOT NULL : 필수, PRIMARY KEY : 기본 키
	userID CHAR(8) NOT NULL PRIMARY KEY,
    -- VARCHAR : 가변문자
    name VARCHAR(10) NOT NULL,
    -- INT : 정수형
    birthYear INT NOT NULL,
    addr CHAR(2) NOT NULL,
    -- NULL : 옵션
    mobile1 CHAR(3) NULL,
    mobile2 CHAR(8) NULL,
    -- SMALLINT : 작은정수형
    height SMALLINT NULL,
    -- DATE : 날짜형
    mDate DATE NULL
);
-- buytbl 테이블 생성
DROP TABLE IF EXISTS buytbl;
CREATE TABLE buytbl(
-- AUTO_INCREMENT : 인덱스 자동 증가
num INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
userid CHAR(8) NOT NULL,
prodName CHAR(6) NOT NULL,
groupName CHAR(4) NULL,
price INT NOT NULL,
amount SMALLINT NOT NULL,
-- FOREIGN KEY(해당 키) REFERENCES 참조할 테이블(참조할 키)
-- 다른 테이블의 기본키를 참조하는 외래키
FOREIGN KEY(userid) REFERENCES usertbl(userID)
);
-- 회원 테이블 데이터 입력
-- INSERT INTO 테이블명 VALUES(실제 값들...) : 각 컬럼명에 맞는 실제 데이터 추가(행 추가)
INSERT INTO usertbl VALUES('LSG','이승기',1987,'서울','011','1111111',182,'2008-8-8');
INSERT INTO usertbl VALUES('KBS','김범수',1979,'경남','011','2222222',173,'2012-4-4');
INSERT INTO usertbl VALUES('KKH','김경호',1971,'전남','019','3333333',182,'2007-7-7');
-- 구매 테이블 데이터 입력
INSERT INTO buytbl VALUES(NULL,'KBS','운동화',NULL,30,2);
INSERT INTO buytbl VALUES(NULL,'KBS','노트북','전자',1000,1);
-- 외래키 제약 조건 에러 발생 : 참조하고 있는 usertbl의 userID에 'JYP'라는 데이터가 없으므로 발생
INSERT INTO buytbl VALUES(NULL,'JYP','모니터','전자',200,1);


-- 기존 usertbl 삭제
-- usertbl의 기본 키인 userID열은 buytbl에 외래 키로 연결되어 있기 때문에 
-- 외래 키를 제거한 후에 다시 기본 키를 제거해야 함
ALTER TABLE buytbl DROP FOREIGN KEY buytbl_ibfk_1;

DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl(
	userID CHAR(8) NOT NULL,
    name VARCHAR(10) NOT NULL,
    birthyear INT NOT NULL,
-- CONSTRAINT PRIMARY KEY : 기본키 제약조건
CONSTRAINT PRIMARY KEY PK_userTBL_userID(userID));

-- 기존 prodTbl 삭제
DROP TABLE IF EXISTS prodTbl;
CREATE TABLE prodTbl(
	prodCode VARCHAR(3) NOT NULL,
	prodID VARCHAR(4) NOT NULL,
    prodDate DATETIME NOT NULL,
    proCur VARCHAR(10) NULL,
-- 제약조건명은 생략가능
-- prodCode와 prodID 컬럼을 합쳐서 복합키로 기본키를 만들었다    
    CONSTRAINT PK_proTbl_proCode_prodID PRIMARY KEY(prodCode, prodID));












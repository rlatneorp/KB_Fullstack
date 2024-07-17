-- sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl1을 생성하고,
-- 자동 생성된 인덱스 목록을 확인하세요.
USE sqldb;

CREATE TABLE tbl1(
	a INT PRIMARY KEY,
    b INT,
    c INT
);

-- 해당 테이블에 대한 인덱스를 보여줌
-- PRIMARY KEY 제약 조건을 걸면, 해당 속성이 클러스터형 인덱스로 자동 생성됨
SHOW INDEX FROM tbl1;

-- sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl2를 생성하고,
-- 자동 생성된 인덱스 목록을 확인하세요.
CREATE TABLE tbl2(
-- PK는 클러스터형 인덱스 자동 생성, 테이블당 하나만 생서됨
	a INT PRIMARY KEY, 
-- UNIQUE는 보조 인덱스 자동 생성, 보조인덱스는 여러개 생성 가능
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);

SHOW INDEX FROM tbl2;

-- sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl3를 생성하고,
-- 자동 생성된 인덱스 목록을 확인하세요.
CREATE TABLE tbl3(
	a INT UNIQUE,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);

-- UNIQUE 컬럼만 세개기 때문에 보조인덱스만 3개 생성됨
SHOW INDEX FROM tbl3;

-- sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl4를 생성하고,
-- 자동 생성된 인덱스 목록을 확인하세요.
CREATE TABLE tbl4(
-- UNIQUE + NOT NULL은 PK와 동일하게 클러스터형 인덱스로 생성된다.
	a INT UNIQUE NOT NULL,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);
-- a는 클러스터형 인덱스,
-- b,c는 보조형 인덱스
SHOW INDEX FROM tbl4;

-- sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl5를 생성하고,
-- 자동 생성된 인덱스 목록을 확인하세요.
CREATE TABLE tbl5(
	a INT UNIQUE NOT NULL,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT PRIMARY KEY
);

-- 한 테이블에는 무조건 클러스터형 인덱스가 하나만 가능하기 때문에
-- 우선 순위가 높은 PK가 클러서터형 인덱스가 되고
-- 나머지 UNIQUE 값들은 모두 보조형 인덱스가 된다
SHOW INDEX FROM tbl5;

-- testdb에 다음 컬럼 목록을 가지는 usertbl을 만드세요.
-- testtb가 존재하지 않으면 만들어준다,
CREATE DATABASE IF NOT EXISTS testdb;
 
USE tabledb;
 
 -- usertbl이 존재하면 지워주겠다
 DROP TABLE IF EXISTS usertbl;
 CREATE TABLE usertbl(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthyear INT NOT NULL,
    addr NCHAR(2) NOT NULL
);

SHOW INDEX FROM usertbl;
-- 아래 데이터를 추가하고, 클러스터형 인덱스의 테이블 내용을 확인하세요.
INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울'),
						  ('KBS', '김범수', 1979, '경남'),
                          ('KKH', '김경호', 1971, '전남'),
                          ('JYP', '조용필', 1950, '경기'),
                          ('SSK', '성시경', 1979, '서울');
-- PRIMARY KEY인 userID 기준으로 데이터가 정렬되어있다. (ABC순)
SELECT * FROM usertbl;

-- ALTER를 사용하여 usertbl에서 PRIMARY KEY 제약조건을 제거하고,
-- name 컬럼에 pk_name이라는 제약조건명으로 기본키를 설정하세요.
-- ALTER TABLE 키워드로 제약조건을 추가하거나 삭제할 수 있다
-- PRIMARY KEY 제약 조건 삭제
ALTER TABLE usertbl DROP PRIMARY KEY;
-- PRIMARY KEY 제약 조건을 name 컬럼에 추가
ALTER TABLE usertbl 
	ADD CONSTRAINT pk_name PRIMARY KEY(name);

-- usertbl의 내용을 출력하여, 새로운 클러스터형 인덱스를 확인하세요
-- PK가 변경되면서 클러스터형 인덱스도 함께 변경되어 정렬 순서가 name순으로 변경됨 (가나다순)
SELECT * FROM usertbl;


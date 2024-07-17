USE sqldb;

-- sqldb에서 usertbl 테이블에서 다음 내용들을 확인하세요
SELECT * FROM usertbl;

-- usertbl의 인덱스 목록 확인
SHOW INDEX FROM usertbl;

-- usertbl의 데이터 크기와 인덱스 크기 확인
SHOW TABLE STATUS LIKE 'usertbl';

-- usertbl의 addr 컬럼에 대해 idx_usertbl_addr 이름으로 인덱스를 만들고
-- 인덱스 목록을 확인하세요
CREATE INDEX idx_usertbl_addr
ON usertbl(addr);
SHOW INDEX FROM usertbl;

-- usertbl의 상태를 출력하여 인덱스의 내용이 만들어졌는지 확인하고,
-- 내용이 없다면 실제 적용되도록 한 후, 인덱스의 크기를 확인하세요.
SHOW TABLE STATUS LIKE 'usertbl';

-- 생성한 인덱스를 실제로 적용하기 위해서 ANALYZE로 테이블을 분석하고 처리해줘야함
ANALYZE TABLE usertbl;
-- Index_length가 0이었는데 분석후 제대로 나오는 걸 볼 수 있다.
SHOW TABLE STATUS LIKE 'usertbl';

-- 출생년도(birthyear)에 보조 인덱스 생성
-- 범수랑 시경이 생일이 둘다 1979이므로 중복값 때문에 인덱스 생성 에러 발생
CREATE UNIQUE INDEX idx_usertbl_birthyear
ON usertbl(birthyear);

-- 이름(name)에 보조 인덱스 생성
CREATE UNIQUE INDEX idx_usertbl_name
ON usertbl(name);
SHOW INDEX FROM usertbl;

-- 이름(name)에 보조 인덱스 삭제
DROP INDEX idx_usertbl_name ON usertbl;

-- name, birthyear 조합으로 인덱스 생성
-- 컬럼 조합시 ,로 이어서 넣어준다
-- 여러개의 컬럼으로 인덱스를 만들 경우 각 컬럼당 한 행이 추가된다
CREATE UNIQUE INDEX idx_usertbl_name_birthyear
ON usertbl(name, birthyear);

SHOW INDEX FROM usertbl;

-- 인덱스 삭제
-- DROP INDEX 또는 ALTER TABLE 구문으로 둘다 가능
DROP INDEX idx_usertbl_addr ON usertbl;
ALTER TABLE usertbl DROP INDEX idx_usertbl_addr;
DROP INDEX idx_usertbl_name_birthyear ON usertbl;
ALTER TABLE usertbl DROP INDEX idx_usertbl_name_birthyear;
